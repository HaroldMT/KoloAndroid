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

public class TransfertScheduled implements KvmSerializable {

    public int idTransfertScheduled;
    public int idSendingCustomer;
    public int idReceiverCustomer;
    public String dateScheduled;
    public Customer customer;
    public Customer customer1;

    public TransfertScheduled() {
    }

    public TransfertScheduled(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("IdTransfertScheduled")) {
            Object obj = soapObject.getProperty("IdTransfertScheduled");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                idTransfertScheduled = Integer.parseInt(j.toString());
            } else if (obj != null && obj instanceof Number) {
                idTransfertScheduled = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("IdSendingCustomer")) {
            Object obj = soapObject.getProperty("IdSendingCustomer");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                idSendingCustomer = Integer.parseInt(j.toString());
            } else if (obj != null && obj instanceof Number) {
                idSendingCustomer = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("IdReceiverCustomer")) {
            Object obj = soapObject.getProperty("IdReceiverCustomer");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                idReceiverCustomer = Integer.parseInt(j.toString());
            } else if (obj != null && obj instanceof Number) {
                idReceiverCustomer = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("DateScheduled")) {
            Object obj = soapObject.getProperty("DateScheduled");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                dateScheduled = j.toString();
            } else if (obj != null && obj instanceof String) {
                dateScheduled = (String) obj;
            }
        }
        if (soapObject.hasProperty("Customer")) {
            SoapObject j = (SoapObject) soapObject.getProperty("Customer");
            customer = new Customer(j);

        }
        if (soapObject.hasProperty("Customer1")) {
            SoapObject j = (SoapObject) soapObject.getProperty("Customer1");
            customer1 = new Customer(j);

        }
    }

    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return idTransfertScheduled;
            case 1:
                return idSendingCustomer;
            case 2:
                return idReceiverCustomer;
            case 3:
                return dateScheduled;
            case 4:
                return customer;
            case 5:
                return customer1;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 6;
    }

    @Override
    public void setProperty(int arg0, Object arg1) {
    }

    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch (index) {
            case 0:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "IdTransfertScheduled";
                break;
            case 1:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "IdSendingCustomer";
                break;
            case 2:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "IdReceiverCustomer";
                break;
            case 3:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "DateScheduled";
                break;
            case 4:
                info.type = Customer.class;
                info.name = "Customer";
                break;
            case 5:
                info.type = Customer.class;
                info.name = "Customer1";
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