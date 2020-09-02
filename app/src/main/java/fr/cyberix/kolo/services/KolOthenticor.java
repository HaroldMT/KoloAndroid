package fr.cyberix.kolo.services;

import android.os.AsyncTask;
import android.util.Log;

import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.MarshalFloat;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.List;

import fr.cyberix.kolo.helpers.KoloConstants;
import fr.cyberix.kolo.ksoap2.IWsdl2CodeEvents;
import fr.cyberix.kolo.ksoap2.WS_Enums;
import fr.cyberix.kolo.model.entities.Customer;
import fr.cyberix.kolo.model.entities.LoginAttempt;
import fr.cyberix.kolo.model.entities.Registration;

public class KolOthenticor {
	final static String TAG = "KolOthenticator";
	public String NAMESPACE = KoloConstants.KolOthenticor_BaseUrl;
	public String url = "";
	public int timeOut = 180000;
	public IWsdl2CodeEvents eventHandler;
	public WS_Enums.SoapProtocolVersion soapVersion;
	
	public KolOthenticor() {
	}
	
	public KolOthenticor(IWsdl2CodeEvents eventHandler) {
		this.eventHandler = eventHandler;
	}
	
	public KolOthenticor(IWsdl2CodeEvents eventHandler, String url) {
		this.eventHandler = eventHandler;
		this.url = url;
	}
	
	public KolOthenticor(IWsdl2CodeEvents eventHandler, String url, int timeOutInSeconds) {
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
	
	public void DoConfirmRegistrationAsync(String jsonReg) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		DoConfirmRegistrationAsync(jsonReg, null);
	}
	
