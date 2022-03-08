package com.estock.api.service.constant;

public enum UserRoleConstant {
    INVALID_ROLE_ID("Invalid role id."),
    INVALID_ROLE_NAME("Invalid role name.");

    private String desc;
    private UserRoleConstant(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
