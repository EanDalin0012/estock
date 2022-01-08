package com.estock.stockmanagement.provider.representproducttype.constants;

public enum RepresentProductTypeErrorCode {
	
	INVALID_PRODUCT_ID("Invalid Product Id."),
	INVALID_QTY("Quantity need over than zero."),
	INVALID_UNIT_PRICE("Unit price need over than zero."),
	INVALID_TOTAL_PRICE("Total price caluate need over than zero.");
	
	private String textValue;

	private RepresentProductTypeErrorCode(String textValue) {
		this.textValue = textValue;
	}

	public String getTextValue() {
		return textValue;
	}
	
}
