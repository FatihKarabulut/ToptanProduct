package com.ahbap.ToptanTrack;

import com.ahbap.IProduct;
import com.ahbap.RepositoryException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class DataHalper implements IProduct<ProductEntity> {

    public IDao dao;

    public DataHalper(IDao dao) {
        this.dao = dao;

    }



    public List<ProductEntity> findByName(String  name)
    {
        try {
            return dao.findByName(name.toUpperCase());

        }
        catch (Throwable e)
        {
             throw new RepositoryException("RepositoryException Error in findByName %s".formatted(e.getMessage()));
        }


    }

    public List<ProductEntity> findAll()  {

        try {

            return dao.findAll();
        }
        catch (Throwable e)
        {
            throw new RepositoryException("RepositoryException Error in findByName %s".formatted(e.getMessage()));
        }

    }
    @Transactional
    public boolean deleteByName(String name)  {

        try {

           dao.deleteByName(name.toUpperCase());
           return true;
        }
        catch (Throwable e)
        {
            throw new RepositoryException("RepositoryException Error in deleteByName %s".formatted(e.getMessage()));
        }
    }
    @Transactional
    public boolean deleteAll() {

        try {

            dao.deleteAllBy();
            return true;
        }
        catch (Throwable e)
        {
            throw new RepositoryException("RepositoryException Error in deleteAllBy %s".formatted(e.getMessage()));

        }


    }


    public boolean updateStock(int stock, String name) {

        try {

            if (stock < 0)
                return false;

            dao.updateADDStock(stock,name.toUpperCase());
            return true;
        }
        catch (Throwable e)
        {
            throw new RepositoryException("RepositoryException Error in updateStock %s".formatted(e.getMessage()));
        }
    }
    public boolean updateADDStock(int stock, String name) {

        try {

            if (stock < 0)
                return false;

            var digit = dao.findByName(name.toUpperCase()).get(0).stock;

            return updateStock(digit + stock,name);

        }
        catch (Throwable e)
        {
            throw new RepositoryException("RepositoryException Error in updateStock %s".formatted(e.getMessage()));
        }
    }
    public boolean updateToReduceStock(int stock, String name) {

        try {

            if (stock < 0)
                return false;

            var digit = dao.findByName(name.toUpperCase()).get(0).stock;
           return updateStock(Math.max(digit - stock, 0),name);

        }
        catch (Throwable e)
        {
            throw new RepositoryException("RepositoryException Error in updateStock %s".formatted(e.getMessage()));
        }
    }
    @Transactional
    public boolean updateSellPriceAndByPrice(BigDecimal sellPrice, BigDecimal byPrice,String name)
    {

        try {

            if (sellPrice.compareTo(BigDecimal.ZERO) <= 0 || byPrice.compareTo(BigDecimal.ZERO) <= 0)
                return false;
             if (byPrice.compareTo(sellPrice) < 0)
                 return false;
            return dao.updateSellPriceAndByPrice(sellPrice,
                    byPrice,name.toUpperCase()) > 0 ;
        }
        catch (Throwable e)
        {
            throw new RepositoryException("RepositoryException Error in updateSellPriceAndByPrice %s".formatted(e.getMessage()));

        }

    }

    @Transactional
    public boolean updateSellPrice( BigDecimal sellPrice, String name){


        try {
            var list  = this.findByName(name).stream().filter(a -> a.byPrice.compareTo(sellPrice) <= 0).toList();
            if (sellPrice.compareTo(BigDecimal.ZERO) < 0)
                return false;
            if (!list.isEmpty())
                return false;
            return dao.updateSellPrice(sellPrice,
                   name.toUpperCase()) > 0 ;
        }
        catch (Throwable e)
        {
            throw new RepositoryException("RepositoryException Error in updateSellPrice %s".formatted(e.getMessage()));

        }
    }
    @Transactional
    public boolean updateByPrice(BigDecimal byPrice, String name){


        try {
            var list = this.findByName(name).stream().filter(a -> a.sellPrice.compareTo(byPrice) >= 0).toList();
            if (byPrice.compareTo(BigDecimal.ZERO) < 0)
                return false;
            if (!list.isEmpty())
                return false;
            return dao.updateByPrice(byPrice,
                    name.toUpperCase()) > 0 ;
        }
        catch (Throwable e)
        {
            throw new RepositoryException("RepositoryException Error in updateByPrice %s".formatted(e.getMessage()));

        }
    }

    public List<ProductEntity>findByByPrice(BigDecimal byPrice) {

        try {

            return dao.findByByPrice(byPrice);
        }
        catch (Throwable e)
        {
            throw new RepositoryException("RepositoryException Error in findByByPrice %s".formatted(e.getMessage()));
        }

    }
   public List<ProductEntity>findBySellPrice(BigDecimal sellPrice){
        try {

            return dao.findBySellPrice(sellPrice);
        }
        catch (Throwable e)
        {
            throw new RepositoryException("RepositoryException Error in findBySellPrice %s".formatted(e.getMessage()));
        }
    }
    public List<ProductEntity> getProductsWithStockLessThan(int stock) {

        try {

            return dao.findWhereStockLessThan(stock);
        }
        catch (Throwable e)
        {
            throw new RepositoryException("RepositoryException Error in findWhereStockLessThan %s".formatted(e.getMessage()));
        }

    }

    @Transactional
    public boolean save(ProductEntity product) {

        product.name = product.name.toUpperCase();
        try {
            var pr = this.findByName(product.name).stream()
                            .filter(a -> a.name.equalsIgnoreCase(product.name))
                                    .findFirst();

            if (pr.isPresent())
            {
                dao.deleteByName(product.name);

                dao.save(product);

            }
            else {
                dao.save(product);

            }
            return true;
        }
        catch (Throwable e)
        {
            throw new RepositoryException("RepositoryException Error in findWhereStockLessThan %s".formatted(e.getMessage()));

        }
    }
}
