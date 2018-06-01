/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package fr.cyberix.kolo.helpers;

import android.util.Log;

import fr.cyberix.kolo.model.AccountInfo;
import fr.cyberix.kolo.model.ParameterInfo;

public class ConfigHelper {
    private static AccountInfo accountInfo = new AccountInfo();
    private static ParameterInfo parameterInfo = new ParameterInfo();

    public static AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public static void setAccountInfo(AccountInfo accountInfo) {
        ConfigHelper.accountInfo = accountInfo;
    }

    public static boolean resetConfig() {
        boolean result = false;
        try {
            accountInfo = new AccountInfo();
            saveConfig();
        } catch (Exception ignored) {
        }
        return result;
    }

    public static void saveConfig() {
        final boolean result = false;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    String configString = SerializationHelper.toJson(accountInfo, AccountInfo.class);
                    StorageHelper.writeFileInternal(KoloConstants.ConfigFileName, configString, false);
                } catch (Exception ignored) {

                }
            }
        };
        new Thread(runnable).start();
    }

    public static ParameterInfo getParameterInfo() {
        return parameterInfo;
    }

    public static void setParameterInfo(ParameterInfo paramInfo) {
        parameterInfo = paramInfo;
    }

    public static boolean initialize() {
        return initializeParameters() & initializeConfig();
    }

    public static boolean initializeParameters() {
        boolean result = false;
        try {
            String configString = StorageHelper.readFileInternal(KoloConstants.ParamFileName);
            if (((configString != null) ? configString.length() : 0) > 0) {
                ParameterInfo parameterInfo1 = SerializationHelper.fromJson(configString, ParameterInfo.class);
                parameterInfo = parameterInfo1 != null ? parameterInfo1 : new ParameterInfo();
                result = true;
            } else parameterInfo = new ParameterInfo();
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
        return result;
    }

    public static boolean initializeConfig() {
        boolean result = false;
        try {
            String configString = StorageHelper.readFileInternal(KoloConstants.ConfigFileName);
            if (((configString != null) ? configString.length() : 0) > 0) {
                AccountInfo accountInfo1 = SerializationHelper.fromJson(configString, AccountInfo.class);
                accountInfo = accountInfo1 != null ? accountInfo1 : new AccountInfo();
                result = true;
            } else accountInfo = new AccountInfo();
//            if (accountInfo.getRegistration().getIdRegistration() > 0) {
//                accountInfo.setCustomer(ServiceHelper.getCustomer(accountInfo.getRegistration()));
//            }
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
        return result;
    }

    public static boolean getRegistered() {
        boolean result = (accountInfo != null) ? accountInfo.getRegistered() : false;
        return result;
    }

    public static boolean getRegistering() {
        boolean result = (accountInfo != null) ? accountInfo.getRegistering() : false;
        return result;
    }

    public static void resetParameters() {
        boolean result = false;
        try {
            parameterInfo = new ParameterInfo();
            saveParameters();
        } catch (Exception ignored) {
            Log.e("resetParameters", ignored.getMessage());
        }
    }

    public static void saveParameters() {
        boolean result = false;
        try {
            String configString = SerializationHelper.toJson(parameterInfo, ParameterInfo.class);
            StorageHelper.writeFileInternal(KoloConstants.ParamFileName, configString, false);
            result = true;
        } catch (Exception ignored) {

        }
    }

    public static void save() {
        saveConfig();
        saveParameters();
    }

    public static boolean hasParameters() {
        return parameterInfo.getCurrencyList().size() > 0;
    }
}
