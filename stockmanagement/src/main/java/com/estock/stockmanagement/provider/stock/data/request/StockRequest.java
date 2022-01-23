package com.estock.stockmanagement.provider.stock.data.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
public class StockRequest {
    private int productID;
    private int qty;
    private double price;
}
