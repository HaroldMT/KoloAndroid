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

public class RefBillType extends AttributeContainer implements KvmSerializable
{

    
    private transient java.lang.Object __source;    
    
    private String BillTypeCode;
    
    private String BillTypeDescription;
    
    private ArrayOfBill Bills;
    
    public String getBillTypeCode()
    {
        return this.BillTypeCode;
    }
    
    public void setBillTypeCode(String value)
    {
        this.BillTypeCode = value;     
    }
    
    public String getBillTypeDescription()
    {
        return this.BillTypeDescription;
    }
    
    public void setBillTypeDescription(String value)
    {
        this.BillTypeDescription = value;     
    }
    
    public ArrayOfBill getBills()
    {
        return this.Bills;
    }
    
    public void setBills(ArrayOfBill value)
    {
        this.Bills = value;     
    }


    public RefBillType(SoapObject j){
        loadFromSoap(j ,new ExtendedSoapSerializationEnvelope());
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
        if (info.name.equals("BillTypeCode"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.BillTypeCode = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.BillTypeCode = (String)obj;
                }
                else{
                    this.BillTypeCode = "";
                }
            }
            return true;
        }
        if (info.name.equals("BillTypeDescription"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.BillTypeDescription = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.BillTypeDescription = (String)obj;
                }
                else{
                    this.BillTypeDescription = "";
                }
            }
            return true;
        }
        if (info.name.equals("Bills"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Bills = (ArrayOfBill)__envelope.get(j,ArrayOfBill.class,false);
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
            return this.BillTypeCode!=null?this.BillTypeCode:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==1)
        {
            return this.BillTypeDescription!=null?this.BillTypeDescription:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==2)
        {
            return this.Bills!=null?this.Bills:SoapPrimitive.NullSkip;
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
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "BillTypeCode";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "BillTypeDescription";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==2)
        {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "Bills";
            info.namespace= "http://kolo.cyberix.fr/";
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}
