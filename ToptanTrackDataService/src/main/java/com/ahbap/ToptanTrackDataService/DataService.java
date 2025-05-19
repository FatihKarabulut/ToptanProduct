package com.ahbap.ToptanTrackDataService;

import com.ahbap.DataServiceException;
import com.ahbap.RepositoryException;
import com.ahbap.ToptanTrack.DataHalper;
import com.ahbap.IProduct;
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

}
