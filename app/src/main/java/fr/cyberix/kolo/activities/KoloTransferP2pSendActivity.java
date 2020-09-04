package fr.cyberix.kolo.activities;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
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
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fr.cyberix.kolo.R;
import fr.cyberix.kolo.fragments.DatePickerFragment;
import fr.cyberix.kolo.helpers.ConfigHelper;
import fr.cyberix.kolo.helpers.KoloConstants;
import fr.cyberix.kolo.helpers.KoloHelper;
import fr.cyberix.kolo.helpers.QrCodeHelper;
import fr.cyberix.kolo.helpers.ScannerHelper;
import fr.cyberix.kolo.helpers.ServiceHelper;
import fr.cyberix.kolo.helpers.ValidationHelper;
import fr.cyberix.kolo.interfaces.ServiceOperationInterface;
import fr.cyberix.kolo.model.AccountInfo;
import fr.cyberix.kolo.model.KoloWsObject;
import fr.cyberix.kolo.model.QrContact;
import fr.cyberix.kolo.model.entities.TransfertP2p;

public class KoloTransferP2pSendActivity extends AppCompatActivity
		implements DatePickerDialog.OnDateSetListener {
	private static final String TAG = KoloTransferP2pSendActivity.class.getSimpleName();
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
	
	private int myYear, myMonth, myDay;
	private QrContact qrContact;
	private TransfertP2p transfertP2p;
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
							} else {
								onSearchNumberContactFailed();
							}
							progressBar.setVisibility(View.GONE);
							sendBtn.setEnabled(true);
							cancelBtn.setEnabled(true);
						}
					}, 3000);
		}
		
		@Override
		public void onOperationFailure(String errorMessage) {
			KoloHelper.ShowSimpleAlert("Failure", errorMessage);
			progressBar.setVisibility(View.GONE);
			sendBtn.setEnabled(true);
			cancelBtn.setEnabled(true);
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
	private Date scheduledDate;
	private Calendar calendar;
	ServiceOperationInterface<TransfertP2p, KoloWsObject<TransfertP2p>> sendP2pTransfer = new ServiceOperationInterface<TransfertP2p,
			KoloWsObject<TransfertP2p>>() {
		
		@Override
		public void onOperationSuccess(String message, KoloWsObject<TransfertP2p> transfertP2p2) {
			final Boolean success = transfertP2p2 != null;
			new android.os.Handler().postDelayed(
					new Runnable() {
						public void run() {
							if (success) {
//								transfertP2p = transfertP2p2;
								onSendMoneySuccess();
							} else {
								onSendMoneyFailed();
							}
							progressBar.setVisibility(View.GONE);
							sendBtn.setEnabled(true);
							cancelBtn.setEnabled(true);
						}
					}, 3000);
		}
		
		@Override
		public void onOperationFailure(String errorMessage) {
			KoloHelper.ShowSimpleAlert("Failure", errorMessage);
			progressBar.setVisibility(View.GONE);
			sendBtn.setEnabled(true);
			cancelBtn.setEnabled(true);
		}
		
		@Override
		public void onPreExecute() {
			sendBtn.setEnabled(false);
			cancelBtn.setEnabled(false);
			progressBar.setVisibility(View.VISIBLE);
			if (inclpassswitchcompat.isChecked()) transfertP2p.setSecret(txtTransSecret.getText().toString());
			if (schedateswitchcompat.isChecked()) transfertP2p.setTransfertDate(txtScheduledDate.getText().toString());
			transfertP2p.setNeedsConfirmation(needconfswitchcompat.isChecked());
			transfertP2p.setIdReceiverCustomer(qrContact.getIdCustomer());
		}
		
		@Override
		public KoloWsObject<TransfertP2p> doInBackground(TransfertP2p parameter) {
			return ServiceHelper.sendP2pTransfer(parameter);
		}
	};
	//	private TransfertP2pAsync transfertP2pAsync;
	private AccountInfo accountInfo;

//	DatePickerDialog.OnDateSetListener datePickerDialog = new DatePickerDialog.OnDateSetListener() {
//		@Override
//		public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
//			myYear = year;
//			myMonth = monthOfYear + 1;
//			myDay = dayOfMonth;
//			calendar.set(Calendar.YEAR, year);
//			calendar.set(Calendar.MONTH, monthOfYear);
//			calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//			showDate();
//		}
//	};
	
	private void showDate() {
		calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, myYear);
		calendar.set(Calendar.MONTH, myMonth - 1);
		calendar.set(Calendar.DAY_OF_MONTH, myDay);
		scheduledDate = calendar.getTime();
		txtScheduledDate.setText(KoloHelper.getDateFormat().format(scheduledDate));
	}
	
	@OnClick(R.id.btn_trans_scan_qr)
	public void ScanQrCode(View v) {
		ScannerHelper.scanBarcode(this, v);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		try {
			if (requestCode == KoloConstants.QR_SCAN_REQUEST_CODE) {
				IntentResult result = IntentIntegrator.parseActivityResult(resultCode, data);
				if (result != null) {
					if (result.getContents() == null) {
						KoloHelper.ShowToast("Cancelled");
					} else {
						String qrContactString = result.getContents();
						QrContact contact = QrCodeHelper.GetQrContactFromQrCode(qrContactString, QrContact.class);
						SetQrContact(contact);
					}
				} else {
					super.onActivityResult(requestCode, resultCode, data);
				}
			} else if (requestCode == KoloConstants.PICK_CONTACT_REQUEST_CODE) {
				Uri contactUri = data.getData();
				Cursor cursor = getContentResolver().query(contactUri, null, null, null, null);
				if (cursor != null) {
					cursor.moveToFirst();
					int column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
					String number = cursor.getString(column);
					Toast.makeText(this, "Recherche du compte Kolo pour le numéro " + number, Toast.LENGTH_LONG).show();

					number = number.replaceAll("[^0-9]", "");
					ServiceHelper.doInBackground(number, findContact);
				} else {
					Toast.makeText(this, "Aucun contact récupéré", Toast.LENGTH_LONG).show();
				}
			}
		} catch (Exception ex) {
			KoloHelper.ShowToast(ex.getMessage());
		}
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
	
	@Override
	protected void onResume() {
		super.onResume();
		KoloHelper.setActivity(this);
	}
	
	@OnClick(R.id.btn_trans_add_contact)
	public void SelectContact(View v) {
		Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
//        Intent intent = new Intent(Intent.ACTION_PICK, Contacts.People.CONTENT_URI);
		startActivityForResult(intent, KoloConstants.PICK_CONTACT_REQUEST_CODE);
	}
	
	@OnClick(R.id.btn_trans_search)
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
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(fr.cyberix.kolo.R.layout.activity_kolo_transfer_p2p_send);
		ButterKnife.setDebug(true);
		ButterKnife.bind(this);
		KoloHelper.setActivity(this);
		
		schedateswitchcompat.setOnCheckedChangeListener(onCheckedChanged());
		inclpassswitchcompat.setOnCheckedChangeListener(onCheckedChanged());
		needconfswitchcompat.setOnCheckedChangeListener(onCheckedChanged());
		transfertP2p = new TransfertP2p();
		accountInfo = ConfigHelper.getAccountInfo();
		progressBar.setVisibility(View.GONE);
		transfertDateLinLayout.setVisibility(View.GONE);
	}
	
	private CompoundButton.OnCheckedChangeListener onCheckedChanged() {
		Log.d(TAG, "onCheckedChanged");
		return new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				switch (buttonView.getId()) {
					case R.id.switchTransScheduleDate:
						if (isChecked) {
							transfertDateLinLayout.setVisibility(View.VISIBLE);
						} else if (isChecked == false) {
							transfertDateLinLayout.setVisibility(View.GONE);
							txtScheduledDate.setText("");
						}
						break;
					case R.id.switchIncludePassphrase:
						if (isChecked) {
							incllinearlayout.setVisibility(View.VISIBLE);
						} else {
							incllinearlayout.setVisibility(View.GONE);
							transfertP2p.setSecret("");
							txtTransSecret.setText("");
						}
						break;
					case R.id.switchNeedConfirmation:
						if (isChecked) {
							transfertP2p.setNeedsConfirmation(true);
						}
					default:
						break;
				}
			}
		};
	}
	
	public void datePicker(View view) {
		Log.d(TAG, "datePicker");
		DatePickerFragment fragment = new DatePickerFragment();
		fragment.show(getSupportFragmentManager(), "datePicker");
	}
	
	@OnClick(R.id.btn_trans_ok)
	public void SendMoney(View v) {
		Log.d(TAG, "SendMoney");
		String strAmount = txtAmount.getText().toString();
		int amount;
		try {
			amount = Integer.parseInt(strAmount);
			transfertP2p.setAmount(amount);
		} catch (NumberFormatException nfe) {
			KoloHelper.ShowToast("Montant invalide");
		}
		if (!isDataValid()) {
			KoloHelper.ShowSimpleAlert("Erreur", "Veuillez vérifier les informations saisies");
			return;
		}
		ServiceHelper.doInBackground(transfertP2p, sendP2pTransfer);
	}
	
	private boolean isDataValid() {
		Log.d(TAG, "isDataValid");
//        return false;
		return true;
	}
	
	public void onSendMoneyFailed() {
		Log.d(TAG, "onSendMoneyFailed");
		KoloHelper.ShowSimpleAlert("Échec", "La transaction n'a pas abouti");
	}
	
	private void onSearchNumberContactFailed() {
		KoloHelper.ShowSimpleAlert("Échec", "Erreur lors de la recherche du contact");
	}
	
	@OnClick(R.id.btn_trans_cancel)
	public void CancelOperation(View v) {
		Log.d(TAG, "CancelOperation");
		finish();
	}
	
	public void onSendMoneySuccess() {
		KoloHelper.ShowToast("Fin de l'opération");
	}
	
	@Override
	public void onDateSet(DatePicker view, int year, int month, int day) {
		Log.d(TAG, "onDateSet");
		Calendar cal = new GregorianCalendar(year, month, day);
		setDate(cal);
		// Do something with the date chosen by the user
	}
	
	private void onSearchNumberContactSucces() {
		KoloHelper.ShowToast("Fin de la recherche");
	}
	
	private void setDate(final Calendar calendar) {
		Log.d(TAG, "setDate");
		final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
		
		((TextView) findViewById(R.id.txt_trans_sche_date))
				.setText(dateFormat.format(calendar.getTime()));
	}
}