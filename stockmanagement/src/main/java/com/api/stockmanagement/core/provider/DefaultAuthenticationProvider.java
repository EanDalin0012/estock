package com.api.stockmanagement.core.provider;

import com.api.stockmanagement.common.dto.JsonObj;
import com.api.stockmanagement.common.dto.JsonObjArray;
import com.api.stockmanagement.core.service.DefaultAuthenticationProviderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.ClientAuthenticationException;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedClientException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class DefaultAuthenticationProvider implements AuthenticationProvider {
    static Logger log = Logger.getLogger(DefaultAuthenticationProvider.class.getName());

    final DefaultAuthenticationProviderService userService;

    public DefaultAuthenticationProvider(DefaultAuthenticationProviderService userService) {
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.info("============== Start Authorization ===============");
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            log.info("============== Authentication Data :"+objectMapper.writeValueAsString(authentication));
//            String k = this.env.getProperty("security.key");
//            String encodedBase64Key = EncryptionUtil.encodeKey(DemoProperties.secretKey);
//            String userName         = EncryptionUtil.decrypt(authentication.getName(), encodedBase64Key);
//            String password         = EncryptionUtil.decrypt((String) authentication.getCredentials(), encodedBase64Key);
//            Map<String, String> data = (Map<String, String>) authentication.getDetails();
//            String deviceInfo = data.get("deviceInfo");
//            String deviceInfoDecrypt = EncryptionUtil.decrypt(deviceInfo, encodedBase64Key).toString();

//            String encodedBase64Key = EncryptionUtil.encodeKey(DemoProperties.secretKey);
            String userName         =authentication.getName();
            String password         = (String) authentication.getCredentials();
            Map<String, String> data = (Map<String, String>) authentication.getDetails();
            String deviceInfo = data.get("deviceInfo");
//            String deviceInfoDecrypt = EncryptionUtil.decrypt(deviceInfo, encodedBase64Key).toString();
//
//            JsonObject deviceInfoObj = new JsonObject();
            JsonObj input = new JsonObj();
            input.setString("userName", userName);

//            if (deviceInfoDecrypt != null || deviceInfoDecrypt != "") {
//                deviceInfoObj = objectMapper.readValue(deviceInfoDecrypt, JsonObject.class);
//            }
//            input.setJsonObject("deviceInfo", deviceInfoObj);

            JsonObj userInfo = userService.authenticate(input);
            log.info("User Info object: "+objectMapper.writeValueAsString(userInfo));

            if (userInfo == null) {
                log.info("============== Authorization User Not Found ===============");
                throw new UnauthorizedClientException("userNotFound");
            }
            if (userInfo.getBoolean("accountLocked")) {
                log.info("============== User Account Locked ===============");
                throw new UnauthorizedClientException("accountLocked");
            }
            if (!userInfo.getBoolean("enabled")) {
                log.info("============== User Enabled False ===============");
                throw new UnauthorizedClientException("userDisabled");
            }
            if (userInfo.getBoolean("accountExpired")) {
                log.info("============== User Account Expired ===============");
                throw new UnauthorizedClientException("userExpired");
            }
            if (userInfo.getBoolean("credentialsExpired")) {
                log.info("============== User Account Credentials Expired ===============>>>>>>>>>>>>");
                throw new UnauthorizedClientException("userExpired");
            }

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String _password = userInfo.getString("password");

            boolean isPasswordMatch = passwordEncoder.matches(password, _password);
            System.out.println(isPasswordMatch);
            if (!isPasswordMatch) {
                throw new UnauthorizedClientException("invalidPassword");
            }

            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            JsonObjArray authorities = userInfo.getJsonObjectArray("authorities");
            for (JsonObj authority : authorities.toListData()) {
                grantedAuthorities.add(new SimpleGrantedAuthority(authority.getString("name")));
            }

            JsonObj param = new JsonObj();
            param.setString("user_name", authentication.getName());
//            userService.updateLoginSuccess(param);
            log.info("Apply keep login success");
//            isLoginSuccess(param);
            JsonObj principal = new JsonObj();
            principal.setString("username", userInfo.getString("username"));
            JsonObj credentials = new JsonObj();
            credentials.setString("password", userInfo.getString("password"));
//            Object principal, Object credentials
            log.info("============== End Authorization ===============>>>>>>>>>>>>\n");
            return new UsernamePasswordAuthenticationToken(
                    principal,
                    credentials,
                    grantedAuthorities);

        } catch (UnauthorizedClientException ex) {
            log.info("============== Get error user name not found exception ===============" + ex);
            throw new ClientAuthenticationException(ex.getMessage(), ex.getCause()) {
                @Override
                public String getOAuth2ErrorCode() {
                    return "404";
                }
            };
        } catch (Exception e) {
            log.error("*** get error class default authentication exception", e);
            log.info("============== Get error user name not found exception ===============" + e);
            throw new ClientAuthenticationException(e.getMessage(), e.getCause()) {
                @Override
                public String getOAuth2ErrorCode() {
                    return "404";
                }
            };
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
