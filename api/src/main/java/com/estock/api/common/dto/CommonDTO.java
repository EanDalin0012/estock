package com.estock.api.common.dto;

import com.estock.api.util.SystemDateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class CommonDTO {
    private int userID;
    private String createdBy;
    private String dateTime;
    private String status;
    public CommonDTO() {
        dateTime = SystemDateUtil.getLocalDate("yyyyMMdd hh:mm:ss");
    }
}
