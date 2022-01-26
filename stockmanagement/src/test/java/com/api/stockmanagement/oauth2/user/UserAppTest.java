package com.api.stockmanagement.oauth2.user;
import com.api.stockmanagement.provider.userdetails.service.impl.UserDetailServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserAppTest {

    @Autowired
    private UserDetailServiceImpl userService;

    @Test
    void inquiryUserByUserName() {
        try {
            this.userService.loadUserByUsername("admin@gmail.com");
        }catch (Exception  e) {
            e.printStackTrace();
        }
    }

}
