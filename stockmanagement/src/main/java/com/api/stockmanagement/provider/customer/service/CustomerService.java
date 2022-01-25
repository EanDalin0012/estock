package com.api.stockmanagement.provider.customer.service;

import com.api.stockmanagement.common.exception.CustomException;
import com.api.stockmanagement.provider.customer.data.adapter.CustomerAdapter;
import com.api.stockmanagement.provider.customer.data.request.CustomerRequest;

import java.util.List;

public interface CustomerService {
    int addNewCustomer(CustomerRequest customerRequest, int userID) throws CustomException;
    int updateCustomer(CustomerRequest customerRequest, int userID) throws CustomException;
    int deleteCustomer(int customerID, int userID) throws CustomException;
    CustomerAdapter inquiryCustomerById(int customerID) throws CustomException;
    List<CustomerAdapter> inquiryCustomer() throws CustomException;
    int count();
}
