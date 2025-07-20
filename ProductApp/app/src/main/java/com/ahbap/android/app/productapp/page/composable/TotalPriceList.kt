package com.ahbap.android.app.productapp.page.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ahbap.android.app.productapp.R
import com.ahbap.android.app.productapp.retrofit.dto.TotalPriceDto

@Composable
fun TotalPriceList(
    navController: NavHostController,
    list: List<TotalPriceDto> = emptyList(),
    digit: Int
) {

    Column(modifier = Modifier.background(Color.White)) {
     Row(modifier = Modifier.fillMaxWidth(),
         horizontalArrangement = Arrangement.Absolute.spacedBy(15.dp)) {
         Image(painter = painterResource(id = R.drawable.outline_arrow_back_24),
             contentDescription = "Back",
             modifier = Modifier.size(50.dp).
             clickable{ navController.popBackStack() })
         Text(text = if (digit == 0 ) "Toplam Satış Fiyatı" else "Toplam Alış fiyatı",
             style = TextStyle(
                 color = Color.Black,
                 fontWeight = FontWeight.W800,
                 fontSize = 20.sp,
                 fontStyle = FontStyle.Italic
             ), modifier = Modifier.padding(top = 15.dp))

     }


        LazyColumn(modifier = Modifier.fillMaxSize().padding(5.dp)
            ,
           contentPadding = PaddingValues(5.dp) ) {

            items(list) {


                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp), colors = CardDefaults.cardColors(
                            containerColor = Color.White,
                            contentColor = Color.Black
                        ),
                        shape = RoundedCornerShape(10.dp),
                        elevation = CardDefaults.cardElevation(10.dp)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize().padding(15.dp),
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Top
                        ) {
                            Text(text = "Name : ${it.name}", fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )

                            Spacer(modifier = Modifier.padding(8.dp))

                            Text(text = "Total : ${it.totalPrice}", fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )

                            Spacer(modifier = Modifier.padding(8.dp))

                            Text(text = "Stock : ${it.stock}", fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )

                    }
                }
            }
        }
    }
}