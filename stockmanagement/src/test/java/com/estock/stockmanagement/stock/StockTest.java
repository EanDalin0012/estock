package com.estock.stockmanagement.stock;

import com.estock.stockmanagement.common.exception.CustomExceptiondkaflkd;
import com.estock.stockmanagement.provider.stock.data.adapter.ProductInStockAdapter;
import com.estock.stockmanagement.provider.stock.data.request.StockRequest;
import com.estock.stockmanagement.provider.stock.service.StockService;
import com.estock.stockmanagement.util.Utility;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StockTest {
    private static final Logger log = Logger.getLogger(StockTest.class.getName());

    @Autowired
    private StockService stockService;

    @Test
    void addNewStock() {
        try {
            StockRequest stockRequest1 = new StockRequest();
            stockRequest1.setProductID(1);
            stockRequest1.setPrice(22);
            stockRequest1.setQty(2);
            int save1 = this.stockService.addNewStockIn(stockRequest1, 1);
        }catch (Exception e) {
            e.printStackTrace();
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }
    @Test
    void inquiryProductInStock() {
        try {
            List<ProductInStockAdapter> list = this.stockService.inquiryProductInStock(1);
            log.info("inquiryProductInStock Test Data :"+ Utility.toJSON(list));
        }catch (Exception e) {
            e.printStackTrace();
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

    @Test
    void inquiryProductInStockByProductID() {
        try {
            List<ProductInStockAdapter> list = this.stockService.inquiryProductInStockByProductID(1, 2);
            log.info("inquiryProductInStock Test Data :"+ Utility.toJSON(list));
        }catch (Exception e) {
            e.printStackTrace();
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }
}
