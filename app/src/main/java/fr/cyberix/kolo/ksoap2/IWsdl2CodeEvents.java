package fr.cyberix.kolo.ksoap2;

//------------------------------------------------------------------------------
// <wsdl2code-generated>
//    This code was generated by http://www.wsdl2code.com version  2.6
//
// Date Of Creation: 6/2/2018 3:00:50 PM
//    Please dont change this code, regeneration will override your changes
//</wsdl2code-generated>
//
//------------------------------------------------------------------------------
//
//This source code was auto-generated by Wsdl2Code  Version
//

public interface IWsdl2CodeEvents {
	void Wsdl2CodeStartedRequest();
	
	void Wsdl2CodeFinished(String methodName, Object Data);
	
	void Wsdl2CodeFinishedWithException(Exception ex);
	
	void Wsdl2CodeEndedRequest();
}
