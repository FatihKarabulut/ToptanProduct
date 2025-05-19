package com.ahbap.ToptanTrackControler.body;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
public class SellPriceAndByPriceDto {
    public BigDecimal sellPrice;
    public BigDecimal byPrice;
    public String name;
}
