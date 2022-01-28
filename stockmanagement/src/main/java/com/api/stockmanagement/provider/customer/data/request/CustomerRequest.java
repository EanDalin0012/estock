package com.api.stockmanagement.provider.customer.data.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerRequest {
    private int id;

    private String customerName;

    private String customerPhone;
    private int resourceID;
    private String desc;
}
