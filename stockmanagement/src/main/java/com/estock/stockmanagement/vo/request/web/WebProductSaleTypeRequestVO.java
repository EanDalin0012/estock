package com.estock.stockmanagement.vo.request.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WebProductSaleTypeRequestVO {
	private int id;
	private int productId;
	private String productSaleType;
	private int qty;
	private double unitPrice;
	private double totalUnitPrice;
	private String desc;
}
