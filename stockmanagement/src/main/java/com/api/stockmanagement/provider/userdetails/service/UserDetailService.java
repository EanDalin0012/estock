package com.api.stockmanagement.provider.userdetails.service;

import com.api.stockmanagement.common.exception.CustomException;
import com.api.stockmanagement.provider.userdetails.data.adapter.UserAdapter;
import org.springframework.security.core.userdetails.User;

public interface UserDetailService {
    UserAdapter inquiryUserByUsername(String userName) throws CustomException;
}
