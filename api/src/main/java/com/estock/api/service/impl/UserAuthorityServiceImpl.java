package com.estock.api.service.impl;

import com.estock.api.common.exception.CustomException;
import com.estock.api.dao.UserAuthorityDAO;
import com.estock.api.dto.UserAuthorityDTO;
import com.estock.api.service.UserAuthorityService;
import com.estock.api.util.GenerateUtil;
import com.estock.api.util.Utility;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserAuthorityServiceImpl implements UserAuthorityService {
    private String key;
    @Autowired
    private UserAuthorityDAO userAuthorityDAO;

    UserAuthorityServiceImpl() {
        this.key = GenerateUtil.key();
    }

    @Override
    public UserAuthorityDTO loadUserAuthorityByUserName(String userName) throws CustomException{
        log.info("------------ Start Service Load User Authorization By User Name ---------------");
        try{
            if (userName.equals("") || userName == null) {
                throw new CustomException("INVALID_USER_NAME", "Invalid user name.");
            }
            UserAuthorityDTO userAuthorityDTO = this.userAuthorityDAO.loadUserAuthorityByUserName(userName);
            log.info(key+"UserAuthorityDTO :"+ Utility.toJSON(userAuthorityDTO));
            return userAuthorityDTO;
        }catch (Exception e) {
            e.printStackTrace();
            log.error(key+"User Authority Service Error:",e);
            throw e;
        }
    }

    @Override
    public UserAuthorityDTO loadUserAuthorityByUserID(int userID) throws CustomException {
        log.info("------------ Start Service Load User Authorization By User ID ---------------");
        try{
            if (userID <= 0) {
                throw new CustomException("INVALID_USER_ID", "Invalid user ID.");
            }
            UserAuthorityDTO userAuthorityDTO = this.userAuthorityDAO.loadUserAuthorityByUserID(userID);
            log.info(key+"UserAuthorityDTO :"+ Utility.toJSON(userAuthorityDTO));
            return userAuthorityDTO;
        }catch (Exception e) {
            e.printStackTrace();
            log.error(key+"User Authority Service Error:",e);
            throw e;
        }
    }
}
