package com.estock.stockmanagement.provider.product.data.adapter;

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
public class ProductAdapter extends CommonAdapter {
	private int id;
	private String productName;
	private int resourceId;
	private String desc;
}
