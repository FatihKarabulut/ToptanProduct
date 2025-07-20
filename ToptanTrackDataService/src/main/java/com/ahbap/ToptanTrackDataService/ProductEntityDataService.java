package com.ahbap.ToptanTrackDataService;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@EqualsAndHashCode
@ToString
public class ProductEntityDataService {

    public String name;
    public String addedBy;
    public int stock;
    public BigDecimal byPrice;
    public BigDecimal sellPrice;
    public LocalDateTime datetime = LocalDateTime.now();

}