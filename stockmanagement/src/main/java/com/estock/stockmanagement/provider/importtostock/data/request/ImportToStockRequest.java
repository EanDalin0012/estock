package com.estock.stockmanagement.provider.importtostock.data.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ImportToStockRequest {
	private int representProductTypeId;
	private int qty;
	private String desc;
}
