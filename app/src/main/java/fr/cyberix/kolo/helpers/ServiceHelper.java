///*
// * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
// * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
// * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
// * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
// * Vestibulum commodo. Ut rhoncus gravida arcu.
// */
//
//package fr.cyberix.kolo.helpers;
//
//import android.support.annotation.Nullable;
//import android.util.Log;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import fr.cyberix.kolo.interfaces.ForeasClient;
//import fr.cyberix.kolo.model.entities.City;
//import fr.cyberix.kolo.model.entities.Currency;
//import fr.cyberix.kolo.model.entities.Customer;
//import fr.cyberix.kolo.model.entities.LoginAttempt;
//import fr.cyberix.kolo.model.entities.MobileDevice;
//import fr.cyberix.kolo.model.entities.RefAddressType;
//import fr.cyberix.kolo.model.entities.RefBillStatus;
//import fr.cyberix.kolo.model.entities.RefBillType;
//import fr.cyberix.kolo.model.entities.RefCustomerType;
//import fr.cyberix.kolo.model.entities.RefExternalAccountType;
//import fr.cyberix.kolo.model.entities.RefGender;
//import fr.cyberix.kolo.model.entities.RefGroupType;
//import fr.cyberix.kolo.model.entities.RefIndustryCategory;
//import fr.cyberix.kolo.model.entities.RefLoginStatus;
//import fr.cyberix.kolo.model.entities.RefMaritalStatus;
//import fr.cyberix.kolo.model.entities.RefOperationStatus;
//import fr.cyberix.kolo.model.entities.RefOperationType;
//import fr.cyberix.kolo.model.entities.RefPartnerType;
//import fr.cyberix.kolo.model.entities.RefPersonRelationshipType;
//import fr.cyberix.kolo.model.entities.RefProvisionStatus;
//import fr.cyberix.kolo.model.entities.RefRegistrationStatus;
//import fr.cyberix.kolo.model.entities.RefResult;
//import fr.cyberix.kolo.model.entities.RefTransfertStatus;
//import fr.cyberix.kolo.model.entities.Registration;
//import fr.cyberix.kolo.model.koloResponse.CurrencyResponse;
//import okhttp3.OkHttpClient;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class ServiceHelper {
//
//    public static ForeasClient service;
//    public static Retrofit retrofit;
//
//    public static ForeasClient getService() {
//        Gson gson = new GsonBuilder()
//                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
//                .create();
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .connectTimeout(1, TimeUnit.MINUTES)
//                .writeTimeout(1, TimeUnit.MINUTES)
//                .readTimeout(1, TimeUnit.MINUTES)
//                .build();
//        if (retrofit == null) retrofit = new Retrofit.Builder()
//                .baseUrl(ForeasConstants.BaseUrl)
//                .client(okHttpClient)
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .build();
//        service = retrofit.create(ForeasClient.class);
//        return service;
//    }
//    public static void refreshParamsFromServer() {
//        try {
//            ConfigHelper.getParameterInfo().setCurrencyList(getCurrencies());
////            ConfigHelper.getParameterInfo().setRefAddressTypes(getRefAddressTypes());
////            ConfigHelper.getParameterInfo().setRefBillStatus(getRefBillStatus());
////            ConfigHelper.getParameterInfo().setRefBillTypes(getRefBillTypes());
////            ConfigHelper.getParameterInfo().setRefCustomerTypes(getRefCustomerTypes());
////            ConfigHelper.getParameterInfo().setRefExternalAccountTypes(getRefExternalAccountTypes());
////            ConfigHelper.getParameterInfo().setRefGenders(getRefGenders());
////            ConfigHelper.getParameterInfo().setRefGroupTypes(getRefGroupTypes());
////            ConfigHelper.getParameterInfo().setRefIndustryCategorys(getRefIndustryCategories());
////            ConfigHelper.getParameterInfo().setRefLoginStatus(getRefLoginStatus());
////            ConfigHelper.getParameterInfo().setRefMaritalStatus(getRefMaritalStatus());
////            ConfigHelper.getParameterInfo().setRefOperationStatus(getRefOperationStatus());
////            ConfigHelper.getParameterInfo().setRefOperationTypes(getRefOperationTypes());
////            ConfigHelper.getParameterInfo().setRefPartnerTypes(getRefPartnerTypes());
////            ConfigHelper.getParameterInfo().setRefPersonRelationshipTypes(getRefPersonRelationshipTypes());
////            ConfigHelper.getParameterInfo().setRefProvisionStatus(getRefProvisionStatus());
////            ConfigHelper.getParameterInfo().setRefRegistrationStatus(getRefRegistrationStatus());
////            ConfigHelper.getParameterInfo().setRefResults(getRefResults());
////            ConfigHelper.getParameterInfo().setRefTransfertStatus(getRefTransfertStatus());
//            ConfigHelper.saveParameters();
//        } catch (Exception e) {
//            Log.d("getCurrencies", "Error: " + e.getMessage());
//            e.printStackTrace();
//        }
////        ConfigHelper.saveParameters();
//    }
//
//    @Nullable
//    public static List<Currency> getCurrencies() {
//        ForeasClient koloClient = ServiceHelper.getService();
//        List<Currency> itemList = null;
////        try {
//            Call<CurrencyResponse> itemResponseCall = koloClient.getCurrencies("");
////            Response response = itemResponseCall.execute();
////            CurrencyResponse itemResponse = (CurrencyResponse)response.body();
////            itemList = itemResponse.values;
//            itemResponseCall.enqueue(new Callback<CurrencyResponse>() {
//                @Override
//                public void onResponse(Call<CurrencyResponse> call, Response<CurrencyResponse> response) {
//                    CurrencyResponse currencyResponse = response.body();
//                    List<Currency> currencyList = currencyResponse.values;
//                    ConfigHelper.getParameterInfo().setCurrencyList(currencyList);
//                    ConfigHelper.saveParameters();
//                }
//                @Override
//                public void onFailure(Call<CurrencyResponse> call, Throwable t) {
//                    Log.d("getCurrencies", "Error: " + t.getMessage());
//                }
//            });
////        } catch (IOException e) {
////            Log.d("getCurrencies", "Error: " + e.getMessage());
////        }
//        return itemList;
//    }
//
//    @Nullable
//    public static List<RefAddressType> getRefAddressTypes() {
//        try {
//            return service.getRefAddressTypes("").execute().body().values;
//        } catch (IOException e) {
//            Log.d("getRefAddressTypes", "Error: " + e.getMessage());
//            return null;
//        }
//    }
//
//    @Nullable
//    public static List<RefBillStatu> getRefBillStatus() {
//        try {
//            return service.getRefBillStatus("").execute().body().values;
//        } catch (IOException e) {
//            Log.d("getRefBillStatus", "Error: " + e.getMessage());
//            return null;
//        }
//    }
//
//    @Nullable
//    public static List<RefBillType> getRefBillTypes() {
//        try {
//            return service.getRefBillTypes("").execute().body().values;
//        } catch (IOException e) {
//            Log.d("getRefBillTypes", "Error: " + e.getMessage());
//            return null;
//        }
//    }
//
//    @Nullable
//    public static List<RefCustomerType> getRefCustomerTypes() {
//        try {
//            return service.getRefCustomerTypes("").execute().body().values;
//        } catch (IOException e) {
//            Log.d("getRefCustomerTypes", "Error: " + e.getMessage());
//            return null;
//        }
//    }
//
//    @Nullable
//    public static List<RefExternalAccountType> getRefExternalAccountTypes() {
//        try {
//            return service.getRefExternalAccountTypes("").execute().body().values;
//        } catch (IOException e) {
//            Log.d("getRefExternalAcountTyp", "Error: " + e.getMessage());
//            return null;
//        }
//    }
//
//    @Nullable
//    public static List<RefGender> getRefGenders() {
//        try {
//            return service.getRefGenders("").execute().body().values;
//        } catch (IOException e) {
//            Log.d("getRefGenders", "Error: " + e.getMessage());
//            return null;
//        }
//    }
//
//    @Nullable
//    public static List<RefGroupType> getRefGroupTypes() {
//        try {
//            return service.getRefGroupTypes("").execute().body().values;
//        } catch (IOException e) {
//            Log.d("getRefGroupTypes", "Error: " + e.getMessage());
//            return null;
//        }
//    }
//
//    @Nullable
//    public static List<RefIndustryCategory> getRefIndustryCategories() {
//        try {
//            return service.getRefIndustryCategories("").execute().body().values;
//        } catch (IOException e) {
//            Log.d("getRefIndustryCategoriy", "Error: " + e.getMessage());
//            return null;
//        }
//    }
//
//    @Nullable
//    public static List<RefLoginStatu> getRefLoginStatus() {
//        try {
//            return service.getRefLoginStatus("").execute().body().values;
//        } catch (IOException e) {
//            Log.d("getRefLoginStatus", "Error: " + e.getMessage());
//            return null;
//        }
//    }
//
//    @Nullable
//    public static List<RefMaritalStatu> getRefMaritalStatus() {
//        try {
//            return service.getRefMaritalStatus("").execute().body().values;
//        } catch (IOException e) {
//            Log.d("getRefMaritalStatus", "Error: " + e.getMessage());
//            return null;
//        }
//    }
//
//    @Nullable
//    public static List<RefOperationStatu> getRefOperationStatus() {
//        try {
//            return service.getRefOperationStatus("").execute().body().values;
//        } catch (IOException e) {
//            Log.d("getRefOperationStatus", "Error: " + e.getMessage());
//            return null;
//        }
//    }
//
//    @Nullable
//    public static List<RefOperationType> getRefOperationTypes() {
//        try {
//            return service.getRefOperationTypes("").execute().body().values;
//        } catch (IOException e) {
//            Log.d("getRefOperationTypes", "Error: " + e.getMessage());
//            return null;
//        }
//    }
//
//    @Nullable
//    public static List<RefPartnerType> getRefPartnerTypes() {
//        try {
//            return service.getRefPartnerTypes("").execute().body().values;
//        } catch (IOException e) {
//            Log.d("getRefPartnerTypes", "Error: " + e.getMessage());
//            return null;
//        }
//    }
//
//    @Nullable
//    public static List<RefPersonRelationshipType> getRefPersonRelationshipTypes() {
//        try {
//            return service.getRefPersonRelationshipTypes("").execute().body().values;
//        } catch (IOException e) {
//            Log.d("getRefProvisionStatus", "Error: " + e.getMessage());
//            return null;
//        }
//    }
//
//    @Nullable
//    public static List<RefProvisionStatu> getRefProvisionStatus() {
//        try {
//            return service.getRefProvisionStatus("").execute().body().values;
//        } catch (IOException e) {
//            Log.d("getRefProvisionStatu", "Error: " + e.getMessage());
//            return null;
//        }
//    }
//
//    @Nullable
//    public static List<RefRegistrationStatu> getRefRegistrationStatus() {
//        try {
//            return service.getRefRegistrationStatus("").execute().body().values;
//        } catch (IOException e) {
//            Log.d("getRefRegistrationStatu", "Error: " + e.getMessage());
//            return null;
//        }
//    }
//
//    @Nullable
//    public static List<RefResult> getRefResults() {
//        try {
//            return service.getRefResults("").execute().body().values;
//        } catch (IOException e) {
//            Log.d("getRefResults", "Error: " + e.getMessage());
//            return null;
//        }
//    }
//
//    @Nullable
//    public static List<RefTransfertStatu> getRefTransfertStatus() {
//        try {
//            return service.getRefTransfertStatus("").execute().body().values;
//        } catch (IOException e) {
//            Log.d("getRefTransfertStatus", "Error: " + e.getMessage());
//            return null;
//        }
//    }
//
//    @Nullable
//    public static List<City> getCity(String cityCode) {
//        try {
//            return service.getCity(cityCode).execute().body().values;
//        } catch (IOException e) {
//            Log.d("getCity", "Error: " + e.getMessage());
//            return null;
//        }
//    }
//
//    @Nullable
//    public static Registration signUp(Registration registration) {
//        try {
//            ForeasClient koloClient = ServiceHelper.getService();
//            Response<Registration> registrationResponse = koloClient.signUp(registration)
//                    .execute();
//            if (registrationResponse != null) {
//                Object objReg = registrationResponse.body();
//                if (objReg instanceof Registration) {
//                    Registration result = (Registration) objReg;
//                    return result;
//                }
//            }
//        } catch (Exception e) {
//            Log.e("signUp", e.getMessage());
//        }
//        return null;
//    }
//
//    @Nullable
//    public static RefResult signIn(LoginAttempt loginAttempt) {
//        try {
//            ForeasClient koloClient = ServiceHelper.getService();
//            Response<RefResult> registrationResponse = koloClient.signIn(loginAttempt)
//                    .execute();
//            if (registrationResponse != null) {
//                Object objReg = registrationResponse.body();
//                if (objReg instanceof RefResult) {
//                    RefResult result = (RefResult) objReg;
//                    return result;
//                }
//            }
//        } catch (IOException e) {
//            Log.e("signIn", e.getMessage());
//        }
//        return null;
//    }
//
//    @Nullable
//    public static Customer confirmRegistration(Registration registration) {
//        try {
//            ForeasClient koloClient = ServiceHelper.getService();
//            Response<Customer> registrationResponse = koloClient.confirmRegistration
//                    (registration).execute();
//            if (registrationResponse != null) {
//                Object objReg = registrationResponse.body();
//                if (objReg instanceof Customer) {
//                    Customer result = (Customer) objReg;
//                    return result;
//                }
//            }
//        } catch (IOException e) {
//            Log.e("confirmRegistration", e.getMessage());
//        }
//        return null;
//    }
//
//    @Nullable
//    public static Customer getCustomer(int idCustomer) {
//        try {
//            ForeasClient koloClient = ServiceHelper.getService();
//            Response<Customer> customerResponse = koloClient.getCustomerById(idCustomer)
//                    .execute();
//            if (customerResponse != null) {
//                Object objReg = customerResponse.body();
//                if (objReg instanceof Customer) {
//                    Customer result = (Customer) objReg;
//                    return result;
//                }
//            }
//        } catch (IOException e) {
//            Log.e("getCustomer", e.getMessage());
//        }
//        return null;
//    }
//
//    @Nullable
//    public static Customer getCustomer(MobileDevice mobileDevice) {
//        try {
//            ForeasClient koloClient = ServiceHelper.getService();
//            Response<Customer> customerResponse = koloClient.getCustomerByPhone(mobileDevice
//                    .getLineNumber()).execute();
//            if (customerResponse != null) {
//                Object objReg = customerResponse.body();
//                if (objReg instanceof Customer) {
//                    Customer result = (Customer) objReg;
//                    return result;
//                }
//            }
//        } catch (IOException e) {
//            Log.e("getCustomer", e.getMessage());
//        }
//        return null;
//    }
//
//    @Nullable
//    public static int getCustomerBalance(int idCustomer) {
//        try {
//            ForeasClient koloClient = ServiceHelper.getService();
//            Response<String> customerResponse = koloClient.getCustomerBalance(idCustomer)
//                    .execute();
//            if (customerResponse != null) {
//                Object objReg = customerResponse.body();
//                String result = objReg.toString();
//                int balance = Integer.parseInt(result);
//                return balance;
//            }
//        } catch (IOException e) {
//            Log.e("getCustomer", e.getMessage());
//        }
//        return -1;
//    }
//}