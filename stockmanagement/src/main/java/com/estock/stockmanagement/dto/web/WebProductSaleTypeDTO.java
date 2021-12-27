package com.estock.stockmanagement.dto.web;

import com.estock.stockmanagement.common.dto.CommonDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 * Product Sale Type
Sale Type {
	- Price		1		22USD		22USD
	- Silver	6		16.50USD	99USD
} 
*/

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
public class WebProductSaleTypeDTO extends CommonDTO {
	
	private int id;
	private int productId;
	private String productSaleType;
	private int qty;
	private double unitPrice;
	private double totalUnitPrice;
	private String desc;
	
}
