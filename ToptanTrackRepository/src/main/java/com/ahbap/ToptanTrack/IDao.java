package com.ahbap.ToptanTrack;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IDao extends CrudRepository<ProductEntity,Long> {


     List<ProductEntity> findAll();

     List<ProductEntity> findByName(String name);

     void deleteByName(String name);

     @Modifying
     @Transactional
     @Query(nativeQuery = true,value = "UPDATE product SET stock = :stocks WHERE name = :names")
     int updateADDStock(@Param("stocks") int stocks, @Param("names") String names);


     @Modifying
     @Transactional
     @Query(nativeQuery = true,value = "UPDATE product SET sell_price = :sellPrice, by_price = :byPrice WHERE name = :name")
     int updateSellPriceAndByPrice(@Param("sellPrice") BigDecimal sellPrice,
                                   @Param("byPrice") BigDecimal byPrice, @Param("name") String name);
     @Modifying
     @Transactional
     @Query(nativeQuery = true,value = "UPDATE product SET sell_price = :sellPrice WHERE name = :name")
     int updateSellPrice(@Param("sellPrice") BigDecimal sellPrice,
                                    @Param("name") String name);

     @Modifying
     @Transactional
     @Query(nativeQuery = true,value = "UPDATE product SET by_price = :byPrice WHERE name = :name and stock > 0" )
    int updateByPrice(@Param("byPrice") BigDecimal byPrice, @Param("name") String name);

    @Query(nativeQuery = true,value = "select * from product where by_price <= :byPrice and stock > 0 ")
     List<ProductEntity>findByByPrice(@Param("byPrice") BigDecimal byPrice);

     @Query(nativeQuery = true,value = "select * from product where sell_price <= :sellPrice and stock > 0")
     List<ProductEntity>findBySellPrice(@Param("sellPrice") BigDecimal sellPrice);

     @Query(nativeQuery = true,value = "SELECT * FROM product p WHERE p.stock < :stock")
     List<ProductEntity> findWhereStockLessThan(@Param("stock") int stock);

     void deleteAllBy();



}
