package com.estock.api.config.mybatis;

import com.estock.api.config.mybatis.interceptor.CustomeInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan("com.estock.api.dao")
public class MyBatisConfiguration {
	
	
	@Bean
    public Interceptor interceptor(){
        return new CustomeInterceptor();
    }

}