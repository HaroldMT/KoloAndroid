package fr.cyberix.kolo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.cyberix.kolo.R;
import fr.cyberix.kolo.helpers.ConfigHelper;
import fr.cyberix.kolo.helpers.KoloHelper;
import fr.cyberix.kolo.model.EneoBillDetailsList;

public class KoloEneoBillPaymentActivity extends AppCompatActivity {
	String TAG;
	@BindView(R.id.eneo_bill_no)
	EditText eneo_bill_number;
	@BindView(R.id.eneo_contract_no)
	EditText eneo_contract_number;
	@BindView(R.id.eneo_pay_btn_card)
	CardView payOtherCardBtn;
	@BindView(R.id.eneo_pay_my_own_btn_card)
	CardView payMyCardBtn;
	@BindView(R.id.eneo_other_card)
	CardView otherCardView;
	@BindView(R.id.eneo_my_bill_text)
	TextView myBillText;
	@BindView(R.id.eneo_someone_bill_text)
	TextView someOneBillText;
	
	boolean isContractSearch = false;
	EneoBillDetailsList eneoBillList;
	Handler handler;
	private View view;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.AppTheme_Dialog);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kolo_eneo_bill_payment);
		TAG = this.getLocalClassName();
		ButterKnife.setDebug(true);
		ButterKnife.bind(this);
		KoloHelper.setActivity(this);
		setTitle("Kolo Eneo");
		eneo_bill_number.setVisibility(View.GONE);
		eneo_contract_number.setVisibility(View.GONE);
		payMyCardBtn.setVisibility(View.GONE);
		payOtherCardBtn.setVisibility(View.GONE);
		otherCardView.setVisibility(View.GONE);
		
		RadioGroup rg = findViewById(R.id.eneo_radio_type);
		rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
//				boolean checked = ((RadioButton) view).isChecked();
				switch (checkedId) {
					case R.id.eneo_radio_my_bill:
//						if (checked) {
						handler = new Handler();
						
						final Runnable rMy = new Runnable() {
							public void run() {
								payMyCardBtn.setVisibility(View.VISIBLE);
								otherCardView.setVisibility(View.GONE);
								payOtherCardBtn.setVisibility(View.GONE);
							}
						};
						handler.postDelayed(rMy, 100);
						break;
//						}
					case R.id.eneo_radio_other_bill:
//						if (checked) {
						handler = new Handler();
						
						final Runnable rOther = new Runnable() {
							public void run() {
								payMyCardBtn.setVisibility(View.GONE);
								otherCardView.setVisibility(View.VISIBLE);
								payOtherCardBtn.setVisibility(View.VISIBLE);
							}
						};
						handler.postDelayed(rOther, 100);
						break;
//						}
				}
			}
		});
	}
	
	public void setBillList(EneoBillDetailsList billList) {
		eneoBillList = billList;
		KoloHelper.ShowSimpleAlert("Eneo bills found", billList.size() + " bills");
	}
	
	public void onRadioButtonClicked(View view) {
		this.view = view;
		boolean checked = ((RadioButton) view).isChecked();
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
			case R.id.eneo_radio_my_bill:
				if (checked) {
					handler = new Handler();
					
					final Runnable r = new Runnable() {
						public void run() {
							payMyCardBtn.setVisibility(View.VISIBLE);
							otherCardView.setVisibility(View.GONE);
							payOtherCardBtn.setVisibility(View.GONE);
						}
					};
					handler.postDelayed(r, 100);
					break;
				}
			case R.id.eneo_radio_other_bill:
				if (checked) {
					handler = new Handler();
					
					final Runnable r = new Runnable() {
						public void run() {
							payMyCardBtn.setVisibility(View.GONE);
							otherCardView.setVisibility(View.VISIBLE);
							payOtherCardBtn.setVisibility(View.VISIBLE);
						}
					};
					handler.postDelayed(r, 100);
					break;
				}
		}
	}
	
	@Override
	public void onPointerCaptureChanged(boolean hasCapture) {
	
	}
	
	public void onClickPayMyBill(View view) {
		isContractSearch = true;
		String eneoCode = ConfigHelper.getAccountInfo().getCustomer().getEneoContractNo();
		checkEneoBills(isContractSearch, eneoCode);
	}
	
	public void checkEneoBills(boolean isContract, String code) {
		if (verifyEneoCode(code)) {
			Intent intent = new Intent(getBaseContext(), KoloEneoPayBillActivity.class);
			intent.putExtra("ENEO_CODE", code);
			intent.putExtra("IS_CONTRACT_SEARCH", isContract);
			startActivity(intent);
			finish();
		}
	}
	
	public boolean verifyEneoCode(String code) {
		boolean isValid = false;
		if (code == null || code.length() < 5) KoloHelper.ShowSimpleAlert("Code eneo manquand ou invalide",
		                                                                  "Veuillez renseigner le code Eneo. S'il s'agit de votre propre facture, veuillez" +
				                                                                  " enregistrer votre numéro de contrat Eneo au préalable dans les " +
				                                                                  "préférences" +
				                                                                  " de l'application");
		else isValid = true;
		return isValid;
	}
	
	public void onClickPaySomeoneBill(View view) {
		String eneoCode;
		if (!isContractSearch)
			eneoCode = eneo_bill_number.getText().toString();
		else
			eneoCode = eneo_contract_number.getText().toString();
		checkEneoBills(isContractSearch, eneoCode);
	}
	
	public void setPaymentType(View view) {
		boolean checked = ((RadioButton) view).isChecked();
		switch (view.getId()) {
			case R.id.eneo_radio_my_bill:
				if (checked) {
					handler = new Handler();
					
					final Runnable r = new Runnable() {
						public void run() {
							payMyCardBtn.setVisibility(View.VISIBLE);
							otherCardView.setVisibility(View.GONE);
						}
					};
					handler.postDelayed(r, 100);
					break;
				}
			case R.id.eneo_radio_other_bill:
				if (checked) {
					handler = new Handler();
					
					final Runnable r = new Runnable() {
						public void run() {
							payMyCardBtn.setVisibility(View.GONE);
							otherCardView.setVisibility(View.VISIBLE);
						}
					};
					handler.postDelayed(r, 100);
					break;
				}
		}
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		KoloHelper.setActivity(this);
	}
}