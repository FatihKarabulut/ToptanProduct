package com.ahbap.android.app.productapp.page

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ahbap.android.app.productapp.R
import com.ahbap.android.app.productapp.page.composable.CardList
import com.ahbap.android.app.productapp.retrofit.Product
import com.ahbap.android.app.productapp.view.Views
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun EditPage(nav: NavHostController, view: Views = hiltViewModel()) {


        var name by remember {
            mutableStateOf("")
        }
        var cardList by remember {
            mutableStateOf(emptyList<Product>())
        }
    var digit by remember {
        mutableStateOf(-1)
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),

            ) {

            TextField(
                name, onValueChange = { name = it },
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold

                ),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,

                    ), placeholder = {
                    Text(
                        "Ürün Adıyla Ara", style = TextStyle(
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Black

                        )
                    )
                },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.width(250.dp)
                    .height(55.dp).padding(end = 5.dp)
            )
            Button(
                modifier = Modifier.fillMaxWidth().height(55.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.success),
                    contentColor = Color.White
                ), onClick = {
                    view.findByName(name)
                   digit = 0
                }) {
                Text(
                    "Ara",
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Black

                    )
                )
            }

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
                 horizontalArrangement = Arrangement.Center
        ) {

            Button(
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.gold),
                    contentColor = Color.White
                ),onClick = {
                    view.FindByList()
                    digit = 1
                })
            {
                Text("Tümünü göster", style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Black
                ))
            }

            Spacer(modifier = Modifier.size(10.dp))
            Button(
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.gold),
                    contentColor = Color.White
                ),onClick = {
                    view.ProductsWithStockLessThan(6)
                    digit = 2
                })
            {
                Text("Stok < 5", style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Black
                ))
            }

        }
        if (digit == 0)
            CardList(nav, view.viewFindByName)
        else if (digit == 1)
            CardList(nav, view.viewFindByList)

        else if (digit == 2)
            CardList(nav, view.viewStockList)
    }
}

