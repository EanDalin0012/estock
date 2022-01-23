package com.estock.stockmanagement.provider.importtostock.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import com.estock.stockmanagement.common.exception.CustomException;
import com.estock.stockmanagement.dao.importtostock.ImportToStockDAO;
import com.estock.stockmanagement.provider.importtostock.constants.ImportToStockErrorCode;
import com.estock.stockmanagement.provider.importtostock.data.adpter.ImportToStockAdapter;
import com.estock.stockmanagement.provider.importtostock.data.request.ImportToStockRequest;
import com.estock.stockmanagement.provider.importtostock.service.ImportToStockService;
import com.estock.stockmanagement.provider.representproducttype.data.adapter.RepresentProductTypeAdapter;
import com.estock.stockmanagement.provider.representproducttype.service.RepresentProductTypeService;

@Service
public class ImportToStockServiceImpl implements ImportToStockService {

	@Autowired
	private RepresentProductTypeService representProductTypeService;
	@Autowired
	private ImportToStockDAO importStockDAO;
	@Autowired
	private PlatformTransactionManager manager;
	
	@Override
	public int addNewStock(List<ImportToStockRequest> importStockRequests, int userId) throws CustomException {
		int save = 0;
		TransactionStatus status = manager.getTransaction(new DefaultTransactionDefinition());
		try {
			for (ImportToStockRequest importStockRequest : importStockRequests) {
				
				if(importStockRequest.getRepresentProductTypeId() <= 0) {
					throw new CustomException(ImportToStockErrorCode.INVALID_REPRESENT_PRODUCT_TYPE_ID.name(), ImportToStockErrorCode.INVALID_REPRESENT_PRODUCT_TYPE_ID.getTextValue());
				}
				
				RepresentProductTypeAdapter representProductTypeAdapter= representProductTypeService.inquiryById(importStockRequest.getRepresentProductTypeId());
				
				if(representProductTypeAdapter != null) {
					
					double representProductTypeTotalPrice = representProductTypeAdapter.getTotalPrice();
					double totalPrice = representProductTypeAdapter.getUnitPrice() * importStockRequest.getQty();
					int totalQty = representProductTypeAdapter.getQty() + importStockRequest.getQty();
					
					ImportToStockAdapter adapter = new ImportToStockAdapter();
					adapter.setDesc(importStockRequest.getDesc());
					adapter.setId(this.count());
					adapter.setTotalPrice(representProductTypeTotalPrice + totalPrice);
					adapter.setRepresentProductTypeId(importStockRequest.getRepresentProductTypeId());
					adapter.setUserId(userId);
					adapter.setTotalQty(totalQty);
					
					save = importStockDAO.addNewStock(adapter);
					manager.commit(status);
					return save;
				} else {
					throw new CustomException(ImportToStockErrorCode.INVALID_REPRESENT_PRODUCT_TYPE_ID.name(), ImportToStockErrorCode.INVALID_REPRESENT_PRODUCT_TYPE_ID.getTextValue());
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
