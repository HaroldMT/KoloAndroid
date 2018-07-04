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

public class Business implements KvmSerializable {
	
	private int idCustomer;
	private String industryCategoryCode;
	private String businessName;
	private Customer customer;
	private RefIndustryCategory refIndustryCategory;
	
	public Business() {
	}
	
	public Business(SoapObject soapObject) {
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
		if (soapObject.hasProperty("IndustryCategoryCode")) {
			Object obj = soapObject.getProperty("IndustryCategoryCode");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setIndustryCategoryCode(j.toString());
			} else if (obj != null && obj instanceof String) {
				setIndustryCategoryCode((String) obj);
			}
		}
		if (soapObject.hasProperty("BusinessName")) {
			Object obj = soapObject.getProperty("BusinessName");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setBusinessName(j.toString());
			} else if (obj != null && obj instanceof String) {
				setBusinessName((String) obj);
			}
		}
		if (soapObject.hasProperty("Customer")) {
			SoapObject j = (SoapObject) soapObject.getProperty("Customer");
			setCustomer(new Customer(j));
			
		}
		if (soapObject.hasProperty("RefIndustryCategory")) {
			SoapObject j = (SoapObject) soapObject.getProperty("RefIndustryCategory");
			setRefIndustryCategory(new RefIndustryCategory(j));
			
		}
	}
	
	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
			case 0:
				return getIdCustomer();
			case 1:
				return getIndustryCategoryCode();
			case 2:
				return getBusinessName();
			case 3:
				return getCustomer();
			case 4:
				return getRefIndustryCategory();
		}
		return null;
	}
	
	@Override
	public int getPropertyCount() {
		return 5;
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
				info.name = "IndustryCategoryCode";
				break;
			case 2:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "BusinessName";
				break;
			case 3:
				info.type = Customer.class;
				info.name = "Customer";
				break;
			case 4:
				info.type = RefIndustryCategory.class;
				info.name = "RefIndustryCategory";
				break;
		}
	}
	
	public int getIdCustomer() {
		return idCustomer;
	}
	
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	
	public String getIndustryCategoryCode() {
		return industryCategoryCode;
	}
	
	public void setIndustryCategoryCode(String industryCategoryCode) {
		this.industryCategoryCode = industryCategoryCode;
	}
	
	public String getBusinessName() {
		return businessName;
	}
	
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public RefIndustryCategory getRefIndustryCategory() {
		return refIndustryCategory;
	}
	
	public void setRefIndustryCategory(RefIndustryCategory refIndustryCategory) {
		this.refIndustryCategory = refIndustryCategory;
	}
	
	//    @Override
	public String getInnerText() {
		return null;
	}
	
	//    @Override
	public void setInnerText(String s) {
	}
}
