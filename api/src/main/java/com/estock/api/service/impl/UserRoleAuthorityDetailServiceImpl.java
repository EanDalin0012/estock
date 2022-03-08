package com.estock.api.service.impl;

import com.estock.api.common.constant.CommonConstant;
import com.estock.api.common.constant.StatusCode;
import com.estock.api.common.exception.CustomException;
import com.estock.api.dao.UserRoleAuthorityDetailDAO;
import com.estock.api.dto.UserRoleAuthorityDetailDTO;
import com.estock.api.service.UserRoleAuthorityDetailService;
import com.estock.api.util.Utility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Slf4j
public class UserRoleAuthorityDetailServiceImpl implements UserRoleAuthorityDetailService {

    @Autowired
    private UserRoleAuthorityDetailDAO userRoleAuthorityDetail;

    @Override
    public Collection<UserRoleAuthorityDetailDTO> inquiry() throws CustomException {
        log.info("-------------------- Start Service User Role Authority Detail -------------------");
        try {
            Collection<UserRoleAuthorityDetailDTO> userRoleAuthorityDetails = this.userRoleAuthorityDetail.inquiry(StatusCode.DELETED.name());
            log.info("------------- UserRoleAuthorityDetail Data =>"+ Utility.toJSON(userRoleAuthorityDetails));
            return userRoleAuthorityDetails;
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(CommonConstant.GENERAL_FAIL_EXCEPTION.name(), e.getMessage());
        }
    }
}
