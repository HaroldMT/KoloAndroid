package fr.cyberix.kolo.entities;

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

public class RefResult implements KvmSerializable {

    public String resultCode;
    public String resultDescription;

    public RefResult() {
    }

    public RefResult(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("ResultCode")) {
            Object obj = soapObject.getProperty("ResultCode");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                resultCode = j.toString();
            } else if (obj != null && obj instanceof String) {
                resultCode = (String) obj;
            }
        }
        if (soapObject.hasProperty("ResultDescription")) {
            Object obj = soapObject.getProperty("ResultDescription");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                resultDescription = j.toString();
            } else if (obj != null && obj instanceof String) {
                resultDescription = (String) obj;
            }
        }
    }
    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return resultCode;
            case 1:
                return resultDescription;
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
                info.name = "ResultCode";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "ResultDescription";
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
