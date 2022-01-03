package com.estock.stockmanagement.provider.authentication.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserData {
	private int id;
	private boolean accountExpired;
	private boolean accountLocked;
	private boolean credentialsExpired;
	private boolean enabled;
	private boolean password;
	private boolean userName;
	private String gender;
	private String fullName;
	private String dateBirth;
	private String phoneNumber;
	private int resourceId;
	private int roleId;
	private int identifyInfoSesourceId;
}
