package com.estock.stockmanagement.common.dto;

import com.estock.stockmanagement.util.SystemDateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class CommonDTO {
	private String dateTime;
	private int userId;
	
	public CommonDTO() {
		dateTime = SystemDateUtil.getLocalDate("dd-MM-yyyy hh:mm:ss");
	}
}
