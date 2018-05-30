package fr.cyberix.kolo.entities;

//------------------------------------------------------------------------------
// <wsdl2code-generated>
//    This code was generated by http://www.wsdl2code.com version  2.6
//
// Date Of Creation: 5/23/2018 7:21:37 PM
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

    public String industryCategoryCode;
    public String industryCategoryDescrption;

    public RefIndustryCategory() {
    }

    public RefIndustryCategory(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("IndustryCategoryCode")) {
            Object obj = soapObject.getProperty("IndustryCategoryCode");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                industryCategoryCode = j.toString();
            } else if (obj != null && obj instanceof String) {
                industryCategoryCode = (String) obj;
            }
        }
        if (soapObject.hasProperty("IndustryCategoryDescrption")) {
            Object obj = soapObject.getProperty("IndustryCategoryDescrption");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                industryCategoryDescrption = j.toString();
            } else if (obj != null && obj instanceof String) {
                industryCategoryDescrption = (String) obj;
            }
        }
    }

    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return industryCategoryCode;
            case 1:
                return industryCategoryDescrption;
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

    public String getInnerText() {
        return null;
    }

    public void setInnerText(String s) {
    }

}
