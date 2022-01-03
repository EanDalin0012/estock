package com.estock.stockmanagement.provider.userinfo.data.adapter;

import java.util.List;

import com.estock.stockmanagement.provider.userinfo.data.UserInfoAuthorityData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserInfoAuthorityAdapter {
	private int id;
	private boolean accountExpired;
	private boolean accountLocked;
	private boolean credentialsExpired;
	private boolean enabled;
	private String userName;
	private String gender;
	private String fullName;
	private String dateBirth;
	private String phoneNumber;
	private int resourceId;
	private int roleId;
	private int identifyInfoSesourceId;
	private List<UserInfoAuthorityData> authorities;
}
