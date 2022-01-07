package com.estock.stockmanagement.provider.authentication.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.estock.stockmanagement.dao.authentication.AuthenticationDAO;
import com.estock.stockmanagement.provider.authentication.data.adapter.AuthenticationAdapter;
import com.estock.stockmanagement.provider.authentication.service.AuthenticationService;
import com.estock.stockmanagement.util.EUtil;
import org.apache.log4j.Logger;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	static Logger log = Logger.getLogger(AuthenticationServiceImpl.class.getName());
	
	@Autowired
	private AuthenticationDAO authenticationDAO;
	
	@Override
	public AuthenticationAdapter loadUserByUsername(String userName) {
		try {
			if(userName != null || userName != "") {
				AuthenticationAdapter authenticationAdapter = this.authenticationDAO.loadUserByUsername(userName);
				log.info(" ======== AuthenticationService Data :"+EUtil.toJSON(authenticationAdapter));
				return authenticationAdapter;
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
