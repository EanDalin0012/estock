package com.estock.api.service.impl;

import com.estock.api.common.constant.CommonConstant;
import com.estock.api.common.constant.StatusCode;
import com.estock.api.common.exception.CustomException;
import com.estock.api.dao.UserRoleAuthorityDAO;
import com.estock.api.dao.UserRoleDAO;
import com.estock.api.dto.UserRoleAuthorityDTO;
import com.estock.api.dto.UserRoleDTO;
import com.estock.api.mapper.UserRoleMapper;
import com.estock.api.service.UserRoleService;
import com.estock.api.service.constant.UserRoleConstant;
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
public class UserRoleServiceImpl implements UserRoleService {
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
    public int save(UserRoleRequestVO userRoleRequestVO, int userId) throws CustomException {
        log.info("------------ Start Service Insert User Role ---------------");
        TransactionStatus transactionStatus = this.transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            log.info("------------ User Role Request Vo Data -> {} "+Utility.toJSON(userRoleRequestVO));

            if (userRoleRequestVO.getRole().equals("") || userRoleRequestVO.getRole() == null) {
                throw new CustomException(UserRoleConstant.INVALID_ROLE_NAME.name(), UserRoleConstant.INVALID_ROLE_NAME.getDesc());
            }

            UserRoleDTO userRoleDTO = UserRoleMapper.INSTANCE.userRoleMapper(userRoleRequestVO);
            userRoleDTO.setUserID(userId);
            userRoleDTO.setStatus(StatusCode.ACTIVE.name());
            log.info("------------ User Role DTO Data -> {} "+Utility.toJSON(userRoleDTO));
            int roleId = this.count();
            userRoleDTO.setId(roleId);
            List<UserRoleAuthorityDTO> userRoleAuthorities = new ArrayList<>();
            int length = userRoleRequestVO.getAuthorities().length;
            if (length > 0) {
                for (int authId: userRoleRequestVO.getAuthorities()) {
                    userRoleAuthorities.add(new UserRoleAuthorityDTO(roleId, authId));
                }
            }
            log.info("------------ List Of User Role Authority DTO Data -> {} "+Utility.toJSON(userRoleAuthorities));
            int saveUserRole = this.userRoleDAO.addUserRole(userRoleDTO);
            int saveUserRoleAuthority = 0 ;
            if (userRoleAuthorities.size() > 0 ) {
                saveUserRoleAuthority = this.userRoleAuthorityDAO.addUserRoleAuthority(userRoleAuthorities);
            }


            log.info("------------ Save User Role Data -> {} "+saveUserRole);
            log.info("------------ Save User Role Authority Data -> {} "+saveUserRoleAuthority);
            if (saveUserRole > 0 || (saveUserRole > 0 && length > 0 && saveUserRoleAuthority> 0)) {
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
    public int edit(UserRoleRequestVO userRoleRequestVO, int userId) throws CustomException {
        log.info("------------ Start Service Update User Role ---------------");
        TransactionStatus transactionStatus = this.transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            log.info("------------ Edit User Role Request Vo Data -> {} "+Utility.toJSON(userRoleRequestVO));
            if (userRoleRequestVO.getId() <= 0) {
                throw new CustomException(UserRoleConstant.INVALID_ROLE_ID.name(), UserRoleConstant.INVALID_ROLE_ID.getDesc());
            }
            if (userRoleRequestVO.getRole().equals("") || userRoleRequestVO.getRole() == null) {
                throw new CustomException(UserRoleConstant.INVALID_ROLE_NAME.name(), UserRoleConstant.INVALID_ROLE_NAME.getDesc());
            }
            UserRoleDTO userRoleDTO = UserRoleMapper.INSTANCE.userRoleMapper(userRoleRequestVO);
            userRoleDTO.setStatus(StatusCode.EDIT.name());
            log.info("------------ User Role DTO Data -> {} "+Utility.toJSON(userRoleDTO));

            List<UserRoleAuthorityDTO> userRoleAuthorities = new ArrayList<>();
            int length = userRoleRequestVO.getAuthorities().length;
            if (length > 0) {
                for (int authId: userRoleRequestVO.getAuthorities()) {
                    userRoleAuthorities.add(new UserRoleAuthorityDTO(userRoleDTO.getId(), authId));
                }
            }
            log.info("------------ List Of User Role Authority DTO Data -> {} "+Utility.toJSON(userRoleAuthorities));
            int editUserRole = this.userRoleDAO.editUserRole(userRoleDTO);
            int deleteUserRoleAuthority = this.userRoleAuthorityDAO.deleteUserRoleAuthority(userRoleDTO.getId());
            int saveUserRoleAuthority = 0 ;
            if (userRoleAuthorities.size() > 0 ) {
                saveUserRoleAuthority = this.userRoleAuthorityDAO.addUserRoleAuthority(userRoleAuthorities);
            }
            if (editUserRole > 0 || (editUserRole > 0 && length > 0 && saveUserRoleAuthority> 0)) {
                this.transactionManager.commit(transactionStatus);
                return 1;
            }
        }catch (Exception e) {
            e.printStackTrace();
            this.transactionManager.rollback(transactionStatus);
            throw new CustomException(CommonConstant.GENERAL_FAIL_EXCEPTION.name(), CommonConstant.GENERAL_FAIL_EXCEPTION.getDesc());
        }
        return 0;
    }

    @Override
    public int delete(int roleId) throws CustomException {
        try {
            if (roleId <= 0) {
                throw new CustomException(UserRoleConstant.INVALID_ROLE_ID.name(), UserRoleConstant.INVALID_ROLE_ID.getDesc());
            }
            int delete = this.userRoleAuthorityDAO.deleteUserRoleAuthority(roleId);
            int deleteUserRole = this.userRoleDAO.deleteUserRole(roleId);
            if (deleteUserRole > 0) {
                return 1;
            }
        }catch (Exception e) {
            e.printStackTrace();
            throw new CustomException(CommonConstant.GENERAL_FAIL_EXCEPTION.name(), e.getMessage());
        }
        return 0;
    }

    @Override
    public Collection<UserRoleDTO> inquiryUserRole() throws CustomException {
        log.info("------------ Start Service Inquiry User Role ---------------");
        try {
            Collection<UserRoleDTO> userRoles = this.userRoleDAO.inquiryUserRole(StatusCode.ACTIVE.name());
            log.info("--------- UserRoles Data =>"+ Utility.toJSON(userRoles));
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
