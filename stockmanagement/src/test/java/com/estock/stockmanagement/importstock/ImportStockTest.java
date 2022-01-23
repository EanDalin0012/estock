package com.estock.stockmanagement.importstock;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.estock.stockmanagement.common.exception.CustomException;
import com.estock.stockmanagement.provider.importstock.data.request.ImportStockRequest;
import com.estock.stockmanagement.provider.importstock.service.ImportStockService;

@SpringBootTest
public class ImportStockTest {
	static Logger log = Logger.getLogger(ImportStockTest.class.getName());
	
	@Autowired
	private ImportStockService importStockService;
	
	@Test
	void contextSave() throws CustomException {
		try{
			ImportStockRequest request = new ImportStockRequest();
			request.setName("Import Stock A");
			int save = this.importStockService.addNewStockName(request, 1);
			log.info(save);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void contextDelete() throws CustomException {
		try{
			ImportStockRequest request = new ImportStockRequest();
			request.setName("Import Stock A");
			int save = this.importStockService.deleteStockName(1, 1);
			log.info(save);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
