package com.ahbap.android.app.productapp.view

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahbap.android.app.productapp.retrofit.IProduct
import com.ahbap.android.app.productapp.retrofit.Product
import com.ahbap.android.app.productapp.retrofit.dto.TotalPriceDto
import com.ahbap.android.app.productapp.retrofit.dto.TotalProfitDto
import com.ahbap.android.app.toptanproductapp.view.dto.UpdateStockDto
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@HiltViewModel
class Views @Inject constructor( var productRepository : IProduct) : ViewModel() {

    var viewFindByList by mutableStateOf(emptyList<Product>())
    var viewFindByName by mutableStateOf(emptyList<Product>())
    var viewStockList by mutableStateOf(emptyList<Product>())
    var viewSaveBool by mutableStateOf(false)
    var viewTotalStock by mutableStateOf(0)
    var viewMaxSellPriceby by mutableStateOf(Product())
    var viewMinSellPriceby by mutableStateOf(Product())
    var viewMinByPriceby by mutableStateOf(Product())
    var viewMaxByPriceby by mutableStateOf(Product())
    var viewTotalSellPrice by mutableStateOf(emptyList<TotalPriceDto>())
    var viewTotalByPrice by mutableStateOf(emptyList<TotalPriceDto>())
    var viewTotalProfit by mutableStateOf(emptyList<TotalProfitDto>())

    fun FindByList() {

        viewModelScope.launch {


            val call = productRepository.findAll()

            call.enqueue(object : Callback<List<Product>> {

                override fun onResponse(
                    call: Call<List<Product>?>,
                    response: Response<List<Product>?>
                ) {
                    if (response.isSuccessful)
                        viewFindByList = response.body()!!
                    else
                        Log.d("onResponse ", "isNotSuccessFull ")
                }

                override fun onFailure(
                    call: Call<List<Product>?>,
                    t: Throwable
                ) {
                    viewFindByList = emptyList()
                    Log.d("onFailure", "onFailure ${t.message}")
                }
            })
        }

    }

    fun findByName(name: String) {
        val call = productRepository.findByName(name)
        call.enqueue(object : Callback<List<Product>> {
            override fun onResponse(
                call: Call<List<Product>?>,
                response: Response<List<Product>>
            ) {
                if (response.isSuccessful) {
                    viewFindByName = response.body()!!
                    Log.d("onResponse ", "isSuccesFull ")
                } else {
                    Log.d("onResponse ", "isNotSuccessFull ")
                }
            }

            override fun onFailure(
                call: Call<List<Product>?>,
                t: Throwable
            ) {

                Log.d("onFailure", "findByName onFailure ${t.message}")
            }
        })
    }

    fun ProductsWithStockLessThan(stock: Int = 6) {
        viewModelScope.launch {

            val call = productRepository.getProductsWithStockLessThan(stock)

            call.enqueue(object : Callback<List<Product>> {
                override fun onResponse(
                    call: Call<List<Product>?>,
                    response: Response<List<Product>?>
                ) {
                    if (response.isSuccessful)
                        viewStockList = response.body()!!
                    else
                        Log.d("onResponse ", "ProductsWithStockLessThan isNotSuccessFull ")
                }

                override fun onFailure(
                    call: Call<List<Product>?>,
                    t: Throwable
                ) {
                    viewStockList = emptyList()
                    Log.d("onFailure", "ProductsWithStockLessThan onFailure ${t.message}")
                }
            })

        }
    }

    fun DeleteByName(name: String = "") {
        viewModelScope.launch {
            val call = productRepository.deleteByName(name)

            call.enqueue(object : Callback<Boolean> {
                override fun onResponse(
                    call: Call<Boolean?>,
                    response: Response<Boolean?>
                ) {
                    if (response.isSuccessful) {
                        FindByList()
                        Log.d("onResponse ", "DeleteByName isSuccesFull ")
                    } else
                        Log.d("onResponse ", "DeleteByName isNotSuccessFull ")
                }

                override fun onFailure(call: Call<Boolean?>, t: Throwable) {
                    Log.d("onFailure", "DeleteByName onFailure ${t.message}")
                }
            })
        }
    }

