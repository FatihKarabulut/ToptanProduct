package com.ahbap.android.app.productapp.retrofit

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class Product(var name: String? = null,
                   @SerializedName("addedBy")var personName: String? = null,
                   var stock: Int = 0,
                   var byPrice: BigDecimal? = null,
                   var sellPrice: BigDecimal? = null
                   )