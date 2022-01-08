package com.estock.stockmanagement.dao.representtypeproduct;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.estock.stockmanagement.provider.representproducttype.data.adapter.RepresentProductTypeAdapter;

@Mapper
public interface RepresentTypeProductDAO {
	int addNewRepresentTypeProduct(RepresentProductTypeAdapter representTypeProductAdapter);
	int countRepresentTypeProduct();
	RepresentProductTypeAdapter inquiryById(@Param("id") int id, @Param("status") String status);
	List<RepresentProductTypeAdapter> inquiryAll(String status);
}
