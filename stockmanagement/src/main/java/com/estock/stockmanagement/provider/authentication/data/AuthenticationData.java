package com.estock.stockmanagement.provider.authentication.data;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
public class AuthenticationData {
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
	private List<AuthorityData> authorities;
}
