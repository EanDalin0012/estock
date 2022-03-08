package com.estock.api.dao;

import com.estock.api.dto.UserRoleAuthorityDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.Collection;

@Mapper
public interface UserRoleAuthorityDAO {
    int addUserRoleAuthority(Collection<UserRoleAuthorityDTO> userRoleAuthorities);
    int deleteUserRoleAuthority(int roleId);
}
