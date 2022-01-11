package com.estock.stockmanagement.provider.representproducttype.data.adapter;

import com.estock.stockmanagement.common.adapter.CommonAdapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
public class RepresentProductTypeAdapter  extends CommonAdapter {
	private int id;
	private int productId;
	private String saleTypeName; // Price, Silver, VIP Silver, Premuim
	private double unitPrice;
	private double totalPrice;
	private int qty;
//	Note: totalPirce = unitPrice*qty
}
