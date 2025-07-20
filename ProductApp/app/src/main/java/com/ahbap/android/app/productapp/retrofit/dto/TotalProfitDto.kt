package com.ahbap.android.app.productapp.retrofit.dto

import java.math.BigDecimal

data class TotalProfitDto(
    var totalProfit: BigDecimal? = null,
    var byPrice: BigDecimal? = null,
    var sell_Price: BigDecimal? = null,
    var name: String? = null,
    var stock: String? = null)

