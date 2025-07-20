package com.ahbap.android.app.productapp.page

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ahbap.android.app.productapp.page.composable.TotalPriceList
import com.ahbap.android.app.productapp.retrofit.dto.TotalPriceDto
import com.ahbap.android.app.productapp.view.Views

@Composable
fun TotalPricePage(navController: NavHostController, digit: Int, view: Views = hiltViewModel()) {


    var list = emptyList<TotalPriceDto>()
    if (digit == 0) {
        view.totalSellPrice()
        list = view.viewTotalSellPrice
    } else if (digit == 1) {
        view.totalByPrice()
        list = view.viewTotalByPrice
    } else
        list = emptyList()



    if (list.isEmpty())
        Text("Boş")
    else
        TotalPriceList(navController,list,digit)


}



