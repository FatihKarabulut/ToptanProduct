package com.ahbap.ToptanTrack;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class TotalProfitDto {

    public BigDecimal totalProfit;
    public BigDecimal byPrice;
    public BigDecimal sell_Price;
    public String name;
}
