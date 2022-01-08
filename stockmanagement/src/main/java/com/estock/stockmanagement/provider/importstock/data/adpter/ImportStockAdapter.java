package com.estock.stockmanagement.provider.importstock.data.adpter;

import com.estock.stockmanagement.common.adapter.CommonAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class ImportStockAdapter extends CommonAdapter {
	private int id;
	private int representProductTypeId;
	private int qty;
	private double totalPrice;
	private String desc;
}
