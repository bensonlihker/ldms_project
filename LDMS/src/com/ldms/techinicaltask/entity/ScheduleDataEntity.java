package com.ldms.techinicaltask.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "QUERY_DATA")
public class ScheduleDataEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	private Double assetCost;
	
	private Double deposit;
	
	private Double interestRate;
	
	private Integer numberOfTerm;
	
	private Double balloon;
	
	private Double monthlyRepayment;
	
	private Double totlaInteresDue;
	
	private Double totlaPaymentDue; 
	
	public ScheduleDataEntity() {
		
	}
	
	public ScheduleDataEntity(
			Double assetCost, 
			Double deposit, 
			Double interestRate, 
			Integer numberOfTerm, 
			Double balloon,
			Double monthlyRepayment,
			Double totlaInteresDue,
			Double totlaPaymentDue) {
		this.assetCost = assetCost;
		this.deposit = deposit;
		this.interestRate = interestRate;
		this.numberOfTerm = numberOfTerm;
		this.balloon = balloon;
		this.monthlyRepayment = monthlyRepayment;
		this.totlaInteresDue = totlaInteresDue;
		this.totlaPaymentDue = totlaPaymentDue;
	}
	
	
	public Double getMonthlyRepayment() {
		return monthlyRepayment;
	}

	public void setMonthlyRepayment(Double monthlyRepayment) {
		this.monthlyRepayment = monthlyRepayment;
	}

	public Double getTotlaInteresDue() {
		return totlaInteresDue;
	}

	public void setTotlaInteresDue(Double totlaInteresDue) {
		this.totlaInteresDue = totlaInteresDue;
	}

	public Double getTotlaPaymentDue() {
		return totlaPaymentDue;
	}

	public void setTotlaPaymentDue(Double totlaPaymentDue) {
		this.totlaPaymentDue = totlaPaymentDue;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Double getAssetCost() {
		return assetCost;
	}

	public void setAssetCost(Double assetCost) {
		this.assetCost = assetCost;
	}

	public Double getDeposit() {
		return deposit;
	}
	public void setDeposit(Double deposit) {
		this.deposit = deposit;
	}
	public Double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	public Integer getNumberOfTerm() {
		return numberOfTerm;
	}
	public void setNumberOfTerm(Integer numberOfTerm) {
		this.numberOfTerm = numberOfTerm;
	}
	public Double getBalloon() {
		return balloon;
	}
	public void setBalloon(Double balloon) {
		this.balloon = balloon;
	}

	@Override
	public String toString() {
		return "ScheduleDataEntity [id=" + id + ", assetCost=" + assetCost + ", deposit=" + deposit + ", interestRate="
				+ interestRate + ", numberOfTerm=" + numberOfTerm + ", balloon=" + balloon + ", monthlyRepayment="
				+ monthlyRepayment + ", totlaInteresDue=" + totlaInteresDue + ", totlaPaymentDue=" + totlaPaymentDue
				+ "]";
	}
	
	
	
	

}
