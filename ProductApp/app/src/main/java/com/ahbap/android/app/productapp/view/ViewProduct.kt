package com.ahbap.android.app.productapp.view

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahbap.android.app.productapp.retrofit.IProduct
import com.ahbap.android.app.productapp.retrofit.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.text.NumberFormat

@HiltViewModel
class ViewProduct @Inject constructor(var product: IProduct) : ViewModel() {

    var personName by mutableStateOf("")
    var name by mutableStateOf("")
    var stock by mutableStateOf(0)
    var byPrice by mutableStateOf(BigDecimal.ZERO)
    var sellPrice by mutableStateOf(BigDecimal.ZERO)
    var sellPriceStr by mutableStateOf("")
    var byPriceStr by mutableStateOf("")
    var stockStr by mutableStateOf("")


    fun toBigDecimalAndToInt() {
        try {
                 stock = stockStr.toInt()
                byPrice = byPriceStr.toBigDecimal()
                sellPrice = sellPriceStr.toBigDecimal()
        } catch (ex: NumberFormatException) {
            Log.d("toBigDecimalAndToInt", "toBigDecimalAndToInt NumberFormatException ${ex.toString()}")
        }
    }
    fun enabledButton() : Boolean{
        return try {
            personName.isNotBlank() && name.isNotBlank()
                    && stockStr.isNotBlank() && byPriceStr.isNotBlank()
                    && sellPriceStr.isNotBlank()
                    && stockStr.toInt() > 0
        }
        catch (ex : NumberFormatException){
            Log.d("enabledButton", "enabledButton NumberFormatException ${ex.toString()}")
            false
        }
    }

    fun toProduct() : Product{
        return Product(name,personName,stock,byPrice,sellPrice)

    }


}