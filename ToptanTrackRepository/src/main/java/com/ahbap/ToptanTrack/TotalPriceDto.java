package com.ahbap.ToptanTrack;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class TotalPriceDto {
    public BigDecimal totalPrice;
    public String name;
    public int stock;
}
