package com.ahbap.ToptanTrackControler;

import com.ahbap.DataServiceException;
import com.ahbap.IProduct;
import com.ahbap.RepositoryException;
import com.ahbap.ToptanTrackDataService.DataService;
import com.ahbap.ToptanTrackDataService.ProductEntityDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductServices  {


    public DataService dataService;

    public ProductServices(DataService dataService) {
        this.dataService = dataService;
    }

    public Optional<List<ProductEntityDataService>> findByName(String  name) {
        try {

            return Optional.of(dataService.findByName(name));

        }
        catch (DataServiceException e)
        {
            log.error(e.getMessage());
            return Optional.empty();
        }


    }

    public Optional<List<ProductEntityDataService>> findAll() {


        try {

            return Optional.of(dataService.findAll());

        }
        catch (DataServiceException e)
        {
            log.error(e.getMessage());
            return Optional.empty();
        }


    }
    public Optional<List<ProductEntityDataService>> findByByPrice(BigDecimal byPrice) {

        try {
            return Optional.of(dataService.findByByPrice(byPrice));
        }
        catch (Throwable e)
        {
            log.error(e.getMessage());
            return Optional.empty();
        }
    }
    public Optional<List<ProductEntityDataService>> findBySellPrice(BigDecimal sellPrice) {

        try {
            return Optional.of(dataService.findBySellPrice(sellPrice));
        }
        catch (Throwable e)
        {
            log.error(e.getMessage());
            return Optional.empty();
        }
    }

    public boolean deleteByName(String name)  {

        try {
            return dataService.deleteByName(name);
        }
        catch (RepositoryException e)
        {
            log.error(e.getMessage());
            return false;
        }

    }

    public boolean deleteAll()   {

        try {

            return dataService.deleteAll();
        }
        catch (DataServiceException e)
        {
         log.error(e.getMessage());
            return false;
        }



    }



    public  boolean updateADDStock(int stock, String name) {

        try {

            return dataService.updateADDStock(stock,name);

        }
        catch (RepositoryException e)
        {
           log.error(e.getMessage());
            return false;
        }


    }

    public boolean updateToReduceStock(int stock, String name) {

        try {

            return dataService.updateToReduceStock(stock,name);

        }
        catch (Throwable e)
        {
            log.error(e.getMessage());
            return false;
        }


    }
    public boolean updateSellPriceAndByPrice(BigDecimal sellPrice, BigDecimal byPrice, String name) {
        try {
            return dataService.updateSellPriceAndByPrice(sellPrice,byPrice,name);
        }
        catch (Throwable e)
        {
            log.error(e.getMessage());
            return false;
        }
    }
    public boolean updateSellPrice(BigDecimal sellPrice, String name) {
        try {
            return dataService.updateSellPrice(sellPrice,name);
        }
        catch (Throwable e)
        {
            log.error(e.getMessage());
            return false;
        }
    }
    public boolean updateByPrice(BigDecimal byPrice, String name) {
        try {
            return dataService.updateByPrice(byPrice,name);
        }
        catch (Throwable e)
        {
            log.error(e.getMessage());
            return false;
        }

    }

    public Optional<List<ProductEntityDataService>> getProductsWithStockLessThan(int stock) {

        try {

            return Optional.of(dataService.getProductsWithStockLessThan(stock));
        }
        catch (Throwable e)
        {
                log.error(e.getMessage());
            return Optional.empty();
        }


    }


    public boolean save(ProductEntityDataService product){

        try {
            return dataService.save(product);
        }
        catch (Throwable e)
        {
            log.error(e.getMessage());
            return false;
        }


    }

}
