package com.estock.stockmanagement.provider.authentication.service;

import com.estock.stockmanagement.provider.authentication.data.adapter.AuthenticationAdapter;

public interface AuthenticationService {
	AuthenticationAdapter loadUserByUsername(String userName);
}
