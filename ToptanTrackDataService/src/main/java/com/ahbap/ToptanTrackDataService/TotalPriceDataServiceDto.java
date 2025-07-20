package com.ahbap.ToptanTrackDataService;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class TotalPriceDataServiceDto {
    public BigDecimal totalPrice;
    public String name;
    public int stock;
}
