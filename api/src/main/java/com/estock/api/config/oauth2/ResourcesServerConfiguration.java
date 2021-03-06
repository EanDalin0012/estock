package com.estock.api.config.oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.sql.DataSource;


@EnableResourceServer
@Configuration
public class ResourcesServerConfiguration  extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "resource-server-rest-api";
    private static final String SECURED_READ_SCOPE = "#oauth2.hasScope('read')";
    private static final String SECURED_WRITE_SCOPE = "#oauth2.hasScope('write')";
    private static final String SECURED_PATTERN = "/api/**";

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;
    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

//    @Bean
//    @ConfigurationProperties(prefix="spring.datasource")
//    public DataSource ouathDataSource(){return DataSourceBuilder.create().build();}

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources
                .stateless(true)
                .accessDeniedHandler(this.accessDeniedHandler)
                .authenticationEntryPoint(this.authenticationEntryPoint)
                .resourceId(RESOURCE_ID);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(new String[] {"/"}).permitAll()
                .antMatchers(new String[]{
                        "/mastercard*/**",
                        "/tutuka*/**"
                }).permitAll()
                .anyRequest()
                .authenticated().and()
                .exceptionHandling()
                .accessDeniedHandler(this.accessDeniedHandler)
                .authenticationEntryPoint(this.authenticationEntryPoint);
    }
}
