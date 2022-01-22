package com.estock.stockmanagement.dao.stock;

import com.estock.stockmanagement.provider.stock.data.adapter.ProductInStockAdapter;
import com.estock.stockmanagement.provider.stock.data.adapter.StockAdapter;
import com.estock.stockmanagement.provider.stock.data.adapter.StockUpdateQtyAdapter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StockDAO {
    int addNewStockIn(StockAdapter stockAdapter);
    int updateStockQty(StockUpdateQtyAdapter stockUpdateQtyAdapter);
    StockAdapter inquiryByStockID(int id);
    List<StockAdapter> inquiryAllStock();
    List<StockAdapter> inquiryStockByProductId(int productID);
    List<ProductInStockAdapter> inquiryProductInStock(int userID);
    List<ProductInStockAdapter> inquiryProductInStockByProductID(@Param("userID") int userID, @Param("productID") int productID);
    int count();
}
