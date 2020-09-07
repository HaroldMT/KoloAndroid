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

public class District extends AttributeContainer implements KvmSerializable
{

    
    private transient java.lang.Object __source;    
    
    private Integer IdDistrict=0;
    
    private String DistrictName;
    
    private String CountryCode;
    
    private ArrayOfCity Cities;
    
    public Integer getIdDistrict()
    {
        return this.IdDistrict;
    }
    
    public void setIdDistrict(Integer value)
    {
        this.IdDistrict = value;     
    }
    
    public String getDistrictName()
    {
        return this.DistrictName;
    }
    
    public void setDistrictName(String value)
    {
        this.DistrictName = value;     
    }
    
    public String getCountryCode()
    {
        return this.CountryCode;
    }
    
    public void setCountryCode(String value)
    {
        this.CountryCode = value;     
    }
    
    public ArrayOfCity getCities()
    {
        return this.Cities;
    }
    
    public void setCities(ArrayOfCity value)
    {
        this.Cities = value;     
    }


    public District(SoapObject j){
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
        if (info.name.equals("IdDistrict"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.IdDistrict = Integer.parseInt(j.toString());
                    }
                }
                else if (obj instanceof Integer){
                    this.IdDistrict = (Integer)obj;
                }
            }
            return true;
        }
        if (info.name.equals("DistrictName"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.DistrictName = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.DistrictName = (String)obj;
                }
                else{
                    this.DistrictName = "";
                }
            }
            return true;
        }
        if (info.name.equals("CountryCode"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.CountryCode = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.CountryCode = (String)obj;
                }
                else{
                    this.CountryCode = "";
                }
            }
            return true;
        }
        if (info.name.equals("Cities"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Cities = (ArrayOfCity)__envelope.get(j,ArrayOfCity.class,false);
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
            return this.IdDistrict;
        }
        else if(propertyIndex==1)
        {
            return this.DistrictName!=null?this.DistrictName:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==2)
        {
            return this.CountryCode!=null?this.CountryCode:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==3)
        {
            return this.Cities!=null?this.Cities:SoapPrimitive.NullSkip;
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
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "IdDistrict";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==1)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "DistrictName";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==2)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "CountryCode";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==3)
        {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "Cities";
            info.namespace= "http://kolo.cyberix.fr/";
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}
