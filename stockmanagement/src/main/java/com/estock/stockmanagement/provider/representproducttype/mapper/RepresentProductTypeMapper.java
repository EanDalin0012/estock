package com.estock.stockmanagement.provider.representproducttype.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.estock.stockmanagement.provider.representproducttype.data.adapter.RepresentProductTypeAdapter;
import com.estock.stockmanagement.provider.representproducttype.data.request.RepresentProductTypeRequest;

@Mapper
public interface RepresentProductTypeMapper {
	public static final RepresentProductTypeMapper INSTANCE = Mappers.getMapper( RepresentProductTypeMapper.class );
	
	RepresentProductTypeAdapter addNewRepresentTypeProduct(RepresentProductTypeRequest productRequest);
}
