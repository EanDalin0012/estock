package com.estock.stockmanagement.dao.web;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.estock.stockmanagement.dto.web.WebSaleTypeDTO;

@Mapper
public interface WebSaleTypeDAO {
	int count();
	int insert(WebSaleTypeDTO webSaleTypeDTO);
	int update(WebSaleTypeDTO webSaleTypeDTO);
	int delete(WebSaleTypeDTO webSaleTypeDTO);
	List<WebSaleTypeDTO> inquiry();
}
