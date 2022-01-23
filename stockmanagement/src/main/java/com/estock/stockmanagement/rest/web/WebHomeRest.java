package com.estock.stockmanagement.rest.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;

@RestController
@RequestMapping(value = "/api/web")
public class WebHomeRest {
	private static Logger log = Logger.getLogger(WebHomeRest.class.getName());
	@GetMapping(value = "/home")
	public String index() {
		log.info("Web Home");
		return "Web Home";
	}
}
