package com.ahbap.ToptanTrackControler;

import com.ahbap.ToptanTrackControler.body.ByPriceUpdateDto;
import com.ahbap.ToptanTrackControler.body.SellPriceAndByPriceDto;
import com.ahbap.ToptanTrackControler.body.SellPriceUpdateDto;
import com.ahbap.ToptanTrackControler.body.StockUpdate;
import com.ahbap.ToptanTrackDataService.ProductEntityDataService;
import com.ahbap.ToptanTrackDataService.TotalPriceDataServiceDto;
import com.ahbap.ToptanTrackDataService.TotalProfitDataServiceDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product")
@Slf4j
@CrossOrigin(origins = "*")
public class ProductControler {

    public ProductServices productServices;

    public ProductControler(ProductServices productServices) {
        this.productServices = productServices;
    }



    @GetMapping("/findByName")
    public ResponseEntity<List<ProductEntityDataService>> findByName(@RequestParam String  name) {


        var product = productServices.findByName(name).get();
        log.info("findByName {}",product);
       return product.equals(Optional.empty()) ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(product);

    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ProductEntityDataService>> findAll() {

        log.info("findAll");
        var product = productServices.findAll();
        return product.equals(Optional.empty()) ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(product.get());
    }

    @GetMapping("/findByByPrice")
    public ResponseEntity<List<ProductEntityDataService>> findByByPrice(@RequestParam BigDecimal byPrice) {
        log.info("findByByPrice");
        var product = productServices.findByByPrice(byPrice);
        return product.equals(Optional.empty()) ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(product.get());
    }
    @GetMapping("/findBySellPrice")
    public ResponseEntity<List<ProductEntityDataService>> findBySellPrice(@RequestParam BigDecimal sellPrice) {
        log.info("findBySellPrice");
        var product = productServices.findBySellPrice(sellPrice);
        return product.equals(Optional.empty()) ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(product.get());
    }

    @DeleteMapping("/delete-by-name")
    public boolean deleteByName(@RequestParam String name)  {

        log.info("deleteByName");
        return productServices.deleteByName(name);

    }


    @DeleteMapping("/delete-all")
    public boolean deleteByAll()   {
    log.info("deleteByAll");
        return productServices.deleteAll();

    }

    @PatchMapping("/update-stock-plus")
    public  boolean updateToAddStock(@RequestBody StockUpdate stockUpdate) {
        log.info("updateToAddStock {}",stockUpdate.stock);
        return productServices.updateADDStock(stockUpdate.stock,stockUpdate.name);
    }

    @PatchMapping("/update-stock-minus")
    public boolean updateToReduceStockDt(@RequestBody StockUpdate stockUpdate) {
        log.info("update-stock-minus");
        return productServices.updateToReduceStock(stockUpdate.stock,stockUpdate.name);
    }
    @PatchMapping("/update-sell-price")
    public boolean updateSellPrice(@RequestBody SellPriceUpdateDto sellPriceUpdate) {
    log.info("updateSellPrice");
        return productServices.updateSellPrice(sellPriceUpdate.sellPrice,sellPriceUpdate.name);

    }

    @PatchMapping("/update-by-price")
    public boolean updateByPrice(@RequestBody ByPriceUpdateDto ByPriceUpdate){
        log.info("updateByPrice");
        return productServices.updateByPrice(ByPriceUpdate.byPrice,ByPriceUpdate.name);
    }

    @PatchMapping("/update-sell-price-and-by-price")
    public boolean updateSellPriceAndByPrice(@RequestBody SellPriceAndByPriceDto sellPriceAndByPriceDto) {
        log.info("updateSellPriceAndByPrice");
        return productServices.updateSellPriceAndByPrice(sellPriceAndByPriceDto.sellPrice,sellPriceAndByPriceDto.byPrice,
                sellPriceAndByPriceDto.name);
    }
    @GetMapping("/stock")
    public ResponseEntity<List<ProductEntityDataService>> getProductsWithStockLessThan(@RequestParam int stock) {
        log.info("getProductsWithStockLessThan");
        return productServices.getProductsWithStockLessThan(stock).equals(Optional.empty()) ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(productServices.getProductsWithStockLessThan(stock).get());
    }


    @PostMapping("/save")
    public boolean save(@RequestBody ProductEntityDataService product){
        log.info("save");
        return productServices.save(product);
    }


    @GetMapping("/total_stock_quantity")
    public int totalStockQuantity() {
        log.info("totalStockQuantity");
        return productServices.totalStockQuantity();
    }
    @GetMapping("/max_sell_price")
    public ProductEntityDataService MaxSellPrice() {
        log.info("MaxSellPrice");
        return productServices.MaxSellPrice();
    }
    @GetMapping("/min_sell_price")
    public ProductEntityDataService MinSellPrice() {
        log.info("MinSellPrice");
        return productServices.MinSellPrice();
    }
    @GetMapping("/max_by_price")
    public ProductEntityDataService MaxByPrice(){
        log.info("max_by_price");
        return productServices.MaxByPrice();
    }
    @GetMapping("/min_by_price")
    public ProductEntityDataService MinByPrice(){
        log.info("MinByPrice");
        return productServices.MinByPrice();
    }
    @GetMapping("/total_selling_price")
    public List<TotalPriceDataServiceDto> totalSellingPrice(){
        log.info("totalSellingPrice");
        return productServices.totalSellingPrice();
    }
    @GetMapping("/total_by_price")
    public List<TotalPriceDataServiceDto> totalByPrice(){
        log.info("totalByPrice");
        return productServices.totalByPrice();
    }
    @GetMapping("/total_profit")
    public List<TotalProfitDataServiceDto> totalProfit(){
        log.info("totalProfit");
        return productServices.totalProfit();
    }


}
