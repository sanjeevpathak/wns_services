package com.wns.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wns.entity.CritGU;
import com.wns.repository.WNSRepository;
import com.wns.service.WNSMigrateService;

@RestController
// @RequestMapping("/getdata")
public class WNSController {

	@Autowired
	WNSRepository repository;
	
	@Autowired
	WNSMigrateService services;

	@GetMapping("/getdata")
	public List<CritGU> getMigrationData() {
	
		return services.finalCritExt();

	}

}
