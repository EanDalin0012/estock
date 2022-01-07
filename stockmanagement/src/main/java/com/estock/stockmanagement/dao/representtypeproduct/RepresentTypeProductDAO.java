package com.estock.stockmanagement.dao.representtypeproduct;

import org.apache.ibatis.annotations.Mapper;

import com.estock.stockmanagement.provider.representproducttype.data.adapter.RepresentProductTypeAdapter;

@Mapper
public interface RepresentTypeProductDAO {
	int addNewRepresentTypeProduct(RepresentProductTypeAdapter representTypeProductAdapter);
	int countRepresentTypeProduct();
}
