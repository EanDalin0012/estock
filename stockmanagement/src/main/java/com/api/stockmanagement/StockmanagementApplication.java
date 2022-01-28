package com.api.stockmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.api.stockmanagement.*")
public class StockmanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockmanagementApplication.class, args);
    }

}
