package com.estock.api.service.constant;

public enum ServiceConstant {
    INVALID_USER_NAME( "User name can't empty || null"),
    GENERAL_FAIL_EXCEPTION("General fails exception");

    private String desc;
    private ServiceConstant(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
