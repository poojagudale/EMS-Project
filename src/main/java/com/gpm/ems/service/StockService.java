package com.gpm.ems.service;

import com.gpm.ems.dto.StockDto;
import java.util.List;

public interface StockService {
    List<StockDto> getAllStocks();
    StockDto getStockByBarcode(String barcode);
    StockDto addStock(StockDto stockDto);
    StockDto decreaseStock(String barcode, int amount);
    StockDto increaseStock(String barcode, int amount);
    StockDto updateStockById(Long id, StockDto stockDto);
}
