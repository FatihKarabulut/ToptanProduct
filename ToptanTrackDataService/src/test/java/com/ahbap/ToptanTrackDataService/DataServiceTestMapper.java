package com.ahbap.ToptanTrackDataService;

import com.ahbap.ToptanTrack.ProductEntity;

public interface DataServiceTestMapper {

    ProductEntity toProductEntityRepo(ProductEntityDataService product);
    ProductEntityDataService toProductEntityData(ProductEntity product);
}
