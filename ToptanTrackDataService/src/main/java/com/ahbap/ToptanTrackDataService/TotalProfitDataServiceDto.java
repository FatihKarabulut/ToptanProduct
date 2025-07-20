package com.ahbap.ToptanTrackDataService;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class TotalProfitDataServiceDto {

    public BigDecimal totalProfit;
    public BigDecimal byPrice;
    public BigDecimal sell_Price;
    public String name;
    public String stock;
}
