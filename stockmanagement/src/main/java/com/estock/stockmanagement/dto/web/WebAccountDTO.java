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
public class WebAccountDTO extends CommonDTO {
	
	private int id;
	private String firstName;
	private String lastName;
	private String dob;
	private String gender;
	private String phone;
	private String otherPhone;
	private int resourceId;
	
}
