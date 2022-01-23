package com.estock.stockmanagement.provider.product.service;

import java.util.List;

import com.estock.stockmanagement.common.exception.CustomException;
import com.estock.stockmanagement.provider.product.data.adapter.ProductAdapter;
import com.estock.stockmanagement.provider.product.data.request.ProductRequest;
import com.estock.stockmanagement.provider.product.data.request.UpdateProductRequest;

public interface ProductService {
	int countProduct();
	int addNewProduct(ProductRequest productRequest) throws CustomException;
	int updateProduct(UpdateProductRequest updateProductRequest)  throws CustomException;
	int deleteProduct(int productId)  throws CustomException;
	List<ProductAdapter> inquiryAllProduct();
	ProductAdapter inquiryProductById(int productId)  throws CustomException;
}
