package com.api.stockmanagement.core.service.impl;

import com.api.stockmanagement.common.dto.JsonObj;
import com.api.stockmanagement.common.dto.JsonObjArray;
import com.api.stockmanagement.core.dao.DefaultAuthenticationProviderDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class DefaultAuthenticationProviderService implements com.api.stockmanagement.core.service.DefaultAuthenticationProviderService, UserDetailsService {
    static Logger log = Logger.getLogger(DefaultAuthenticationProviderService.class.getName());

//    @Autowired
//    OauthAccessTokenService oauthAccessTokenService;

//    @Autowired
//    private TokenStore tokenStore;
//    @Inject
//    private ApplicationEventPublisher eventPublisher;

    final DefaultAuthenticationProviderDao defaultAuthenticationProviderDao;
    DefaultAuthenticationProviderService(DefaultAuthenticationProviderDao defaultAuthenticationProviderDao) {
        this.defaultAuthenticationProviderDao = defaultAuthenticationProviderDao;

    }

    @Override
    public JsonObj getUserObjectByName(JsonObj param) throws Exception {
//        removeTokenAndDeviceInfo(param);
        return defaultAuthenticationProviderDao.getUserByName(param);
    }

    @Override
    public JsonObj authenticate(JsonObj jsonObject) {
        log.info("authenticate login");

        String userName = jsonObject.getString("userName");

        // Keep Device info when user login
//        if(jsonObject.getJsonObject("deviceInfo") != null) {
//            JsonObj deviceInfo = jsonObject.getJsonObject("deviceInfo");
//            deviceInfo.setString("userName", userName);
//            eventPublisher.publishEvent(new HistoryUserLoginEvent(deviceInfo));
//        }
//
//        removeToken(jsonObject);
        return defaultAuthenticationProviderDao.authenticate(jsonObject);
    }

//    private void removeToken(JsonObject jsonObject) {
//        log.info("removeToken");
//        JsonObject object = this.oauthAccessTokenService.getClientIDUserName(jsonObject);
//        if (object !=null) {
//            String clientId = object.getString("clientID");
//            String userName = jsonObject.getString("userName");
//            Collection<OAuth2AccessToken> data =  tokenStore.findTokensByClientIdAndUserName(clientId, userName);
//            for (OAuth2AccessToken s : data) {
//                tokenStore.removeAccessToken(s);
//            }
//        }
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            JsonObj input = new JsonObj();
            input.put("userName", username);
            JsonObj userInfo = defaultAuthenticationProviderDao.getUserByName(input);
            log.info("user info:"+ userInfo.toString());
            String userName = (String) userInfo.get("userName");
            String password = (String) userInfo.get("password");
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            JsonObjArray authorities = userInfo.getJsonObjectArray("authorities");
            for (JsonObj authority : authorities.toListData()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(authority.getString("name")));
            }

//            Collection<? extends GrantedAuthority> authorities = (Collection<? extends GrantedAuthority>) userInfo.get("authorities");
            if (userInfo != null) {
                UserDetails userDetails = User.builder()
                        .username(username)
                        .password(password)
                        .authorities(grantedAuthorities)
                        .build();
                return userDetails;
            }
            throw new UsernameNotFoundException("User not found_0");

        } catch (Exception e) {
            log.error("get error exception service loadUserByUsername:", e);
            throw e;
        }
    }
}
