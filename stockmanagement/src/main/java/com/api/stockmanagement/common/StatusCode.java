package com.api.stockmanagement.common;

public enum StatusCode {
    INSERT("Insert"),
    UPDATE("Update"),
    DELETE("Delete");

    private String textValue;
    private StatusCode(String textValue){
        this.textValue = textValue;
    }

    public String getTextValue() {
        return textValue;
    }
}
