package com.estock.api.dto;

import com.estock.api.common.dto.CommonDTO;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class CredentialDTO extends CommonDTO {
    private int id;
    private String userName;
    private boolean accountExpired;
    private boolean accountLocked;
    private boolean credentialsExpired;
    private boolean enabled;
    private int roleId;
}
