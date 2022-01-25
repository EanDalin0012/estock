package com.api.stockmanagement.provider.oauth2.user.service.impl;

import com.api.stockmanagement.common.exception.CustomException;
import com.api.stockmanagement.dao.oauth2.UserDAO;
import com.api.stockmanagement.provider.customer.service.impl.CustomerServiceImpl;
import com.api.stockmanagement.provider.oauth2.user.constant.UserConstant;
import com.api.stockmanagement.provider.oauth2.user.data.adapter.UserAdapter;
import com.api.stockmanagement.provider.oauth2.user.service.UserService;
import com.api.stockmanagement.util.Utility;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {
    private static Logger log = Logger.getLogger(UserServiceImpl.class.getName());

    @Autowired
    private UserDAO userDAO;

    @Override
    public int addNewUser(UserAdapter userAdapter) throws CustomException {
        log.info("========== Start Add New User ==========");
        try {
            log.info("UserAdapter Data :"+ Utility.toJSON(userAdapter));

            if (userAdapter.getUserName().isEmpty() || userAdapter.getUserName() == null) {
                throw new CustomException(UserConstant.INVALID_USER_NAME.name(), UserConstant.INVALID_USER_NAME.getDesc());
            }
            if (userAdapter.getPassword().isEmpty() || userAdapter.getPassword() == null) {
                throw new CustomException(UserConstant.INVALID_PASSWORD.name(), UserConstant.INVALID_PASSWORD.getDesc());
            }
            if (userAdapter.getRoleID() <= 0) {
                throw new CustomException(UserConstant.INVALID_ROLE_ID.name(), UserConstant.INVALID_ROLE_ID.getDesc());
            }
            if (userAdapter.getUserInfoID() <0 ) {
                throw new CustomException(UserConstant.INVALID_USER_INFO_ID.name(), UserConstant.INVALID_USER_INFO_ID.getDesc());
            }
            int save = this.userDAO.addNewUser(userAdapter);
            log.info("UserAdapter Data Save :"+ save);
            return save;
        }catch (Exception e) {
            log.error("Error Service UserServiceImpl :"+e);
            throw e;
        }
    }

    @Override
    public int enableUser(boolean enable) {
        return 0;
    }

    @Override
    public UserAdapter inquiryUserByID(int userID) {
        return null;
    }

    @Override
    public UserAdapter inquiryUserByUserName(String userName) {
        return null;
    }

    @Override
    public List<UserAdapter> inquiryUserByUserInfoID(int userInfoID) {
        return null;
    }
}
