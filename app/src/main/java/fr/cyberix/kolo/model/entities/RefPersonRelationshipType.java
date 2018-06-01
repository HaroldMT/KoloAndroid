package fr.cyberix.kolo.model.entities;

//------------------------------------------------------------------------------
// <wsdl2code-generated>
//    This code was generated by http://www.wsdl2code.com version  2.6
//
// Date Of Creation: 6/1/2018 1:24:28 PM
//    Please dont change this code, regeneration will override your changes
//</wsdl2code-generated>
//
//------------------------------------------------------------------------------
//
//This source code was auto-generated by Wsdl2Code  Version
//
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import java.util.Hashtable;

public class RefPersonRelationshipType implements KvmSerializable {

    private String relationshipTypeCode;
    private String relationshipTypeDescription;

    public RefPersonRelationshipType() {
    }

    public RefPersonRelationshipType(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("RelationshipTypeCode")) {
            Object obj = soapObject.getProperty("RelationshipTypeCode");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                setRelationshipTypeCode(j.toString());
            } else if (obj != null && obj instanceof String) {
                setRelationshipTypeCode((String) obj);
            }
        }
        if (soapObject.hasProperty("RelationshipTypeDescription")) {
            Object obj = soapObject.getProperty("RelationshipTypeDescription");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                setRelationshipTypeDescription(j.toString());
            } else if (obj != null && obj instanceof String) {
                setRelationshipTypeDescription((String) obj);
            }
        }
    }
    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return getRelationshipTypeCode();
            case 1:
                return getRelationshipTypeDescription();
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 2;
    }

    @Override
    public void setProperty(int arg0, Object arg1) {
    }

    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch (index) {
            case 0:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "RelationshipTypeCode";
                break;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "RelationshipTypeDescription";
                break;
        }
    }

    //    @Override
    public String getInnerText() {
        return null;
    }

    //    @Override
    public void setInnerText(String s) {
    }

    public String getRelationshipTypeCode() {
        return relationshipTypeCode;
    }

    public void setRelationshipTypeCode(String relationshipTypeCode) {
        this.relationshipTypeCode = relationshipTypeCode;
    }

    public String getRelationshipTypeDescription() {
        return relationshipTypeDescription;
    }

    public void setRelationshipTypeDescription(String relationshipTypeDescription) {
        this.relationshipTypeDescription = relationshipTypeDescription;
    }
}
