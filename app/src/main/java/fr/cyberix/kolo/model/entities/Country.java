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

public class Country implements KvmSerializable {

    private String countryCode;
    private String countryName;

    public Country() {
    }

    public Country(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("CountryCode")) {
            Object obj = soapObject.getProperty("CountryCode");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                setCountryCode(j.toString());
            } else if (obj != null && obj instanceof String) {
                setCountryCode((String) obj);
            }
        }
        if (soapObject.hasProperty("CountryName")) {
            Object obj = soapObject.getProperty("CountryName");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                setCountryName(j.toString());
            } else if (obj != null && obj instanceof String) {
                setCountryName((String) obj);
            }
        }
    }
    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return getCountryCode();
            case 1:
                return getCountryName();
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
                info.name = "CountryCode";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "CountryName";
                break;
        }
    }

    //    @Override
    public String getInnerText() {
        return null;
    }

    //    @Override
    public void setInnerText(String s) {
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
