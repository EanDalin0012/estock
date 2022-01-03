package com.estock.stockmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.estock.stockmanagement.provider.authentication.data.adapter.AuthenticationAdapter;
import com.estock.stockmanagement.provider.authentication.service.AuthenticationService;
import com.estock.stockmanagement.util.EUtil;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class StockmanagementApplicationTests {

	@Autowired
	private  AuthenticationService authenticationService;
	@Test
	void contextLoads() {
		AuthenticationAdapter data = this.authenticationService.loadUserByUsername("admin@gmail.com");
		log.info("StockmanagementApplicationTests =>" + EUtil.toJSON(data));
	}
	


}
