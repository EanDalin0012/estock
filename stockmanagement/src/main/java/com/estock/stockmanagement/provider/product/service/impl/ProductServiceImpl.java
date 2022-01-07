package com.estock.stockmanagement.provider.product.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estock.stockmanagement.common.constants.StatusCode;
import com.estock.stockmanagement.common.exception.CustomException;
import com.estock.stockmanagement.dao.product.ProductDAO;
import com.estock.stockmanagement.provider.product.constants.ProductErrorCode;
import com.estock.stockmanagement.provider.product.data.adapter.ProductAdapter;
import com.estock.stockmanagement.provider.product.data.adapter.UpdateStatusProductAdapter;
import com.estock.stockmanagement.provider.product.data.request.ProductRequest;
import com.estock.stockmanagement.provider.product.data.request.UpdateProductRequest;
import com.estock.stockmanagement.provider.product.mapper.ProductMapper;
import com.estock.stockmanagement.provider.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public int addNewProduct(ProductRequest productRequest) throws CustomException {
		
		if(productRequest.getName() == null || productRequest.getName() == "") {
			throw new CustomException(ProductErrorCode.INVALID_PRODUCT_NAME.name(), "");
		}
		
		ProductAdapter data = this.productDAO.inquiryProductByName(productRequest.getName());
		if(data != null) {
			throw new CustomException(ProductErrorCode.PRODUCT_NAME_EXETED.name(), "Product Name Exited");
		}
		
		ProductAdapter productAdapter = ProductMapper.INSTANCE.productAdapter(productRequest);
		productAdapter.setId(this.countProduct());
		int save = this.productDAO.addNewProduct(productAdapter);
		
		if(save > 0)  {
			return save;
		}
		return 0;
	}

	@Override
	public int updateProduct(UpdateProductRequest updateProductRequest) throws CustomException {
		
		if(updateProductRequest.getId() <= 0) {
			throw new CustomException(ProductErrorCode.INVALID_PRODUCT_ID.name(), "Invalid Product ID");
		}
		
		if (updateProductRequest.getName() == null || updateProductRequest.getName() == "") {
			throw new CustomException(ProductErrorCode.INVALID_PRODUCT_NAME.name(), "Invalid Product ID");
		}
		
		ProductAdapter productAdapter = ProductMapper.INSTANCE.convertUpdateProduct(updateProductRequest);
		int update = this.productDAO.updateProduct(productAdapter);
		
		return update;
	}

	@Override
	public int deleteProduct(int productId) throws CustomException {
		try {
			if(productId <= 0) {
				throw new CustomException(ProductErrorCode.INVALID_PRODUCT_ID.name(), "Invalid Product Id");
			}
			
			UpdateStatusProductAdapter statusProductAdapter = new UpdateStatusProductAdapter();
			statusProductAdapter.setId(productId);
			statusProductAdapter.setStatus(StatusCode.DELETE.name());
			int deleteProduct = this.productDAO.deleteProduct(statusProductAdapter);
			return deleteProduct;
			
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<ProductAdapter> inquiryAllProduct() {
		try {
			List<ProductAdapter> datas = this.productDAO.inquiryAllProduct();
			return datas;
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public ProductAdapter inquiryProductById(int productId) throws CustomException {
		try {
			if (productId <= 0) {
				throw new CustomException(ProductErrorCode.INVALID_PRODUCT_ID.name(), "Invalid Product ID");
			}
			ProductAdapter productAdapter = this.inquiryProductById(productId);
			return productAdapter;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public int countProduct() {
		return this.productDAO.countProduct() + 1;
	}

}
