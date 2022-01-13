package com.estock.stockmanagement.provider.importtostock.service;

import java.util.List;

import com.estock.stockmanagement.common.exception.CustomException;
import com.estock.stockmanagement.provider.importtostock.data.request.ImportToStockRequest;

public interface ImportToStockService {
	int addNewStock(List<ImportToStockRequest> importStockRequests, int userId) throws CustomException;
}
