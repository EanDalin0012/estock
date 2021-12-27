package com.estock.stockmanagement.rest.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/web")
@Slf4j
public class WebHomeRest {

	@GetMapping(value = "/home")
	public String index() {
		log.info("Web Home");
		return "Web Home";
	}
}
