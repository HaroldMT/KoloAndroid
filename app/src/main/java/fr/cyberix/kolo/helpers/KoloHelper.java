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
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.text.DateFormat;

import fr.cyberix.kolo.R;

import static fr.cyberix.kolo.helpers.KoloConstants.MY_PERMISSIONS_REQUEST_CODE;
import static fr.cyberix.kolo.helpers.KoloConstants.UTF8_CHARSET;

public class KoloHelper {
	
	public static android.support.v7.app.AlertDialog.Builder MyAlertBuilder;
	private static AppCompatActivity myActivity;
	private static ContextWrapper myContextWrapper;
	private static ProgressBar progressBar;
	private static Context myContext;
	private static Handler mHandler;
	
	public static ContextWrapper getMyContextWrapper() {
		return myContextWrapper;
	}
	
	public static void setMyContextWrapper(ContextWrapper myContextWrapper) {
		KoloHelper.myContextWrapper = myContextWrapper;
	}
	
	public static Context getMyContext() {
		return myContext;
	}
	
	public static void setMyContext(Context context) {
		myContext = context;
	}
	
	public static boolean initialize(AppCompatActivity activity, Context context, ContextWrapper
			contextWrapper) {
		mHandler = new android.os.Handler();
		setActivity(activity);
		SystemServiceHelper.initialize(activity);
		getSimInfo();
		return ConfigHelper.initialize();
	}
	
	public static void setActivity(AppCompatActivity activity) {
		myActivity = activity;
		myContext = activity;
		myContextWrapper = activity;
		MyAlertBuilder = new android.support.v7.app.AlertDialog.Builder(myActivity);
		SystemServiceHelper.initialize(activity);
	}
	
	public static void getSimInfo() {
		try {
			ConfigHelper.getAccountInfo().setTelInfo(SystemServiceHelper.getInfos());
		} catch (Exception ex) {
			ex.printStackTrace();
			String err = ex.getMessage();
			KoloHelper.ShowToast(err);
		}
	}
	
	// public static void Show
	public static void ShowToast(String notificationText) {
		Toast.makeText(myActivity, notificationText, Toast.LENGTH_SHORT).show();
	}
	
	public static DateFormat getDateFormat() {
		DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(myContext);
		return dateFormat;
	}
	
	public static void SendActivationSms(String phoneNumber) {
		if (!ValidationHelper.isValidPhone(phoneNumber)) {
			KoloHelper.ShowSimpleAlert("Opération impossible", "Le numéro de téléphone saisit n\'est pas valide");
			return;
		}
		
		SystemServiceHelper.sendSms(phoneNumber, "Activation SMS by SmsManager");
		SystemServiceHelper.SendSmsIntent(phoneNumber, "Activation SMS by Intent");
		KoloHelper.ShowToast("Le message d\'activation a été envoyé, veuillez patienter");
	}
	
	public static void ShowSimpleAlert(String title, String alert) {
		AlertDialog dialog = MyAlertBuilder.create();
		dialog.setTitle(title);
		dialog.setMessage(alert);
		dialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", (DialogInterface.OnClickListener) null);
		dialog.show();
	}
	
	public static void ShowProgressBar() {
		progressBar = new ProgressBar(myActivity);
		progressBar.setIndeterminate(true);
		progressBar.setVisibility(View.VISIBLE);
	}
	
	public static void HideProgressBar() {
		if (progressBar != null)
			progressBar.setVisibility(View.INVISIBLE);
	}
	
	private static byte[] encodeUTF8(String string) {
		return string.getBytes(UTF8_CHARSET);
	}
	
	private static String decodeUTF8(byte[] bytes) {
		return new String(bytes, UTF8_CHARSET);
	}
	
	public static <T> void startActivity(Class<T> activityClass) {
		Intent intent = new Intent(myActivity, activityClass);
		myActivity.startActivity(intent);
	}
	
