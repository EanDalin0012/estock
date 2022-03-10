package com.estock.api.service;

import com.estock.api.common.exception.CustomException;
import com.estock.api.dto.UserRoleDTO;
import com.estock.api.vo.request.UserRoleRequestVO;

import java.util.Collection;
import java.util.List;

public interface UserRoleService {
    List<UserRoleDTO> userRoles() throws CustomException;
    int save(UserRoleRequestVO userRoleRequestVO, int userId) throws CustomException;
    int edit(UserRoleRequestVO userRoleRequestVO, int userId) throws CustomException;
    int delete(int roleId) throws CustomException;
    Collection<UserRoleDTO> inquiryUserRole() throws CustomException;
}
