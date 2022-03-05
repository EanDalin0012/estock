package com.estock.api.dao;

import com.estock.api.dto.LoadUserInfoDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoadUserInfoDAO {
    LoadUserInfoDTO loadUserInfo(String userName);
}
