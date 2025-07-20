package com.ahbap.android.app.productapp.retrofit

import com.ahbap.android.app.productapp.retrofit.dto.TotalPriceDto
import com.ahbap.android.app.productapp.retrofit.dto.TotalProfitDto
import com.ahbap.android.app.toptanproductapp.view.dto.UpdatePriceDto
import com.ahbap.android.app.toptanproductapp.view.dto.UpdateSellPriceAndByPriceDto
import com.ahbap.android.app.toptanproductapp.view.dto.UpdateSellPriceDto
import com.ahbap.android.app.toptanproductapp.view.dto.UpdateStockDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Query
import java.math.BigDecimal

interface IProduct {
    @POST("product/save")
    fun save(@Body product: Product): Call<Boolean>

    @GET("product/findAll")
    fun findAll(): Call<List<Product>>

    @GET("product/stock")
    fun getProductsWithStockLessThan(@Query("stock") stock : Int): Call<List<Product>>

    @GET("product/findByName")
    fun findByName(@Query("name") name: String = ""): Call<List<Product>>

    @GET("product/findByByPrice")
    fun findByByPrice(@Query("byPrice") byPrice: BigDecimal): Call<List<Product>>

    @GET("product/findBySellPrice")
    fun findBySellPrice(@Query("sellPrice") sellPrice: BigDecimal): Call<List<Product>>

    @DELETE("product/delete-all")
    fun deleteAll(): Call<Boolean>
    @DELETE("product/delete-by-name")
    fun deleteByName(@Query("name") name: String = ""): Call<Boolean>

    @PATCH("product/update-by-price")
    fun updateByPrice(@Body updatePriceDto: UpdatePriceDto): Call<Boolean>

    @PATCH("product/update-sell-price")
    fun updateSellPrice(@Body sellPriceUpdate: UpdateSellPriceDto): Call<Boolean>

    @PATCH("product/update-sell-price-and-by-price")
    fun updateSellPriceAndByPrice(@Body price: UpdateSellPriceAndByPriceDto): Call<Boolean>

    @PATCH("product/update-stock-minus")
    fun updateStockMinus(@Body stockUpdate: UpdateStockDto): Call<Boolean>

    @PATCH("product/update-stock-plus")
    fun updateStockPlus(@Body stockUpdate: UpdateStockDto): Call<Boolean>

    @GET("product/total_stock_quantity")
    fun totalStock() : Call<Int>
    @GET("product/max_sell_price")
    fun max_sel_price() : Call<Product>
    @GET("product/min_sell_price")
    fun min_sell_price() : Call<Product>

    @GET("product/max_by_price")
    fun max_byPrice(): Call<Product>
    @GET("product/min_by_price")
    fun min_byPrice(): Call<Product>

    @GET("product/total_selling_price")
    fun total_by_sell(): Call<List<TotalPriceDto>>
    @GET("product/total_by_price")
    fun total_by_price(): Call<List<TotalPriceDto>>
    @GET("product/total_profit")
    fun total_profit(): Call<List<TotalProfitDto>>


}