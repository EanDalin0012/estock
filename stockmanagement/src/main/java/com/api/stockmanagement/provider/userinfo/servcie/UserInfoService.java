package com.api.stockmanagement.provider.userinfo.servcie;

import com.api.stockmanagement.common.exception.CustomException;
import com.api.stockmanagement.provider.userinfo.data.request.UserInfoRequest;

public interface UserInfoService {
    int addNewUserInfo(UserInfoRequest userInfoRequest) throws CustomException;
    int updateUserInfo(UserInfoRequest userInfoRequest) throws CustomException;
    int deleteUserInfo(int userID) throws CustomException;
    void inquiryUserInfoByID(int userID) throws CustomException;
    void inquiryUserInfoByUserName(String userName) throws CustomException;
}
