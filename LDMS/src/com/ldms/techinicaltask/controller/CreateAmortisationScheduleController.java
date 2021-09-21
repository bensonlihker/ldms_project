package com.ldms.techinicaltask.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ldms.techinicaltask.data.IndividualScheduleData;
import com.ldms.techinicaltask.data.InputData;
import com.ldms.techinicaltask.entity.ScheduleDataEntity;
import com.ldms.techinicaltask.repository.ScheduleDataRepository;
import com.ldms.techinicaltask.service.LoanCalculatorService;

@RestController
@RequestMapping("create")
public class CreateAmortisationScheduleController {

	@Autowired
	LoanCalculatorService loanCalculatorService;
	
	@Autowired
	ScheduleDataRepository scheduleDataRepository; 
	
	// create the schedule and store it to H2 database, also calculate the amortisation schedule, return the result by json 
	@PostMapping("/")
	public ResponseEntity<List<IndividualScheduleData>> createAmortisationSchedule(@RequestBody InputData data) {
		List<IndividualScheduleData> resultList = new ArrayList<IndividualScheduleData>();
		
		
		if (vaildInputData(data)) {
			ScheduleDataEntity scheduleData = null;


			scheduleData= loanCalculatorService.createAmortisationScheduleAndScheduleList(resultList, data);
			
			if(scheduleData != null) {
				scheduleDataRepository.save(scheduleData);	
			}
			
			return new ResponseEntity<>(resultList, HttpStatus.OK);
		}

		

		return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
	}

	
	// validate the input data , asset cost, deposit, interest rate & number of terms should be not null and greater than 0
	
	// balloon is an option data, so don't need to check 
	private boolean vaildInputData(InputData data) {
		boolean reuslt = false;

		
		
		if (data != null) {
			if (data.getAssetCost() != null && data.getDeposit() != null && data.getInterestRate() != null
					&& data.getNumberOfTerm() != null) {
				if (data.getAssetCost() >= data.getDeposit()&& data.getDeposit()>= 0 && data.getInterestRate() >= 0 && data.getNumberOfTerm()>0) {
					reuslt = true;
				}
			}
		}
		
		return reuslt;

	}

	
	
	
}
