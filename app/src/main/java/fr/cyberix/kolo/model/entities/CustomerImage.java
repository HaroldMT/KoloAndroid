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

import fr.cyberix.kolo.ksoap2.VectorByte;

public class CustomerImage implements KvmSerializable {

    private int idCustomer;
    private VectorByte imageBytes;
    private Customer customer;

    public CustomerImage() {
    }

    public CustomerImage(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("IdCustomer")) {
            Object obj = soapObject.getProperty("IdCustomer");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                setIdCustomer(Integer.parseInt(j.toString()));
            } else if (obj != null && obj instanceof Number) {
                setIdCustomer((Integer) obj);
            }
        }
        if (soapObject.hasProperty("ImageBytes")) {
            SoapPrimitive j = (SoapPrimitive) soapObject.getProperty("ImageBytes");
            setImageBytes(new VectorByte(j));
        }
        if (soapObject.hasProperty("Customer")) {
            SoapObject j = (SoapObject) soapObject.getProperty("Customer");
            setCustomer(new Customer(j));
            
        }
    }
    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return getIdCustomer();
            case 1:
                return getImageBytes().toString();
            case 2:
                return getCustomer();
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
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "ImageBytes";
                break;
            case 2:
                info.type = Customer.class;
                info.name = "Customer";
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

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public VectorByte getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(VectorByte imageBytes) {
        this.imageBytes = imageBytes;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
