package com.ahbap.android.app.productapp.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material.icons.filled.Sell
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ahbap.android.app.productapp.Naw.NavItem
import com.ahbap.android.app.productapp.R
import com.ahbap.android.app.productapp.page.globalNumber.TOTAL_BY_PRICE
import com.ahbap.android.app.productapp.page.globalNumber.TOTAL_SELL
import com.ahbap.android.app.productapp.view.Views
import java.math.BigDecimal

@Composable
fun DashboardPage(nav : NavHostController,views: Views = hiltViewModel()) {

    LaunchedEffect(Unit) {
        views.totalStock()
        views.maxSelPrice()
        views.maxByPrice()
        views.minSelPrice()
        views.minByPrice()
        views.totalSellPrice()
        views.totalByPrice()
        views.totalProfit()
    }

    Column(modifier = Modifier.fillMaxSize().padding(top = 8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start) {
        Card(colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.Green_button_plus),
            contentColor = Color.White
        ), shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(10.dp)
        ) {



            Row(modifier = Modifier.fillMaxWidth().padding(5.dp),
                horizontalArrangement = Arrangement.Start,
            ) {

                Icon(
                    imageVector = Icons.Default.Inventory,
                    contentDescription = "Stok",
                    tint = Color.White
                )

                Text("${stringResource(id = R.string.text_name_dashboard_sum_stock)}: \n ${views.viewTotalStock} Adet",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ),

                    )



            }



        } // card
        Spacer(modifier = Modifier.padding(5.dp))

        Card(colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.Redd),
            contentColor = Color.White
        ),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            onClick = {nav.navigate("${NavItem.TotalPrice.router}/$TOTAL_SELL")}) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                horizontalArrangement = Arrangement.Start,
            ) {


                val totalSelPrice = views.viewTotalSellPrice
                val sum = totalSelPrice.sumOf { it.totalPrice }
                Icon(
                    imageVector = Icons.Default.AttachMoney, contentDescription = "Toplam Satış Fiyatı",
                    tint = Color.White
                )
                Text(
                    "${stringResource(id = R.string.text_name_dashboard_total_sell_price)}: \n ${(sum)}",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )

            }
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Card(colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.total_by_price),
            contentColor = Color.White
        ),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            onClick = {nav.navigate("${NavItem.TotalPrice.router}/$TOTAL_BY_PRICE")}) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                horizontalArrangement = Arrangement.Start,
            ) {


                val totalByPrice = views.viewTotalByPrice
                val sum = totalByPrice.sumOf { it.totalPrice }
                Icon(
                    imageVector = Icons.Default.AttachMoney, contentDescription = "Toplam Alış Fiyatı",
                    tint = Color.White
                )
                Text(
                    "${stringResource(id = R.string.text_name_dashboard_total_by_price)}: \n ${(sum)}",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )

            }
        }

        Spacer(modifier = Modifier.padding(5.dp))
        Card(colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.warning),
            contentColor = Color.White
        ),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            onClick = {nav.navigate(NavItem.TotalProfit.router)}) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                horizontalArrangement = Arrangement.Start,
            ) {


                val totalProfit = views.viewTotalProfit
                val sum = totalProfit.filter { it.totalProfit != null }
                    .fold(BigDecimal.ZERO) { acc, item -> acc + item.totalProfit!! }

                Icon(
                    imageVector = Icons.Default.AttachMoney, contentDescription = "Toplam Kar Fiyatı",
                    tint = Color.White
                )
                Text(
                    "${stringResource(id = R.string.text_name_dashboard_total_profit)}: \n ${(sum)}",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                )

            }
        }

        Spacer(modifier = Modifier.padding(5.dp))


        Spacer(modifier = Modifier.padding(5.dp))
        Card(colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.purple_200),
            contentColor = Color.White
        ),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(10.dp)){

            Row(modifier = Modifier.fillMaxWidth().padding(5.dp),
                horizontalArrangement = Arrangement.Start,
                ){

                val sellPrice = views.viewMaxSellPriceby
                Icon(imageVector = Icons.Default.Sell,contentDescription = "Satış Fiyatı",
                    tint = Color.White)
                Text( stringResource(id = R.string.text_name_dashboard_max_sell_price)+
                   ": \n ${sellPrice.name} (${sellPrice.sellPrice})",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ))
            }


        }

        Spacer(modifier = Modifier.padding(5.dp))
        Card(colors = CardDefaults.cardColors(
            containerColor = Color.Gray,
            contentColor = Color.White
        ),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(10.dp)){

            Row(modifier = Modifier.fillMaxWidth().padding(5.dp),
                horizontalArrangement = Arrangement.Start,
            ){



                val minSellPrice = views.viewMinSellPriceby

                Icon(imageVector = Icons.Default.Sell,contentDescription = "Satış Fiyatı",
                    tint = Color.White)
                Text( stringResource(id = R.string.text_name_dashboard_min_sell_price)+
                        ": \n ${minSellPrice.name} (${minSellPrice.sellPrice})",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ))
            }


        }

    Spacer(modifier = Modifier.padding(5.dp))
    Card(colors = CardDefaults.cardColors(
        containerColor = colorResource(id = R.color.teal_700),
        contentColor = Color.White
    ),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(10.dp)) {

        Row(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            horizontalArrangement = Arrangement.Start,
        ) {


            val maxByPrice = views.viewMaxByPriceby

            Icon(
                imageVector = Icons.Default.ShoppingCart, contentDescription = "Alış Fiyatı",
                tint = Color.White
            )
            Text(
                stringResource(id = R.string.text_name_dashboard_max_by_price) +
                        ": \n ${maxByPrice.name} (${maxByPrice.byPrice})",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )


    }}
        Spacer(modifier = Modifier.padding(5.dp))
        Card(colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.min_by_price),
            contentColor = Color.White
        ),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(10.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            horizontalArrangement = Arrangement.Start,
        ) {


            val minByPrice = views.viewMinByPriceby

            Icon(
                imageVector = Icons.Default.ShoppingCart, contentDescription = "Alış Fiyatı",
                tint = Color.White
            )
            Text(
                stringResource(id = R.string.text_name_dashboard_min_by_price) +
                        ": \n ${minByPrice.name} (${minByPrice.byPrice})",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )

        }
        }


}



}