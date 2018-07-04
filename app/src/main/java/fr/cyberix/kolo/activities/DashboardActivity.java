package fr.cyberix.kolo.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;

import java.math.BigDecimal;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cards.pay.paycardsrecognizer.sdk.Card;
import cards.pay.paycardsrecognizer.sdk.ScanCardIntent;
import fr.cyberix.kolo.R;
import fr.cyberix.kolo.fragments.HistoryFragment;
import fr.cyberix.kolo.fragments.NotificationsFragment;
import fr.cyberix.kolo.helpers.ConfigHelper;
import fr.cyberix.kolo.helpers.KoloHelper;
import io.card.payment.CardIOActivity;
import io.card.payment.CreditCard;

import static fr.cyberix.kolo.helpers.KoloConstants.CREDIT_CARD_SCAN_REQUEST_CODE1;
import static fr.cyberix.kolo.helpers.KoloConstants.CREDIT_CARD_SCAN_REQUEST_CODE2;
import static fr.cyberix.kolo.helpers.KoloConstants.PAYPAL_CLIENT_ID;
import static fr.cyberix.kolo.helpers.KoloConstants.PAYPAL_REQUEST_CODE2;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
	private static PayPalConfiguration config = new PayPalConfiguration()
			
			// Start with mock environment.  When ready, switch to sandbox (ENVIRONMENT_SANDBOX)
			// or live (ENVIRONMENT_PRODUCTION)
			.environment(PayPalConfiguration.ENVIRONMENT_NO_NETWORK)
			.clientId(PAYPAL_CLIENT_ID);
	String TAG;
	@BindView(R.id.card_view_kolo_retrait)
	CardView cardKoloRetrieve;
	@BindView(R.id.card_view_kolo_tranfer)
	CardView cardKoloTransfer;
	@BindView(R.id.card_view_kolo_payement)
	CardView cardKoloPayement;
	@BindView(R.id.drawer_naview)
	NavigationView mNavigationView;
	@BindView(R.id.drawer_nav)
	DrawerLayout mDrawerLayout;
	@BindView(R.id.txtDashFirstname)
	TextView _firstnameTextview;
	@BindView(R.id.txtDashMainBalance)
	TextView _mainbalanceTextview;
	@BindView(R.id.toolbar)
	Toolbar mToolbar;
	private CardView cardDashDrawer;
	private Menu mNavigationMenu;
	private ActionBarDrawerToggle mDrawerToggle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
		ButterKnife.setDebug(true);
		ButterKnife.bind(this);
		KoloHelper.setActivity(this);
		TAG = this.getLocalClassName();
		
		// Get the menu from navigation view
		mNavigationMenu = mNavigationView.getMenu();
		
		// Set a title for toolbar
		mToolbar.setTitle("Kolo");
		
		// Set the support action bar
		setSupportActionBar(mToolbar);
		
		// Initialize a drawer toggle instance
		mDrawerToggle = new ActionBarDrawerToggle(
				this,
				mDrawerLayout,
				mToolbar,
				R.string.drawer_open,
				R.string.drawer_close
		) {
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				// Do something
			}
			
			public void onDrawerClosed(View view) {
				super.onDrawerClosed(view);
				// Do something
			}
		};
		
		//Drawer animation and toggle
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
		mDrawerLayout.addDrawerListener(mDrawerToggle);
		mDrawerToggle.syncState();
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		//Navigation item click events handling
		setupDrawerContent(mNavigationView);
		
		someInitialization();
	}
	
	private void setupDrawerContent(NavigationView navigationView) {
		navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(@NonNull MenuItem item) {
				selectItemDrawer(item);
				return true;
			}
		});
	}
	
	private void someInitialization() {
		String accountBalanceString = String.valueOf(ConfigHelper.getAccountInfo().getCustomer().getBalance());
		String firstNameString = ConfigHelper.getAccountInfo().getPerson().getFirstname();
		_firstnameTextview.setText(firstNameString);
		_mainbalanceTextview.setText(accountBalanceString);
		
		View headerView = mNavigationView.getHeaderView(0);
		cardDashDrawer = headerView.findViewById(R.id.card_dash_drawheader);
		cardDashDrawer.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showProfile();
			}
		});
	}
	
	public void showProfile() {
//        Intent intent = new Intent(this, KoloUserProfilActivity.class);
//        startActivity(intent);
		KoloHelper.startActivity(KoloUserProfilActivity.class);
	}
	
	//Fragment implementaion through navigation drawer.
	public void selectItemDrawer(MenuItem menuItem) {
		Fragment myfragment = null;
		Class fragmentClass = null;
		switch (menuItem.getItemId()) {
			case R.id.drawer_notifications:
				fragmentClass = NotificationsFragment.class;
				break;
			case R.id.drawer_historic:
				fragmentClass = HistoryFragment.class;
				break;
			case R.id.drawer_dash:
				//fragmentClass = TestFragment.class;
				break;
			default:
				break;
		}
		try {
			myfragment = (Fragment) fragmentClass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.beginTransaction().replace(R.id.fra_lay_nav, myfragment).commit();
		menuItem.setChecked(true);
		setTitle(menuItem.getTitle());
		mDrawerLayout.closeDrawers();
	}
	
	@Override
	public void onDestroy() {
		stopService(new Intent(this, PayPalService.class));
		super.onDestroy();
	}
	
	@OnClick(R.id.card_view_kolo_retrait)
	public void onClickKoloRetrait(View view) {
	
	}
	
	@OnClick(R.id.card_view_kolo_eneo)
	public void onClickKoloEneo(View view) {
		KoloHelper.startActivity(KoloEneoBillPaymentActivity.class);
	}
	
	@OnClick(R.id.card_view_kolo_payement)
	public void onClickKoloPayement(View view) {
	
	}
	
	@OnClick(R.id.card_view_kolo_top_up)
	public void onClickKoloTopUp(View view) {
		KoloHelper.startActivity(KoloTopUpActivity.class);
	}
	
	@OnClick(R.id.card_view_kolo_tranfer)
	public void onClickKoloTransferP2p(View view) {
		KoloHelper.startActivity(KoloTransferP2pSendActivity.class);
	}
	
	@OnClick(R.id.card_view_kolo_visa_scan)
	public void onClickKoloVisaScan(View view) {
//	    scanVisaCardCardIo(view);
//	    scanVisaCardPayCard(view);
		paypal(view);
	}
	
	public void paypal(View v) {
		Intent serviceConfig = new Intent(this, PayPalService.class);
		serviceConfig.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
		startService(serviceConfig);
		
		PayPalPayment payment = new PayPalPayment(new BigDecimal("5.65"),
		                                          "USD", "My Awesome Item", PayPalPayment.PAYMENT_INTENT_SALE);
		
		Intent paymentConfig = new Intent(this, PaymentActivity.class);
		paymentConfig.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
		paymentConfig.putExtra(PaymentActivity.EXTRA_PAYMENT, payment);
		startActivityForResult(paymentConfig, PAYPAL_REQUEST_CODE2);
	}
	
	@OnClick(R.id.card_view_kolo_card_form)
	public void onClickKoloCreditCardForm(View view) {
		KoloHelper.startActivity(CreditCardInputActivity.class);
	}
	
	public void scanVisaCardPayCard(View v) {
		Intent intent = new ScanCardIntent.Builder(this).build();
		startActivityForResult(intent, CREDIT_CARD_SCAN_REQUEST_CODE2);
	}
	
	public void scanVisaCardCardIo(View v) {
		Intent scanIntent = new Intent(this, CardIOActivity.class);
		
		// customize these values to suit your needs.
		scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_EXPIRY, true); // default: false
		scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_CVV, false); // default: false
		scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_POSTAL_CODE, false); // default: false
		
		// CREDIT_CARD_SCAN_REQUEST_CODE1 is arbitrary and is only used within this activity.
		startActivityForResult(scanIntent, CREDIT_CARD_SCAN_REQUEST_CODE1);
	}
	
	@OnClick(R.id.card_view_kolo_mad)
	public void onClickKoloMad(View view) {
		KoloHelper.ShowSimpleAlert("Kolo Mad", "Formulaire d'envoi MAD à partir de KOLO");
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
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.drawermenu_02, menu);
		return true;
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		KoloHelper.setActivity(this);
	}
	
	//Drawer Buttom coding
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return (true);
		}
		
		switch (item.getItemId()) {
			case R.id.draw_menu_home:
				if (!KoloHelper.getMyActivity().getClass().equals(DashboardActivity.class)) {
					startActivity(new Intent(DashboardActivity.this, DashboardActivity.class));
				}
				break;
			case R.id.drawMenuProfilloutline:
				showProfile();
				break;
			default:
				break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public boolean onNavigationItemSelected(@NonNull MenuItem item) {
		selectItemDrawer(item);
		return true;
	}
	

}