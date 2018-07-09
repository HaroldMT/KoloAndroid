package fr.cyberix.kolo.services;

//------------------------------------------------------------------------------
// <wsdl2code-generated>
//    This code was generated by http://www.wsdl2code.com version  2.6
//
// Date Of Creation: 6/2/2018 3:40:35 PM
//    Please dont change this code, regeneration will override your changes
//</wsdl2code-generated>
//
//------------------------------------------------------------------------------
//
//This source code was auto-generated by Wsdl2Code  Version
//

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

public class KolOSphere {
	
	public String NAMESPACE = "http://kolo.cyberix.fr/";
	public String url = "";
	public int timeOut = 180000;
	public IWsdl2CodeEvents eventHandler;
	public WS_Enums.SoapProtocolVersion soapVersion;
	
	public KolOSphere() {
	}
	
	public KolOSphere(IWsdl2CodeEvents eventHandler) {
		this.eventHandler = eventHandler;
	}
	
	public KolOSphere(IWsdl2CodeEvents eventHandler, String url) {
		this.eventHandler = eventHandler;
		this.url = url;
	}
	
	public KolOSphere(IWsdl2CodeEvents eventHandler, String url, int timeOutInSeconds) {
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
	
	public void DoTransfertA2AAsync(String jsonTransfertP2p) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		DoTransfertA2AAsync(jsonTransfertP2p, null);
	}
	
