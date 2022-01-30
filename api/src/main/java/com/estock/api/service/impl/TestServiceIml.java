package com.estock.api.service.impl;

import com.estock.api.common.template.KeyTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class TestServiceIml implements KeyTemplate {
    private String key;
    private final static Logger log = LogManager.getLogger(TestServiceIml.class.getName());

    public void TestKey() {
        log.info(key+"======== TestServiceIml ======");
    }
    @Override
    public void key(String key) {
       this.key = key;
    }
}
