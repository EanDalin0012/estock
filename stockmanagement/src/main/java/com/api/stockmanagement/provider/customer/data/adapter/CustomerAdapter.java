package com.api.stockmanagement.provider.customer.data.adapter;

import com.api.stockmanagement.common.adapter.CommonAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class CustomerAdapter extends CommonAdapter {
    private int id;
    private String customerName;
    private String customerPhone;
    private int resourceID;
    private String desc;
}
