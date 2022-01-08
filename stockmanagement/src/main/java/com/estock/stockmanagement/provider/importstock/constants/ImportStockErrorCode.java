package com.estock.stockmanagement.provider.importstock.constants;

public enum ImportStockErrorCode {
	INVALID_REPRESENT_PRODUCT_TYPE_ID("Invalid represent product type id.");
	
	private String textValue;

	private ImportStockErrorCode(String textValue) {
		this.textValue = textValue;
	}

	public String getTextValue() {
		return textValue;
	}
}
