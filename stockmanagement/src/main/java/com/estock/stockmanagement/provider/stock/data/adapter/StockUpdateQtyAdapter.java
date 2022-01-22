package com.estock.stockmanagement.provider.stock.data.adapter;

import com.estock.stockmanagement.common.adapter.CommonAdapter;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
public class StockUpdateQtyAdapter extends CommonAdapter {
    private int stockId;
    private int qty;
}
