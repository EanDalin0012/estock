package com.estock.stockmanagement.provider.product.data.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateProductRequest {
	private int id;
	private String name;
	private int resourceId;
	private String desc;
}
