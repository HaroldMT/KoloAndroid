/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package fr.cyberix.kolo.model;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public final class TelephonyInfo {
	private String deviceId;
	private String deviceSoftwareVersion;
	private boolean simReady;
	private boolean isSmsCapable;
	private String line1Number;
	private String mmsUAProfUrl;
	private String mmsUserAgent;
	private String networkCountryIso;
	private String networkOperator;
	private String networkOperatorName;
	private String simCountryIso;
	private String networkType;
	private String phoneType;
	private String simOperator;
	private String simOperatorName;
	private String simSerialNumber;
	private String subscriberId;
	
	public static TelephonyInfo getNewInstance(Context context, TelephonyManager telephonyManager) {
		TelephonyInfo telInfo = new TelephonyInfo();
		try {
			telInfo.deviceId = telephonyManager.getDeviceId();
			telInfo.deviceSoftwareVersion = telephonyManager.getDeviceSoftwareVersion();
			telInfo.isSmsCapable = isSimSupport(context);
			telInfo.networkCountryIso = telephonyManager.getNetworkCountryIso();
			telInfo.networkOperator = telephonyManager.getNetworkOperator();
			telInfo.networkOperatorName = telephonyManager.getNetworkOperatorName();
			telInfo.networkType = getNetworkType(telephonyManager.getNetworkType());
			telInfo.phoneType = getPhoneType(telephonyManager.getPhoneType());
			telInfo.simCountryIso = telephonyManager.getSimCountryIso();
			telInfo.simOperator = telephonyManager.getSimOperator();
			telInfo.simOperatorName = telephonyManager.getSimOperatorName();
			telInfo.simSerialNumber = telephonyManager.getSimSerialNumber();
			telInfo.simReady = isSimStateReadyorNotReady();
			telInfo.subscriberId = telephonyManager.getSubscriberId();
		} catch (SecurityException e) {
			e.printStackTrace();
			Toast.makeText(context, "Please Give All required permission to Read phone state", Toast.LENGTH_LONG);
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(context, "Could not get moile phone details", Toast.LENGTH_LONG);
		}
		return telInfo;
	}
	
	public static boolean isSimSupport(Context context) {
		TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);  //gets the current TelephonyManager
		return !(tm.getSimState() == TelephonyManager.SIM_STATE_ABSENT);
		
	}
	
	private static String getNetworkType(int type) {
		String result = "";
		
		switch (type) {
			case TelephonyManager.NETWORK_TYPE_1xRTT:
				result = "1xRTT";
				break;
			case TelephonyManager.NETWORK_TYPE_CDMA:
				result = "CDMA";
				break;
			case TelephonyManager.NETWORK_TYPE_EDGE:
				result = "EDGE";
				break;
			case TelephonyManager.NETWORK_TYPE_EHRPD:
				result = "EHRPD";
				break;
			case TelephonyManager.NETWORK_TYPE_EVDO_0:
				result = "EVDO_0";
				break;
			case TelephonyManager.NETWORK_TYPE_EVDO_A:
				result = "EVDO_A";
				break;
			case TelephonyManager.NETWORK_TYPE_EVDO_B:
				result = "EVDO_B";
				break;
			case TelephonyManager.NETWORK_TYPE_GPRS:
				result = "GPRS";
				break;
			case TelephonyManager.NETWORK_TYPE_HSDPA:
				result = "HSDPA";
				break;
			case TelephonyManager.NETWORK_TYPE_HSPA:
				result = "HSPA";
				break;
			case TelephonyManager.NETWORK_TYPE_HSPAP:
				result = "HSPAP";
				break;
			case TelephonyManager.NETWORK_TYPE_HSUPA:
				result = "HSUPA";
				break;
			case TelephonyManager.NETWORK_TYPE_IDEN:
				result = "IDEN";
				break;
			case TelephonyManager.NETWORK_TYPE_LTE:
				result = "LTE";
				break;
			case TelephonyManager.NETWORK_TYPE_UMTS:
				result = "UMTS";
				break;
			case TelephonyManager.NETWORK_TYPE_UNKNOWN:
				result = "UNKNOWN";
				break;
			default:
				result = "unknown type";
		}
		return result;
	}
	
	private static String getPhoneType(int type) {
		String result = "";
		
		switch (type) {
			case TelephonyManager.PHONE_TYPE_CDMA:
				result = "CDMA";
				break;
			case TelephonyManager.PHONE_TYPE_GSM:
				result = "GSM";
				break;
			case TelephonyManager.PHONE_TYPE_NONE:
				result = "NONE";
				break;
			case TelephonyManager.PHONE_TYPE_SIP:
				result = "SLIP";
				break;
			default:
				result = "unknown type";
		}
		return result;
	}
	
	public static boolean isSimStateReadyorNotReady() {
//        int simSlotCount = sSlotCount;
//        String simStates = SystemProperties.get("gsm.sim.state", "");
//        if (simStates != null) {
//            String[] slotState = simStates.split(",");
//            int simSlot = 0;
//            while (simSlot < simSlotCount && slotState.length > simSlot) {
//                String simSlotState = slotState[simSlot];
//                Log.d("MultiSimUtils", "isSimStateReadyorNotReady() : simSlot = " + simSlot + ", simState = " + simSlotState);
//                if (simSlotState.equalsIgnoreCase("READY") || simSlotState.equalsIgnoreCase("NOT_READY")) {
//                    return true;
//                }
//                simSlot++;
//            }
//        }
//        return false;
		return true;
	}
	
	public static String getDeviceName() {
		String manufacturer = Build.MANUFACTURER;
		String model = Build.MODEL;
		if (model.startsWith(manufacturer)) {
			return model.toUpperCase();
		}
		return manufacturer.toUpperCase() + " " + model;
	}
	
	public static String getNetworkType2(Context context) {
		TelephonyManager mTelephonyManager = (TelephonyManager)
				context.getSystemService(Context.TELEPHONY_SERVICE);
		int networkType = mTelephonyManager.getNetworkType();
		switch (networkType) {
			case TelephonyManager.NETWORK_TYPE_GPRS:
			case TelephonyManager.NETWORK_TYPE_EDGE:
			case TelephonyManager.NETWORK_TYPE_CDMA:
			case TelephonyManager.NETWORK_TYPE_1xRTT:
			case TelephonyManager.NETWORK_TYPE_IDEN:
				return "2g";
			case TelephonyManager.NETWORK_TYPE_UMTS:
			case TelephonyManager.NETWORK_TYPE_EVDO_0:
			case TelephonyManager.NETWORK_TYPE_EVDO_A:
				/**
				 From this link https://goo.gl/R2HOjR ..NETWORK_TYPE_EVDO_0 & NETWORK_TYPE_EVDO_A
				 EV-DO is an evolution of the CDMA2000 (IS-2000) standard that supports high data rates.
				 
				 Where CDMA2000 https://goo.gl/1y10WI .CDMA2000 is a family of 3G[1] mobile technology standards for sending voice,
				 data, and signaling data between mobile phones and cell sites.
				 */
			case TelephonyManager.NETWORK_TYPE_HSDPA:
			case TelephonyManager.NETWORK_TYPE_HSUPA:
			case TelephonyManager.NETWORK_TYPE_HSPA:
			case TelephonyManager.NETWORK_TYPE_EVDO_B:
			case TelephonyManager.NETWORK_TYPE_EHRPD:
			case TelephonyManager.NETWORK_TYPE_HSPAP:
				//Log.d("Type", "3g");
				//For 3g HSDPA , HSPAP(HSPA+) are main  networktype which are under 3g Network
				//But from other constants also it will 3g like HSPA,HSDPA etc which are in 3g case.
				//Some cases are added after  testing(real) in device with 3g enable data
				//and speed also matters to decide 3g network type
				//http://goo.gl/bhtVT
				return "3g";
			case TelephonyManager.NETWORK_TYPE_LTE:
				//No specification for the 4g but from wiki
				//I found(LTE (Long-Term Evolution, commonly marketed as 4G LTE))
				//https://goo.gl/9t7yrR
				return "4g";
			default:
				return "Notfound";
		}
	}
	
	public boolean isSimReady() {
		return simReady;
	}
	
	public void setSimReady(boolean simReady) {
		this.simReady = simReady;
	}
	
	public String getDeviceId() {
		return deviceId;
	}
	
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	public String getDeviceSoftwareVersion() {
		return deviceSoftwareVersion;
	}
	
	public void setDeviceSoftwareVersion(String deviceSoftwareVersion) {
		this.deviceSoftwareVersion = deviceSoftwareVersion;
	}
	
	public boolean isSmsCapable() {
		return isSmsCapable;
	}
	
	public void setSmsCapable(boolean smsCapable) {
		isSmsCapable = smsCapable;
	}
	
	public String getLine1Number() {
		return line1Number;
	}
	
	public void setLine1Number(String line1Number) {
		this.line1Number = line1Number;
	}
	
	public String getMmsUAProfUrl() {
		return mmsUAProfUrl;
	}
	
	public void setMmsUAProfUrl(String mmsUAProfUrl) {
		this.mmsUAProfUrl = mmsUAProfUrl;
	}
	
	public String getMmsUserAgent() {
		return mmsUserAgent;
	}
	
	public void setMmsUserAgent(String mmsUserAgent) {
		this.mmsUserAgent = mmsUserAgent;
	}
	
	public String getNetworkCountryIso() {
		return networkCountryIso;
	}
	
	public void setNetworkCountryIso(String networkCountryIso) {
		this.networkCountryIso = networkCountryIso;
	}
	
	public String getNetworkOperator() {
		return networkOperator;
	}
	
	public void setNetworkOperator(String networkOperator) {
		this.networkOperator = networkOperator;
	}
	
	public String getNetworkOperatorName() {
		return networkOperatorName;
	}
	
	public void setNetworkOperatorName(String networkOperatorName) {
		this.networkOperatorName = networkOperatorName;
	}
	
	public String getSimCountryIso() {
		return simCountryIso;
	}
	
	public void setSimCountryIso(String simCountryIso) {
		this.simCountryIso = simCountryIso;
	}
	
	public String getNetworkType() {
		return networkType;
	}
	
	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}
	
	public String getPhoneType() {
		return phoneType;
	}
	
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
	
	public String getSimOperator() {
		return simOperator;
	}
	
	public void setSimOperator(String simOperator) {
		this.simOperator = simOperator;
	}
	
	public String getSimOperatorName() {
		return simOperatorName;
	}
	
	public void setSimOperatorName(String simOperatorName) {
		this.simOperatorName = simOperatorName;
	}
	
	public String getSimSerialNumber() {
		return simSerialNumber;
	}
	
	public void setSimSerialNumber(String simSerialNumber) {
		this.simSerialNumber = simSerialNumber;
	}
	
	public String getSubscriberId() {
		return subscriberId;
	}
	
	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("DataState: {DataState}");
		sb.append("DeviceId: {DeviceId}");
		// *
		sb.append("HasIccCard: {HasIccCard}");
		// *
		sb.append("IsSmsCapable: {IsSmsCapable}");
		sb.append("Line1Number: {Line1Number}");
		// *
		sb.append("NetworkCountryIso: {NetworkCountryIso}");
		// *
		sb.append("NetworkOperator: {NetworkOperator}");
		sb.append("NetworkOperatorName: {NetworkOperatorName}");
		sb.append("NetworkType: {NetworkType}");
		sb.append("PhoneType: {PhoneType}");
		sb.append("SimCountryIso: {SimCountryIso}");
		// *
		sb.append("SimOperator: {SimOperator}");
		// *
		sb.append("SimOperatorName: {SimOperatorName}");
		sb.append("SimSerialNumber: {SimSerialNumber}");
		// *
		sb.append("SimState: {SimState}");
		sb.append("SubscriberId: {SubscriberId}");
		// *
		String result = sb.toString();
		return result;
	}
}
