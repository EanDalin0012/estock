package com.estock.api.common.type;

import com.fasterxml.jackson.annotation.JsonValue;

public interface Type<T> {

	@JsonValue T getValue();
	
	String getDescription();
}
