package com.ahbap.ToptanTrackControler;

import com.ahbap.ToptanTrackControler.body.ByPriceUpdateDto;
import com.ahbap.ToptanTrackControler.body.SellPriceAndByPriceDto;
import com.ahbap.ToptanTrackControler.body.SellPriceUpdateDto;
import com.ahbap.ToptanTrackControler.body.StockUpdate;
import com.ahbap.ToptanTrackDataService.ProductEntityDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductControler {

    public ProductServices productServices;

    public ProductControler(ProductServices productServices) {
        this.productServices = productServices;
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<ProductEntityDataService>> findByName(@RequestParam String  name) {

        var product = productServices.findByName(name);
        return product.equals(Optional.empty()) ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(product.get());
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ProductEntityDataService>> findAll() {

        var product = productServices.findAll();
        return product.equals(Optional.empty()) ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(product.get());
    }

    @GetMapping("/findByByPrice")
    public ResponseEntity<List<ProductEntityDataService>> findByByPrice(@RequestParam BigDecimal byPrice) {
        var product = productServices.findByByPrice(byPrice);
        return product.equals(Optional.empty()) ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(product.get());
    }
    @GetMapping("/findBySellPrice")
    public ResponseEntity<List<ProductEntityDataService>> findBySellPrice(@RequestParam BigDecimal sellPrice) {

        var product = productServices.findBySellPrice(sellPrice);
        return product.equals(Optional.empty()) ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(product.get());
    }
    @DeleteMapping("/delete-by-name")
    public boolean deleteByName(@RequestParam String name)  {

        return productServices.deleteByName(name);

    }

    @DeleteMapping("/delete-all")
    public boolean deleteByAll()   {

        return productServices.deleteAll();

    }

    @PatchMapping("/update-stock-plus")
    public  boolean updateToAddStock(@RequestBody StockUpdate stockUpdate) {

        return productServices.updateADDStock(stockUpdate.stock,stockUpdate.name);
    }

    @PatchMapping("/update-stock-minus")
    public boolean updateToReduceStockDt(@RequestBody StockUpdate stockUpdate) {

        return productServices.updateToReduceStock(stockUpdate.stock,stockUpdate.name);
    }
    @PatchMapping("/update-sell-price")
    public boolean updateSellPrice(@RequestBody SellPriceUpdateDto sellPriceUpdate) {

        return productServices.updateSellPrice(sellPriceUpdate.sellPrice,sellPriceUpdate.name);

    }

    @PatchMapping("/update-by-price")
    public boolean updateByPrice(@RequestBody ByPriceUpdateDto ByPriceUpdate){

        return productServices.updateByPrice(ByPriceUpdate.byPrice,ByPriceUpdate.name);
    }

    @PatchMapping("/update-sell-price-and-by-price")
    public boolean updateSellPriceAndByPrice(@RequestBody SellPriceAndByPriceDto sellPriceAndByPriceDto) {

        return productServices.updateSellPriceAndByPrice(sellPriceAndByPriceDto.sellPrice,sellPriceAndByPriceDto.byPrice,sellPriceAndByPriceDto.name);
    }
    @GetMapping("/stock")
    public ResponseEntity<List<ProductEntityDataService>> getProductsWithStockLessThan(@RequestParam int stock) {

        return productServices.getProductsWithStockLessThan(stock).equals(Optional.empty()) ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(productServices.getProductsWithStockLessThan(stock).get());
    }


    @PostMapping("/save")
    public boolean save(@RequestBody ProductEntityDataService product){

        return productServices.save(product);
    }


}
