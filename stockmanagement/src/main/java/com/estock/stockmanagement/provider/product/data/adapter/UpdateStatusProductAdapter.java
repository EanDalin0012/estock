package com.estock.stockmanagement.provider.product.data.adapter;

import com.estock.stockmanagement.common.adapter.CommonAdapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateStatusProductAdapter extends CommonAdapter {
	private int id;
	private String status;
}
