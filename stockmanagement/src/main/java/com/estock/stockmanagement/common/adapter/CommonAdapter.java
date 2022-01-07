package com.estock.stockmanagement.common.adapter;

import com.estock.stockmanagement.common.constants.StatusCode;
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
	private String stutas;
	public CommonAdapter() {
		dateTime = SystemDateUtil.getLocalDate("dd-MM-yyyy hh:mm:ss");
		this.stutas = StatusCode.INSERT.name();
	}
}
