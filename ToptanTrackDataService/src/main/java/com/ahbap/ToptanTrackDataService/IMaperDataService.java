package com.ahbap.ToptanTrackDataService;

import com.ahbap.ToptanTrack.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(implementationName = "MapersDataServiceImpl",componentModel = "spring")
public interface IMaperDataService {

    ProductEntity toProductEntityRepo(ProductEntityDataService product);
    ProductEntityDataService toProductEntityDataService(ProductEntity productEntity);
}
