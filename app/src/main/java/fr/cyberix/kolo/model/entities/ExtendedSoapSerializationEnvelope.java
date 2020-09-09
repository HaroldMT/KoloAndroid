package fr.cyberix.kolo.model.entities;

//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 5.10.3.0
//
// Created by Quasar Development 
//
//----------------------------------------------------


import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.*;
import org.kxml2.io.KXmlParser;
import org.kxml2.kdom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Vector;
import java.io.StringReader;
import java.io.StringWriter;



//If you have a compilation error here then you have to add a reference to ExKsoap2.jar to your project (you can find it in Libs folder in the generated zip file)
public class ExtendedSoapSerializationEnvelope extends com.easywsdl.exksoap2.serialization.ExSoapSerializationEnvelope {
    static HashMap< java.lang.String,java.lang.Class> classNames = new HashMap< java.lang.String, java.lang.Class>();
    
    static {
        classNames.put("http://kolo.cyberix.fr/^^RefGender",RefGender.class);
        classNames.put("http://kolo.cyberix.fr/^^Person",Person.class);
        classNames.put("http://kolo.cyberix.fr/^^BusinessContact",BusinessContact.class);
        classNames.put("http://kolo.cyberix.fr/^^Business",Business.class);
        classNames.put("http://kolo.cyberix.fr/^^Customer",Customer.class);
        classNames.put("http://kolo.cyberix.fr/^^AccountOperationRequest",AccountOperationRequest.class);
        classNames.put("http://kolo.cyberix.fr/^^AccountOperation",AccountOperation.class);
        classNames.put("http://kolo.cyberix.fr/^^RefOperationStatu",RefOperationStatu.class);
        classNames.put("http://kolo.cyberix.fr/^^Partner",Partner.class);
        classNames.put("http://kolo.cyberix.fr/^^Commission",Commission.class);
        classNames.put("http://kolo.cyberix.fr/^^Fee",Fee.class);
        classNames.put("http://kolo.cyberix.fr/^^MasterUserHistory",MasterUserHistory.class);
        classNames.put("http://kolo.cyberix.fr/^^MasterUser",MasterUser.class);
        classNames.put("http://kolo.cyberix.fr/^^Currency",Currency.class);
        classNames.put("http://kolo.cyberix.fr/^^RefPartnerType",RefPartnerType.class);
        classNames.put("http://kolo.cyberix.fr/^^PartnerAddress",PartnerAddress.class);
        classNames.put("http://kolo.cyberix.fr/^^Adress",Adress.class);
        classNames.put("http://kolo.cyberix.fr/^^City",City.class);
        classNames.put("http://kolo.cyberix.fr/^^Country",Country.class);
        classNames.put("http://kolo.cyberix.fr/^^District",District.class);
        classNames.put("http://kolo.cyberix.fr/^^RefAddressType",RefAddressType.class);
        classNames.put("http://kolo.cyberix.fr/^^CustomerAddress",CustomerAddress.class);
        classNames.put("http://kolo.cyberix.fr/^^Provision",Provision.class);
        classNames.put("http://kolo.cyberix.fr/^^PartnerBalanceHistory",PartnerBalanceHistory.class);
        classNames.put("http://kolo.cyberix.fr/^^RefProvisionStatu",RefProvisionStatu.class);
        classNames.put("http://kolo.cyberix.fr/^^WholeSalerUser",WholeSalerUser.class);
        classNames.put("http://kolo.cyberix.fr/^^Activation",Activation.class);
        classNames.put("http://kolo.cyberix.fr/^^TimeSpan",TimeSpan.class);
        classNames.put("http://kolo.cyberix.fr/^^Registration",Registration.class);
        classNames.put("http://kolo.cyberix.fr/^^RefRegistrationStatu",RefRegistrationStatu.class);
        classNames.put("http://kolo.cyberix.fr/^^Wholesaler",Wholesaler.class);
        classNames.put("http://kolo.cyberix.fr/^^WholeSalerHistory",WholeSalerHistory.class);
        classNames.put("http://kolo.cyberix.fr/^^Reseller",Reseller.class);
        classNames.put("http://kolo.cyberix.fr/^^Transfert2Cash",Transfert2Cash.class);
        classNames.put("http://kolo.cyberix.fr/^^RefOperationType",RefOperationType.class);
        classNames.put("http://kolo.cyberix.fr/^^CustomerBalanceHistory",CustomerBalanceHistory.class);
        classNames.put("http://kolo.cyberix.fr/^^TransfertE2e",TransfertE2e.class);
        classNames.put("http://kolo.cyberix.fr/^^ExternalAccount",ExternalAccount.class);
        classNames.put("http://kolo.cyberix.fr/^^CreditCardInfo",CreditCardInfo.class);
        classNames.put("http://kolo.cyberix.fr/^^ExternalAccountHistory",ExternalAccountHistory.class);
        classNames.put("http://kolo.cyberix.fr/^^RefExternalAccountType",RefExternalAccountType.class);
        classNames.put("http://kolo.cyberix.fr/^^RefTransfertStatu",RefTransfertStatu.class);
        classNames.put("http://kolo.cyberix.fr/^^TransfertGroup",TransfertGroup.class);
        classNames.put("http://kolo.cyberix.fr/^^CustomerGroup",CustomerGroup.class);
        classNames.put("http://kolo.cyberix.fr/^^RefGroupType",RefGroupType.class);
        classNames.put("http://kolo.cyberix.fr/^^GroupImage",GroupImage.class);
        classNames.put("http://kolo.cyberix.fr/^^RecurringContribution",RecurringContribution.class);
        classNames.put("http://kolo.cyberix.fr/^^TransfertGroupScheduled",TransfertGroupScheduled.class);
        classNames.put("http://kolo.cyberix.fr/^^Bill",Bill.class);
        classNames.put("http://kolo.cyberix.fr/^^RefBillStatu",RefBillStatu.class);
        classNames.put("http://kolo.cyberix.fr/^^BillDetail",BillDetail.class);
        classNames.put("http://kolo.cyberix.fr/^^BillPayment",BillPayment.class);
        classNames.put("http://kolo.cyberix.fr/^^RefBillType",RefBillType.class);
        classNames.put("http://kolo.cyberix.fr/^^RefCustomerType",RefCustomerType.class);
        classNames.put("http://kolo.cyberix.fr/^^MobileDevice",MobileDevice.class);
        classNames.put("http://kolo.cyberix.fr/^^CustomerImage",CustomerImage.class);
        classNames.put("http://kolo.cyberix.fr/^^CustomerLogin",CustomerLogin.class);
        classNames.put("http://kolo.cyberix.fr/^^RefLoginStatu",RefLoginStatu.class);
        classNames.put("http://kolo.cyberix.fr/^^KoloUser",KoloUser.class);
        classNames.put("http://kolo.cyberix.fr/^^KoloGroup",KoloGroup.class);
        classNames.put("http://kolo.cyberix.fr/^^KoloPermission",KoloPermission.class);
        classNames.put("http://kolo.cyberix.fr/^^KoloSystemAction",KoloSystemAction.class);
        classNames.put("http://kolo.cyberix.fr/^^KoloSystemHistory",KoloSystemHistory.class);
        classNames.put("http://kolo.cyberix.fr/^^LoginAttempt",LoginAttempt.class);
        classNames.put("http://kolo.cyberix.fr/^^RefResult",RefResult.class);
        classNames.put("http://kolo.cyberix.fr/^^CustomerTag",CustomerTag.class);
        classNames.put("http://kolo.cyberix.fr/^^Tag",Tag.class);
        classNames.put("http://kolo.cyberix.fr/^^EneoBillPayment",EneoBillPayment.class);
        classNames.put("http://kolo.cyberix.fr/^^KoloNotification",KoloNotification.class);
        classNames.put("http://kolo.cyberix.fr/^^TopUp",TopUp.class);
        classNames.put("http://kolo.cyberix.fr/^^TransferGravity",TransferGravity.class);
        classNames.put("http://kolo.cyberix.fr/^^Transfert2CashDetail",Transfert2CashDetail.class);
        classNames.put("http://kolo.cyberix.fr/^^TransfertP2p",TransfertP2p.class);
        classNames.put("http://kolo.cyberix.fr/^^TransfertScheduled",TransfertScheduled.class);
        classNames.put("http://kolo.cyberix.fr/^^RefIndustryCategory",RefIndustryCategory.class);
        classNames.put("http://kolo.cyberix.fr/^^BusinessContactUpdateHistory",BusinessContactUpdateHistory.class);
        classNames.put("http://kolo.cyberix.fr/^^RefMaritalStatu",RefMaritalStatu.class);
        classNames.put("http://kolo.cyberix.fr/^^PersonRelationship",PersonRelationship.class);
        classNames.put("http://kolo.cyberix.fr/^^RefPersonRelationshipType",RefPersonRelationshipType.class);
        classNames.put("http://kolo.cyberix.fr/^^MyRefTypes",MyRefTypes.class);
        classNames.put("http://kolo.cyberix.fr/^^CustomerExternalAccount",CustomerExternalAccount.class);
        classNames.put("http://kolo.cyberix.fr/^^KoloMadCustomer",KoloMadCustomer.class);
        classNames.put("http://kolo.cyberix.fr/^^KoloMadDetails",KoloMadDetails.class);
        classNames.put("http://kolo.cyberix.fr/^^KoloWsObjectOfObject",KoloWsObjectOfObject.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfPerson",ArrayOfPerson.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfBusinessContact",ArrayOfBusinessContact.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfAccountOperationRequest",ArrayOfAccountOperationRequest.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfAccountOperation",ArrayOfAccountOperation.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfCommission",ArrayOfCommission.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfMasterUserHistory",ArrayOfMasterUserHistory.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfCustomer",ArrayOfCustomer.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfPartner",ArrayOfPartner.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfPartnerAddress",ArrayOfPartnerAddress.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfAdress",ArrayOfAdress.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfCity",ArrayOfCity.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfCustomerAddress",ArrayOfCustomerAddress.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfProvision",ArrayOfProvision.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfActivation",ArrayOfActivation.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfRegistration",ArrayOfRegistration.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfWholeSalerUser",ArrayOfWholeSalerUser.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfWholeSalerHistory",ArrayOfWholeSalerHistory.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfTransfert2Cash",ArrayOfTransfert2Cash.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfCustomerBalanceHistory",ArrayOfCustomerBalanceHistory.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfTransfertE2e",ArrayOfTransfertE2e.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfExternalAccount",ArrayOfExternalAccount.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfExternalAccountHistory",ArrayOfExternalAccountHistory.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfTransfertGroup",ArrayOfTransfertGroup.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfCustomerGroup",ArrayOfCustomerGroup.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfRecurringContribution",ArrayOfRecurringContribution.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfTransfertGroupScheduled",ArrayOfTransfertGroupScheduled.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfBill",ArrayOfBill.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfBillDetail",ArrayOfBillDetail.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfBillPayment",ArrayOfBillPayment.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfMobileDevice",ArrayOfMobileDevice.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfCustomerLogin",ArrayOfCustomerLogin.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfKoloUser",ArrayOfKoloUser.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfKoloPermission",ArrayOfKoloPermission.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfKoloSystemHistory",ArrayOfKoloSystemHistory.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfLoginAttempt",ArrayOfLoginAttempt.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfCustomerTag",ArrayOfCustomerTag.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfEneoBillPayment",ArrayOfEneoBillPayment.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfKoloNotification",ArrayOfKoloNotification.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfTopUp",ArrayOfTopUp.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfTransferGravity",ArrayOfTransferGravity.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfTransfert2CashDetail",ArrayOfTransfert2CashDetail.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfTransfertP2p",ArrayOfTransfertP2p.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfTransfertScheduled",ArrayOfTransfertScheduled.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfBusiness",ArrayOfBusiness.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfBusinessContactUpdateHistory",ArrayOfBusinessContactUpdateHistory.class);
        classNames.put("http://kolo.cyberix.fr/^^ArrayOfPersonRelationship",ArrayOfPersonRelationship.class);
    } 

    protected static final int QNAME_NAMESPACE = 0;
    private static final String TYPE_LABEL = "type";

    public static void setDateTimeConverter(DateTimeConverter converter)
    {
        if(converter==null)
        {
            dateTimeConverter = new StandardDateTimeConverter();
        }
        dateTimeConverter=converter;
    }

    public static DateTimeConverter getDateTimeConverter()
    {
        return dateTimeConverter;
    }

    private static DateTimeConverter dateTimeConverter = new StandardDateTimeConverter();

    public ExtendedSoapSerializationEnvelope() {
        this(SoapEnvelope.VER11);
    }

    public ExtendedSoapSerializationEnvelope(int soapVersion) {
        super(soapVersion);
        implicitTypes = true;
        setAddAdornments(false);
        new MarshalGuid().register(this);
        new MarshalFloat().register(this);
    }


    @Override
    protected void writeProperty(XmlSerializer writer, java.lang.Object obj, PropertyInfo type) throws IOException {
        //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
        //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
        if (obj == null || obj== SoapPrimitive.NullNilElement) {
            writer.attribute(xsi, version >= VER12 ? NIL_LABEL : NULL_LABEL, "true");
            return;
        }
        if(writeReferenceObject(writer,obj))
        {
            return;
        }
        java.lang.Object[] qName = getInfo(null, obj);
        if (!type.multiRef && qName[2] == null )
        {
            if (!implicitTypes || (obj.getClass() != type.type && !(obj instanceof Vector ) && type.type!=java.lang.String.class  )) {
                java.lang.String xmlName=Helper.getKeyByValue(classNames,obj.getClass());
                if(xmlName!=null) {
                    java.lang.String[] parts = xmlName.split("\\^\\^");
                    java.lang.String prefix = writer.getPrefix(parts[0], true);
                    writer.attribute(xsi, TYPE_LABEL, prefix + ":" + parts[1]);
                }
                else
                {
                    if(type.type instanceof String) {
                        java.lang.String xsdPrefix = writer.getPrefix(xsd, true);
                        java.lang.String myType = (java.lang.String) type.type;
                        java.lang.String[] parts = myType.split("\\^\\^");
                        if (parts.length == 2) {
                            xsdPrefix = writer.getPrefix(parts[0], true);
                            myType = parts[1];
                        }

                        writer.attribute(xsi, TYPE_LABEL, xsdPrefix + ":" + myType);
                    }
                    else
                    {
                        java.lang.String prefix = writer.getPrefix(type.namespace, true);
                        writer.attribute(xsi, TYPE_LABEL, prefix + ":" + obj.getClass().getSimpleName());
                    }

                }
            }
            //super.writeProperty(writer,obj,type);

            //!!!!! If you have a compilation error here then you are using old version of ksoap2 library. Please upgrade to the latest version.
            //!!!!! You can find a correct version in Lib folder from generated zip file!!!!!
            writeElement(writer, obj, type, qName[QNAME_MARSHAL]);
        }
        else {
            super.writeProperty(writer, obj, type);
        }
    }

    public SoapObject GetExceptionDetail(Element detailElement,java.lang.String exceptionElementNS,java.lang.String exceptionElementName)
    {
        int index=detailElement.indexOf(exceptionElementNS,exceptionElementName,0);
        if(index>-1)
        {
            Element errorElement=detailElement.getElement(index);
            return GetSoapObject(errorElement);
        }
        return null;
    }

    public SoapObject GetSoapObject(Element detailElement) {
        try{
            XmlSerializer xmlSerializer = XmlPullParserFactory.newInstance().newSerializer();
            StringWriter writer = new StringWriter();
            xmlSerializer.setOutput(writer);
            detailElement.write(xmlSerializer);
            xmlSerializer.flush();

            XmlPullParser xpp = new KXmlParser();
            xpp.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true);

            xpp.setInput(new StringReader(writer.toString()));
            xpp.nextTag();
            SoapObject soapObj = new SoapObject(detailElement.getNamespace(),detailElement.getName());
            readSerializable(xpp,soapObj);
            return soapObj;
        }
        catch (java.lang.Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    public java.lang.Object GetHeader(Element detailElement) {
        if(detailElement.getChildCount()>0 && detailElement.getText(0)!=null)
        {
            SoapPrimitive primitive = new SoapPrimitive(detailElement.getNamespace(),detailElement.getName(),detailElement.getText(0));
            return  primitive;
        }
    
        return GetSoapObject(detailElement);
    }
    private Object createObject(Object soap, Class cl) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Object obj=cl.newInstance();
        Method ctor = obj.getClass().getMethod("loadFromSoap",Object.class,ExtendedSoapSerializationEnvelope.class);
        ctor.invoke(obj,soap,this);
        return obj;
    }

    public java.lang.Object get(java.lang.Object soap,java.lang.Class cl,boolean typeFromClass)
    {
        if(soap==null)
        {
            return null;
        }
        try
        {
            if(typeFromClass)
            {
                return createObject(soap, cl);
            }
            java.lang.Object refAttr=getReference(soap);
            if (refAttr != null)
            {
                return refAttr;
            }
            else
            {
                if(soap instanceof SoapObject)
                {
                    if(cl ==SoapObject.class)
                    {
                        return soap;
                    }
                    java.lang.String key=String.format("%s^^%s",((SoapObject)soap).getNamespace(),((SoapObject)soap).getName());
                    if(classNames.containsKey(key))
                    {
                        cl=classNames.get(key);
                    }
                }
                return createObject(soap, cl);
            }
        }
        catch (java.lang.Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }


    public java.lang.Object getSpecificType(java.lang.Object obj)
    {
        if(obj==null)
        {
            return null;
        }
        if(obj instanceof SoapObject)
        {
            SoapObject soapObject=(SoapObject)obj;
            java.lang.String key=soapObject.getNamespace()+"^^"+soapObject.getName();
            if(classNames.containsKey(key))
            {
                java.lang.Class cl=classNames.get(key);
                try
                {
                    return createObject(soapObject, cl);
                } 
                catch (java.lang.Exception e)
                {
                    e.printStackTrace();
                }
            }
        }

        return obj;
    }

    public static java.lang.Object getXSDType(java.lang.Object param)
    {
        if(param==null)
        {
            return null;
        }
        java.lang.Class obj=param.getClass();
        if(obj.equals(java.lang.String.class))
        {
            return "string";
        }
        if(obj.equals(int.class) || obj.equals(java.lang.Integer.class))
        {
            return "int";
        }
        if(obj.equals(float.class) || obj.equals(java.lang.Float.class))
        {
            return "float";
        }
        if(obj.equals(double.class) || obj.equals(java.lang.Double.class))
        {
            return "double";
        }
        if(obj.equals(java.math.BigDecimal.class))
        {
            return "decimal";
        }
        if(obj.equals(short.class) || obj.equals(java.lang.Short.class))
        {
            return "short";
        }
        if(obj.equals(long.class) || obj.equals(java.lang.Long.class))
        {
            return "long";
        }
        if(obj.equals(boolean.class) || obj.equals(java.lang.Boolean.class))
        {
            return "boolean";
        }
        java.lang.String xmlName=Helper.getKeyByValue(classNames,obj);
        if(xmlName==null)
        {
            return obj;
        }
        return xmlName;
    }} 
