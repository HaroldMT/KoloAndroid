package fr.cyberix.kolo.model;

public class KoloMadCustomer {
	private int madCustomerId;
	private String madCustomerCode;
	private String lastName;
	private String firstName;
	private String phoneNumber;
	private boolean success;
	private String error;
	
	public int getMadCustomerId() {
		return madCustomerId;
	}
	
	public void setMadCustomerId(int madCustomerId) {
		this.madCustomerId = madCustomerId;
	}
	
	public String getMadCustomerCode() {
		return madCustomerCode;
	}
	
	public void setMadCustomerCode(String madCustomerCode) {
		this.madCustomerCode = madCustomerCode;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public String getError() {
		return error;
	}
	
	public void setError(String error) {
		this.error = error;
	}
}
