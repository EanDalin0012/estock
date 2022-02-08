package com.estock.api.service;

import com.estock.api.common.exception.CustomException;
import com.estock.api.dto.UserInfoDTO;

public interface UserInfoService {
    UserInfoDTO loadUserInfoByID(int id) throws CustomException;
    UserInfoDTO loadUserByUserName(String userName) throws CustomException;
}
