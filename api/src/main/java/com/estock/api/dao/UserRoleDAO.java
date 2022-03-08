package com.estock.api.dao;

import com.estock.api.dto.UserRoleDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

@Mapper
public interface UserRoleDAO {
    int addUserRole(UserRoleDTO roleDTO);
    int editUserRole(UserRoleDTO roleDTO);
    Collection<UserRoleDTO> inquiryUserRole(String Status);
    int count();
}
