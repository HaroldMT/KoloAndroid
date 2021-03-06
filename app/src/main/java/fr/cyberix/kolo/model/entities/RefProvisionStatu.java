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

public class RefProvisionStatu implements KvmSerializable {
	
	private String provisionStatusCode;
	private String provisionStatusDescription;
	
	public RefProvisionStatu() {
	}
	
	public RefProvisionStatu(SoapObject soapObject) {
		if (soapObject == null)
			return;
		if (soapObject.hasProperty("ProvisionStatusCode")) {
			Object obj = soapObject.getProperty("ProvisionStatusCode");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setProvisionStatusCode(j.toString());
			} else if (obj != null && obj instanceof String) {
				setProvisionStatusCode((String) obj);
			}
		}
		if (soapObject.hasProperty("ProvisionStatusDescription")) {
			Object obj = soapObject.getProperty("ProvisionStatusDescription");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setProvisionStatusDescription(j.toString());
			} else if (obj != null && obj instanceof String) {
				setProvisionStatusDescription((String) obj);
			}
		}
	}
	
	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
			case 0:
				return getProvisionStatusCode();
			case 1:
				return getProvisionStatusDescription();
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
				info.name = "ProvisionStatusCode";
				break;
			case 1:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "ProvisionStatusDescription";
				break;
		}
	}
	
	public String getProvisionStatusCode() {
		return provisionStatusCode;
	}
	
	public void setProvisionStatusCode(String provisionStatusCode) {
		this.provisionStatusCode = provisionStatusCode;
	}
	
	public String getProvisionStatusDescription() {
		return provisionStatusDescription;
	}
	
	public void setProvisionStatusDescription(String provisionStatusDescription) {
		this.provisionStatusDescription = provisionStatusDescription;
	}
	
	//    @Override
	public String getInnerText() {
		return null;
	}
	
	//    @Override
	public void setInnerText(String s) {
	}
}
