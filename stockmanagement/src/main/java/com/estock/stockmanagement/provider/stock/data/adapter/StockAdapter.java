package com.estock.stockmanagement.provider.stock.data.adapter;

import com.estock.stockmanagement.common.adapter.CommonAdapter;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
public class StockAdapter extends CommonAdapter {
    private int id;
    private int productID;
    private int qty;
    private double price;
}
