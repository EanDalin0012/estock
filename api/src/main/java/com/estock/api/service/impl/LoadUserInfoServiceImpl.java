package com.estock.api.service.impl;

import com.estock.api.common.exception.CustomException;
import com.estock.api.dao.LoadUserInfoDAO;
import com.estock.api.dto.LoadUserInfoDTO;
import com.estock.api.service.LoadUserInfoService;
import com.estock.api.service.constant.ServiceConstant;
import com.estock.api.util.Utility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoadUserInfoServiceImpl implements LoadUserInfoService {
    @Autowired
    private LoadUserInfoDAO loadUserInfoDAO;

    @Override
    public LoadUserInfoDTO loadUserInfo(String userName) throws CustomException {
        try {
            if (userName.equals("") || userName == null) {
                throw new CustomException(ServiceConstant.INVALID_USER_NAME.name(), ServiceConstant.INVALID_USER_NAME.getDesc());
            }
            LoadUserInfoDTO loadUserInfoDTO = this.loadUserInfoDAO.loadUserInfo(userName);
            log.info("LoadUserInfoDTO Data =>"+ Utility.toJSON(loadUserInfoDTO));
            return loadUserInfoDTO;
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(ServiceConstant.GENERAL_FAIL_EXCEPTION.name(), ServiceConstant.GENERAL_FAIL_EXCEPTION.getDesc());
        }
    }
}
