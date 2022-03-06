package com.estock.api.rest;

import com.estock.api.common.constant.CommonConstant;
import com.estock.api.common.exception.CustomException;
import com.estock.api.service.UserRoleService;
import com.estock.api.vo.ResponseVO;
import com.estock.api.vo.request.UserRoleRequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user-role")
@Slf4j
public class UserRoleRest {
    @Autowired
    private UserRoleService userRoleService;

    @PostMapping(value = "/save")
    public ResponseVO<Boolean> save(@RequestBody UserRoleRequestVO userRoleRequest) {
        ResponseVO<Boolean> response = new ResponseVO<>();
        try {
            int save = this.userRoleService.save(userRoleRequest);
            if (save > 0) {
                response.setResultCode(CommonConstant.SUCCESS.name());
                response.setResultMessage(CommonConstant.SUCCESS.name());
                response.setBody(true);
            } else {
                response.setResultCode(CommonConstant.FAIL.name());
                response.setResultMessage(CommonConstant.FAIL.name());
                response.setBody(false);
            }
            return response;
        }catch (Exception e) {
            e.printStackTrace();
            response.setResultCode(CommonConstant.GENERAL_FAIL_EXCEPTION.name());
            response.setResultMessage(e.getMessage());
        } catch (CustomException e) {
            e.printStackTrace();
            response.setResultCode(e.getMessageCode());
            response.setResultMessage(e.getMessage());
        }
        return response;
    }
}
