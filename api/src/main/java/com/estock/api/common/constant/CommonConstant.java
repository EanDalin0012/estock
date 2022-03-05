package com.estock.api.common.constant;

public enum CommonConstant {
    INVALID_USER_NAME( "User name can't empty || null"),
    GENERAL_FAIL_EXCEPTION("General fails exception"),
    SUCCESS("Success"),
    FAIL("fail");

    private String desc;
    private CommonConstant(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
