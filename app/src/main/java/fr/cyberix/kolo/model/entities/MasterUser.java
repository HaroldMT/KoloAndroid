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

public class MasterUser extends AttributeContainer implements KvmSerializable
{

    
    private transient java.lang.Object __source;    
    
    private Integer IdMasterUser=0;
    
    private String FirstName;
    
    private String LastName;
    
    private String Telephone;
    
    private String Email;
    
    private String DateCreation;
    
    private ArrayOfMasterUserHistory MasterUserHistories;
    
    public Integer getIdMasterUser()
    {
        return this.IdMasterUser;
    }
    
    public void setIdMasterUser(Integer value)
    {
        this.IdMasterUser = value;     
    }
    
    public String getFirstName()
    {
        return this.FirstName;
    }
    
    public void setFirstName(String value)
    {
        this.FirstName = value;     
    }
    
    public String getLastName()
    {
        return this.LastName;
    }
    
    public void setLastName(String value)
    {
        this.LastName = value;     
    }
    
    public String getTelephone()
    {
        return this.Telephone;
    }
    
    public void setTelephone(String value)
    {
        this.Telephone = value;     
    }
    
    public String getEmail()
    {
        return this.Email;
    }
    
    public void setEmail(String value)
    {
        this.Email = value;     
    }
    
    public String getDateCreation()
    {
        return this.DateCreation;
    }
    
    public void setDateCreation(String value)
    {
        this.DateCreation = value;     
    }
    
    public ArrayOfMasterUserHistory getMasterUserHistories()
    {
        return this.MasterUserHistories;
    }
    
    public void setMasterUserHistories(ArrayOfMasterUserHistory value)
    {
        this.MasterUserHistories = value;     
    }


    public MasterUser(SoapObject j){
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
        if (info.name.equals("IdMasterUser"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.IdMasterUser = Integer.parseInt(j.toString());
                    }
                }
                else if (obj instanceof Integer){
                    this.IdMasterUser = (Integer)obj;
                }
            }
            return true;
        }
        if (info.name.equals("FirstName"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.FirstName = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.FirstName = (String)obj;
                }
                else{
                    this.FirstName = "";
                }
            }
            return true;
        }
        if (info.name.equals("LastName"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.LastName = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.LastName = (String)obj;
                }
                else{
                    this.LastName = "";
                }
            }
            return true;
        }
        if (info.name.equals("Telephone"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.Telephone = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.Telephone = (String)obj;
                }
                else{
                    this.Telephone = "";
                }
            }
            return true;
        }
        if (info.name.equals("Email"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.Email = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.Email = (String)obj;
                }
                else{
                    this.Email = "";
                }
            }
            return true;
        }
        if (info.name.equals("DateCreation"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.DateCreation = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.DateCreation = (String)obj;
                }
            }
            return true;
        }
        if (info.name.equals("MasterUserHistories"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.MasterUserHistories = (ArrayOfMasterUserHistory)__envelope.get(j,ArrayOfMasterUserHistory.class,false);
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
            return this.IdMasterUser;
        }
        else if(propertyIndex==1)
        {
            return this.FirstName!=null?this.FirstName:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==2)
        {
            return this.LastName!=null?this.LastName:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==3)
        {
            return this.Telephone!=null?this.Telephone:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==4)
        {
            return this.Email!=null?this.Email:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==5)
        {
            return this.DateCreation!=null?this.DateCreation:SoapPrimitive.NullNilElement;
        }
        else if(propertyIndex==6)
        {
            return this.MasterUserHistories!=null?this.MasterUserHistories:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 7;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "IdMasterUser";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "FirstName";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==2)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "LastName";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==3)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "Telephone";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==4)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "Email";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==5)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "DateCreation";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==6)
        {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "MasterUserHistories";
            info.namespace= "http://kolo.cyberix.fr/";
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}