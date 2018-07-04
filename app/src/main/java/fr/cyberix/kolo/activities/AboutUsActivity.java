package fr.cyberix.kolo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import fr.cyberix.kolo.R;
import fr.cyberix.kolo.helpers.KoloHelper;

public class AboutUsActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about_us);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		KoloHelper.setActivity(this);
	}
}
