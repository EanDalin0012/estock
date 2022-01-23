package com.estock.stockmanagement.importtostock;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.estock.stockmanagement.common.exception.CustomException;
import com.estock.stockmanagement.provider.importtostock.data.request.ImportToStockRequest;
import com.estock.stockmanagement.provider.importtostock.service.ImportToStockService;


@SpringBootTest
public class ImportToStockTest {
	static Logger log = Logger.getLogger(ImportToStockTest.class.getName());
	private String key;
	
	@Autowired
	private ImportToStockService importStockService;
	
//	public ImportStockTest() {
//		this.key = GenerateRandomKeyUtil.key();	
//	}
	
	@Test
	void contextSave() throws CustomException {
		try {
			List<ImportToStockRequest> lst = new ArrayList<ImportToStockRequest>();
			lst.add(new ImportToStockRequest(1, 0, "test"));
			lst.add(new ImportToStockRequest(2, 0, "test"));
			
			int save = this.importStockService.addNewStock(lst, 1);
			log.info(key+ "=== add "+ save);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
