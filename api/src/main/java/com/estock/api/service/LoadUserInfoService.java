package com.estock.api.service;

import com.estock.api.common.exception.CustomException;
import com.estock.api.dto.LoadUserInfoDTO;

public interface LoadUserInfoService {
    LoadUserInfoDTO loadUserInfo(String userName) throws CustomException;
}
