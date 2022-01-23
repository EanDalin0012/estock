package com.estock.stockmanagement.provider.authentication.data.adapter;

import java.util.List;

import com.estock.stockmanagement.provider.authentication.data.AuthorityData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
public class AuthenticationAdapter {
	private int id;
	private boolean accountExpired;
	private boolean accountLocked;
	private boolean credentialsExpired;
	private boolean enabled;
	private String password;
	private String userName;
	private String gender;
	private String fullName;
	private String dateBirth;
	private String phoneNumber;
	private int resourceId;
	private int roleId;
	private int identifyInfoSesourceId;
	private List<AuthorityData> authorities;
}
