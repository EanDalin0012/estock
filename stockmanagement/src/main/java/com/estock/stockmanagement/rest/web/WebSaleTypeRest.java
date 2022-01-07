package com.estock.stockmanagement.rest.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;

@RestController
@RequestMapping(value = "/api/web/sale-type")
public class WebSaleTypeRest {
	static Logger log = Logger.getLogger(WebSaleTypeRest.class.getName());
	
	@GetMapping(value = "/home")
	public String index() {
		log.info("========== Start Inquiry Sale Type Channel Web");
		return "Web Home";
	}
	
	@PostMapping(value = "/insert")
	public void insert() {
		log.info("========== Start Insert Sale Type Channel Web");
//		if(requestVO != null) {
//			
//		}
	}
	
	@PostMapping(value = "/update")
	public void update() {
		log.info("========== Start Update Sale Type Channel Web");
	}
	
	@PostMapping(value = "/delete")
	public void delete() {
		log.info("========== Start Delete Sale Type Channel Web");
	}
	
}
