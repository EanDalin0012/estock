package com.estock.stockmanagement.dto.web;

import com.estock.stockmanagement.common.dto.CommonDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
public class WebProductDTO extends CommonDTO {
	
	private int id;
	private String productName;
	private int resourceId;
	
}
