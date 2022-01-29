package com.estock.api.service.impl;

import com.estock.api.dao.AuthenticationDAO;
import com.estock.api.dto.UserDTO;
import com.estock.api.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private AuthenticationDAO authenticationDAO;

    @Override
    public UserDTO authenticate(String userName) {
        return authenticationDAO.getUserByName(userName);
    }
}
