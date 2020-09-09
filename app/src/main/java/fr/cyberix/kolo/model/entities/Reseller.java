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

public class Reseller extends AttributeContainer implements KvmSerializable
{

    
    private transient java.lang.Object __source;    
    
    private Integer IdPartner=0;
    
    private Integer IdWholesalerPartner=0;
    
    private Partner Partner;
    
    public Integer getIdPartner()
    {
        return this.IdPartner;
    }
    
    public void setIdPartner(Integer value)
    {
        this.IdPartner = value;     
    }
    
    public Integer getIdWholesalerPartner()
    {
        return this.IdWholesalerPartner;
    }
    
    public void setIdWholesalerPartner(Integer value)
    {
        this.IdWholesalerPartner = value;     
    }
    
    public Partner getPartner()
    {
        return this.Partner;
    }
    
    public void setPartner(Partner value)
    {
        this.Partner = value;     
    }


    public Reseller(SoapObject j){
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
        if (info.name.equals("IdPartner"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.IdPartner = Integer.parseInt(j.toString());
                    }
                }
                else if (obj instanceof Integer){
                    this.IdPartner = (Integer)obj;
                }
            }
            return true;
        }
        if (info.name.equals("IdWholesalerPartner"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.IdWholesalerPartner = Integer.parseInt(j.toString());
                    }
                }
                else if (obj instanceof Integer){
                    this.IdWholesalerPartner = (Integer)obj;
                }
            }
            return true;
        }
        if (info.name.equals("Partner"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Partner = (Partner)__envelope.get(j,Partner.class,false);
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
            return this.IdPartner;
        }
        else if(propertyIndex==1)
        {
            return this.IdWholesalerPartner;
        }
        else if(propertyIndex==2)
        {
            return this.Partner!=null?this.Partner:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 3;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "IdPartner";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==1)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "IdWholesalerPartner";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==2)
        {
            info.type = Partner.class;
            info.name = "Partner";
            info.namespace= "http://kolo.cyberix.fr/";
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}
