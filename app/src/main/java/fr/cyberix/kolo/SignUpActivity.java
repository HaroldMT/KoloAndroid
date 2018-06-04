package fr.cyberix.kolo;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.cyberix.kolo.helpers.ConfigHelper;
import fr.cyberix.kolo.helpers.KoloConstants;
import fr.cyberix.kolo.helpers.KoloHelper;
import fr.cyberix.kolo.helpers.SerializationHelper;
import fr.cyberix.kolo.helpers.SystemServiceHelper;
import fr.cyberix.kolo.helpers.ValidationHelper;
import fr.cyberix.kolo.model.AccountInfo;
import fr.cyberix.kolo.model.TelephonyInfo;
import fr.cyberix.kolo.model.entities.MobileDevice;
import fr.cyberix.kolo.model.entities.Registration;
import fr.cyberix.kolo.services.KolOthenticor;
import fr.cyberix.kolo.services.MobileService;

public class SignUpActivity extends AppCompatActivity
        implements DatePickerDialog.OnDateSetListener {

    private static final String TAG = "SignupActivity";
    UserSignUpTask userSignUpTask = null;
    String dob;
    String email;
    String firstname;
    String lastname;
    String mobile;
    String pwd;
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
    private Calendar calendar;
    private int myYear, myMonth, myDay;
    private Registration registration;
    @BindView(R.id.progressBar_signup)
    ProgressBar signup_progressBar;
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
    private AccountInfo accountInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.setDebug(true);
        ButterKnife.bind(this);
        KoloHelper.setActivity(this);
        loadConfig();
        View.OnClickListener onDateClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                new DatePickerDialog(SignUpActivity.this, datePickerDialog, now.get(Calendar
                        .YEAR), now.get
                        (Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH)).show();
            }
        };
        _dobButton.setOnClickListener(onDateClickListener);
        _dobText.setOnClickListener(onDateClickListener);
        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) signup();
            }
        });
        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                Intent intent = new Intent(getApplicationContext(), SignUpConfirmationActivity.class);
                startActivity(intent);
                finish();
//                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }
    /**
     * This callback method, call DatePickerFragment class,
     * DatePickerFragment class returns calendar view.
     * @param view
     */
    public void datePicker(View view){

        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getSupportFragmentManager(),"datePicker");
    }

    /**
     * To set date on TextView
     * @param calendar
     */
    private void setDate(final Calendar calendar) {
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);

        ((TextView) findViewById(R.id.txtSignUpDob))
                .setText(dateFormat.format(calendar.getTime()));

    }

    /**
     * To receive a callback when the user sets the date.
     * @param view
     * @param year
     * @param month
     * @param day
     */
    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        Calendar cal = new GregorianCalendar(year, month, day);
        setDate(cal);
        // Do something with the date chosen by the user
    }

    /**
     * Create a DatePickerFragment class that extends DialogFragment.
     * Define the onCreateDialog() method to return an instance of DatePickerDialog
     */
    public static class DatePickerFragment extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);


            return new DatePickerDialog(getActivity(),
                    (DatePickerDialog.OnDateSetListener)
                            getActivity(), year, month, day);
        }

    }

    public void loadConfig() {
        calendar = Calendar.getInstance();
        accountInfo = ConfigHelper.getAccountInfo();
        registration = ConfigHelper.getAccountInfo().getRegistration();
        if (registration != null) {
            //_dobValue = new Date(registration.getDob());
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

    public void signup() {
        Log.d(TAG, "Signup");
        if (!validate()) {
            onSignupFailed();
            return;
        }
        userSignUpTask = new UserSignUpTask(registration, accountInfo);
        userSignUpTask.execute((Void) null);
    }

    private void showDate() {
        calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, myYear);
        calendar.set(Calendar.MONTH, myMonth - 1);
        calendar.set(Calendar.DAY_OF_MONTH, myDay);
        _dobValue = calendar.getTime();
        _dobButton.setText(KoloHelper.getDateFormat().format(_dobValue));
    }

    public void onSignupFailed() {
        if (userSignUpTask.mRegistration != null && userSignUpTask.mRegistration
                .getIdRegistration() == -10) {
            Toast.makeText(getBaseContext(), "This number is already register; it is your " +
                    "number, try to sign in", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getBaseContext(), "Registration failed", Toast.LENGTH_LONG).show();
        }
        _signupButton.setEnabled(true);
    }

    public void onSignupSuccess() {
        _signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        ConfigHelper.getAccountInfo().setRegistred(false);
        ConfigHelper.getAccountInfo().setRegistring(true);
        ConfigHelper.saveConfig();
        startActivity(new Intent(getBaseContext(), SignUpConfirmationActivity.class));
        finish();
    }

    private class UserSignUpTask extends AsyncTask<Void, Void, Registration> {

        private Registration mRegistration;
        private AccountInfo mAccountInfo;
        private MobileDevice mMobileDevice;

        UserSignUpTask(Registration registration, AccountInfo accountInfo) {
            mRegistration = registration;
            mAccountInfo = accountInfo;
        }

        UserSignUpTask(Registration registration, AccountInfo accountInfo, MobileDevice mobileDevice) {
            mRegistration = registration;
            mAccountInfo = accountInfo;
            mMobileDevice = mobileDevice;
        }

        @Override
        protected Registration doInBackground(Void... params) {
            try {
                //mRegistration.setDeviceId("1111111111");
                //mRegistration.setSimSerialNumber("1111111111");
                //mRegistration.setOperatorDeviceSim("TTelecom");
                //mRegistration.setSimSubscriberId(mRegistration.getFirstName());

                mRegistration = SerializationHelper.fromJson(
                        new KolOthenticor(null
                        ,KoloConstants
                        .KolOthenticor_BaseUrl)
                        .DoRegistration(SerializationHelper
                        .toJson(mRegistration, mRegistration.getClass()))
                        ,mRegistration.getClass());

            } catch (Exception e) {
                return null;
            }
            return mRegistration;
        }

        @Override
        protected void onPreExecute() {
            _signupButton.setEnabled(false);

//            signup_progressBar.setVisibility(View.VISIBLE);

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
            final Boolean success = mRegistration != null && mRegistration.getRegistrationStatusCode().equalsIgnoreCase(KoloConstants.REGISTRATION_STATUS_NEEDCONFIRM);
            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            if (success) {
                                registration = myRegistration;
                                mRegistration = myRegistration;
                                ConfigHelper.getAccountInfo().getRegistration()
                                        .setRegistrationStatusCode
                                                (KoloConstants.REGISTRATION_STATUS_NEEDCONFIRM);
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
