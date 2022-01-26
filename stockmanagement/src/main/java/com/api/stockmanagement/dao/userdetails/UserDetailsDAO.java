package com.api.stockmanagement.dao.userdetails;

import com.api.stockmanagement.provider.userdetails.data.adapter.UserAdapter;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.User;

@Mapper
public interface UserDetailsDAO {
    UserAdapter loadUserByUsername(String userName);
}
