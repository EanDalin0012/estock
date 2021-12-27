package com.estock.stockmanagement.service.impl.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.estock.stockmanagement.common.exception.CustomException;
import com.estock.stockmanagement.dao.web.WebSaleTypeDAO;
import com.estock.stockmanagement.dto.web.WebSaleTypeDTO;
import com.estock.stockmanagement.service.web.WebSaleTypeService;

@Service
public class WebSaleTypeServiceImpl implements WebSaleTypeService{

	@Autowired
	private WebSaleTypeDAO webSaleTypeDAO;
	
	@Override
	public int insert(WebSaleTypeDTO webSaleTypeDTO) throws CustomException {
		if(webSaleTypeDTO.getSaleType().equals("") || webSaleTypeDTO == null) {
			throw new CustomException("invalidSaleType", "SaleType is emty");
		}
		webSaleTypeDTO.setId(this.count());
		return this.webSaleTypeDAO.insert(webSaleTypeDTO);
	}

	@Override
	public int update(WebSaleTypeDTO webSaleTypeDTO) {
		// TODO Auto-generated method stub
		return this.webSaleTypeDAO.update(webSaleTypeDTO);
	}

	@Override
	public int delete(WebSaleTypeDTO webSaleTypeDTO) {
		// TODO Auto-generated method stub
		return this.webSaleTypeDAO.delete(webSaleTypeDTO);
	}

	@Override
	public List<WebSaleTypeDTO> inquiry() {
		// TODO Auto-generated method stub
		return this.webSaleTypeDAO.inquiry();
	}

	@Override
	public int count() {
		return this.webSaleTypeDAO.count() + 1;
	}

}
