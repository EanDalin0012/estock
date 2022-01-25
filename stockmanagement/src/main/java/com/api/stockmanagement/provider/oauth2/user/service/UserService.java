package com.api.stockmanagement.provider.oauth2.user.service;

import com.api.stockmanagement.common.exception.CustomException;
import com.api.stockmanagement.provider.oauth2.user.data.adapter.UserAdapter;

import java.util.List;

public interface UserService {
    int addNewUser(UserAdapter userAdapter) throws CustomException;
    int enableUser(boolean enable);
    UserAdapter inquiryUserByID(int userID);
    UserAdapter inquiryUserByUserName(String userName);
    List<UserAdapter> inquiryUserByUserInfoID(int userInfoID);
}