    fun updatePlusStock(name: String) {

        viewModelScope.launch {
            val call = productRepository.updateStockPlus(
                UpdateStockDto(
                    stock = UPDATE_PLUS_STOCK,
                    name = name,
                )
            )

            call.enqueue(object : Callback<Boolean> {
                override fun onResponse(
                    call: Call<Boolean?>,
                    response: Response<Boolean?>
                ) {
                    if (response.isSuccessful) {
                        FindByList()
                        Log.d("onResponse ", "updatePlusStock isSuccesFull ")
                    } else
                        Log.d("onResponse ", "updatePlusStock isNotSuccessFull ")
                }

                override fun onFailure(call: Call<Boolean?>, t: Throwable) {
                    Log.d("onFailure", "updatePlusStock onFailure ${t.message}")
                }
            })
        }

    }

    fun updateMinusStock(name: String) {

        viewModelScope.launch {
            val call = productRepository.updateStockMinus(
                UpdateStockDto(
                    stock = UPDATE_MINUS_STOCK,
                    name = name,
                )
            )

            call.enqueue(object : Callback<Boolean> {
                override fun onResponse(
                    call: Call<Boolean?>,
                    response: Response<Boolean?>
                ) {
                    if (response.isSuccessful) {
                        FindByList()
                        Log.d("onResponse ", "updateMinusStock isSuccesFull ")
                    } else
                        Log.d("onResponse ", "updateMinusStock isNotSuccessFull ")
                }

                override fun onFailure(call: Call<Boolean?>, t: Throwable) {
                    Log.d("onFailure", "updateMinusStock onFailure ${t.message}")
                }
            })
        }
    }

    fun SaveProduct(product: Product) {

        viewModelScope.launch {
            val call = productRepository.save(product)

            call.enqueue(object : Callback<Boolean> {
                override fun onResponse(
                    call: Call<Boolean?>,
                    response: Response<Boolean?>
                ) {
                    if (response.isSuccessful) {
                        viewSaveBool = response.body()!!
                        Log.d("onResponse ", "SaveProduct isSuccesFull ")
                    } else {
                        Log.d("onResponse ", "SaveProduct isNotSuccessFull ")
                    }

                }

                override fun onFailure(call: Call<Boolean?>, t: Throwable) {
                    Log.d("onFailure", "Saveproduct onFailure ${t.message}")
                }
            })

        }
    }

    fun totalStock() {

        viewModelScope.launch {

            val call = productRepository.totalStock()
            call.enqueue(object : Callback<Int> {
                override fun onResponse(
                    call: Call<Int?>,
                    response: Response<Int?>
                ) {
                    if (response.isSuccessful) {
                        viewTotalStock = response.body()!!
                        Log.d("isSuccesFull", "totalStock issucces")
                    } else
                        Log.d("unSucces", "totalStock unSucces")
                }

                override fun onFailure(call: Call<Int?>, t: Throwable) {
                    Log.e("totalStock", "totalStock onFailure ${t.message}")
                }
            })
        }
    }

    fun maxSelPrice() {
        viewModelScope.launch {
            val call = productRepository.max_sel_price()

            call.enqueue(object : Callback<Product> {
                override fun onResponse(
                    call: Call<Product?>,
                    response: Response<Product?>
                ) {

                    if (response.isSuccessful) {
                        viewMaxSellPriceby = response.body()!!
                        Log.d("isSuccesFull", "maxSelPrice issucces")
                    } else
                        Log.d("unSucces", "maxSelPrice unSucces")
                }

                override fun onFailure(
                    call: Call<Product?>,
                    t: Throwable
                ) {
                    Log.e("maxSelPrice", "maxSelPrice onFailure ${t.message}")
                }
            })
        }
    }

