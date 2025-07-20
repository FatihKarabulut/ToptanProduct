package com.ahbap.ToptanTrackDataService.mappers;

import com.ahbap.ToptanTrack.ProductEntity;
import com.ahbap.ToptanTrack.TotalPriceDto;
import com.ahbap.ToptanTrack.TotalProfitDto;
import com.ahbap.ToptanTrackDataService.ProductEntityDataService;
import com.ahbap.ToptanTrackDataService.TotalPriceDataServiceDto;
import com.ahbap.ToptanTrackDataService.TotalProfitDataServiceDto;
import org.mapstruct.Mapper;

@Mapper(implementationName = "MapersDataServiceImpl", componentModel = "spring")
public interface IMaperDataService {

    ProductEntity toProductEntityRepo(ProductEntityDataService product);

    ProductEntityDataService toProductEntityDataService(ProductEntity productEntity);


    TotalProfitDto totallProfitDto(TotalProfitDataServiceDto totalProfitDataServiceDto);

    TotalPriceDto totalPriceDto(TotalPriceDataServiceDto totalPriceDataServiceDto);

    TotalProfitDataServiceDto toTotalProfitDataServiceDto(TotalProfitDto totalProfitDto);

    TotalPriceDataServiceDto toTotalPriceDataServiceDto(TotalPriceDto totalPriceDto);


}
