package com.estock.stockmanagement.common.adapter;

import com.estock.stockmanagement.common.dto.CommonDTO;
import com.estock.stockmanagement.util.SystemDateUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class CommonAdapter {
	private String dateTime;
	private int userId;
	
	public CommonAdapter() {
		dateTime = SystemDateUtil.getLocalDate("dd-MM-yyyy hh:mm:ss");
	}
}
