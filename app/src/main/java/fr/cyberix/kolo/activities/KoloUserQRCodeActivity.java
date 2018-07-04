package fr.cyberix.kolo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.zxing.WriterException;

import butterknife.ButterKnife;
import fr.cyberix.kolo.R;
import fr.cyberix.kolo.helpers.KoloHelper;
import fr.cyberix.kolo.helpers.QrCodeHelper;
import fr.cyberix.kolo.model.QrContact;

import static fr.cyberix.kolo.helpers.ScannerHelper.generateQrCode_general;

public class KoloUserQRCodeActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTheme(android.R.style.Theme_Material_Light_Dialog);
		super.onCreate(savedInstanceState);
		setContentView(fr.cyberix.kolo.R.layout.activity_kolo_user_qrcode);
		ButterKnife.setDebug(true);
		ButterKnife.bind(this);
		setTitle("My Kolo Code");
		//QR code generator
		QrContact me = new QrContact();
		String qrCodeData = QrCodeHelper.GenerateQrCodeData(me, QrContact.class);
		ImageView imageView = findViewById(R.id.img_usrprof_qrcode);
		
		try {
			generateQrCode_general(qrCodeData, imageView);
		} catch (WriterException e) {
			e.printStackTrace();
		}
		
		Button button = findViewById(R.id.btn_usrprof_qrcode_close);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		KoloHelper.setActivity(this);
	}
}
