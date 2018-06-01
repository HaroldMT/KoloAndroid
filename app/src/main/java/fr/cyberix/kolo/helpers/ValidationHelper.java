/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package fr.cyberix.kolo.helpers;

import android.util.Patterns;

public class ValidationHelper {
    private static final String NAME_REGEX = "^[A-Za-z]+$";
    //    private static final String PWD_REGEX = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$";
    private static final String PWD_REGEX = "^(?=.*\\d).{4,8}$";

    public static boolean isValidPhone(String phone) {
        return phone.isEmpty() || Patterns.PHONE.matcher(phone).matches();
    }

    public static boolean isValidEmail(String email) {
        return email.isEmpty() || android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isValidName(String name) {
        return name.isEmpty() || name.matches(NAME_REGEX);
    }

    public static boolean isValidPassword(String password) {
        return password.isEmpty() || password.matches(PWD_REGEX);
    }

    public static boolean isValidRegistrationCode(String code) {
        return code.isEmpty() || code.length() >= 4;
    }

    public static boolean isValidOperationDate(String date) {
        return true;
    }

    public static boolean isValidDateOfBirth(String date) {
        return true;
    }
}
