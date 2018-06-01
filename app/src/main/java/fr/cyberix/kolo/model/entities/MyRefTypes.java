package fr.cyberix.kolo.model.entities;

//------------------------------------------------------------------------------
// <wsdl2code-generated>
//    This code was generated by http://www.wsdl2code.com version  2.6
//
// Date Of Creation: 6/1/2018 1:24:28 PM
//    Please dont change this code, regeneration will override your changes
//</wsdl2code-generated>
//
//------------------------------------------------------------------------------
//
//This source code was auto-generated by Wsdl2Code  Version
//

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;

import java.util.Hashtable;

public class MyRefTypes implements KvmSerializable {

    private AccountOperation a1;
    private Currency a10;
    private Customer a11;
    private CustomerAddress a12;
    private CustomerBalanceHistory a13;
    private CustomerExternalAccount a14;
    private CustomerGroup a15;
    private CustomerImage a16;
    private CustomerLogin a17;
    private CustomerTag a18;
    private District a19;
    private AccountOperationRequest a2;
    private ExternalAccount a20;
    private ExternalAccountHistory a21;
    private KoloNotification a22;
    private GroupImage a23;
    private LoginAttempt a24;
    private MobileDevice a25;
    private Partner a26;
    private PartnerAddress a27;
    private PartnerBalanceHistory a28;
    private Person a29;
    private Adresse a3;
    private PersonRelationship a30;
    private Provision a31;
    private RecurringContribution a32;
    private RefAddressType a33;
    private RefBillStatu a34;
    private RefBillType a35;
    private RefCustomerType a36;
    private RefExternalAccountType a37;
    private RefGender a38;
    private RefGroupType a39;
    private Bill a4;
    private RefIndustryCategory a40;
    private RefLoginStatu a41;
    private RefMaritalStatu a42;
    private RefOperationStatu a43;
    private RefOperationType a44;
    private RefPartnerType a45;
    private RefPersonRelationshipType a46;
    private RefProvisionStatu a47;
    private RefRegistrationStatu a48;
    private RefResult a49;
    private BillPayment a5;
    private RefTransfertStatu a50;
    private Registration a51;
    private Reseller a52;
    private Tag a53;
    private Transfert2Cash a54;
    private Transfert2CashDetails a55;
    private TransfertE2e a56;
    private TransfertGroup a57;
    private TransfertGroupScheduled a58;
    private TransfertP2p a59;
    private Business a6;
    private TransfertScheduled a60;
    private KoloUser a61;
    private Wholesaler a62;
    private BusinessContact a7;
    private City a8;
    private Country a9;

    public MyRefTypes() {
    }

