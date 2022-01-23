package com.estock.stockmanagement.provider.userinfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.estock.stockmanagement.common.constants.ErrorCode;
import com.estock.stockmanagement.common.exception.CustomException;
import com.estock.stockmanagement.dao.userinfo.UserInfoDAO;
import com.estock.stockmanagement.provider.userinfo.constants.UserInfoErrorCode;
import com.estock.stockmanagement.provider.userinfo.data.adapter.UserInfoAdapter;
import com.estock.stockmanagement.provider.userinfo.data.adapter.UserInfoAuthorityAdapter;
import com.estock.stockmanagement.provider.userinfo.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDAO userInfoDAO;
	
	@Override
	public UserInfoAdapter loadUserByUserId(int userId) throws CustomException {
		try {
			if(userId > 0) {
				UserInfoAdapter userInfoAdapter = this.userInfoDAO.loadUserByUserId(userId);
				return userInfoAdapter;
			} else {
				throw new CustomException(UserInfoErrorCode.INVALID_USER_ID.name(), "Invalid User Id");
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(ErrorCode.EXCEPTION_FAIL.name(), "EXCEPTION_FAIL");
		}
	}

	@Override
	public UserInfoAuthorityAdapter loadUserAuthority(int userId) throws CustomException {
		try {
			 if(userId > 0) {
				 UserInfoAuthorityAdapter userInfoAuthorityAdapter = this.userInfoDAO.loadUserAuthority(userId);
				 return userInfoAuthorityAdapter;
			 } else {
				 throw new CustomException(UserInfoErrorCode.INVALID_USER_ID.name(), "Invalid User Id");
			 }
		}catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(ErrorCode.EXCEPTION_FAIL.name(), "EXCEPTION_FAIL");
		}
	}

}
