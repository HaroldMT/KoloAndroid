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

public class Customer implements KvmSerializable {

    public int idCustomer;
    public String customerTypeCode;
    public String currencyCode;
    public int balance;
    public String dateCreated;
    public int idRegistration;
    public Business business;
    public Currency currency;
    public Registration registration;
    public RefCustomerType refCustomerType;
    public MobileDevice mobileDevice;
    public CustomerImage customerImage;
    public CustomerLogin customerLogin;
    public Partner partner;
    public Person person;

    public Customer() {
    }

    public Customer(SoapObject soapObject) {
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
        if (soapObject.hasProperty("CustomerTypeCode")) {
            Object obj = soapObject.getProperty("CustomerTypeCode");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                customerTypeCode = j.toString();
            } else if (obj != null && obj instanceof String) {
                customerTypeCode = (String) obj;
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
        if (soapObject.hasProperty("IdRegistration")) {
            Object obj = soapObject.getProperty("IdRegistration");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                idRegistration = Integer.parseInt(j.toString());
            } else if (obj != null && obj instanceof Number) {
                idRegistration = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("Business")) {
            SoapObject j = (SoapObject) soapObject.getProperty("Business");
            business = new Business(j);

        }
        if (soapObject.hasProperty("Currency")) {
            SoapObject j = (SoapObject) soapObject.getProperty("Currency");
            currency = new Currency(j);

        }
        if (soapObject.hasProperty("Registration")) {
            SoapObject j = (SoapObject) soapObject.getProperty("Registration");
            registration = new Registration(j);

        }
        if (soapObject.hasProperty("RefCustomerType")) {
            SoapObject j = (SoapObject) soapObject.getProperty("RefCustomerType");
            refCustomerType = new RefCustomerType(j);

        }
        if (soapObject.hasProperty("MobileDevice")) {
            SoapObject j = (SoapObject) soapObject.getProperty("MobileDevice");
            mobileDevice = new MobileDevice(j);

        }
        if (soapObject.hasProperty("CustomerImage")) {
            SoapObject j = (SoapObject) soapObject.getProperty("CustomerImage");
            customerImage = new CustomerImage(j);

        }
        if (soapObject.hasProperty("CustomerLogin")) {
            SoapObject j = (SoapObject) soapObject.getProperty("CustomerLogin");
            customerLogin = new CustomerLogin(j);

        }
        if (soapObject.hasProperty("Partner")) {
            SoapObject j = (SoapObject) soapObject.getProperty("Partner");
            partner = new Partner(j);

        }
        if (soapObject.hasProperty("Person")) {
            SoapObject j = (SoapObject) soapObject.getProperty("Person");
            person = new Person(j);

        }
    }

    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return idCustomer;
            case 1:
                return customerTypeCode;
            case 2:
                return currencyCode;
            case 3:
                return balance;
            case 4:
                return dateCreated;
            case 5:
                return idRegistration;
            case 6:
                return business;
            case 7:
                return currency;
            case 8:
                return registration;
            case 9:
                return refCustomerType;
            case 10:
                return mobileDevice;
            case 11:
                return customerImage;
            case 12:
                return customerLogin;
            case 13:
                return partner;
            case 14:
                return person;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 15;
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
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "CustomerTypeCode";
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
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "IdRegistration";
                break;
            case 6:
                info.type = Business.class;
                info.name = "Business";
                break;
            case 7:
                info.type = Currency.class;
                info.name = "Currency";
                break;
            case 8:
                info.type = Registration.class;
                info.name = "Registration";
                break;
            case 9:
                info.type = RefCustomerType.class;
                info.name = "RefCustomerType";
                break;
            case 10:
                info.type = MobileDevice.class;
                info.name = "MobileDevice";
                break;
            case 11:
                info.type = CustomerImage.class;
                info.name = "CustomerImage";
                break;
            case 12:
                info.type = CustomerLogin.class;
                info.name = "CustomerLogin";
                break;
            case 13:
                info.type = Partner.class;
                info.name = "Partner";
                break;
            case 14:
                info.type = Person.class;
                info.name = "Person";
                break;
        }
    }

    public String getInnerText() {
        return null;
    }

    public void setInnerText(String s) {
    }

}
