package com.estock.stockmanagement.provider.representproducttype.service;

import java.util.List;

import com.estock.stockmanagement.common.exception.CustomException;
import com.estock.stockmanagement.provider.representproducttype.data.request.RepresentProductTypeRequest;

public interface RepresentProductTypeService {
	int addNewRepresentTypeProduct(List<RepresentProductTypeRequest> representTypeProductRequests, int userId) throws CustomException;
}
