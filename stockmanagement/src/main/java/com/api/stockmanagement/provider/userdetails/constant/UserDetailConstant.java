package com.api.stockmanagement.provider.userdetails.constant;

public enum UserDetailConstant {
    INVALID_USER_NAME("Invalid User Name."),
    USER_NOT_FOUND("User not found.");
    private String desc;
    private UserDetailConstant(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
