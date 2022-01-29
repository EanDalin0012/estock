package com.estock.api.dao;

import com.estock.api.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthenticationDAO {
    UserDTO getUserByName(String userName);
}
