package com.estock.stockmanagement.provider.authentication.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuthorityData {
	private int id;
	private String name;
}
