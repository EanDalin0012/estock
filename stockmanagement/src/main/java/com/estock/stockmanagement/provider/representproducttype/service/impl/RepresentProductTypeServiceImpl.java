package com.estock.stockmanagement.provider.representproducttype.service.impl;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.estock.stockmanagement.common.constants.StatusCode;
import com.estock.stockmanagement.common.exception.CustomException;
import com.estock.stockmanagement.common.util.GenerateRandomKeyUtil;
import com.estock.stockmanagement.dao.representtypeproduct.RepresentTypeProductDAO;
import com.estock.stockmanagement.provider.representproducttype.constants.RepresentProductTypeErrorCode;
import com.estock.stockmanagement.provider.representproducttype.data.adapter.RepresentProductTypeAdapter;
import com.estock.stockmanagement.provider.representproducttype.data.request.RepresentProductTypeRequest;
import com.estock.stockmanagement.provider.representproducttype.mapper.RepresentProductTypeMapper;
import com.estock.stockmanagement.provider.representproducttype.service.RepresentProductTypeService;

@Service
public class RepresentProductTypeServiceImpl implements RepresentProductTypeService {
	static Logger log = Logger.getLogger(RepresentProductTypeServiceImpl.class.getName());
	private String key;
	
	@Autowired
	private RepresentTypeProductDAO representTypeProductDAO;
	@Autowired
	private PlatformTransactionManager manager;
	
	
	
	public RepresentProductTypeServiceImpl() {
		this.key = GenerateRandomKeyUtil.key();
	}
	
	@Override
	public int addNewRepresentTypeProduct(List<RepresentProductTypeRequest> representTypeProductRequests, int userId) throws CustomException {
		TransactionStatus status = manager.getTransaction(new DefaultTransactionDefinition());
		int save = 0;
		try {
			if(representTypeProductRequests.size() > 0) {
				for (RepresentProductTypeRequest representTypeProductRequest : representTypeProductRequests) {
					log.info(key +"=== RepresentProductTypeRequest Data :"+representTypeProductRequest.toString());
					if(representTypeProductRequest.getProductId() <= 0) {
						throw new CustomException(RepresentProductTypeErrorCode.INVALID_PRODUCT_ID.name(), RepresentProductTypeErrorCode.INVALID_PRODUCT_ID.getTextValue());
					} else if (representTypeProductRequest.getQty() <= 0) {
						throw new CustomException(RepresentProductTypeErrorCode.INVALID_QTY.name(), RepresentProductTypeErrorCode.INVALID_QTY.getTextValue());
					}
					
					double totalPrice = representTypeProductRequest.getQty() * representTypeProductRequest.getUnitPrice();
					
					RepresentProductTypeAdapter adapter = RepresentProductTypeMapper.INSTANCE.addNewRepresentTypeProduct(representTypeProductRequest);
					adapter.setId(this.count());
					adapter.setTotalPrice(totalPrice);
					adapter.setUserId(userId);
					adapter.setStutas(StatusCode.INSERT.name());
					log.info(key +"=== RepresentProductTypeAdapter Data :"+adapter.toString());
					
					save = this.representTypeProductDAO.addNewRepresentTypeProduct(adapter);
					log.info(key +"=== save :"+save);
				}
				manager.commit(status);
				return save;
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
			manager.rollback(status);
		}
		return save;
	}
	
	private int count() {
		return this.representTypeProductDAO.countRepresentTypeProduct() + 1;
	}

	@Override
	public RepresentProductTypeAdapter inquiryById(int id) throws CustomException {
		try {
			if(id <= 0) {
				throw new CustomException(RepresentProductTypeErrorCode.INVALID_REPRESENT_PRODUCT_T_ID.name(), RepresentProductTypeErrorCode.INVALID_REPRESENT_PRODUCT_T_ID.getTextValue());
			}
			RepresentProductTypeAdapter adapter = this.representTypeProductDAO.inquiryById(id, StatusCode.DELETE.name());
			return adapter;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<RepresentProductTypeAdapter> inquiryAll() {
		try {
			List<RepresentProductTypeAdapter> datas = this.representTypeProductDAO.inquiryAll(StatusCode.DELETE.name());
			return datas;
		}catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}
		return null;
	}

}
