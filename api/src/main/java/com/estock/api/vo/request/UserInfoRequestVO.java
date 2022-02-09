package com.estock.api.vo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserInfoRequestVO {
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private String dateBirth;
    private String phone;
    private String desc;
    private int resourceID;
}
