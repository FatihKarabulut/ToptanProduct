package com.ahbap.android.app.productapp.retrofit.dto

import kotlinx.serialization.Serializable
import java.math.BigDecimal


data class TotalPriceDto(var totalPrice : BigDecimal =  BigDecimal.ZERO,
                            var name : String = "",
                            var stock : Int = 0
    )
