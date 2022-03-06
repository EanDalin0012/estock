package com.estock.api.service;

import com.estock.api.common.exception.CustomException;
import com.estock.api.dto.UserRoleAuthorityDetailDTO;

import java.util.Collection;

public interface UserRoleAuthorityDetailService {
    Collection<UserRoleAuthorityDetailDTO> inquiry() throws CustomException;
}
