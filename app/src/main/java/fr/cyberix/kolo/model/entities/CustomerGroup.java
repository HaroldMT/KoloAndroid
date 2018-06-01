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

public class CustomerGroup implements KvmSerializable {

    private int idCustomerGroup;
    private int idMemberCustomer;
    private String groupTypeCode;
    private String groupName;
    private String creationDate;
    private Customer customer;
    private RefGroupType refGroupType;
    private GroupImage groupImage;

    public CustomerGroup() {
    }

    public CustomerGroup(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("IdCustomerGroup")) {
            Object obj = soapObject.getProperty("IdCustomerGroup");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                setIdCustomerGroup(Integer.parseInt(j.toString()));
            } else if (obj != null && obj instanceof Number) {
                setIdCustomerGroup((Integer) obj);
            }
        }
        if (soapObject.hasProperty("IdMemberCustomer")) {
            Object obj = soapObject.getProperty("IdMemberCustomer");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                setIdMemberCustomer(Integer.parseInt(j.toString()));
            } else if (obj != null && obj instanceof Number) {
                setIdMemberCustomer((Integer) obj);
            }
        }
        if (soapObject.hasProperty("GroupTypeCode")) {
            Object obj = soapObject.getProperty("GroupTypeCode");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                setGroupTypeCode(j.toString());
            } else if (obj != null && obj instanceof String) {
                setGroupTypeCode((String) obj);
            }
        }
        if (soapObject.hasProperty("GroupName")) {
            Object obj = soapObject.getProperty("GroupName");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                setGroupName(j.toString());
            } else if (obj != null && obj instanceof String) {
                setGroupName((String) obj);
            }
        }
        if (soapObject.hasProperty("CreationDate")) {
            Object obj = soapObject.getProperty("CreationDate");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                setCreationDate(j.toString());
            } else if (obj != null && obj instanceof String) {
                setCreationDate((String) obj);
            }
        }
        if (soapObject.hasProperty("Customer")) {
            SoapObject j = (SoapObject) soapObject.getProperty("Customer");
            setCustomer(new Customer(j));

        }
        if (soapObject.hasProperty("RefGroupType")) {
            SoapObject j = (SoapObject) soapObject.getProperty("RefGroupType");
            setRefGroupType(new RefGroupType(j));

        }
        if (soapObject.hasProperty("GroupImage")) {
            SoapObject j = (SoapObject) soapObject.getProperty("GroupImage");
            setGroupImage(new GroupImage(j));

        }
    }

    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return getIdCustomerGroup();
            case 1:
                return getIdMemberCustomer();
            case 2:
                return getGroupTypeCode();
            case 3:
                return getGroupName();
            case 4:
                return getCreationDate();
            case 5:
                return getCustomer();
            case 6:
                return getRefGroupType();
            case 7:
                return getGroupImage();
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 8;
    }

    @Override
    public void setProperty(int arg0, Object arg1) {
    }

    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch (index) {
            case 0:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "IdCustomerGroup";
                break;
            case 1:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "IdMemberCustomer";
                break;
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "GroupTypeCode";
                break;
            case 3:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "GroupName";
                break;
            case 4:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "CreationDate";
                break;
            case 5:
                info.type = Customer.class;
                info.name = "Customer";
                break;
            case 6:
                info.type = RefGroupType.class;
                info.name = "RefGroupType";
                break;
            case 7:
                info.type = GroupImage.class;
                info.name = "GroupImage";
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

    public int getIdCustomerGroup() {
        return idCustomerGroup;
    }

    public void setIdCustomerGroup(int idCustomerGroup) {
        this.idCustomerGroup = idCustomerGroup;
    }

    public int getIdMemberCustomer() {
        return idMemberCustomer;
    }

    public void setIdMemberCustomer(int idMemberCustomer) {
        this.idMemberCustomer = idMemberCustomer;
    }

    public String getGroupTypeCode() {
        return groupTypeCode;
    }

    public void setGroupTypeCode(String groupTypeCode) {
        this.groupTypeCode = groupTypeCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public RefGroupType getRefGroupType() {
        return refGroupType;
    }

    public void setRefGroupType(RefGroupType refGroupType) {
        this.refGroupType = refGroupType;
    }

    public GroupImage getGroupImage() {
        return groupImage;
    }

    public void setGroupImage(GroupImage groupImage) {
        this.groupImage = groupImage;
    }
}
