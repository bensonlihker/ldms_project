package com.ldms.techinicaltask.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ldms.techinicaltask.data.IndividualScheduleData;
import com.ldms.techinicaltask.data.InputData;

import com.ldms.techinicaltask.entity.ScheduleDataEntity;

@Service
public class LoanCalculatorService {

	public double calMonthlyRepaymentWithBalloon(InputData input) {
		double result = 0d;
		
		double monthlyInterest = calMonthlyInterest(input);
		double remainTotal = input.getAssetCost() - input.getDeposit();
		
		result = (remainTotal - (input.getBalloon() / Math.pow((1 + monthlyInterest), input.getNumberOfTerm())))
				* (monthlyInterest / (1 - Math.pow((1 + monthlyInterest), -input.getNumberOfTerm())));

		return roundUp2d(result);
	}

	public double calMonthlyRepaymentWithoutBalloon(InputData input) {
		double result = 0d;

		double monthlyInterest = calMonthlyInterest(input);
		double remainTotal = input.getAssetCost() - input.getDeposit();

		result = remainTotal * (monthlyInterest * Math.pow((1 + monthlyInterest), input.getNumberOfTerm()))
				/ (Math.pow(1 + monthlyInterest, input.getNumberOfTerm()) - 1);

		
		return roundUp2d(result);
	}
	
	

	// round up to decimal places
	public double roundUp2d(double input) {

		return Math.round(input * 100.0) / 100.0;

	}

	// calculate monthly interest 
	public double calMonthlyInterest(InputData input) {
		return (input.getInterestRate() / 100) / 12;
	}
	
	
	// create schedule and also return schedule data
	public ScheduleDataEntity createAmortisationScheduleAndScheduleList(List<IndividualScheduleData> resultList,
			InputData data) {
		
		ScheduleDataEntity scheduleData = null;
		double payment = 0;
		
		if(data.getBalloon() != null && data.getBalloon() > 0) {
			payment = calMonthlyRepaymentWithBalloon(data);	
		} else {
			payment = calMonthlyRepaymentWithoutBalloon(data);
		}
		
		 
		double balance = 0;
		double interest = 0;
		double principal = 0;

		double totalInterest = 0;

		double monthlyInterest = calMonthlyInterest(data);

		
		// loop through all period 
		for (int period = 1; period <= data.getNumberOfTerm(); period++) {

			// init first period balance
			if (period == 1) {
				balance = data.getAssetCost() - data.getDeposit();

			}

			// calculate the interest of this period 
			interest = roundUp2d(balance * monthlyInterest);			

			// sum of interest  
			totalInterest = totalInterest + interest;

			// calculate the principal  
			principal = roundUp2d(payment - interest);

			// calculate the balance 
			balance = roundUp2d(balance - principal);

			
// 			about the rounding issue, since the interest rounding every loop. it may case that the final balance not same as total payment 			
//			if (balance < 0) {
//				balance = 0;
//			}
//			
//			if(data.getBalloon() != null && period == data.getNumberOfTerm()) {
//				balance = data.getBalloon(); 	
//			}

			resultList.add(new IndividualScheduleData(period, payment, principal, interest, balance));
		}

		scheduleData = new ScheduleDataEntity(data.getAssetCost(), 
											  data.getDeposit(), 
											  data.getInterestRate(), 
											  data.getNumberOfTerm(),
											  data.getBalloon(),
											  payment,
											  totalInterest, 
											  roundUp2d(payment * data.getNumberOfTerm()));

		return scheduleData;
		
		
	}

	
}
