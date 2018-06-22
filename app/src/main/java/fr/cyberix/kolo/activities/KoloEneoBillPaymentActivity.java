package fr.cyberix.kolo.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fr.cyberix.kolo.R;
import fr.cyberix.kolo.helpers.KoloHelper;
import fr.cyberix.kolo.helpers.SerializationHelper;
import fr.cyberix.kolo.helpers.ServiceHelper;
import fr.cyberix.kolo.model.EneoBillDetailsList;
import fr.cyberix.kolo.services.KolOPartVice;

public class KoloEneoBillPaymentActivity extends AppCompatActivity {
	String TAG;
	@BindView(R.id.eneo_pay_btn)
	Button payBtn;
	@BindView(R.id.eneo_bill_no)
	EditText eneo_bill_number;
	@BindView(R.id.eneo_contract_no)
	EditText eneo_contract_number;
	
	boolean isContractSearch = false;
	EneoBillDetailsList eneoBillList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kolo_eneo_bill_payment);
		TAG = this.getLocalClassName();
		ButterKnife.setDebug(true);
		ButterKnife.bind(this);
		KoloHelper.setActivity(this);
		eneo_bill_number.setVisibility(View.GONE);
		eneo_contract_number.setVisibility(View.GONE);
	}
	
	@OnClick(R.id.eneo_pay_btn)
	public void payEneoBill(View v) {
		String eneoCode;
		if (!isContractSearch)
			eneoCode = eneo_bill_number.getText().toString();
		else
			eneoCode = eneo_contract_number.getText().toString();
		QueryEneoBillAsync eneoQuery = new QueryEneoBillAsync(eneoCode, isContractSearch);
		eneoQuery.execute();
	}
	
	public void setBillList(EneoBillDetailsList billList) {
		eneoBillList = billList;
	}
	
	public void onRadioButtonClicked(View view) {
		// Is the button now checked?
		boolean checked = ((RadioButton) view).isChecked();
		
		// Check which radio button was clicked
		switch (view.getId()) {
			case R.id.eneo_radio_contract:
				if (checked) {
					eneo_bill_number.setVisibility(View.GONE);
					eneo_contract_number.setVisibility(View.VISIBLE);
					eneo_bill_number.setText("");
					isContractSearch = true;
					break;
				}
			case R.id.eneo_radio_bill_number:
				if (checked) {
					eneo_bill_number.setVisibility(View.VISIBLE);
					eneo_contract_number.setVisibility(View.GONE);
					eneo_contract_number.setText("");
					isContractSearch = false;
					break;
				}
		}
	}
	
	public class QueryEneoBillAsync extends AsyncTask<Void, Void, EneoBillDetailsList> {
		String eneoCode;
		boolean isContractNo;
		String result;
		
		public QueryEneoBillAsync(String code, boolean isContractNumber) {
			eneoCode = code;
			isContractNo = isContractNumber;
		}
		
		@Override
		protected EneoBillDetailsList doInBackground(Void... voids) {
			KolOPartVice service = ServiceHelper.getKolOPartVice();
			if (isContractNo)
				result = service.GetEneoBillsByBillAccount(eneoCode);
			else
				result = service.GetEneoBillByBillNumber(eneoCode);
			EneoBillDetailsList eneoBillDetailsList = SerializationHelper.fromJson(result, EneoBillDetailsList.class);
			return eneoBillDetailsList;
		}
		
		@Override
		protected void onPostExecute(EneoBillDetailsList eneoBillDetailsList) {
			super.onPostExecute(eneoBillDetailsList);
		}
	}
}