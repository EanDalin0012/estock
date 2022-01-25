package com.api.stockmanagement.provider.oauth2.user.constant;

public enum UserConstant {
    INVALID_USER_ID("Invalid User ID."),
    INVALID_USER_NAME("User name can't empty or null"),
    INVALID_USER_INFO_ID("Invalid user info ID."),
    INVALID_ROLE_ID("Invalid Role ID."),
    INVALID_PASSWORD("Password can't empty or null");

    private String desc;

    private UserConstant(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return this.desc;
    }
}
