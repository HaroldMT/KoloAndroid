/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package fr.cyberix.kolo.model;

import java.util.ArrayList;
import java.util.List;

import fr.cyberix.kolo.model.entities.Currency;
import fr.cyberix.kolo.model.entities.RefAddressType;
import fr.cyberix.kolo.model.entities.RefBillStatu;
import fr.cyberix.kolo.model.entities.RefBillType;
import fr.cyberix.kolo.model.entities.RefCustomerType;
import fr.cyberix.kolo.model.entities.RefExternalAccountType;
import fr.cyberix.kolo.model.entities.RefGender;
import fr.cyberix.kolo.model.entities.RefGroupType;
import fr.cyberix.kolo.model.entities.RefIndustryCategory;
import fr.cyberix.kolo.model.entities.RefLoginStatu;
import fr.cyberix.kolo.model.entities.RefMaritalStatu;
import fr.cyberix.kolo.model.entities.RefOperationStatu;
import fr.cyberix.kolo.model.entities.RefOperationType;
import fr.cyberix.kolo.model.entities.RefPartnerType;
import fr.cyberix.kolo.model.entities.RefPersonRelationshipType;
import fr.cyberix.kolo.model.entities.RefProvisionStatu;
import fr.cyberix.kolo.model.entities.RefRegistrationStatu;
import fr.cyberix.kolo.model.entities.RefResult;
import fr.cyberix.kolo.model.entities.RefTransfertStatu;

/**
 * Created by tmhar on 9/13/2017.
 */

public class ParameterInfo {
	private List<Currency> currencyList = new ArrayList<>();
	
	private List<RefAddressType> refAddressTypes = new ArrayList<>();
	
	private List<RefBillStatu> refBillStatus = new ArrayList<>();
	
	private List<RefBillType> refBillTypes = new ArrayList<>();
	
	private List<RefCustomerType> refCustomerTypes = new ArrayList<>();
	
	private List<RefExternalAccountType> refExternalAccountTypes = new ArrayList<>();
	
	private List<RefGender> refGenders = new ArrayList<>();
	
	private List<RefGroupType> refGroupTypes = new ArrayList<>();
	
	private List<RefIndustryCategory> refIndustryCategorys = new ArrayList<>();
	
	private List<RefLoginStatu> refLoginStatus = new ArrayList<>();
	
	private List<RefMaritalStatu> refMaritalStatus = new ArrayList<>();
	
	private List<RefOperationStatu> refOperationStatus = new ArrayList<>();
	
	private List<RefOperationType> refOperationTypes = new ArrayList<>();
	
	private List<RefPartnerType> refPartnerTypes = new ArrayList<>();
	
	private List<RefPersonRelationshipType> refPersonRelationshipTypes = new ArrayList<>();
	
	private List<RefProvisionStatu> refProvisionStatus = new ArrayList<>();
	
	private List<RefRegistrationStatu> refRegistrationStatus = new ArrayList<>();
	
	private List<RefResult> refResults = new ArrayList<>();
	private List<RefTransfertStatu> refTransfertStatus;
	
	public List<Currency> getCurrencyList() {
		return currencyList;
	}
	
	public void setCurrencyList(List<Currency> currencyList) {
		this.currencyList = currencyList == null ? new ArrayList<Currency>() : currencyList;
	}
	
	public List<RefAddressType> getRefAddressTypes() {
		return refAddressTypes;
	}
	
	public void setRefAddressTypes(List<RefAddressType> refAddressTypes) {
		this.refAddressTypes = refAddressTypes;
	}
	
	public List<RefBillStatu> getRefBillStatus() {
		return refBillStatus;
	}
	
	public void setRefBillStatus(List<RefBillStatu> refBillStatus) {
		this.refBillStatus = refBillStatus;
	}
	
	public List<RefBillType> getRefBillTypes() {
		return refBillTypes;
	}
	
	public void setRefBillTypes(List<RefBillType> refBillTypes) {
		this.refBillTypes = refBillTypes;
	}
	
