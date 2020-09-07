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

public class TransferGravity extends AttributeContainer implements KvmSerializable
{

    
    private transient java.lang.Object __source;    
    
    private Integer TransferMadId=0;
    
    private String GravityReference;
    
    private String KoloReference;
    
    private Integer KoloSenderId=0;
    
    private Integer GravitySenderId=0;
    
    private Integer GravityReceiverId=0;
    
    private Integer Amount=0;
    
    private Boolean Received=false;
    
    private String ReceiverLastName;
    
    private String ReceiverFirstName;
    
    private String ReceiverPhoneNumber;
    
    private Customer Customer;
    
    public Integer getTransferMadId()
    {
        return this.TransferMadId;
    }
    
    public void setTransferMadId(Integer value)
    {
        this.TransferMadId = value;     
    }
    
    public String getGravityReference()
    {
        return this.GravityReference;
    }
    
    public void setGravityReference(String value)
    {
        this.GravityReference = value;     
    }
    
    public String getKoloReference()
    {
        return this.KoloReference;
    }
    
    public void setKoloReference(String value)
    {
        this.KoloReference = value;     
    }
    
    public Integer getKoloSenderId()
    {
        return this.KoloSenderId;
    }
    
    public void setKoloSenderId(Integer value)
    {
        this.KoloSenderId = value;     
    }
    
    public Integer getGravitySenderId()
    {
        return this.GravitySenderId;
    }
    
    public void setGravitySenderId(Integer value)
    {
        this.GravitySenderId = value;     
    }
    
    public Integer getGravityReceiverId()
    {
        return this.GravityReceiverId;
    }
    
    public void setGravityReceiverId(Integer value)
    {
        this.GravityReceiverId = value;     
    }
    
    public Integer getAmount()
    {
        return this.Amount;
    }
    
    public void setAmount(Integer value)
    {
        this.Amount = value;     
    }
    
    public Boolean getReceived()
    {
        return this.Received;
    }
    
    public void setReceived(Boolean value)
    {
        this.Received = value;     
    }
    
    public String getReceiverLastName()
    {
        return this.ReceiverLastName;
    }
    
    public void setReceiverLastName(String value)
    {
        this.ReceiverLastName = value;     
    }
    
    public String getReceiverFirstName()
    {
        return this.ReceiverFirstName;
    }
    
    public void setReceiverFirstName(String value)
    {
        this.ReceiverFirstName = value;     
    }
    
    public String getReceiverPhoneNumber()
    {
        return this.ReceiverPhoneNumber;
    }
    
    public void setReceiverPhoneNumber(String value)
    {
        this.ReceiverPhoneNumber = value;     
    }
    
    public Customer getCustomer()
    {
        return this.Customer;
    }
    
    public void setCustomer(Customer value)
    {
        this.Customer = value;     
    }


    public TransferGravity(SoapObject j){
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
        if (info.name.equals("TransferMadId"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.TransferMadId = Integer.parseInt(j.toString());
                    }
                }
                else if (obj instanceof Integer){
                    this.TransferMadId = (Integer)obj;
                }
            }
            return true;
        }
        if (info.name.equals("GravityReference"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.GravityReference = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.GravityReference = (String)obj;
                }
                else{
                    this.GravityReference = "";
                }
            }
            return true;
        }
        if (info.name.equals("KoloReference"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.KoloReference = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.KoloReference = (String)obj;
                }
                else{
                    this.KoloReference = "";
                }
            }
            return true;
        }
        if (info.name.equals("KoloSenderId"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.KoloSenderId = Integer.parseInt(j.toString());
                    }
                }
                else if (obj instanceof Integer){
                    this.KoloSenderId = (Integer)obj;
                }
            }
            return true;
        }
        if (info.name.equals("GravitySenderId"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.GravitySenderId = Integer.parseInt(j.toString());
                    }
                }
                else if (obj instanceof Integer){
                    this.GravitySenderId = (Integer)obj;
                }
            }
            return true;
        }
        if (info.name.equals("GravityReceiverId"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.GravityReceiverId = Integer.parseInt(j.toString());
                    }
                }
                else if (obj instanceof Integer){
                    this.GravityReceiverId = (Integer)obj;
                }
            }
            return true;
        }
        if (info.name.equals("Amount"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.Amount = Integer.parseInt(j.toString());
                    }
                }
                else if (obj instanceof Integer){
                    this.Amount = (Integer)obj;
                }
            }
            return true;
        }
        if (info.name.equals("Received"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.Received = Boolean.valueOf(j.toString());
                    }
                }
                else if (obj instanceof Boolean){
                    this.Received = (Boolean)obj;
                }
            }
            return true;
        }
        if (info.name.equals("ReceiverLastName"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.ReceiverLastName = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.ReceiverLastName = (String)obj;
                }
                else{
                    this.ReceiverLastName = "";
                }
            }
            return true;
        }
        if (info.name.equals("ReceiverFirstName"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.ReceiverFirstName = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.ReceiverFirstName = (String)obj;
                }
                else{
                    this.ReceiverFirstName = "";
                }
            }
            return true;
        }
        if (info.name.equals("ReceiverPhoneNumber"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.ReceiverPhoneNumber = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.ReceiverPhoneNumber = (String)obj;
                }
                else{
                    this.ReceiverPhoneNumber = "";
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
            return this.TransferMadId;
        }
        else if(propertyIndex==1)
        {
            return this.GravityReference!=null?this.GravityReference:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==2)
        {
            return this.KoloReference!=null?this.KoloReference:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==3)
        {
            return this.KoloSenderId;
        }
        else if(propertyIndex==4)
        {
            return this.GravitySenderId;
        }
        else if(propertyIndex==5)
        {
            return this.GravityReceiverId;
        }
        else if(propertyIndex==6)
        {
            return this.Amount;
        }
        else if(propertyIndex==7)
        {
            return this.Received;
        }
        else if(propertyIndex==8)
        {
            return this.ReceiverLastName!=null?this.ReceiverLastName:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==9)
        {
            return this.ReceiverFirstName!=null?this.ReceiverFirstName:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==10)
        {
            return this.ReceiverPhoneNumber!=null?this.ReceiverPhoneNumber:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==11)
        {
            return this.Customer!=null?this.Customer:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 12;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "TransferMadId";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "GravityReference";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==2)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "KoloReference";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==3)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "KoloSenderId";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==4)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "GravitySenderId";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==5)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "GravityReceiverId";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==6)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "Amount";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==7)
        {
            info.type = PropertyInfo.BOOLEAN_CLASS;
            info.name = "Received";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==8)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "ReceiverLastName";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==9)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "ReceiverFirstName";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==10)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "ReceiverPhoneNumber";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==11)
        {
            info.type = Customer.class;
            info.name = "Customer";
            info.namespace= "http://kolo.cyberix.fr/";
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}
