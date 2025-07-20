package com.ahbap.ToptanTrackDataService;

import com.ahbap.DataServiceException;
import com.ahbap.IProduct;
import com.ahbap.RepositoryException;
import com.ahbap.ToptanTrack.DataHalper;
import com.ahbap.ToptanTrack.ProductEntity;
import com.ahbap.ToptanTrackDataService.mappers.IMaperDataService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@ComponentScan("com.ahbap")
public class DataService implements IProduct<ProductEntityDataService> {
    public DataHalper repositories;
    public IMaperDataService mappers;

    public DataService(DataHalper repositories, IMaperDataService mapers) {
        this.repositories = repositories;
        this.mappers = mapers;
    }


    @Override
    public List<ProductEntityDataService> findByName(String  name)
    {
        try {

            return repositories.findByName(name).stream().map(a -> mappers.toProductEntityDataService(a)).toList();

        }
        catch (RepositoryException e)
        {
            throw new DataServiceException("DataServiceException Error in findByName %s".formatted(e.getMessage()));
        }


    }

    @Override
    public List<ProductEntityDataService> findAll() {

        try {

            return repositories.findAll().stream().map(a -> mappers.toProductEntityDataService(a)).toList();

        }
        catch (RepositoryException e)
        {
            throw new DataServiceException("DataServiceException Error in findByName %s".formatted(e.getMessage()));
        }

    }

    @Override
    public boolean deleteByName(String name)  {

        try {
            return repositories.deleteByName(name);
        }
        catch (RepositoryException e)
        {
            throw new DataServiceException("DataServiceException Error in deleteByName %s".formatted(e.getMessage()));
        }
    }

    @Override
    public boolean deleteAll()   {

        try {

            return repositories.deleteAll();
        }
        catch (RepositoryException e)
        {
            throw new DataServiceException("DataServiceException Error in deleteAllBy %s".formatted(e.getMessage()));
        }


    }

    @Override
    public boolean updateADDStock(int stock, String name) {

        try {

            return repositories.updateADDStock(stock,name);

        }
        catch (RepositoryException e)
        {
            throw new DataServiceException("DataServiceException Error in updateStock %s".formatted(e.getMessage()));
        }
    }
    @Override
    public boolean updateToReduceStock(int stock, String name) {

        try {

            return repositories.updateToReduceStock(stock,name);

        }
        catch (RepositoryException e)
        {
            throw new DataServiceException("DataServiceException Error in updateStock %s".formatted(e.getMessage()));
        }
    }

    @Override
    public boolean updateStock(int stock, String name) {
        try {
            return repositories.updateStock(stock,name);
        }
        catch (RepositoryException e)
        {
            throw new DataServiceException("DataServiceException Error in updateStock %s".formatted(e.getMessage()));
        }

    }

    @Override
    public boolean updateSellPriceAndByPrice(BigDecimal sellPrice, BigDecimal byPrice, String name) {

        try {
            return repositories.updateSellPriceAndByPrice(sellPrice,byPrice,name);
        }
        catch (RepositoryException e)
        {
            throw new DataServiceException("DataServiceException Error in updateSellPriceAndByPrice %s".formatted(e.getMessage()));
        }
    }

    @Override
    public boolean updateSellPrice(BigDecimal sellPrice, String name) {

        try {
            return repositories.updateSellPrice(sellPrice,name);
        }
        catch (RepositoryException e)
        {
            throw new DataServiceException("DataServiceException Error in updateSellPrice %s".formatted(e.getMessage()));
        }
    }

    @Override
    public boolean updateByPrice(BigDecimal byPrice, String name) {
        try {
            return repositories.updateByPrice(byPrice,name);
        }
        catch (RepositoryException e)
        {
            throw new DataServiceException("DataServiceException Error in updateByPrice %s".formatted(e.getMessage()));
        }
    }

