/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package fr.cyberix.kolo.helpers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.google.gson.GsonBuilder;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class SerializationHelper {
    private static final Charset UTF8_CHARSET = Charset.forName("UTF-8");

    public static <T> String toJson(Object source, Class<T> typeOfSrc) {
        return source == null ? "" :
                new GsonBuilder().create().toJson(source, typeOfSrc);
    }

    public static <T> T fromJson(String jsonValue, Class<T> typeOfSrc) {
        return ((jsonValue == null) | (jsonValue.length() == 0)) ? null :
                new GsonBuilder().create().fromJson(jsonValue, typeOfSrc);
    }

    public static Bitmap bytesToBitmap(byte[] imageBytes) {
        try {
            Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
            return bitmap;
        } catch (Exception ex) {
            return null;
        }
    }

    public static String HashPassword(String password) {
        String hashedPwd = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] pwdBytes = encodeUTF8(password);
            byte[] bytes = md.digest(pwdBytes);
            hashedPwd = decodeUTF8(bytes);
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