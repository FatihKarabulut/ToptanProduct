package com.ahbap.android.app.productapp.page.composable

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ahbap.android.app.productapp.retrofit.Product
import com.ahbap.android.app.productapp.view.Views
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun FindByList(nav: NavHostController, view: Views = hiltViewModel()) : List<Product> {

    var list by remember {
        mutableStateOf(emptyList<Product>())
    }

    val call = view.productRepository.findAll()

    call.enqueue(object : Callback<List<Product>>{

        override fun onResponse(
            call: Call<List<Product>?>,
            response: Response<List<Product>?>
        )
        {
            if (response.isSuccessful)
                list = response.body()!!
            else
                Log.d("onResponse ","isNotSuccessFull ")
        }

        override fun onFailure(
            call: Call<List<Product>?>,
            t: Throwable
        ) {
            list = emptyList()
            Log.d("onFailure","onFailure ${t.message}")
        }
    })

    return list

}