package fr.cyberix.kolo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import fr.cyberix.kolo.R;
import fr.cyberix.kolo.helpers.KoloHelper;

public class KoloMadActivity extends AppCompatActivity {
	
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
}
