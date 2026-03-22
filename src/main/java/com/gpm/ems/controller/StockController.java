package com.gpm.ems.controller;

import com.gpm.ems.dto.StockDto;
import com.gpm.ems.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@CrossOrigin(origins = "http://localhost:3000")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public ResponseEntity<List<StockDto>> getAllStocks() {
        List<StockDto> stocks = stockService.getAllStocks();
        return stocks.isEmpty()
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @GetMapping("/{barcode}")
    public ResponseEntity<StockDto> getStockByBarcode(@PathVariable String barcode) {
        try {
            StockDto stock = stockService.getStockByBarcode(barcode);
            return new ResponseEntity<>(stock, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> addStock(@RequestBody StockDto stockDto) {
        try {
            if (stockDto.getItemName() == null || stockDto.getBarcode() == null || stockDto.getQuantity() <= 0) {
                return new ResponseEntity<>("Invalid request data", HttpStatus.BAD_REQUEST);
            }
            StockDto createdStock = stockService.addStock(stockDto);
            return new ResponseEntity<>(createdStock, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/decrease/{barcode}")
    public ResponseEntity<?> decreaseStock(@PathVariable String barcode, @RequestParam int amount) {
        if (amount <= 0) {
            return new ResponseEntity<>("Decrease amount must be greater than 0", HttpStatus.BAD_REQUEST);
        }
        try {
            StockDto updatedStock = stockService.decreaseStock(barcode, amount);
            return new ResponseEntity<>(updatedStock, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/increase/{barcode}")
    public ResponseEntity<?> increaseStock(@PathVariable String barcode, @RequestParam int amount) {
        if (amount <= 0) {
            return new ResponseEntity<>("Increase amount must be greater than 0", HttpStatus.BAD_REQUEST);
        }
        try {
            StockDto updatedStock = stockService.increaseStock(barcode, amount);
            return new ResponseEntity<>(updatedStock, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // ✅ Necessary addition - For frontend update stock by ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStockById(@PathVariable Long id, @RequestBody StockDto stockDto) {
        try {
            StockDto updatedStock = stockService.updateStockById(id, stockDto);
            return new ResponseEntity<>(updatedStock, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
