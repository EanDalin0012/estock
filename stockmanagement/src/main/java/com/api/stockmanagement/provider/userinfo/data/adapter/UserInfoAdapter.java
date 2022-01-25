package com.api.stockmanagement.provider.userinfo.data.adapter;

import com.api.stockmanagement.common.adapter.CommonAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class UserInfoAdapter extends CommonAdapter {
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private String dateBirth;
    private String phoneNumber;
    private String email;
    private int resourceID;
}
