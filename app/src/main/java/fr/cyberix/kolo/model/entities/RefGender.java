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

public class RefGender implements KvmSerializable {
	
	private String genderCode;
	private String genderDescription;
	
	public RefGender() {
	}
	
	public RefGender(SoapObject soapObject) {
		if (soapObject == null)
			return;
		if (soapObject.hasProperty("GenderCode")) {
			Object obj = soapObject.getProperty("GenderCode");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setGenderCode(j.toString());
			} else if (obj != null && obj instanceof String) {
				setGenderCode((String) obj);
			}
		}
		if (soapObject.hasProperty("GenderDescription")) {
			Object obj = soapObject.getProperty("GenderDescription");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setGenderDescription(j.toString());
			} else if (obj != null && obj instanceof String) {
				setGenderDescription((String) obj);
			}
		}
	}
	
	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
			case 0:
				return getGenderCode();
			case 1:
				return getGenderDescription();
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
				info.name = "GenderCode";
				break;
			case 1:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "GenderDescription";
				break;
		}
	}
	
	public String getGenderCode() {
		return genderCode;
	}
	
	public void setGenderCode(String genderCode) {
		this.genderCode = genderCode;
	}
	
	public String getGenderDescription() {
		return genderDescription;
	}
	
	public void setGenderDescription(String genderDescription) {
		this.genderDescription = genderDescription;
	}
	
	//    @Override
	public String getInnerText() {
		return null;
	}
	
	//    @Override
	public void setInnerText(String s) {
	}
}
