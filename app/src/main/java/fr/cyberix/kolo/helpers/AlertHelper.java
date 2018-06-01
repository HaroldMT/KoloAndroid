/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package fr.cyberix.kolo.helpers;

import android.app.AlertDialog;
import android.content.Context;

import fr.cyberix.kolo.R;

/**
 * Created by tmhar on 9/13/2017.
 */

public class AlertHelper {
    public static void ShowAlert(Context context, String title, String message) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        AlertDialog alert = dialog.create();
        alert.setTitle(title);
        alert.setMessage(message);
        //  Ok button click task
        alert.show();
    }

    public static boolean ShowAlert(Context context, String title, String message, String okText, String cancelText) {
        boolean result = false;
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        AlertDialog alert = dialog.create();
        alert.setTitle("Title");
        alert.setMessage("Complex Alert");
        alert.setIcon(R.drawable.ic_portrait_black_48dp);
        result = true;
        alert.show();
        return result;
    }
}
