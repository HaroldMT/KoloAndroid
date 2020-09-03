package fr.cyberix.kolo.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;

import java.math.BigDecimal;

import cards.pay.paycardsrecognizer.sdk.Card;
import cards.pay.paycardsrecognizer.sdk.ScanCardIntent;
import fr.cyberix.kolo.R;
import fr.cyberix.kolo.fragments.AccountFragment;
import fr.cyberix.kolo.fragments.HistoryFragment;
import fr.cyberix.kolo.fragments.HomeFragment;
import fr.cyberix.kolo.fragments.NotificationsFragment;
import fr.cyberix.kolo.fragments.OperationsFragment;
import fr.cyberix.kolo.fragments.SettingsFragment;
import fr.cyberix.kolo.helpers.ConfigHelper;
import fr.cyberix.kolo.helpers.KoloHelper;
import fr.cyberix.kolo.model.AccountInfo;
import fr.cyberix.kolo.model.entities.Customer;
import fr.cyberix.kolo.other.CircleTransform;
import io.card.payment.CardIOActivity;
import io.card.payment.CreditCard;

import static fr.cyberix.kolo.helpers.KoloConstants.CREDIT_CARD_SCAN_REQUEST_CODE1;
import static fr.cyberix.kolo.helpers.KoloConstants.CREDIT_CARD_SCAN_REQUEST_CODE2;
import static fr.cyberix.kolo.helpers.KoloConstants.PAYPAL_CLIENT_ID;
import static fr.cyberix.kolo.helpers.KoloConstants.PAYPAL_REQUEST_CODE2;

