package com.api.stockmanagement.dao.customer;

import com.api.stockmanagement.provider.customer.data.adapter.CustomerAdapter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerDAO {
    int addNewCustomer(CustomerAdapter customerAdapter);
    int updateCustomer(CustomerAdapter customerAdapter);
    int deleteCustomer(@Param("customerID") int customerID, @Param("userID") int userID, @Param("Status") String Status);
    CustomerAdapter inquiryCustomerById(int customerID);
    List<CustomerAdapter> inquiryCustomer();
    int count();
}
