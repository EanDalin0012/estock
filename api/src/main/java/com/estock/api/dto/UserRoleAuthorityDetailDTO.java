package com.estock.api.dto;

import com.estock.api.common.dto.CommonDTO;
import lombok.*;

import java.util.Collection;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class UserRoleAuthorityDetailDTO extends CommonDTO {
    private int id;
    private String role;
    private String desc;
    Collection<AuthorityDTO> authorities;
}
