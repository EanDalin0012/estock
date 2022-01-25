package com.api.stockmanagement.provider.userinfo.data.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserInfoRequest {
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private String dateBirth;
    private String phoneNumber;
    private String email;
}
