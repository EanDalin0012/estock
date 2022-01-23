package com.estock.stockmanagement.provider.importstock.service;

import com.estock.stockmanagement.common.exception.CustomException;
import com.estock.stockmanagement.provider.importstock.data.request.ImportStockRequest;

public interface ImportStockService {
	int addNewStockName(ImportStockRequest adapter, int userId) throws CustomException;
	int deleteStockName(int id, int userId) throws CustomException;
	int countImportStock();
}
