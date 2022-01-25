package com.api.stockmanagement.customer;

import com.api.stockmanagement.common.exception.CustomException;
import com.api.stockmanagement.provider.customer.data.request.CustomerRequest;
import com.api.stockmanagement.provider.customer.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerTest {
    @Autowired
    private CustomerService customerService;
    @Test
    void addNewCustomer() {
        try {
            CustomerRequest customerRequest = new CustomerRequest();
            customerRequest.setCustomerName("Ean Dalin");
            customerRequest.setDesc("test");
            int save = this.customerService.addNewCustomer(customerRequest, 1);
        }catch (Exception | CustomException e) {
            e.printStackTrace();
        }
    }
}