    public MyRefTypes(SoapObject soapObject) {
        if (soapObject == null)
            return;
        if (soapObject.hasProperty("a1")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a1");
            setA1(new AccountOperation(j));

        }
        if (soapObject.hasProperty("a10")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a10");
            setA10(new Currency(j));

        }
        if (soapObject.hasProperty("a11")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a11");
            setA11(new Customer(j));

        }
        if (soapObject.hasProperty("a12")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a12");
            setA12(new CustomerAddress(j));

        }
        if (soapObject.hasProperty("a13")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a13");
            setA13(new CustomerBalanceHistory(j));

        }
        if (soapObject.hasProperty("a14")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a14");
            setA14(new CustomerExternalAccount(j));

        }
        if (soapObject.hasProperty("a15")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a15");
            setA15(new CustomerGroup(j));

        }
        if (soapObject.hasProperty("a16")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a16");
            setA16(new CustomerImage(j));

        }
        if (soapObject.hasProperty("a17")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a17");
            setA17(new CustomerLogin(j));

        }
        if (soapObject.hasProperty("a18")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a18");
            setA18(new CustomerTag(j));

        }
        if (soapObject.hasProperty("a19")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a19");
            setA19(new District(j));

        }
        if (soapObject.hasProperty("a2")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a2");
            setA2(new AccountOperationRequest(j));

        }
        if (soapObject.hasProperty("a20")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a20");
            setA20(new ExternalAccount(j));

        }
        if (soapObject.hasProperty("a21")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a21");
            setA21(new ExternalAccountHistory(j));

        }
        if (soapObject.hasProperty("a22")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a22");
            setA22(new KoloNotification(j));

        }
        if (soapObject.hasProperty("a23")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a23");
            setA23(new GroupImage(j));

        }
        if (soapObject.hasProperty("a24")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a24");
            setA24(new LoginAttempt(j));

        }
        if (soapObject.hasProperty("a25")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a25");
            setA25(new MobileDevice(j));

        }
        if (soapObject.hasProperty("a26")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a26");
            setA26(new Partner(j));

        }
        if (soapObject.hasProperty("a27")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a27");
            setA27(new PartnerAddress(j));

        }
        if (soapObject.hasProperty("a28")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a28");
            setA28(new PartnerBalanceHistory(j));

        }
        if (soapObject.hasProperty("a29")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a29");
            setA29(new Person(j));

        }
        if (soapObject.hasProperty("a3")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a3");
            setA3(new Adresse(j));

        }
        if (soapObject.hasProperty("a30")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a30");
            setA30(new PersonRelationship(j));

        }
        if (soapObject.hasProperty("a31")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a31");
            setA31(new Provision(j));

        }
        if (soapObject.hasProperty("a32")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a32");
            setA32(new RecurringContribution(j));

        }
        if (soapObject.hasProperty("a33")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a33");
            setA33(new RefAddressType(j));

        }
        if (soapObject.hasProperty("a34")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a34");
            setA34(new RefBillStatu(j));

        }
        if (soapObject.hasProperty("a35")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a35");
            setA35(new RefBillType(j));

        }
        if (soapObject.hasProperty("a36")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a36");
            setA36(new RefCustomerType(j));

        }
        if (soapObject.hasProperty("a37")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a37");
            setA37(new RefExternalAccountType(j));

        }
        if (soapObject.hasProperty("a38")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a38");
            setA38(new RefGender(j));

        }
        if (soapObject.hasProperty("a39")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a39");
            setA39(new RefGroupType(j));

        }
        if (soapObject.hasProperty("a4")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a4");
            setA4(new Bill(j));

        }
        if (soapObject.hasProperty("a40")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a40");
            setA40(new RefIndustryCategory(j));

        }
        if (soapObject.hasProperty("a41")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a41");
            setA41(new RefLoginStatu(j));

        }
        if (soapObject.hasProperty("a42")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a42");
            setA42(new RefMaritalStatu(j));

        }
        if (soapObject.hasProperty("a43")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a43");
            setA43(new RefOperationStatu(j));

        }
        if (soapObject.hasProperty("a44")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a44");
            setA44(new RefOperationType(j));

        }
        if (soapObject.hasProperty("a45")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a45");
            setA45(new RefPartnerType(j));

        }
        if (soapObject.hasProperty("a46")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a46");
            setA46(new RefPersonRelationshipType(j));

        }
        if (soapObject.hasProperty("a47")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a47");
            setA47(new RefProvisionStatu(j));

        }
        if (soapObject.hasProperty("a48")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a48");
            setA48(new RefRegistrationStatu(j));

        }
        if (soapObject.hasProperty("a49")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a49");
            setA49(new RefResult(j));

        }
        if (soapObject.hasProperty("a5")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a5");
            setA5(new BillPayment(j));

        }
        if (soapObject.hasProperty("a50")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a50");
            setA50(new RefTransfertStatu(j));

        }
        if (soapObject.hasProperty("a51")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a51");
            setA51(new Registration(j));

        }
        if (soapObject.hasProperty("a52")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a52");
            setA52(new Reseller(j));

        }
        if (soapObject.hasProperty("a53")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a53");
            setA53(new Tag(j));

        }
        if (soapObject.hasProperty("a54")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a54");
            setA54(new Transfert2Cash(j));

        }
        if (soapObject.hasProperty("a55")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a55");
            setA55(new Transfert2CashDetails(j));

        }
        if (soapObject.hasProperty("a56")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a56");
            setA56(new TransfertE2e(j));

        }
        if (soapObject.hasProperty("a57")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a57");
            setA57(new TransfertGroup(j));

        }
        if (soapObject.hasProperty("a58")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a58");
            setA58(new TransfertGroupScheduled(j));

        }
        if (soapObject.hasProperty("a59")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a59");
            setA59(new TransfertP2p(j));

        }
        if (soapObject.hasProperty("a6")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a6");
            setA6(new Business(j));

        }
        if (soapObject.hasProperty("a60")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a60");
            setA60(new TransfertScheduled(j));

        }
        if (soapObject.hasProperty("a61")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a61");
            setA61(new KoloUser(j));

        }
        if (soapObject.hasProperty("a62")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a62");
            setA62(new Wholesaler(j));

        }
        if (soapObject.hasProperty("a7")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a7");
            setA7(new BusinessContact(j));

        }
        if (soapObject.hasProperty("a8")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a8");
            setA8(new City(j));

        }
        if (soapObject.hasProperty("a9")) {
            SoapObject j = (SoapObject) soapObject.getProperty("a9");
            setA9(new Country(j));

        }
    }

