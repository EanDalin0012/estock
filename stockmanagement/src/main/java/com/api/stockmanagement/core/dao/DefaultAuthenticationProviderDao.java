package com.api.stockmanagement.core.dao;

import com.api.stockmanagement.common.dto.JsonObj;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DefaultAuthenticationProviderDao {
    JsonObj getUserByName(JsonObj param);
    JsonObj authenticate(JsonObj jsonObject);
}
