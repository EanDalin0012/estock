package com.estock.stockmanagement.provider.importtostock.constants;

public enum ImportToStockErrorCode {
	INVALID_REPRESENT_PRODUCT_TYPE_ID("Invalid represent product type id.");
	
	private String textValue;

	private ImportToStockErrorCode(String textValue) {
		this.textValue = textValue;
	}

	public String getTextValue() {
		return textValue;
	}
}
