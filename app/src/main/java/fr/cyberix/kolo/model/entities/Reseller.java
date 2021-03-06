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

public class Reseller implements KvmSerializable {
	
	private int idPartner;
	private int idWholesalerPartner;
	private Partner partner;
	
	public Reseller() {
	}
	
	public Reseller(SoapObject soapObject) {
		if (soapObject == null)
			return;
		if (soapObject.hasProperty("IdPartner")) {
			Object obj = soapObject.getProperty("IdPartner");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setIdPartner(Integer.parseInt(j.toString()));
			} else if (obj != null && obj instanceof Number) {
				setIdPartner((Integer) obj);
			}
		}
		if (soapObject.hasProperty("IdWholesalerPartner")) {
			Object obj = soapObject.getProperty("IdWholesalerPartner");
			if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
				SoapPrimitive j = (SoapPrimitive) obj;
				setIdWholesalerPartner(Integer.parseInt(j.toString()));
			} else if (obj != null && obj instanceof Number) {
				setIdWholesalerPartner((Integer) obj);
			}
		}
		if (soapObject.hasProperty("Partner")) {
			SoapObject j = (SoapObject) soapObject.getProperty("Partner");
			setPartner(new Partner(j));
			
		}
	}
	
	@Override
	public Object getProperty(int arg0) {
		switch (arg0) {
			case 0:
				return getIdPartner();
			case 1:
				return getIdWholesalerPartner();
			case 2:
				return getPartner();
		}
		return null;
	}
	
	@Override
	public int getPropertyCount() {
		return 3;
	}
	
	@Override
	public void setProperty(int arg0, Object arg1) {
	}
	
	@Override
	public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
		switch (index) {
			case 0:
				info.type = PropertyInfo.INTEGER_CLASS;
				info.name = "IdPartner";
				break;
			case 1:
				info.type = PropertyInfo.INTEGER_CLASS;
				info.name = "IdWholesalerPartner";
				break;
			case 2:
				info.type = Partner.class;
				info.name = "Partner";
				break;
		}
	}
	
	public int getIdPartner() {
		return idPartner;
	}
	
	public void setIdPartner(int idPartner) {
		this.idPartner = idPartner;
	}
	
	public int getIdWholesalerPartner() {
		return idWholesalerPartner;
	}
	
	public void setIdWholesalerPartner(int idWholesalerPartner) {
		this.idWholesalerPartner = idWholesalerPartner;
	}
	
	public Partner getPartner() {
		return partner;
	}
	
	public void setPartner(Partner partner) {
		this.partner = partner;
	}
	
	//    @Override
	public String getInnerText() {
		return null;
	}
	
	//    @Override
	public void setInnerText(String s) {
	}
}
