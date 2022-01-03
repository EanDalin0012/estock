package com.estock.stockmanagement.provider.userinfo.service.impl;

import org.springframework.stereotype.Service;

import com.estock.stockmanagement.provider.userinfo.data.adapter.UserInfoAdapter;
import com.estock.stockmanagement.provider.userinfo.data.adapter.UserInfoAuthorityAdapter;
import com.estock.stockmanagement.provider.userinfo.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Override
	public UserInfoAdapter loadUserByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfoAuthorityAdapter loadUserAuthority(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
