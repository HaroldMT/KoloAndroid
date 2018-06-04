package fr.cyberix.kolo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import fr.cyberix.kolo.R;

public class KoloUserProfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(fr.cyberix.kolo.R.layout.activity_kolo_user_profil);

        Button button = findViewById(R.id.btn_usrprof_showqrcode);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(KoloUserProfilActivity.this, KoloUserQRCodeActivity.class));
            }
        });
    }
}
