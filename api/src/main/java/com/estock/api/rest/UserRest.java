package com.estock.api.rest;

import com.estock.api.common.constant.ResponseCode;
import com.estock.api.common.exception.CustomException;
import com.estock.api.dto.UserInfoDTO;
import com.estock.api.service.UserInfoService;
import com.estock.api.util.Utility;
import com.estock.api.vo.ResponseVO;
import com.estock.api.vo.request.LoadUserRequestVO;
import com.estock.api.vo.request.UserInfoRequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/user-info")
@Slf4j
public class UserRest {
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping(value = "/")
    public ResponseVO<List<UserInfoDTO>> index() {
        ResponseVO<List<UserInfoDTO>> listResponseVO = new ResponseVO<>();
        try{
            List<UserInfoDTO> userInfoDTOList = new ArrayList<>();
            for (int i = 1; i <100000 ; i++) {
                UserInfoDTO userInfoDTO = new UserInfoDTO();
                userInfoDTO.setId(i);
                userInfoDTO.setFirstName("first - name "+i);
                userInfoDTO.setLastName("last - name "+i);
                userInfoDTO.setDateBirth("birt date "+i);
                userInfoDTO.setGender("male");
                userInfoDTO.setUserID(1);
                userInfoDTO.setDesc("desc "+1);
                userInfoDTO.setStatus("Enable");
                userInfoDTO.setResourceID(1);
                userInfoDTOList.add(userInfoDTO);
            }
            listResponseVO.setBody(userInfoDTOList);
            listResponseVO.setResultCode("200");
            listResponseVO.setResultMessage("Success");
            log.info("response info:"+ Utility.toJSON(listResponseVO));
        }catch (Exception e) {
            listResponseVO.setResultCode("500");
            listResponseVO.setResultMessage("fail");
            e.printStackTrace();
            throw e;
        }
        return listResponseVO;
    }

    @PostMapping(value = "/load-user-info")
    public ResponseVO<UserInfoDTO> loadUserInfo(@RequestBody LoadUserRequestVO loadUserRequestVO) {
        ResponseVO<UserInfoDTO> responseVO = new ResponseVO<>();
        try {
            UserInfoDTO userInfoDTO = this.userInfoService.loadUserByUserName(loadUserRequestVO.getUserName());
            if (userInfoDTO != null) {
                responseVO.setBody(userInfoDTO);
                responseVO.setResultCode(ResponseCode.SUCCESS.getCode());
                responseVO.setResultMessage(ResponseCode.SUCCESS.name());
                return responseVO;
            }
        }catch (Exception e) {
            e.printStackTrace();
            responseVO.setResultMessage(e.getMessage());
        } catch (CustomException e) {
            e.printStackTrace();
            responseVO.setResultMessage(e.getMessage());
        }
        responseVO.setResultCode(ResponseCode.FAIL.getCode());
        return responseVO;
    }

    @PostMapping(value = "/update")
    public  ResponseVO<UserInfoDTO> updateUserInfo(@RequestBody UserInfoRequestVO userInfoRequestVO, @RequestParam("userId") int userId) {
        log.info("----------- updateUserInfo Data:"+Utility.toJSON(userInfoRequestVO));
        log.info("----------- userId Data:"+userId);
        ResponseVO<UserInfoDTO> userInfoDTOResponseVO = new ResponseVO<>();
        userInfoDTOResponseVO.setResultCode(ResponseCode.SUCCESS.getCode());
        userInfoDTOResponseVO.setResultMessage(ResponseCode.SUCCESS.name());
        return userInfoDTOResponseVO;
    }

}