	public void DoConfirmRegistrationAsync(final String jsonReg, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected String doInBackground(Void... params) {
				return DoConfirmRegistration(jsonReg, headers);
			}
			
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			
			@Override
			protected void onPostExecute(String result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("DoConfirmRegistration", result);
				}
			}
		}.execute();
	}
	
	public String DoConfirmRegistration(String jsonReg, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject(KoloConstants.KolOthenticor_BaseUrl, "DoConfirmRegistration");
		soapReq.addProperty("jsonReg", jsonReg);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call(KoloConstants.KolOthenticor_BaseUrl + "DoConfirmRegistration", soapEnvelope, headers);
			} else {
				httpTransport.call(KoloConstants.KolOthenticor_BaseUrl + "DoConfirmRegistration", soapEnvelope);
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
	
	public String DoConfirmRegistration(String jsonReg) {
		return DoConfirmRegistration(jsonReg, null);
	}
	
	public void DoLoginAsync(String jsonLogAttempt) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		DoLoginAsync(jsonLogAttempt, null);
	}
	
	public void DoLoginAsync(final String jsonLogAttempt, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected String doInBackground(Void... params) {
				return DoLogin(jsonLogAttempt, headers);
			}
			
			@Override
			protected void onPostExecute(String result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("DoLogin", result);
				}
			}
		}.execute();
	}
	
	public String DoLogin(String jsonLogAttempt, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject(KoloConstants.KolOthenticor_BaseUrl, "DoLogin");
		soapReq.addProperty("jsonLogAttempt", jsonLogAttempt);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call(KoloConstants.KolOthenticor_BaseUrl + "DoLogin", soapEnvelope, headers);
			} else {
				httpTransport.call(KoloConstants.KolOthenticor_BaseUrl + "DoLogin", soapEnvelope);
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
	
	public String DoLogin(String jsonLogAttempt) {
		return DoLogin(jsonLogAttempt, null);
	}
	
	public void DoRegistrationAsync(String jsonReg) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		DoRegistrationAsync(jsonReg, null);
	}
	
	public void DoRegistrationAsync(final String jsonReg, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected String doInBackground(Void... params) {
				return DoRegistration(jsonReg, headers);
			}
			
			@Override
			protected void onPostExecute(String result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("DoRegistration", result);
				}
			}
		}.execute();
	}
	
	public String DoRegistration(String jsonReg, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;

		SoapObject soapReq = new SoapObject(KoloConstants.NAMESPACE, "DoRegistration");
		soapReq.addProperty("jsonReg", jsonReg);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			Log.d(TAG, "URL : " + KoloConstants.KolOthenticor_BaseUrl + "?op=DoRegistration");

			if (headers != null) {
				httpTransport.call(KoloConstants.NAMESPACE + "DoRegistration", soapEnvelope, headers);
			} else {
				httpTransport.call(KoloConstants.NAMESPACE + "DoRegistration", soapEnvelope);
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
					Object obj = result.getProperty(0); //((SoapObject)result.getProperty(0)).getProperty(2); // (); IsSuccess, ErrorMessage,  DataObject

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
	
	public String DoRegistration(String jsonReg) {
		return DoRegistration(jsonReg, null);
	}
	
	public void SignInAsync(LoginAttempt loginAttempt) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		SignInAsync(loginAttempt, null);
	}
	
	public void SignInAsync(final LoginAttempt loginAttempt, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, LoginAttempt>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected LoginAttempt doInBackground(Void... params) {
				return SignIn(loginAttempt, headers);
			}
			
			@Override
			protected void onPostExecute(LoginAttempt result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("SignIn", result);
				}
			}
		}.execute();
	}
	
	public LoginAttempt SignIn(LoginAttempt loginAttempt, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject(KoloConstants.KolOthenticor_BaseUrl, "SignIn");
		soapEnvelope.addMapping(KoloConstants.KolOthenticor_BaseUrl, "loginAttempt", new LoginAttempt().getClass());
		MarshalFloat marshalFloat = new MarshalFloat();
		marshalFloat.register(soapEnvelope);
		soapReq.addProperty("loginAttempt", loginAttempt);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call(KoloConstants.KolOthenticor_BaseUrl + "SignIn", soapEnvelope, headers);
			} else {
				httpTransport.call(KoloConstants.KolOthenticor_BaseUrl + "SignIn", soapEnvelope);
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
					SoapObject j = (SoapObject) obj;
					LoginAttempt resultVariable = new LoginAttempt(j);
					return resultVariable;
					
				}
			}
		} catch (Exception e) {
			if (eventHandler != null)
				eventHandler.Wsdl2CodeFinishedWithException(e);
			e.printStackTrace();
		}
		return null;
	}
	
	public LoginAttempt SignIn(LoginAttempt loginAttempt) {
		return SignIn(loginAttempt, null);
	}
	
	public void SignUpAsync(Registration registration) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		SignUpAsync(registration, null);
	}
	
	public void SignUpAsync(final Registration registration, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, Registration>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected Registration doInBackground(Void... params) {
				return SignUp(registration, headers);
			}
			
			@Override
			protected void onPostExecute(Registration result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("SignUp", result);
				}
			}
		}.execute();
	}
	
	public Registration SignUp(Registration registration, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject(KoloConstants.KolOthenticor_BaseUrl, "SignUp");
		soapEnvelope.addMapping(KoloConstants.KolOthenticor_BaseUrl, "registration", new Registration().getClass());
		soapReq.addProperty("registration", registration);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call(KoloConstants.KolOthenticor_BaseUrl + "SignUp", soapEnvelope, headers);
			} else {
				httpTransport.call(KoloConstants.KolOthenticor_BaseUrl + "SignUp", soapEnvelope);
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
					SoapObject j = (SoapObject) obj;
					Registration resultVariable = new Registration(j);
					return resultVariable;
					
				}
			}
		} catch (Exception e) {
			if (eventHandler != null)
				eventHandler.Wsdl2CodeFinishedWithException(e);
			e.printStackTrace();
		}
		return null;
	}
	
	public Registration SignUp(Registration registration) {
		return SignUp(registration, null);
	}
	
	public void SignUpVerificationAsync(Registration registration) throws Exception {
		if (this.eventHandler == null)
			throw new Exception("Async Methods Requires IWsdl2CodeEvents");
		SignUpVerificationAsync(registration, null);
	}
	
	public void SignUpVerificationAsync(final Registration registration, final List<HeaderProperty> headers) {
		
		new AsyncTask<Void, Void, Customer>() {
			@Override
			protected void onPreExecute() {
				eventHandler.Wsdl2CodeStartedRequest();
			}
			
			@Override
			protected Customer doInBackground(Void... params) {
				return SignUpVerification(registration, headers);
			}
			
			@Override
			protected void onPostExecute(Customer result) {
				eventHandler.Wsdl2CodeEndedRequest();
				if (result != null) {
					eventHandler.Wsdl2CodeFinished("SignUpVerification", result);
				}
			}
		}.execute();
	}
	
	public Customer SignUpVerification(Registration registration, List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject(KoloConstants.KolOthenticor_BaseUrl, "SignUpVerification");
		soapEnvelope.addMapping(KoloConstants.KolOthenticor_BaseUrl, "registration", new Registration().getClass());
		soapReq.addProperty("registration", registration);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			if (headers != null) {
				httpTransport.call(KoloConstants.KolOthenticor_BaseUrl + "SignUpVerification", soapEnvelope, headers);
			} else {
				httpTransport.call(KoloConstants.KolOthenticor_BaseUrl + "SignUpVerification", soapEnvelope);
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
					SoapObject j = (SoapObject) obj;
					Customer resultVariable = new Customer(j);
					return resultVariable;
					
				}
			}
		} catch (Exception e) {
			if (eventHandler != null)
				eventHandler.Wsdl2CodeFinishedWithException(e);
			e.printStackTrace();
		}
		return null;
	}
	
	public Customer SignUpVerification(Registration registration) {
		return SignUpVerification(registration, null);
	}
	
}
