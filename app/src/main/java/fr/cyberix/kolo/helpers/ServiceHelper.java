package fr.cyberix.kolo.helpers;

import android.os.AsyncTask;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import fr.cyberix.kolo.interfaces.ServiceOperationInterface;
import fr.cyberix.kolo.model.CustomerBalanceHistoryList;
import fr.cyberix.kolo.model.EneoBillDetails;
import fr.cyberix.kolo.model.EneoBillDetailsList;
import fr.cyberix.kolo.model.KoloNotificationList;
import fr.cyberix.kolo.model.KoloWsObject;
import fr.cyberix.kolo.model.ParameterInfo;
import fr.cyberix.kolo.model.QrContact;
import fr.cyberix.kolo.model.TransferP2pDetails;
import fr.cyberix.kolo.model.TransferP2pDetailsList;
import fr.cyberix.kolo.model.entities.Bill;
import fr.cyberix.kolo.model.entities.Customer;
import fr.cyberix.kolo.model.entities.LoginAttempt;
import fr.cyberix.kolo.model.entities.Registration;
import fr.cyberix.kolo.model.entities.TopUp;
import fr.cyberix.kolo.model.entities.TransferGravity;
import fr.cyberix.kolo.model.entities.TransfertP2p;
import fr.cyberix.kolo.services.KolOPartVice;
import fr.cyberix.kolo.services.KolOSphere;
import fr.cyberix.kolo.services.KolOthenticor;
import fr.cyberix.kolo.services.MobileService;

public final class ServiceHelper {
	private final static int TimeOutDelay = 180000;
	private static KolOthenticor kolOthenticor;
	private static MobileService mobileService;
	private static KolOPartVice kolOPartVice;
	//region Fields
	private static KolOSphere kolOSphere;
	private static int customerId;
	//endregion
	
	static {
		kolOSphere = new KolOSphere(null, KoloConstants.KolOSphere_BaseUrl);
		kolOthenticor = new KolOthenticor(null, KoloConstants.KolOthenticor_BaseUrl);
		mobileService = new MobileService(null, KoloConstants.KolOMobileService_BaseUrl);
		kolOPartVice = new KolOPartVice(null, KoloConstants.KolOPartVice_BaseUrl);
		kolOSphere.timeOut = TimeOutDelay;
		kolOthenticor.timeOut = TimeOutDelay;
		mobileService.timeOut = TimeOutDelay;
		kolOPartVice.timeOut = TimeOutDelay;
	}
	
	public static void initialize() {
		customerId = ConfigHelper.getCustomerId();
	}
	
	//region Service methods to be executed in background
	public static KoloWsObject<QrContact> getContactByNumber(String number) {
		KoloWsObject<QrContact> result;
		MobileService service = ServiceHelper.getMobileService();
		String transResult = service.GetCustomerByIdCustomerAndNumber(0, number);
		Type fooType = new TypeToken<KoloWsObject<QrContact>>() {
		}.getType();
		result = SerializationHelper.fromKoloJson(transResult, fooType);
		return result;
	}
	
	public static KolOthenticor getOthenticorService() {
		if (kolOthenticor == null)
			kolOthenticor = new KolOthenticor(null, KoloConstants.KolOthenticor_BaseUrl);
		return kolOthenticor;
	}
	
	public static MobileService getMobileService() {
		if (mobileService == null)
			mobileService = new MobileService(null, KoloConstants.KolOMobileService_BaseUrl);
		return mobileService;
	}
	
	public static KolOPartVice getKolOPartVice() {
		if (kolOPartVice == null)
			kolOPartVice = new KolOPartVice(null, KoloConstants.KolOPartVice_BaseUrl);
		return kolOPartVice;
	}
	//endregion
	
	public static KoloWsObject<TransferP2pDetailsList> getP2pTransfers(TransferP2pDetailsList data) {
		KoloWsObject<TransferP2pDetailsList> result;
		KolOSphere service = ServiceHelper.getSphereService();
		String transResult = service.GetTransfertP2pList(customerId);
		Type fooType = new TypeToken<KoloWsObject<TransferP2pDetailsList>>() {
		}.getType();
		result = SerializationHelper.fromKoloJson(transResult, fooType);
		return result;
	}
	
