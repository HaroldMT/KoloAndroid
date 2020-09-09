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

public class Partner extends AttributeContainer implements KvmSerializable
{

    
    private transient java.lang.Object __source;    
    
    private Integer IdPartner=0;
    
    private String PartnerTypeCode;
    
    private String CurrencyCode;
    
    private Integer Balance=0;
    
    private String DateCreated;
    
    private ArrayOfAccountOperation AccountOperations;
    
    private ArrayOfCommission Commissions;
    
    private Currency Currency;
    
    private Customer Customer;
    
    private RefPartnerType RefPartnerType;
    
    private ArrayOfPartnerAddress PartnerAddresses;
    
    private ArrayOfProvision Provisions;
    
    private ArrayOfProvision Provisions1;
    
    private Reseller Reseller;
    
    private ArrayOfTransfert2Cash Transfert2Cash;
    
    private Wholesaler Wholesaler;
    
    private ArrayOfWholeSalerHistory WholeSalerHistories;
    
    public Integer getIdPartner()
    {
        return this.IdPartner;
    }
    
    public void setIdPartner(Integer value)
    {
        this.IdPartner = value;     
    }
    
    public String getPartnerTypeCode()
    {
        return this.PartnerTypeCode;
    }
    
    public void setPartnerTypeCode(String value)
    {
        this.PartnerTypeCode = value;     
    }
    
    public String getCurrencyCode()
    {
        return this.CurrencyCode;
    }
    
    public void setCurrencyCode(String value)
    {
        this.CurrencyCode = value;     
    }
    
    public Integer getBalance()
    {
        return this.Balance;
    }
    
    public void setBalance(Integer value)
    {
        this.Balance = value;     
    }
    
    public String getDateCreated()
    {
        return this.DateCreated;
    }
    
    public void setDateCreated(String value)
    {
        this.DateCreated = value;     
    }
    
    public ArrayOfAccountOperation getAccountOperations()
    {
        return this.AccountOperations;
    }
    
    public void setAccountOperations(ArrayOfAccountOperation value)
    {
        this.AccountOperations = value;     
    }
    
    public ArrayOfCommission getCommissions()
    {
        return this.Commissions;
    }
    
    public void setCommissions(ArrayOfCommission value)
    {
        this.Commissions = value;     
    }
    
    public Currency getCurrency()
    {
        return this.Currency;
    }
    
    public void setCurrency(Currency value)
    {
        this.Currency = value;     
    }
    
    public Customer getCustomer()
    {
        return this.Customer;
    }
    
    public void setCustomer(Customer value)
    {
        this.Customer = value;     
    }
    
    public RefPartnerType getRefPartnerType()
    {
        return this.RefPartnerType;
    }
    
    public void setRefPartnerType(RefPartnerType value)
    {
        this.RefPartnerType = value;     
    }
    
    public ArrayOfPartnerAddress getPartnerAddresses()
    {
        return this.PartnerAddresses;
    }
    
    public void setPartnerAddresses(ArrayOfPartnerAddress value)
    {
        this.PartnerAddresses = value;     
    }
    
    public ArrayOfProvision getProvisions()
    {
        return this.Provisions;
    }
    
    public void setProvisions(ArrayOfProvision value)
    {
        this.Provisions = value;     
    }
    
    public ArrayOfProvision getProvisions1()
    {
        return this.Provisions1;
    }
    
    public void setProvisions1(ArrayOfProvision value)
    {
        this.Provisions1 = value;     
    }
    
    public Reseller getReseller()
    {
        return this.Reseller;
    }
    
    public void setReseller(Reseller value)
    {
        this.Reseller = value;     
    }
    
    public ArrayOfTransfert2Cash getTransfert2Cash()
    {
        return this.Transfert2Cash;
    }
    
    public void setTransfert2Cash(ArrayOfTransfert2Cash value)
    {
        this.Transfert2Cash = value;     
    }
    
    public Wholesaler getWholesaler()
    {
        return this.Wholesaler;
    }
    
    public void setWholesaler(Wholesaler value)
    {
        this.Wholesaler = value;     
    }
    
    public ArrayOfWholeSalerHistory getWholeSalerHistories()
    {
        return this.WholeSalerHistories;
    }
    
    public void setWholeSalerHistories(ArrayOfWholeSalerHistory value)
    {
        this.WholeSalerHistories = value;     
    }


