package fr.cyberix.kolo.model.entities;

//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 5.10.3.0
//
// Created by Quasar Development 
//
//----------------------------------------------------




import org.ksoap2.serialization.*;
import java.util.Vector;
import java.util.Hashtable;


public class ArrayOfKoloUser extends Vector<KoloUser> implements KvmSerializable
{
    private transient java.lang.Object __source;

    public ArrayOfKoloUser()
    {
    }

    public ArrayOfKoloUser(int initialCapactiy)
    {
        super(initialCapactiy);
    }

    public ArrayOfKoloUser(java.util.Collection< KoloUser> initialCapactiy)
    {
        super(initialCapactiy);
    }

    public ArrayOfKoloUser(SoapObject j){
        loadFromSoap(j, new ExtendedSoapSerializationEnvelope());
    }

    public void loadFromSoap(java.lang.Object inObj,ExtendedSoapSerializationEnvelope __envelope)
    {
        if (inObj == null)
            return;
        __source=inObj;
            SoapObject soapObject=(SoapObject)inObj;
            int size = soapObject.getPropertyCount();
            for (int i0=0;i0< size;i0++)
            {
                java.lang.Object obj = soapObject.getProperty(i0);
                if (obj!=null && obj instanceof AttributeContainer)
                {
                    AttributeContainer j =(AttributeContainer) soapObject.getProperty(i0);
                    KoloUser j1= (KoloUser)__envelope.get(j,KoloUser.class,false);
                    add(j1);
                    
                }
            }
    }

    public java.lang.Object getSourceObject()
    {
        return __source;
    }
    
    @Override
    public java.lang.Object getProperty(int arg0) {
        return this.get(arg0)!=null?this.get(arg0):SoapPrimitive.NullNilElement;
    }
    
    @Override
    public int getPropertyCount() {
        return this.size();
    }
    
    @Override
    public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info) {
        info.name = "KoloUser";
        info.type = KoloUser.class;
    	info.namespace= "http://kolo.cyberix.fr/";
    }
    
    @Override
    public void setProperty(int arg0, java.lang.Object arg1) {
    }

    
}