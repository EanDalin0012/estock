package com.estock.stockmanagement.rest.mobile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/mobile")
@Slf4j
public class MobileHomeRest {
	
	@GetMapping(value = "/home")
	public String index() {
		log.info("");
		return "Web Home";
	}
	
}
