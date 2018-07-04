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

public class Transfert2Cash implements KvmSerializable {
	
	private int idTransfert2Cash;
	private int idPartnerAccount;
	private int idSendingTransfert2CashDetails;
	private int idReceiverTransfert2CashDetails;
	private String codeTransfertStatus;
	private int amount;
	private Partner partner;
	
	public Transfert2Cash() {
	}
	
	public Transfert2Cash(SoapObject soapObject) {
		if (soapObject == null)
			return;
		if (soapObject.hasProperty("IdTransfert2Cash")) {
			Object obj = soapObject.getProperty("IdTransfert2Cash");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setIdTransfert2Cash(Integer.parseInt(j.toString()));
			} else if (obj != null && obj instanceof Number) {
				setIdTransfert2Cash((Integer) obj);
			}
		}
		if (soapObject.hasProperty("IdPartnerAccount")) {
			Object obj = soapObject.getProperty("IdPartnerAccount");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setIdPartnerAccount(Integer.parseInt(j.toString()));
			} else if (obj != null && obj instanceof Number) {
				setIdPartnerAccount((Integer) obj);
			}
		}
		if (soapObject.hasProperty("IdSendingTransfert2CashDetails")) {
			Object obj = soapObject.getProperty("IdSendingTransfert2CashDetails");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setIdSendingTransfert2CashDetails(Integer.parseInt(j.toString()));
			} else if (obj != null && obj instanceof Number) {
				setIdSendingTransfert2CashDetails((Integer) obj);
			}
		}
		if (soapObject.hasProperty("IdReceiverTransfert2CashDetails")) {
			Object obj = soapObject.getProperty("IdReceiverTransfert2CashDetails");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setIdReceiverTransfert2CashDetails(Integer.parseInt(j.toString()));
			} else if (obj != null && obj instanceof Number) {
				setIdReceiverTransfert2CashDetails((Integer) obj);
			}
		}
		if (soapObject.hasProperty("CodeTransfertStatus")) {
			Object obj = soapObject.getProperty("CodeTransfertStatus");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setCodeTransfertStatus(j.toString());
			} else if (obj != null && obj instanceof String) {
				setCodeTransfertStatus((String) obj);
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
		if (soapObject.hasProperty("Partner")) {
			SoapObject j = (SoapObject) soapObject.getProperty("Partner");
			setPartner(new Partner(j));
			
		}
	}
	
	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
			case 0:
				return getIdTransfert2Cash();
			case 1:
				return getIdPartnerAccount();
			case 2:
				return getIdSendingTransfert2CashDetails();
			case 3:
				return getIdReceiverTransfert2CashDetails();
			case 4:
				return getCodeTransfertStatus();
			case 5:
				return getAmount();
			case 6:
				return getPartner();
		}
		return null;
	}
	
	@Override
	public int getPropertyCount() {
		return 7;
	}
	
	@Override
	public void setProperty(int arg0, Object arg1) {
	}
	
	@Override
	public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
		switch (index) {
			case 0:
				info.type = PropertyInfo.INTEGER_CLASS;
				info.name = "IdTransfert2Cash";
				break;
			case 1:
				info.type = PropertyInfo.INTEGER_CLASS;
				info.name = "IdPartnerAccount";
				break;
			case 2:
				info.type = PropertyInfo.INTEGER_CLASS;
				info.name = "IdSendingTransfert2CashDetails";
				break;
			case 3:
				info.type = PropertyInfo.INTEGER_CLASS;
				info.name = "IdReceiverTransfert2CashDetails";
				break;
			case 4:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "CodeTransfertStatus";
				break;
			case 5:
				info.type = PropertyInfo.INTEGER_CLASS;
				info.name = "Amount";
				break;
			case 6:
				info.type = Partner.class;
				info.name = "Partner";
				break;
		}
	}
	
	public int getIdTransfert2Cash() {
		return idTransfert2Cash;
	}
	
	public void setIdTransfert2Cash(int idTransfert2Cash) {
		this.idTransfert2Cash = idTransfert2Cash;
	}
	
	public int getIdPartnerAccount() {
		return idPartnerAccount;
	}
	
	public void setIdPartnerAccount(int idPartnerAccount) {
		this.idPartnerAccount = idPartnerAccount;
	}
	
	public int getIdSendingTransfert2CashDetails() {
		return idSendingTransfert2CashDetails;
	}
	
	public void setIdSendingTransfert2CashDetails(int idSendingTransfert2CashDetails) {
		this.idSendingTransfert2CashDetails = idSendingTransfert2CashDetails;
	}
	
	public int getIdReceiverTransfert2CashDetails() {
		return idReceiverTransfert2CashDetails;
	}
	
	public void setIdReceiverTransfert2CashDetails(int idReceiverTransfert2CashDetails) {
		this.idReceiverTransfert2CashDetails = idReceiverTransfert2CashDetails;
	}
	
	public String getCodeTransfertStatus() {
		return codeTransfertStatus;
	}
	
	public void setCodeTransfertStatus(String codeTransfertStatus) {
		this.codeTransfertStatus = codeTransfertStatus;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public Partner getPartner() {
		return partner;
	}
	
	public void setPartner(Partner partner) {
		this.partner = partner;
	}
	
	//    @Override
	public String getInnerText() {
		return null;
	}
	
	//    @Override
	public void setInnerText(String s) {
	}
}
