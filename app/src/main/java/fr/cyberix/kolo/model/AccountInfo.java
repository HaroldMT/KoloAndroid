/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package fr.cyberix.kolo.model;

import android.support.annotation.NonNull;

import java.util.Date;
import java.util.HashSet;

import fr.cyberix.kolo.helpers.SystemServiceHelper;
import fr.cyberix.kolo.model.entities.Business;
import fr.cyberix.kolo.model.entities.Customer;
import fr.cyberix.kolo.model.entities.MobileDevice;
import fr.cyberix.kolo.model.entities.Person;
import fr.cyberix.kolo.model.entities.Registration;

public final class AccountInfo {
	private Boolean isAuthenticated = false;
	private Boolean isRegistring = false;
	private Boolean isRegistred = false;
	private Customer customer = new Customer();
	private Date lastAuthenticationTime;
	private MobileDevice mobileDevice = new MobileDevice();
	private Person person = new Person();
	private Business business = new Business();
	private Registration registration = new Registration();
	private TelephonyInfo telInfo = SystemServiceHelper.getInfos();
	private HashSet<Contact> contacts = new HashSet<Contact>();
	
	public Boolean getAuthenticated() {
		return isAuthenticated;
	}
	
	public void setAuthenticated(Boolean authenticated) {
		isAuthenticated = authenticated;
	}
	
	@NonNull
	public Boolean getRegistered() {
		return isRegistred;
	}
	
	@NonNull
	public Boolean getRegistering() {
		return isRegistring;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
		if (customer.getMobileDevice() != null) setMobileDevice(customer.getMobileDevice());
		if (customer.getBusiness() != null) setBusiness(customer.getBusiness());
		if (customer.getPerson() != null) setPerson(customer.getPerson());
	}
	
	public String getFullName() {
		return this.person.getLastname() + ' ' + this.person.getFirstname();
	}
	
	public Date getLastAuthenticationTime() {
		return lastAuthenticationTime;
	}
	
	public void setLastAuthenticationTime(Date lastAuthenticationTime) {
		this.lastAuthenticationTime = lastAuthenticationTime;
	}
	
	public MobileDevice getMobileDevice() {
		return mobileDevice;
	}
	
	public void setMobileDevice(MobileDevice mobileDevice) {
		this.mobileDevice = mobileDevice;
	}
	
	public Boolean getRegistring() {
		return isRegistring;
	}
	
	public void setRegistring(Boolean registring) {
		isRegistring = registring;
	}
	
	public Boolean getRegistred() {
		return isRegistred;
	}
	
	public void setRegistred(Boolean registred) {
		isRegistred = registred;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public Registration getRegistration() {
		return registration;
	}
	
	public void setRegistration(Registration registration) {
		this.registration = registration;
		if (registration != null) {
		
		}
	}
	
	public TelephonyInfo getTelInfo() {
		return telInfo;
	}
	
	public void setTelInfo(TelephonyInfo telInfo) {
		this.telInfo = telInfo;
	}
	
	public HashSet<Contact> getContacts() {
		return contacts;
	}
	
	public void setContacts(HashSet<Contact> contacts) {
		this.contacts = contacts;
	}
	
	public Business getBusiness() {
		return business;
	}
	
	public void setBusiness(Business business) {
		this.business = business;
	}
}
