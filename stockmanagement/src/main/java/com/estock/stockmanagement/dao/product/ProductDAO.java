package com.estock.stockmanagement.dao.product;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.estock.stockmanagement.provider.product.data.adapter.ProductAdapter;
import com.estock.stockmanagement.provider.product.data.adapter.UpdateStatusProductAdapter;

@Mapper
public interface ProductDAO {
	int countProduct();
	int addNewProduct(ProductAdapter productAdapter);
	int updateProduct(ProductAdapter productAdapter);
	int deleteProduct(UpdateStatusProductAdapter updateStatusProduct);
	List<ProductAdapter> inquiryAllProduct();
	ProductAdapter inquiryProductById(int productId);
	ProductAdapter inquiryProductByName(String productName);
}
