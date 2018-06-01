/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package fr.cyberix.kolo.helpers;

import android.content.Context;
import android.content.ContextWrapper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;

import static fr.cyberix.kolo.helpers.KoloConstants.UTF8_CHARSET;

public class KoloHelper {

    public static android.support.v7.app.AlertDialog.Builder MyAlertBuilder;
    private static AppCompatActivity myActivity;
    private static ContextWrapper myContextWrapper;
    private static ProgressBar progressBar;
    private static Context myContext;

    public static AppCompatActivity getMyActivity() {
        return myActivity;
    }

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

//        SystemServiceHelper.SendSms(phoneNumber, "Activation SMS by SmsManager");
        // TelephonyHelper.SendSmsIntent(phoneNumber, "Activation SMS by Intent");
        KoloHelper.ShowToast("Le message d\'activation a été envoyé, veuillez patienter");
    }

    public static void ShowSimpleAlert(String title, String alert) {
        android.support.v7.app.AlertDialog dialog = MyAlertBuilder.create();
        dialog.setTitle(title);
        dialog.setMessage(alert);
        dialog.show();
        // dialog.setButton("OK", (c, ev) =>
        // {
        //     // Ok button click task
        // });
    }

    public static void ShowNotification(String title, String text) {
//        //  Instantiate the builder and set notification elements:
//        Notification.Builder builder = (new Notification.Builder(myActivity) + setContentTitle(title).setContentText(text).setSmallIcon(Resource.Drawable.Icon));
//        //  Build the notification:
//        Notification notification = builder.Build();
//        //  Get the notification manager:
//        NotificationManager notificationManager = ((NotificationManager)(myContextWrapper.getSystemService(Context.NOTIFICATION_SERVICE)));
//        //  Publish the notification:
//            const int notificationId = 0;
//        notificationManager.Notify(notificationId, notification);
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

    public String get_SHA_512_SecurePassword(String passwordToHash, String salt) {
        String generatedPassword = null;
        String hashedPwd = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] pwdBytes = encodeUTF8(passwordToHash);
//            md.update(salt.getBytes("UTF-8"));
            byte[] bytes = md.digest(pwdBytes);
//            StringBuilder sb = new StringBuilder();
            hashedPwd = decodeUTF8(bytes);
//            for(int i=0; i< bytes.length ;i++){
//                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
//            }
//            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashedPwd;
    }

    private static byte[] encodeUTF8(String string) {
        return string.getBytes(UTF8_CHARSET);
    }

    private static String decodeUTF8(byte[] bytes) {
        return new String(bytes, UTF8_CHARSET);
    }
}
