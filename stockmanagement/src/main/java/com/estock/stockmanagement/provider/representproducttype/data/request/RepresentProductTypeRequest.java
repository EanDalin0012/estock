package com.estock.stockmanagement.provider.representproducttype.data.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RepresentProductTypeRequest {
	private int productId;
	private String saleTypeName; // Price, Silver, VIP Silver, Premuim
	private double unitPrice;
	private double totalPrice;
	private int qty;
	//	Note: totalPirce = unitPrice*qty
}
