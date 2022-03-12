package com.estock.api.service;

import com.estock.api.common.exception.CustomException;
import com.estock.api.dto.UserInfoDTO;
import com.estock.api.dto.UserInfoDetailDTO;

import java.util.List;

public interface UserInfoService {
    UserInfoDTO loadUserInfoByID(int id) throws CustomException;
    UserInfoDTO loadUserByUserName(String userName) throws CustomException;
    List<UserInfoDetailDTO> inquiry() throws CustomException;
}
