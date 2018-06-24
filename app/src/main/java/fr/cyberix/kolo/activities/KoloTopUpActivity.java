package fr.cyberix.kolo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.cyberix.kolo.R;
import fr.cyberix.kolo.helpers.KoloHelper;

public class KoloTopUpActivity extends AppCompatActivity {
	String TAG;
	@BindView(R.id.airtime_amount_text)
	EditText airtimeAmount;
	@BindView(R.id.airtime_buy_btn)
	Button buyAirtime;
	@BindView(R.id.airtime_provider_spinner)
    Spinner airtimeProvider;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kolo_top_up);
		TAG = this.getLocalClassName();
		ButterKnife.setDebug(true);
		ButterKnife.bind(this);
		KoloHelper.setActivity(this);
	}
}
