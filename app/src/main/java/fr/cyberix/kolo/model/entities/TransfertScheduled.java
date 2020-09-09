package fr.cyberix.kolo.model.entities;
//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 5.10.3.0
//
// Created by Quasar Development 
//
//----------------------------------------------------



import java.util.Hashtable;
import org.ksoap2.serialization.*;

public class TransfertScheduled extends AttributeContainer implements KvmSerializable
{

    
    private transient java.lang.Object __source;    
    
    private Integer IdTransfertScheduled=0;
    
    private Integer IdSendingCustomer=0;
    
    private Integer IdReceiverCustomer=0;
    
    private String DateScheduled;
    
    private Customer Customer;
    
    private Customer Customer1;
    
    public Integer getIdTransfertScheduled()
    {
        return this.IdTransfertScheduled;
    }
    
    public void setIdTransfertScheduled(Integer value)
    {
        this.IdTransfertScheduled = value;     
    }
    
    public Integer getIdSendingCustomer()
    {
        return this.IdSendingCustomer;
    }
    
    public void setIdSendingCustomer(Integer value)
    {
        this.IdSendingCustomer = value;     
    }
    
    public Integer getIdReceiverCustomer()
    {
        return this.IdReceiverCustomer;
    }
    
    public void setIdReceiverCustomer(Integer value)
    {
        this.IdReceiverCustomer = value;     
    }
    
    public String getDateScheduled()
    {
        return this.DateScheduled;
    }
    
    public void setDateScheduled(String value)
    {
        this.DateScheduled = value;     
    }
    
    public Customer getCustomer()
    {
        return this.Customer;
    }
    
    public void setCustomer(Customer value)
    {
        this.Customer = value;     
    }
    
    public Customer getCustomer1()
    {
        return this.Customer1;
    }
    
    public void setCustomer1(Customer value)
    {
        this.Customer1 = value;     
    }


    public TransfertScheduled(SoapObject j){
        loadFromSoap(j, new ExtendedSoapSerializationEnvelope());
    }
    
    public void loadFromSoap(java.lang.Object paramObj,ExtendedSoapSerializationEnvelope __envelope)
    {
        if (paramObj == null)
            return;
        AttributeContainer inObj=(AttributeContainer)paramObj;
        __source=inObj; 
        
        if(inObj instanceof SoapObject)
        {
            SoapObject soapObject=(SoapObject)inObj;
            int size = soapObject.getPropertyCount();
            for (int i0=0;i0< size;i0++)
            {
                PropertyInfo info=soapObject.getPropertyInfo(i0);
                if(!loadProperty(info,soapObject,__envelope))
                {
                }
            } 
        }



    }

    
    protected boolean loadProperty(PropertyInfo info,SoapObject soapObject,ExtendedSoapSerializationEnvelope __envelope)
    {
        java.lang.Object obj = info.getValue();
        if (info.name.equals("IdTransfertScheduled"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.IdTransfertScheduled = Integer.parseInt(j.toString());
                    }
                }
                else if (obj instanceof Integer){
                    this.IdTransfertScheduled = (Integer)obj;
                }
            }
            return true;
        }
        if (info.name.equals("IdSendingCustomer"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.IdSendingCustomer = Integer.parseInt(j.toString());
                    }
                }
                else if (obj instanceof Integer){
                    this.IdSendingCustomer = (Integer)obj;
                }
            }
            return true;
        }
        if (info.name.equals("IdReceiverCustomer"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.IdReceiverCustomer = Integer.parseInt(j.toString());
                    }
                }
                else if (obj instanceof Integer){
                    this.IdReceiverCustomer = (Integer)obj;
                }
            }
            return true;
        }
        if (info.name.equals("DateScheduled"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.DateScheduled = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.DateScheduled = (String)obj;
                }
            }
            return true;
        }
        if (info.name.equals("Customer"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Customer = (Customer)__envelope.get(j,Customer.class,false);
            }
            return true;
        }
        if (info.name.equals("Customer1"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Customer1 = (Customer)__envelope.get(j,Customer.class,false);
            }
            return true;
        }
        return false;
    }
    
    public java.lang.Object getOriginalXmlSource()
    {
        return __source;
    }    
    

    @Override
    public java.lang.Object getProperty(int propertyIndex) {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if(propertyIndex==0)
        {
            return this.IdTransfertScheduled;
        }
        else if(propertyIndex==1)
        {
            return this.IdSendingCustomer;
        }
        else if(propertyIndex==2)
        {
            return this.IdReceiverCustomer;
        }
        else if(propertyIndex==3)
        {
            return this.DateScheduled!=null?this.DateScheduled:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==4)
        {
            return this.Customer!=null?this.Customer:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==5)
        {
            return this.Customer1!=null?this.Customer1:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 6;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "IdTransfertScheduled";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==1)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "IdSendingCustomer";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==2)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "IdReceiverCustomer";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==3)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "DateScheduled";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==4)
        {
            info.type = Customer.class;
            info.name = "Customer";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==5)
        {
            info.type = Customer.class;
            info.name = "Customer1";
            info.namespace= "http://kolo.cyberix.fr/";
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}
