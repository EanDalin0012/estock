package com.estock.stockmanagement.provider.stock.mapper;

import com.estock.stockmanagement.provider.stock.data.adapter.StockAdapter;
import com.estock.stockmanagement.provider.stock.data.request.StockRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StockMapper {
    public static final StockMapper INSTANCE = Mappers.getMapper( StockMapper.class );
//    @Mapping( target = "productName", source = "name")
    StockAdapter convert(StockRequest stockRequest);
}
