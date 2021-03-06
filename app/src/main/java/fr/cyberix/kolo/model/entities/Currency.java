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

public class Currency implements KvmSerializable {
	
	private String currencyCode;
	private String currencyName;
	
	public Currency() {
	}
	
	public Currency(SoapObject soapObject) {
		if (soapObject == null)
			return;
		if (soapObject.hasProperty("CurrencyCode")) {
			Object obj = soapObject.getProperty("CurrencyCode");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setCurrencyCode(j.toString());
			} else if (obj != null && obj instanceof String) {
				setCurrencyCode((String) obj);
			}
		}
		if (soapObject.hasProperty("CurrencyName")) {
			Object obj = soapObject.getProperty("CurrencyName");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setCurrencyName(j.toString());
			} else if (obj != null && obj instanceof String) {
				setCurrencyName((String) obj);
			}
		}
	}
	
	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
			case 0:
				return getCurrencyCode();
			case 1:
				return getCurrencyName();
		}
		return null;
	}
	
	@Override
	public int getPropertyCount() {
		return 2;
	}
	
	@Override
	public void setProperty(int arg0, Object arg1) {
	}
	
	@Override
	public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
		switch (index) {
			case 0:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "CurrencyCode";
				break;
			case 1:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "CurrencyName";
				break;
		}
	}
	
	public String getCurrencyCode() {
		return currencyCode;
	}
	
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	public String getCurrencyName() {
		return currencyName;
	}
	
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	
	//    @Override
	public String getInnerText() {
		return null;
	}
	
	//    @Override
	public void setInnerText(String s) {
	}
}
