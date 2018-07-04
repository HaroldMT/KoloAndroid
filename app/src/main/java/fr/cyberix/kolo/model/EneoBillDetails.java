package fr.cyberix.kolo.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class EneoBillDetails implements Parcelable {
	public static final Creator<EneoBillDetails> CREATOR = new Creator<EneoBillDetails>() {
		@Override
		public EneoBillDetails createFromParcel(Parcel in) {
			return new EneoBillDetails(in);
		}
		
		@Override
		public EneoBillDetails[] newArray(int size) {
			return new EneoBillDetails[size];
		}
	};
	Date dueDate;
	int amount;
	String billNumber;
	String contractNumber;
	
	protected EneoBillDetails(Parcel in) {
		dueDate = new Date(in.readLong());
		amount = in.readInt();
		billNumber = in.readString();
		contractNumber = in.readString();
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getBillNumber() {
		return billNumber;
	}
	
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
	
	public String getContractNumber() {
		return contractNumber;
	}
	
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
	
	@Override
	public int describeContents() {
		return hashCode();
	}
	
	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeLong(dueDate.getTime());
		parcel.writeInt(amount);
		parcel.writeString(billNumber);
		parcel.writeString(contractNumber);
	}
	
	@Override
	public String toString() {
		return "Détails de la facture {" +
				"dueDate=" + dueDate +
				", amount=" + amount +
				", billNumber='" + billNumber + '\'' +
				", contractNumber='" + contractNumber + '\'' +
				'}';
	}
}
