package fr.cyberix.kolo.model;

import java.util.Date;

public class TransferP2pDetails {
	int senderIdCustomer;
	String senderTelephone;
	String senderLastName;
	String senderFirstName;
	String senderMiddleName;
	int receiverIdCustomer;
	String receiverTelephone;
	String receiverLastName;
	String receiverFirstName;
	String receiverMiddleName;
	int amount;
	String status;
	Date transferDate;
	String passPhrase;
	boolean needsConfirmation;
	Date scheduleDate;
	
	public String getReceiverFullname() {
		StringBuilder sb = new StringBuilder();
		if (receiverLastName != null) sb.append(receiverLastName + ' ');
		if (receiverMiddleName != null) sb.append(receiverMiddleName + ' ');
		if (receiverFirstName != null) sb.append(receiverFirstName + ' ');
		String fName = sb.toString();
		String fullName = fName.trim();
//        String fullName = (lastName + ' ' + middleName + ' ' + firstName).replace("  ", " ");
		return fullName;
	}
	
	public String getSenderFullname() {
		StringBuilder sb = new StringBuilder();
		if (senderLastName != null) sb.append(senderLastName + ' ');
		if (senderMiddleName != null) sb.append(senderMiddleName + ' ');
		if (senderFirstName != null) sb.append(senderFirstName + ' ');
		String fName = sb.toString();
		String fullName = fName.trim();
//        String fullName = (lastName + ' ' + middleName + ' ' + firstName).replace("  ", " ");
		return fullName;
	}
	
	public int getSenderIdCustomer() {
		return senderIdCustomer;
	}
	
	public void setSenderIdCustomer(int senderIdCustomer) {
		this.senderIdCustomer = senderIdCustomer;
	}
	
	public String getSenderTelephone() {
		return senderTelephone;
	}
	
	public void setSenderTelephone(String senderTelephone) {
		this.senderTelephone = senderTelephone;
	}
	
	public String getSenderLastName() {
		return senderLastName;
	}
	
	public void setSenderLastName(String senderLastName) {
		this.senderLastName = senderLastName;
	}
	
	public String getSenderFirstName() {
		return senderFirstName;
	}
	
	public void setSenderFirstName(String senderFirstName) {
		this.senderFirstName = senderFirstName;
	}
	
	public String getSenderMiddleName() {
		return senderMiddleName;
	}
	
	public void setSenderMiddleName(String senderMiddleName) {
		this.senderMiddleName = senderMiddleName;
	}
	
	public int getReceiverIdCustomer() {
		return receiverIdCustomer;
	}
	
	public void setReceiverIdCustomer(int receiverIdCustomer) {
		this.receiverIdCustomer = receiverIdCustomer;
	}
	
	public String getReceiverTelephone() {
		return receiverTelephone;
	}
	
	public void setReceiverTelephone(String receiverTelephone) {
		this.receiverTelephone = receiverTelephone;
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
	
	public String getReceiverMiddleName() {
		return receiverMiddleName;
	}
	
	public void setReceiverMiddleName(String receiverMiddleName) {
		this.receiverMiddleName = receiverMiddleName;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getTransferDate() {
		return transferDate;
	}
	
	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}
	
	public String getPassPhrase() {
		return passPhrase;
	}
	
	public void setPassPhrase(String passPhrase) {
		this.passPhrase = passPhrase;
	}
	
	public boolean isNeedsConfirmation() {
		return needsConfirmation;
	}
	
	public void setNeedsConfirmation(boolean needsConfirmation) {
		this.needsConfirmation = needsConfirmation;
	}
	
	public Date getScheduleDate() {
		return scheduleDate;
	}
	
	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
}
