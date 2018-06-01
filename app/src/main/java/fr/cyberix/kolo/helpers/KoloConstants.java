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
    //    public static final String BaseUrl = "http://192.168.7.100/api/";
    public static final String BaseUrl = "http://192.168.43.149/";
    //    public static final String BaseUrl = "http://192.168.1.15/";
    public static final int forceLoginAfterShutdownTimeLimit = 5;
}
