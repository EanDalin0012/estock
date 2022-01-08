package com.estock.stockmanagement.representproducttype;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.estock.stockmanagement.common.exception.CustomException;
import com.estock.stockmanagement.common.util.GenerateRandomKeyUtil;
import com.estock.stockmanagement.provider.representproducttype.data.adapter.RepresentProductTypeAdapter;
import com.estock.stockmanagement.provider.representproducttype.data.request.RepresentProductTypeRequest;
import com.estock.stockmanagement.provider.representproducttype.service.RepresentProductTypeService;
import com.estock.stockmanagement.util.EUtil;


@SpringBootTest
public class RepresentProductTypeTest {
	static Logger log = Logger.getLogger(RepresentProductTypeTest.class.getName());
	private String key;
	
	RepresentProductTypeTest() {
		this.key = GenerateRandomKeyUtil.key();
	}
	
	@Autowired
	private RepresentProductTypeService representProductTypeService;
	
	@Test
	void contextLoads() throws CustomException {
		try {
			
			List<RepresentProductTypeRequest> representTypeProductRequests = new ArrayList<RepresentProductTypeRequest>();
			representTypeProductRequests.add(new RepresentProductTypeRequest(1,"Price", 1, 22));
			representTypeProductRequests.add(new RepresentProductTypeRequest(1,"Silver", 6, 16.5));
			representTypeProductRequests.add(new RepresentProductTypeRequest(1,"VIP Silver", 12, 16.00));
			representTypeProductRequests.add(new RepresentProductTypeRequest(1,"Premuim", 30, 15.50));
			representTypeProductRequests.add(new RepresentProductTypeRequest(1,"VIP Premuim", 50, 14.80));
			representTypeProductRequests.add(new RepresentProductTypeRequest(1,"Gold", 100, 14.00));
			representTypeProductRequests.add(new RepresentProductTypeRequest(1,"VIP Gold", 200, 13.00));
			representTypeProductRequests.add(new RepresentProductTypeRequest(1,"Diamond", 500, 12.10));
			representTypeProductRequests.add(new RepresentProductTypeRequest(1,"VIP Diamond", 1000, 11.50));
			representTypeProductRequests.add(new RepresentProductTypeRequest(1,"Queen", 2000, 11.00));
			representTypeProductRequests.add(new RepresentProductTypeRequest(1,"VIP Queen", 3000, 10.50));
			representTypeProductRequests.add(new RepresentProductTypeRequest(1,"Supper Queen", 4000, 10.00));
			
			representTypeProductRequests.add(new RepresentProductTypeRequest(2,"Price", 1, 15.00));
			representTypeProductRequests.add(new RepresentProductTypeRequest(2,"Silver", 6, 10.00));
			representTypeProductRequests.add(new RepresentProductTypeRequest(2,"VIP Silver", 15, 9.50));
			representTypeProductRequests.add(new RepresentProductTypeRequest(2,"Premuim", 35, 9.00));
			representTypeProductRequests.add(new RepresentProductTypeRequest(2,"VIP Premuim", 55, 8.50));
			representTypeProductRequests.add(new RepresentProductTypeRequest(2,"Gold", 100, 8.00));
			representTypeProductRequests.add(new RepresentProductTypeRequest(2,"VIP Gold", 200, 7.50));
			representTypeProductRequests.add(new RepresentProductTypeRequest(2,"Diamond", 400, 7.00));
			representTypeProductRequests.add(new RepresentProductTypeRequest(2,"VIP Diamond", 600, 6.50));
			representTypeProductRequests.add(new RepresentProductTypeRequest(2,"Queen", 1000, 6.00));
			representTypeProductRequests.add(new RepresentProductTypeRequest(2,"VIP Queen", 2000, 5.50));
			representTypeProductRequests.add(new RepresentProductTypeRequest(2,"Supper Queen", 3000, 5));
			
			int add = this.representProductTypeService.addNewRepresentTypeProduct(representTypeProductRequests, 1);
			log.info(key +"add =>" +add);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void inquiryById() {
		try {
			RepresentProductTypeAdapter adapter = this.representProductTypeService.inquiryById(1);
			log.info(key +"=== Test() RepresentProductTypeAdapter Data :" +EUtil.toJSON(adapter));
		}catch (Exception e) {
			e.printStackTrace();
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void inquiryAll() {
		try {
			List<RepresentProductTypeAdapter> adapters = this.representProductTypeService.inquiryAll();
			log.info(key +"List Of RepresentProductTypeAdapter Data :" +EUtil.toJSON(adapters));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
