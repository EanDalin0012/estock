package com.estock.stockmanagement.dao.importtostock;


import org.apache.ibatis.annotations.Mapper;

import com.estock.stockmanagement.provider.importtostock.data.adpter.ImportToStockAdapter;

@Mapper
public interface ImportToStockDAO {
	int addNewStock(ImportToStockAdapter importStockAdapter);
	int countImportStock();
}
