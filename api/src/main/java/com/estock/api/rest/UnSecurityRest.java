package com.estock.api.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/unsecure")
public class UnSecurityRest {
    private final static Logger log = LogManager.getLogger(UnSecurityRest.class.getName());
    @GetMapping(value = "/t")
    public String toString() {
        log.info("======== Testing ==========");
        return "est";
    }
}
