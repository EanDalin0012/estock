package com.estock.api.dao;


import com.estock.api.dto.UserInfoDTO;
import com.estock.api.dto.UserInfoDetailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoDAO {
    UserInfoDTO loadUserByID(int id);
    List<UserInfoDetailDTO> inquiry(String status);
}
