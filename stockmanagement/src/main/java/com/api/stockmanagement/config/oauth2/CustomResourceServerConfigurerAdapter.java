package com.api.stockmanagement.config.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.inject.Inject;

@Configuration
@EnableResourceServer
public class CustomResourceServerConfigurerAdapter extends ResourceServerConfigurerAdapter {
    private static final String RESOURCE_ID = "resource-server-rest-api";
    private static final String SECURED_READ_SCOPE = "#oauth2.hasScope('read')";
    private static final String SECURED_WRITE_SCOPE = "#oauth2.hasScope('write')";
    private static final String SECURED_PATTERN = "/api/**";

    @Inject
    private AccessDeniedHandler accessDeniedHandler;
    @Inject private AuthenticationEntryPoint authenticationEntryPoint;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID);
    }

//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.requestMatchers()
//                .antMatchers(SECURED_PATTERN).and().authorizeRequests()
//                .antMatchers(HttpMethod.POST, SECURED_PATTERN).access(SECURED_WRITE_SCOPE)
//                .anyRequest().access(SECURED_READ_SCOPE);
//    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        resources
//                .stateless(true)
//                .accessDeniedHandler(this.accessDeniedHandler)
//                .authenticationEntryPoint(this.authenticationEntryPoint)
//                .resourceId(RESOURCE_ID);
//    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(new String[] {"/"}).permitAll()
                .antMatchers(new String[]{
                        "/api/image*/**",
                        "/unsecur*/**",
                        "/wechat*/**",
                        "/ecomv*/**"
                }).permitAll()
                .anyRequest()
                .authenticated().and()
                .exceptionHandling()
                .accessDeniedHandler(this.accessDeniedHandler)
                .authenticationEntryPoint(this.authenticationEntryPoint);
    }
}
