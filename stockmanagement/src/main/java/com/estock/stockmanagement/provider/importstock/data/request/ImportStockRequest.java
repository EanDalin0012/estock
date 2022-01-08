package com.estock.stockmanagement.provider.importstock.data.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ImportStockRequest {
	private int representProductTypeId;
	private int qty;
	private String desc;
}
