package com.estock.stockmanagement.vo.request.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WebAccountRequestVO {
	private int id;
	private String firstName;
	private String lastName;
	private String dob;
	private String gender;
	private String phone;
	private String otherPhone;
	private int resourceId;
}
