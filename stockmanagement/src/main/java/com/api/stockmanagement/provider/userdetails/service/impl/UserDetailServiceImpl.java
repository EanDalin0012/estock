package com.api.stockmanagement.provider.userdetails.service.impl;

import com.api.stockmanagement.common.exception.CustomException;
import com.api.stockmanagement.dao.userdetails.DetailUserDAO;
import com.api.stockmanagement.provider.userdetails.constant.UserDetailConstant;
import com.api.stockmanagement.provider.userdetails.data.adapter.AuthorityAdapter;
import com.api.stockmanagement.provider.userdetails.data.adapter.UserAdapter;
import com.api.stockmanagement.provider.userdetails.service.UserDetailService;
import com.api.stockmanagement.util.Utility;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDetailServiceImpl implements UserDetailsService, UserDetailService {
    private static Logger log = Logger.getLogger(UserDetailServiceImpl.class.getName());

    @Autowired
    private DetailUserDAO userDetailsDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserAdapter userAdapter = this.inquiryUserByUsername(username);

            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (AuthorityAdapter authorityAdapter:userAdapter.getAuthorities()) {
                grantedAuthorities.add(new GrantedAuthority() {
                    @Override
                    public String getAuthority() {
                        return authorityAdapter.getName();
                    }
                });
            }

            UserDetails userDetails = User.builder()
                    .username(userAdapter.getUserName())
                    .password(userAdapter.getPassword())
                    .authorities(grantedAuthorities)
                    .build();
            return userDetails;

//            UserDetails user = new User(userAdapter.getUserName(), userAdapter.getPassword(),true, false , false, false, grantedAuthorities);
//            return user;
        }catch (Exception e) {
            throw e;
        } catch (CustomException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserAdapter inquiryUserByUsername(String username) throws CustomException {
        try {
            if (username.equals("") || username == null) {
                throw new CustomException(UserDetailConstant.INVALID_USER_NAME.name(), UserDetailConstant.INVALID_USER_NAME.getDesc());
            }
            UserAdapter userAdapter = this.userDetailsDAO.inquiryUserByUsername(username);

            log.info("UserAdapter :"+ Utility.toJSON(userAdapter));
            if (userAdapter == null) {
                throw new CustomException(UserDetailConstant.USER_NOT_FOUND.name(), UserDetailConstant.USER_NOT_FOUND.getDesc());
            }
            return userAdapter;
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
