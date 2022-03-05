package com.estock.api.mapper;

import com.estock.api.dto.UserRoleDTO;
import com.estock.api.vo.request.UserRoleRequestVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserRoleMapper {
    UserRoleMapper INSTANCE = Mappers.getMapper(UserRoleMapper.class);
    @Mapping(source = "id", target = "id")
    @Mapping(source = "role", target = "role")
    UserRoleDTO userRoleMapper(UserRoleRequestVO userRoleRequestVO);
}
