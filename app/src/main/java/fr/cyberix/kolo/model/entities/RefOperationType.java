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

public class RefOperationType implements KvmSerializable {
	
	private String operationTypeCode;
	private String operationTypeName;
	
	public RefOperationType() {
	}
	
	public RefOperationType(SoapObject soapObject) {
		if (soapObject == null)
			return;
		if (soapObject.hasProperty("OperationTypeCode")) {
			Object obj = soapObject.getProperty("OperationTypeCode");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setOperationTypeCode(j.toString());
			} else if (obj != null && obj instanceof String) {
				setOperationTypeCode((String) obj);
			}
		}
		if (soapObject.hasProperty("OperationTypeName")) {
			Object obj = soapObject.getProperty("OperationTypeName");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setOperationTypeName(j.toString());
			} else if (obj != null && obj instanceof String) {
				setOperationTypeName((String) obj);
			}
		}
	}
	
	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
			case 0:
				return getOperationTypeCode();
			case 1:
				return getOperationTypeName();
		}
		return null;
	}
	
	@Override
	public int getPropertyCount() {
		return 2;
	}
	
	@Override
	public void setProperty(int arg0, Object arg1) {
	}
	
	@Override
	public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
		switch (index) {
			case 0:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "OperationTypeCode";
				break;
			case 1:
				info.type = PropertyInfo.STRING_CLASS;
				info.name = "OperationTypeName";
				break;
		}
	}
	
	public String getOperationTypeCode() {
		return operationTypeCode;
	}
	
	public void setOperationTypeCode(String operationTypeCode) {
		this.operationTypeCode = operationTypeCode;
	}
	
	public String getOperationTypeName() {
		return operationTypeName;
	}
	
	public void setOperationTypeName(String operationTypeName) {
		this.operationTypeName = operationTypeName;
	}
	
	//    @Override
	public String getInnerText() {
		return null;
	}
	
	//    @Override
	public void setInnerText(String s) {
	}
}
