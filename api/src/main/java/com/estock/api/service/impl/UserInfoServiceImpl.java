package com.estock.api.service.impl;

import com.estock.api.common.constant.CommonConstant;
import com.estock.api.common.constant.StatusCode;
import com.estock.api.common.exception.CustomException;
import com.estock.api.dao.UserInfoDAO;
import com.estock.api.dto.UserDTO;
import com.estock.api.dto.UserInfoDTO;
import com.estock.api.dto.UserInfoDetailDTO;
import com.estock.api.service.AuthenticationService;
import com.estock.api.service.UserInfoService;
import com.estock.api.service.constant.UserInfoConstant;
import com.estock.api.util.Utility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserInfoServiceImpl  implements UserInfoService {
    @Autowired
    private AuthenticationService userDAO;
    @Autowired
    private UserInfoDAO userInfoDAO;

    @Override
    public UserInfoDTO loadUserInfoByID(int id) throws CustomException {
        log.info("-------- Start loadUser Info ByID Service --------");
        log.info("ID : "+id);
        try {
            if (id <=0 ){
                throw new CustomException(UserInfoConstant.INVALID_USER_INFO_ID.name(), UserInfoConstant.INVALID_USER_INFO_ID.getDesc());
            }
            UserInfoDTO userInfoDTO = this.userInfoDAO.loadUserByID(id);
            log.info("User Info :"+ Utility.toJSON(userInfoDTO));
            return userInfoDTO;
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public UserInfoDTO loadUserByUserName(String userName) throws CustomException {
        log.info("-------- Start UserInfo Service --------");
        log.info("User Name: "+userName);
        try {
            if (userName.equals("") || userName == null) {
                throw new CustomException(UserInfoConstant.INVALID_USER_NAME.name(), UserInfoConstant.INVALID_USER_NAME.getDesc());
            }
            UserDTO userDTO = this.userDAO.authenticate(userName);
            if (userDTO != null) {
                return this.loadUserInfoByID(userDTO.getUserInfoID());
            } else {
                throw new CustomException(UserInfoConstant.INVALID_USER_NAME.name(), UserInfoConstant.INVALID_USER_NAME.getDesc());
            }
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<UserInfoDetailDTO> inquiry() throws CustomException {
        log.info("-------- Start Service Inquiry User Info --------");
        try {
            List<UserInfoDetailDTO> lists = this.userInfoDAO.inquiry(StatusCode.DELETED.name());
            log.info("--------- User Info List <-- {} "+Utility.toJSON(lists));
            return lists;
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(CommonConstant.GENERAL_FAIL_EXCEPTION.name(), e.getMessage());
        }
    }
}