    @Override
    public List<ProductEntityDataService> findByByPrice(BigDecimal byPrice) {

        try {
            return repositories.findByByPrice(byPrice).stream()
                    .map(a -> mappers.toProductEntityDataService(a)).toList();
        }
        catch (RepositoryException e)
        {
            throw new DataServiceException("DataServiceException Error in findByByPrice %s".formatted(e.getMessage()));
        }
    }

    @Override
    public List<ProductEntityDataService> findBySellPrice(BigDecimal sellPrice) {

        try{
            return repositories.findBySellPrice(sellPrice).stream()
                    .map(a -> mappers.toProductEntityDataService(a)).toList();
        }
        catch (RepositoryException e)
        {
            throw new DataServiceException("DataServiceException Error in findBySellPrice %s".formatted(e.getMessage()));
        }
    }


    public List<ProductEntityDataService> getProductsWithStockLessThan(int stock) {

        try {

            return repositories.getProductsWithStockLessThan(stock).stream().map(a -> mappers.toProductEntityDataService(a)).toList();
        }
        catch (RepositoryException e)
        {
            throw new DataServiceException("DataServiceException Error in findWhereStockLessThan %s".formatted(e.getMessage()));
        }

    }


    public boolean save(ProductEntityDataService product){

        try {
            return repositories.save(mappers.toProductEntityRepo(product));
        }
        catch (RepositoryException e)
        {
            throw new DataServiceException("DataServiceException Error in save %s".formatted(e.getMessage()));
        }
    }

    public int totalStockQuantity() {
        try {

            return repositories.totalStockQuantity();

        } catch (Throwable e) {
            throw new RepositoryException("RepositoryException Error in totalStockQuantity %s".formatted(e.getMessage()));

        }

    }

    public ProductEntityDataService MaxSellPrice() {

        try {
            return mappers.toProductEntityDataService(repositories.MaxSellPrice());
        }
        catch (Throwable e) {
            throw new RepositoryException("MaxSellPrice Error in totalStockQuantity %s".formatted(e.getMessage()));

        }

    }
    public ProductEntityDataService MinSellPrice(){

        try {
            return mappers.toProductEntityDataService(repositories.MinSellPrice());
        }
        catch (Throwable e) {
            throw new RepositoryException("MaxSellPrice Error in MinSellPrice %s".formatted(e.getMessage()));

        }
    }
    /// /////////

    public ProductEntityDataService MaxByPrice(){

        try {
            return mappers.toProductEntityDataService(repositories.MaxByPrice());
        }
        catch (Throwable e) {
            throw new RepositoryException("MaxSellPrice Error in MaxByPrice %s".formatted(e.getMessage()));

        }
    }
    public ProductEntityDataService MinByPrice(){

        try {
            return mappers.toProductEntityDataService(repositories.MinByPrice());
        }
        catch (Throwable e) {
            throw new RepositoryException("MaxSellPrice Error in MinByPrice %s".formatted(e.getMessage()));

        }
    }
    public List<TotalPriceDataServiceDto> totalSellingPrice(){

        try {
            return repositories.totalSellingPrice().stream().map(a -> mappers.toTotalPriceDataServiceDto(a)).toList();
        }
        catch (Throwable e) {
            throw new RepositoryException("MaxSellPrice Error in totalSellingPrice %s".formatted(e.getMessage()));

        }
    }
    public List<TotalPriceDataServiceDto>  totalByPrice(){

        try {
            return repositories.totalByPrice().stream().map(a -> mappers.toTotalPriceDataServiceDto(a)).toList();
        }
        catch (Throwable e) {
            throw new RepositoryException("MaxSellPrice Error in totalSellingPrice %s".formatted(e.getMessage()));

        }
    }
    public List<TotalProfitDataServiceDto>  totalProfit(){

        try {
            return repositories.totalProfit().stream().map(a -> mappers.toTotalProfitDataServiceDto(a)).toList();
        }
        catch (Throwable e) {
            throw new RepositoryException("MaxSellPrice Error in totalProfit %s".formatted(e.getMessage()));

        }
    }

}
