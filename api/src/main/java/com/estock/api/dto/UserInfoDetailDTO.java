package com.estock.api.dto;

import com.estock.api.common.dto.CommonDTO;
import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class UserInfoDetailDTO extends CommonDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private String dateBirth;
    private String phone;
    private String desc;
    private int resourceID;
    List<CredentialDTO> credentials;
    UserRoleDTO userRole;
}
