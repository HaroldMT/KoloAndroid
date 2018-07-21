package fr.cyberix.kolo.interfaces;

import fr.cyberix.kolo.model.KoloWsObject;

public interface ServiceOperationInterface<ParameterType, ResultType extends KoloWsObject> {
	void onOperationSuccess(String message, ResultType data);
	
	void onOperationFailure(String errorMessage);
	
	void onPreExecute();
	
	ResultType doInBackground(ParameterType parameter);
}