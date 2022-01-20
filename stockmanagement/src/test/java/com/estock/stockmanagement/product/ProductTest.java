package com.estock.stockmanagement.product;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.estock.stockmanagement.common.exception.CustomException;
import com.estock.stockmanagement.provider.product.data.adapter.ProductAdapter;
import com.estock.stockmanagement.provider.product.data.request.ProductRequest;
import com.estock.stockmanagement.provider.product.data.request.UpdateProductRequest;
import com.estock.stockmanagement.provider.product.service.ProductService;
import com.estock.stockmanagement.util.Utility;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class ProductTest {

	@Autowired
	private  ProductService productService;
	
	@Test
	void contextLoads() {
		try {
			List<ProductAdapter> data =  this.productService.inquiryAllProduct();
			log.info("Inquiry All Product =>" + Utility.toJSON(data));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void contextLoadById() {
		try {
			ProductAdapter data =  this.productService.inquiryProductById(1);
			log.info("Inquiry All Product =>" + Utility.toJSON(data));
		}catch (Exception e) {
			e.printStackTrace();
		} catch (CustomException ex) {
			ex.printStackTrace();
			log.info(ex.getKey() +","+ex.getValue());
		}
		
	}
	

	@Test
	void contextDelteProduct() {
		try {
			int data =  this.productService.deleteProduct(1);
			log.info("Inquiry All Product =>" + Utility.toJSON(data));
		}catch (Exception e) {
			e.printStackTrace();
		} catch (CustomException ex) {
			ex.printStackTrace();
			log.info(ex.getKey() +","+ex.getValue());
		}
		
	}
	
	@Test
	void contextAddNewProduct() {
		try {
			ProductRequest productRequest = new ProductRequest();
			productRequest.setName("Pichy P-White");
			productRequest.setResourceId(1);
			productRequest.setDesc("Pichy P-White");
			log.info("Add New Product =>" + Utility.toJSON(productRequest));
			int addNewProduct = this.productService.addNewProduct(productRequest);
			log.info("add new product :"+addNewProduct);
		}catch (Exception  e) {
			e.printStackTrace();
		} catch (CustomException ex) {
			ex.printStackTrace();
			log.info(ex.getKey() +","+ex.getValue());
		}
		
	}
	
	@Test
	void contextUpdateProduct() {
		try {
			UpdateProductRequest updateProductRequest = new UpdateProductRequest();
			updateProductRequest.setId(1);
			updateProductRequest.setName("Phichy P-White");
			updateProductRequest.setDesc("Phichy P-White");
			updateProductRequest.setResourceId(1);
			
			log.info("Add New Product =>" + Utility.toJSON(updateProductRequest));
			int updateProduct = this.productService.updateProduct(updateProductRequest);
			log.info("Update Product :"+updateProduct);
		}catch (Exception  e) {
			e.printStackTrace();
		} catch (CustomException ex) {
			ex.printStackTrace();
		}
	}
}
