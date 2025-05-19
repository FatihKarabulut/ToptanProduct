package com.ahbap.ToptanTrackControler.body;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
public class ByPriceUpdateDto {
    public BigDecimal byPrice;
    public String name;
}
