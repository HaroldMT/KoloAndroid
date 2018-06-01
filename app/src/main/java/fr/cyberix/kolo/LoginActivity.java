package fr.cyberix.kolo;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.cyberix.kolo.helpers.KoloHelper;
import fr.cyberix.kolo.model.entities.Registration;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "SignupActivity";
    @BindView(R.id.btn_dob)
    Button _dobButton;
    @BindView(R.id.btnRegister)
    Button _signupButton;
    @BindView(R.id.link_login)
    TextView _loginLink;
    @BindView(R.id.txtSignUpDob)
    TextView _dobText;
    @BindView(R.id.txtSignUpEmail)
    EditText _emailText;
    @BindView(R.id.txtSignUpFirstname)
    EditText _firstNameText;
    @BindView(R.id.txtSignUpLastName)
    EditText _lastnameText;
    @BindView(R.id.txtSignUpTel)
    EditText _mobileText;
    @BindView(R.id.txtSignUpPwd)
    EditText _pwdText;
    @BindView(R.id.signup_progressBar)
    ProgressBar signup_progressBar;

    UserSignUpTask userSignUpTask = null;
    String dob;
    String email;
    String firstname;
    String lastname;
    String mobile;
    String pwd;
    private Calendar calendar;
    private int myYear, myMonth, myDay;
    private Registration registration;
    private Date _dobValue;
    DatePickerDialog.OnDateSetListener datePickerDialog = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
            myYear = year;
            myMonth = monthOfYear + 1;
            myDay = dayOfMonth;
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, monthOfYear);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            showDate();
        }
    };

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
        calendar = Calendar.getInstance();
        registration = ConfigHelper.getAccountInfo().getRegistration();
        if (registration != null) {
            _dobValue = registration.getDob();
            _emailText.setText(registration.getEmail());
            _firstNameText.setText(registration.getFirstName());
            _lastnameText.setText(registration.getLastName());
            _mobileText.setText(registration.getPhoneNumber());
            if (_dobValue != null) {
                myDay = _dobValue.getDay() + 1;
                myMonth = _dobValue.getMonth() + 1;
                myYear = _dobValue.getYear() + 1900;
            } else {
                Date now = Calendar.getInstance().getTime();
                myDay = now.getDay() + 1;
                myMonth = now.getMonth() + 1;
                myYear = now.getYear() + 1900;
            }
            showDate();
        }
    }

    private void showDate() {
        calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, myYear);
        calendar.set(Calendar.MONTH, myMonth - 1);
        calendar.set(Calendar.DAY_OF_MONTH, myDay);
        _dobValue = calendar.getTime();
        _dobButton.setText(ForeasHelper.getDateFormat().format(_dobValue));
    }

    public void signup() {
        Log.d(TAG, "Signup");
        if (!validate()) {
            onSignupFailed();
            return;
        }
        userSignUpTask = new UserSignUpTask(registration);
        userSignUpTask.execute((Void) null);
    }

    public boolean validate() {
        boolean valid = true;

        dob = _dobText.getText().toString();
        email = _emailText.getText().toString();
        firstname = _firstNameText.getText().toString();
        lastname = _lastnameText.getText().toString();
        mobile = _mobileText.getText().toString();
        pwd = _pwdText.getText().toString();

        if (!ValidationHelper.isValidEmail(email)) {
            _emailText.setError("Invalid email");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (!ValidationHelper.isValidDateOfBirth(dob)) {
            _dobText.setError("Invalid date of birth");
            valid = false;
        } else {
            _dobText.setError(null);
        }

        if (!ValidationHelper.isValidName(firstname)) {
            _firstNameText.setError("Invalid firstame");
            valid = false;
        } else {
            _firstNameText.setError(null);
        }

        if (!ValidationHelper.isValidName(lastname)) {
            _lastnameText.setError("Invalid lastname");
            valid = false;
        } else {
            _lastnameText.setError(null);
        }

        if (!ValidationHelper.isValidPassword(pwd)) {
            _pwdText.setError("Invalid password");
            valid = false;
        } else {
            _pwdText.setError(null);
        }

        if (!ValidationHelper.isValidPhone(mobile)) {
            _mobileText.setError("Invalid date of birth");
            valid = false;
        } else {
            _mobileText.setError(null);
        }

        return valid;
    }

    public void onSignupFailed() {
        if (userSignUpTask.mRegistration != null && userSignUpTask.mRegistration
                .getIdRegistration() == -10) {
            Toast.makeText(getBaseContext(), "This number is already register; is it is your " +
                    "number, try to sign in", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getBaseContext(), "Registration failed", Toast.LENGTH_LONG).show();
        }
        _signupButton.setEnabled(true);
    }

    public void onSignupSuccess() {
        _signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        ConfigHelper.saveConfig();
        startActivity(new Intent(getBaseContext(), ConfirmRegistrationActivity.class));
        finish();
    }

    private class UserSignUpTask extends AsyncTask<Void, Void, Registration> {

        private Registration mRegistration;

        UserSignUpTask(Registration registration) {
            mRegistration = registration;
        }

        @Override
        protected Registration doInBackground(Void... params) {
            try {
                mRegistration = ServiceHelper.signUp(mRegistration);
            } catch (Exception e) {
                return null;
            }
            return mRegistration;
        }

        @Override
        protected void onPreExecute() {
            _signupButton.setEnabled(false);

            signup_progressBar.setVisibility(View.VISIBLE);

            TelephonyInfo telInfo = SystemServiceHelper.getInfos();
            String pass = SerializationHelper.HashPassword(_pwdText.getText().toString());
            mRegistration.setDob(_dobValue);
            mRegistration.setEmail(_emailText.getText().toString());
            mRegistration.setFirstName(_firstNameText.getText().toString());
            mRegistration.setLastName(_lastnameText.getText().toString());
            mRegistration.setPhoneNumber(_mobileText.getText().toString());
            mRegistration.setPwd(pass);
            mRegistration.setOperatorDeviceSim(telInfo.getSimOperatorName());
            mRegistration.setSimSerialNumber(telInfo.getSimSerialNumber());
            mRegistration.setSimSubscriberId(telInfo.getSubscriberId());
            mRegistration.setDeviceId(telInfo.getDeviceId());
            mRegistration.setRegistrationStatusCode("");
            ConfigHelper.getAccountInfo().setRegistration(registration);
            ConfigHelper.saveConfig();
        }

        @Override
        protected void onPostExecute(final Registration myRegistration) {
            mRegistration = myRegistration;
            final Boolean success = myRegistration != null && myRegistration.isRegistering();
            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            if (success) {
                                registration = myRegistration;
                                mRegistration = myRegistration;
                                ConfigHelper.getAccountInfo().getRegistration().setRegistrationStatusCode(Registration.STATUS_NEEDCONFIRM);
                                ConfigHelper.getAccountInfo().getRegistration().setIdRegistration(myRegistration.getIdRegistration());
                                onSignupSuccess();
                            } else onSignupFailed();
                            signup_progressBar.setVisibility(View.GONE);
                        }
                    }, 3000);
        }

        @Override
        protected void onCancelled() {
            userSignUpTask = null;
            signup_progressBar.setVisibility(View.GONE);
        }
    }
}