    fun minSelPrice() {

        viewModelScope.launch {

            val call = productRepository.min_sell_price()

            call.enqueue(object : Callback<Product>{
                override fun onResponse(
                    call: Call<Product?>,
                    response: Response<Product?>
                ) {
                    if (response.isSuccessful){
                        viewMinSellPriceby = response.body()!!
                        Log.d("isSuccesFull", "minSelPrice issucces")
                    }
                    else
                        Log.d("unSucces", "minSelPrice unSucces")
                }

                override fun onFailure(
                    call: Call<Product?>,
                    t: Throwable
                ) {
                    Log.e("onFailure", "minSelPrice onFailure ${t.message}")
                }
            })
        }
    }

    fun maxByPrice() {
        viewModelScope.launch {
            val call = productRepository.max_byPrice()
            call.enqueue(object : Callback<Product> {
                override fun onResponse(
                    call: Call<Product?>,
                    response: Response<Product?>
                ) {
                    if (response.isSuccessful) {
                        viewMaxByPriceby = response.body()!!
                        Log.d("isSuccesFull", "maxByPrice issucces")
                    } else
                        Log.d("unSucces", "maxByPrice unSucces")
                }

                override fun onFailure(
                    call: Call<Product?>,
                    t: Throwable
                ) {
                    Log.e("onFailure", "maxByPrice onFailure ${t.message}")
                }
            })
        }

    }

    fun minByPrice() {

        val call = productRepository.min_byPrice()

        call.enqueue(object : Callback<Product> {
            override fun onResponse(
                call: Call<Product?>,
                response: Response<Product?>
            ) {

                if (response.isSuccessful){
                    viewMinByPriceby = response.body()!!
                    Log.d("isSuccesFull", "minByPrice issucces")

                }
                else
                    Log.d("unSucces", "minByPrice unSucces")
            }

            override fun onFailure(
                call: Call<Product?>,
                t: Throwable
            ) {
                Log.e("onFailure", "minByPrice onFailure ${t.message}")
            }
        })
    }

    fun totalSellPrice(){
        viewModelScope.launch {
            val call = productRepository.total_by_sell()
            call.enqueue(object : Callback<List<TotalPriceDto>> {
                override fun onResponse(
                    call: Call<List<TotalPriceDto>?>,
                    response: Response<List<TotalPriceDto>?>
                ) {
                    if (response.isSuccessful) {
                        viewTotalSellPrice = response.body()!!
                        Log.d("onResponse ", "totalSellprice isSuccesFull ")
                    } else
                        Log.d("onResponse ", "totalSellprice isNotSuccessFull ")
                }

                override fun onFailure(
                    call: Call<List<TotalPriceDto>?>,
                    t: Throwable
                ) {
                    TODO("Not yet implemented")
                }
            })
        }
    }

    fun totalByPrice(){
        viewModelScope.launch {

            val call = productRepository.total_by_price()

            call.enqueue(object : Callback<List<TotalPriceDto>> {

                override fun onResponse(
                    call: Call<List<TotalPriceDto>?>,
                    response: Response<List<TotalPriceDto>?>
                ) {
                    if (response.isSuccessful){
                        viewTotalByPrice = response.body()!!
                        Log.d("onResponse ", "totalByPrice isSuccesFull ")
                    }
                    else{
                        Log.d("onResponse ", "totalByPrice isNotSuccessFull ")
                    }
                }

                override fun onFailure(
                    call: Call<List<TotalPriceDto>?>,
                    t: Throwable
                ) {
                    Log.e("onFailure", "totalByPrice onFailure ${t.message}")
                }
            })

        }

    }

    fun totalProfit(){

        viewModelScope.launch {
            val call = productRepository.total_profit()
            call.enqueue(object : Callback<List<TotalProfitDto>>{

                override fun onResponse(
                    call: Call<List<TotalProfitDto>?>,
                    response: Response<List<TotalProfitDto>?>
                ) {
                    if (response.isSuccessful){
                        viewTotalProfit = response.body()!!
                        Log.d("onResponse ", "totalProfit isSuccesFull ")
                    }
                    else{
                        Log.d("onResponse ", "totalProfit isNotSuccessFull ")
                    }
                }

                override fun onFailure(
                    call: Call<List<TotalProfitDto>?>,
                    t: Throwable
                ) {
                    Log.e("onFailure", "totalProfit onFailure ${t.message}")
                }
            })
        }

    }

}