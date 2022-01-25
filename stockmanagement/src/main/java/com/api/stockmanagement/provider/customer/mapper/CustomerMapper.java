package com.api.stockmanagement.provider.customer.mapper;

import com.api.stockmanagement.provider.customer.data.adapter.CustomerAdapter;
import com.api.stockmanagement.provider.customer.data.request.CustomerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    public static final CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping( target = "id", source = "id")
    CustomerAdapter convert(CustomerRequest customerRequest);
}
