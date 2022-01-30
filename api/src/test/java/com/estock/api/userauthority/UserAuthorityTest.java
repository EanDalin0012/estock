package com.estock.api.userauthority;

import com.estock.api.common.exception.CustomException;
import com.estock.api.dto.UserAuthorityDTO;
import com.estock.api.service.UserAuthorityService;
import com.estock.api.service.impl.UserAuthorityServiceImpl;
import com.estock.api.util.Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserAuthorityTest {
    private final static Logger log = LogManager.getLogger(UserAuthorityTest.class.getName());
    @Autowired
    private UserAuthorityService userAuthorityService;
    @Test
    void contextLoads() {
        try {
            UserAuthorityDTO userAuthorityDTO = this.userAuthorityService.loadUserAuthorityByUserName("admin");
            log.info("==== DAta :"+ Utility.toJSON(userAuthorityDTO));
        }catch (Exception e) {
            e.printStackTrace();
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }
}
