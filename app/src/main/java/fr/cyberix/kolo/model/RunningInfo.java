package fr.cyberix.kolo.model;

import fr.cyberix.kolo.model.entities.LoginAttempt;

public class RunningInfo {
	private LoginAttempt loginAttempt;
	private TransferP2pDetailsList p2pDetailsList;
	private EneoBillDetailsList eneoBills;
	private CustomerBalanceHistoryList balanceHistories;
	private KoloNotificationList notifications;
	
	public RunningInfo() {
		loginAttempt = new LoginAttempt();
		p2pDetailsList = new TransferP2pDetailsList();
		eneoBills = new EneoBillDetailsList();
		balanceHistories = new CustomerBalanceHistoryList();
		notifications = new KoloNotificationList();
	}
	
	public TransferP2pDetailsList getP2pDetailsList() {
		return p2pDetailsList;
	}
	
	public void setP2pDetailsList(TransferP2pDetailsList p2pDetailsList) {
		this.p2pDetailsList = p2pDetailsList;
	}
	
	public EneoBillDetailsList getEneoBills() {
		return eneoBills;
	}
	
	public void setEneoBills(EneoBillDetailsList eneoBills) {
		this.eneoBills = eneoBills;
	}
	
	public CustomerBalanceHistoryList getBalanceHistories() {
		return balanceHistories;
	}
	
	public void setBalanceHistories(CustomerBalanceHistoryList balanceHistories) {
		this.balanceHistories = balanceHistories;
	}
	
	public KoloNotificationList getNotifications() {
		return notifications;
	}
	
	public void setNotifications(KoloNotificationList notifications) {
		this.notifications = notifications;
	}
	
	public LoginAttempt getLoginAttempt() {
		return loginAttempt;
	}
	
	public void setLoginAttempt(LoginAttempt loginAttempt) {
		this.loginAttempt = loginAttempt;
	}
}
