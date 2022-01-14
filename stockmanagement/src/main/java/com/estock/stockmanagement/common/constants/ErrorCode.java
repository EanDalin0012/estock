package com.estock.stockmanagement.common.constants;

public enum ErrorCode {
	INVALID_USER_ID("Invalid user."),
	EXCEPTION_FAIL("Throw exception error.");
	
	private String textValue;

	private ErrorCode(String textValue) {
		this.textValue = textValue;
	}

	public String getTextValue() {
		return textValue;
	}
}
