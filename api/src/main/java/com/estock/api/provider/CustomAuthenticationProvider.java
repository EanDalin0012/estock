package com.estock.api.provider;

import com.estock.api.dto.AuthorityDTO;
import com.estock.api.dto.UserDTO;
import com.estock.api.event.DeviceLoginEvent;
import com.estock.api.service.AuthenticationService;
import com.estock.api.util.BCryptPwEncoder;
import com.estock.api.util.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.common.exceptions.ClientAuthenticationException;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedClientException;
import org.springframework.stereotype.Component;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private static Logger log = LogManager.getLogger();

    @Inject
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private AuthenticationService userDAO;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.info("============== Start Authorization ===============");
        try {
//            String k = this.env.getProperty("security.key");
//            String encodedBase64Key = Encr8yptionUtil.encodeKey(DemoProperties.secretKey);
//            String userName         = EncryptionUtil.decrypt(authentication.getName(), encodedBase64Key);
//            String password         = EncryptionUtil.decrypt((String) authentication.getCredentials(), encodedBase64Key);
//            Map<String, String> data = (Map<String, String>) authentication.getDetails();
//            String deviceInfo = data.get("deviceInfo");
//            String deviceInfoDecrypt = EncryptionUtil.decrypt(deviceInfo, encodedBase64Key).toString();

//            String encodedBase64Key = EncryptionUtil.encodeKey(DemoProperties.secretKey);
            String userName         =authentication.getName();
            String password         = (String) authentication.getCredentials();
            Map<String, String> data = (Map<String, String>) authentication.getDetails();
            String deviceInfo =  data.get("deviceInfo");
            String chanel     = data.get("chanel");

            if(deviceInfo != null) {
                eventPublisher.publishEvent(new DeviceLoginEvent(deviceInfo));
            }


            UserDTO userInfo = this.userDAO.authenticate(userName);
            log.info("User Info object: "+ Utility.toJSON(userInfo));

            if (userInfo == null) {
                log.info("============== Authorization User Not Found ===============");
                throw new UnauthorizedClientException("userNotFound");
            }
            if (userInfo.isAccountLocked()) {
                log.info("============== User Account Locked ===============");
                throw new UnauthorizedClientException("accountLocked");
            }
            if (!userInfo.isEnabled()) {
                log.info("============== User Enabled False ===============");
                throw new UnauthorizedClientException("userDisabled");
            }
            if (userInfo.isAccountExpired()) {
                log.info("============== User Account Expired ===============");
                throw new UnauthorizedClientException("userExpired");
            }
            if (userInfo.isCredentialsExpired()) {
                log.info("============== User Account Credentials Expired ===============>>>>>>>>>>>>");
                throw new UnauthorizedClientException("userExpired");
            }

//            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String _password = userInfo.getPassword();

            boolean isPasswordMatch = BCryptPwEncoder.matches(password, _password);
            System.out.println(isPasswordMatch);
            if (!isPasswordMatch) {
                throw new UnauthorizedClientException("invalidPassword");
            }

            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            List<AuthorityDTO> authorities = userInfo.getAuthorities();
            for (AuthorityDTO authority : authorities) {
                grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
            }

            Map<String, Object> principal = new HashMap<>();
            principal.put("username", userInfo.getUserName());
            principal.put("Chanel", "Web");

            Map<String, Object> credentials = new HashMap<>();
            principal.put("password", userInfo.getPassword());

            principal.put("Chanel", chanel);

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
