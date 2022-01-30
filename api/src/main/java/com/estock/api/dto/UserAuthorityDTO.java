package com.estock.api.dto;

import com.estock.api.common.dto.CommonDTO;
import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class UserAuthorityDTO extends CommonDTO {
    private int id;
    private String userName;
    private String password;
    private boolean accountExpired;
    private boolean accountLocked;
    private boolean credentialsExpired;
    private boolean enabled;
    private String firstName;
    private String lastName;
    private String gender;
    private String dateBirth;
    private String phone;
    private String desc;
    private List<AuthorityDTO> authorities;
}
