package com.estock.stockmanagement.provider.stock.service;

import com.estock.stockmanagement.common.exception.CustomException;
import com.estock.stockmanagement.provider.stock.data.adapter.ProductInStockAdapter;
import com.estock.stockmanagement.provider.stock.data.adapter.StockAdapter;
import com.estock.stockmanagement.provider.stock.data.adapter.StockUpdateQtyAdapter;
import com.estock.stockmanagement.provider.stock.data.request.StockRequest;

import java.util.List;

public interface StockService {
    int addNewStockIn(StockRequest stockRequest, int userID) throws CustomException;
    int updateStockQty(StockUpdateQtyAdapter stockUpdateQtyAdapter) throws CustomException;
    StockAdapter inquiryByStockID(int id) throws CustomException;
    ProductInStockAdapter countProductInStock() throws CustomException;
    ProductInStockAdapter countProductInStock(int productID) throws CustomException;
    List<ProductInStockAdapter> inquiryProductInStock(int userId) throws CustomException;
    List<ProductInStockAdapter> inquiryProductInStockByProductID(int userID,int productId) throws CustomException;
    int count();
}
