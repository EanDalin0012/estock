package com.estock.stockmanagement.dto.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
public class WebSaleProductDTO {
	
	private int id;
	private int productId;
	private int productSaleTypeId;
	
}
