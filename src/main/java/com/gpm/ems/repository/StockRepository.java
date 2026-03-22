package com.gpm.ems.repository;

import com.gpm.ems.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByBarcode(String barcode);
    Optional<Stock> findByItemName(String itemName);
    Optional<Stock> findByItemNameAndDate(String itemName, LocalDate date);
    Optional<Stock> findByBarcodeAndDate(String barcode, LocalDate date);
}
