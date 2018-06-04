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

import static fr.cyberix.kolo.helpers.ScannerHelper.generateQRCode_general;

public class KoloUserQRCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(fr.cyberix.kolo.R.layout.activity_kolo_user_qrcode);
        ButterKnife.setDebug(true);
        ButterKnife.bind(this);
        KoloHelper.setActivity(this);

        //QR code generator
        String qrCodeData = QrCodeHelper.GenerateQrCodeData();
        ImageView imageView = findViewById(R.id.img_usrprof_qrcode);

        try {
            generateQRCode_general(qrCodeData, imageView);
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
}
