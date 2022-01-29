package com.api.stockmanagement.core.service;

import com.api.stockmanagement.common.dto.JsonObj;

public interface DefaultAuthenticationProviderService {
    JsonObj getUserObjectByName(JsonObj param) throws Exception;
    JsonObj authenticate(JsonObj jsonObject);
}