	public void DoTransfertA2AAsync(final String jsonTransfertP2p, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected String doInBackground(Void... params) {
				return DoTransfertA2A(jsonTransfertP2p, headers);
			}
			
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			
			@Override
			protected void onPostExecute(String result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("DoTransfertA2A", result);
				}
			}
		}.execute();
	}
	
	public String DoTransfertA2A(String jsonTransfertP2p, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "DoTransfertA2A");
		soapReq.addProperty("jsonTransfertP2p", jsonTransfertP2p);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call("http://kolo.cyberix.fr/DoTransfertA2A", soapEnvelope, headers);
			} else {
				httpTransport.call("http://kolo.cyberix.fr/DoTransfertA2A", soapEnvelope);
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
	
	public String DoReceiveA2A(String jsonTransfertP2p) {
		return DoReceiveA2A(jsonTransfertP2p, null);
	}
	
	public String DoTransfertA2A(String jsonTransfertP2p) {
		return DoTransfertA2A(jsonTransfertP2p, null);
	}
	
	public String DoReceiveA2A(String jsonTransfertP2p, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "DoTransfertA2A");
		soapReq.addProperty("jsonTransfertP2p", jsonTransfertP2p);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call("http://kolo.cyberix.fr/DoTransfertA2A", soapEnvelope, headers);
			} else {
				httpTransport.call("http://kolo.cyberix.fr/DoTransfertA2A", soapEnvelope);
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
	
	public void DoTransfertA2CAsync(String jsonTransfert2c) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		DoTransfertA2CAsync(jsonTransfert2c, null);
	}
	
	public void DoTransfertA2CAsync(final String jsonTransfert2c, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected String doInBackground(Void... params) {
				return DoTransfertA2C(jsonTransfert2c, headers);
			}
			
			@Override
			protected void onPostExecute(String result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("DoTransfertA2C", result);
				}
			}
		}.execute();
	}
	
	public String DoTransfertA2C(String jsonTransfert2c, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "DoTransfertA2C");
		soapReq.addProperty("jsonTransfert2c", jsonTransfert2c);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call("http://kolo.cyberix.fr/DoTransfertA2C", soapEnvelope, headers);
			} else {
				httpTransport.call("http://kolo.cyberix.fr/DoTransfertA2C", soapEnvelope);
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
	
	public String DoTransfertA2C(String jsonTransfert2c) {
		return DoTransfertA2C(jsonTransfert2c, null);
	}
	
	public void DoTransfertC2AAsync(String jsonTransfert2c) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		DoTransfertC2AAsync(jsonTransfert2c, null);
	}
	
	public void DoTransfertC2AAsync(final String jsonTransfert2c, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected String doInBackground(Void... params) {
				return DoTransfertC2A(jsonTransfert2c, headers);
			}
			
			@Override
			protected void onPostExecute(String result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("DoTransfertC2A", result);
				}
			}
		}.execute();
	}
	
	public String DoTransfertC2A(String jsonTransfert2c, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "DoTransfertC2A");
		soapReq.addProperty("jsonTransfert2c", jsonTransfert2c);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call("http://kolo.cyberix.fr/DoTransfertC2A", soapEnvelope, headers);
			} else {
				httpTransport.call("http://kolo.cyberix.fr/DoTransfertC2A", soapEnvelope);
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
	
	public String DoTransfertC2A(String jsonTransfert2c) {
		return DoTransfertC2A(jsonTransfert2c, null);
	}
	
	public void DoTransfertC2CAsync(String jsonTransfert2c) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		DoTransfertC2CAsync(jsonTransfert2c, null);
	}
	
	public void DoTransfertC2CAsync(final String jsonTransfert2c, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected String doInBackground(Void... params) {
				return DoTransfertC2C(jsonTransfert2c, headers);
			}
			
			@Override
			protected void onPostExecute(String result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("DoTransfertC2C", result);
				}
			}
		}.execute();
	}
	
	public String DoTransfertC2C(String jsonTransfert2c, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "DoTransfertC2C");
		soapReq.addProperty("jsonTransfert2c", jsonTransfert2c);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call("http://kolo.cyberix.fr/DoTransfertC2C", soapEnvelope, headers);
			} else {
				httpTransport.call("http://kolo.cyberix.fr/DoTransfertC2C", soapEnvelope);
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
	
	public String DoTransfertC2C(String jsonTransfert2c) {
		return DoTransfertC2C(jsonTransfert2c, null);
	}
	
	public void GetTransfertP2pByIdTransfertAsync(int idTransfertP2p) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		GetTransfertP2pByIdTransfertAsync(idTransfertP2p, null);
	}
	
	public void GetTransfertP2pByIdTransfertAsync(final int idTransfertP2p, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected String doInBackground(Void... params) {
				return GetTransfertP2pByIdTransfert(idTransfertP2p, headers);
			}
			
			@Override
			protected void onPostExecute(String result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("GetTransfertP2pByIdTransfert", result);
				}
			}
		}.execute();
	}
	
	public String GetTransfertP2pByIdTransfert(int idTransfertP2p, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "GetTransfertP2pByIdTransfert");
		soapReq.addProperty("idTransfertP2p", idTransfertP2p);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call("http://kolo.cyberix.fr/GetTransfertP2pByIdTransfert", soapEnvelope, headers);
			} else {
				httpTransport.call("http://kolo.cyberix.fr/GetTransfertP2pByIdTransfert", soapEnvelope);
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
	
	public String GetTransfertP2pByIdTransfert(int idTransfertP2p) {
		return GetTransfertP2pByIdTransfert(idTransfertP2p, null);
	}
	
	public void GetTransfert2CashByIdTransfertAsync(int idTransfert2Cash) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		GetTransfert2CashByIdTransfertAsync(idTransfert2Cash, null);
	}
	
	public void GetTransfert2CashByIdTransfertAsync(final int idTransfert2Cash, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected String doInBackground(Void... params) {
				return GetTransfert2CashByIdTransfert(idTransfert2Cash, headers);
			}
			
			@Override
			protected void onPostExecute(String result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("GetTransfert2CashByIdTransfert", result);
				}
			}
		}.execute();
	}
	
	public String GetTransfert2CashByIdTransfert(int idTransfert2Cash, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "GetTransfert2CashByIdTransfert");
		soapReq.addProperty("idTransfert2Cash", idTransfert2Cash);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call("http://kolo.cyberix.fr/GetTransfert2CashByIdTransfert", soapEnvelope, headers);
			} else {
				httpTransport.call("http://kolo.cyberix.fr/GetTransfert2CashByIdTransfert", soapEnvelope);
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
	
	public String GetTransfert2CashByIdTransfert(int idTransfert2Cash) {
		return GetTransfert2CashByIdTransfert(idTransfert2Cash, null);
	}
	
	public void GetTransfert2CashDetailsByIdTransfert2CashDetailsAsync(int idTransfert2CashDetails) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		GetTransfert2CashDetailsByIdTransfert2CashDetailsAsync(idTransfert2CashDetails, null);
	}
	
	public void GetTransfert2CashDetailsByIdTransfert2CashDetailsAsync(final int idTransfert2CashDetails, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected String doInBackground(Void... params) {
				return GetTransfert2CashDetailsByIdTransfert2CashDetails(idTransfert2CashDetails, headers);
			}
			
			@Override
			protected void onPostExecute(String result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("GetTransfert2CashDetailsByIdTransfert2CashDetails", result);
				}
			}
		}.execute();
	}
	
	public String GetTransfert2CashDetailsByIdTransfert2CashDetails(int idTransfert2CashDetails, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "GetTransfert2CashDetailsByIdTransfert2CashDetails");
		soapReq.addProperty("idTransfert2CashDetails", idTransfert2CashDetails);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call("http://kolo.cyberix.fr/GetTransfert2CashDetailsByIdTransfert2CashDetails", soapEnvelope, headers);
			} else {
				httpTransport.call("http://kolo.cyberix.fr/GetTransfert2CashDetailsByIdTransfert2CashDetails", soapEnvelope);
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
	
	public String GetTransfert2CashDetailsByIdTransfert2CashDetails(int idTransfert2CashDetails) {
		return GetTransfert2CashDetailsByIdTransfert2CashDetails(idTransfert2CashDetails, null);
	}
	
	public void GetTransfertP2pListAsync(int idCustomer) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		GetTransfertP2pListAsync(idCustomer, null);
	}
	
	public void GetTransfertP2pListAsync(final int idCustomer, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected String doInBackground(Void... params) {
				return GetTransfertP2pList(idCustomer, headers);
			}
			
			@Override
			protected void onPostExecute(String result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("GetTransfertP2pList", result);
				}
			}
		}.execute();
	}
	
	public String GetTransfertP2pList(int idCustomer, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "GetTransfertP2pList");
		soapReq.addProperty("idCustomer", idCustomer);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call("http://kolo.cyberix.fr/GetTransfertP2pList", soapEnvelope, headers);
			} else {
				httpTransport.call("http://kolo.cyberix.fr/GetTransfertP2pList", soapEnvelope);
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
	
	public String GetTransfertP2pList(int idCustomer) {
		return GetTransfertP2pList(idCustomer, null);
	}
	
	public void GetTransfert2CashListAsync(int idTransfert2CashDetails) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		GetTransfert2CashListAsync(idTransfert2CashDetails, null);
	}
	
	public void GetTransfert2CashListAsync(final int idTransfert2CashDetails, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected String doInBackground(Void... params) {
				return GetTransfert2CashList(idTransfert2CashDetails, headers);
			}
			
			@Override
			protected void onPostExecute(String result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("GetTransfert2CashList", result);
				}
			}
		}.execute();
	}
	
	public String GetTransfert2CashList(int idTransfert2CashDetails, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject("http://kolo.cyberix.fr/", "GetTransfert2CashList");
		soapReq.addProperty("idTransfert2CashDetails", idTransfert2CashDetails);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call("http://kolo.cyberix.fr/GetTransfert2CashList", soapEnvelope, headers);
			} else {
				httpTransport.call("http://kolo.cyberix.fr/GetTransfert2CashList", soapEnvelope);
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
	
	public String GetTransfert2CashList(int idTransfert2CashDetails) {
		return GetTransfert2CashList(idTransfert2CashDetails, null);
	}
}
