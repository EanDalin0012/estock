package com.estock.stockmanagement.rest.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(value = "/api/web")
public class WebHomeRest {
	private static final Logger log = LoggerFactory.getLogger(WebHomeRest.class);
	@GetMapping(value = "/home")
	public String index() {
		log.info("Web Home");
		return "Web Home";
	}
}