    @Override
    public Object getProperty(int arg0) {
        switch (arg0) {
            case 0:
                return getA1();
            case 1:
                return getA10();
            case 2:
                return getA11();
            case 3:
                return getA12();
            case 4:
                return getA13();
            case 5:
                return getA14();
            case 6:
                return getA15();
            case 7:
                return getA16();
            case 8:
                return getA17();
            case 9:
                return getA18();
            case 10:
                return getA19();
            case 11:
                return getA2();
            case 12:
                return getA20();
            case 13:
                return getA21();
            case 14:
                return getA22();
            case 15:
                return getA23();
            case 16:
                return getA24();
            case 17:
                return getA25();
            case 18:
                return getA26();
            case 19:
                return getA27();
            case 20:
                return getA28();
            case 21:
                return getA29();
            case 22:
                return getA3();
            case 23:
                return getA30();
            case 24:
                return getA31();
            case 25:
                return getA32();
            case 26:
                return getA33();
            case 27:
                return getA34();
            case 28:
                return getA35();
            case 29:
                return getA36();
            case 30:
                return getA37();
            case 31:
                return getA38();
            case 32:
                return getA39();
            case 33:
                return getA4();
            case 34:
                return getA40();
            case 35:
                return getA41();
            case 36:
                return getA42();
            case 37:
                return getA43();
            case 38:
                return getA44();
            case 39:
                return getA45();
            case 40:
                return getA46();
            case 41:
                return getA47();
            case 42:
                return getA48();
            case 43:
                return getA49();
            case 44:
                return getA5();
            case 45:
                return getA50();
            case 46:
                return getA51();
            case 47:
                return getA52();
            case 48:
                return getA53();
            case 49:
                return getA54();
            case 50:
                return getA55();
            case 51:
                return getA56();
            case 52:
                return getA57();
            case 53:
                return getA58();
            case 54:
                return getA59();
            case 55:
                return getA6();
            case 56:
                return getA60();
            case 57:
                return getA61();
            case 58:
                return getA62();
            case 59:
                return getA7();
            case 60:
                return getA8();
            case 61:
                return getA9();
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 62;
    }

    @Override
    public void setProperty(int arg0, Object arg1) {
    }

    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        switch (index) {
            case 0:
                info.type = AccountOperation.class;
                info.name = "a1";
                break;
            case 1:
                info.type = Currency.class;
                info.name = "a10";
                break;
            case 2:
                info.type = Customer.class;
                info.name = "a11";
                break;
            case 3:
                info.type = CustomerAddress.class;
                info.name = "a12";
                break;
            case 4:
                info.type = CustomerBalanceHistory.class;
                info.name = "a13";
                break;
            case 5:
                info.type = CustomerExternalAccount.class;
                info.name = "a14";
                break;
            case 6:
                info.type = CustomerGroup.class;
                info.name = "a15";
                break;
            case 7:
                info.type = CustomerImage.class;
                info.name = "a16";
                break;
            case 8:
                info.type = CustomerLogin.class;
                info.name = "a17";
                break;
            case 9:
                info.type = CustomerTag.class;
                info.name = "a18";
                break;
            case 10:
                info.type = District.class;
                info.name = "a19";
                break;
            case 11:
                info.type = AccountOperationRequest.class;
                info.name = "a2";
                break;
            case 12:
                info.type = ExternalAccount.class;
                info.name = "a20";
                break;
            case 13:
                info.type = ExternalAccountHistory.class;
                info.name = "a21";
                break;
            case 14:
                info.type = KoloNotification.class;
                info.name = "a22";
                break;
            case 15:
                info.type = GroupImage.class;
                info.name = "a23";
                break;
            case 16:
                info.type = LoginAttempt.class;
                info.name = "a24";
                break;
            case 17:
                info.type = MobileDevice.class;
                info.name = "a25";
                break;
            case 18:
                info.type = Partner.class;
                info.name = "a26";
                break;
            case 19:
                info.type = PartnerAddress.class;
                info.name = "a27";
                break;
            case 20:
                info.type = PartnerBalanceHistory.class;
                info.name = "a28";
                break;
            case 21:
                info.type = Person.class;
                info.name = "a29";
                break;
            case 22:
                info.type = Adresse.class;
                info.name = "a3";
                break;
            case 23:
                info.type = PersonRelationship.class;
                info.name = "a30";
                break;
            case 24:
                info.type = Provision.class;
                info.name = "a31";
                break;
            case 25:
                info.type = RecurringContribution.class;
                info.name = "a32";
                break;
            case 26:
                info.type = RefAddressType.class;
                info.name = "a33";
                break;
            case 27:
                info.type = RefBillStatu.class;
                info.name = "a34";
                break;
            case 28:
                info.type = RefBillType.class;
                info.name = "a35";
                break;
            case 29:
                info.type = RefCustomerType.class;
                info.name = "a36";
                break;
            case 30:
                info.type = RefExternalAccountType.class;
                info.name = "a37";
                break;
            case 31:
                info.type = RefGender.class;
                info.name = "a38";
                break;
            case 32:
                info.type = RefGroupType.class;
                info.name = "a39";
                break;
            case 33:
                info.type = Bill.class;
                info.name = "a4";
                break;
            case 34:
                info.type = RefIndustryCategory.class;
                info.name = "a40";
                break;
            case 35:
                info.type = RefLoginStatu.class;
                info.name = "a41";
                break;
            case 36:
                info.type = RefMaritalStatu.class;
                info.name = "a42";
                break;
            case 37:
                info.type = RefOperationStatu.class;
                info.name = "a43";
                break;
            case 38:
                info.type = RefOperationType.class;
                info.name = "a44";
                break;
            case 39:
                info.type = RefPartnerType.class;
                info.name = "a45";
                break;
            case 40:
                info.type = RefPersonRelationshipType.class;
                info.name = "a46";
                break;
            case 41:
                info.type = RefProvisionStatu.class;
                info.name = "a47";
                break;
            case 42:
                info.type = RefRegistrationStatu.class;
                info.name = "a48";
                break;
            case 43:
                info.type = RefResult.class;
                info.name = "a49";
                break;
            case 44:
                info.type = BillPayment.class;
                info.name = "a5";
                break;
            case 45:
                info.type = RefTransfertStatu.class;
                info.name = "a50";
                break;
            case 46:
                info.type = Registration.class;
                info.name = "a51";
                break;
            case 47:
                info.type = Reseller.class;
                info.name = "a52";
                break;
            case 48:
                info.type = Tag.class;
                info.name = "a53";
                break;
            case 49:
                info.type = Transfert2Cash.class;
                info.name = "a54";
                break;
            case 50:
                info.type = Transfert2CashDetails.class;
                info.name = "a55";
                break;
            case 51:
                info.type = TransfertE2e.class;
                info.name = "a56";
                break;
            case 52:
                info.type = TransfertGroup.class;
                info.name = "a57";
                break;
            case 53:
                info.type = TransfertGroupScheduled.class;
                info.name = "a58";
                break;
            case 54:
                info.type = TransfertP2p.class;
                info.name = "a59";
                break;
            case 55:
                info.type = Business.class;
                info.name = "a6";
                break;
            case 56:
                info.type = TransfertScheduled.class;
                info.name = "a60";
                break;
            case 57:
                info.type = KoloUser.class;
                info.name = "a61";
                break;
            case 58:
                info.type = Wholesaler.class;
                info.name = "a62";
                break;
            case 59:
                info.type = BusinessContact.class;
                info.name = "a7";
                break;
            case 60:
                info.type = City.class;
                info.name = "a8";
                break;
            case 61:
                info.type = Country.class;
                info.name = "a9";
                break;
        }
    }

