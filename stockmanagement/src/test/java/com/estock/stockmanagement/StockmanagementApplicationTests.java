package com.estock.stockmanagement;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.estock.stockmanagement.provider.product.data.adapter.ProductAdapter;
import com.estock.stockmanagement.provider.product.service.ProductService;
import com.estock.stockmanagement.util.Utility;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class StockmanagementApplicationTests {

	@Autowired
	private  ProductService productService;
	
	@Test
	void contextLoads() {
		try {
			List<ProductAdapter> data = this.productService.inquiryAllProduct();
			log.info("Inquiry All Product Data :" + Utility.toJSON(data));	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	void contextAddNewProduct() {
		try {
			List<ProductAdapter> data = this.productService.inquiryAllProduct();
			log.info("Inquiry All Product Data :" + Utility.toJSON(data));	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


}
