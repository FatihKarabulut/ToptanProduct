package com.ahbap.ToptanTrackControler;

import com.ahbap.DataServiceException;
import com.ahbap.RepositoryException;
import com.ahbap.ToptanTrack.ProductEntity;
import com.ahbap.ToptanTrackDataService.DataService;
import com.ahbap.ToptanTrackDataService.ProductEntityDataService;
import com.ahbap.ToptanTrackDataService.TotalPriceDataServiceDto;
import com.ahbap.ToptanTrackDataService.TotalProfitDataServiceDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServices  {


    public DataService dataService;

    public ProductServices(DataService dataService) {
        this.dataService = dataService;
    }

    public Optional<List<ProductEntityDataService>> findByName(String  name) {
        try {

            var list = new ArrayList<>(dataService.findByName(name));
            Collections.reverse(list);

            return Optional.of(list);

        }
        catch (DataServiceException e)
        {
            log.error(e.getMessage());
            return Optional.empty();
        }


    }

    public Optional<List<ProductEntityDataService>> findAll() {


        try {

            var list = new ArrayList<>(dataService.findAll());
            Collections.reverse(list);
            return Optional.of(list);

        }
        catch (DataServiceException e)
        {
            log.error(e.getMessage());
            return Optional.empty();
        }


    }
    public Optional<List<ProductEntityDataService>> findByByPrice(BigDecimal byPrice) {

        try {
            var list = new ArrayList<>(dataService.findByByPrice(byPrice));
            Collections.reverse(list);
            return Optional.of(list);
        }
        catch (Throwable e)
        {
            log.error(e.getMessage());
            return Optional.empty();
        }
    }
    public Optional<List<ProductEntityDataService>> findBySellPrice(BigDecimal sellPrice) {

        try {
            var list = new ArrayList<>(dataService.findBySellPrice(sellPrice));
            Collections.reverse(list);
            return Optional.of(list);
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
            var list = new ArrayList<>(dataService.getProductsWithStockLessThan(stock));
            Collections.reverse(list);
            return Optional.of(list);
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

    //
    public int totalStockQuantity() {
        try {

            return dataService.totalStockQuantity();

        } catch (Throwable e) {
            throw new RepositoryException("RepositoryException Error in totalStockQuantity %s".formatted(e.getMessage()));

        }

    }

    public ProductEntityDataService MaxSellPrice() {

        try {
            return dataService.MaxSellPrice();
        }
        catch (Throwable e) {
            throw new RepositoryException("MaxSellPrice Error in totalStockQuantity %s".formatted(e.getMessage()));

        }

    }
    public ProductEntityDataService MinSellPrice(){

        try {
            return dataService.MinSellPrice();
        }
        catch (Throwable e) {
            throw new RepositoryException("MaxSellPrice Error in MinSellPrice %s".formatted(e.getMessage()));

        }
    }
    /// /////////

    public ProductEntityDataService MaxByPrice(){

        try {
            return dataService.MaxByPrice();
        }
        catch (Throwable e) {
            throw new RepositoryException("MaxSellPrice Error in MaxByPrice %s".formatted(e.getMessage()));

        }
    }
    public ProductEntityDataService MinByPrice(){

        try {
            return dataService.MinByPrice();
        }
        catch (Throwable e) {
            throw new RepositoryException("MaxSellPrice Error in MinByPrice %s".formatted(e.getMessage()));

        }
    }
    public List<TotalPriceDataServiceDto> totalSellingPrice(){

        try {
            return dataService.totalSellingPrice();
        }
        catch (Throwable e) {
            throw new RepositoryException("MaxSellPrice Error in totalSellingPrice %s".formatted(e.getMessage()));

        }
    }
    public List<TotalPriceDataServiceDto>  totalByPrice(){

        try {
            return dataService.totalByPrice();
        }
        catch (Throwable e) {
            throw new RepositoryException("MaxSellPrice Error in totalSellingPrice %s".formatted(e.getMessage()));

        }
    }
    public List<TotalProfitDataServiceDto>  totalProfit(){

        try {
            return dataService.totalProfit();
        }
        catch (Throwable e) {
            throw new RepositoryException("MaxSellPrice Error in totalProfit %s".formatted(e.getMessage()));

        }
    }
}
