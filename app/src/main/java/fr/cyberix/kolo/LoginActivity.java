package fr.cyberix.kolo;

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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.cyberix.kolo.helpers.ConfigHelper;
import fr.cyberix.kolo.helpers.KoloConstants;
import fr.cyberix.kolo.helpers.KoloHelper;
import fr.cyberix.kolo.helpers.SerializationHelper;
import fr.cyberix.kolo.helpers.SystemServiceHelper;
import fr.cyberix.kolo.model.TelephonyInfo;
import fr.cyberix.kolo.model.entities.Customer;
import fr.cyberix.kolo.model.entities.LoginAttempt;
import fr.cyberix.kolo.model.entities.RefResult;
import fr.cyberix.kolo.services.KolOthenticor;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

    @BindView(R.id.progressBar_login)
    ProgressBar loginProgressBar;
    @BindView(R.id.txt_edit_login_phone)
    EditText inputPhone;
    @BindView(R.id.txt_input_login_passphrase)
    TextInputEditText inputPassword;
    @BindView(R.id.login_button)
    Button btnLogin;
    @BindView(R.id.signUp_button)
    Button btnSignup;
    LoginAttempt loginAttempt = null;
    UserSignInTask userSignInTask = null;
    Customer customer = null;
    private RefResult loginResult = null;

    RelativeLayout login_view, login_creds;
    LinearLayout signUp_view;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            login_creds.setVisibility(View.VISIBLE);
            signUp_view.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.setDebug(true);
        ButterKnife.bind(this);
        KoloHelper.setActivity(this);

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

        AlertDialog alertDialog = new AlertDialog.Builder(LoginActivity.this).create();
        alertDialog.setTitle("Alert test");
        alertDialog.setMessage("Just want to make sure that i can show this alert");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();

        login_creds = findViewById(R.id.login_creds);
        signUp_view = findViewById(R.id.signUp_view);

        // 2000 is timeout for splash

        handler.postDelayed(runnable, 2000);

        Button nbutton = findViewById(R.id.login_button);
        nbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, KoloMainActivity.class));
            }
        });

        Button mbutton = findViewById(R.id.signUp_button);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });

        Button fbutton = findViewById(R.id.forgotten_pass_button);
        fbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
            }
        });

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
        userSignInTask = new UserSignInTask();
        userSignInTask.execute((Void) null);
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
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {
                btnLogin.setEnabled(true);
                ConfigHelper.saveConfig();
                startActivity(new Intent(getBaseContext(), DashboardActivity.class));
                finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        btnLogin.setEnabled(true);
        ConfigHelper.getAccountInfo().setLastAuthenticationTime(Calendar.getInstance().getTime());
        ConfigHelper.getAccountInfo().setAuthenticated(true);
        ConfigHelper.saveConfig();
        startActivity(new Intent(getBaseContext(), DashboardActivity.class));
        finish();
    }

    private class UserSignInTask extends AsyncTask<Void, Void, RefResult> {
        UserSignInTask() {
        }

        @Override
        protected RefResult doInBackground(Void... params) {
            LoginAttempt loginResult;
            try {
                String loginResultString = new KolOthenticor().DoLogin(SerializationHelper.toJson(loginAttempt, loginAttempt.getClass()));
                loginResult = SerializationHelper.fromJson(loginResultString, LoginAttempt.class);
            } catch (Exception e) {
                return null;
            }
            return loginResult.getRefResult();
        }

        @Override
        protected void onPreExecute() {
            btnLogin.setEnabled(false);

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
        protected void onPostExecute(final RefResult myLoginResult) {
            final Boolean success = (myLoginResult != null) && myLoginResult.getResultCode().equals
                    (KoloConstants.REFSTATUS_RESULT_SUCCESS);
            new Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            if (success) {
                                loginResult = myLoginResult;
                                onLoginSuccess();
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
