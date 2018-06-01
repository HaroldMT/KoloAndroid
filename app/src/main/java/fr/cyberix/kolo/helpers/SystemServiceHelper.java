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
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Telephony;
import android.support.v4.app.ActivityCompat;
import android.telecom.TelecomManager;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import fr.cyberix.kolo.model.TelephonyInfo;

public class SystemServiceHelper {
    private static boolean initialized;
    private static TelecomManager telecomManager;
    private static TelephonyManager telManager;
    private static LocationManager locationManager;
    private static Location loc;
    private final int MAX_SMS_MESSAGE_LENGTH = 160;
    private final int SMS_PORT = 8901;
    private final String SMS_DELIVERED = "SMS_DELIVERED";
    private final String SMS_SENT = "SMS_SENT";

    public static boolean isInitialized() {
        return initialized;
    }

    public static void setInitialized(boolean initialized) {
        SystemServiceHelper.initialized = initialized;
    }

    public static TelephonyInfo getInfos() {
        return TelephonyInfo.getNewInstance(KoloHelper.getMyContextWrapper(), telManager);
    }

    public static void initialize(ContextWrapper context) {
        initialized = false;
        telManager = (TelephonyManager) KoloHelper.getMyContextWrapper().getSystemService(Context.TELEPHONY_SERVICE);
        telecomManager = (TelecomManager) KoloHelper.getMyContextWrapper().getSystemService(Context.TELECOM_SERVICE);
        locationManager = (LocationManager) KoloHelper.getMyContextWrapper().getSystemService(Context.LOCATION_SERVICE);
        initialized = true;
    }

    public static Location getLocation() {
        // to Find the Location
        MyLocation.LocationResult locationResult = new MyLocation.LocationResult() {
            @Override
            public void gotLocation(final Location location) {
                loc = location;
            }
        };

        MyLocation myLocation = new MyLocation();
        myLocation.getLocation(KoloHelper.getMyContextWrapper(), locationResult);
        return loc;
    }

    public static Location getLocation2() {
        Location location = null;
        Criteria criteria = new Criteria();
        String bestProvider = locationManager.getBestProvider(criteria, false);
        if (ActivityCompat.checkSelfPermission(KoloHelper.getMyContextWrapper(),
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(KoloHelper.getMyContextWrapper(),
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            location = locationManager.getLastKnownLocation(bestProvider);
        }
        return location;
    }

    public static void locationGetter() {
        LocationManager lm = (LocationManager) KoloHelper.getMyContextWrapper().getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(KoloHelper.getMyContextWrapper(), Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(KoloHelper.getMyContextWrapper(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        if (location != null) {
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
        }
    }

    public static void sendSms2(String phonenumber, String message) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            SmsManager.getSmsManagerForSubscriptionId(0).sendTextMessage(phonenumber, null, message, null, null);
            SmsManager.getSmsManagerForSubscriptionId(1).sendTextMessage(phonenumber, null, message, null, null);
            SmsManager.getSmsManagerForSubscriptionId(2).sendTextMessage(phonenumber, null, message, null, null);
        } else {
            Toast toast = Toast.makeText(KoloHelper.getMyContextWrapper(), "Cannot generate sms, this is an old android version", Toast.LENGTH_LONG);
        }
    }

    public static void sendSms(String phonenumber, String message) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) // At least KitKat
        {
            String defaultSmsPackageName = Telephony.Sms.getDefaultSmsPackage(KoloHelper.getMyContextWrapper()); // Need to change the build to API 19

            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.setType("text/plain");
            sendIntent.putExtra(Intent.EXTRA_TEXT, message);

            if (defaultSmsPackageName != null)// Can be null in case that there is no default, then the user would be able to choose
            // any app that support this intent.
            {
                sendIntent.setPackage(defaultSmsPackageName);
            }
            KoloHelper.getMyContextWrapper().startActivity(sendIntent);

        } else // For early versions, do what worked for you before.
        {
            Intent smsIntent = new Intent(android.content.Intent.ACTION_VIEW);
            smsIntent.setType("vnd.android-dir/mms-sms");
            smsIntent.putExtra("address", phonenumber);
            smsIntent.putExtra("sms_body", message);
            KoloHelper.getMyContextWrapper().startActivity(smsIntent);
        }
    }

    public static void SendSmsIntent(String destinationAddress, String text) {
        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse(destinationAddress));
        smsIntent.putExtra("sms_body", text);
        KoloHelper.getMyContextWrapper().startActivity(smsIntent);
    }
}
