package com.estock.stockmanagement.mapstruct.web;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.estock.stockmanagement.dto.web.WebSaleTypeDTO;
import com.estock.stockmanagement.vo.request.web.WebSaleTypeRequestVO;

@Mapper
public interface WebSaleTypeRequestVOMapStruct {
	public static final WebSaleTypeRequestVOMapStruct INSTANCE = Mappers.getMapper( WebSaleTypeRequestVOMapStruct.class );
//	@Mapping( target = "authoritiesVO", source = "authorities")
	WebSaleTypeDTO webSaleTypeDTO(WebSaleTypeRequestVO webSaleTypeRequestVO);
}
