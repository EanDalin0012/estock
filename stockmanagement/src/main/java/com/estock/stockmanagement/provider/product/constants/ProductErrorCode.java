package com.estock.stockmanagement.provider.product.constants;

public enum ProductErrorCode {
	INVALID_PRODUCT_ID("Invalid product Id."),
	INVALID_PRODUCT_NAME("Invalid product name."),
	PRODUCT_NAME_EXETED("Product name exited.");
	
	private String textValue;

	private ProductErrorCode(String textValue) {
		this.textValue = textValue;
	}

	public String getTextValue() {
		return textValue;
	}
}
