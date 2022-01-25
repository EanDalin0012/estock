package com.api.stockmanagement.provider.customer.data.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerRequest {
    private int id;
    @NotNull
    @NotBlank(message = "Invalid")
    private String customerName;
    @NotNull
    @Size(min = 9, max = 10)
    @NotBlank(message = "Invalid")
    private String customerPhone;
    private int resourceID;
    private String desc;
}
