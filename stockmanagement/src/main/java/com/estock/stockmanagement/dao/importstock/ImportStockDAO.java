package com.estock.stockmanagement.dao.importstock;


import org.apache.ibatis.annotations.Mapper;
import com.estock.stockmanagement.provider.importstock.data.adpter.ImportStockAdapter;

@Mapper
public interface ImportStockDAO {
	int addNewStock(ImportStockAdapter importStockAdapter);
	int countImportStock();
}
