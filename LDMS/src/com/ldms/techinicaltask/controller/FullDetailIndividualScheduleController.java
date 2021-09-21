package com.ldms.techinicaltask.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ldms.techinicaltask.data.IndividualScheduleData;
import com.ldms.techinicaltask.data.InputData;
import com.ldms.techinicaltask.entity.ScheduleDataEntity;
import com.ldms.techinicaltask.repository.ScheduleDataRepository;
import com.ldms.techinicaltask.service.LoanCalculatorService;

@RestController
@RequestMapping("get")
public class FullDetailIndividualScheduleController {
	@Autowired
	ScheduleDataRepository scheduleDataRepository;

	@Autowired
	LoanCalculatorService loanCalculatorService;

	@GetMapping("/")
	public ResponseEntity<Map<String, ?>> getAmortisationSchedule(@RequestParam(required = true) Integer id) {
		List<IndividualScheduleData> resultList = new ArrayList<IndividualScheduleData>();
		Map<String, Object> resultMap = new HashMap<>();

		if (id != null) {
			Optional<ScheduleDataEntity> data = scheduleDataRepository.findById(id);

			if (data.isPresent()) {
				ScheduleDataEntity scheduleData = data.get();

				InputData input = new InputData(scheduleData.getAssetCost(), scheduleData.getDeposit(),
						scheduleData.getInterestRate(), scheduleData.getNumberOfTerm(), scheduleData.getBalloon());

				loanCalculatorService.createAmortisationScheduleAndScheduleList(resultList, input);

				resultMap.put("scheduleData", scheduleData);
				resultMap.put("resultList", resultList);

			}

			return new ResponseEntity<>(resultMap, HttpStatus.OK);
		}

		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

	}
}
