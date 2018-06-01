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

public class TransfertE2e implements KvmSerializable {

    private int idTransfertE2e;
    private int idCustomer;
    private int idSendingExternalAccount;
    private int idReceiverExternalAccount;
    private String transfertStatusCode;
    private int amount;
    private String operationTypeCode;
    private String reference;
    private Customer customer;
    private ExternalAccount externalAccount;
    private ExternalAccount externalAccount1;
    private RefOperationType refOperationType;
    private RefTransfertStatu refTransfertStatu;

    public TransfertE2e() {
    }

    public TransfertE2e(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("IdTransfertE2e")) {
            Object obj = soapObject.getProperty("IdTransfertE2e");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                setIdTransfertE2e(Integer.parseInt(j.toString()));
            } else if (obj != null && obj instanceof Number) {
                setIdTransfertE2e((Integer) obj);
            }
        }
        if (soapObject.hasProperty("IdCustomer")) {
            Object obj = soapObject.getProperty("IdCustomer");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                setIdCustomer(Integer.parseInt(j.toString()));
            } else if (obj != null && obj instanceof Number) {
                setIdCustomer((Integer) obj);
            }
        }
        if (soapObject.hasProperty("IdSendingExternalAccount")) {
            Object obj = soapObject.getProperty("IdSendingExternalAccount");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                setIdSendingExternalAccount(Integer.parseInt(j.toString()));
            } else if (obj != null && obj instanceof Number) {
                setIdSendingExternalAccount((Integer) obj);
            }
        }
        if (soapObject.hasProperty("IdReceiverExternalAccount")) {
            Object obj = soapObject.getProperty("IdReceiverExternalAccount");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                setIdReceiverExternalAccount(Integer.parseInt(j.toString()));
            } else if (obj != null && obj instanceof Number) {
                setIdReceiverExternalAccount((Integer) obj);
            }
        }
        if (soapObject.hasProperty("TransfertStatusCode")) {
            Object obj = soapObject.getProperty("TransfertStatusCode");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                setTransfertStatusCode(j.toString());
            } else if (obj != null && obj instanceof String) {
                setTransfertStatusCode((String) obj);
            }
        }
        if (soapObject.hasProperty("Amount")) {
            Object obj = soapObject.getProperty("Amount");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                setAmount(Integer.parseInt(j.toString()));
            } else if (obj != null && obj instanceof Number) {
                setAmount((Integer) obj);
            }
        }
        if (soapObject.hasProperty("OperationTypeCode")) {
            Object obj = soapObject.getProperty("OperationTypeCode");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                setOperationTypeCode(j.toString());
            } else if (obj != null && obj instanceof String) {
                setOperationTypeCode((String) obj);
            }
        }
        if (soapObject.hasProperty("Reference")) {
            Object obj = soapObject.getProperty("Reference");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
                SoapPrimitive j = (SoapPrimitive) obj;
                setReference(j.toString());
            } else if (obj != null && obj instanceof String) {
                setReference((String) obj);
            }
        }
        if (soapObject.hasProperty("Customer")) {
            SoapObject j = (SoapObject) soapObject.getProperty("Customer");
            setCustomer(new Customer(j));

        }
        if (soapObject.hasProperty("ExternalAccount")) {
            SoapObject j = (SoapObject) soapObject.getProperty("ExternalAccount");
            setExternalAccount(new ExternalAccount(j));

        }
        if (soapObject.hasProperty("ExternalAccount1")) {
            SoapObject j = (SoapObject) soapObject.getProperty("ExternalAccount1");
            setExternalAccount1(new ExternalAccount(j));

        }
        if (soapObject.hasProperty("RefOperationType")) {
            SoapObject j = (SoapObject) soapObject.getProperty("RefOperationType");
            setRefOperationType(new RefOperationType(j));

        }
        if (soapObject.hasProperty("RefTransfertStatu")) {
            SoapObject j = (SoapObject) soapObject.getProperty("RefTransfertStatu");
            setRefTransfertStatu(new RefTransfertStatu(j));

        }
    }

    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return getIdTransfertE2e();
            case 1:
                return getIdCustomer();
            case 2:
                return getIdSendingExternalAccount();
            case 3:
                return getIdReceiverExternalAccount();
            case 4:
                return getTransfertStatusCode();
            case 5:
                return getAmount();
            case 6:
                return getOperationTypeCode();
            case 7:
                return getReference();
            case 8:
                return getCustomer();
            case 9:
                return getExternalAccount();
            case 10:
                return getExternalAccount1();
            case 11:
                return getRefOperationType();
            case 12:
                return getRefTransfertStatu();
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 13;
    }

    @Override
    public void setProperty(int arg0, Object arg1) {
    }

    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch (index) {
            case 0:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "IdTransfertE2e";
                break;
            case 1:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "IdCustomer";
                break;
            case 2:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "IdSendingExternalAccount";
                break;
            case 3:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "IdReceiverExternalAccount";
                break;
            case 4:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "TransfertStatusCode";
                break;
            case 5:
                info.type = PropertyInfo.INTEGER_CLASS;
                info.name = "Amount";
                break;
            case 6:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "OperationTypeCode";
                break;
            case 7:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "Reference";
                break;
            case 8:
                info.type = Customer.class;
                info.name = "Customer";
                break;
            case 9:
                info.type = ExternalAccount.class;
                info.name = "ExternalAccount";
                break;
            case 10:
                info.type = ExternalAccount.class;
                info.name = "ExternalAccount1";
                break;
            case 11:
                info.type = RefOperationType.class;
                info.name = "RefOperationType";
                break;
            case 12:
                info.type = RefTransfertStatu.class;
                info.name = "RefTransfertStatu";
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

    public int getIdTransfertE2e() {
        return idTransfertE2e;
    }

    public void setIdTransfertE2e(int idTransfertE2e) {
        this.idTransfertE2e = idTransfertE2e;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdSendingExternalAccount() {
        return idSendingExternalAccount;
    }

    public void setIdSendingExternalAccount(int idSendingExternalAccount) {
        this.idSendingExternalAccount = idSendingExternalAccount;
    }

    public int getIdReceiverExternalAccount() {
        return idReceiverExternalAccount;
    }

    public void setIdReceiverExternalAccount(int idReceiverExternalAccount) {
        this.idReceiverExternalAccount = idReceiverExternalAccount;
    }

    public String getTransfertStatusCode() {
        return transfertStatusCode;
    }

    public void setTransfertStatusCode(String transfertStatusCode) {
        this.transfertStatusCode = transfertStatusCode;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getOperationTypeCode() {
        return operationTypeCode;
    }

    public void setOperationTypeCode(String operationTypeCode) {
        this.operationTypeCode = operationTypeCode;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ExternalAccount getExternalAccount() {
        return externalAccount;
    }

    public void setExternalAccount(ExternalAccount externalAccount) {
        this.externalAccount = externalAccount;
    }

    public ExternalAccount getExternalAccount1() {
        return externalAccount1;
    }

    public void setExternalAccount1(ExternalAccount externalAccount1) {
        this.externalAccount1 = externalAccount1;
    }

    public RefOperationType getRefOperationType() {
        return refOperationType;
    }

    public void setRefOperationType(RefOperationType refOperationType) {
        this.refOperationType = refOperationType;
    }

    public RefTransfertStatu getRefTransfertStatu() {
        return refTransfertStatu;
    }

    public void setRefTransfertStatu(RefTransfertStatu refTransfertStatu) {
        this.refTransfertStatu = refTransfertStatu;
    }
}
