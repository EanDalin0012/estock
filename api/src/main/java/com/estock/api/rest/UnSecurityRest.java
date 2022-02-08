package com.estock.api.rest;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/unsecure")
@Slf4j
public class UnSecurityRest {
    @GetMapping(value = "/t")
    public String toString() {
        log.info("======== Testing ==========");
        return "est";
    }
}
