package fr.cyberix.kolo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class LoginActivity extends AppCompatActivity {

    RelativeLayout login_view, login_creds;
    LinearLayout signUp_view;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            login_creds.setVisibility(View.VISIBLE);
            signUp_view.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_creds = findViewById(R.id.login_creds);
        signUp_view = findViewById(R.id.signUp_view);

        // 2000 is timeout for splash

        handler.postDelayed(runnable, 2000);

        Button nbutton = findViewById(R.id.login_button);
        nbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, KoloMainActivity.class));
            }
        });

        Button mbutton = findViewById(R.id.signUp_button);
        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });

        Button fbutton = findViewById(R.id.forgotten_pass_button);
        fbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
            }
        });

    }

}
