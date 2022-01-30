package com.estock.api.rest;

import com.estock.api.common.template.KeyTemplate;
import com.estock.api.service.impl.TestServiceIml;
import com.estock.api.service.impl.UserAuthorityServiceImpl;
import com.estock.api.util.GenerateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class HomeRest implements KeyTemplate {
    private final static Logger log = LogManager.getLogger(HomeRest.class.getName());

    private String key;
    @Autowired
    private TestServiceIml testServiceIml;
    HomeRest() {
        this.key = GenerateUtil.key();
    }
    @GetMapping(value = "/hello")
    public String index() {
        log.info(key+"HomeRest Key");
        this.testServiceIml.TestKey();
        log.info(key+"index Key");
        return "data";
    }

    @Override
    public void key(String key) {
       this.key = key;
    }
}
