package com.estock.api.rest;

import com.estock.api.common.constant.CommonConstant;
import com.estock.api.common.exception.CustomException;
import com.estock.api.dto.LoadUserInfoDTO;
import com.estock.api.service.LoadUserInfoService;
import com.estock.api.service.constant.ServiceConstant;
import com.estock.api.vo.ResponseVO;
import com.estock.api.vo.request.LoadUserRequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/load-user")
@Slf4j
public class LoadUserInfoRest {
    @Autowired
    private LoadUserInfoService userInfoService;

    @PostMapping(value = "/index")
    public ResponseVO<LoadUserInfoDTO> index(@RequestBody LoadUserRequestVO loadUserRequest) {
        ResponseVO<LoadUserInfoDTO> response = new ResponseVO<>();
        try {
            LoadUserInfoDTO loadUserInfoDTO = this.userInfoService.loadUserInfo(loadUserRequest.getUserName());
            response.setBody(loadUserInfoDTO);
            response.setResultMessage(CommonConstant.SUCCESS.getDesc());
            response.setResultCode(CommonConstant.SUCCESS.name());
        }catch (Exception e) {
            e.printStackTrace();
            response.setResultCode(CommonConstant.GENERAL_FAIL_EXCEPTION.name());
            response.setResultMessage(CommonConstant.GENERAL_FAIL_EXCEPTION.getDesc());
        } catch (CustomException e) {
            response.setResultCode(e.getMessageCode());
            response.setResultMessage(e.getMessage());
        }
        return response;
    }
}
