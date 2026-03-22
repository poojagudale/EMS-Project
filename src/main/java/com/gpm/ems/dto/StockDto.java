package com.gpm.ems.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class StockDto {
    private Long id;
    private String itemName;
    private int quantity;
    private String barcode;
    private LocalDate date;
}