public class KoloHomeActivity extends AppCompatActivity
		implements NavigationView.OnNavigationItemSelectedListener, HomeFragment.OnFragmentInteractionListener, AccountFragment
		.OnFragmentInteractionListener, HistoryFragment.OnFragmentInteractionListener, OperationsFragment
				           .OnFragmentInteractionListener, NotificationsFragment.OnFragmentInteractionListener {
	// urls to load navigation header background image
	// and profile image
	private static final String urlNavHeaderBg = "https://api.androidhive.info/images/nav-menu-header-bg.jpg";
	private static final String urlProfileImg = "https://lh3.googleusercontent.com/eCtE_G34M9ygdkmOpYvCag1vBARCmZwnVS6rS5t4JLzJ6QgQSBquM0nuTsCpLhYbKljoyS-txg";
	// tags used to attach the fragments
	private static final String TAG_HOME = "home";
	private static final String TAG_ACCOUNT = "account";
	private static final String TAG_OPERATIONS = "operations";
	private static final String TAG_HISTORY = "history";
	private static final String TAG_NOTIFICATIONS = "notifications";
	private static final String TAG_SETTINGS = "settings";
	// index to identify current nav menu item
	public static int navItemIndex = 0;
	public static String CURRENT_TAG = TAG_HOME;
	private static PayPalConfiguration payPalConfiguration = new PayPalConfiguration()
			
			// Start with mock environment.  When ready, switch to sandbox (ENVIRONMENT_SANDBOX)
			// or live (ENVIRONMENT_PRODUCTION)
			.environment(PayPalConfiguration.ENVIRONMENT_NO_NETWORK)
			.clientId(PAYPAL_CLIENT_ID);
	String TAG;
	private NavigationView navigationView;
	private DrawerLayout drawer;
	private View navHeader;
	private ImageView imgNavHeaderBg, imgProfile;
	private TextView txtName, txtWebsite;
	private Toolbar toolbar;
	private FloatingActionButton fab;
	private ActionBarDrawerToggle toggle;
	// toolbar titles respected to selected nav menu item
	private String[] activityTitles;
	// flag to load home fragment when user presses back key
	private boolean shouldLoadHomeFragOnBackPress = true;
	private Handler mHandler;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kolo_home);
		KoloHelper.setActivity(this);
		TAG = this.getLocalClassName();

		toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		if (getSupportActionBar() != null) {
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		}
		
		mHandler = new Handler();

		drawer = findViewById(R.id.drawer_layout);
		navigationView = findViewById(R.id.nav_view);
		fab = findViewById(R.id.fab);

		// Navigation view header
		navHeader = navigationView.getHeaderView(0);
		txtName = navHeader.findViewById(R.id.name);
		txtWebsite = navHeader.findViewById(R.id.website);
		imgNavHeaderBg = navHeader.findViewById(R.id.img_header_bg);
		imgProfile = navHeader.findViewById(R.id.img_profile);

		// load toolbar titles from string resources
		activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);

		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
				        .setAction("Action", null).show();
			}
		});

		// load nav menu header data
		loadNavHeader();
		
		// initializing navigation menu
		setUpNavigationView();
		
		if (savedInstanceState == null) {
			navItemIndex = 0;
			CURRENT_TAG = TAG_HOME;
			loadHomeFragment();
		}
		
		ConfigHelper.getAccountInfo().getCustomer().setEneoContractNo("200050721");
		AccountInfo accountInfo = ConfigHelper.getAccountInfo();
		Customer customer = accountInfo.getCustomer();
		customer.setEneoContractNo("200050721");
	}
	
	private void loadNavHeader() {
		// name, website
		txtName.setText("Ravi Tamada");
		txtWebsite.setText("www.androidhive.info");
		
		// loading header background image
		Glide.with(this).load(urlNavHeaderBg)
		     .crossFade()
		     .diskCacheStrategy(DiskCacheStrategy.ALL)
		     .into(imgNavHeaderBg);
		
		// Loading profile image
		Glide.with(this).load(urlProfileImg)
		     .crossFade()
		     .thumbnail(0.5f)
		     .bitmapTransform(new CircleTransform(this))
		     .diskCacheStrategy(DiskCacheStrategy.ALL)
		     .into(imgProfile);
		
		// showing dot next to notifications label
		navigationView.getMenu().getItem(3).setActionView(R.layout.menu_dot);
	}
	
	private void setUpNavigationView() {
		//Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
		navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
			
			// This method will trigger on item Click of navigation menu
			@Override
			public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
				
				//Check to see which item was being clicked and perform appropriate action
				switch (menuItem.getItemId()) {
					//Replacing the main content with ContentFragment Which is our Inbox View;
					case R.id.nav_home:
						navItemIndex = 0;
						CURRENT_TAG = TAG_HOME;
						break;
					case R.id.nav_account:
						navItemIndex = 1;
						CURRENT_TAG = TAG_ACCOUNT;
						break;
					case R.id.nav_operation:
						navItemIndex = 2;
						CURRENT_TAG = TAG_OPERATIONS;
						break;
					case R.id.nav_history:
						navItemIndex = 3;
						CURRENT_TAG = TAG_HISTORY;
						break;
					case R.id.nav_notifications:
						navItemIndex = 4;
						CURRENT_TAG = TAG_NOTIFICATIONS;
						break;
					case R.id.nav_settings:
//						navItemIndex = 5;
//						CURRENT_TAG = TAG_SETTINGS;
						KoloHelper.startActivity(SettingsActivity.class);
						drawer.closeDrawers();
						break;
					case R.id.nav_about_us:
						// launch new intent instead of loading fragment
//						startActivity(new Intent(KoloHomeActivity.this, AboutUsActivity.class));
						KoloHelper.startActivity(AboutUsActivity.class);
						drawer.closeDrawers();
						return true;
					case R.id.nav_privacy_policy:
						// launch new intent instead of loading fragment
//						startActivity(new Intent(KoloHomeActivity.this, PrivacyPolicyActivity.class));
						KoloHelper.startActivity(PrivacyPolicyActivity.class);
						drawer.closeDrawers();
						return true;
					default:
						navItemIndex = 0;
				}
				
				//Checking if the item is in checked state or not, if not make it in checked state
				if (menuItem.isChecked()) {
					menuItem.setChecked(false);
				} else {
					menuItem.setChecked(true);
				}
				menuItem.setChecked(true);
				loadHomeFragment();
				return true;
			}
		});
		
		ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {
			
			@Override
			public void onDrawerOpened(View drawerView) {
				// Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
				super.onDrawerOpened(drawerView);
			}
			
			@Override
			public void onDrawerClosed(View drawerView) {
				// Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
				super.onDrawerClosed(drawerView);
			}
		};
		
		//Setting the actionbarToggle to drawer layout
		drawer.addDrawerListener(actionBarDrawerToggle);
		
		//calling sync state is necessary or else your hamburger icon wont show up
		actionBarDrawerToggle.syncState();
	}
	
	@Override
	public void onFragmentInteraction(Uri uri) {
	
	}
	
	public void showUserQrAccount(View view) {
		KoloHelper.startActivity(KoloUserQRCodeActivity.class);
	}
	
	public void showUserAccount(View view) {
		showAccountFragment();
	}
	
	public void showAccountFragment() {
		navItemIndex = 1;
		CURRENT_TAG = TAG_ACCOUNT;
		loadHomeFragment();
	}
	
	@Override
	public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
		super.onCreate(savedInstanceState, persistentState);
		KoloHelper.setActivity(this);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		
		// show menu only when home fragment is selected
		if (navItemIndex == 0) {
			getMenuInflater().inflate(R.menu.main, menu);
		}
		
		// when fragment is notifications, load the menu created for notifications
		if (navItemIndex == 3) {
			getMenuInflater().inflate(R.menu.notifications, menu);
		}
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		
		//noinspection SimplifiableIfStatement
		if (id == R.id.action_logout) {
			Toast.makeText(getApplicationContext(), "Logout user!", Toast.LENGTH_LONG).show();
			return true;
		}
		
		// user is in notifications fragment
		// and selected 'Mark all as Read'
		if (id == R.id.action_mark_all_read) {
			Toast.makeText(getApplicationContext(), "All notifications marked as read!", Toast.LENGTH_LONG).show();
		}
		
		// user is in notifications fragment
		// and selected 'Clear All'
		if (id == R.id.action_clear_notifications) {
			Toast.makeText(getApplicationContext(), "Clear all notifications!", Toast.LENGTH_LONG).show();
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if (requestCode == CREDIT_CARD_SCAN_REQUEST_CODE1) {
			onScanVisaCardCardIoResult(requestCode, resultCode, data);
		} else if (requestCode == CREDIT_CARD_SCAN_REQUEST_CODE2) {
			onScanVisaCardPayCardResult(requestCode, resultCode, data);
		} else if (requestCode == PAYPAL_REQUEST_CODE2) {
			onPaypalResult(requestCode, resultCode, data);
		}
		// else handle other activity results
	}
	
	@Override
	public void onBackPressed() {
		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawers();
			return;
		}
		
		// This code loads home fragment when back key is pressed
		// when user is in other fragment than home
		if (shouldLoadHomeFragOnBackPress) {
			// checking if user is on other navigation menu
			// rather than home
			if (navItemIndex != 0) {
				navItemIndex = 0;
				CURRENT_TAG = TAG_HOME;
				loadHomeFragment();
				return;
			}
		}
		
		super.onBackPressed();
	}
	
	private void loadHomeFragment() {
		// selecting appropriate nav menu item
		selectNavMenu();
		
		// set toolbar title
		setToolbarTitle();
		
		// if user select the current navigation menu again, don't do anything
		// just close the navigation drawer
		if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
			drawer.closeDrawers();
			
			// show or hide the fab button
			toggleFab();
			return;
		}
		
		// Sometimes, when fragment has huge data, screen seems hanging
		// when switching between navigation menus
		// So using runnable, the fragment is loaded with cross fade effect
		// This effect can be seen in GMail app
		Runnable mPendingRunnable = new Runnable() {
			@Override
			public void run() {
				// update the main content by replacing fragments
				Fragment fragment = getHomeFragment();
				FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
				fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
				                                        android.R.anim.fade_out);
				fragmentTransaction.replace(R.id.main_kolo_frame, fragment, CURRENT_TAG);
				fragmentTransaction.commitAllowingStateLoss();
			}
		};
		
		// If mPendingRunnable is not null, then add to the message queue
		if (mPendingRunnable != null) {
			mHandler.post(mPendingRunnable);
		}
		
		// show or hide the fab button
		toggleFab();
		
		//Closing drawer on item click
		drawer.closeDrawers();
		
		// refresh toolbar menu
		invalidateOptionsMenu();
	}
	
	private void selectNavMenu() {
		navigationView.getMenu().getItem(navItemIndex).setChecked(true);
	}
	
	@Override
	public boolean onNavigationItemSelected(@NonNull MenuItem item) {
		return false;
	}
	
	private void setToolbarTitle() {
		getSupportActionBar().setTitle(activityTitles[navItemIndex]);
	}
	
	// show or hide the fab
	private void toggleFab() {
		if (navItemIndex == 0)
			fab.show();
		else
			fab.hide();
	}
	
	private Fragment getHomeFragment() {
		switch (navItemIndex) {
			case 0:
				// home
				return new HomeFragment();
			case 1:
				// account
				return new AccountFragment();
			case 2:
				// operations
				return new OperationsFragment();
			case 3:
				// history
				return new HistoryFragment();
			case 4:
				// notifications fragment
				return new NotificationsFragment();
			
			case 5:
				// settings fragment
				return new SettingsFragment();
			default:
				return new HomeFragment();
		}
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		KoloHelper.setActivity(this);
	}
	
	public void onScanVisaCardCardIoResult(int requestCode, int resultCode, Intent data) {
		String resultDisplayStr;
		if (data != null && data.hasExtra(CardIOActivity.EXTRA_SCAN_RESULT)) {
			CreditCard scanResult = data.getParcelableExtra(CardIOActivity.EXTRA_SCAN_RESULT);
			
			// Never log a raw card number. Avoid displaying it, but if necessary use getFormattedCardNumber()
			resultDisplayStr = "Card Number: " + scanResult.getRedactedCardNumber() + "\n";
			
			// Do something with the raw number, e.g.:
			// myService.setCardNumber( scanResult.cardNumber );
			
			if (scanResult.isExpiryValid()) {
				resultDisplayStr += "Expiration Date: " + scanResult.expiryMonth + "/" + scanResult.expiryYear + "\n";
			}
			
			if (scanResult.cvv != null) {
				// Never log or display a CVV
				resultDisplayStr += "CVV has " + scanResult.cvv.length() + " digits.\n";
			}
			
			if (scanResult.postalCode != null) {
				resultDisplayStr += "Postal Code: " + scanResult.postalCode + "\n";
			}
		} else {
			resultDisplayStr = "Scan was canceled.";
		}
		// do something with resultDisplayStr, maybe display it in a textView
		// resultTextView.setText(resultDisplayStr);
		KoloHelper.ShowSimpleAlert("Visa Scan Result", resultDisplayStr);
	}
	
	public void onScanVisaCardPayCardResult(int requestCode, int resultCode, Intent data) {
		String resultDisplayStr;
		if (resultCode == Activity.RESULT_OK) {
			Card card = data.getParcelableExtra(ScanCardIntent.RESULT_PAYCARDS_CARD);
			String cardData = "Card number: " + card.getCardNumberRedacted() + "\n"
					+ "Card holder: " + card.getCardHolderName() + "\n"
					+ "Card expiration date: " + card.getExpirationDate();
			resultDisplayStr = "Card info: " + cardData;
		} else if (resultCode == Activity.RESULT_CANCELED) {
			resultDisplayStr = "Scan canceled";
		} else {
			resultDisplayStr = "Scan failed";
		}
		Log.i(TAG, resultDisplayStr);
		KoloHelper.ShowSimpleAlert("Visa Scan Result", resultDisplayStr);
	}
	
	public void onPaypalResult(int requestCode, int resultCode, Intent data) {
		String resultDisplayStr = "";
		if (resultCode == Activity.RESULT_OK) {
			PaymentConfirmation confirm = data.getParcelableExtra(
					PaymentActivity.EXTRA_RESULT_CONFIRMATION);
			if (confirm != null) {
				try {
					resultDisplayStr = confirm.toJSONObject().toString(4);
					// TODO: send 'confirm' to your server for verification
				} catch (JSONException e) {
					resultDisplayStr = "no confirmation data: ";
					Log.e(TAG, "no confirmation data: ", e);
				}
			}
		} else if (resultCode == Activity.RESULT_CANCELED) {
			resultDisplayStr = "The user canceled.";
		} else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
			resultDisplayStr = "Invalid payment / config set";
		}
		KoloHelper.ShowSimpleAlert("PayPal", resultDisplayStr);
		Log.i(TAG, resultDisplayStr);
	}
	
	public void onKoloReceiveP2p(View view) {
		KoloHelper.startActivity(KoloTransferP2pReceiveActivity.class);
	}
	
	public void onKoloSendP2p(View view) {
		KoloHelper.startActivity(KoloTransferP2pSendActivity.class);
	}
	
	public void onKoloPayEneo(View view) {
		KoloHelper.startActivity(KoloEneoBillPaymentActivity.class);
	}
	
	public void onKoloCreditCard(View view) {
		KoloHelper.startActivity(CreditCardInputActivity.class);
	}
	
	public void onKoloTopUp(View view) {
		KoloHelper.startActivity(KoloTopUpActivity.class);
	}
	
	public void onKoloPaypal(View view) {
		Intent serviceConfig = new Intent(this, PayPalService.class);
		serviceConfig.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, payPalConfiguration);
		startService(serviceConfig);
		
		PayPalPayment payment = new PayPalPayment(new BigDecimal("5.65"),
		                                          "USD", "My Awesome Item", PayPalPayment.PAYMENT_INTENT_SALE);
		
		Intent paymentConfig = new Intent(this, PaymentActivity.class);
		paymentConfig.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, payPalConfiguration);
		paymentConfig.putExtra(PaymentActivity.EXTRA_PAYMENT, payment);
		startActivityForResult(paymentConfig, PAYPAL_REQUEST_CODE2);
	}
	
	public void onKoloMad(View view) {
		KoloHelper.startActivity(KoloMadActivity.class);
	}
	
	
}
