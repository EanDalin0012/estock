package com.estock.api.util;

import com.estock.api.provider.CustomAuthenticationProvider;
import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPwEncoder {
    private final static Logger log = Logger.getLogger(CustomAuthenticationProvider.class.getName());
    public static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static String encode(String password) {
        try {
            return passwordEncoder.encode(password);
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static boolean matches(String password, String encodePassword) {
        try {
            return passwordEncoder.matches(password, encodePassword);
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


}
