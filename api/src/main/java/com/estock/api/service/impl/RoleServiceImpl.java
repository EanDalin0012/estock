package com.estock.api.service.impl;

import com.estock.api.common.constant.CommonConstant;
import com.estock.api.common.constant.StatusCode;
import com.estock.api.common.exception.CustomException;
import com.estock.api.dao.UserRoleAuthorityDAO;
import com.estock.api.dao.UserRoleDAO;
import com.estock.api.dto.UserRoleAuthorityDTO;
import com.estock.api.dto.UserRoleDTO;
import com.estock.api.mapper.UserRoleMapper;
import com.estock.api.service.RoleService;
import com.estock.api.util.Utility;
import com.estock.api.vo.request.UserRoleRequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {
    @Autowired
    private UserRoleDAO userRoleDAO;
    @Autowired
    private UserRoleAuthorityDAO userRoleAuthorityDAO;
    @Autowired
    private PlatformTransactionManager transactionManager;

    @Override
    @PreAuthorize("hasAuthority('READ_ROLE')")
    public List<UserRoleDTO> userRoles() {
        log.info("------------ Start Service Inquiry User Role ---------------");
        return null;
    }

    @Override
    @PreAuthorize("hasAuthority('ADD_ROLE')")
    public int save(UserRoleRequestVO userRoleRequestVO) throws CustomException {
        log.info("------------ Start Service Insert User Role ---------------");
        TransactionStatus transactionStatus = this.transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            UserRoleDTO userRoleDTO = UserRoleMapper.INSTANCE.userRoleMapper(userRoleRequestVO);
            int roleId = this.count();
            userRoleDTO.setId(roleId);
            List<UserRoleAuthorityDTO> userRoleAuthorities = new ArrayList<>();
            int length = userRoleRequestVO.getAuthorities().length;
            if (length > 0) {
                for (int authId: userRoleRequestVO.getAuthorities()) {
                    userRoleAuthorities.add(new UserRoleAuthorityDTO(roleId, authId));
                }
            }
            int saveUserRole = this.userRoleDAO.addUserRole(userRoleDTO);
            int saveUserRoleAuthority = this.userRoleAuthorityDAO.addUserRoleAuthority(userRoleAuthorities);
            if (saveUserRole > 0 && saveUserRoleAuthority > 0) {
                this.transactionManager.commit(transactionStatus);
                return 1;
            } else {
                return 0;
            }

        }catch (Exception e) {
            e.printStackTrace();
            this.transactionManager.rollback(transactionStatus);
            throw new CustomException(CommonConstant.GENERAL_FAIL_EXCEPTION.name(), CommonConstant.GENERAL_FAIL_EXCEPTION.getDesc());
        }
    }

    @Override
    @PreAuthorize("hasAuthority('EDIT_ROLE')")
    public int edit(UserRoleRequestVO userRoleRequestVO) throws CustomException {
        log.info("------------ Start Service Update User Role ---------------");
        return 0;
    }

    @Override
    public Collection<UserRoleDTO> inquiryUserRole() throws CustomException {
        log.info("------------ Start Service Inquiry User Role ---------------");
        try {
            Collection<UserRoleDTO> userRoles = this.userRoleDAO.inquiryUserRole(StatusCode.ACTIVE.name());
            log.info("UserRoles Data =>"+ Utility.toJSON(userRoles));
            return userRoles;
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(CommonConstant.GENERAL_FAIL_EXCEPTION.name(),CommonConstant.GENERAL_FAIL_EXCEPTION.getDesc());
        }
    }

    private int count() {
        return this.userRoleDAO.count() + 1;
    }

}
