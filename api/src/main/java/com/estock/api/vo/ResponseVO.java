package com.estock.api.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseVO<T> extends BaseVO {

	private String resultCode;
	private String resultMessage;
	private T body;
}
