package com.ahbap.ToptanTrackDataService;

import com.ahbap.ToptanTrack.ProductEntity;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;


/*
    ihtiyaç halinde kullanılabilir

 */
@Component
@EntityScan("com.ahbap")
public class MapperTest implements DataServiceTestMapper {
    @Override
    public ProductEntity toProductEntityRepo(ProductEntityDataService product) {
            var pe = new ProductEntity();
            pe.name = product.name;
            pe.addedBy = product.addedBy;
            pe.byPrice = product.byPrice;
            pe.sellPrice = product.sellPrice;
            pe.stock = product.stock;
            pe.datetime = product.datetime;

        return pe;
    }

    @Override
    public ProductEntityDataService toProductEntityData(ProductEntity product) {
        var pdt = new ProductEntityDataService();
        pdt.name = product.name;
        pdt.addedBy = product.addedBy;
        pdt.byPrice = product.byPrice;
        pdt.sellPrice = product.sellPrice;
        pdt.stock = product.stock;
        pdt.datetime = product.datetime;
        return pdt;
    }
}
