package com.estock.stockmanagement.provider.product.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
public class ProductData {
	private int id;
	private String productName;
	private int resourceId;
	private String desc;
}
