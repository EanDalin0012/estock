package com.estock.api.dao;

import com.estock.api.common.exception.CustomException;
import com.estock.api.dto.UserInfoDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoDAO {
    UserInfoDTO loadUserByID(int id);
}
