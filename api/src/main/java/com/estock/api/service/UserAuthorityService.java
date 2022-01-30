package com.estock.api.service;

import com.estock.api.common.exception.CustomException;
import com.estock.api.dto.UserAuthorityDTO;

public interface UserAuthorityService {
    UserAuthorityDTO loadUserAuthorityByUserName(String userName) throws CustomException;
    UserAuthorityDTO loadUserAuthorityByUserID(int userID) throws CustomException;
}
