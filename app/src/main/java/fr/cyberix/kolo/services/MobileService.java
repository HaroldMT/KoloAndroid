package fr.cyberix.kolo.services;

import android.os.AsyncTask;

import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.List;

import fr.cyberix.kolo.ksoap2.IWsdl2CodeEvents;
import fr.cyberix.kolo.ksoap2.WS_Enums;
import fr.cyberix.kolo.model.entities.MobileDevice;
import fr.cyberix.kolo.model.entities.MyRefTypes;
import fr.cyberix.kolo.model.entities.RefGender;

public class MobileService {
	
	public String NAMESPACE ="http://kolo.cyberix.fr/";
	public String url = "";
    public int timeOut = 180000;
    public IWsdl2CodeEvents eventHandler;
    public WS_Enums.SoapProtocolVersion soapVersion;
	
	public MobileService(){}
	
	public MobileService(IWsdl2CodeEvents eventHandler)
    {
        this.eventHandler = eventHandler;
    }
    public MobileService(IWsdl2CodeEvents eventHandler,String url)
    {
        this.eventHandler = eventHandler;
        this.url = url;
    }
    public MobileService(IWsdl2CodeEvents eventHandler,String url,int timeOutInSeconds)
    {
        this.eventHandler = eventHandler;
        this.url = url;
        this.setTimeOut(timeOutInSeconds);
    }
    public void setTimeOut(int seconds){
        this.timeOut = seconds * 1000;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public void GetRefGenderAsync() throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        GetRefGenderAsync(null);
    }
	
	public void GetRefGenderAsync(final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, RefGender>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            }
			
