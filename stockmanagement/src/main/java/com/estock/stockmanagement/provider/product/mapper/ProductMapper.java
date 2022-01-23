package com.estock.stockmanagement.provider.product.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.estock.stockmanagement.provider.product.data.adapter.ProductAdapter;
import com.estock.stockmanagement.provider.product.data.request.ProductRequest;
import com.estock.stockmanagement.provider.product.data.request.UpdateProductRequest;

@Mapper
public interface ProductMapper {
	
	public static final ProductMapper INSTANCE = Mappers.getMapper( ProductMapper.class );
	
	@Mapping( target = "productName", source = "name")
	ProductAdapter productAdapter(ProductRequest productRequest);
	
	@Mapping( target = "productName", source = "name")
	ProductAdapter convertUpdateProduct(UpdateProductRequest productRequest);
}
