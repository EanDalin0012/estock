package com.api.stockmanagement.config.oauth2.provider;

import com.api.stockmanagement.common.exception.CustomException;
import com.api.stockmanagement.provider.userdetails.data.adapter.AuthorityAdapter;
import com.api.stockmanagement.provider.userdetails.data.adapter.UserAdapter;
import com.api.stockmanagement.provider.userdetails.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {


    private final UserDetailServiceImpl userDetailService;
    public CustomAuthenticationProvider(UserDetailServiceImpl userDetailService) {
        this.userDetailService = userDetailService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            String userName = authentication.getName();
            String password = (String) authentication.getCredentials();
            UserAdapter userAdapter = this.userDetailService.inquiryUserByUsername(userName);
//            String passwordDb = userAdapter.getPassword();
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String _password = userAdapter.getPassword();

//            String pw = passwordEncoder.encode(userName);

            boolean isPasswordMatch = passwordEncoder.matches(password, _password);
            System.out.println(isPasswordMatch);
            if (!isPasswordMatch) {
                throw new UsernameNotFoundException("InvalidPassword");
            }

//            if (password.equals(userAdapter.getPassword()))
//            {
//                Collection<? extends GrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
//                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userAdapter, password, authorities);
//                return authenticationToken;
//            }

            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (AuthorityAdapter authorityAdapter:userAdapter.getAuthorities()) {
                grantedAuthorities.add(new GrantedAuthority() {
                    @Override
                    public String getAuthority() {
                        return authorityAdapter.getName();
                    }
                });
            }

            Map<String, Object> param = new HashMap<>();
            param.put("user_name", authentication.getName());

            Map<String, Object> principal = new HashMap<>();
            principal.put("username", userName);
            Map<String, Object> credentials = new HashMap<>();
            credentials.put("password", userAdapter.getPassword());

            return new UsernamePasswordAuthenticationToken(
                    principal,
                    credentials,
                    grantedAuthorities);

        }catch (Exception e) {
            e.printStackTrace();
        } catch (CustomException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
