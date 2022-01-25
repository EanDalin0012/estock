package com.api.stockmanagement.provider.oauth2.user.data.adapter;

import com.api.stockmanagement.common.adapter.CommonAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class UserAdapter extends CommonAdapter {
    private int userInfoID;
    private int roleID;
    private String userName;
    private String password;
    private String status;
    private boolean accountExpired;
    private boolean accountLocked;
    private boolean credentialsExpired;
    private boolean enabled;

}
