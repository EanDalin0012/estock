package com.estock.api.common.constant;

public enum ResponseCode {
    SUCCESS("200"),
    FAIL("404");
    private String code;
    private ResponseCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return this.code;
    }
}
