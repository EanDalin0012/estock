package com.estock.stockmanagement.importstock;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.estock.stockmanagement.common.exception.CustomException;
import com.estock.stockmanagement.common.util.GenerateRandomKeyUtil;
import com.estock.stockmanagement.provider.importstock.data.request.ImportStockRequest;
import com.estock.stockmanagement.provider.importstock.service.ImportStockService;

@SpringBootTest
public class ImportStockTest {
	static Logger log = Logger.getLogger(ImportStockTest.class.getName());
	private String key;
	
	@Autowired
	private ImportStockService importStockService;
	
	public ImportStockTest() {
		this.key = GenerateRandomKeyUtil.key();	
	}
	
	@Test
	void contextSave() throws CustomException {
		try {
			List<ImportStockRequest> lst = new ArrayList<ImportStockRequest>();
			lst.add(new ImportStockRequest(0, 0, null));
			lst.add(new ImportStockRequest(0, 0, null));
			lst.add(new ImportStockRequest(0, 0, null));
			
			int save = this.importStockService.addNewStock(lst, 1);
			log.info(key+ "=== add "+ save);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