	public List<RefCustomerType> getRefCustomerTypes() {
		return refCustomerTypes;
	}
	
	public void setRefCustomerTypes(List<RefCustomerType> refCustomerTypes) {
		this.refCustomerTypes = refCustomerTypes;
	}
	
	public List<RefExternalAccountType> getRefExternalAccountTypes() {
		return refExternalAccountTypes;
	}
	
	public void setRefExternalAccountTypes(List<RefExternalAccountType> refExternalAccountTypes) {
		this.refExternalAccountTypes = refExternalAccountTypes;
	}
	
	public List<RefGender> getRefGenders() {
		return refGenders;
	}
	
	public void setRefGenders(List<RefGender> refGenders) {
		this.refGenders = refGenders;
	}
	
	public List<RefGroupType> getRefGroupTypes() {
		return refGroupTypes;
	}
	
	public void setRefGroupTypes(List<RefGroupType> refGroupTypes) {
		this.refGroupTypes = refGroupTypes;
	}
	
	public List<RefIndustryCategory> getRefIndustryCategorys() {
		return refIndustryCategorys;
	}
	
	public void setRefIndustryCategorys(List<RefIndustryCategory> refIndustryCategorys) {
		this.refIndustryCategorys = refIndustryCategorys;
	}
	
	public List<RefLoginStatu> getRefLoginStatus() {
		return refLoginStatus;
	}
	
	public void setRefLoginStatus(List<RefLoginStatu> refLoginStatus) {
		this.refLoginStatus = refLoginStatus;
	}
	
	public List<RefMaritalStatu> getRefMaritalStatus() {
		return refMaritalStatus;
	}
	
	public void setRefMaritalStatus(List<RefMaritalStatu> refMaritalStatus) {
		this.refMaritalStatus = refMaritalStatus;
	}
	
	public List<RefOperationStatu> getRefOperationStatus() {
		return refOperationStatus;
	}
	
	public void setRefOperationStatus(List<RefOperationStatu> refOperationStatus) {
		this.refOperationStatus = refOperationStatus;
	}
	
	public List<RefOperationType> getRefOperationTypes() {
		return refOperationTypes;
	}
	
	public void setRefOperationTypes(List<RefOperationType> refOperationTypes) {
		this.refOperationTypes = refOperationTypes;
	}
	
	public List<RefPartnerType> getRefPartnerTypes() {
		return refPartnerTypes;
	}
	
	public void setRefPartnerTypes(List<RefPartnerType> refPartnerTypes) {
		this.refPartnerTypes = refPartnerTypes;
	}
	
	public List<RefPersonRelationshipType> getRefPersonRelationshipTypes() {
		return refPersonRelationshipTypes;
	}
	
	public void setRefPersonRelationshipTypes(List<RefPersonRelationshipType> refPersonRelationshipTypes) {
		this.refPersonRelationshipTypes = refPersonRelationshipTypes;
	}
	
	public List<RefProvisionStatu> getRefProvisionStatus() {
		return refProvisionStatus;
	}
	
	public void setRefProvisionStatus(List<RefProvisionStatu> refProvisionStatus) {
		this.refProvisionStatus = refProvisionStatus;
	}
	
	public List<RefRegistrationStatu> getRefRegistrationStatus() {
		return refRegistrationStatus;
	}
	
	public void setRefRegistrationStatus(List<RefRegistrationStatu> refRegistrationStatus) {
		this.refRegistrationStatus = refRegistrationStatus;
	}
	
	public List<RefResult> getRefResults() {
		return refResults;
	}
	
	public void setRefResults(List<RefResult> refResults) {
		this.refResults = refResults;
	}
	
	public List<RefTransfertStatu> getRefTransfertStatus() {
		return refTransfertStatus;
	}
	
	public void setRefTransfertStatus(List<RefTransfertStatu> refTransfertStatus) {
		this.refTransfertStatus = refTransfertStatus;
	}
	
	
}
