package com.estock.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class HomeRest {

    @GetMapping(value = "/hello")
    public String index() {
        return "data";
    }
}
