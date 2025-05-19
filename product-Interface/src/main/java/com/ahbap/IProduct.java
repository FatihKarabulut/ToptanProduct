package com.ahbap;

import java.math.BigDecimal;
import java.util.List;

public interface IProduct<T> {
    List<T> findByName(String name);

    List<T> findAll();


    boolean deleteByName(String name);


    boolean deleteAll();


    boolean updateStock(int stock, String name);

    boolean updateADDStock(int stock, String name);

    boolean updateToReduceStock(int stock, String name);


    boolean updateSellPriceAndByPrice(BigDecimal sellPrice, BigDecimal byPrice, String name);


    boolean updateSellPrice(BigDecimal sellPrice, String name);


    boolean updateByPrice(BigDecimal byPrice, String name);

    List<T> findByByPrice(BigDecimal byPrice);

    List<T> findBySellPrice(BigDecimal sellPrice);

    List<T> getProductsWithStockLessThan(int stock);


     boolean save(T product);


}
