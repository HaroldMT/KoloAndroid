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

import java.util.Date;
import java.util.Hashtable;

import fr.cyberix.kolo.helpers.DateHelper;

public class Registration implements KvmSerializable {
	
	private int idRegistration;
	private String lastName;
	private String firstName;
	private String phoneNumber;
	private String dob;
	private String email;
	private String registrationToken;
	private String registrationStatusCode;
	private String registrationDate;
	private String registrationConfirmDate;
	private String simSubscriberId;
	private String simSerialNumber;
	private String operatorDeviceSim;
	private String registrationTokenExpiryDate;
	private String pwd;
	private String deviceId;
	private RefRegistrationStatu refRegistrationStatu;
	
	public Registration() {
	}
	
	public Registration(SoapObject soapObject) {
		if (soapObject == null)
			return;
		if (soapObject.hasProperty("IdRegistration")) {
			Object obj = soapObject.getProperty("IdRegistration");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setIdRegistration(Integer.parseInt(j.toString()));
			} else if (obj != null && obj instanceof Number) {
				setIdRegistration((Integer) obj);
			}
		}
		if (soapObject.hasProperty("LastName")) {
			Object obj = soapObject.getProperty("LastName");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setLastName(j.toString());
			} else if (obj != null && obj instanceof String) {
				setLastName((String) obj);
			}
		}
		if (soapObject.hasProperty("FirstName")) {
			Object obj = soapObject.getProperty("FirstName");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setFirstName(j.toString());
			} else if (obj != null && obj instanceof String) {
				setFirstName((String) obj);
			}
		}
		if (soapObject.hasProperty("PhoneNumber")) {
			Object obj = soapObject.getProperty("PhoneNumber");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setPhoneNumber(j.toString());
			} else if (obj != null && obj instanceof String) {
				setPhoneNumber((String) obj);
			}
		}
		if (soapObject.hasProperty("Dob")) {
			Object obj = soapObject.getProperty("Dob");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setDob(new Date(j.toString()));
			} else if (obj != null && obj instanceof String) {
				setDob((Date) obj);
			}
		}
		if (soapObject.hasProperty("Email")) {
			Object obj = soapObject.getProperty("Email");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setEmail(j.toString());
			} else if (obj != null && obj instanceof String) {
				setEmail((String) obj);
			}
		}
		if (soapObject.hasProperty("RegistrationToken")) {
			Object obj = soapObject.getProperty("RegistrationToken");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setRegistrationToken(j.toString());
			} else if (obj != null && obj instanceof String) {
				setRegistrationToken((String) obj);
			}
		}
		if (soapObject.hasProperty("RegistrationStatusCode")) {
			Object obj = soapObject.getProperty("RegistrationStatusCode");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setRegistrationStatusCode(j.toString());
			} else if (obj != null && obj instanceof String) {
				setRegistrationStatusCode((String) obj);
			}
		}
		if (soapObject.hasProperty("RegistrationDate")) {
			Object obj = soapObject.getProperty("RegistrationDate");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setRegistrationDate(new Date(j.toString()));
			} else if (obj != null && obj instanceof String) {
				setRegistrationDate((Date) obj);
			}
		}
		if (soapObject.hasProperty("RegistrationConfirmDate")) {
			Object obj = soapObject.getProperty("RegistrationConfirmDate");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setRegistrationConfirmDate(new Date(j.toString()));
			} else if (obj != null && obj instanceof String) {
				setRegistrationConfirmDate((Date) obj);
			}
		}
		if (soapObject.hasProperty("SimSubscriberId")) {
			Object obj = soapObject.getProperty("SimSubscriberId");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setSimSubscriberId(j.toString());
			} else if (obj != null && obj instanceof String) {
				setSimSubscriberId((String) obj);
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
		if (soapObject.hasProperty("OperatorDeviceSim")) {
			Object obj = soapObject.getProperty("OperatorDeviceSim");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setOperatorDeviceSim(j.toString());
			} else if (obj != null && obj instanceof String) {
				setOperatorDeviceSim((String) obj);
			}
		}
		if (soapObject.hasProperty("RegistrationTokenExpiryDate")) {
			Object obj = soapObject.getProperty("RegistrationTokenExpiryDate");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setRegistrationTokenExpiryDate(new Date(j.toString()));
			} else if (obj != null && obj instanceof String) {
				setRegistrationTokenExpiryDate((Date) obj);
			}
		}
		if (soapObject.hasProperty("Pwd")) {
			Object obj = soapObject.getProperty("Pwd");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setPwd(j.toString());
			} else if (obj != null && obj instanceof String) {
				setPwd((String) obj);
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
		if (soapObject.hasProperty("RefRegistrationStatu")) {
			SoapObject j = (SoapObject) soapObject.getProperty("RefRegistrationStatu");
			setRefRegistrationStatu(new RefRegistrationStatu(j));
			
		}
	}
	
	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
			case 0:
				return getIdRegistration();
			case 1:
				return getLastName();
			case 2:
				return getFirstName();
			case 3:
				return getPhoneNumber();
			case 4:
				return getDob();
			case 5:
				return getEmail();
			case 6:
				return getRegistrationToken();
			case 7:
				return getRegistrationStatusCode();
			case 8:
				return getRegistrationDate();
			case 9:
				return getRegistrationConfirmDate();
			case 10:
				return getSimSubscriberId();
			case 11:
				return getSimSerialNumber();
			case 12:
				return getOperatorDeviceSim();
			case 13:
				return getRegistrationTokenExpiryDate();
			case 14:
				return getPwd();
			case 15:
				return getDeviceId();
			case 16:
				return getRefRegistrationStatu();
		}
		return null;
	}
	
	@Override
	public int getPropertyCount() {
		return 17;
	}
	
	@Override
	public void setProperty(int arg0, Object arg1) {
	}
	
	@Override
	public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
		switch (index) {
			case 0:
				info.type = PropertyInfo.INTEGER_CLASS;
				info.name = "IdRegistration";
				break;
			case 1:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "LastName";
				break;
			case 2:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "FirstName";
				break;
			case 3:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "PhoneNumber";
				break;
			case 4:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "Dob";
				break;
			case 5:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "Email";
				break;
			case 6:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "RegistrationToken";
				break;
			case 7:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "RegistrationStatusCode";
				break;
			case 8:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "RegistrationDate";
				break;
			case 9:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "RegistrationConfirmDate";
				break;
			case 10:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "SimSubscriberId";
				break;
			case 11:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "SimSerialNumber";
				break;
			case 12:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "OperatorDeviceSim";
				break;
			case 13:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "RegistrationTokenExpiryDate";
				break;
			case 14:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "Pwd";
				break;
			case 15:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "DeviceId";
				break;
			case 16:
				info.type = RefRegistrationStatu.class;
				info.name = "RefRegistrationStatu";
				break;
		}
	}
	
	public int getIdRegistration() {
		return idRegistration;
	}
	
	public void setIdRegistration(int idRegistration) {
		this.idRegistration = idRegistration;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public Date getDob() {
		return DateHelper.String2Date(dob);
	}
	
	public void setDob(Date dob) {
		this.dob = DateHelper.Date2String(dob);
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRegistrationToken() {
		return registrationToken;
	}
	
	public void setRegistrationToken(String registrationToken) {
		this.registrationToken = registrationToken;
	}
	
	public String getRegistrationStatusCode() {
		return registrationStatusCode;
	}
	
	public Date getRegistrationDate() {
		return DateHelper.String2Date(registrationDate);
	}
	
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = DateHelper.Date2String(registrationDate);
	}
	
	public Date getRegistrationConfirmDate() {
		return DateHelper.String2Date(registrationConfirmDate);
	}
	
	public void setRegistrationConfirmDate(Date registrationConfirmDate) {
		this.registrationConfirmDate = DateHelper.Date2String(registrationConfirmDate);
	}
	
	public String getSimSubscriberId() {
		return simSubscriberId;
	}
	
	public void setSimSubscriberId(String simSubscriberId) {
		this.simSubscriberId = simSubscriberId;
	}
	
	public String getSimSerialNumber() {
		return simSerialNumber;
	}
	
	public void setSimSerialNumber(String simSerialNumber) {
		this.simSerialNumber = simSerialNumber;
	}
	
	public String getOperatorDeviceSim() {
		return operatorDeviceSim;
	}
	
	public Date getRegistrationTokenExpiryDate() {
		return DateHelper.String2Date(registrationTokenExpiryDate);
	}
	
	public void setRegistrationTokenExpiryDate(Date registrationTokenExpiryDate) {
		this.registrationTokenExpiryDate = DateHelper.Date2String(registrationTokenExpiryDate);
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public String getDeviceId() {
		return deviceId;
	}
	
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	public RefRegistrationStatu getRefRegistrationStatu() {
		return refRegistrationStatu;
	}
	
	public void setRefRegistrationStatu(RefRegistrationStatu refRegistrationStatu) {
		this.refRegistrationStatu = refRegistrationStatu;
	}
	
	public void setOperatorDeviceSim(String operatorDeviceSim) {
		this.operatorDeviceSim = operatorDeviceSim;
	}
	
	public void setRegistrationStatusCode(String registrationStatusCode) {
		this.registrationStatusCode = registrationStatusCode;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	//    @Override
	public String getInnerText() {
		return null;
	}
	
	//    @Override
	public void setInnerText(String s) {
	}

	@Override
	public String toString() {
		return "Registration{" +
				"idRegistration=" + idRegistration +
				", lastName='" + lastName + '\'' +
				", firstName='" + firstName + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", dob='" + dob + '\'' +
				", email='" + email + '\'' +
				", registrationToken='" + registrationToken + '\'' +
				", registrationStatusCode='" + registrationStatusCode + '\'' +
				", registrationDate='" + registrationDate + '\'' +
				", registrationConfirmDate='" + registrationConfirmDate + '\'' +
				", simSubscriberId='" + simSubscriberId + '\'' +
				", simSerialNumber='" + simSerialNumber + '\'' +
				", operatorDeviceSim='" + operatorDeviceSim + '\'' +
				", registrationTokenExpiryDate='" + registrationTokenExpiryDate + '\'' +
				", pwd='" + pwd + '\'' +
				", deviceId='" + deviceId + '\'' +
				", refRegistrationStatu=" + refRegistrationStatu +
				'}';
	}
}
