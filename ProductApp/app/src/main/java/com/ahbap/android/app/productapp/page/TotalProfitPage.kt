package com.ahbap.android.app.productapp.page

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ahbap.android.app.productapp.R
import com.ahbap.android.app.productapp.retrofit.dto.TotalProfitDto
import com.ahbap.android.app.productapp.view.Views

@Composable
fun TotalProfitPage(navController: NavHostController,
                    views: Views = hiltViewModel()
) {

    var list by remember {
        mutableStateOf(emptyList<TotalProfitDto>())

    }
    LaunchedEffect(Unit) {
        views.totalProfit()

    }
    list = views.viewTotalProfit

    Column(modifier = Modifier.fillMaxSize()

        .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)) {

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.spacedBy(15.dp)) {
            Image(painter = painterResource(id = R.drawable.outline_arrow_back_24),
                contentDescription = "Back",
                modifier = Modifier.size(50.dp).
                clickable{ navController.popBackStack() },
                colorFilter = ColorFilter.tint(Color.White))
            Text(text = "Toplam Kar",
                style = TextStyle(
                    color = Color.White,
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
                        containerColor = colorResource(id = R.color.gold),
                        contentColor = Color.Black
                    ),
                    shape = RoundedCornerShape(10.dp),
                    elevation = CardDefaults.cardElevation(10.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize().padding(15.dp),
                        verticalArrangement = Arrangement.Top
                    ) {
                        Text(text = "Name : ${it.name}", fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )


                        Spacer(modifier = Modifier.padding(8.dp))

                        Text(text = "Stock : ${it.stock}", fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )

                        Spacer(modifier = Modifier.padding(8.dp))


                        Text(text = "Total : ${it.totalProfit}", fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )

                        Spacer(modifier = Modifier.padding(8.dp))

                        Text(text = "ByPrice : ${it.byPrice}", fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )
                        Spacer(modifier = Modifier.padding(8.dp))
                        Text(text = "SelPrice : ${it.sell_Price}", fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                        )

                    }

                }
            }

        }

    }

}