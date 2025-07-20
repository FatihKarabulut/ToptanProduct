package com.ahbap.android.app.toptanproductapp.view.dto

import java.math.BigDecimal

data class UpdateSellPriceAndByPriceDto(var sellPrice: BigDecimal = BigDecimal.ZERO,
                                        var byPrice: BigDecimal = BigDecimal.ZERO,
                                        var name : String = "")