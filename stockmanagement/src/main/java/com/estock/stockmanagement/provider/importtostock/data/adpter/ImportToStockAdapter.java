package com.estock.stockmanagement.provider.importtostock.data.adpter;

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
@ToString(callSuper = true)
public class ImportToStockAdapter extends CommonAdapter {
	private int id;
	private int representProductTypeId;
	private int qty;
	private int totalQty;
	private double totalPrice;
	private String desc;
}
