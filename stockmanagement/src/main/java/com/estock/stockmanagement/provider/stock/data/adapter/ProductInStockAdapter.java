package com.estock.stockmanagement.provider.stock.data.adapter;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
public class ProductInStockAdapter {
    private int productID;
    private String productName;
    private int totalQty;
}
