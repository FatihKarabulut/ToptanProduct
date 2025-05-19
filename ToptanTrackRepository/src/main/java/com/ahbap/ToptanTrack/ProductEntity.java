package com.ahbap.ToptanTrack;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id = -1;


    @Column(name = "name")
    public String name;
    @Column(name = "added_by_name")
    public String addedBy;
    @Column(name = "stock")
    public int stock;
    @Column(name = "by_price")
    public BigDecimal byPrice;
    @Column(name = "sell_price")
    public BigDecimal sellPrice;
    @Column(name = "date_time")
    public LocalDateTime datetime;

}
