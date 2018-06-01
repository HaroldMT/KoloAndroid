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

public class TransfertGroupScheduled implements KvmSerializable {

    public int idTransfertGroupScheduled;
    public int idReceiverGroup;
    public int idSendingCustomer;
    public Customer customer;
    public CustomerGroup customerGroup;

    public TransfertGroupScheduled() {
    }

    public TransfertGroupScheduled(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("IdTransfertGroupScheduled")) {
            Object obj = soapObject.getProperty("IdTransfertGroupScheduled");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                idTransfertGroupScheduled = Integer.parseInt(j.toString());
            } else if (obj != null && obj instanceof Number) {
                idTransfertGroupScheduled = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("IdReceiverGroup")) {
            Object obj = soapObject.getProperty("IdReceiverGroup");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                idReceiverGroup = Integer.parseInt(j.toString());
            } else if (obj != null && obj instanceof Number) {
                idReceiverGroup = (Integer) obj;
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
        if (soapObject.hasProperty("Customer")) {
            SoapObject j = (SoapObject) soapObject.getProperty("Customer");
            customer = new Customer(j);

        }
        if (soapObject.hasProperty("CustomerGroup")) {
            SoapObject j = (SoapObject) soapObject.getProperty("CustomerGroup");
            customerGroup = new CustomerGroup(j);

        }
    }

    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return idTransfertGroupScheduled;
            case 1:
                return idReceiverGroup;
            case 2:
                return idSendingCustomer;
            case 3:
                return customer;
            case 4:
                return customerGroup;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 5;
    }

    @Override
    public void setProperty(int arg0, Object arg1) {
    }

    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch (index) {
            case 0:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "IdTransfertGroupScheduled";
                break;
            case 1:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "IdReceiverGroup";
                break;
            case 2:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "IdSendingCustomer";
                break;
            case 3:
                info.type = Customer.class;
                info.name = "Customer";
                break;
            case 4:
                info.type = CustomerGroup.class;
                info.name = "CustomerGroup";
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