	//region Getters
	public static KolOSphere getSphereService() {
		if (kolOSphere == null)
			kolOSphere = new KolOSphere(null, KoloConstants.KolOSphere_BaseUrl);
		return kolOSphere;
	}
	
	public static KoloWsObject<Bill> sendBill(Bill data) {
		KoloWsObject<Bill> result;
		KolOSphere service = ServiceHelper.getSphereService();
		String transJson = SerializationHelper.toKoloJson(data, Bill.class);
		String transResult = service.SendBill(transJson);
		Type fooType = new TypeToken<KoloWsObject<Bill>>() {
		}.getType();
		result = SerializationHelper.fromKoloJson(transResult, fooType);
		return result;
	}
	
	public static KoloWsObject<Bill> rejectBill(Bill data) {
		KoloWsObject<Bill> result;
		KolOSphere service = ServiceHelper.getSphereService();
		String transJson = SerializationHelper.toKoloJson(data, Bill.class);
		String transResult = service.RejectBill(transJson);
		Type fooType = new TypeToken<KoloWsObject<Bill>>() {
		}.getType();
		result = SerializationHelper.fromKoloJson(transResult, fooType);
		return result;
	}
	
	public static KoloWsObject<Bill> cancelBill(Bill data) {
		KoloWsObject<Bill> result;
		KolOSphere service = ServiceHelper.getSphereService();
		String transJson = SerializationHelper.toKoloJson(data, Bill.class);
		String transResult = service.CancelBill(transJson);
		Type fooType = new TypeToken<KoloWsObject<Bill>>() {
		}.getType();
		result = SerializationHelper.fromKoloJson(transResult, fooType);
		return result;
	}
	
	public static KoloWsObject<Bill> payBill(Bill data) {
		KoloWsObject<Bill> result;
		KolOSphere service = ServiceHelper.getSphereService();
		String transJson = SerializationHelper.toKoloJson(data, Bill.class);
		String transResult = service.PayBill(transJson);
		Type fooType = new TypeToken<KoloWsObject<Bill>>() {
		}.getType();
		result = SerializationHelper.fromKoloJson(transResult, fooType);
		return result;
	}
	
	public static KoloWsObject<EneoBillDetailsList> getEneoBill(String billNumber) {
		KoloWsObject<EneoBillDetailsList> result;
		KolOPartVice service = ServiceHelper.getKolOPartVice();
		String transResult = service.GetEneoBillByBillNumber(billNumber);
		Type fooType = new TypeToken<KoloWsObject<EneoBillDetailsList>>() {
		}.getType();
		result = SerializationHelper.fromKoloJson(transResult, fooType);
		return result;
	}
	
	public static KoloWsObject<EneoBillDetailsList> getEneoBills(String account) {
		KoloWsObject<EneoBillDetailsList> result;
		KolOPartVice service = ServiceHelper.getKolOPartVice();
		String transResult = service.GetEneoBillsByBillAccount(account);
		Type fooType = new TypeToken<KoloWsObject<EneoBillDetailsList>>() {
		}.getType();
		result = SerializationHelper.fromKoloJson(transResult, fooType);
		return result;
	}
	
	public static KoloWsObject<CustomerBalanceHistoryList> getHistory(Customer data) {
		KoloWsObject<CustomerBalanceHistoryList> result;
		MobileService service = ServiceHelper.getMobileService();
		String transResult = service.GetCustomerBalanceHistory(customerId);
		Type fooType = new TypeToken<KoloWsObject<CustomerBalanceHistoryList>>() {
		}.getType();
		result = SerializationHelper.fromKoloJson(transResult, fooType);
		return result;
	}
	
