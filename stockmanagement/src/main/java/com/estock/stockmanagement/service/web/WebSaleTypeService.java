package com.estock.stockmanagement.service.web;

import java.util.List;

import com.estock.stockmanagement.common.exception.CustomException;
import com.estock.stockmanagement.dto.web.WebSaleTypeDTO;

public interface WebSaleTypeService {
	int count();
	int insert(WebSaleTypeDTO webSaleTypeDTO) throws CustomException;
	int update(WebSaleTypeDTO webSaleTypeDTO) throws CustomException;
	int delete(WebSaleTypeDTO webSaleTypeDTO) throws CustomException;
	List<WebSaleTypeDTO> inquiry();
}
