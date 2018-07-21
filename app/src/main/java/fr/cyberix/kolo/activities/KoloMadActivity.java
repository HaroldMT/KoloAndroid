package fr.cyberix.kolo.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;
import fr.cyberix.kolo.R;
import fr.cyberix.kolo.helpers.KoloConstants;
import fr.cyberix.kolo.helpers.KoloHelper;
import fr.cyberix.kolo.helpers.ScannerHelper;
import fr.cyberix.kolo.helpers.ServiceHelper;
import fr.cyberix.kolo.helpers.ValidationHelper;
import fr.cyberix.kolo.interfaces.ServiceOperationInterface;
import fr.cyberix.kolo.model.KoloWsObject;
import fr.cyberix.kolo.model.QrContact;
import fr.cyberix.kolo.model.entities.TransferGravity;

public class KoloMadActivity extends AppCompatActivity {
	private static final String TAG = KoloMadActivity.class.getSimpleName();
	@BindView(R.id.btn_trans_search)
	ImageButton btnAddPersonFromSearch;
	@BindView(R.id.btn_trans_add_contact)
	ImageButton btnAddPersonFromContact;
	@BindView(R.id.btn_trans_scan_qr)
	ImageButton btnAddPersonFromQr;
	@BindView(R.id.switchIncludePassphrase)
	SwitchCompat inclpassswitchcompat;
	@BindView(R.id.switchNeedConfirmation)
	SwitchCompat needconfswitchcompat;
	@BindView(R.id.switchTransScheduleDate)
	SwitchCompat schedateswitchcompat;
	@BindView(R.id.LlyKoloTransferIncPass)
	LinearLayout incllinearlayout;
	@BindView(R.id.linLayoutTransferP2pDate)
	LinearLayout transfertDateLinLayout;
	@BindView(R.id.btn_trans_ok)
	Button sendBtn;
	@BindView(R.id.btn_trans_cancel)
	Button cancelBtn;
	@BindView(R.id.progressBar_trans_p2p)
	ProgressBar progressBar;
	@BindView(R.id.txtTransSecret)
	TextInputEditText txtTransSecret;
	@BindView(R.id.txtTransEnterAmt)
	TextInputEditText txtAmount;
	@BindView(R.id.txt_trans_sche_date)
	TextView txtScheduledDate;
	@BindView(R.id.txt_trans_full_name)
	TextView txtTransFullName;
	@BindView(R.id.txt_trans_phone)
	TextView txtTransPhone;
	ServiceOperationInterface<TransferGravity, KoloWsObject<String>> sendTransfer = new ServiceOperationInterface<TransferGravity,
			KoloWsObject<String>>() {
		
		@Override
		public void onOperationSuccess(String message, KoloWsObject<String> transfert) {
			final Boolean success = transfert != null;
			new android.os.Handler().postDelayed(
					new Runnable() {
						public void run() {
							if (success) {
//								transfertP2p = transfertP2p2;
								onSendMoneySuccess();
							} else onSendMoneyFailed();
							progressBar.setVisibility(View.GONE);
							sendBtn.setEnabled(true);
							cancelBtn.setEnabled(true);
						}
					}, 3000);
		}
		
		@Override
		public void onOperationFailure(String errorMessage) {
			KoloHelper.ShowSimpleAlert("Failure", errorMessage);
		}
		
		@Override
		public void onPreExecute() {
			sendBtn.setEnabled(false);
			cancelBtn.setEnabled(false);
			progressBar.setVisibility(View.VISIBLE);
//			if (inclpassswitchcompat.isChecked()) transfertGravity.setSecret(txtTransSecret.getText().toString());
//			if (schedateswitchcompat.isChecked()) transfertGravity.setTransfertDate(txtScheduledDate.getText().toString());
//			transfertGravity.setNeedsConfirmation(needconfswitchcompat.isChecked());
//			transfertGravity.setIdReceiverCustomer(qrContact.getIdCustomer());
		}
		
		@Override
		public KoloWsObject<String> doInBackground(TransferGravity parameter) {
			return ServiceHelper.sendGravityTransfer(parameter);
		}
	};
	private QrContact qrContact;
	ServiceOperationInterface<String, KoloWsObject<QrContact>> findContact = new ServiceOperationInterface<String,
			KoloWsObject<QrContact>>() {
		
		@Override
		public void onOperationSuccess(String message, KoloWsObject<QrContact> koloContact) {
			final QrContact contact = koloContact.getDataObject();
			final Boolean success = contact != null;
			
			new android.os.Handler().postDelayed(
					new Runnable() {
						public void run() {
							if (success) {
								SetQrContact(contact);
								onSearchNumberContactSucces();
							} else onSearchNumberContactFailed();
							progressBar.setVisibility(View.GONE);
							sendBtn.setEnabled(true);
							cancelBtn.setEnabled(true);
						}
					}, 3000);
		}
		
		@Override
		public void onOperationFailure(String errorMessage) {
			KoloHelper.ShowSimpleAlert("Failure", errorMessage);
		}
		
		@Override
		public void onPreExecute() {
			sendBtn.setEnabled(false);
			cancelBtn.setEnabled(false);
			progressBar.setVisibility(View.VISIBLE);
		}
		
		@Override
		public KoloWsObject<QrContact> doInBackground(String parameter) {
			return ServiceHelper.getContactByNumber(parameter);
		}
	};
	private TransferGravity transfertGravity;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kolo_mad);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		KoloHelper.setActivity(this);
	}
	
	private Date scheduledDate;
	private Calendar calendar;
	
	@OnClick(R.id.btn_mad_qr_search)
	public void ScanQrCode(View v) {
		ScannerHelper.scanBarcode(this, v);
	}
	
	@OnClick(R.id.btn_mad_contact_search)
	public void SelectContact(View v) {
		Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
//        Intent intent = new Intent(Intent.ACTION_PICK, Contacts.People.CONTENT_URI);
		startActivityForResult(intent, KoloConstants.PICK_CONTACT_REQUEST_CODE);
	}
	
	@OnClick(R.id.btn_mad_ok)
	public void SendMoney(View v) {
		Log.d(TAG, "SendMoney");
		String strAmount = txtAmount.getText().toString();
		int amount;
		try {
			amount = Integer.parseInt(strAmount);
			transfertGravity.setAmount(amount);
		} catch (NumberFormatException nfe) {
			KoloHelper.ShowToast("Montant invalide");
		}
		if (!isDataValid()) {
			KoloHelper.ShowSimpleAlert("Erreur", "Veuillez vérifier les informations saisies");
			return;
		}
		ServiceHelper.doInBackground(transfertGravity, sendTransfer);
	}
	
	private boolean isDataValid() {
		Log.d(TAG, "isDataValid");
//        return false;
		return true;
	}
	
	@OnClick(R.id.btn_mad_number_search)
	public void QueryNumber(View v) {
		LayoutInflater layoutInflater = LayoutInflater.from(this);
		View promptView = layoutInflater.inflate(R.layout.input_layout, null);
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
		alertDialogBuilder.setView(promptView);
		
		final TextInputEditText editText = promptView.findViewById(R.id.txt_user_input);
		editText.setHint("Numéro de téléphone");
		
		// setup a dialog window
		alertDialogBuilder.setCancelable(false)
		                  .setPositiveButton("Rechercher", new DialogInterface.OnClickListener() {
			                  public void onClick(DialogInterface dialog, int id) {
				                  String telephone = editText.getText().toString();
				                  if (!ValidationHelper.isValidPhone(telephone)) {
					                  KoloHelper.ShowSimpleAlert("Erreur", "Numéro de téléphone incorrect");
				                  } else {
					                  ServiceHelper.doInBackground(null, findContact);
				                  }
			                  }
		                  })
		                  .setNegativeButton("Cancel",
		                                     new DialogInterface.OnClickListener() {
			                                     public void onClick(DialogInterface dialog, int id) {
				                                     dialog.cancel();
			                                     }
		                                     });
		
		// create an alert dialog
		AlertDialog alert = alertDialogBuilder.create();
		alert.show();
	}
	
	public void SetQrContact(QrContact contact) {
		qrContact = contact;
		if (qrContact == null) {
			txtTransFullName.setText("");
			txtTransPhone.setText("");
		} else {
			txtTransFullName.setText(qrContact.getFullName());
			txtTransPhone.setText(qrContact.getLineNumber());
		}
	}
	
	private void onSearchNumberContactFailed() {
		KoloHelper.ShowSimpleAlert("Échec", "Erreur lors de la recherche du contact");
	}
	
	public void onSendMoneySuccess() {
		KoloHelper.ShowToast("Fin de l'opération");
	}
	
	private void onSearchNumberContactSucces() {
		KoloHelper.ShowToast("Fin de la recherche");
	}
	
	public void onSendMoneyFailed() {
		Log.d(TAG, "onSendMoneyFailed");
		KoloHelper.ShowSimpleAlert("Échec", "La transaction n'a pas abouti");
	}
}
