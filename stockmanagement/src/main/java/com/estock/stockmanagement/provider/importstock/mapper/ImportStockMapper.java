package com.estock.stockmanagement.provider.importstock.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.estock.stockmanagement.provider.importstock.data.adapter.ImportStockAdapter;
import com.estock.stockmanagement.provider.importstock.data.request.ImportStockRequest;

@Mapper
public interface ImportStockMapper {
	public static final ImportStockMapper INSTANCE = Mappers.getMapper( ImportStockMapper.class );
	
	@Mapping( target = "importStockName", source = "name")
	ImportStockAdapter converter(ImportStockRequest importStockRequest);
}
