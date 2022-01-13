package com.estock.stockmanagement.dao.importstock;


import org.apache.ibatis.annotations.Mapper;

import com.estock.stockmanagement.provider.importtostock.data.adpter.ImportToStockAdapter;

@Mapper
public interface ImportStockDAO {
	int addNewStock(ImportToStockAdapter importStockAdapter);
	int countImportStock();
}
