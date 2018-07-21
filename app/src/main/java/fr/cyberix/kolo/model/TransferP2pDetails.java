package fr.cyberix.kolo.model;

import java.util.Date;

public class TransferP2pDetails {
	private int transferId;
	private String reference;
	private int senderIdCustomer;
	private String senderTelephone;
	private String senderLastName;
	private String senderFirstName;
	private String senderMiddleName;
	private int receiverIdCustomer;
	private String receiverTelephone;
	private String receiverLastName;
	private String receiverFirstName;
	private String receiverMiddleName;
	private int amount;
	private String status;
	private Date transferDate;
	private String passPhrase;
	private boolean needsConfirmation;
	private Date scheduleDate;
	
	public String getReceiverFullname() {
		StringBuilder sb = new StringBuilder();
		if (getReceiverLastName() != null) sb.append(getReceiverLastName() + ' ');
		if (getReceiverMiddleName() != null) sb.append(getReceiverMiddleName() + ' ');
		if (getReceiverFirstName() != null) sb.append(getReceiverFirstName() + ' ');
		String fName = sb.toString();
		String fullName = fName.trim();
//        String fullName = (lastName + ' ' + middleName + ' ' + firstName).replace("  ", " ");
		return fullName;
	}
	
	public String getSenderFullname() {
		StringBuilder sb = new StringBuilder();
		if (getSenderLastName() != null) sb.append(getSenderLastName() + ' ');
		if (getSenderMiddleName() != null) sb.append(getSenderMiddleName() + ' ');
		if (getSenderFirstName() != null) sb.append(getSenderFirstName() + ' ');
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
	
	public String toReceptionString() {
		return getSenderFullname() + " has send " + getAmount() + "XAF on " + getTransferDate().toString() + ". Do you accept it?";
	}
	
	public String toSendingString() {
		return getReceiverFullname() + " will receive " + getAmount() + "XAF. Do you accept it?";
	}
	
	public int getTransferId() {
		return transferId;
	}
	
	public void setTransferId(int transferId) {
		this.transferId = transferId;
	}
	
	public String getReference() {
		return reference;
	}
	
	public void setReference(String reference) {
		this.reference = reference;
	}
}
