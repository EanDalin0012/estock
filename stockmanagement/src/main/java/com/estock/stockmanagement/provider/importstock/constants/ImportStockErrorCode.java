package com.estock.stockmanagement.provider.importstock.constants;

public enum ImportStockErrorCode {
	INVALID_IMPORT_STOCK_ID("Invaldi import stock id."),
	INVALID_IMPORT_STOCK_NAME("Import stock name not allow null or empty.");
	
	private String textValue;

	private ImportStockErrorCode(String textValue) {
		this.textValue = textValue;
	}

	public String getTextValue() {
		return textValue;
	}
}
