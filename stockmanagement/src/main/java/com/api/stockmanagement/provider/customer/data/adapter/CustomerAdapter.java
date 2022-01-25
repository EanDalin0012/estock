package com.api.stockmanagement.provider.customer.data.adapter;

import com.api.stockmanagement.common.adapter.CommonAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class CustomerAdapter extends CommonAdapter {
    @NotNull
    private int id;
    @NotBlank(message = "Email is mandatory")
    private String customerName;
    @Size(min = 9, max = 10)
    @NotBlank(message = "Email is mandatory")
    private String customerPhone;
    private int resourceID;
    private String desc;
}
