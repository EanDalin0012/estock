package com.estock.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Collection;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoadUserInfoDTO {
    private int id;
    private Collection<AuthorityDTO> authorities;
    private UserRoleDTO userRole;
    private CredentialDTO credential;
    private UserInfoDTO userInfo;
}
