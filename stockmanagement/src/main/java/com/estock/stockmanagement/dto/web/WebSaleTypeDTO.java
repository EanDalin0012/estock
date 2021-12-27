package com.estock.stockmanagement.dto.web;

import com.estock.stockmanagement.common.dto.CommonDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 Sale Type {
 	- Member
 	- Customer
 } 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
public class WebSaleTypeDTO extends CommonDTO {
	
	private int id;
	private String saleType;
	private String desc;
	
}
