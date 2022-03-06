package com.estock.api.rest;

import com.estock.api.common.constant.CommonConstant;
import com.estock.api.common.exception.CustomException;
import com.estock.api.dto.UserRoleAuthorityDetailDTO;
import com.estock.api.service.UserRoleAuthorityDetailService;
import com.estock.api.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "/api/user-role-authority-detail")
@Slf4j
public class UserRoleAuthorityDetailRest {
    @Autowired
    private UserRoleAuthorityDetailService userRoleAuthorityDetailService;

    @GetMapping(value = "/index")
    public ResponseVO<Collection<UserRoleAuthorityDetailDTO>> index() {
        log.info("---------- Start UserRoleAuthorityDetail API ----------");
        ResponseVO<Collection<UserRoleAuthorityDetailDTO>> response = new ResponseVO<>();
        try {
            Collection<UserRoleAuthorityDetailDTO> userRoleAuthorityDetail = this.userRoleAuthorityDetailService.inquiry();
            response.setBody(userRoleAuthorityDetail);
            response.setResultCode(CommonConstant.SUCCESS.name());
            response.setResultMessage(CommonConstant.SUCCESS.getDesc());
        }catch (Exception | CustomException e) {
            e.printStackTrace();
            response.setResultCode(CommonConstant.GENERAL_FAIL_EXCEPTION.name());
            response.setResultMessage(e.getMessage());
        }
        return response;
    }
}
