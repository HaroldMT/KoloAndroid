package fr.cyberix.kolo.model.entities;

//------------------------------------------------------------------------------
// <wsdl2code-generated>
//    This code was generated by http://www.wsdl2code.com version  2.6
//
// Date Of Creation: 6/1/2018 1:24:28 PM
//    Please dont change this code, regeneration will override your changes
//</wsdl2code-generated>
//
//------------------------------------------------------------------------------
//
//This source code was auto-generated by Wsdl2Code  Version
//

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import java.util.Hashtable;

public class MobileDevice implements KvmSerializable {
	
	private int idMobileDevice;
	private String deviceId;
	private String lineNumber;
	private String networkCountryIso;
	private String networkOperator;
	private String networkOperatorName;
	private String networkType;
	private String phoneType;
	private String simCountryIso;
	private String simOperator;
	private String simOperatorName;
	private String simSerialNumber;
	private String simState;
	private String subscriberId;
	private Customer customer;
	
	public MobileDevice() {
	}
	
	public MobileDevice(SoapObject soapObject) {
		if (soapObject == null)
			return;
		if (soapObject.hasProperty("IdMobileDevice")) {
			Object obj = soapObject.getProperty("IdMobileDevice");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setIdMobileDevice(Integer.parseInt(j.toString()));
			} else if (obj != null && obj instanceof Number) {
				setIdMobileDevice((Integer) obj);
			}
		}
		if (soapObject.hasProperty("DeviceId")) {
			Object obj = soapObject.getProperty("DeviceId");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setDeviceId(j.toString());
			} else if (obj != null && obj instanceof String) {
				setDeviceId((String) obj);
			}
		}
		if (soapObject.hasProperty("LineNumber")) {
			Object obj = soapObject.getProperty("LineNumber");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setLineNumber(j.toString());
			} else if (obj != null && obj instanceof String) {
				setLineNumber((String) obj);
			}
		}
		if (soapObject.hasProperty("NetworkCountryIso")) {
			Object obj = soapObject.getProperty("NetworkCountryIso");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setNetworkCountryIso(j.toString());
			} else if (obj != null && obj instanceof String) {
				setNetworkCountryIso((String) obj);
			}
		}
		if (soapObject.hasProperty("NetworkOperator")) {
			Object obj = soapObject.getProperty("NetworkOperator");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setNetworkOperator(j.toString());
			} else if (obj != null && obj instanceof String) {
				setNetworkOperator((String) obj);
			}
		}
		if (soapObject.hasProperty("NetworkOperatorName")) {
			Object obj = soapObject.getProperty("NetworkOperatorName");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setNetworkOperatorName(j.toString());
			} else if (obj != null && obj instanceof String) {
				setNetworkOperatorName((String) obj);
			}
		}
		if (soapObject.hasProperty("NetworkType")) {
			Object obj = soapObject.getProperty("NetworkType");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setNetworkType(j.toString());
			} else if (obj != null && obj instanceof String) {
				setNetworkType((String) obj);
			}
		}
		if (soapObject.hasProperty("PhoneType")) {
			Object obj = soapObject.getProperty("PhoneType");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setPhoneType(j.toString());
			} else if (obj != null && obj instanceof String) {
				setPhoneType((String) obj);
			}
		}
		if (soapObject.hasProperty("SimCountryIso")) {
			Object obj = soapObject.getProperty("SimCountryIso");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setSimCountryIso(j.toString());
			} else if (obj != null && obj instanceof String) {
				setSimCountryIso((String) obj);
			}
		}
		if (soapObject.hasProperty("SimOperator")) {
			Object obj = soapObject.getProperty("SimOperator");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setSimOperator(j.toString());
			} else if (obj != null && obj instanceof String) {
				setSimOperator((String) obj);
			}
		}
		if (soapObject.hasProperty("SimOperatorName")) {
			Object obj = soapObject.getProperty("SimOperatorName");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setSimOperatorName(j.toString());
			} else if (obj != null && obj instanceof String) {
				setSimOperatorName((String) obj);
			}
		}
		if (soapObject.hasProperty("SimSerialNumber")) {
			Object obj = soapObject.getProperty("SimSerialNumber");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setSimSerialNumber(j.toString());
			} else if (obj != null && obj instanceof String) {
				setSimSerialNumber((String) obj);
			}
		}
		if (soapObject.hasProperty("SimState")) {
			Object obj = soapObject.getProperty("SimState");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setSimState(j.toString());
			} else if (obj != null && obj instanceof String) {
				setSimState((String) obj);
			}
		}
		if (soapObject.hasProperty("SubscriberId")) {
			Object obj = soapObject.getProperty("SubscriberId");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setSubscriberId(j.toString());
			} else if (obj != null && obj instanceof String) {
				setSubscriberId((String) obj);
			}
		}
		if (soapObject.hasProperty("Customer")) {
			SoapObject j = (SoapObject) soapObject.getProperty("Customer");
			setCustomer(new Customer(j));
			
		}
	}
	
	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
			case 0:
				return getIdMobileDevice();
			case 1:
				return getDeviceId();
			case 2:
				return getLineNumber();
			case 3:
				return getNetworkCountryIso();
			case 4:
				return getNetworkOperator();
			case 5:
				return getNetworkOperatorName();
			case 6:
				return getNetworkType();
			case 7:
				return getPhoneType();
			case 8:
				return getSimCountryIso();
			case 9:
				return getSimOperator();
			case 10:
				return getSimOperatorName();
			case 11:
				return getSimSerialNumber();
			case 12:
				return getSimState();
			case 13:
				return getSubscriberId();
			case 14:
				return getCustomer();
		}
		return null;
	}
	
	@Override
	public int getPropertyCount() {
		return 15;
	}
	
	@Override
	public void setProperty(int arg0, Object arg1) {
	}
	
	@Override
	public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
		switch (index) {
			case 0:
				info.type = PropertyInfo.INTEGER_CLASS;
				info.name = "IdMobileDevice";
				break;
			case 1:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "DeviceId";
				break;
			case 2:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "LineNumber";
				break;
			case 3:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "NetworkCountryIso";
				break;
			case 4:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "NetworkOperator";
				break;
			case 5:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "NetworkOperatorName";
				break;
			case 6:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "NetworkType";
				break;
			case 7:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "PhoneType";
				break;
			case 8:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "SimCountryIso";
				break;
			case 9:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "SimOperator";
				break;
			case 10:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "SimOperatorName";
				break;
			case 11:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "SimSerialNumber";
				break;
			case 12:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "SimState";
				break;
			case 13:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "SubscriberId";
				break;
			case 14:
				info.type = Customer.class;
				info.name = "Customer";
				break;
		}
	}
	
	public int getIdMobileDevice() {
		return idMobileDevice;
	}
	
	public void setIdMobileDevice(int idMobileDevice) {
		this.idMobileDevice = idMobileDevice;
	}
	
	public String getDeviceId() {
		return deviceId;
	}
	
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	public String getLineNumber() {
		return lineNumber;
	}
	
	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
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
	
	public String getSimCountryIso() {
		return simCountryIso;
	}
	
	public void setSimCountryIso(String simCountryIso) {
		this.simCountryIso = simCountryIso;
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
	
	public String getSimState() {
		return simState;
	}
	
	public String getSubscriberId() {
		return subscriberId;
	}
	
	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void setSimState(String simState) {
		this.simState = simState;
	}
	
	//    @Override
	public String getInnerText() {
		return null;
	}
	
	//    @Override
	public void setInnerText(String s) {
	}
}
