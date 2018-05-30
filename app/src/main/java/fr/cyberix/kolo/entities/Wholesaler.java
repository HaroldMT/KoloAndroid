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

public class Wholesaler implements KvmSerializable {

    public int idPartner;
    public Partner partner;

    public Wholesaler() {
    }

    public Wholesaler(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("IdPartner")) {
            Object obj = soapObject.getProperty("IdPartner");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                idPartner = Integer.parseInt(j.toString());
            } else if (obj != null && obj instanceof Number) {
                idPartner = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("Partner")) {
            SoapObject j = (SoapObject) soapObject.getProperty("Partner");
            partner = new Partner(j);

        }
    }

    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return idPartner;
            case 1:
                return partner;
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
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "IdPartner";
                break;
            case 1:
                info.type = Partner.class;
                info.name = "Partner";
                break;
        }
    }

    public String getInnerText() {
        return null;
    }

    public void setInnerText(String s) {
    }

}
