package com.api.stockmanagement.dao.oauth2;

import com.api.stockmanagement.provider.oauth2.user.data.adapter.UserAdapter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDAO {
    int addNewUser(UserAdapter userAdapter);
    int enableUser(boolean enable);
    UserAdapter inquiryUserByID(int userID);
    UserAdapter inquiryUserByUserName(String userName);
    List<UserAdapter> inquiryUserByUserInfoID(int userInfoID);
}
