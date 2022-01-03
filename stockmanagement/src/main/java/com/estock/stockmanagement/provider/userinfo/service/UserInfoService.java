package com.estock.stockmanagement.provider.userinfo.service;

import com.estock.stockmanagement.provider.userinfo.data.adapter.UserInfoAdapter;
import com.estock.stockmanagement.provider.userinfo.data.adapter.UserInfoAuthorityAdapter;

public interface UserInfoService {
	UserInfoAdapter loadUserByUserId(int userId);
	UserInfoAuthorityAdapter loadUserAuthority(int userId);
}
