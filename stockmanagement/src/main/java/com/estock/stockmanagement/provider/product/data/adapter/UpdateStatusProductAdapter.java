package com.estock.stockmanagement.provider.product.data.adapter;

import com.estock.stockmanagement.common.adapter.CommonAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateStatusProductAdapter extends CommonAdapter {
	private int id;
	private String status;
}
