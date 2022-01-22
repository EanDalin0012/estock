package com.estock.stockmanagement.provider.stock.service.impl;

import com.estock.stockmanagement.common.exception.CustomException;
import com.estock.stockmanagement.dao.stock.StockDAO;
import com.estock.stockmanagement.provider.stock.constants.StockConstant;
import com.estock.stockmanagement.provider.stock.constants.StockStatus;
import com.estock.stockmanagement.provider.stock.data.adapter.ProductInStockAdapter;
import com.estock.stockmanagement.provider.stock.data.adapter.StockAdapter;
import com.estock.stockmanagement.provider.stock.data.adapter.StockUpdateQtyAdapter;
import com.estock.stockmanagement.provider.stock.data.request.StockRequest;
import com.estock.stockmanagement.provider.stock.mapper.StockMapper;
import com.estock.stockmanagement.provider.stock.service.StockService;
import com.estock.stockmanagement.util.Utility;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {
    private static final Logger log = Logger.getLogger(StockServiceImpl.class.getName());

    @Autowired
    private StockDAO stockDAO;

    @Override
    public int addNewStockIn(StockRequest stockRequest, int userID) throws CustomException {
        log.info("========= Start Add New Stock ==========");
        try {
            log.info("StockRequest Data "+ Utility.toJSON(stockRequest));
            int count = this.count();
            StockAdapter stockAdapter = StockMapper.INSTANCE.convert(stockRequest);
            stockAdapter.setId(count);
            stockAdapter.setUserId(userID);
            stockAdapter.setStutas(StockStatus.A.name());
            log.info("StockAdapter Data "+ Utility.toJSON(stockAdapter));

            if (stockAdapter.getPrice() <= 0 ) {
                throw new CustomException(StockConstant.INVALID_PRICE.name(), StockConstant.INVALID_PRICE.getTextValue());
            }
            if (stockAdapter.getProductID() <= 0) {
                throw new CustomException(StockConstant.INVALID_PRODUCT_ID.name(), StockConstant.INVALID_PRODUCT_ID.getTextValue());
            }
            if (stockAdapter.getQty() <= 0 ) {
                throw new CustomException(StockConstant.INVALID_QTY.name(), StockConstant.INVALID_QTY.getTextValue());
            }

            int save = this.stockDAO.addNewStockIn(stockAdapter);
            log.info("Save New Stock : "+ save);
            return save;
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public int updateStockQty(StockUpdateQtyAdapter stockUpdateQtyAdapter) throws CustomException{
        log.info("======== Start Update Stock Qty ===========");
        try {
            log.info("StockUpdateQtyAdapter Data"+Utility.toJSON(stockUpdateQtyAdapter));
            if (stockUpdateQtyAdapter.getQty() <=0 ) {
                throw new CustomException(StockConstant.INVALID_QTY.name(), StockConstant.INVALID_QTY.getTextValue());
            }
            if (stockUpdateQtyAdapter.getStockId() <=0 ) {
                throw new CustomException(StockConstant.INVALID_STOCK_ID.name(), StockConstant.INVALID_STOCK_ID.getTextValue());
            }

            StockAdapter stockAdapter = this.inquiryByStockID(stockUpdateQtyAdapter.getStockId());
            if (stockAdapter == null) {
                throw new CustomException(StockConstant.INVALID_STOCK_ID.name(), StockConstant.INVALID_STOCK_ID.getTextValue());
            }

            int save = this.stockDAO.updateStockQty(stockUpdateQtyAdapter);
            log.info("Save Update Qty :"+save);
            return save;
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public StockAdapter inquiryByStockID(int id) throws CustomException {
        log.info("======= Start Inquiry Stock By ID =======");
        try {
            if (id <=0 ) {
                throw new CustomException(StockConstant.INVALID_STOCK_ID.name(), StockConstant.INVALID_PRODUCT_ID.getTextValue());
            }
            StockAdapter data = this.stockDAO.inquiryByStockID(id);
            log.info("StockAdapter Data :"+Utility.toJSON(data));
            return data;
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ProductInStockAdapter countProductInStock() throws CustomException{

        return null;
    }

    @Override
    public ProductInStockAdapter countProductInStock(int productID) throws CustomException{
        return null;
    }

    @Override
    public List<ProductInStockAdapter> inquiryProductInStock(int userId) throws CustomException {
        log.info("======== Start Inquiry Product In Stock =========");
        try {
            if (userId <=0 ) {
                throw new CustomException(StockConstant.INVALID_USER_ID.name(), StockConstant.INVALID_USER_ID.getTextValue());
            }
            List<ProductInStockAdapter> list = this.stockDAO.inquiryProductInStock(userId);
            log.info("Start Inquiry Product In Stock Info :"+Utility.toJSON(list));
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<ProductInStockAdapter> inquiryProductInStockByProductID(int userID, int productID) throws CustomException {
        log.info("======== Start Inquiry Product In Stock =========");
        try {
            if (userID <=0 ) {
                throw new CustomException(StockConstant.INVALID_USER_ID.name(), StockConstant.INVALID_USER_ID.getTextValue());
            }

            if (productID <=0 ) {
                throw new CustomException(StockConstant.INVALID_PRODUCT_ID.name(), StockConstant.INVALID_PRODUCT_ID.getTextValue());
            }

            List<ProductInStockAdapter> list = this.stockDAO.inquiryProductInStockByProductID(userID, productID);
            log.info("Start Inquiry Product In Stock Info :"+Utility.toJSON(list));
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public int count() {
        return this.stockDAO.count() + 1;
    }
}
