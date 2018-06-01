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

public class PartnerAddress implements KvmSerializable {

    public int idPartner;
    public int idAddress;
    public String addresseTypeCode;
    public Adresse adresse;
    public Partner partner;

    public PartnerAddress() {
    }

    public PartnerAddress(SoapObject soapObject) {
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
        if (soapObject.hasProperty("IdAddress")) {
            Object obj = soapObject.getProperty("IdAddress");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                idAddress = Integer.parseInt(j.toString());
            } else if (obj != null && obj instanceof Number) {
                idAddress = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("AddresseTypeCode")) {
            Object obj = soapObject.getProperty("AddresseTypeCode");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                addresseTypeCode = j.toString();
            } else if (obj != null && obj instanceof String) {
                addresseTypeCode = (String) obj;
            }
        }
        if (soapObject.hasProperty("Adresse")) {
            SoapObject j = (SoapObject) soapObject.getProperty("Adresse");
            adresse = new Adresse(j);

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
                return idAddress;
            case 2:
                return addresseTypeCode;
            case 3:
                return adresse;
            case 4:
                return partner;
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
                info.name = "IdPartner";
                break;
            case 1:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "IdAddress";
                break;
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "AddresseTypeCode";
                break;
            case 3:
                info.type = Adresse.class;
                info.name = "Adresse";
                break;
            case 4:
                info.type = Partner.class;
                info.name = "Partner";
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
