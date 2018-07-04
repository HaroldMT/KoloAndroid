package fr.cyberix.kolo.other;

import android.Manifest;
import android.os.Bundle;
import android.widget.Toast;

import fr.cyberix.kolo.R;
import fr.cyberix.kolo.activities.AbsRuntimePermission;

public class Permission extends AbsRuntimePermission {
	private static final int REQUEST_PERMISSION = 10;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_kolo_main);
		
		requestAppPermissions(new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS, Manifest.permission.SEND_SMS, Manifest
				                      .permission.WRITE_CONTACTS,
				                      Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS, Manifest.permission.INTERNET},
		                      R.string.msg, REQUEST_PERMISSION);
	}
	
	@Override
	public void onPermissionsGranted(int requestCode) {
		Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_SHORT).show();
	}
}