    //    @Override
    public String getInnerText() {
        return null;
    }

    //    @Override
    public void setInnerText(String s) {
    }

    public AccountOperation getA1() {
        return a1;
    }

    public void setA1(AccountOperation a1) {
        this.a1 = a1;
    }

    public Currency getA10() {
        return a10;
    }

    public void setA10(Currency a10) {
        this.a10 = a10;
    }

    public Customer getA11() {
        return a11;
    }

    public void setA11(Customer a11) {
        this.a11 = a11;
    }

    public CustomerAddress getA12() {
        return a12;
    }

    public void setA12(CustomerAddress a12) {
        this.a12 = a12;
    }

    public CustomerBalanceHistory getA13() {
        return a13;
    }

    public void setA13(CustomerBalanceHistory a13) {
        this.a13 = a13;
    }

    public CustomerExternalAccount getA14() {
        return a14;
    }

    public void setA14(CustomerExternalAccount a14) {
        this.a14 = a14;
    }

    public CustomerGroup getA15() {
        return a15;
    }

    public void setA15(CustomerGroup a15) {
        this.a15 = a15;
    }

    public CustomerImage getA16() {
        return a16;
    }

    public void setA16(CustomerImage a16) {
        this.a16 = a16;
    }

    public CustomerLogin getA17() {
        return a17;
    }

