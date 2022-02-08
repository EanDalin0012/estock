package com.estock.api.service.constant;

public enum UserInfoConstant {
    INVALID_USER_INFO_ID("Invalid ID."),
    INVALID_USER_NAME("Invalid User Name.");

    private String desc;
    private UserInfoConstant(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }
}
