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

public class RefBillStatu implements KvmSerializable {

    private String billStatusCode;
    private String billStatusDescription;

    public RefBillStatu() {
    }

    public RefBillStatu(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("BillStatusCode")) {
            Object obj = soapObject.getProperty("BillStatusCode");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                setBillStatusCode(j.toString());
            } else if (obj != null && obj instanceof String) {
                setBillStatusCode((String) obj);
            }
        }
        if (soapObject.hasProperty("BillStatusDescription")) {
            Object obj = soapObject.getProperty("BillStatusDescription");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                setBillStatusDescription(j.toString());
            } else if (obj != null && obj instanceof String) {
                setBillStatusDescription((String) obj);
            }
        }
    }

    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return getBillStatusCode();
            case 1:
                return getBillStatusDescription();
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
                info.name = "BillStatusCode";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "BillStatusDescription";
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

    public String getBillStatusCode() {
        return billStatusCode;
    }

    public void setBillStatusCode(String billStatusCode) {
        this.billStatusCode = billStatusCode;
    }

    public String getBillStatusDescription() {
        return billStatusDescription;
    }

    public void setBillStatusDescription(String billStatusDescription) {
        this.billStatusDescription = billStatusDescription;
    }
}
