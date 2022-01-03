package com.estock.stockmanagement.dao.userinfo;

import org.apache.ibatis.annotations.Mapper;

import com.estock.stockmanagement.provider.userinfo.data.adapter.UserInfoAdapter;
import com.estock.stockmanagement.provider.userinfo.data.adapter.UserInfoAuthorityAdapter;

@Mapper
public interface UserInfoDAO {
	UserInfoAdapter loadUserByUserId(int userId);
	UserInfoAuthorityAdapter loadUserAuthority(int userId);
}
