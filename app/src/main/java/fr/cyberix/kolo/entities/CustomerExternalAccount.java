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

public class CustomerExternalAccount implements KvmSerializable {

    public int idCustomer;
    public int idExternalAccount;
    public ExternalAccount externalAccount;

    public CustomerExternalAccount() {
    }

    public CustomerExternalAccount(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("IdCustomer")) {
            Object obj = soapObject.getProperty("IdCustomer");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                idCustomer = Integer.parseInt(j.toString());
            } else if (obj != null && obj instanceof Number) {
                idCustomer = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("IdExternalAccount")) {
            Object obj = soapObject.getProperty("IdExternalAccount");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                idExternalAccount = Integer.parseInt(j.toString());
            } else if (obj != null && obj instanceof Number) {
                idExternalAccount = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("ExternalAccount")) {
            SoapObject j = (SoapObject) soapObject.getProperty("ExternalAccount");
            externalAccount = new ExternalAccount(j);

        }
    }

    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return idCustomer;
            case 1:
                return idExternalAccount;
            case 2:
                return externalAccount;
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
                info.name = "IdCustomer";
                break;
            case 1:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "IdExternalAccount";
                break;
            case 2:
                info.type = ExternalAccount.class;
                info.name = "ExternalAccount";
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
