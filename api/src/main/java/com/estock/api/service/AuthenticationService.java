package com.estock.api.service;

import com.estock.api.dto.UserDTO;

public interface AuthenticationService {
    UserDTO authenticate(String userName);
}
