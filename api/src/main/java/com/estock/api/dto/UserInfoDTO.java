package com.estock.api.dto;

import com.estock.api.common.dto.CommonDTO;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class UserInfoDTO extends CommonDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private String dateBirth;
    private String phone;
    private String desc;
}
