package fr.cyberix.kolo.model;

public class KoloMadDetails {
	private String reference;
	private int madId;
	private boolean success;
	private String error;
	private int senderId;
	private int receiverId;
	private int amount;
	private int fee;
	private int tax;
	private boolean everywhere;
	private String cityCode;
	private String password;
	
	public String getReference() {
		return reference;
	}
	
	public void setReference(String reference) {
		this.reference = reference;
	}
	
	public int getMadId() {
		return madId;
	}
	
	public void setMadId(int madId) {
		this.madId = madId;
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
	
	public int getSenderId() {
		return senderId;
	}
	
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	
	public int getReceiverId() {
		return receiverId;
	}
	
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public int getFee() {
		return fee;
	}
	
	public void setFee(int fee) {
		this.fee = fee;
	}
	
	public int getTax() {
		return tax;
	}
	
	public void setTax(int tax) {
		this.tax = tax;
	}
	
	public boolean isEverywhere() {
		return everywhere;
	}
	
	public void setEverywhere(boolean everywhere) {
		this.everywhere = everywhere;
	}
	
	public String getCityCode() {
		return cityCode;
	}
	
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
