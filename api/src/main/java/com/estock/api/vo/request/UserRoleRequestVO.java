package com.estock.api.vo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRoleRequestVO {
    private int id;
    private String role;
    private String desc;
    private int [] authorities;
}
