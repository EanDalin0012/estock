package com.estock.stockmanagement.provider.representproducttype.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.estock.stockmanagement.common.exception.CustomException;
import com.estock.stockmanagement.dao.representtypeproduct.RepresentTypeProductDAO;
import com.estock.stockmanagement.provider.representproducttype.data.adapter.RepresentProductTypeAdapter;
import com.estock.stockmanagement.provider.representproducttype.data.request.RepresentProductTypeRequest;
import com.estock.stockmanagement.provider.representproducttype.mapper.RepresentProductTypeMapper;
import com.estock.stockmanagement.provider.representproducttype.service.RepresentProductTypeService;

@Service
public class RepresentProductTypeServiceImpl implements RepresentProductTypeService {

	@Autowired
	private RepresentTypeProductDAO representTypeProductDAO;
	
	@Override
	public int addNewRepresentTypeProduct(List<RepresentProductTypeRequest> representTypeProductRequests, int userId) throws CustomException {
		try {
			if(representTypeProductRequests.size() > 0) {
				for (RepresentProductTypeRequest representTypeProductRequest : representTypeProductRequests) {
					if(representTypeProductRequest.getProductId() <= 0) {
						throw new CustomException("", "");
					}
					RepresentProductTypeAdapter adapter = RepresentProductTypeMapper.INSTANCE.addNewRepresentTypeProduct(representTypeProductRequest);
					adapter.setId(this.count());
					this.representTypeProductDAO.addNewRepresentTypeProduct(adapter);
				}
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	private int count() {
		return this.representTypeProductDAO.countRepresentTypeProduct() + 1;
	}

}