    public void setA17(CustomerLogin a17) {
        this.a17 = a17;
    }

    public CustomerTag getA18() {
        return a18;
    }

    public void setA18(CustomerTag a18) {
        this.a18 = a18;
    }

    public District getA19() {
        return a19;
    }

    public void setA19(District a19) {
        this.a19 = a19;
    }

    public AccountOperationRequest getA2() {
        return a2;
    }

    public void setA2(AccountOperationRequest a2) {
        this.a2 = a2;
    }

    public ExternalAccount getA20() {
        return a20;
    }

    public void setA20(ExternalAccount a20) {
        this.a20 = a20;
    }

    public ExternalAccountHistory getA21() {
        return a21;
    }

    public void setA21(ExternalAccountHistory a21) {
        this.a21 = a21;
    }

    public KoloNotification getA22() {
        return a22;
    }

    public void setA22(KoloNotification a22) {
        this.a22 = a22;
    }

    public GroupImage getA23() {
        return a23;
    }

    public void setA23(GroupImage a23) {
        this.a23 = a23;
    }

    public LoginAttempt getA24() {
        return a24;
    }

    public void setA24(LoginAttempt a24) {
        this.a24 = a24;
    }

    public MobileDevice getA25() {
        return a25;
    }

    public void setA25(MobileDevice a25) {
        this.a25 = a25;
    }

    public Partner getA26() {
        return a26;
    }

    public void setA26(Partner a26) {
        this.a26 = a26;
    }

    public PartnerAddress getA27() {
        return a27;
    }

    public void setA27(PartnerAddress a27) {
        this.a27 = a27;
    }

    public PartnerBalanceHistory getA28() {
        return a28;
    }

    public void setA28(PartnerBalanceHistory a28) {
        this.a28 = a28;
    }

    public Person getA29() {
        return a29;
    }

    public void setA29(Person a29) {
        this.a29 = a29;
    }

    public Adresse getA3() {
        return a3;
    }

    public void setA3(Adresse a3) {
        this.a3 = a3;
    }

    public PersonRelationship getA30() {
        return a30;
    }

    public void setA30(PersonRelationship a30) {
        this.a30 = a30;
    }

    public Provision getA31() {
        return a31;
    }

    public void setA31(Provision a31) {
        this.a31 = a31;
    }

    public RecurringContribution getA32() {
        return a32;
    }

    public void setA32(RecurringContribution a32) {
        this.a32 = a32;
    }

    public RefAddressType getA33() {
        return a33;
    }

    public void setA33(RefAddressType a33) {
        this.a33 = a33;
    }

    public RefBillStatu getA34() {
        return a34;
    }

    public void setA34(RefBillStatu a34) {
        this.a34 = a34;
    }

    public RefBillType getA35() {
        return a35;
    }

    public void setA35(RefBillType a35) {
        this.a35 = a35;
    }

    public RefCustomerType getA36() {
        return a36;
    }

    public void setA36(RefCustomerType a36) {
        this.a36 = a36;
    }

    public RefExternalAccountType getA37() {
        return a37;
    }

    public void setA37(RefExternalAccountType a37) {
        this.a37 = a37;
    }

    public RefGender getA38() {
        return a38;
    }

