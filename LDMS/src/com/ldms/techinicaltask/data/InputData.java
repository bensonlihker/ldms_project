package com.ldms.techinicaltask.data;



public class InputData {
	private Double assetCost;
	
	private Double deposit;
	
	private Double interestRate;
	
	private Integer numberOfTerm;
	
	private Double balloon;


	

	public InputData(Double assetCost, Double deposit, Double interestRate, Integer numberOfTerm, Double balloon) {
		super();
		this.assetCost = assetCost;
		this.deposit = deposit;
		this.interestRate = interestRate;
		this.numberOfTerm = numberOfTerm;
		this.balloon = balloon;
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
	
	

}
