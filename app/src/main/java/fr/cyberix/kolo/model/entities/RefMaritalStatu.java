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

public class RefMaritalStatu implements KvmSerializable {

    public String maritalStatusCode;
    public String maritalStatusDescription;

    public RefMaritalStatu() {
    }

    public RefMaritalStatu(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("MaritalStatusCode")) {
            Object obj = soapObject.getProperty("MaritalStatusCode");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                maritalStatusCode = j.toString();
            } else if (obj != null && obj instanceof String) {
                maritalStatusCode = (String) obj;
            }
        }
        if (soapObject.hasProperty("MaritalStatusDescription")) {
            Object obj = soapObject.getProperty("MaritalStatusDescription");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                maritalStatusDescription = j.toString();
            } else if (obj != null && obj instanceof String) {
                maritalStatusDescription = (String) obj;
            }
        }
    }
    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return maritalStatusCode;
            case 1:
                return maritalStatusDescription;
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
                info.name = "MaritalStatusCode";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "MaritalStatusDescription";
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