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

public class RefOperationStatu extends AttributeContainer implements KvmSerializable
{

    
    private transient java.lang.Object __source;    
    
    private String OperationStatusCode;
    
    private String OperationStatusDescription;
    
    private ArrayOfAccountOperation AccountOperations;
    
    private ArrayOfAccountOperationRequest AccountOperationRequests;
    
    public String getOperationStatusCode()
    {
        return this.OperationStatusCode;
    }
    
    public void setOperationStatusCode(String value)
    {
        this.OperationStatusCode = value;     
    }
    
    public String getOperationStatusDescription()
    {
        return this.OperationStatusDescription;
    }
    
    public void setOperationStatusDescription(String value)
    {
        this.OperationStatusDescription = value;     
    }
    
    public ArrayOfAccountOperation getAccountOperations()
    {
        return this.AccountOperations;
    }
    
    public void setAccountOperations(ArrayOfAccountOperation value)
    {
        this.AccountOperations = value;     
    }
    
    public ArrayOfAccountOperationRequest getAccountOperationRequests()
    {
        return this.AccountOperationRequests;
    }
    
    public void setAccountOperationRequests(ArrayOfAccountOperationRequest value)
    {
        this.AccountOperationRequests = value;     
    }


    public RefOperationStatu(SoapObject j){
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
        if (info.name.equals("OperationStatusCode"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.OperationStatusCode = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.OperationStatusCode = (String)obj;
                }
                else{
                    this.OperationStatusCode = "";
                }
            }
            return true;
        }
        if (info.name.equals("OperationStatusDescription"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.OperationStatusDescription = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.OperationStatusDescription = (String)obj;
                }
                else{
                    this.OperationStatusDescription = "";
                }
            }
            return true;
        }
        if (info.name.equals("AccountOperations"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.AccountOperations = (ArrayOfAccountOperation)__envelope.get(j,ArrayOfAccountOperation.class,false);
            }
            return true;
        }
        if (info.name.equals("AccountOperationRequests"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.AccountOperationRequests = (ArrayOfAccountOperationRequest)__envelope.get(j,ArrayOfAccountOperationRequest.class,false);
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
            return this.OperationStatusCode!=null?this.OperationStatusCode:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==1)
        {
            return this.OperationStatusDescription!=null?this.OperationStatusDescription:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==2)
        {
            return this.AccountOperations!=null?this.AccountOperations:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==3)
        {
            return this.AccountOperationRequests!=null?this.AccountOperationRequests:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 4;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "OperationStatusCode";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "OperationStatusDescription";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==2)
        {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "AccountOperations";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==3)
        {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "AccountOperationRequests";
            info.namespace= "http://kolo.cyberix.fr/";
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}
