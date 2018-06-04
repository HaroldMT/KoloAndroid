package fr.cyberix.kolo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import fr.cyberix.kolo.helpers.ConfigHelper;
import fr.cyberix.kolo.helpers.DateHelper;
import fr.cyberix.kolo.helpers.KoloConstants;
import fr.cyberix.kolo.helpers.KoloHelper;
import fr.cyberix.kolo.helpers.PermissionHelper;

public class SplashActivity extends AppCompatActivity {
    private TextView tv;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        tv = findViewById(R.id.splash_text);
        iv = findViewById(R.id.splash_image);

        Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.splashtransition);
        tv.startAnimation(myAnim);
        iv.startAnimation(myAnim);

        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                }
            }
        };

        timer.start();
        PermissionHelper.checkPermissions(this, this);
        KoloHelper.initialize(this, this, this);

        if (ConfigHelper.getRegistering())
            startActivity(new Intent(getApplicationContext(), SignUpConfirmationActivity.class));
        else if (ConfigHelper.getRegistered()) {
            Boolean gotoLoginActivity = true;
            if (ConfigHelper.getAccountInfo().getAuthenticated()) {
                Date date = ConfigHelper.getAccountInfo().getLastAuthenticationTime();
                DateHelper dateHelper = DateHelper.DateDiff(date, Calendar.getInstance().getTime());
                if (dateHelper.diffInMin < KoloConstants.forceLoginAfterShutdownTimeLimit) {
                    gotoLoginActivity = false;
                    startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
                }
            }
            if (gotoLoginActivity)
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        } else startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
        finish();
    }
}