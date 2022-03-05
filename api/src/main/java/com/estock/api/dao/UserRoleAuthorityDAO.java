package com.estock.api.dao;

import com.estock.api.dto.UserRoleAuthorityDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserRoleAuthorityDAO {
    int addUserRoleAuthority(List<UserRoleAuthorityDTO> userRoleAuthorities);
}