	public static KoloWsObject<KoloNotificationList> getNotifications(Customer data) {
		KoloWsObject<KoloNotificationList> result;
		MobileService service = ServiceHelper.getMobileService();
		String transResult = service.GetCustomerNotifications(customerId);
		Type fooType = new TypeToken<KoloWsObject<KoloNotificationList>>() {
		}.getType();
		result = SerializationHelper.fromKoloJson(transResult, fooType);
		return result;
	}
	
	public static KoloWsObject<ParameterInfo> getParameters(ParameterInfo data) {
		KoloWsObject<ParameterInfo> result;
		MobileService service = ServiceHelper.getMobileService();
		String transResult = service.GetParameters();
		Type fooType = new TypeToken<KoloWsObject<ParameterInfo>>() {
		}.getType();
		result = SerializationHelper.fromKoloJson(transResult, fooType);
		return result;
	}
	
	public static KoloWsObject<String> buyTopUp(TopUp data) {
		KoloWsObject<String> result;
		KolOPartVice service = ServiceHelper.getKolOPartVice();
		String transJson = SerializationHelper.toKoloJson(data, TopUp.class);
		String transResult = service.DoTopUp(transJson);
		Type fooType = new TypeToken<KoloWsObject<String>>() {
		}.getType();
		result = SerializationHelper.fromKoloJson(transResult, fooType);
		return result;
	}
	
	public static KoloWsObject<String> payEneoBill(EneoBillDetails data) {
		KoloWsObject<String> result;
		KolOPartVice service = ServiceHelper.getKolOPartVice();
		String customerIdString = String.valueOf(customerId);
		String transResult = service.DoPayEneoBill(data.getBillNumber(), customerIdString);
		Type fooType = new TypeToken<KoloWsObject<String>>() {
		}.getType();
		result = SerializationHelper.fromKoloJson(transResult, fooType);
		return result;
	}
	
	public static KoloWsObject<String> sendGravityTransfer(TransferGravity data) {
		KoloWsObject<String> result;
		KolOPartVice service = ServiceHelper.getKolOPartVice();
		String transJson = SerializationHelper.toKoloJson(data, TransferGravity.class);
		int senderId = data.getGravitySenderId();
		int receiverId = data.getGravityReceiverId();
		int amount = data.getAmount();
		int transResult = service.DoSendMad(data.getGravitySenderId(), data.getGravityReceiverId(), data.getAmount());
		Type fooType = new TypeToken<KoloWsObject<TransferGravity>>() {
		}.getType();
		result = SerializationHelper.fromKoloJson(String.valueOf(transResult), fooType);
		return result;
	}
	
	public static KoloWsObject<TransfertP2p> sendP2pTransfer(TransfertP2p data) {
		KoloWsObject<TransfertP2p> result;
		KolOSphere service = ServiceHelper.getSphereService();
		String transJson = SerializationHelper.toKoloJson(data, TransfertP2p.class);
		String transResult = service.DoTransfertA2A(transJson);
		Type fooType = new TypeToken<KoloWsObject<TransfertP2p>>() {
		}.getType();
		result = SerializationHelper.fromKoloJson(transResult, fooType);
		return result;
	}
	
	public static KoloWsObject<TransferP2pDetails> acceptP2pTransfer(TransferP2pDetails data) {
		KoloWsObject<TransferP2pDetails> result;
//		try {
		KolOSphere service = ServiceHelper.getSphereService();
		String transJson = SerializationHelper.toKoloJson(data, TransferP2pDetails.class);
		String transResult = service.DoAcceptTransfertA2A(transJson);
		Type fooType = new TypeToken<KoloWsObject<TransferP2pDetails>>() {
		}.getType();
		result = SerializationHelper.fromKoloJson(transResult, fooType);
//		} catch (Exception ex) {
//			result = new KoloWsObject<>();
//			result.setErrorMessage(ex.getMessage());
//			result.setSucces(false);
//		}
		return result;
	}
	
