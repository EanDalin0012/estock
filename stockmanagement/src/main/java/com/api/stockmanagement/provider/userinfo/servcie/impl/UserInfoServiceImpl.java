package com.api.stockmanagement.provider.userinfo.servcie.impl;

import com.api.stockmanagement.common.exception.CustomException;
import com.api.stockmanagement.provider.userinfo.data.adapter.UserInfoAdapter;
import com.api.stockmanagement.provider.userinfo.data.request.UserInfoRequest;
import com.api.stockmanagement.provider.userinfo.mapper.UserInfoMapper;
import com.api.stockmanagement.provider.userinfo.servcie.UserInfoService;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {


    @Override
    public int addNewUserInfo(UserInfoRequest userInfoRequest) throws CustomException {
        try {
            UserInfoAdapter userInfoAdapter = UserInfoMapper.INSTANCE.convert(userInfoRequest);
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return 0;
    }

    @Override
    public int updateUserInfo(UserInfoRequest userInfoRequest) throws CustomException {
        try {
            UserInfoAdapter userInfoAdapter = UserInfoMapper.INSTANCE.convert(userInfoRequest);
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return 0;
    }

    @Override
    public int deleteUserInfo(int userID) throws CustomException {
        return 0;
    }

    @Override
    public void inquiryUserInfoByID(int userID) throws CustomException {

    }

    @Override
    public void inquiryUserInfoByUserName(String userName) throws CustomException {

    }
}
