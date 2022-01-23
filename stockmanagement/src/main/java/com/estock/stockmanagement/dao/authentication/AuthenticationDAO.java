package com.estock.stockmanagement.dao.authentication;

import org.apache.ibatis.annotations.Mapper;

import com.estock.stockmanagement.provider.authentication.data.adapter.AuthenticationAdapter;

@Mapper
public interface AuthenticationDAO {
	AuthenticationAdapter loadUserByUsername(String userName);
}
