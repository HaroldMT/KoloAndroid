/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package fr.cyberix.kolo.helpers;

import java.nio.charset.Charset;

/**
 * Created by tmhar on 9/16/2017.
 */

public final class KoloConstants {
    public static final String ConfigFileName = "config.frs";
    //    public static final String ForeasDefaultFolderName = "Foreas";
    public static final String ParamFileName = "refTypeHelper.frs";
    public static final Charset UTF8_CHARSET = Charset.forName("UTF-8");
	public static final String ngrokId = "c2020ebb";
	public static final String BaseUrl = "http://" + ngrokId + ".ngrok.io/KoloWin.CustomerService/";
    public static final int forceLoginAfterShutdownTimeLimit = 5;
    public static final String REGISTRATION_STATUS_NONE = "NONE";
    public static final String REGISTRATION_STATUS_CANCEL = "CANCEL";
    public static final String REGISTRATION_STATUS_COMPLETED = "COMPLETED";
    public static final String REGISTRATION_STATUS_DELETED = "DELETED";
    public static final String REGISTRATION_STATUS_NEEDCONFIRM = "NEEDCONFIRM";
    public static final String REFSTATUS_RESULT_NONE = "NONE";
    public static final String REFSTATUS_RESULT_FAIL = "FAIL";
    public static final String REFSTATUS_RESULT_SUCCESS = "SUCCESS";
    public static final String KolOthenticor_BaseUrl = BaseUrl+"KolOthenticor.asmx";
    public static final String KolOSphere_BaseUrl = BaseUrl+"KolOSphere.asmx";
    public static final String KolOPartVice_BaseUrl = BaseUrl + "KolOPartVice.asmx";
    public static final String KolOMobileService_BaseUrl = BaseUrl + "MobileService.asmx";

    public static final  String DATE_FORMAT_FOR_SERVICE = "yyyy-MM-dd hh:mm:ss";
    public static final int QR_SCAN_REQUEST_CODE = 100;
    public static final int PICK_CONTACT_REQUEST_CODE = 101;
}
