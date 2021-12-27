package com.estock.stockmanagement.vo.request.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WebSaleProductRequestVO<B> {
	private String saleType;
	private B data;
}
