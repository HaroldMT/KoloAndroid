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

public class TransfertGroup implements KvmSerializable {

    public int idTransfertGroup;
    public int idReceiverGroup;
    public int idSendingCustomer;
    public int amount;
    public String codeTransfertStatus;
    public String reference;
    public Customer customer;
    public CustomerGroup customerGroup;
    public RefTransfertStatu refTransfertStatu;

    public TransfertGroup() {
    }

    public TransfertGroup(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("IdTransfertGroup")) {
            Object obj = soapObject.getProperty("IdTransfertGroup");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                idTransfertGroup = Integer.parseInt(j.toString());
            } else if (obj != null && obj instanceof Number) {
                idTransfertGroup = (Integer) obj;
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
        if (soapObject.hasProperty("Amount")) {
            Object obj = soapObject.getProperty("Amount");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                amount = Integer.parseInt(j.toString());
            } else if (obj != null && obj instanceof Number) {
                amount = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("CodeTransfertStatus")) {
            Object obj = soapObject.getProperty("CodeTransfertStatus");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                codeTransfertStatus = j.toString();
            } else if (obj != null && obj instanceof String) {
                codeTransfertStatus = (String) obj;
            }
        }
        if (soapObject.hasProperty("Reference")) {
            Object obj = soapObject.getProperty("Reference");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                reference = j.toString();
            } else if (obj != null && obj instanceof String) {
                reference = (String) obj;
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
        if (soapObject.hasProperty("RefTransfertStatu")) {
            SoapObject j = (SoapObject) soapObject.getProperty("RefTransfertStatu");
            refTransfertStatu = new RefTransfertStatu(j);

        }
    }

    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return idTransfertGroup;
            case 1:
                return idReceiverGroup;
            case 2:
                return idSendingCustomer;
            case 3:
                return amount;
            case 4:
                return codeTransfertStatus;
            case 5:
                return reference;
            case 6:
                return customer;
            case 7:
                return customerGroup;
            case 8:
                return refTransfertStatu;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 9;
    }

    @Override
    public void setProperty(int arg0, Object arg1) {
    }

    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch (index) {
            case 0:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "IdTransfertGroup";
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
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "Amount";
                break;
            case 4:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "CodeTransfertStatus";
                break;
            case 5:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "Reference";
                break;
            case 6:
                info.type = Customer.class;
                info.name = "Customer";
                break;
            case 7:
                info.type = CustomerGroup.class;
                info.name = "CustomerGroup";
                break;
            case 8:
                info.type = RefTransfertStatu.class;
                info.name = "RefTransfertStatu";
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
