package com.estock.stockmanagement.provider.importstock.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import com.estock.stockmanagement.common.exception.CustomException;
import com.estock.stockmanagement.dao.importstock.ImportStockDAO;
import com.estock.stockmanagement.provider.importstock.constants.ImportStockErrorCode;
import com.estock.stockmanagement.provider.importstock.data.adpter.ImportStockAdapter;
import com.estock.stockmanagement.provider.importstock.data.request.ImportStockRequest;
import com.estock.stockmanagement.provider.importstock.service.ImportStockService;
import com.estock.stockmanagement.provider.representproducttype.data.adapter.RepresentProductTypeAdapter;
import com.estock.stockmanagement.provider.representproducttype.service.RepresentProductTypeService;

@Service
public class ImportStockServiceImpl implements ImportStockService {

	@Autowired
	private RepresentProductTypeService representProductTypeService;
	@Autowired
	private ImportStockDAO importStockDAO;
	@Autowired
	private PlatformTransactionManager manager;
	
	@Override
	public int addNewStock(List<ImportStockRequest> importStockRequests, int userId) throws CustomException {
		int save = 0;
		TransactionStatus status = manager.getTransaction(new DefaultTransactionDefinition());
		try {
			for (ImportStockRequest importStockRequest : importStockRequests) {
				
				if(importStockRequest.getRepresentProductTypeId() <= 0) {
					throw new CustomException(ImportStockErrorCode.INVALID_REPRESENT_PRODUCT_TYPE_ID.name(), ImportStockErrorCode.INVALID_REPRESENT_PRODUCT_TYPE_ID.getTextValue());
				}
				
				RepresentProductTypeAdapter representProductTypeAdapter= representProductTypeService.inquiryById(importStockRequest.getRepresentProductTypeId());
				
				if(representProductTypeAdapter != null) {
					
					double representProductTypeTotalPrice = representProductTypeAdapter.getTotalPrice();
					double totalPrice = representProductTypeAdapter.getUnitPrice() * importStockRequest.getQty();
					
					ImportStockAdapter adapter = new ImportStockAdapter();
					adapter.setDesc(importStockRequest.getDesc());
					adapter.setId(this.count());
					adapter.setTotalPrice(representProductTypeTotalPrice + totalPrice);
					adapter.setRepresentProductTypeId(importStockRequest.getRepresentProductTypeId());
					adapter.setUserId(userId);
					
					save = importStockDAO.addNewStock(adapter);
					manager.commit(status);
					return save;
				} else {
					throw new CustomException(ImportStockErrorCode.INVALID_REPRESENT_PRODUCT_TYPE_ID.name(), ImportStockErrorCode.INVALID_REPRESENT_PRODUCT_TYPE_ID.getTextValue());
				}
				
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			manager.rollback(status);
		}
		return save;
	}
	
	private int count() {
		return this.importStockDAO.countImportStock() + 1;
	}

}
