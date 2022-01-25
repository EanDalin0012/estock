package com.api.stockmanagement.provider.customer.service.impl;

import com.api.stockmanagement.common.StatusCode;
import com.api.stockmanagement.common.exception.CustomException;
import com.api.stockmanagement.dao.customer.CustomerDAO;
import com.api.stockmanagement.provider.customer.constant.CustomerConstant;
import com.api.stockmanagement.provider.customer.data.adapter.CustomerAdapter;
import com.api.stockmanagement.provider.customer.data.request.CustomerRequest;
import com.api.stockmanagement.provider.customer.mapper.CustomerMapper;
import com.api.stockmanagement.provider.customer.service.CustomerService;
import com.api.stockmanagement.util.Utility;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.Valid;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static Logger log = Logger.getLogger(CustomerServiceImpl.class.getName());

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public int addNewCustomer(@Valid CustomerRequest customerRequest, int userID) throws CustomException {
        log.info("======= Start Add New Customer ==============");
        try {
            if (customerRequest.getCustomerName().isEmpty()) {
                throw new CustomException(CustomerConstant.INVALID_CUSTOMER_NAME.name(), CustomerConstant.INVALID_CUSTOMER_NAME.getTextValue());
            }
            CustomerAdapter customerAdapter = CustomerMapper.INSTANCE.convert(customerRequest);
            customerAdapter.setId(this.count());
            customerAdapter.setStatus(StatusCode.INSERT.name());
            customerAdapter.setId(userID);
            log.info("Customer Info :"+ Utility.toJSON(customerAdapter));
            int save = this.customerDAO.addNewCustomer(customerAdapter);
            log.info("Save :"+save);
            return save;
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    @Override
    public int updateCustomer(CustomerRequest customerRequest,int userID) throws CustomException {
        log.info("======== Start Update Customer =====");
        try {
            log.info("CustomerRequest :"+Utility.toJSON(customerRequest));
            if (customerRequest.getId() <= 0) {
                throw new CustomException(CustomerConstant.INVALID_CUSTOMER_NAME.name(), CustomerConstant.INVALID_CUSTOMER_NAME.getTextValue());
            }
            if (customerRequest.getCustomerName().isEmpty()) {
                throw new CustomException(CustomerConstant.INVALID_CUSTOMER_NAME.name(), CustomerConstant.INVALID_CUSTOMER_NAME.getTextValue());
            }

            CustomerAdapter customerAdapter = CustomerMapper.INSTANCE.convert(customerRequest);
            customerAdapter.setUserID(userID);
            customerAdapter.setStatus(StatusCode.UPDATE.name());
            log.info("customerAdapter :"+Utility.toJSON(customerAdapter));
            int update = this.customerDAO.updateCustomer(customerAdapter);
            log.info("Update :"+update);
            return update;
        }catch (Exception e){
            log.error("Error Update Customer :", e);
            throw e;
        }
    }

    @Override
    public int deleteCustomer(int customerID, int userID) throws CustomException {
        log.info("===== Start Delete Customer ======");
        try {
            if (customerID <= 0) {
                throw new CustomException(CustomerConstant.INVALID_CUSTOMER_ID.name(), CustomerConstant.INVALID_CUSTOMER_ID.getTextValue());
            }
            log.info("Customer ID:"+customerID+",User ID :"+userID);
            int delete = this.customerDAO.deleteCustomer(customerID,userID, StatusCode.DELETE.name());
            return delete;
        }catch (Exception e) {
            log.error("Delete Customer :", e);
            throw e;
        }
    }

    @Override
    public CustomerAdapter inquiryCustomerById(int customerID) throws CustomException {
        return null;
    }

    @Override
    public List<CustomerAdapter> inquiryCustomer() throws CustomException {
        return null;
    }

    @Override
    public int count() {
        return this.customerDAO.count() + 1;
    }
}
