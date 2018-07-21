package fr.cyberix.kolo.model;

public class KoloWsObject<T> {
	private Boolean isSucces;
	private String errorMessage;
	private T dataObject;
	
	public Boolean getSucces() {
		return isSucces;
	}
	
	public void setSucces(Boolean succes) {
		isSucces = succes;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public T getDataObject() {
		return dataObject;
	}
	
	public void setDataObject(T dataObject) {
		this.dataObject = dataObject;
	}
	
}
