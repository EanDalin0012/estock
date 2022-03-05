package com.estock.api.service;

import com.estock.api.common.exception.CustomException;
import com.estock.api.dto.UserRoleDTO;
import com.estock.api.vo.request.UserRoleRequestVO;

import java.util.Collection;
import java.util.List;

public interface RoleService {
    List<UserRoleDTO> userRoles() throws CustomException;
    int save(UserRoleRequestVO userRoleRequestVO) throws CustomException;
    int edit(UserRoleRequestVO userRoleRequestVO) throws CustomException;
    Collection<UserRoleDTO> inquiryUserRole() throws CustomException;
}
