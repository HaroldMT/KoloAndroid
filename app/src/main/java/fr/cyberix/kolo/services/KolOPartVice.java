package fr.cyberix.kolo.services;

import android.os.AsyncTask;

import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.List;

import fr.cyberix.kolo.ksoap2.IWsdl2CodeEvents;
import fr.cyberix.kolo.ksoap2.WS_Enums;

public class KolOPartVice {
	
	public String NAMESPACE = "http://kolo.cyberix.fr/";
	public String url = "";
	public int timeOut = 180000;
	public IWsdl2CodeEvents eventHandler;
	public WS_Enums.SoapProtocolVersion soapVersion;
	
	public KolOPartVice() {
	}
	
	public KolOPartVice(IWsdl2CodeEvents eventHandler) {
		this.eventHandler = eventHandler;
	}
	
	public KolOPartVice(IWsdl2CodeEvents eventHandler, String url) {
		this.eventHandler = eventHandler;
		this.url = url;
	}
	
	public KolOPartVice(IWsdl2CodeEvents eventHandler, String url, int timeOutInSeconds) {
		this.eventHandler = eventHandler;
		this.url = url;
		this.setTimeOut(timeOutInSeconds);
	}
	
	public void setTimeOut(int seconds) {
		this.timeOut = seconds * 1000;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void DoPayEneoBillAsync(String jsonBillNumber, String jsonCustomer) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		DoPayEneoBillAsync(jsonBillNumber, jsonCustomer, null);
	}
	
