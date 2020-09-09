package fr.cyberix.kolo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.cyberix.kolo.R;
import fr.cyberix.kolo.helpers.ConfigHelper;
import fr.cyberix.kolo.helpers.DateHelper;
import fr.cyberix.kolo.helpers.KoloConstants;
import fr.cyberix.kolo.helpers.KoloHelper;
import fr.cyberix.kolo.helpers.PermissionHelper;
import fr.cyberix.kolo.helpers.ServiceHelper;
import fr.cyberix.kolo.services.NotificationsService;

public class SplashActivity extends AppCompatActivity {
	@BindView(R.id.splash_text)
	TextView tv;
	@BindView(R.id.splash_image)
	ImageView iv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.AppTheme_FullScreen);
		super.onCreate(savedInstanceState);
		setContentView(fr.cyberix.kolo.R.layout.activity_splash);
		ButterKnife.setDebug(true);
		ButterKnife.bind(this);
		KoloHelper.setActivity(this);
		ServiceHelper.initialize();
		PermissionHelper.checkPermissions();
		Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.splashtransition);
		tv.startAnimation(myAnim);
		iv.startAnimation(myAnim);
		
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
				}
			}
		};
		
		timer.start();
		PermissionHelper.checkPermissions(this, this);
		KoloHelper.initialize(this, this, this);
		
		if (ConfigHelper.getRegistering()) {
//			startActivity(new Intent(getApplicationContext(), SignUpConfirmationActivity.class));
			KoloHelper.startActivity(SignUpConfirmationActivity.class);
		} else if (ConfigHelper.getRegistered()) {
			Boolean gotoLoginActivity = true;
			if (ConfigHelper.getAccountInfo().getAuthenticated()) {
				Date date = ConfigHelper.getAccountInfo().getLastAuthenticationTime();
				DateHelper dateHelper = DateHelper.DateDiff(date, Calendar.getInstance().getTime());
				String timeMsg = "Last loggin was " + dateHelper.diffInMin + "mn ago";
//				Toast.makeText(this, timeMsg, Toast.LENGTH_LONG);
				if (dateHelper.diffInMin < KoloConstants.forceLoginAfterShutdownTimeLimit) {
					gotoLoginActivity = false;
					KoloHelper.startActivity(KoloHomeActivity.class);
//					KoloHelper.startActivity(KoloMadActivity.class);
//					startActivity(new Intent(getApplicationContext(), KoloHomeActivity.class));
				}
			}
			if (gotoLoginActivity) {
//				NotificationsService.
//				startActivity(new Intent(getApplicationContext(), LoginActivity.class));

				KoloHelper.startActivity(LoginActivity.class);
			}
			
		} else {
//			startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
			KoloHelper.startActivity(SignUpActivity.class);
		}
		finish();
	}
}