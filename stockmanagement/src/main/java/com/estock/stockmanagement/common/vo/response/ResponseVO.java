package com.estock.stockmanagement.common.vo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseVO<T> {
	private String code;
	private String message;
	private T data;
}
