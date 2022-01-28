package com.api.stockmanagement.oauth2.user;
import com.api.stockmanagement.provider.userdetails.service.impl.UserDetailServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
    @Test
    void test() {
        try {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String _password = "spring-security-oauth2-read-write-client-password1234";

            String pw = "$2a$04$soeOR.QFmClXeFIrhJVLWOQxfHjsJLSpWrU1iGxcMGdu.a5hvfY4W";//passwordEncoder.encode("admin1234");

            boolean isPasswordMatch = passwordEncoder.matches(_password, pw);
            System.out.println(isPasswordMatch);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
