package fr.cyberix.kolo.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.braintreepayments.cardform.view.CardForm;

import butterknife.BindView;
import fr.cyberix.kolo.R;
import fr.cyberix.kolo.helpers.KoloHelper;

public class CreditCardInputActivity extends AppCompatActivity {
	@BindView(R.id.card_form)
	CardForm cardForm;
	@BindView(R.id.card_form_btn_scan)
	Button btnScan;
	@BindView(R.id.card_form_btn_buy)
	Button btnBuy;
	AlertDialog.Builder alertBuilder;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_credit_card_input);
//		ButterKnife.setDebug(true);
//		ButterKnife.bind(this);
		KoloHelper.setActivity(this);
		
		cardForm = findViewById(R.id.card_form);
		btnBuy = findViewById(R.id.card_form_btn_buy);
		btnScan = findViewById(R.id.card_form_btn_scan);
		cardForm.cardRequired(true)
		        .expirationRequired(true)
		        .cvvRequired(true)
		        .postalCodeRequired(true)
		        .mobileNumberRequired(true)
		        .mobileNumberExplanation("SMS is required on this number")
		        .setup(CreditCardInputActivity.this);
		cardForm.getCvvEditText().setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
		btnBuy.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (cardForm.isValid()) {
					alertBuilder = new AlertDialog.Builder(CreditCardInputActivity.this);
					alertBuilder.setTitle("Confirm before purchase");
					alertBuilder.setMessage("Card number: " + cardForm.getCardNumber() + "\n" +
							                        "Card expiry date: " + cardForm.getExpirationDateEditText().getText().toString() + "\n" +
							                        "Card CVV: " + cardForm.getCvv() + "\n" +
							                        "Postal code: " + cardForm.getPostalCode() + "\n" +
							                        "Phone number: " + cardForm.getMobileNumber());
					alertBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialogInterface, int i) {
							dialogInterface.dismiss();
							Toast.makeText(CreditCardInputActivity.this, "Thank you for purchase", Toast.LENGTH_LONG).show();
						}
					});
					alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialogInterface, int i) {
							dialogInterface.dismiss();
						}
					});
					AlertDialog alertDialog = alertBuilder.create();
					alertDialog.show();
				} else {
					Toast.makeText(CreditCardInputActivity.this, "Please complete the form", Toast.LENGTH_LONG).show();
				}
			}
		});
		
		btnScan.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (cardForm.isCardScanningAvailable())
					cardForm.scanCard(KoloHelper.getMyActivity());
				if (cardForm.isValid())
					Toast.makeText(KoloHelper.getMyActivity(), "This is a valid card", Toast.LENGTH_SHORT);
				else
					KoloHelper.ShowSimpleAlert("Error", "Invalid data");
			}
		});
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		KoloHelper.setActivity(this);
	}

//	@OnClick(R.id.card_form_btn_buy)
//	public void onConfirmClick(View v) {
//		if (cardForm.isValid())
//			Toast.makeText(this, "This is a valid card", Toast.LENGTH_SHORT);
//		else
//			KoloHelper.ShowSimpleAlert("Error", "Invalid data");
//	}
//
//	@OnClick(R.id.card_form_btn_scan)
//	public void onScanClick(View v) {
//		if (cardForm.isCardScanningAvailable())
//			cardForm.scanCard(KoloHelper.getMyActivity());
//		cardForm.validate();
//		if (cardForm.isValid())
//			Toast.makeText(this, "This is a valid card", Toast.LENGTH_SHORT);
//		else
//			KoloHelper.ShowSimpleAlert("Error", "Invalid data");
//	}
}
