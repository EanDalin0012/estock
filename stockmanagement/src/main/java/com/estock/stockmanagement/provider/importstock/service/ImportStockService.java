package com.estock.stockmanagement.provider.importstock.service;

import java.util.List;

import com.estock.stockmanagement.common.exception.CustomException;
import com.estock.stockmanagement.provider.importstock.data.request.ImportStockRequest;

public interface ImportStockService {
	int addNewStock(List<ImportStockRequest> importStockRequests, int userId) throws CustomException;
}
