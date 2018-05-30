package fr.cyberix.kolo.entities;

//------------------------------------------------------------------------------
// <wsdl2code-generated>
//    This code was generated by http://www.wsdl2code.com version  2.6
//
// Date Of Creation: 5/23/2018 7:21:37 PM
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

public class PersonRelationship implements KvmSerializable {

    public int idCustomer;
    public int idPersonRelation;
    public String relationshipTypeCode;
    public Person person;
    public Person person1;
    public RefPersonRelationshipType refPersonRelationshipType;

    public PersonRelationship() {
    }

    public PersonRelationship(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("IdCustomer")) {
            Object obj = soapObject.getProperty("IdCustomer");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                idCustomer = Integer.parseInt(j.toString());
            } else if (obj != null && obj instanceof Number) {
                idCustomer = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("IdPersonRelation")) {
            Object obj = soapObject.getProperty("IdPersonRelation");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                idPersonRelation = Integer.parseInt(j.toString());
            } else if (obj != null && obj instanceof Number) {
                idPersonRelation = (Integer) obj;
            }
        }
        if (soapObject.hasProperty("RelationshipTypeCode")) {
            Object obj = soapObject.getProperty("RelationshipTypeCode");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                relationshipTypeCode = j.toString();
            } else if (obj != null && obj instanceof String) {
                relationshipTypeCode = (String) obj;
            }
        }
        if (soapObject.hasProperty("Person")) {
            SoapObject j = (SoapObject) soapObject.getProperty("Person");
            person = new Person(j);

        }
        if (soapObject.hasProperty("Person1")) {
            SoapObject j = (SoapObject) soapObject.getProperty("Person1");
            person1 = new Person(j);

        }
        if (soapObject.hasProperty("RefPersonRelationshipType")) {
            SoapObject j = (SoapObject) soapObject.getProperty("RefPersonRelationshipType");
            refPersonRelationshipType = new RefPersonRelationshipType(j);

        }
    }

    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return idCustomer;
            case 1:
                return idPersonRelation;
            case 2:
                return relationshipTypeCode;
            case 3:
                return person;
            case 4:
                return person1;
            case 5:
                return refPersonRelationshipType;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 6;
    }

    @Override
    public void setProperty(int arg0, Object arg1) {
    }

    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch (index) {
            case 0:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "IdCustomer";
                break;
            case 1:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "IdPersonRelation";
                break;
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "RelationshipTypeCode";
                break;
            case 3:
                info.type = Person.class;
                info.name = "Person";
                break;
            case 4:
                info.type = Person.class;
                info.name = "Person1";
                break;
            case 5:
                info.type = RefPersonRelationshipType.class;
                info.name = "RefPersonRelationshipType";
                break;
        }
    }

    public String getInnerText() {
        return null;
    }

    public void setInnerText(String s) {
    }

}
