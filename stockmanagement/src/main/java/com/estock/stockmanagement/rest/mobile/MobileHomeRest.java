package com.estock.stockmanagement.rest.mobile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estock.stockmanagement.rest.web.WebSaleTypeRest;

import org.apache.log4j.Logger;

@RestController
@RequestMapping(value = "/api/mobile")
public class MobileHomeRest {
	private static Logger log = Logger.getLogger(MobileHomeRest.class.getName());
	
	@GetMapping(value = "/home")
	public String index() {
		log.info("");
		return "Web Home";
	}
	
}