	public void DoPayEneoBillAsync(final String jsonBillNumber, final String jsonCustomer, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected String doInBackground(Void... params) {
				return DoPayEneoBill(jsonBillNumber, jsonCustomer, headers);
			}
			
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			
			@Override
			protected void onPostExecute(String result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("DoPayEneoBill", result);
				}
			}
		}.execute();
	}
	
	public String DoPayEneoBill(String jsonBillNumber, String jsonCustomer, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "DoPayEneoBill");
		soapReq.addProperty("jsonBillNumber", jsonBillNumber);
		soapReq.addProperty("jsonCustomer", jsonCustomer);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call("http://kolo.cyberix.fr/DoPayEneoBill", soapEnvelope, headers);
			} else {
				httpTransport.call("http://kolo.cyberix.fr/DoPayEneoBill", soapEnvelope);
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
	
	public String DoPayEneoBill(String jsonBillNumber, String jsonCustomer) {
		return DoPayEneoBill(jsonBillNumber, jsonCustomer, null);
	}
	
	public void GetEneoBillByBillNumberAsync(String jsonBillNumber) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		GetEneoBillByBillNumberAsync(jsonBillNumber, null);
	}
	
	public void GetEneoBillByBillNumberAsync(final String jsonBillNumber, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected String doInBackground(Void... params) {
				return GetEneoBillByBillNumber(jsonBillNumber, headers);
			}
			
			@Override
			protected void onPostExecute(String result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("GetEneoBillByBillNumber", result);
				}
			}
		}.execute();
	}
	
	public String GetEneoBillByBillNumber(String jsonBillNumber, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "GetEneoBillByBillNumber");
		soapReq.addProperty("jsonBillNumber", jsonBillNumber);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call("http://kolo.cyberix.fr/GetEneoBillByBillNumber", soapEnvelope, headers);
			} else {
				httpTransport.call("http://kolo.cyberix.fr/GetEneoBillByBillNumber", soapEnvelope);
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
	
	public String GetEneoBillByBillNumber(String jsonBillNumber) {
		return GetEneoBillByBillNumber(jsonBillNumber, null);
	}
	
	public void GetEneoBillsByBillAccountAsync(String jsonBillAccount) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		GetEneoBillsByBillAccountAsync(jsonBillAccount, null);
	}
	
	public void GetEneoBillsByBillAccountAsync(final String jsonBillAccount, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected String doInBackground(Void... params) {
				return GetEneoBillsByBillAccount(jsonBillAccount, headers);
			}
			
			@Override
			protected void onPostExecute(String result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("GetEneoBillsByBillAccount", result);
				}
			}
		}.execute();
	}
	
	public String GetEneoBillsByBillAccount(String jsonBillAccount, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "GetEneoBillsByBillAccount");
		soapReq.addProperty("jsonBillAccount", jsonBillAccount);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call("http://kolo.cyberix.fr/GetEneoBillsByBillAccount", soapEnvelope, headers);
			} else {
				httpTransport.call("http://kolo.cyberix.fr/GetEneoBillsByBillAccount", soapEnvelope);
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
	
	public String GetEneoBillsByBillAccount(String jsonBillAccount) {
		return GetEneoBillsByBillAccount(jsonBillAccount, null);
	}
	
	public void FindCustomerMadAsync(int amount, String phone, String customerCode, String reference) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		FindCustomerMadAsync(amount, phone, customerCode, reference, null);
	}
	
	public void FindCustomerMadAsync(final int amount, final String phone, final String customerCode, final String reference, final List<HeaderProperty>
			headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected String doInBackground(Void... params) {
				return FindCustomerMad(amount, phone, customerCode, reference, headers);
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
	
	public String FindCustomerMad(int amount, String phone, String customerCode, String reference, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "FindCustomerMad");
		soapReq.addProperty("amount", amount);
		soapReq.addProperty("phone", phone);
		soapReq.addProperty("customerCode", customerCode);
		soapReq.addProperty("reference", reference);
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
	
	public String FindCustomerMad(int amount, String phone, String customerCode, String reference) {
		return FindCustomerMad(amount, phone, customerCode, reference, null);
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
	
	public void DoSendMadAsync(int idSender, int idReciever, int amount) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		DoSendMadAsync(idSender, idReciever, amount, null);
	}
	
	public void DoSendMadAsync(final int idSender, final int idReciever, final int amount, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, Number>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected Number doInBackground(Void... params) {
				return DoSendMad(idSender, idReciever, amount, headers);
			}
			
			@Override
			protected void onPostExecute(Number result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("DoSendMad", result);
				}
			}
		}.execute();
	}
	
	public int DoSendMad(int idSender, int idReciever, int amount, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "DoSendMad");
		soapReq.addProperty("idSender", idSender);
		soapReq.addProperty("idReciever", idReciever);
		soapReq.addProperty("amount", amount);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call("http://kolo.cyberix.fr/DoSendMad", soapEnvelope, headers);
			} else {
				httpTransport.call("http://kolo.cyberix.fr/DoSendMad", soapEnvelope);
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
						int resultVariable = Integer.parseInt(j.toString());
						return resultVariable;
					} else if (obj != null && obj instanceof Number) {
						int resultVariable = (Integer) obj;
						return resultVariable;
					}
				}
			}
		} catch (Exception e) {
			if (eventHandler != null)
				eventHandler.Wsdl2CodeFinishedWithException(e);
			e.printStackTrace();
		}
		return -1;
	}
	
	public int DoSendMad(int idSender, int idReciever, int amount) {
		return DoSendMad(idSender, idReciever, amount, null);
	}
	
	public void GetMADFeesAsync(int montant) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		GetMADFeesAsync(montant, null);
	}
	
	public void GetMADFeesAsync(final int montant, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, Number>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected Number doInBackground(Void... params) {
				return GetMADFees(montant, headers);
			}
			
			@Override
			protected void onPostExecute(Number result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("GetMADFees", result);
				}
			}
		}.execute();
	}
	
	public int GetMADFees(int montant, List<HeaderProperty> headers) {
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
						int resultVariable = Integer.parseInt(j.toString());
						return resultVariable;
					} else if (obj != null && obj instanceof Number) {
						int resultVariable = (Integer) obj;
						return resultVariable;
					}
				}
			}
		} catch (Exception e) {
			if (eventHandler != null)
				eventHandler.Wsdl2CodeFinishedWithException(e);
			e.printStackTrace();
		}
		return -1;
	}
	
	public int GetMADFees(int montant) {
		return GetMADFees(montant, null);
	}
	
	public void DoTopUpAsync(String jsonTopUp) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		DoTopUpAsync(jsonTopUp, null);
	}
	
	public void DoTopUpAsync(final String jsonTopUp, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected String doInBackground(Void... params) {
				return DoTopUp(jsonTopUp, headers);
			}
			
			@Override
			protected void onPostExecute(String result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("DoTopUp", result);
				}
			}
		}.execute();
	}
	
	public String DoTopUp(String jsonTopUp, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "DoTopUp");
		soapReq.addProperty("jsonTopUp", jsonTopUp);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call("http://kolo.cyberix.fr/DoTopUp", soapEnvelope, headers);
			} else {
				httpTransport.call("http://kolo.cyberix.fr/DoTopUp", soapEnvelope);
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
	
	public String DoTopUp(String jsonTopUp) {
		return DoTopUp(jsonTopUp, null);
	}
	
}
