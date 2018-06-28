package fr.cyberix.kolo.model.entities;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import java.util.Hashtable;

public class TransferGravity implements KvmSerializable {
	
	private int transferMadId;
	private String gravityReference;
	private String koloReference;
	private int koloSenderId;
	private int gravitySenderId;
	private int gravityReceiverId;
	private int amount;
	private boolean received;
	private String receiverLastName;
	private String receiverFirstName;
	private String receiverPhoneNumber;
	private Customer customer;
	
	public TransferGravity() {
	}
	
	public TransferGravity(SoapObject soapObject) {
		if (soapObject == null)
			return;
		if (soapObject.hasProperty("TransferMadId")) {
			Object obj = soapObject.getProperty("TransferMadId");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setTransferMadId(Integer.parseInt(j.toString()));
			} else if (obj != null && obj instanceof Number) {
				setTransferMadId((Integer) obj);
			}
		}
		if (soapObject.hasProperty("GravityReference")) {
			Object obj = soapObject.getProperty("GravityReference");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setGravityReference(j.toString());
			} else if (obj != null && obj instanceof String) {
				setGravityReference((String) obj);
			}
		}
		if (soapObject.hasProperty("KoloReference")) {
			Object obj = soapObject.getProperty("KoloReference");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setKoloReference(j.toString());
			} else if (obj != null && obj instanceof String) {
				setKoloReference((String) obj);
			}
		}
		if (soapObject.hasProperty("KoloSenderId")) {
			Object obj = soapObject.getProperty("KoloSenderId");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setKoloSenderId(Integer.parseInt(j.toString()));
			} else if (obj != null && obj instanceof Number) {
				setKoloSenderId((Integer) obj);
			}
		}
		if (soapObject.hasProperty("GravitySenderId")) {
			Object obj = soapObject.getProperty("GravitySenderId");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setGravitySenderId(Integer.parseInt(j.toString()));
			} else if (obj != null && obj instanceof Number) {
				setGravitySenderId((Integer) obj);
			}
		}
		if (soapObject.hasProperty("GravityReceiverId")) {
			Object obj = soapObject.getProperty("GravityReceiverId");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setGravityReceiverId(Integer.parseInt(j.toString()));
			} else if (obj != null && obj instanceof Number) {
				setGravityReceiverId((Integer) obj);
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
		if (soapObject.hasProperty("Received")) {
			Object obj = soapObject.getProperty("Received");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setReceived(Boolean.parseBoolean(j.toString()));
			} else if (obj != null && obj instanceof Boolean) {
				setReceived((Boolean) obj);
			}
		}
		if (soapObject.hasProperty("ReceiverLastName")) {
			Object obj = soapObject.getProperty("ReceiverLastName");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setReceiverLastName(j.toString());
			} else if (obj != null && obj instanceof String) {
				setReceiverLastName((String) obj);
			}
		}
		if (soapObject.hasProperty("ReceiverFirstName")) {
			Object obj = soapObject.getProperty("ReceiverFirstName");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setReceiverFirstName(j.toString());
			} else if (obj != null && obj instanceof String) {
				setReceiverFirstName((String) obj);
			}
		}
		if (soapObject.hasProperty("ReceiverPhoneNumber")) {
			Object obj = soapObject.getProperty("ReceiverPhoneNumber");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setReceiverPhoneNumber(j.toString());
			} else if (obj != null && obj instanceof String) {
				setReceiverPhoneNumber((String) obj);
			}
		}
		if (soapObject.hasProperty("Customer")) {
			SoapObject j = (SoapObject) soapObject.getProperty("Customer");
			setCustomer(new Customer(j));
			
		}
	}
	
	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
			case 0:
				return getTransferMadId();
			case 1:
				return getGravityReference();
			case 2:
				return getKoloReference();
			case 3:
				return getKoloSenderId();
			case 4:
				return getGravitySenderId();
			case 5:
				return getGravityReceiverId();
			case 6:
				return getAmount();
			case 7:
				return isReceived();
			case 8:
				return getReceiverLastName();
			case 9:
				return getReceiverFirstName();
			case 10:
				return getReceiverPhoneNumber();
			case 11:
				return getCustomer();
		}
		return null;
	}
	
	@Override
	public int getPropertyCount() {
		return 12;
	}
	
	@Override
	public void setProperty(int arg0, Object arg1) {
	}
	
	@Override
	public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
		switch (index) {
			case 0:
				info.type = PropertyInfo.INTEGER_CLASS;
				info.name = "TransferMadId";
				break;
			case 1:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "GravityReference";
				break;
			case 2:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "KoloReference";
				break;
			case 3:
				info.type = PropertyInfo.INTEGER_CLASS;
				info.name = "KoloSenderId";
				break;
			case 4:
				info.type = PropertyInfo.INTEGER_CLASS;
				info.name = "GravitySenderId";
				break;
			case 5:
				info.type = PropertyInfo.INTEGER_CLASS;
				info.name = "GravityReceiverId";
				break;
			case 6:
				info.type = PropertyInfo.INTEGER_CLASS;
				info.name = "Amount";
				break;
			case 7:
				info.type = PropertyInfo.BOOLEAN_CLASS;
				info.name = "Received";
				break;
			case 8:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "ReceiverLastName";
				break;
			case 9:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "ReceiverFirstName";
				break;
			case 10:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "ReceiverPhoneNumber";
				break;
			case 11:
				info.type = Customer.class;
				info.name = "Customer";
				break;
		}
	}
	
	public int getTransferMadId() {
		return transferMadId;
	}
	
	public void setTransferMadId(int transferMadId) {
		this.transferMadId = transferMadId;
	}
	
	public String getGravityReference() {
		return gravityReference;
	}
	
	public void setGravityReference(String gravityReference) {
		this.gravityReference = gravityReference;
	}
	
	public String getKoloReference() {
		return koloReference;
	}
	
	public void setKoloReference(String koloReference) {
		this.koloReference = koloReference;
	}
	
	public int getKoloSenderId() {
		return koloSenderId;
	}
	
	public void setKoloSenderId(int koloSenderId) {
		this.koloSenderId = koloSenderId;
	}
	
	public int getGravitySenderId() {
		return gravitySenderId;
	}
	
	public void setGravitySenderId(int gravitySenderId) {
		this.gravitySenderId = gravitySenderId;
	}
	
	public int getGravityReceiverId() {
		return gravityReceiverId;
	}
	
	public void setGravityReceiverId(int gravityReceiverId) {
		this.gravityReceiverId = gravityReceiverId;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public boolean isReceived() {
		return received;
	}
	
	public void setReceived(boolean received) {
		this.received = received;
	}
	
	public String getReceiverLastName() {
		return receiverLastName;
	}
	
	public void setReceiverLastName(String receiverLastName) {
		this.receiverLastName = receiverLastName;
	}
	
	public String getReceiverFirstName() {
		return receiverFirstName;
	}
	
	public void setReceiverFirstName(String receiverFirstName) {
		this.receiverFirstName = receiverFirstName;
	}
	
	public String getReceiverPhoneNumber() {
		return receiverPhoneNumber;
	}
	
	public void setReceiverPhoneNumber(String receiverPhoneNumber) {
		this.receiverPhoneNumber = receiverPhoneNumber;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	//    @Override
	public String getInnerText() {
		return null;
	}
	
	//    @Override
	public void setInnerText(String s) {
	}
}
