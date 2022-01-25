package com.api.stockmanagement.dao.userinfo;

import com.api.stockmanagement.provider.userinfo.data.adapter.UserInfoAdapter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserInfoDAO {
    int addNewUserInfo(UserInfoAdapter userInfoAdapter);
    int updateUserInfo(UserInfoAdapter userInfoAdapter);
    int deleteUserInfo(@Param("userID") int userID,@Param("status") String status);
    UserInfoAdapter inquiryUserInfoByID(int userID);
    UserInfoAdapter inquiryUserInfoByUserName(String userName);
    List<UserInfoAdapter> inquiryUserInfo(String status);
}
