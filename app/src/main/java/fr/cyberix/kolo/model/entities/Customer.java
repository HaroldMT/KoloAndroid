package fr.cyberix.kolo.model.entities;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;

import java.util.Hashtable;

public class Customer implements KvmSerializable {
	
	public CustomerImage customerImage;
	public CustomerLogin customerLogin;
	public Partner partner;
	public Person person;
	private int idCustomer;
	private String customerTypeCode;
	private String currencyCode;
	private int balance;
	private String dateCreated;
	private int idRegistration;
	private int balanceUnavailable;
	private String eneoContractNo;
	private int eneoPercentage;
	private Business business;
	private Currency currency;
	private Registration registration;
	private RefCustomerType refCustomerType;
	private MobileDevice mobileDevice;
	private int topUpPercentage;
	private int gravityId;
	private String gravityCode;
	private int gravityPercentage;
	
	public Customer() {
	}
	
	public Customer(SoapObject soapObject) {
		if (soapObject == null)
			return;
		if (soapObject.hasProperty("IdCustomer")) {
			Object obj = soapObject.getProperty("IdCustomer");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setIdCustomer(Integer.parseInt(j.toString()));
			} else if (obj != null && obj instanceof Number) {
				setIdCustomer((Integer) obj);
			}
		}
		if (soapObject.hasProperty("CustomerTypeCode")) {
			Object obj = soapObject.getProperty("CustomerTypeCode");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setCustomerTypeCode(j.toString());
			} else if (obj != null && obj instanceof String) {
				setCustomerTypeCode((String) obj);
			}
		}
		if (soapObject.hasProperty("CurrencyCode")) {
			Object obj = soapObject.getProperty("CurrencyCode");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setCurrencyCode(j.toString());
			} else if (obj != null && obj instanceof String) {
				setCurrencyCode((String) obj);
			}
		}
		if (soapObject.hasProperty("Balance")) {
			Object obj = soapObject.getProperty("Balance");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setBalance(Integer.parseInt(j.toString()));
			} else if (obj != null && obj instanceof Number) {
				setBalance((Integer) obj);
			}
		}
		if (soapObject.hasProperty("DateCreated")) {
			Object obj = soapObject.getProperty("DateCreated");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setDateCreated(j.toString());
			} else if (obj != null && obj instanceof String) {
				setDateCreated((String) obj);
			}
		}
		if (soapObject.hasProperty("IdRegistration")) {
			Object obj = soapObject.getProperty("IdRegistration");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setIdRegistration(Integer.parseInt(j.toString()));
			} else if (obj != null && obj instanceof Number) {
				setIdRegistration((Integer) obj);
			}
		}
		if (soapObject.hasProperty("BalanceUnavailable")) {
			Object obj = soapObject.getProperty("BalanceUnavailable");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setBalanceUnavailable(Integer.parseInt(j.toString()));
			} else if (obj != null && obj instanceof Number) {
				setBalanceUnavailable((Integer) obj);
			}
		}
		if (soapObject.hasProperty("EneoContractNo")) {
			Object obj = soapObject.getProperty("EneoContractNo");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setEneoContractNo(j.toString());
			} else if (obj != null && obj instanceof String) {
				setEneoContractNo((String) obj);
			}
		}
		if (soapObject.hasProperty("EneoPercentage")) {
			Object obj = soapObject.getProperty("EneoPercentage");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setEneoPercentage(Integer.parseInt(j.toString()));
			} else if (obj != null && obj instanceof Number) {
				setEneoPercentage((Integer) obj);
			}
		}
		if (soapObject.hasProperty("TopUpPercentage")) {
			Object obj = soapObject.getProperty("TopUpPercentage");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setTopUpPercentage(Integer.parseInt(j.toString()));
			} else if (obj != null && obj instanceof Number) {
				setTopUpPercentage((Integer) obj);
			}
		}
		if (soapObject.hasProperty("GravityId")) {
			Object obj = soapObject.getProperty("GravityId");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setGravityId(Integer.parseInt(j.toString()));
			} else if (obj != null && obj instanceof Number) {
				setGravityId((Integer) obj);
			}
		}
		if (soapObject.hasProperty("GravityCode")) {
			Object obj = soapObject.getProperty("GravityCode");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setGravityCode(j.toString());
			} else if (obj != null && obj instanceof String) {
				setGravityCode((String) obj);
			}
		}
		if (soapObject.hasProperty("GravityPercentage")) {
			Object obj = soapObject.getProperty("GravityPercentage");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setGravityPercentage(Integer.parseInt(j.toString()));
			} else if (obj != null && obj instanceof Number) {
				setGravityPercentage((Integer) obj);
			}
		}
		if (soapObject.hasProperty("Business")) {
			SoapObject j = (SoapObject) soapObject.getProperty("Business");
			setBusiness(new Business(j));
			
		}
		if (soapObject.hasProperty("Currency")) {
			SoapObject j = (SoapObject) soapObject.getProperty("Currency");
			setCurrency(new Currency(j));
			
		}
		if (soapObject.hasProperty("Registration")) {
			SoapObject j = (SoapObject) soapObject.getProperty("Registration");
			setRegistration(new Registration(j));
			
		}
		if (soapObject.hasProperty("RefCustomerType")) {
			SoapObject j = (SoapObject) soapObject.getProperty("RefCustomerType");
			setRefCustomerType(new RefCustomerType(j));
			
		}
		if (soapObject.hasProperty("MobileDevice")) {
			SoapObject j = (SoapObject) soapObject.getProperty("MobileDevice");
			setMobileDevice(new MobileDevice(j));
			
		}
		if (soapObject.hasProperty("CustomerImage")) {
			SoapObject j = (SoapObject) soapObject.getProperty("CustomerImage");
			customerImage = new CustomerImage(j);
			
		}
		if (soapObject.hasProperty("CustomerLogin")) {
			SoapObject j = (SoapObject) soapObject.getProperty("CustomerLogin");
			customerLogin = new CustomerLogin(j);
			
		}
		if (soapObject.hasProperty("Partner")) {
			SoapObject j = (SoapObject) soapObject.getProperty("Partner");
			partner = new Partner(j);
			
		}
		if (soapObject.hasProperty("Person")) {
			SoapObject j = (SoapObject) soapObject.getProperty("Person");
			person = new Person(j);
			
		}
	}
	
	public CustomerImage getCustomerImage() {
		return customerImage;
	}
	
	public void setCustomerImage(CustomerImage customerImage) {
		this.customerImage = customerImage;
	}
	
	public CustomerLogin getCustomerLogin() {
		return customerLogin;
	}
	
	public void setCustomerLogin(CustomerLogin customerLogin) {
		this.customerLogin = customerLogin;
	}
	
	public Partner getPartner() {
		return partner;
	}
	
	public void setPartner(Partner partner) {
		this.partner = partner;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
			case 0:
				return getIdCustomer();
			case 1:
				return getCustomerTypeCode();
			case 2:
				return getCurrencyCode();
			case 3:
				return getBalance();
			case 4:
				return getDateCreated();
			case 5:
				return getIdRegistration();
			case 6:
				return getBalanceUnavailable();
			case 7:
				return getEneoContractNo();
			case 8:
				return getEneoPercentage();
			case 9:
				return getTopUpPercentage();
			case 10:
				return getGravityId();
			case 11:
				return getGravityCode();
			case 12:
				return getGravityPercentage();
			case 13:
				return getBusiness();
			case 14:
				return getCurrency();
			case 15:
				return getRegistration();
			case 16:
				return getRefCustomerType();
			case 17:
				return getMobileDevice();
			case 18:
				return customerImage;
			case 19:
				return customerLogin;
			case 20:
				return partner;
			case 21:
				return person;
		}
		return null;
	}
	
	@Override
	public int getPropertyCount() {
		return 22;
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
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "CustomerTypeCode";
				break;
			case 2:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "CurrencyCode";
				break;
			case 3:
				info.type = PropertyInfo.INTEGER_CLASS;
				info.name = "Balance";
				break;
			case 4:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "DateCreated";
				break;
			case 5:
				info.type = PropertyInfo.INTEGER_CLASS;
				info.name = "IdRegistration";
				break;
			case 6:
				info.type = PropertyInfo.INTEGER_CLASS;
				info.name = "BalanceUnavailable";
				break;
			case 7:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "EneoContractNo";
				break;
			case 8:
				info.type = PropertyInfo.INTEGER_CLASS;
				info.name = "EneoPercentage";
				break;
			case 9:
				info.type = PropertyInfo.INTEGER_CLASS;
				info.name = "TopUpPercentage";
				break;
			case 10:
				info.type = PropertyInfo.INTEGER_CLASS;
				info.name = "GravityId";
				break;
			case 11:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "GravityCode";
				break;
			case 12:
				info.type = PropertyInfo.INTEGER_CLASS;
				info.name = "GravityPercentage";
				break;
			case 13:
				info.type = Business.class;
				info.name = "Business";
				break;
			case 14:
				info.type = Currency.class;
				info.name = "Currency";
				break;
			case 15:
				info.type = Registration.class;
				info.name = "Registration";
				break;
			case 16:
				info.type = RefCustomerType.class;
				info.name = "RefCustomerType";
				break;
			case 17:
				info.type = MobileDevice.class;
				info.name = "MobileDevice";
				break;
			case 18:
				info.type = CustomerImage.class;
				info.name = "CustomerImage";
				break;
			case 19:
				info.type = CustomerLogin.class;
				info.name = "CustomerLogin";
				break;
			case 20:
				info.type = Partner.class;
				info.name = "Partner";
				break;
			case 21:
				info.type = Person.class;
				info.name = "Person";
				break;
		}
	}
	
	public int getIdCustomer() {
		return idCustomer;
	}
	
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	
	public String getCustomerTypeCode() {
		return customerTypeCode;
	}
	
	public void setCustomerTypeCode(String customerTypeCode) {
		this.customerTypeCode = customerTypeCode;
	}
	
	public String getCurrencyCode() {
		return currencyCode;
	}
	
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public String getDateCreated() {
		return dateCreated;
	}
	
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public int getIdRegistration() {
		return idRegistration;
	}
	
	public int getBalanceUnavailable() {
		return balanceUnavailable;
	}
	
	public void setBalanceUnavailable(int balanceUnavailable) {
		this.balanceUnavailable = balanceUnavailable;
	}
	
	public String getEneoContractNo() {
		return eneoContractNo;
	}
	
	public void setEneoContractNo(String eneoContractNo) {
		this.eneoContractNo = eneoContractNo;
	}
	
	public int getEneoPercentage() {
		return eneoPercentage;
	}
	
	public void setEneoPercentage(int eneoPercentage) {
		this.eneoPercentage = eneoPercentage;
	}
	
	public int getTopUpPercentage() {
		return topUpPercentage;
	}
	
	public void setTopUpPercentage(int topUpPercentage) {
		this.topUpPercentage = topUpPercentage;
	}
	
	public int getGravityId() {
		return gravityId;
	}
	
	public void setGravityId(int gravityId) {
		this.gravityId = gravityId;
	}
	
	public String getGravityCode() {
		return gravityCode;
	}
	
	public void setGravityCode(String gravityCode) {
		this.gravityCode = gravityCode;
	}
	
	public int getGravityPercentage() {
		return gravityPercentage;
	}
	
	public void setGravityPercentage(int gravityPercentage) {
		this.gravityPercentage = gravityPercentage;
	}
	
	public Business getBusiness() {
		return business;
	}
	
	public void setBusiness(Business business) {
		this.business = business;
	}
	
	public Currency getCurrency() {
		return currency;
	}
	
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	public Registration getRegistration() {
		return registration;
	}
	
	public void setRegistration(Registration registration) {
		this.registration = registration;
	}
	
	public RefCustomerType getRefCustomerType() {
		return refCustomerType;
	}
	
	public void setRefCustomerType(RefCustomerType refCustomerType) {
		this.refCustomerType = refCustomerType;
	}
	
	public MobileDevice getMobileDevice() {
		return mobileDevice;
	}
	
	public void setMobileDevice(MobileDevice mobileDevice) {
		this.mobileDevice = mobileDevice;
	}
	
	public void setIdRegistration(int idRegistration) {
		this.idRegistration = idRegistration;
	}
	
	public int getTotalBalance() {
		return balance + balanceUnavailable;
	}
	
	//    @Override
	public String getInnerText() {
		return null;
	}
	
	//    @Override
	public void setInnerText(String s) {
	}
}
