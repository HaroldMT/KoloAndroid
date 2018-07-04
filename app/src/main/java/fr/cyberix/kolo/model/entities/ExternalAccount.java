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

public class ExternalAccount implements KvmSerializable {
	
	private int idExternalAccount;
	private String externalLogin;
	private String externalPwd;
	private String externalAccountTypeCode;
	private int idCreditCard;
	private RefExternalAccountType refExternalAccountType;
	private CreditCardInfo creditCardInfo;
	
	public ExternalAccount() {
	}
	
	public ExternalAccount(SoapObject soapObject) {
		if (soapObject == null)
			return;
		if (soapObject.hasProperty("IdExternalAccount")) {
			Object obj = soapObject.getProperty("IdExternalAccount");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setIdExternalAccount(Integer.parseInt(j.toString()));
			} else if (obj != null && obj instanceof Number) {
				setIdExternalAccount((Integer) obj);
			}
		}
		if (soapObject.hasProperty("ExternalLogin")) {
			Object obj = soapObject.getProperty("ExternalLogin");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setExternalLogin(j.toString());
			} else if (obj != null && obj instanceof String) {
				setExternalLogin((String) obj);
			}
		}
		if (soapObject.hasProperty("ExternalPwd")) {
			Object obj = soapObject.getProperty("ExternalPwd");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setExternalPwd(j.toString());
			} else if (obj != null && obj instanceof String) {
				setExternalPwd((String) obj);
			}
		}
		if (soapObject.hasProperty("ExternalAccountTypeCode")) {
			Object obj = soapObject.getProperty("ExternalAccountTypeCode");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setExternalAccountTypeCode(j.toString());
			} else if (obj != null && obj instanceof String) {
				setExternalAccountTypeCode((String) obj);
			}
		}
		if (soapObject.hasProperty("RefExternalAccountType")) {
			SoapObject j = (SoapObject) soapObject.getProperty("RefExternalAccountType");
			setRefExternalAccountType(new RefExternalAccountType(j));
			
		}
	}
	
	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
			case 0:
				return getIdExternalAccount();
			case 1:
				return getExternalLogin();
			case 2:
				return getExternalPwd();
			case 3:
				return getExternalAccountTypeCode();
			case 4:
				return getRefExternalAccountType();
		}
		return null;
	}
	
	@Override
	public int getPropertyCount() {
		return 5;
	}
	
	@Override
	public void setProperty(int arg0, Object arg1) {
	}
	
	@Override
	public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
		switch (index) {
			case 0:
				info.type = PropertyInfo.INTEGER_CLASS;
				info.name = "IdExternalAccount";
				break;
			case 1:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "ExternalLogin";
				break;
			case 2:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "ExternalPwd";
				break;
			case 3:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "ExternalAccountTypeCode";
				break;
			case 4:
				info.type = RefExternalAccountType.class;
				info.name = "RefExternalAccountType";
				break;
		}
	}
	
	public int getIdExternalAccount() {
		return idExternalAccount;
	}
	
	public void setIdExternalAccount(int idExternalAccount) {
		this.idExternalAccount = idExternalAccount;
	}
	
	public String getExternalLogin() {
		return externalLogin;
	}
	
	public void setExternalLogin(String externalLogin) {
		this.externalLogin = externalLogin;
	}
	
	public String getExternalPwd() {
		return externalPwd;
	}
	
	public void setExternalPwd(String externalPwd) {
		this.externalPwd = externalPwd;
	}
	
	public String getExternalAccountTypeCode() {
		return externalAccountTypeCode;
	}
	
	public void setExternalAccountTypeCode(String externalAccountTypeCode) {
		this.externalAccountTypeCode = externalAccountTypeCode;
	}
	
	public RefExternalAccountType getRefExternalAccountType() {
		return refExternalAccountType;
	}
	
	public void setRefExternalAccountType(RefExternalAccountType refExternalAccountType) {
		this.refExternalAccountType = refExternalAccountType;
	}
	
	//    @Override
	public String getInnerText() {
		return null;
	}
	
	//    @Override
	public void setInnerText(String s) {
	}
	
	public int getIdCreditCard() {
		return idCreditCard;
	}
	
	public void setIdCreditCard(int idCreditCard) {
		this.idCreditCard = idCreditCard;
	}
	
	public CreditCardInfo getCreditCardInfo() {
		return creditCardInfo;
	}
	
	public void setCreditCardInfo(CreditCardInfo creditCardInfo) {
		this.creditCardInfo = creditCardInfo;
	}
}