	public static Toolbar setSupportActionBar(int resourceId, boolean displayHomeAsUp, boolean displayShowHome) {
		Toolbar toolbar = myActivity.findViewById(resourceId);
		myActivity.setSupportActionBar(toolbar);
		if (myActivity.getSupportActionBar() != null) {
			myActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(displayHomeAsUp);
			myActivity.getSupportActionBar().setDisplayShowHomeEnabled(displayShowHome);
		}
		return toolbar;
	}
	
	protected String showInputDialog() {
		AppCompatActivity activity = getMyActivity();
		final String userEntry = "";
		// get prompts.xml view
		LayoutInflater layoutInflater = LayoutInflater.from(activity);
		View promptView = layoutInflater.inflate(R.layout.input_layout, null);
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
		alertDialogBuilder.setView(promptView);
		
		final TextInputEditText editText = promptView.findViewById(R.id.txt_user_input);
		// setup a dialog window
		alertDialogBuilder.setCancelable(false)
		                  .setPositiveButton("OK", new DialogInterface.OnClickListener() {
			                  public void onClick(DialogInterface dialog, int id) {
				                  String tmpUserEntry = editText.getText().toString();
//                                  userEntry = tmpUserEntry;
			                  }
		                  })
		                  .setNegativeButton("Cancel",
		                                     new DialogInterface.OnClickListener() {
			                                     public void onClick(DialogInterface dialog, int id) {
				                                     dialog.cancel();
			                                     }
		                                     });
		
		// create an alert dialog
		AlertDialog alert = alertDialogBuilder.create();
		alert.show();
		return userEntry;
	}
	
	public static AppCompatActivity getMyActivity() {
		return myActivity;
	}
	
	public static void checkPermissions() {
		String[] myPermissions = new String[]{
				Manifest.permission.SEND_SMS,
				Manifest.permission.RECEIVE_SMS,
				Manifest.permission.READ_SMS,
				Manifest.permission.READ_CONTACTS,
				Manifest.permission.INTERNET,
		};
		if (ContextCompat.checkSelfPermission(myActivity, Manifest.permission.SEND_SMS)
				+ ContextCompat.checkSelfPermission(
				myActivity, Manifest.permission.READ_SMS)
				+ ContextCompat.checkSelfPermission(
				myActivity, Manifest.permission.RECEIVE_SMS)
				+ ContextCompat.checkSelfPermission(
				myActivity, Manifest.permission.READ_CONTACTS)
				+ ContextCompat.checkSelfPermission(
				myActivity, Manifest.permission.INTERNET)
				!= PackageManager.PERMISSION_GRANTED) {
			
			// Do something, when permissions not granted
			if (ActivityCompat.shouldShowRequestPermissionRationale(
					myActivity, Manifest.permission.SEND_SMS)
					|| ActivityCompat.shouldShowRequestPermissionRationale(
					myActivity, Manifest.permission.RECEIVE_SMS)
					|| ActivityCompat.shouldShowRequestPermissionRationale(
					myActivity, Manifest.permission.READ_SMS)
					|| ActivityCompat.shouldShowRequestPermissionRationale(
					myActivity, Manifest.permission.READ_CONTACTS)
					|| ActivityCompat.shouldShowRequestPermissionRationale(
					myActivity, Manifest.permission.INTERNET)) {
				// If we should give explanation of requested permissions
				
				// Show an alert dialog here with request explanation
				android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(myActivity);
				builder.setMessage("Contacts permissions" +
						                   " SMS Permissions are required to access kolo App.");
				builder.setTitle("Please grant those permissions");
				builder.setPositiveButton("OK", (dialogInterface, i) -> ActivityCompat.requestPermissions(
						myActivity, myPermissions, MY_PERMISSIONS_REQUEST_CODE));
				builder.setNeutralButton("Cancel", null);
				android.app.AlertDialog dialog = builder.create();
				dialog.show();
			} else {
				// Directly request for required permissions, without explanation
				ActivityCompat.requestPermissions(
						myActivity, myPermissions, MY_PERMISSIONS_REQUEST_CODE);
			}
		} else {
			// Do something, when permissions are already granted
			Toast.makeText(myContext, "Permissions already granted", Toast.LENGTH_SHORT).show();
		}
	}
}
