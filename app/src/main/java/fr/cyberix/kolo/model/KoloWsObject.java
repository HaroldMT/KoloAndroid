package fr.cyberix.kolo.model;

public class KoloWsObject<T> {
	private boolean isSucces = false;
	private String errorMessage;
	private T dataObject;
	
	public boolean getSucces() {
		return isSucces;
	}
	
	public void setSucces(boolean succes) {
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
