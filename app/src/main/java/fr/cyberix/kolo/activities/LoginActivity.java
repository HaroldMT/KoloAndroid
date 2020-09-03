package fr.cyberix.kolo.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.cyberix.kolo.R;
import fr.cyberix.kolo.helpers.ConfigHelper;
import fr.cyberix.kolo.helpers.KoloConstants;
import fr.cyberix.kolo.helpers.KoloHelper;
import fr.cyberix.kolo.helpers.SerializationHelper;
import fr.cyberix.kolo.helpers.ServiceHelper;
import fr.cyberix.kolo.helpers.SystemServiceHelper;
import fr.cyberix.kolo.interfaces.ServiceOperationInterface;
import fr.cyberix.kolo.model.KoloWsObject;
import fr.cyberix.kolo.model.TelephonyInfo;
import fr.cyberix.kolo.model.entities.Customer;
import fr.cyberix.kolo.model.entities.LoginAttempt;
import fr.cyberix.kolo.services.KolOthenticor;

public class LoginActivity extends AppCompatActivity {
	private static final String TAG = "LoginActivity";
	private static final int REQUEST_SIGNUP = 0;
	
	@BindView(R.id.progressBar_login)
	ProgressBar loginProgressBar;
	@BindView(R.id.txt_edit_login_phone)
	TextView inputPhone;
	@BindView(R.id.txt_edit_login_passphrase)
	TextInputEditText inputPassword;
	@BindView(R.id.login_button)
	Button btnLogin;
	@BindView(R.id.signUp_button)
	Button btnSignup;
	@BindView(R.id.forgot_button)
	Button btnForgot;
	LoginAttempt loginAttempt;
	UserSignInTask userSignInTask;
	Customer customer;
	
