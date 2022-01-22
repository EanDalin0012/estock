package com.estock.stockmanagement.provider.stock.constants;

public enum StockConstant {
    INVALID_USER_ID("Invalid User ID."),
    INVALID_QTY("Invalid Qty."),
    INVALID_PRICE("Price must be than zero."),
    INVALID_PRODUCT_ID("Invalid product ID."),
    INVALID_STOCK_ID("Invalid Stock ID.");
    ;
    private String textValue;

    private StockConstant(String textValue) {
        this.textValue = textValue;
    }

    public String getTextValue() {
        return textValue;
    }
}
