package com.gpm.ems.mapper;

import com.gpm.ems.dto.StockDto;
import com.gpm.ems.entity.Stock;
import org.springframework.stereotype.Component;

@Component
public class StockMapper {

    public StockDto toDto(Stock stock) {
        StockDto dto = new StockDto();
        dto.setId(stock.getId());
        dto.setItemName(stock.getItemName());
        dto.setQuantity(stock.getQuantity());
        dto.setBarcode(stock.getBarcode());
        dto.setDate(stock.getDate());
        return dto;
    }

    public Stock toEntity(StockDto dto) {
        Stock stock = new Stock();
        stock.setId(dto.getId());
        stock.setItemName(dto.getItemName());
        stock.setQuantity(dto.getQuantity());
        stock.setBarcode(dto.getBarcode());
        stock.setDate(dto.getDate());
        return stock;
    }
}
