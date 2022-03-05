package com.estock.api.dto;

import com.estock.api.common.dto.CommonDTO;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class UserRoleDTO extends CommonDTO {
    private int id;
    private String role;
}
