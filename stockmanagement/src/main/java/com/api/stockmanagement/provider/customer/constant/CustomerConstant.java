package com.api.stockmanagement.provider.customer.constant;

public enum CustomerConstant {
    INVALID_CUSTOMER_ID("Invalid Customer ID."),
    INVALID_CUSTOMER_NAME("Customer name not allow empty or null.");

    private String textValue;
    private CustomerConstant(String textValue) {
        this.textValue = textValue;
    }

    public String getTextValue() {
        return textValue;
    }
}