	//    LinearLayout login_view, ;
	LinearLayout signUp_view, login_creds;
	Handler handler = new Handler();
	Runnable runnable = new Runnable() {
		@Override
		public void run() {
			login_creds.setVisibility(View.VISIBLE);
			signUp_view.setVisibility(View.VISIBLE);
		}
	};
	ServiceOperationInterface<LoginAttempt, KoloWsObject<LoginAttempt>> tryToLogIn = new ServiceOperationInterface<LoginAttempt, KoloWsObject<LoginAttempt>>
			() {
		@Override
		public void onOperationSuccess(String message, KoloWsObject<LoginAttempt> data) {
			Log.d(TAG, "onOperationSuccess");
			LoginAttempt attempt = data.getDataObject();
			Date time = Calendar.getInstance().getTime();
			ConfigHelper.getAccountInfo().setLastAuthenticationTime(time);
			ConfigHelper.getAccountInfo().setAuthenticated(true);
			Customer customer = attempt.getCustomerLogin().getCustomer();
			if (customer != null)
				ConfigHelper.getAccountInfo().setCustomer(customer);
			else
				ConfigHelper.getAccountInfo().getCustomer().setIdCustomer(attempt.getIdCustomer());
			ConfigHelper.saveConfig();
			startActivity(new Intent(getBaseContext(), KoloHomeActivity.class));
			finish();
		}
		
		@Override
		public void onOperationFailure(String errorMessage) {
			Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
			Log.d(TAG, "onOperationFailure");
			btnLogin.setEnabled(true);
			btnSignup.setEnabled(true);
			btnForgot.setEnabled(true);
		}
		
		@Override
		public void onPreExecute() {
			btnLogin.setEnabled(false);
			btnSignup.setEnabled(false);
			btnForgot.setEnabled(false);
			loginProgressBar.setVisibility(View.VISIBLE);
			
			TelephonyInfo telInfo = SystemServiceHelper.getInfos();
			Location loc = SystemServiceHelper.getLocation();
			String pass = SerializationHelper.HashPassword(inputPassword.getText().toString());
			loginAttempt = new LoginAttempt();
			loginAttempt.setNumber(inputPhone.getText().toString());
			loginAttempt.setPwd(pass);
			loginAttempt.setIdCustomer(customer.getIdCustomer());
			loginAttempt.setSimOperator(telInfo.getSimOperatorName());
			loginAttempt.setSimSerialNumber(telInfo.getSimSerialNumber());
			loginAttempt.setSubscriberId(telInfo.getSubscriberId());
			loginAttempt.setDeviceId(telInfo.getDeviceId());
			if (loc != null) {
				loginAttempt.setLatitude(Double.valueOf(loc.getLatitude()));
				loginAttempt.setLongitude(Double.valueOf(loc.getLongitude()));
				loginAttempt.setAccuracy(Double.valueOf(loc.getAccuracy()));
			}
		}
		
		@Override
		public KoloWsObject<LoginAttempt> doInBackground(LoginAttempt parameter) {
			return ServiceHelper.doLogin(parameter);
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.AppTheme_Dialog);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		this.setFinishOnTouchOutside(false);
		ButterKnife.setDebug(true);
		ButterKnife.bind(this);
		setTitle("Kolo Login");
		loadConfig();
		loginProgressBar.setVisibility(View.INVISIBLE);
		btnLogin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				login();
			}
		});
		btnSignup.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// Start the Signup activity
				Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
				startActivityForResult(intent, REQUEST_SIGNUP);
				finish();
				overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
			}
		});
		
		login_creds = findViewById(R.id.login_creds);
		signUp_view = findViewById(R.id.signUp_view);
		
		handler.postDelayed(runnable, 2000);
	}
	
	public void loadConfig() {
		if (!ConfigHelper.getRegistered()) {
			AlertDialog alertDialog = new AlertDialog.Builder(LoginActivity.this).create();
			alertDialog.setTitle("No account found");
			alertDialog.setMessage("There is no registered account on this device. You should " +
					                       "sign up first");
			alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
			                      new DialogInterface.OnClickListener() {
				                      public void onClick(DialogInterface dialog, int which) {
					                      dialog.dismiss();
				                      }
			                      });
			alertDialog.show();
		} else {
			customer = ConfigHelper.getAccountInfo().getCustomer();
			if (customer != null) {
				inputPhone.setText(ConfigHelper.getAccountInfo().getMobileDevice().getLineNumber());
				inputPhone.setEnabled(false);
			} else {
				AlertDialog alertDialog = new AlertDialog.Builder(LoginActivity.this).create();
				alertDialog.setTitle("No account found");
				alertDialog.setMessage("There is no customer data on this device. You " +
						                       "should sign up first");
				alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
				                      new DialogInterface.OnClickListener() {
					                      public void onClick(DialogInterface dialog, int which) {
						                      dialog.dismiss();
					                      }
				                      });
				alertDialog.show();
			}
		}
	}
	
	public void login() {
		Log.d(TAG, "Login");
		if (!validate()) {
			onLoginFailed();
			return;
		}
		
		btnLogin.setEnabled(false);
		btnSignup.setEnabled(false);
		btnForgot.setEnabled(false);
		loginProgressBar.setVisibility(View.VISIBLE);
		
		TelephonyInfo telInfo = SystemServiceHelper.getInfos();
		Location loc = SystemServiceHelper.getLocation();
		String pass = SerializationHelper.HashPassword(inputPassword.getText().toString());
		loginAttempt = new LoginAttempt();
		loginAttempt.setNumber(inputPhone.getText().toString());
		loginAttempt.setPwd(pass);
		loginAttempt.setIdCustomer(customer.getIdCustomer());
		loginAttempt.setSimOperator(telInfo.getSimOperatorName());
		loginAttempt.setSimSerialNumber(telInfo.getSimSerialNumber());
		loginAttempt.setSubscriberId(telInfo.getSubscriberId());
		loginAttempt.setDeviceId(telInfo.getDeviceId());
		if (loc != null) {
			loginAttempt.setLatitude(Double.valueOf(loc.getLatitude()));
			loginAttempt.setLongitude(Double.valueOf(loc.getLongitude()));
			loginAttempt.setAccuracy(Double.valueOf(loc.getAccuracy()));
		}
		ServiceHelper.doInBackground(loginAttempt, tryToLogIn);
//		userSignInTask = new UserSignInTask();
//		userSignInTask.execute((Void) null);
	}
	
	public boolean validate() {
		boolean valid = true;
		
		String phone = inputPhone.getText().toString();
		String password = inputPassword.getText().toString();
		
		if (phone.isEmpty() || !Patterns.PHONE.matcher(phone).matches()) {
			inputPhone.setError("enter a valid phone number");
			valid = false;
		} else {
			inputPhone.setError(null);
		}
		
		if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
			inputPassword.setError("between 4 and 10 alphanumeric characters");
			valid = false;
		} else {
			inputPassword.setError(null);
		}
		
		return valid;
	}
	
	public void onLoginFailed() {
		Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
		btnLogin.setEnabled(true);
		btnSignup.setEnabled(true);
		btnForgot.setEnabled(true);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_SIGNUP) {
			if (resultCode == RESULT_OK) {
				btnLogin.setEnabled(true);
				ConfigHelper.saveConfig();
				startActivity(new Intent(getBaseContext(), fr.cyberix.kolo.activities.DashboardActivity.class));
				finish();
			}
		}
	}
	
	@Override
	public void onBackPressed() {
		moveTaskToBack(true);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		KoloHelper.setActivity(this);
	}
	
	public void onLoginSuccess(LoginAttempt attempt) {
//        btnLogin.setEnabled(true);
//        btnSignup.setEnabled(false);
		Date time = Calendar.getInstance().getTime();
		ConfigHelper.getAccountInfo().setLastAuthenticationTime(time);
		ConfigHelper.getAccountInfo().setAuthenticated(true);
		Customer customer = attempt.getCustomerLogin().getCustomer();
		if (customer != null)
			ConfigHelper.getAccountInfo().setCustomer(customer);
		else
			ConfigHelper.getAccountInfo().getCustomer().setIdCustomer(attempt.getIdCustomer());
		ConfigHelper.saveConfig();
//		startActivity(new Intent(getBaseContext(), DashboardActivity.class));
		startActivity(new Intent(getBaseContext(), KoloHomeActivity.class));
		finish();
	}
	
	private class UserSignInTask extends AsyncTask<Void, Void, LoginAttempt> {
		UserSignInTask() {
		
		}
		
		@Override
		protected LoginAttempt doInBackground(Void... params) {
			try {
				KolOthenticor service = ServiceHelper.getOthenticorService();
				String loginJson = SerializationHelper.toJson(loginAttempt, loginAttempt.getClass());
				String resultJson = service.DoLogin(loginJson);
				KoloWsObject<LoginAttempt> result = SerializationHelper.fromKoloJson(resultJson, new KoloWsObject<LoginAttempt>().getClass());
				loginAttempt = result.getDataObject();
			} catch (final Exception e) {
				
				return null;
			}
			return loginAttempt;
		}
		
		@Override
		protected void onPreExecute() {
		
		}
		
		@Override
		protected void onPostExecute(final LoginAttempt myLoginResult) {
			final Boolean success = (myLoginResult != null) && myLoginResult.getResultCode().equals
					(KoloConstants.REFSTATUS_RESULT_SUCCESS);
			new Handler().postDelayed(
					new Runnable() {
						public void run() {
							if (success) {
								//loginResult = myLoginResult;
								onLoginSuccess(myLoginResult);
							} else onLoginFailed();
							loginProgressBar.setVisibility(View.INVISIBLE);
						}
					}, 3000);
		}
		
		@Override
		protected void onCancelled() {
			userSignInTask = null;
			loginProgressBar.setVisibility(View.INVISIBLE);
		}
	}
}