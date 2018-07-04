package fr.cyberix.kolo.model.entities;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import java.util.Hashtable;

public class CreditCardInfo implements KvmSerializable {
	
	private int idCreditCardInfo;
	private String nameOnCard;
	private String cardNumber;
	private int expiryMonth;
	private int expiryYear;
	private String secretCode;
	private ExternalAccount externalAccount;
	
	public CreditCardInfo() {
	}
	
	public CreditCardInfo(SoapObject soapObject) {
		if (soapObject == null)
			return;
		if (soapObject.hasProperty("IdCreditCardInfo")) {
			Object obj = soapObject.getProperty("IdCreditCardInfo");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setIdCreditCardInfo(Integer.parseInt(j.toString()));
			} else if (obj != null && obj instanceof Number) {
				setIdCreditCardInfo((Integer) obj);
			}
		}
		if (soapObject.hasProperty("NameOnCard")) {
			Object obj = soapObject.getProperty("NameOnCard");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setNameOnCard(j.toString());
			} else if (obj != null && obj instanceof String) {
				setNameOnCard((String) obj);
			}
		}
		if (soapObject.hasProperty("CardNumber")) {
			Object obj = soapObject.getProperty("CardNumber");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setCardNumber(j.toString());
			} else if (obj != null && obj instanceof String) {
				setCardNumber((String) obj);
			}
		}
		if (soapObject.hasProperty("ExpiryMonth")) {
			Object obj = soapObject.getProperty("ExpiryMonth");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setExpiryMonth(Integer.parseInt(j.toString()));
			} else if (obj != null && obj instanceof Number) {
				setExpiryMonth((Integer) obj);
			}
		}
		if (soapObject.hasProperty("ExpiryYear")) {
			Object obj = soapObject.getProperty("ExpiryYear");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setExpiryYear(Integer.parseInt(j.toString()));
			} else if (obj != null && obj instanceof Number) {
				setExpiryYear((Integer) obj);
			}
		}
		if (soapObject.hasProperty("SecretCode")) {
			Object obj = soapObject.getProperty("SecretCode");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setSecretCode(j.toString());
			} else if (obj != null && obj instanceof String) {
				setSecretCode((String) obj);
			}
		}
		if (soapObject.hasProperty("ExternalAccount")) {
			SoapObject j = (SoapObject) soapObject.getProperty("ExternalAccount");
			setExternalAccount(new ExternalAccount(j));
			
		}
	}
	
	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
			case 0:
				return getIdCreditCardInfo();
			case 1:
				return getNameOnCard();
			case 2:
				return getCardNumber();
			case 3:
				return getExpiryMonth();
			case 4:
				return getExpiryYear();
			case 5:
				return getSecretCode();
			case 6:
				return getExternalAccount();
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
				info.name = "IdCreditCardInfo";
				break;
			case 1:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "NameOnCard";
				break;
			case 2:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "CardNumber";
				break;
			case 3:
				info.type = PropertyInfo.INTEGER_CLASS;
				info.name = "ExpiryMonth";
				break;
			case 4:
				info.type = PropertyInfo.INTEGER_CLASS;
				info.name = "ExpiryYear";
				break;
			case 5:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "SecretCode";
				break;
			case 6:
				info.type = ExternalAccount.class;
				info.name = "ExternalAccount";
				break;
		}
	}
	
	public int getIdCreditCardInfo() {
		return idCreditCardInfo;
	}
	
	public void setIdCreditCardInfo(int idCreditCardInfo) {
		this.idCreditCardInfo = idCreditCardInfo;
	}
	
	public String getNameOnCard() {
		return nameOnCard;
	}
	
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	
	public String getCardNumber() {
		return cardNumber;
	}
	
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public int getExpiryMonth() {
		return expiryMonth;
	}
	
	public void setExpiryMonth(int expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	
	public int getExpiryYear() {
		return expiryYear;
	}
	
	public void setExpiryYear(int expiryYear) {
		this.expiryYear = expiryYear;
	}
	
	public String getSecretCode() {
		return secretCode;
	}
	
	public void setSecretCode(String secretCode) {
		this.secretCode = secretCode;
	}
	
	public ExternalAccount getExternalAccount() {
		return externalAccount;
	}
	
	public void setExternalAccount(ExternalAccount externalAccount) {
		this.externalAccount = externalAccount;
	}
	
	public String getInnerText() {
		return null;
	}
	
	public void setInnerText(String s) {
	}
}
