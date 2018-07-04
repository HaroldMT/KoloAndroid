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

public class RefIndustryCategory implements KvmSerializable {
	
	private String industryCategoryCode;
	private String industryCategoryDescrption;
	
	public RefIndustryCategory() {
	}
	
	public RefIndustryCategory(SoapObject soapObject) {
		if (soapObject == null)
			return;
		if (soapObject.hasProperty("IndustryCategoryCode")) {
			Object obj = soapObject.getProperty("IndustryCategoryCode");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setIndustryCategoryCode(j.toString());
			} else if (obj != null && obj instanceof String) {
				setIndustryCategoryCode((String) obj);
			}
		}
		if (soapObject.hasProperty("IndustryCategoryDescrption")) {
			Object obj = soapObject.getProperty("IndustryCategoryDescrption");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setIndustryCategoryDescrption(j.toString());
			} else if (obj != null && obj instanceof String) {
				setIndustryCategoryDescrption((String) obj);
			}
		}
	}
	
	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
			case 0:
				return getIndustryCategoryCode();
			case 1:
				return getIndustryCategoryDescrption();
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
				info.name = "IndustryCategoryCode";
				break;
			case 1:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "IndustryCategoryDescrption";
				break;
		}
	}
	
	public String getIndustryCategoryCode() {
		return industryCategoryCode;
	}
	
	public void setIndustryCategoryCode(String industryCategoryCode) {
		this.industryCategoryCode = industryCategoryCode;
	}
	
	public String getIndustryCategoryDescrption() {
		return industryCategoryDescrption;
	}
	
	public void setIndustryCategoryDescrption(String industryCategoryDescrption) {
		this.industryCategoryDescrption = industryCategoryDescrption;
	}
	
	//    @Override
	public String getInnerText() {
		return null;
	}
	
	//    @Override
	public void setInnerText(String s) {
	}
}
