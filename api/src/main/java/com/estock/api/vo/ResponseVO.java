package com.estock.api.vo;

import lombok.*;


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseVO<T> extends BaseVO {
	private String resultCode;
	private String resultMessage;
	private T body;
}