			@Override
            protected RefGender doInBackground(Void... params) {
                return GetRefGender(headers);
            }
            @Override
            protected void onPostExecute(RefGender result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("GetRefGender", result);
                }
            }
        }.execute();
    }
	
	public RefGender GetRefGender(){
        return GetRefGender(null);
    }
	
	public RefGender GetRefGender(List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/","GetRefGender");
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://kolo.cyberix.fr/GetRefGender", soapEnvelope,headers);
            }else{
                httpTransport.call("http://kolo.cyberix.fr/GetRefGender", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    SoapObject j = (SoapObject)obj;
                    RefGender resultVariable =  new RefGender (j);
                    return resultVariable;
	
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return null;
    }
	
	public void CreatePersonAsync(String jsonPerson) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        CreatePersonAsync(jsonPerson, null);
    }
	
	public void CreatePersonAsync(final String jsonPerson, final List<HeaderProperty> headers) {
        
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            }
	
	        @Override
            protected Void doInBackground(Void... params) {
                CreatePerson(jsonPerson, headers);
                return null;
            }
            @Override
            protected void onPostExecute(Void result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("CreatePerson", result);
                }
            }
        }.execute();
    }
	
	public void CreatePerson(String jsonPerson){
        CreatePerson(jsonPerson, null);
    }
	
	public void CreatePerson(String jsonPerson,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/","CreatePerson");
        soapReq.addProperty("jsonPerson",jsonPerson);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://kolo.cyberix.fr/CreatePerson", soapEnvelope,headers);
            }else{
                httpTransport.call("http://kolo.cyberix.fr/CreatePerson", soapEnvelope);
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
    }
	
	public void TestServiceAsync(MyRefTypes myRefTypes) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        TestServiceAsync(myRefTypes, null);
    }
	
	public void TestServiceAsync(final MyRefTypes myRefTypes, final List<HeaderProperty> headers) {
        
        new AsyncTask<Void, Void, MyRefTypes>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            }
	
	        @Override
            protected MyRefTypes doInBackground(Void... params) {
                return TestService(myRefTypes, headers);
            }
            @Override
            protected void onPostExecute(MyRefTypes result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("TestService", result);
                }
            }
        }.execute();
    }
	
	public MyRefTypes TestService(MyRefTypes myRefTypes){
        return TestService(myRefTypes, null);
    }
	
	public MyRefTypes TestService(MyRefTypes myRefTypes, List<HeaderProperty> headers) {
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/","TestService");
        soapEnvelope.addMapping("http://kolo.cyberix.fr/","myRefTypes",new MyRefTypes().getClass());
        MarshalFloat marshalFloat = new MarshalFloat();
        marshalFloat.register(soapEnvelope);
        soapReq.addProperty("myRefTypes",myRefTypes);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://kolo.cyberix.fr/TestService", soapEnvelope,headers);
            }else{
                httpTransport.call("http://kolo.cyberix.fr/TestService", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    SoapObject j = (SoapObject)obj;
                    MyRefTypes resultVariable =  new MyRefTypes (j);
                    return resultVariable;
	
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return null;
    }
	
	public void InsertMobileDeviceAsync(String jsonMobileDevice) throws Exception{
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        InsertMobileDeviceAsync(jsonMobileDevice, null);
    }
	
	public void InsertMobileDeviceAsync(final String jsonMobileDevice, final List<HeaderProperty> headers) {
        
        new AsyncTask<Void, Void, MobileDevice>(){
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            }
	
	        @Override
            protected MobileDevice doInBackground(Void... params) {
                return InsertMobileDevice(jsonMobileDevice, headers);
            }
            @Override
            protected void onPostExecute(MobileDevice result)
            {
                eventHandler.Wsdl2CodeEndedRequest();
                if (result != null){
                    eventHandler.Wsdl2CodeFinished("InsertMobileDevice", result);
                }
            }
        }.execute();
    }
	
	public MobileDevice InsertMobileDevice(String jsonMobileDevice){
        return InsertMobileDevice(jsonMobileDevice, null);
    }
	
	public MobileDevice InsertMobileDevice(String jsonMobileDevice,List<HeaderProperty> headers){
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
        SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/","InsertMobileDevice");
        soapReq.addProperty("jsonMobileDevice",jsonMobileDevice);
        soapEnvelope.setOutputSoapObject(soapReq);
        HttpTransportSE httpTransport = new HttpTransportSE(url,timeOut);
        try{
            if (headers!=null){
                httpTransport.call("http://kolo.cyberix.fr/InsertMobileDevice", soapEnvelope,headers);
            }else{
                httpTransport.call("http://kolo.cyberix.fr/InsertMobileDevice", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
            if (retObj instanceof SoapFault){
                SoapFault fault = (SoapFault)retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
            }else{
                SoapObject result=(SoapObject)retObj;
                if (result.getPropertyCount() > 0){
                    Object obj = result.getProperty(0);
                    SoapObject j = (SoapObject)obj;
                    MobileDevice resultVariable =  new MobileDevice (j);
                    return resultVariable;
	
                }
            }
        }catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return null;
    }
	
	public void GetCustomerByIdCustomerAndNumberAsync(int idCustomer, String number) throws Exception {
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        GetCustomerByIdCustomerAndNumberAsync(idCustomer, number, null);
    }
	
	public void GetCustomerByIdCustomerAndNumberAsync(final int idCustomer, final String number, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            }
			
			@Override
			protected String doInBackground(Void... params) {
				return GetCustomerByIdCustomerAndNumber(idCustomer, number, headers);
			}
            @Override
            protected void onPostExecute(String result) {
                eventHandler.Wsdl2CodeEndedRequest();
	            if (result != null) {
                    eventHandler.Wsdl2CodeFinished("GetCustomerByIdCustomerAndNumber", result);
                }
            }
        }.execute();
    }
	
	public String GetCustomerByIdCustomerAndNumber(int idCustomer, String number, List<HeaderProperty> headers) {
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "GetCustomerByIdCustomerAndNumber");
		soapReq.addProperty("idCustomer", idCustomer);
		soapReq.addProperty("number", number);
        soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call("http://kolo.cyberix.fr/GetCustomerByIdCustomerAndNumber", soapEnvelope, headers);
			} else {
                httpTransport.call("http://kolo.cyberix.fr/GetCustomerByIdCustomerAndNumber", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
			if (retObj instanceof SoapFault) {
				SoapFault fault = (SoapFault) retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
			} else {
				SoapObject result = (SoapObject) retObj;
				if (result.getPropertyCount() > 0) {
                    Object obj = result.getProperty(0);
					if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
						SoapPrimitive j = (SoapPrimitive) obj;
                        String resultVariable = j.toString();
                        return resultVariable;
					} else if (obj != null && obj instanceof String) {
                        String resultVariable = (String) obj;
                        return resultVariable;
                    }
                }
            }
		} catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return "";
    }
	
	public String GetCustomerByIdCustomerAndNumber(int idCustomer, String number) {
        return GetCustomerByIdCustomerAndNumber(idCustomer, number, null);
    }
	
	public void GetCustomerAccountAsync(int idCustomer) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		GetCustomerAccountAsync(idCustomer, null);
	}
	
	public void GetCustomerAccountAsync(final int idCustomer, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected String doInBackground(Void... params) {
				return GetCustomerAccount(idCustomer, headers);
			}
			
			@Override
			protected void onPostExecute(String result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("GetCustomerAccount", result);
				}
			}
		}.execute();
	}
	
	public String GetCustomerAccount(int idCustomer, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "GetCustomerAccount");
		soapReq.addProperty("idCustomer", idCustomer);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call("http://kolo.cyberix.fr/GetCustomerAccount", soapEnvelope, headers);
			} else {
				httpTransport.call("http://kolo.cyberix.fr/GetCustomerAccount", soapEnvelope);
			}
			Object retObj = soapEnvelope.bodyIn;
			if (retObj instanceof SoapFault) {
				SoapFault fault = (SoapFault) retObj;
				Exception ex = new Exception(fault.faultstring);
				if (eventHandler != null)
					eventHandler.Wsdl2CodeFinishedWithException(ex);
			} else {
				SoapObject result = (SoapObject) retObj;
				if (result.getPropertyCount() > 0) {
					Object obj = result.getProperty(0);
					if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
						SoapPrimitive j = (SoapPrimitive) obj;
						String resultVariable = j.toString();
						return resultVariable;
					} else if (obj != null && obj instanceof String) {
						String resultVariable = (String) obj;
						return resultVariable;
					}
				}
			}
		} catch (Exception e) {
			if (eventHandler != null)
				eventHandler.Wsdl2CodeFinishedWithException(e);
			e.printStackTrace();
		}
		return "";
	}
	
	public String GetCustomerAccount(int idCustomer) {
		return GetCustomerAccount(idCustomer, null);
	}
	
	public void GetCustomerContactsAsync(String contacts, String idCustomer) throws Exception {
        if (this.eventHandler == null)
            throw new Exception("Async Methods Requires IWsdl2CodeEvents");
        GetCustomerContactsAsync(contacts, idCustomer, null);
    }
	
	public void GetCustomerContactsAsync(final String contacts, final String idCustomer, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
            @Override
            protected void onPreExecute() {
                eventHandler.Wsdl2CodeStartedRequest();
            }
			
			@Override
            protected String doInBackground(Void... params) {
                return GetCustomerContacts(contacts, idCustomer, headers);
            }
            @Override
            protected void onPostExecute(String result) {
                eventHandler.Wsdl2CodeEndedRequest();
	            if (result != null) {
                    eventHandler.Wsdl2CodeFinished("GetCustomerContacts", result);
                }
            }
        }.execute();
    }
	
	public String GetCustomerContacts(String contacts, String idCustomer, List<HeaderProperty> headers) {
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.implicitTypes = true;
        soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "GetCustomerContacts");
		soapReq.addProperty("contacts", contacts);
		soapReq.addProperty("idCustomer", idCustomer);
        soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call("http://kolo.cyberix.fr/GetCustomerContacts", soapEnvelope, headers);
			} else {
                httpTransport.call("http://kolo.cyberix.fr/GetCustomerContacts", soapEnvelope);
            }
            Object retObj = soapEnvelope.bodyIn;
			if (retObj instanceof SoapFault) {
				SoapFault fault = (SoapFault) retObj;
                Exception ex = new Exception(fault.faultstring);
                if (eventHandler != null)
                    eventHandler.Wsdl2CodeFinishedWithException(ex);
			} else {
				SoapObject result = (SoapObject) retObj;
				if (result.getPropertyCount() > 0) {
                    Object obj = result.getProperty(0);
					if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
						SoapPrimitive j = (SoapPrimitive) obj;
                        String resultVariable = j.toString();
                        return resultVariable;
					} else if (obj != null && obj instanceof String) {
                        String resultVariable = (String) obj;
                        return resultVariable;
                    }
                }
            }
		} catch (Exception e) {
            if (eventHandler != null)
                eventHandler.Wsdl2CodeFinishedWithException(e);
            e.printStackTrace();
        }
        return "";
    }
	
	public String GetCustomerContacts(String contacts, String idCustomer) {
        return GetCustomerContacts(contacts, idCustomer, null);
    }
	
	public void FindCustomerMadAsync(String jsonMadCustomer) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		FindCustomerMadAsync(jsonMadCustomer, null);
	}
	
	public void FindCustomerMadAsync(final String jsonMadCustomer, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected String doInBackground(Void... params) {
				return FindCustomerMad(jsonMadCustomer, headers);
			}
			
			@Override
			protected void onPostExecute(String result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("FindCustomerMad", result);
				}
			}
		}.execute();
	}
	
	public String FindCustomerMad(String jsonMadCustomer, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "FindCustomerMad");
		soapReq.addProperty("jsonMadCustomer", jsonMadCustomer);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call("http://kolo.cyberix.fr/FindCustomerMad", soapEnvelope, headers);
			} else {
				httpTransport.call("http://kolo.cyberix.fr/FindCustomerMad", soapEnvelope);
			}
			Object retObj = soapEnvelope.bodyIn;
			if (retObj instanceof SoapFault) {
				SoapFault fault = (SoapFault) retObj;
				Exception ex = new Exception(fault.faultstring);
				if (eventHandler != null)
					eventHandler.Wsdl2CodeFinishedWithException(ex);
			} else {
				SoapObject result = (SoapObject) retObj;
				if (result.getPropertyCount() > 0) {
					Object obj = result.getProperty(0);
					if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
						SoapPrimitive j = (SoapPrimitive) obj;
						String resultVariable = j.toString();
						return resultVariable;
					} else if (obj != null && obj instanceof String) {
						String resultVariable = (String) obj;
						return resultVariable;
					}
				}
			}
		} catch (Exception e) {
			if (eventHandler != null)
				eventHandler.Wsdl2CodeFinishedWithException(e);
			e.printStackTrace();
		}
		return "";
	}
	
	public String FindCustomerMad(String jsonMadCustomer) {
		return FindCustomerMad(jsonMadCustomer, null);
	}
	
	public void FindManagerCustomerByPhoneAsync(String phone) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		FindManagerCustomerByPhoneAsync(phone, null);
	}
	
	public void FindManagerCustomerByPhoneAsync(final String phone, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected String doInBackground(Void... params) {
				return FindManagerCustomerByPhone(phone, headers);
			}
			
			@Override
			protected void onPostExecute(String result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("FindManagerCustomerByPhone", result);
				}
			}
		}.execute();
	}
	
	public String FindManagerCustomerByPhone(String phone, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "FindManagerCustomerByPhone");
		soapReq.addProperty("phone", phone);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call("http://kolo.cyberix.fr/FindManagerCustomerByPhone", soapEnvelope, headers);
			} else {
				httpTransport.call("http://kolo.cyberix.fr/FindManagerCustomerByPhone", soapEnvelope);
			}
			Object retObj = soapEnvelope.bodyIn;
			if (retObj instanceof SoapFault) {
				SoapFault fault = (SoapFault) retObj;
				Exception ex = new Exception(fault.faultstring);
				if (eventHandler != null)
					eventHandler.Wsdl2CodeFinishedWithException(ex);
			} else {
				SoapObject result = (SoapObject) retObj;
				if (result.getPropertyCount() > 0) {
					Object obj = result.getProperty(0);
					if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
						SoapPrimitive j = (SoapPrimitive) obj;
						String resultVariable = j.toString();
						return resultVariable;
					} else if (obj != null && obj instanceof String) {
						String resultVariable = (String) obj;
						return resultVariable;
					}
				}
			}
		} catch (Exception e) {
			if (eventHandler != null)
				eventHandler.Wsdl2CodeFinishedWithException(e);
			e.printStackTrace();
		}
		return "";
	}
	
	public String FindManagerCustomerByPhone(String phone) {
		return FindManagerCustomerByPhone(phone, null);
	}
	
	public void FindManagerCustomerByCustomerCodeAsync(String customerCode) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		FindManagerCustomerByCustomerCodeAsync(customerCode, null);
	}
	
	public void FindManagerCustomerByCustomerCodeAsync(final String customerCode, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected String doInBackground(Void... params) {
				return FindManagerCustomerByCustomerCode(customerCode, headers);
			}
			
			@Override
			protected void onPostExecute(String result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("FindManagerCustomerByCustomerCode", result);
				}
			}
		}.execute();
	}
	
	public String FindManagerCustomerByCustomerCode(String customerCode, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "FindManagerCustomerByCustomerCode");
		soapReq.addProperty("customerCode", customerCode);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call("http://kolo.cyberix.fr/FindManagerCustomerByCustomerCode", soapEnvelope, headers);
			} else {
				httpTransport.call("http://kolo.cyberix.fr/FindManagerCustomerByCustomerCode", soapEnvelope);
			}
			Object retObj = soapEnvelope.bodyIn;
			if (retObj instanceof SoapFault) {
				SoapFault fault = (SoapFault) retObj;
				Exception ex = new Exception(fault.faultstring);
				if (eventHandler != null)
					eventHandler.Wsdl2CodeFinishedWithException(ex);
			} else {
				SoapObject result = (SoapObject) retObj;
				if (result.getPropertyCount() > 0) {
					Object obj = result.getProperty(0);
					if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
						SoapPrimitive j = (SoapPrimitive) obj;
						String resultVariable = j.toString();
						return resultVariable;
					} else if (obj != null && obj instanceof String) {
						String resultVariable = (String) obj;
						return resultVariable;
					}
				}
			}
		} catch (Exception e) {
			if (eventHandler != null)
				eventHandler.Wsdl2CodeFinishedWithException(e);
			e.printStackTrace();
		}
		return "";
	}
	
	public String FindManagerCustomerByCustomerCode(String customerCode) {
		return FindManagerCustomerByCustomerCode(customerCode, null);
	}
	
	public void GetMADFeesAsync(int montant) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		GetMADFeesAsync(montant, null);
	}
	
	public void GetMADFeesAsync(final int montant, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected String doInBackground(Void... params) {
				return GetMADFees(montant, headers);
			}
			
			@Override
			protected void onPostExecute(String result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("GetMADFees", result);
				}
			}
		}.execute();
	}
	
	public String GetMADFees(int montant, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "GetMADFees");
		soapReq.addProperty("montant", montant);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call("http://kolo.cyberix.fr/GetMADFees", soapEnvelope, headers);
			} else {
				httpTransport.call("http://kolo.cyberix.fr/GetMADFees", soapEnvelope);
			}
			Object retObj = soapEnvelope.bodyIn;
			if (retObj instanceof SoapFault) {
				SoapFault fault = (SoapFault) retObj;
				Exception ex = new Exception(fault.faultstring);
				if (eventHandler != null)
					eventHandler.Wsdl2CodeFinishedWithException(ex);
			} else {
				SoapObject result = (SoapObject) retObj;
				if (result.getPropertyCount() > 0) {
					Object obj = result.getProperty(0);
					if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
						SoapPrimitive j = (SoapPrimitive) obj;
						String resultVariable = j.toString();
						return resultVariable;
					} else if (obj != null && obj instanceof String) {
						String resultVariable = (String) obj;
						return resultVariable;
					}
				}
			}
		} catch (Exception e) {
			if (eventHandler != null)
				eventHandler.Wsdl2CodeFinishedWithException(e);
			e.printStackTrace();
		}
		return "";
	}
	
	public String GetMADFees(int montant) {
		return GetMADFees(montant, null);
	}
	
	public void GetEneoBillPaymentHistoryAsync(int jsonIdCustomer) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		GetEneoBillPaymentHistoryAsync(jsonIdCustomer, null);
	}
	
	public void GetEneoBillPaymentHistoryAsync(final int jsonIdCustomer, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected String doInBackground(Void... params) {
				return GetEneoBillPaymentHistory(jsonIdCustomer, headers);
			}
			
			@Override
			protected void onPostExecute(String result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("GetEneoBillPaymentHistory", result);
				}
			}
		}.execute();
	}
	
	public String GetEneoBillPaymentHistory(int jsonIdCustomer, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "GetEneoBillPaymentHistory");
		soapReq.addProperty("jsonIdCustomer", jsonIdCustomer);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call("http://kolo.cyberix.fr/GetEneoBillPaymentHistory", soapEnvelope, headers);
			} else {
				httpTransport.call("http://kolo.cyberix.fr/GetEneoBillPaymentHistory", soapEnvelope);
			}
			Object retObj = soapEnvelope.bodyIn;
			if (retObj instanceof SoapFault) {
				SoapFault fault = (SoapFault) retObj;
				Exception ex = new Exception(fault.faultstring);
				if (eventHandler != null)
					eventHandler.Wsdl2CodeFinishedWithException(ex);
			} else {
				SoapObject result = (SoapObject) retObj;
				if (result.getPropertyCount() > 0) {
					Object obj = result.getProperty(0);
					if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
						SoapPrimitive j = (SoapPrimitive) obj;
						String resultVariable = j.toString();
						return resultVariable;
					} else if (obj != null && obj instanceof String) {
						String resultVariable = (String) obj;
						return resultVariable;
					}
				}
			}
		} catch (Exception e) {
			if (eventHandler != null)
				eventHandler.Wsdl2CodeFinishedWithException(e);
			e.printStackTrace();
		}
		return "";
	}
	
	public String GetEneoBillPaymentHistory(int jsonIdCustomer) {
		return GetEneoBillPaymentHistory(jsonIdCustomer, null);
	}
	
	public void GetCustomerBalanceHistoryAsync(int jsonIdCustomer) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		GetCustomerBalanceHistoryAsync(jsonIdCustomer, null);
	}
	
	public void GetCustomerBalanceHistoryAsync(final int jsonIdCustomer, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected String doInBackground(Void... params) {
				return GetCustomerBalanceHistory(jsonIdCustomer, headers);
			}
			
			@Override
			protected void onPostExecute(String result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("GetCustomerBalanceHistory", result);
				}
			}
		}.execute();
	}
	
	public String GetCustomerBalanceHistory(int jsonIdCustomer, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "GetCustomerBalanceHistory");
		soapReq.addProperty("jsonIdCustomer", jsonIdCustomer);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call("http://kolo.cyberix.fr/GetCustomerBalanceHistory", soapEnvelope, headers);
			} else {
				httpTransport.call("http://kolo.cyberix.fr/GetCustomerBalanceHistory", soapEnvelope);
			}
			Object retObj = soapEnvelope.bodyIn;
			if (retObj instanceof SoapFault) {
				SoapFault fault = (SoapFault) retObj;
				Exception ex = new Exception(fault.faultstring);
				if (eventHandler != null)
					eventHandler.Wsdl2CodeFinishedWithException(ex);
			} else {
				SoapObject result = (SoapObject) retObj;
				if (result.getPropertyCount() > 0) {
					Object obj = result.getProperty(0);
					if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
						SoapPrimitive j = (SoapPrimitive) obj;
						String resultVariable = j.toString();
						return resultVariable;
					} else if (obj != null && obj instanceof String) {
						String resultVariable = (String) obj;
						return resultVariable;
					}
				}
			}
		} catch (Exception e) {
			if (eventHandler != null)
				eventHandler.Wsdl2CodeFinishedWithException(e);
			e.printStackTrace();
		}
		return "";
	}
	
	public String GetCustomerBalanceHistory(int jsonIdCustomer) {
		return GetCustomerBalanceHistory(jsonIdCustomer, null);
	}
	
	public void GetCustomerNotificationsAsync(int jsonIdCustomer) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		GetCustomerNotificationsAsync(jsonIdCustomer, null);
	}
	
	public void GetCustomerNotificationsAsync(final int jsonIdCustomer, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected String doInBackground(Void... params) {
				return GetCustomerNotifications(jsonIdCustomer, headers);
			}
			
			@Override
			protected void onPostExecute(String result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("GetCustomerNotifications", result);
				}
			}
		}.execute();
	}
	
	public String GetCustomerNotifications(int jsonIdCustomer, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "GetCustomerNotifications");
		soapReq.addProperty("jsonIdCustomer", jsonIdCustomer);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call("http://kolo.cyberix.fr/GetCustomerNotifications", soapEnvelope, headers);
			} else {
				httpTransport.call("http://kolo.cyberix.fr/GetCustomerNotifications", soapEnvelope);
			}
			Object retObj = soapEnvelope.bodyIn;
			if (retObj instanceof SoapFault) {
				SoapFault fault = (SoapFault) retObj;
				Exception ex = new Exception(fault.faultstring);
				if (eventHandler != null)
					eventHandler.Wsdl2CodeFinishedWithException(ex);
			} else {
				SoapObject result = (SoapObject) retObj;
				if (result.getPropertyCount() > 0) {
					Object obj = result.getProperty(0);
					if (obj != null && obj.getClass().equals(SoapPrimitive.class)) {
						SoapPrimitive j = (SoapPrimitive) obj;
						String resultVariable = j.toString();
						return resultVariable;
					} else if (obj != null && obj instanceof String) {
						String resultVariable = (String) obj;
						return resultVariable;
					}
				}
			}
		} catch (Exception e) {
			if (eventHandler != null)
				eventHandler.Wsdl2CodeFinishedWithException(e);
			e.printStackTrace();
		}
		return "";
	}
	
	public String GetCustomerNotifications(int jsonIdCustomer) {
		return GetCustomerNotifications(jsonIdCustomer, null);
	}
    
}
