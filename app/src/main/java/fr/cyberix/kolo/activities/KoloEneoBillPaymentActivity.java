package fr.cyberix.kolo.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.cyberix.kolo.R;
import fr.cyberix.kolo.helpers.KoloHelper;
import fr.cyberix.kolo.helpers.SerializationHelper;
import fr.cyberix.kolo.helpers.ServiceHelper;
import fr.cyberix.kolo.model.EneoBillDetailsList;
import fr.cyberix.kolo.services.KolOPartVice;

public class KoloEneoBillPaymentActivity extends AppCompatActivity {
	String TAG;
	//	@BindView(R.id.eneo_pay_btn)
//	Button payBtn;
	@BindView(R.id.eneo_bill_no)
	EditText eneo_bill_number;
	@BindView(R.id.eneo_contract_no)
	EditText eneo_contract_number;
	@BindView(R.id.eneo_pay_btn_card)
	CardView payCardBtn;
	
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
		payCardBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				payEneoBill(v);
			}
		});
	}
	
	//	@OnClick(R.id.eneo_pay_btn)
	public void payEneoBill(View v) {
		String eneoCode;
		if (!isContractSearch)
			eneoCode = eneo_bill_number.getText().toString();
		else
			eneoCode = eneo_contract_number.getText().toString();
		Intent intent = new Intent(getBaseContext(), KoloEneoPayBillActivity.class);
		intent.putExtra("ENEO_CODE", eneoCode);
		intent.putExtra("IS_CONTRACT_SEARCH", isContractSearch);
		startActivity(intent);
		finish();
//		QueryEneoBillAsync eneoQuery = new QueryEneoBillAsync(eneoCode, isContractSearch);
//		eneoQuery.execute();
	}
	
	public void setBillList(EneoBillDetailsList billList) {
		eneoBillList = billList;
		KoloHelper.ShowSimpleAlert("Eneo bills found", billList.size() + " bills");
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
	
	@Override
	public void onPointerCaptureChanged(boolean hasCapture) {
	
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
			setBillList(eneoBillDetailsList);
		}
	}
}