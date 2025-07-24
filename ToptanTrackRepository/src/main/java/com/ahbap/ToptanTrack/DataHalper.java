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


    @Override
    public List<ProductEntity> findByName(String name) {
        try {

            return dao.findByName(name.toUpperCase());

        } catch (Throwable e) {
            throw new RepositoryException("RepositoryException Error in findByName %s".formatted(e.getMessage()));
        }


    }
    @Override
    public List<ProductEntity> findAll() {

        try {

            return dao.findAll();
        } catch (Throwable e) {
            throw new RepositoryException("RepositoryException Error in findByName %s".formatted(e.getMessage()));
        }

    }
    @Override
    @Transactional
    public boolean deleteByName(String name) {

        try {

            if (name.isBlank())
                return false;
            dao.deleteByName(name.toUpperCase());
            return true;
        } catch (Throwable e) {
            throw new RepositoryException("RepositoryException Error in deleteByName %s".formatted(e.getMessage()));
        }
    }
    @Override
    @Transactional
    public boolean deleteAll() {

        try {

            dao.deleteAllBy();
            return true;
        } catch (Throwable e) {
            throw new RepositoryException("RepositoryException Error in deleteAllBy %s".formatted(e.getMessage()));

        }


    }

    @Override
    public boolean updateStock(int stock, String name) {

        try {


            if (stock < 0 || name.isBlank())
                return false;


            dao.updateADDStock(stock, name.toUpperCase());
            return true;
        } catch (Throwable e) {
            throw new RepositoryException("RepositoryException Error in updateStock %s".formatted(e.getMessage()));
        }
    }

    @Override
    public boolean updateADDStock(int stock, String name) {

        try {
            var list = dao.findByName(name.toUpperCase());

            if (stock < 0 || list.isEmpty())
                return false;

            var digit = list.get(0).stock;

            return updateStock(digit + stock, name);

        } catch (Throwable e) {
            throw new RepositoryException("RepositoryException Error in updateStock %s".formatted(e.getMessage()));
        }
    }

    @Override
    public boolean updateToReduceStock(int stock, String name) {

        try {

            var list = dao.findByName(name.toUpperCase());
            if (stock < 0 || list.isEmpty())
                return false;

            var digit = list.get(0).stock;

            return updateStock(digit - stock, name);

        } catch (Throwable e) {
            throw new RepositoryException("RepositoryException Error in updateStock %s".formatted(e.getMessage()));
        }
    }

    @Override
    @Transactional
    public boolean updateSellPriceAndByPrice(BigDecimal sellPrice, BigDecimal byPrice, String name) {

        try {

            if (sellPrice.compareTo(BigDecimal.ZERO) <= 0 || byPrice.compareTo(BigDecimal.ZERO) <= 0)
                return false;
            if (byPrice.compareTo(sellPrice) > 0)
                return false;
            if (name.isBlank())
                return false;

            return dao.updateSellPriceAndByPrice(sellPrice, byPrice, name.toUpperCase()) > 0;
        } catch (Throwable e) {
            throw new RepositoryException("RepositoryException Error in updateSellPriceAndByPrice %s".formatted(e.getMessage()));

        }

    }

    @Override
    @Transactional
    public boolean updateSellPrice(BigDecimal sellPrice, String name) {


        try {
            var list = this.findByName(name).stream().filter(a -> a.byPrice.compareTo(sellPrice) >= 0).toList();
            if (sellPrice.compareTo(BigDecimal.ZERO) < 0)
                return false;
            if (!list.isEmpty())
                return false;
            if (name.isBlank())
                return false;
            return dao.updateSellPrice(sellPrice,
                    name.toUpperCase()) > 0;
        } catch (Throwable e) {
            throw new RepositoryException("RepositoryException Error in updateSellPrice %s".formatted(e.getMessage()));

        }
    }

    @Override
    @Transactional
    public boolean updateByPrice(BigDecimal byPrice, String name) {


        try {
            var list = this.findByName(name).stream().filter(a -> a.sellPrice.compareTo(byPrice) <= 0).toList();
            if (byPrice.compareTo(BigDecimal.ZERO) < 0)
                return false;
            if (!list.isEmpty())
                return false;
            if (name.isBlank())
                return false;
            return dao.updateByPrice(byPrice,
                    name.toUpperCase()) > 0;
        } catch (Throwable e) {
            throw new RepositoryException("RepositoryException Error in updateByPrice %s".formatted(e.getMessage()));

        }
    }

    @Override
    public List<ProductEntity> findByByPrice(BigDecimal byPrice) {

        try {

            return dao.findByByPrice(byPrice);
        } catch (Throwable e) {
            throw new RepositoryException("RepositoryException Error in findByByPrice %s".formatted(e.getMessage()));
        }

    }

    @Override
    public List<ProductEntity> findBySellPrice(BigDecimal sellPrice) {
        try {

            return dao.findBySellPrice(sellPrice);
        } catch (Throwable e) {
            throw new RepositoryException("RepositoryException Error in findBySellPrice %s".formatted(e.getMessage()));
        }
    }

    @Override
    public List<ProductEntity> getProductsWithStockLessThan(int stock) {

        try {

            return dao.findWhereStockLessThan(stock);
        } catch (Throwable e) {
            throw new RepositoryException("RepositoryException Error in findWhereStockLessThan %s".formatted(e.getMessage()));
        }

    }

    @Override
    @Transactional
    public boolean save(ProductEntity product) {

        product.name = product.name.toUpperCase();
        try {
            var pr = this.findByName(product.name).stream()
                    .filter(a -> a.name.equalsIgnoreCase(product.name))
                    .findFirst();

            if (pr.isPresent()) {
                dao.deleteByName(product.name);

                dao.save(product);

            } else if (product.stock < 0 || product.sellPrice.compareTo(BigDecimal.ZERO) <= 0
                    || product.byPrice.compareTo(BigDecimal.ZERO) <= 0 ||
                    product.byPrice.compareTo(product.sellPrice) >= 0)
                return false;
            else if (product.name.isBlank() || product.addedBy.isBlank())
                return false;

            else {
                dao.save(product);

            }

            return true;
        } catch (Throwable e) {
            throw new RepositoryException("RepositoryException Error in findWhereStockLessThan %s".formatted(e.getMessage()));

        }

    }


    public int totalStockQuantity() {
        try {

            return dao.totalStockQuantity();

        } catch (Throwable e) {
            throw new RepositoryException("RepositoryException Error in totalStockQuantity %s".formatted(e.getMessage()));

        }

    }

    public ProductEntity MaxSellPrice() {

        try {
            return dao.getBySellPrice(dao.MaxSellPrice());
        }
        catch (Throwable e) {
            throw new RepositoryException("RepositoryException Error in MaxSellPrice %s".formatted(e.getMessage()));

        }

    }
    public ProductEntity MinSellPrice(){

        try {
            return dao.getBySellPrice(dao.MinSellPrice());
        }
        catch (Throwable e) {
            throw new RepositoryException("RepositoryException Error in MinSellPrice %s".formatted(e.getMessage()));

        }
    }
    public ProductEntity MaxByPrice(){

        try {
            return dao.getByPrice(dao.MaxByPrice());
        }
        catch (Throwable e) {
            throw new RepositoryException("RepositoryException Error in MaxByPrice %s".formatted(e.getMessage()));

        }
    }

    public ProductEntity MinByPrice(){

        try {
            return dao.getByPrice(dao.MinByPrice());
        }
        catch (Throwable e) {
            throw new RepositoryException("RepositoryException Error in MinByPrice %s".formatted(e.getMessage()));

        }
    }
    public List<TotalPriceDto> totalSellingPrice(){

        try {
            return dao.totalSellingPrice();
        }
        catch (Throwable e) {
            throw new RepositoryException("RepositoryException Error in totalSellingPrice %s".formatted(e.getMessage()));

        }
    }
    public List<TotalPriceDto>  totalByPrice(){

        try {
            return dao.totalByPrice();
        }
        catch (Throwable e) {
            throw new RepositoryException("RepositoryException Error in totalByPrice %s".formatted(e.getMessage()));

        }
    }
    public List<TotalProfitDto>  totalProfit(){

        try {
            return dao.totalProfit();
        }
        catch (Throwable e) {
            throw new RepositoryException("RepositoryException Error in totalProfit %s".formatted(e.getMessage()));

        }
    }

}
