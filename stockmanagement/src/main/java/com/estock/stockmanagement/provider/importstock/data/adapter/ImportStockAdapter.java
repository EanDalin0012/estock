package com.estock.stockmanagement.provider.importstock.data.adapter;

import com.estock.stockmanagement.common.adapter.CommonAdapter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ImportStockAdapter extends CommonAdapter{
	private int id;
	private String importStockName;
	private String desc;
}
