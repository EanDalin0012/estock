package com.estock.api.service.impl;

import com.estock.api.dao.AuthenticationDAO;
import com.estock.api.dto.UserDTO;
import com.estock.api.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private AuthenticationDAO authenticationDAO;

//    @Autowired
//    private TokenStore tokenStore;

    @Override
    public UserDTO authenticate(String userName) {

//        String token = tokenStore.getAccessToken();
        return authenticationDAO.getUserByName(userName);
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

}
