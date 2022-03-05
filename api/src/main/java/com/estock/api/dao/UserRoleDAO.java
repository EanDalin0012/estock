package com.estock.api.dao;

import com.estock.api.dto.UserRoleDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleDAO {
    int addUserRole(UserRoleDTO roleDTO);
    int count();
}
