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
	
	public void DoRecieveMadAsync(String jsonMad) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		DoRecieveMadAsync(jsonMad, null);
	}
	
	public void DoRecieveMadAsync(final String jsonMad, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected String doInBackground(Void... params) {
				return DoRecieveMad(jsonMad, headers);
			}
			
			@Override
			protected void onPostExecute(String result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("DoRecieveMad", result);
				}
			}
		}.execute();
	}
	
	public String DoRecieveMad(String jsonMad, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "DoRecieveMad");
		soapReq.addProperty("jsonMad", jsonMad);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call("http://kolo.cyberix.fr/DoRecieveMad", soapEnvelope, headers);
			} else {
				httpTransport.call("http://kolo.cyberix.fr/DoRecieveMad", soapEnvelope);
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
	
	public String DoRecieveMad(String jsonMad) {
		return DoRecieveMad(jsonMad, null);
	}
	
	public void DoSendMadAsync(String jsonMad) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		DoSendMadAsync(jsonMad, null);
	}
	
	public void DoSendMadAsync(final String jsonMad, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected String doInBackground(Void... params) {
				return DoSendMad(jsonMad, headers);
			}
			
			@Override
			protected void onPostExecute(String result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("DoSendMad", result);
				}
			}
		}.execute();
	}
	
	public String DoSendMad(String jsonMad, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "DoSendMad");
		soapReq.addProperty("jsonMad", jsonMad);
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
	
	public String DoSendMad(String jsonMad) {
		return DoSendMad(jsonMad, null);
	}
	
	public void GetMadByBordereauAsync(String jsonBordereau) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		GetMadByBordereauAsync(jsonBordereau, null);
	}
	
	public void GetMadByBordereauAsync(final String jsonBordereau, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected String doInBackground(Void... params) {
				return GetMadByBordereau(jsonBordereau, headers);
			}
			
			@Override
			protected void onPostExecute(String result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("GetMadByBordereau", result);
				}
			}
		}.execute();
	}
	
	public String GetMadByBordereau(String jsonBordereau, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "GetMadByBordereau");
		soapReq.addProperty("jsonBordereau", jsonBordereau);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call("http://kolo.cyberix.fr/GetMadByBordereau", soapEnvelope, headers);
			} else {
				httpTransport.call("http://kolo.cyberix.fr/GetMadByBordereau", soapEnvelope);
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
	
	public String GetMadByBordereau(String jsonBordereau) {
		return GetMadByBordereau(jsonBordereau, null);
	}
	
	public void GetMadByCustomerAsync(String jsonCustomer) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		GetMadByCustomerAsync(jsonCustomer, null);
	}
	
	public void GetMadByCustomerAsync(final String jsonCustomer, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected String doInBackground(Void... params) {
				return GetMadByCustomer(jsonCustomer, headers);
			}
			
			@Override
			protected void onPostExecute(String result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("GetMadByCustomer", result);
				}
			}
		}.execute();
	}
	
	public String GetMadByCustomer(String jsonCustomer, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "GetMadByCustomer");
		soapReq.addProperty("jsonCustomer", jsonCustomer);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call("http://kolo.cyberix.fr/GetMadByCustomer", soapEnvelope, headers);
			} else {
				httpTransport.call("http://kolo.cyberix.fr/GetMadByCustomer", soapEnvelope);
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
	
	public String GetMadByCustomer(String jsonCustomer) {
		return GetMadByCustomer(jsonCustomer, null);
	}
	
	public void GetMadByReferenceAsync(String jsonReference) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		GetMadByReferenceAsync(jsonReference, null);
	}
	
	public void GetMadByReferenceAsync(final String jsonReference, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected String doInBackground(Void... params) {
				return GetMadByReference(jsonReference, headers);
			}
			
			@Override
			protected void onPostExecute(String result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("GetMadByReference", result);
				}
			}
		}.execute();
	}
	
	public String GetMadByReference(String jsonReference, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "GetMadByReference");
		soapReq.addProperty("jsonReference", jsonReference);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call("http://kolo.cyberix.fr/GetMadByReference", soapEnvelope, headers);
			} else {
				httpTransport.call("http://kolo.cyberix.fr/GetMadByReference", soapEnvelope);
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
	
	public String GetMadByReference(String jsonReference) {
		return GetMadByReference(jsonReference, null);
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

