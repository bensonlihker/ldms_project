package com.ldms.techinicaltask.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.ldms.techinicaltask.entity.ScheduleDataEntity;
import com.ldms.techinicaltask.repository.ScheduleDataRepository;

@RestController
@RequestMapping("list_all")
public class ListPreviouslySchedulesController {

	@Autowired
	ScheduleDataRepository scheduleDataRepository; 
	

	@GetMapping("/")
	public ResponseEntity<List<ScheduleDataEntity>> listall() {
		List<ScheduleDataEntity> resultList = scheduleDataRepository.findAll(); 
		
		if(resultList != null && resultList.size() > 0) {
			return new ResponseEntity<>(resultList, HttpStatus.OK);	
		}
		
		return new ResponseEntity<>(null, HttpStatus.NO_CONTENT); 
		
		
		
	}
}
