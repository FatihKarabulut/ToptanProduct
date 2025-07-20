package com.ahbap.android.app.toptanproductapp.view.dto

import java.math.BigDecimal

data class UpdatePriceDto(var byPrice: BigDecimal = BigDecimal.ZERO, var name : String = "")

data class UpdateSellPriceDto(var sellPrice: BigDecimal = BigDecimal.ZERO, var name : String = "")