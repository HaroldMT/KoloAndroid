package fr.cyberix.kolo;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fr.cyberix.kolo.helpers.ConfigHelper;
import fr.cyberix.kolo.helpers.KoloConstants;
import fr.cyberix.kolo.helpers.KoloHelper;
import fr.cyberix.kolo.helpers.SerializationHelper;
import fr.cyberix.kolo.helpers.ValidationHelper;
import fr.cyberix.kolo.model.entities.Customer;
import fr.cyberix.kolo.model.entities.Registration;
import fr.cyberix.kolo.services.KolOthenticor;

public class SignUpConfirmationActivity extends AppCompatActivity {
    private static final String TAG = "ConfirmationActivity";

    @BindView(R.id.txt_signup_conf_names)
    TextView _usernameView;
    @BindView(R.id.txt_signup_conf_phone)
    TextView _telephoneView;
    @BindView(R.id.txt_signup_conf_Dob)
    TextView _dobView;
    @BindView(R.id.txt_signup_conf_email)
    TextView _emailView;
    @BindView(R.id.btn_signup_conf_ent_conf_code)
    EditText _codeText;
    @BindView(R.id.btn_signup_conf_confirm)
    Button _btnConfirmRegistration;
    //@BindView(R.id.confirm_signup_progressBar)
    //ProgressBar confirm_signup_progressBar;
    Registration registration = null;
    UserConfirmSignUpTask userConfirmSignUpTask = null;
    Customer customer = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_confirmation);
        ButterKnife.bind(this);
        KoloHelper.setActivity(this);
        //confirm_signup_progressBar.setVisibility(View.INVISIBLE);
        loadConfig();
    }

    public void loadConfig() {
        registration = ConfigHelper.getAccountInfo().getRegistration();
        if (registration != null) {
            _dobView.setText(KoloHelper.getDateFormat().format(registration.getDob()));
            _emailView.setText(registration.getEmail());
            _usernameView.setText(registration.getFirstName() + " " + registration.getLastName());
            _telephoneView.setText(registration.getPhoneNumber());
        }
    }

    @OnClick(R.id.btn_signup_conf_confirm)
    public void OnClickRegistration() {
        if (validate()) confirmRegistration();
    }

    public boolean validate() {
        Boolean valid = true;
        if (!ValidationHelper.isValidRegistrationCode(_codeText.getText().toString())) {
            _codeText.setError("Invalid code");
            valid = false;
        } else {
            _codeText.setError(null);
        }
        return valid;
    }

    public void confirmRegistration() {
        Log.d(TAG, "Confirm");
        if (!validate()) {
            onConfirmFailed();
            return;
        }
        userConfirmSignUpTask = new UserConfirmSignUpTask();
        userConfirmSignUpTask.execute((Void) null);
    }

    public void onConfirmFailed() {
        String message = "";
        if (customer != null) {
            switch (customer.getIdCustomer()) {
                case -10:
                    message = ": Your registration data could not be found. Please register again";
                    break;
                case -20:
                    message = ": Registration data is invalid. Register again";
                    break;
                case -30:
                    message = ": The confirmation code is incorrect";
                    break;
                case -40:
                    message = ": The confirmation has expired. Register again";
                    break;
                default:
                    message = ", please try again";
            }
        }
        Toast.makeText(getBaseContext(), "Confirmation failed" + message, Toast.LENGTH_LONG).show();
        _btnConfirmRegistration.setEnabled(true);
    }

    public void onConfirmSuccess() {
        _btnConfirmRegistration.setEnabled(true);
        setResult(RESULT_OK, null);
        ConfigHelper.getAccountInfo().getRegistration().setRegistrationStatusCode(KoloConstants.REGISTRATION_STATUS_COMPLETED);
        ConfigHelper.getAccountInfo().setCustomer(customer);
        ConfigHelper.saveConfig();
        startActivity(new Intent(getBaseContext(), LoginActivity.class));
        finish();
    }

    private class UserConfirmSignUpTask extends AsyncTask<Void, Void, Customer> {

        UserConfirmSignUpTask() {
        }

        @Override
        protected Customer doInBackground(Void... params) {
            Customer myCustomer = new Customer();
            try {
                myCustomer = SerializationHelper.fromJson(new KolOthenticor(null,KoloConstants.KolOthenticor_BaseUrl).DoConfirmRegistration(SerializationHelper.toJson(registration, registration.getClass())),myCustomer.getClass());
            } catch (Exception e) {
                return null;
            }
            return myCustomer;
        }

        @Override
        protected void onPreExecute() {
            _btnConfirmRegistration.setEnabled(false);
            //confirm_signup_progressBar.setVisibility(View.VISIBLE);
            registration.setRegistrationToken(_codeText.getText().toString());
        }

        @Override
        protected void onPostExecute(final Customer myCustomer) {
            customer = myCustomer;
            final Boolean success = myCustomer != null && myCustomer.getIdCustomer() >= 0;
            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            if (success) {
                                onConfirmSuccess();
                            } else onConfirmFailed();
                            //confirm_signup_progressBar.setVisibility(View.GONE);
                        }
                    }, 3000);
        }

        @Override
        protected void onCancelled() {
            userConfirmSignUpTask = null;
            //confirm_signup_progressBar.setVisibility(View.GONE);
        }
    }
}
