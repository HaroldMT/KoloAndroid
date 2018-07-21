/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package fr.cyberix.kolo.helpers;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public abstract class PermissionHelper {
	private static final int MY_PERMISSIONS_REQUEST_CODE = 123;
	
	public static boolean verifyPermissions(int[] grantResults) {
		// At least one result must be checked.
		if (grantResults.length < 1) {
			return false;
		}
		
		// Verify that each required permission has been granted, otherwise return false.
		for (int result : grantResults) {
			if (result != PackageManager.PERMISSION_GRANTED) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean checkPermissions(final Context mContext, final AppCompatActivity
			mActivity) {
		if (android.support.v4.content.ContextCompat.checkSelfPermission(mActivity, Manifest.permission.SEND_SMS)
				+ ContextCompat.checkSelfPermission(mActivity, Manifest.permission.READ_SMS)
				+ ContextCompat.checkSelfPermission(mActivity, Manifest.permission.RECEIVE_SMS)
				+ ContextCompat.checkSelfPermission(mActivity, Manifest.permission.READ_CONTACTS)
				+ ContextCompat.checkSelfPermission(mActivity, Manifest.permission.READ_PHONE_STATE)
				+ ContextCompat.checkSelfPermission(mActivity, Manifest.permission.INTERNET)
				+ ContextCompat.checkSelfPermission(mActivity, Manifest.permission.WRITE_CONTACTS)
				+ ContextCompat.checkSelfPermission(mActivity, Manifest.permission.ACCESS_COARSE_LOCATION)
				+ ContextCompat.checkSelfPermission(mActivity, Manifest.permission.ACCESS_FINE_LOCATION)
				+ ContextCompat.checkSelfPermission(mActivity, Manifest.permission.SEND_SMS)
				!= PackageManager.PERMISSION_GRANTED) {
			
			// Do something, when permissions not granted
			if (ActivityCompat.shouldShowRequestPermissionRationale(
					mActivity, Manifest.permission.SEND_SMS)
					|| ActivityCompat.shouldShowRequestPermissionRationale(
					mActivity, Manifest.permission.RECEIVE_SMS)
					|| ActivityCompat.shouldShowRequestPermissionRationale(
					mActivity, Manifest.permission.READ_SMS)
					|| ActivityCompat.shouldShowRequestPermissionRationale(
					mActivity, Manifest.permission.READ_CONTACTS)
					|| ActivityCompat.shouldShowRequestPermissionRationale(
					mActivity, Manifest.permission.INTERNET)
					|| ActivityCompat.shouldShowRequestPermissionRationale(
					mActivity, Manifest.permission.READ_PHONE_STATE)
					|| ActivityCompat.shouldShowRequestPermissionRationale(
					mActivity, Manifest.permission.WRITE_CONTACTS)
					|| ActivityCompat.shouldShowRequestPermissionRationale(
					mActivity, Manifest.permission.ACCESS_COARSE_LOCATION)
					|| ActivityCompat.shouldShowRequestPermissionRationale(
					mActivity, Manifest.permission.ACCESS_FINE_LOCATION)) {
				// If we should give explanation of requested permissions
				
				// Show an alert dialog here with request explanation
				AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
				builder.setMessage("Contacts permissions" +
						                   " SMS Permissions are required to access kolo App.");
				builder.setTitle("Please grant those permissions");
				builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						ActivityCompat.requestPermissions(
								mActivity,
								new String[]{
										Manifest.permission.SEND_SMS,
										Manifest.permission.RECEIVE_SMS,
										Manifest.permission.READ_SMS,
										Manifest.permission.READ_CONTACTS,
										Manifest.permission.INTERNET,
										Manifest.permission.READ_PHONE_STATE,
										Manifest.permission.WRITE_CONTACTS,
										Manifest.permission.ACCESS_COARSE_LOCATION,
										Manifest.permission.ACCESS_FINE_LOCATION,
								},
								MY_PERMISSIONS_REQUEST_CODE
						                                 );
					}
				});
				builder.setNeutralButton("Cancel", null);
				AlertDialog dialog = builder.create();
				dialog.show();
			} else {
				// Directly request for required permissions, without explanation
				ActivityCompat.requestPermissions(
						mActivity,
						new String[]{
								Manifest.permission.SEND_SMS,
								Manifest.permission.RECEIVE_SMS,
								Manifest.permission.READ_SMS,
								Manifest.permission.READ_CONTACTS,
								Manifest.permission.INTERNET,
								Manifest.permission.READ_PHONE_STATE,
								Manifest.permission.WRITE_CONTACTS,
								Manifest.permission.ACCESS_COARSE_LOCATION,
								Manifest.permission.ACCESS_FINE_LOCATION,
						},
						MY_PERMISSIONS_REQUEST_CODE
				                                 );
			}
		} else {
			// Do something, when permissions are already granted
			android.widget.Toast.makeText(mContext, "Permissions already granted", android.widget.Toast.LENGTH_SHORT).show();
		}
		return false;
	}
	
	public static void checkPermissions() {
		String[] myPermissions = new String[]{
				Manifest.permission.SEND_SMS,
				Manifest.permission.RECEIVE_SMS,
				Manifest.permission.READ_SMS,
				Manifest.permission.READ_CONTACTS,
				Manifest.permission.INTERNET,
		};
		if (ContextCompat.checkSelfPermission(KoloHelper.getMyActivity(), Manifest.permission.SEND_SMS)
				+ ContextCompat.checkSelfPermission(
				KoloHelper.getMyActivity(), Manifest.permission.READ_SMS)
				+ ContextCompat.checkSelfPermission(
				KoloHelper.getMyActivity(), Manifest.permission.RECEIVE_SMS)
				+ ContextCompat.checkSelfPermission(
				KoloHelper.getMyActivity(), Manifest.permission.READ_CONTACTS)
				+ ContextCompat.checkSelfPermission(
				KoloHelper.getMyActivity(), Manifest.permission.INTERNET)
				!= PackageManager.PERMISSION_GRANTED) {
			
			// Do something, when permissions not granted
			if (ActivityCompat.shouldShowRequestPermissionRationale(
					KoloHelper.getMyActivity(), Manifest.permission.SEND_SMS)
					|| ActivityCompat.shouldShowRequestPermissionRationale(
					KoloHelper.getMyActivity(), Manifest.permission.RECEIVE_SMS)
					|| ActivityCompat.shouldShowRequestPermissionRationale(
					KoloHelper.getMyActivity(), Manifest.permission.READ_SMS)
					|| ActivityCompat.shouldShowRequestPermissionRationale(
					KoloHelper.getMyActivity(), Manifest.permission.READ_CONTACTS)
					|| ActivityCompat.shouldShowRequestPermissionRationale(
					KoloHelper.getMyActivity(), Manifest.permission.INTERNET)) {
				// If we should give explanation of requested permissions
				
				// Show an alert dialog here with request explanation
				android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(KoloHelper.getMyActivity());
				builder.setMessage("Contacts permissions" +
						                   " SMS Permissions are required to access kolo App.");
				builder.setTitle("Please grant those permissions");
				builder.setPositiveButton("OK", (dialogInterface, i) -> ActivityCompat.requestPermissions(
						KoloHelper.getMyActivity(), myPermissions, MY_PERMISSIONS_REQUEST_CODE));
				builder.setNeutralButton("Cancel", null);
				android.app.AlertDialog dialog = builder.create();
				dialog.show();
			} else {
				// Directly request for required permissions, without explanation
				ActivityCompat.requestPermissions(
						KoloHelper.getMyActivity(), myPermissions, MY_PERMISSIONS_REQUEST_CODE);
			}
		} else {
			// Do something, when permissions are already granted
			Toast.makeText(KoloHelper.getMyContext(), "Permissions already granted", Toast.LENGTH_SHORT).show();
		}
	}
}