    public Partner(SoapObject j){
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
        if (info.name.equals("PartnerTypeCode"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.PartnerTypeCode = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.PartnerTypeCode = (String)obj;
                }
                else{
                    this.PartnerTypeCode = "";
                }
            }
            return true;
        }
        if (info.name.equals("CurrencyCode"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.CurrencyCode = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.CurrencyCode = (String)obj;
                }
                else{
                    this.CurrencyCode = "";
                }
            }
            return true;
        }
        if (info.name.equals("Balance"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.Balance = Integer.parseInt(j.toString());
                    }
                }
                else if (obj instanceof Integer){
                    this.Balance = (Integer)obj;
                }
            }
            return true;
        }
        if (info.name.equals("DateCreated"))
        {
            if(obj!=null)
            {
                if (obj instanceof SoapPrimitive)
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    if(j.toString()!=null)
                    {
                        this.DateCreated = j.toString();
                    }
                }
                else if (obj instanceof String){
                    this.DateCreated = (String)obj;
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
        if (info.name.equals("Commissions"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Commissions = (ArrayOfCommission)__envelope.get(j,ArrayOfCommission.class,false);
            }
            return true;
        }
        if (info.name.equals("Currency"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Currency = (Currency)__envelope.get(j,Currency.class,false);
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
        if (info.name.equals("RefPartnerType"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.RefPartnerType = (RefPartnerType)__envelope.get(j,RefPartnerType.class,false);
            }
            return true;
        }
        if (info.name.equals("PartnerAddresses"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.PartnerAddresses = (ArrayOfPartnerAddress)__envelope.get(j,ArrayOfPartnerAddress.class,false);
            }
            return true;
        }
        if (info.name.equals("Provisions"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Provisions = (ArrayOfProvision)__envelope.get(j,ArrayOfProvision.class,false);
            }
            return true;
        }
        if (info.name.equals("Provisions1"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Provisions1 = (ArrayOfProvision)__envelope.get(j,ArrayOfProvision.class,false);
            }
            return true;
        }
        if (info.name.equals("Reseller"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Reseller = (Reseller)__envelope.get(j,Reseller.class,false);
            }
            return true;
        }
        if (info.name.equals("Transfert2Cash"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Transfert2Cash = (ArrayOfTransfert2Cash)__envelope.get(j,ArrayOfTransfert2Cash.class,false);
            }
            return true;
        }
        if (info.name.equals("Wholesaler"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.Wholesaler = (Wholesaler)__envelope.get(j,Wholesaler.class,false);
            }
            return true;
        }
        if (info.name.equals("WholeSalerHistories"))
        {
            if(obj!=null)
            {
                java.lang.Object j = obj;
                this.WholeSalerHistories = (ArrayOfWholeSalerHistory)__envelope.get(j,ArrayOfWholeSalerHistory.class,false);
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
            return this.PartnerTypeCode!=null?this.PartnerTypeCode:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==2)
        {
            return this.CurrencyCode!=null?this.CurrencyCode:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==3)
        {
            return this.Balance;
        }
        else if(propertyIndex==4)
        {
            return this.DateCreated!=null?this.DateCreated:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==5)
        {
            return this.AccountOperations!=null?this.AccountOperations:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==6)
        {
            return this.Commissions!=null?this.Commissions:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==7)
        {
            return this.Currency!=null?this.Currency:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==8)
        {
            return this.Customer!=null?this.Customer:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==9)
        {
            return this.RefPartnerType!=null?this.RefPartnerType:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==10)
        {
            return this.PartnerAddresses!=null?this.PartnerAddresses:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==11)
        {
            return this.Provisions!=null?this.Provisions:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==12)
        {
            return this.Provisions1!=null?this.Provisions1:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==13)
        {
            return this.Reseller!=null?this.Reseller:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==14)
        {
            return this.Transfert2Cash!=null?this.Transfert2Cash:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==15)
        {
            return this.Wholesaler!=null?this.Wholesaler:SoapPrimitive.NullSkip;
        }
        else if(propertyIndex==16)
        {
            return this.WholeSalerHistories!=null?this.WholeSalerHistories:SoapPrimitive.NullSkip;
        }
        return null;
    }


    @Override
    public int getPropertyCount() {
        return 17;
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
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "PartnerTypeCode";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==2)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "CurrencyCode";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==3)
        {
            info.type = PropertyInfo.INTEGER_CLASS;
            info.name = "Balance";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==4)
        {
            info.type = PropertyInfo.STRING_CLASS;
            info.name = "DateCreated";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==5)
        {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "AccountOperations";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==6)
        {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "Commissions";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==7)
        {
            info.type = Currency.class;
            info.name = "Currency";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==8)
        {
            info.type = Customer.class;
            info.name = "Customer";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==9)
        {
            info.type = RefPartnerType.class;
            info.name = "RefPartnerType";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==10)
        {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "PartnerAddresses";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==11)
        {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "Provisions";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==12)
        {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "Provisions1";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==13)
        {
            info.type = Reseller.class;
            info.name = "Reseller";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==14)
        {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "Transfert2Cash";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==15)
        {
            info.type = Wholesaler.class;
            info.name = "Wholesaler";
            info.namespace= "http://kolo.cyberix.fr/";
        }
        else if(propertyIndex==16)
        {
            info.type = PropertyInfo.VECTOR_CLASS;
            info.name = "WholeSalerHistories";
            info.namespace= "http://kolo.cyberix.fr/";
        }
    }

    @Override
    public void setProperty(int arg0, java.lang.Object arg1)
    {
    }

    
}
