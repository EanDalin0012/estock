package com.estock.api.common.constant;

public enum AuthorityConstant {
    CREATE_USER("Create User Login"),
    READ_USER("Read User"),
    UPDATE_USER("Update USER"),
    DELETE_USER("Delete User"),
    RESET_PASSWORD_USER("Reset Password User");



    private String textValue;
    private AuthorityConstant(String textValue) {
        this.textValue = textValue;
    }

    public String getTextValue() {
        return textValue;
    }
}
