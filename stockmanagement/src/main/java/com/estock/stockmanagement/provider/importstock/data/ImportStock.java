package com.estock.stockmanagement.provider.importstock.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ImportStock {
	private int productId;
	private int productSaleTypeId;
}
