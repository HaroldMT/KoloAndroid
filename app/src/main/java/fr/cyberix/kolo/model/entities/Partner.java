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

public class Partner implements KvmSerializable {

    public int idPartner;
    public String partnerTypeCode;
    public String currencyCode;
    public int balance;
    public String dateCreated;
    public Currency currency;
    public Customer customer;
    public RefPartnerType refPartnerType;
    public Reseller reseller;
    public Wholesaler wholesaler;

    public Partner() {
    }

    public Partner(SoapObject soapObject) {
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
        if (soapObject.hasProperty("PartnerTypeCode")) {
            Object obj = soapObject.getProperty("PartnerTypeCode");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                partnerTypeCode = j.toString();
            } else if (obj != null && obj instanceof String) {
                partnerTypeCode = (String) obj;
            }
        }
        if (soapObject.hasProperty("CurrencyCode")) {
            Object obj = soapObject.getProperty("CurrencyCode");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                currencyCode = j.toString();
            } else if (obj != null && obj instanceof String) {
                currencyCode = (String) obj;
            }
        }
        if (soapObject.hasProperty("Balance")) {
            Object obj = soapObject.getProperty("Balance");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                balance = Integer.parseInt(j.toString());
            } else if (obj != null && obj instanceof Number) {
                balance = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("DateCreated")) {
            Object obj = soapObject.getProperty("DateCreated");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                dateCreated = j.toString();
            } else if (obj != null && obj instanceof String) {
                dateCreated = (String) obj;
            }
        }
        if (soapObject.hasProperty("Currency")) {
            SoapObject j = (SoapObject) soapObject.getProperty("Currency");
            currency = new Currency(j);
            
        }
        if (soapObject.hasProperty("Customer")) {
            SoapObject j = (SoapObject) soapObject.getProperty("Customer");
            customer = new Customer(j);
            
        }
        if (soapObject.hasProperty("RefPartnerType")) {
            SoapObject j = (SoapObject) soapObject.getProperty("RefPartnerType");
            refPartnerType = new RefPartnerType(j);
            
        }
        if (soapObject.hasProperty("Reseller")) {
            SoapObject j = (SoapObject) soapObject.getProperty("Reseller");
            reseller = new Reseller(j);
            
        }
        if (soapObject.hasProperty("Wholesaler")) {
            SoapObject j = (SoapObject) soapObject.getProperty("Wholesaler");
            wholesaler = new Wholesaler(j);
            
        }
    }
    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return idPartner;
            case 1:
                return partnerTypeCode;
            case 2:
                return currencyCode;
            case 3:
                return balance;
            case 4:
                return dateCreated;
            case 5:
                return currency;
            case 6:
                return customer;
            case 7:
                return refPartnerType;
            case 8:
                return reseller;
            case 9:
                return wholesaler;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 10;
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
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "PartnerTypeCode";
                break;
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "CurrencyCode";
                break;
            case 3:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "Balance";
                break;
            case 4:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "DateCreated";
                break;
            case 5:
                info.type = Currency.class;
                info.name = "Currency";
                break;
            case 6:
                info.type = Customer.class;
                info.name = "Customer";
                break;
            case 7:
                info.type = RefPartnerType.class;
                info.name = "RefPartnerType";
                break;
            case 8:
                info.type = Reseller.class;
                info.name = "Reseller";
                break;
            case 9:
                info.type = Wholesaler.class;
                info.name = "Wholesaler";
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