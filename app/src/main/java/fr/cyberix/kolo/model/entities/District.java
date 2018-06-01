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

public class District implements KvmSerializable {

    public int idDistrict;
    public String districtName;
    public String countryCode;

    public District() {
    }

    public District(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("IdDistrict")) {
            Object obj = soapObject.getProperty("IdDistrict");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                idDistrict = Integer.parseInt(j.toString());
            } else if (obj != null && obj instanceof Number) {
                idDistrict = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("DistrictName")) {
            Object obj = soapObject.getProperty("DistrictName");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                districtName = j.toString();
            } else if (obj != null && obj instanceof String) {
                districtName = (String) obj;
            }
        }
        if (soapObject.hasProperty("CountryCode")) {
            Object obj = soapObject.getProperty("CountryCode");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                countryCode = j.toString();
            } else if (obj != null && obj instanceof String) {
                countryCode = (String) obj;
            }
        }
    }

    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return idDistrict;
            case 1:
                return districtName;
            case 2:
                return countryCode;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 3;
    }

    @Override
    public void setProperty(int arg0, Object arg1) {
    }

    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch (index) {
            case 0:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "IdDistrict";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "DistrictName";
                break;
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "CountryCode";
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

}