    public void setA38(RefGender a38) {
        this.a38 = a38;
    }

    public RefGroupType getA39() {
        return a39;
    }

    public void setA39(RefGroupType a39) {
        this.a39 = a39;
    }

    public Bill getA4() {
        return a4;
    }

    public void setA4(Bill a4) {
        this.a4 = a4;
    }

    public RefIndustryCategory getA40() {
        return a40;
    }

    public void setA40(RefIndustryCategory a40) {
        this.a40 = a40;
    }

    public RefLoginStatu getA41() {
        return a41;
    }

    public void setA41(RefLoginStatu a41) {
        this.a41 = a41;
    }

    public RefMaritalStatu getA42() {
        return a42;
    }

    public void setA42(RefMaritalStatu a42) {
        this.a42 = a42;
    }

    public RefOperationStatu getA43() {
        return a43;
    }

    public void setA43(RefOperationStatu a43) {
        this.a43 = a43;
    }

    public RefOperationType getA44() {
        return a44;
    }

    public void setA44(RefOperationType a44) {
        this.a44 = a44;
    }

    public RefPartnerType getA45() {
        return a45;
    }

    public void setA45(RefPartnerType a45) {
        this.a45 = a45;
    }

    public RefPersonRelationshipType getA46() {
        return a46;
    }

    public void setA46(RefPersonRelationshipType a46) {
        this.a46 = a46;
    }

    public RefProvisionStatu getA47() {
        return a47;
    }

    public void setA47(RefProvisionStatu a47) {
        this.a47 = a47;
    }

    public RefRegistrationStatu getA48() {
        return a48;
    }

    public void setA48(RefRegistrationStatu a48) {
        this.a48 = a48;
    }

    public RefResult getA49() {
        return a49;
    }

    public void setA49(RefResult a49) {
        this.a49 = a49;
    }

    public BillPayment getA5() {
        return a5;
    }

    public void setA5(BillPayment a5) {
        this.a5 = a5;
    }

    public RefTransfertStatu getA50() {
        return a50;
    }

    public void setA50(RefTransfertStatu a50) {
        this.a50 = a50;
    }

    public Registration getA51() {
        return a51;
    }

    public void setA51(Registration a51) {
        this.a51 = a51;
    }

    public Reseller getA52() {
        return a52;
    }

    public void setA52(Reseller a52) {
        this.a52 = a52;
    }

    public Tag getA53() {
        return a53;
    }

    public void setA53(Tag a53) {
        this.a53 = a53;
    }

    public Transfert2Cash getA54() {
        return a54;
    }

    public void setA54(Transfert2Cash a54) {
        this.a54 = a54;
    }

    public Transfert2CashDetails getA55() {
        return a55;
    }

    public void setA55(Transfert2CashDetails a55) {
        this.a55 = a55;
    }

    public TransfertE2e getA56() {
        return a56;
    }

    public void setA56(TransfertE2e a56) {
        this.a56 = a56;
    }

    public TransfertGroup getA57() {
        return a57;
    }

    public void setA57(TransfertGroup a57) {
        this.a57 = a57;
    }

    public TransfertGroupScheduled getA58() {
        return a58;
    }

    public void setA58(TransfertGroupScheduled a58) {
        this.a58 = a58;
    }

    public TransfertP2p getA59() {
        return a59;
    }

    public void setA59(TransfertP2p a59) {
        this.a59 = a59;
    }

    public Business getA6() {
        return a6;
    }

    public void setA6(Business a6) {
        this.a6 = a6;
    }

    public TransfertScheduled getA60() {
        return a60;
    }

    public void setA60(TransfertScheduled a60) {
        this.a60 = a60;
    }

    public KoloUser getA61() {
        return a61;
    }

    public void setA61(KoloUser a61) {
        this.a61 = a61;
    }

    public Wholesaler getA62() {
        return a62;
    }

    public void setA62(Wholesaler a62) {
        this.a62 = a62;
    }

    public BusinessContact getA7() {
        return a7;
    }

    public void setA7(BusinessContact a7) {
        this.a7 = a7;
    }

    public City getA8() {
        return a8;
    }

    public void setA8(City a8) {
        this.a8 = a8;
    }

    public Country getA9() {
        return a9;
    }

    public void setA9(Country a9) {
        this.a9 = a9;
    }
}
