package com.gpm.ems.service.impl;

import com.gpm.ems.dto.StockDto;
import com.gpm.ems.entity.Stock;
import com.gpm.ems.mapper.StockMapper;
import com.gpm.ems.repository.StockRepository;
import com.gpm.ems.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private StockMapper stockMapper;

    @Override
    public List<StockDto> getAllStocks() {
        List<Stock> stocks = stockRepository.findAll();
        return stocks.stream().map(stockMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public StockDto getStockByBarcode(String barcode) {
        Stock stock = stockRepository.findByBarcode(barcode)
                .orElseThrow(() -> new RuntimeException("Stock with barcode " + barcode + " not found"));
        return stockMapper.toDto(stock);
    }

    @Override
    public StockDto addStock(StockDto stockDto) {
        if (stockRepository.findByBarcode(stockDto.getBarcode()).isPresent()) {
            throw new RuntimeException("Stock with barcode " + stockDto.getBarcode() + " already exists");
        }
        if (stockRepository.findByItemName(stockDto.getItemName()).isPresent()) {
            throw new RuntimeException("Stock with item name " + stockDto.getItemName() + " already exists");
        }
        Stock stock = stockMapper.toEntity(stockDto);
        Stock savedStock = stockRepository.save(stock);
        return stockMapper.toDto(savedStock);
    }

    @Override
    public StockDto decreaseStock(String barcode, int amount) {
        Stock stock = stockRepository.findByBarcode(barcode)
                .orElseThrow(() -> new RuntimeException("Stock with barcode " + barcode + " not found"));

        if (stock.getQuantity() < amount) {
            throw new RuntimeException("Not enough stock available to decrease by " + amount);
        }

        stock.setQuantity(stock.getQuantity() - amount);
        Stock updatedStock = stockRepository.save(stock);
        return stockMapper.toDto(updatedStock);
    }

    @Override
    public StockDto increaseStock(String barcode, int amount) {
        Stock stock = stockRepository.findByBarcode(barcode)
                .orElseThrow(() -> new RuntimeException("Stock with barcode " + barcode + " not found"));

        stock.setQuantity(stock.getQuantity() + amount);
        Stock updatedStock = stockRepository.save(stock);
        return stockMapper.toDto(updatedStock);
    }

    @Override
    public StockDto updateStockById(Long id, StockDto stockDto) {
        Stock stock = stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock with ID " + id + " not found"));

        stock.setItemName(stockDto.getItemName());
        stock.setQuantity(stockDto.getQuantity());
        stock.setBarcode(stockDto.getBarcode());
        stock.setDate(stockDto.getDate());

        Stock updatedStock = stockRepository.save(stock);
        return stockMapper.toDto(updatedStock);
    }
}
