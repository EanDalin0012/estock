package com.estock.stockmanagement.provider.product.request;

import com.estock.stockmanagement.provider.product.data.adapter.ProductAdapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductRequest {
	private String name;
	private int resourceId;
	private String desc;
}
