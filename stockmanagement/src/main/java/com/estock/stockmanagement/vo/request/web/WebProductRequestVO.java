package com.estock.stockmanagement.vo.request.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WebProductRequestVO {
	private int id;
	private String productName;
	private int resourceId;
}
