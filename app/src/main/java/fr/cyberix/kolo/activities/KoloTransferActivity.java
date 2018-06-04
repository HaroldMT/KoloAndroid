package fr.cyberix.kolo.activities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import fr.cyberix.kolo.R;

public class KoloTransferActivity extends AppCompatActivity
        implements DatePickerDialog.OnDateSetListener {

    LinearLayout schulinearLayout, incllinearlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(fr.cyberix.kolo.R.layout.activity_kolo_transfer);

        //Switch controller
        SwitchCompat schedateswitchcompat = findViewById(R.id.switchTransScheduleDate);
        SwitchCompat inclpassswitchcompat = findViewById(R.id.switchIncludePassphrase);
        SwitchCompat needconfswitchcompat = findViewById(R.id.switchNeedConfirmation);
        schedateswitchcompat.setOnCheckedChangeListener(onCheckedChanged());
        inclpassswitchcompat.setOnCheckedChangeListener(onCheckedChanged());
        needconfswitchcompat.setOnCheckedChangeListener(onCheckedChanged());

        //Progress bar and Linearlayout initialisation
        schulinearLayout = findViewById(R.id.LlyKoloTransferSchuLly);
        incllinearlayout = findViewById(R.id.LlyKoloTransferIncPass);

    }

    private CompoundButton.OnCheckedChangeListener onCheckedChanged() {
        return new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                switch (buttonView.getId()){
                    case R.id.switchTransScheduleDate :
                        if (isChecked == true){
                            schulinearLayout.setVisibility(View.VISIBLE);
                        }else if (isChecked == false){schulinearLayout.setVisibility(View.GONE);}
                        break;
                    case R.id.switchIncludePassphrase :
                        if (isChecked == true){
                            incllinearlayout.setVisibility(View.VISIBLE);
                        }else if (isChecked == false){incllinearlayout.setVisibility(View.GONE);}
                        break;
                    default:break;
                }
            }
        };
    }

    /**
     * This callback method, call DatePickerFragment class,
     * DatePickerFragment class returns calendar view.
     * @param view
     */
    public void datePicker(View view){

        SignUpActivity.DatePickerFragment fragment = new SignUpActivity.DatePickerFragment();
        fragment.show(getSupportFragmentManager(),"datePicker");
    }

    /**
     * To set date on TextView
     * @param calendar
     */
    private void setDate(final Calendar calendar) {
        final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);

        ((TextView) findViewById(R.id.txt_trans_sche_date))
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
}
