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

public class RefOperationStatu implements KvmSerializable {

    public String operationStatusCode;
    public String operationStatusDescription;

    public RefOperationStatu() {
    }

    public RefOperationStatu(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("OperationStatusCode")) {
            Object obj = soapObject.getProperty("OperationStatusCode");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                operationStatusCode = j.toString();
            } else if (obj != null && obj instanceof String) {
                operationStatusCode = (String) obj;
            }
        }
        if (soapObject.hasProperty("OperationStatusDescription")) {
            Object obj = soapObject.getProperty("OperationStatusDescription");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                operationStatusDescription = j.toString();
            } else if (obj != null && obj instanceof String) {
                operationStatusDescription = (String) obj;
            }
        }
    }

    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return operationStatusCode;
            case 1:
                return operationStatusDescription;
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
                info.name = "OperationStatusCode";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "OperationStatusDescription";
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
