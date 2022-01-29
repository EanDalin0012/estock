package com.api.stockmanagement.config.oauth2;

import com.api.stockmanagement.core.provider.DefaultAuthenticationProvider;
import com.api.stockmanagement.core.service.DefaultAuthenticationProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationDataSourceScriptDatabaseInitializer;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.sql.init.DatabaseInitializationSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * Created by Sokkheang Huo
 */

@Configuration
@EnableWebSecurity
@Order(SecurityProperties.BASIC_AUTH_ORDER)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DefaultAuthenticationProviderService userService;
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Autowired
//	private DaoAuthentication authProvider;

	/*
	 * @Bean
	 * 
	 * @Override public UserDetailsService userDetailsServiceBean() throws Exception
	 * { return new JdbcUserDetails(); }
	 */

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/webjars/**",
									"/resources/**",
									"/html/**",
									"/video/**",
									"/view_photo/**",
									"/file/**",
									"/tokens/**",
									"/reset/**",
									"/article/**");
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
			.anyRequest().authenticated().and().httpBasic()
			.and().csrf().disable();
    }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// auth.userDetailsService(userDetailsServiceBean())
		// .passwordEncoder(passwordEncoder());

		auth.authenticationProvider(new DefaultAuthenticationProvider(userService));
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

//	@Bean
//	public IntegrationDataSourceScriptDatabaseInitializer customIntegrationDataSourceInitializer(DataSource dataSource) {
//		return new IntegrationDataSourceScriptDatabaseInitializer(dataSource, new DatabaseInitializationSettings());
//	}
}
