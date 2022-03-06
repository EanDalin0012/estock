package com.estock.api.dao;

import com.estock.api.dto.UserRoleAuthorityDetailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;

@Mapper
public interface UserRoleAuthorityDetailDAO {
    Collection<UserRoleAuthorityDetailDTO> inquiry(String status);
}
