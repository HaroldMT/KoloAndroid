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

public class EneoBillPayment extends AttributeContainer implements KvmSerializable
{

    
    private transient java.lang.Object __source;    
    
    private Integer IdEneoBillPayment=0;
    
    private Integer IdCustomer=0;
    
    private String PaymentDate;
    //private java.util.Date PaymentDate;

    private String ContractNo;
    
    private String BillNumber;
    
    private Integer Fee=0;
    
    private Integer Ccion=0;
    
    private Integer BillAmount=0;
    
    private String Reference;
    
    private Customer Customer;
    
    public Integer getIdEneoBillPayment()
    {
        return this.IdEneoBillPayment;
    }
    
    public void setIdEneoBillPayment(Integer value)
    {
        this.IdEneoBillPayment = value;     
    }
    
    public Integer getIdCustomer()
    {
        return this.IdCustomer;
    }
    
    public void setIdCustomer(Integer value)
    {
        this.IdCustomer = value;     
    }
    
//    public java.util.Date getPaymentDate()
//    {
//        return this.PaymentDate;
//    }
//
//    public void setPaymentDate(java.util.Date value)
//    {
//        this.PaymentDate = value;
//    }

    public String getPaymentDate()
    {
        return this.PaymentDate;
    }

    public void setPaymentDate(String value)
    {
        this.PaymentDate = value;
    }
    
    public String getContractNo()
    {
        return this.ContractNo;
    }
    
    public void setContractNo(String value)
    {
        this.ContractNo = value;     
    }
    
    public String getBillNumber()
    {
        return this.BillNumber;
    }
    
    public void setBillNumber(String value)
    {
        this.BillNumber = value;     
    }
    
    public Integer getFee()
    {
        return this.Fee;
    }
    
    public void setFee(Integer value)
    {
        this.Fee = value;     
    }
    
    public Integer getCcion()
    {
        return this.Ccion;
    }
    
    public void setCcion(Integer value)
    {
        this.Ccion = value;     
    }
    
    public Integer getBillAmount()
    {
        return this.BillAmount;
    }
    
    public void setBillAmount(Integer value)
    {
        this.BillAmount = value;     
    }
    
    public String getReference()
    {
        return this.Reference;
    }
    
    public void setReference(String value)
    {
        this.Reference = value;     
    }
    
    public Customer getCustomer()
    {
        return this.Customer;
    }
    
    public void setCustomer(Customer value)
    {
        this.Customer = value;     
    }


    public EneoBillPayment(SoapObject j){
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
        if (info.name.equals("IdEneoBillPayment"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.IdEneoBillPayment = Integer.parseInt(j.toString());
                    }
                }
                else if (obj instanceof Integer){
                    this.IdEneoBillPayment = (Integer)obj;
                }
            }
            return true;
        }
        if (info.name.equals("IdCustomer"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.IdCustomer = Integer.parseInt(j.toString());
                    }
                }
                else if (obj instanceof Integer){
                    this.IdCustomer = (Integer)obj;
                }
            }
            return true;
        }
        if (info.name.equals("PaymentDate"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.PaymentDate = j.toString();
                        //this.PaymentDate = ExtendedSoapSerializationEnvelope.getDateTimeConverter().convertDateTime(j.toString());
                    }
                }
                else if (obj instanceof String){
                    this.PaymentDate = (String)obj;
                    //this.PaymentDate = (java.util.Date)obj;
                }
            }
            return true;
        }
        if (info.name.equals("ContractNo"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.ContractNo = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.ContractNo = (String)obj;
                }
                else{
                    this.ContractNo = "";
                }
            }
            return true;
        }
        if (info.name.equals("BillNumber"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.BillNumber = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.BillNumber = (String)obj;
                }
                else{
                    this.BillNumber = "";
                }
            }
            return true;
        }
        if (info.name.equals("Fee"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.Fee = Integer.parseInt(j.toString());
                    }
                }
                else if (obj instanceof Integer){
                    this.Fee = (Integer)obj;
                }
            }
            return true;
        }
        if (info.name.equals("Ccion"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.Ccion = Integer.parseInt(j.toString());
                    }
                }
                else if (obj instanceof Integer){
                    this.Ccion = (Integer)obj;
                }
            }
            return true;
        }
        if (info.name.equals("BillAmount"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.BillAmount = Integer.parseInt(j.toString());
                    }
                }
                else if (obj instanceof Integer){
                    this.BillAmount = (Integer)obj;
                }
            }
            return true;
        }
        if (info.name.equals("Reference"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.Reference = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.Reference = (String)obj;
                }
                else{
                    this.Reference = "";
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
            return this.IdEneoBillPayment;
        }
        else if(propertyIndex==1)
        {
            return this.IdCustomer;
        }
        else if(propertyIndex==2)
        {
            return this.PaymentDate!=null?this.PaymentDate:SoapPrimitive.NullSkip;
            //return this.PaymentDate!=null?ExtendedSoapSerializationEnvelope.getDateTimeConverter().getStringFromDateTime(this.PaymentDate):SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==3)
        {
            return this.ContractNo!=null?this.ContractNo:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==4)
        {
            return this.BillNumber!=null?this.BillNumber:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==5)
        {
            return this.Fee;
        }
        else if(propertyIndex==6)
        {
            return this.Ccion;
        }
        else if(propertyIndex==7)
        {
            return this.BillAmount;
        }
        else if(propertyIndex==8)
        {
            return this.Reference!=null?this.Reference:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==9)
        {
            return this.Customer!=null?this.Customer:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 10;
    }

    @Override
    public void getPropertyInfo(int propertyIndex, Hashtable arg1, PropertyInfo info)
    {
        if(propertyIndex==0)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "IdEneoBillPayment";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==1)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "IdCustomer";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==2)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "PaymentDate";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==3)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "ContractNo";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==4)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "BillNumber";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==5)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "Fee";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==6)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "Ccion";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==7)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "BillAmount";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==8)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "Reference";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==9)
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
