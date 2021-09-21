package com.ldms.techinicaltask.data;



public class IndividualScheduleData {
	private int period;
	private Double payment;
	private Double principal;
	private Double interest;
	private Double balance;
	
	
	
	public IndividualScheduleData(int period, Double payment, Double principal, Double interest, Double balance) {
		super();
		this.period = period;
		this.payment = payment;
		this.principal = principal;
		this.interest = interest;
		this.balance = balance;
	}
	
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public Double getPayment() {
		return payment;
	}
	public void setPayment(Double payment) {
		this.payment = payment;
	}
	public Double getPrincipal() {
		return principal;
	}
	public void setPrincipal(Double principal) {
		this.principal = principal;
	}
	public Double getInterest() {
		return interest;
	}
	public void setInterest(Double interest) {
		this.interest = interest;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	
}
