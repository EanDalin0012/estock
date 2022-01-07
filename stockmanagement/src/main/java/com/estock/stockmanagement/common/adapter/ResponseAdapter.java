package com.estock.stockmanagement.common.adapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseAdapter<T> {
	private String code;
	private String message;
	private T data;
}
