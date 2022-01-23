package com.estock.stockmanagement.provider.importstock.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.estock.stockmanagement.common.constants.ErrorCode;
import com.estock.stockmanagement.common.constants.StatusCode;
import com.estock.stockmanagement.common.exception.CustomException;
import com.estock.stockmanagement.dao.importtostock.ImportToStockDAO;
import com.estock.stockmanagement.provider.importstock.constants.ImportStockErrorCode;
import com.estock.stockmanagement.provider.importstock.data.adapter.ImportStockAdapter;
import com.estock.stockmanagement.provider.importstock.data.request.ImportStockRequest;
import com.estock.stockmanagement.provider.importstock.mapper.ImportStockMapper;
import com.estock.stockmanagement.provider.importstock.service.ImportStockService;
import com.estock.stockmanagement.util.Utility;

@Service
public class ImportStockServiceImpl implements ImportStockService {
	private static Logger log = Logger.getLogger(ImportStockServiceImpl.class.getName());
	
	@Autowired
	private ImportToStockDAO importStockDAO;
	
	public ImportStockServiceImpl() {
		
	}
	
	@Override
	public int addNewStockName(ImportStockRequest request, int userId) throws CustomException {
		log.info("========= Start Add New Import Stock Service =========");
		try {
			
			if(request.getName() == null || request.getName().trim().equals("")) {
				throw new CustomException(ImportStockErrorCode.INVALID_IMPORT_STOCK_NAME.name(), ImportStockErrorCode.INVALID_IMPORT_STOCK_NAME.getTextValue());
			} else if (userId <=0 ) {
				throw new CustomException(ErrorCode.INVALID_USER_ID.name(), ErrorCode.INVALID_USER_ID.getTextValue());
			}
			
			log.info("ImportStockRequest Data :"+Utility.toJSON(request));
			ImportStockAdapter adapter = ImportStockMapper.INSTANCE.converter(request);
			adapter.setId(this.countImportStock());
			adapter.setUserId(userId);
			adapter.setStutas(StatusCode.INSERT.name());
			log.info("ImportStockAdapter Data :"+Utility.toJSON(adapter));
		
			int save = this.importStockDAO.addNewStockName(adapter);
			log.info("Save ImportStock Data :"+save);
			return save;
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int deleteStockName(int id, int userId) throws CustomException {
		log.info("========= Start Delete Import Stock Service =========");
		try {
			log.info("========= Import Stock ID : "+id);
			log.info("========= User ID : "+userId);
			if(id <= 0) {
				throw new CustomException(ImportStockErrorCode.INVALID_IMPORT_STOCK_ID.name(), ImportStockErrorCode.INVALID_IMPORT_STOCK_ID.getTextValue());
			}  else if (userId <=0 ) {
				throw new CustomException(ErrorCode.INVALID_USER_ID.name(), ErrorCode.INVALID_USER_ID.getTextValue());
			}
			int delete = this.importStockDAO.deleteStockName(id, userId, StatusCode.DELETE.name());
			log.info("========= Start Delete Import Stock Data : "+delete);
			return delete;
		}catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(ErrorCode.EXCEPTION_FAIL.name(), e);
		}
	}

	@Override
	public int countImportStock() {
		return this.importStockDAO.countImportStock() + 1;
	}

}