	public static KoloWsObject<TransferP2pDetails> confirmP2pTransfer(TransferP2pDetails data) {
		KoloWsObject<TransferP2pDetails> result;
//		try {
		KolOSphere service = ServiceHelper.getSphereService();
		String transJson = SerializationHelper.toKoloJson(data, TransferP2pDetails.class);
		String transResult = service.DoConfirmTransfertA2A(transJson);
		Type fooType = new TypeToken<KoloWsObject<TransferP2pDetails>>() {
		}.getType();
		result = SerializationHelper.fromKoloJson(transResult, fooType);
//		} catch (Exception ex) {
//			result = new KoloWsObject<>();
//			result.setErrorMessage(ex.getMessage());
//			result.setSucces(false);
//		}
		return result;
	}
	
	public static KoloWsObject<LoginAttempt> doLogin(LoginAttempt data) {
		KoloWsObject<LoginAttempt> result;
//		try {
		KolOthenticor service = ServiceHelper.getOthenticorService();
		String loginJson = SerializationHelper.toJson(data, LoginAttempt.class);
		String resultJson = service.DoLogin(loginJson);
		Type fooType = new TypeToken<KoloWsObject<LoginAttempt>>() {
		}.getType();
		result = SerializationHelper.fromKoloJson(resultJson, fooType);
//		} catch (Exception ex) {
//			result = new KoloWsObject<>();
//			result.setErrorMessage(ex.getMessage());
//			result.setSucces(false);
//		}
		return result;
	}
	
	public static KoloWsObject<Customer> confirmSignUp(Registration data) {
		KoloWsObject<Customer> result = null;
//		try {
		KolOthenticor service = ServiceHelper.getOthenticorService();
		String transJson = SerializationHelper.toKoloJson(data, Registration.class);
		String transResult = service.DoConfirmRegistration(transJson);
		Type fooType = new TypeToken<KoloWsObject<TransferP2pDetails>>() {
		}.getType();
		result = SerializationHelper.fromKoloJson(transResult, fooType);
//		} catch (Exception ex) {
//			result = new KoloWsObject<>();
//			result.setErrorMessage(ex.getMessage());
//			result.setSucces(false);
//		}
		return result;
	}
	
	public static KoloWsObject<Registration> signUp(Registration data) {
		KoloWsObject<Registration> result;
//		try {
		KolOthenticor service = ServiceHelper.getOthenticorService();
		String transJson = SerializationHelper.toKoloJson(data, Registration.class);
		String transResult = service.DoRegistration(transJson);
		Type fooType = new TypeToken<KoloWsObject<Registration>>() {
		}.getType();
		result = SerializationHelper.fromKoloJson(transResult, fooType);
//		} catch (Exception ex) {
//			result = new KoloWsObject<>();
//			result.setErrorMessage(ex.getMessage());
//			result.setSucces(false);
//		}
		return result;
	}
	//endregion
	
	//region BackGround executor
	public static <ParameterType, ResultType extends KoloWsObject> void doInBackground(ParameterType parameter, final ServiceOperationInterface<ParameterType,
			ResultType>
			serviceInterface) {
		serviceInterface.onPreExecute();
		new AsyncTask<ParameterType, Void, ResultType>() {
			
			@Override
			protected ResultType doInBackground(ParameterType... parameters) {
				ResultType result = null;
				try {
					ParameterType param = parameters[0];
					result = serviceInterface.doInBackground(param);
					return result;
				} catch (Exception ex) {
					KoloWsObject tmpResult = new KoloWsObject();
					tmpResult.setErrorMessage(ex.getMessage());
					tmpResult.setSucces(false);
					result = (ResultType) tmpResult;
				}
				return result;
			}
			
			@Override
			protected void onPostExecute(ResultType result) {
				super.onPostExecute(result);
				if (result == null) {
					serviceInterface.onOperationFailure("The operation could not complete. Please retry");
				}
				else if (result.getSucces() == false) {
					serviceInterface.onOperationFailure(result.getErrorMessage());
				}
				else if (result.getDataObject() == null) {
					serviceInterface.onOperationFailure(result.getErrorMessage());
				}

				else {
					serviceInterface.onOperationSuccess("", result);
				}
			}
		}.execute(parameter);
	}
	//endregion
}
