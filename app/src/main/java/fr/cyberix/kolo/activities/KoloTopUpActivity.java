package fr.cyberix.kolo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fr.cyberix.kolo.R;
import fr.cyberix.kolo.helpers.KoloHelper;
import fr.cyberix.kolo.helpers.ServiceHelper;
import fr.cyberix.kolo.interfaces.ServiceOperationInterface;
import fr.cyberix.kolo.model.KoloWsObject;
import fr.cyberix.kolo.model.entities.TopUp;

public class KoloTopUpActivity extends AppCompatActivity {
	String TAG;
	@BindView(R.id.airtime_amount_text)
	EditText airtimeAmount;
	@BindView(R.id.airtime_buy_btn)
	Button buyAirtime;
	@BindView(R.id.airtime_provider_spinner)
	Spinner airtimeProvider;
	
	ServiceOperationInterface<TopUp, KoloWsObject<String>> doTopUp = new ServiceOperationInterface<TopUp, KoloWsObject<String>>() {
		@Override
		public void onOperationSuccess(String message, KoloWsObject<String> data) {
			Toast.makeText(KoloHelper.getMyActivity(), data.getDataObject(), Toast.LENGTH_LONG).show();
		}
		
		@Override
		public void onOperationFailure(String errorMessage) {
			KoloHelper.ShowSimpleAlert("Failure", errorMessage);
		}
		
		@Override
		public void onPreExecute() {
		
		}
		
		@Override
		public KoloWsObject<String> doInBackground(TopUp parameter) {
			return ServiceHelper.buyTopUp(parameter);
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.AppTheme_Dialog);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kolo_top_up);
		TAG = this.getLocalClassName();
		ButterKnife.setDebug(true);
		ButterKnife.bind(this);
		KoloHelper.setActivity(this);
		setTitle("Kolo TopUp");
	}
	
	@OnClick(R.id.airtime_buy_btn)
	public void onBuyAirtimeClick() {
		ServiceHelper.doInBackground(null, doTopUp);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		KoloHelper.setActivity(this);
	}
}
