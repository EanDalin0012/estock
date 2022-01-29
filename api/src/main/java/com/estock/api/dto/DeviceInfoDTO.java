package com.estock.api.dto;

import com.estock.api.common.dto.CommonDTO;
import lombok.*;


@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class DeviceInfoDTO extends CommonDTO {
    private int id;
    private String userAgent;
    private String os;
    private String browser;
    private String device;
    private String osVersion;
    private String browserVersion;
    private String deviceType;
    private String orientation;
    private String networkIP;
}
