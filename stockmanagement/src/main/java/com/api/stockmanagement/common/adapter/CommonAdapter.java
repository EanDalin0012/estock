package com.api.stockmanagement.common.adapter;

import com.api.stockmanagement.common.StatusCode;
import com.api.stockmanagement.util.SystemDateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class CommonAdapter {
    private int userID;
    private String dateTime;
    private String status;

    public CommonAdapter() {
        dateTime = SystemDateUtil.getLocalDate("dd-MM-yyyy hh:mm:ss");
        this.status = StatusCode.INSERT.name();
    }
}
