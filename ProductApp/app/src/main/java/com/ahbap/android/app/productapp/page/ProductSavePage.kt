package com.ahbap.android.app.productapp.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ahbap.android.app.productapp.R
import com.ahbap.android.app.productapp.page.composable.CardList
import com.ahbap.android.app.productapp.view.ViewProduct
import com.ahbap.android.app.productapp.view.Views

@Composable
fun ProductSavePage(nav: NavHostController,views: Views = hiltViewModel(),
                    viewProduct: ViewProduct = hiltViewModel()) {

    var count by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxSize(),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Card(
            modifier = Modifier.padding(10.dp).fillMaxWidth(),
            elevation = CardDefaults.cardElevation(12.dp),
            shape = RoundedCornerShape(
                topStart = 10.dp,
                topEnd = 10.dp,
                bottomEnd = 85.dp,
                bottomStart = 10.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
                contentColor = Color.Black
            )

        ) {
            Column(
                modifier = Modifier
                    .padding(top = 20.dp).fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {

                TextField(
                    viewProduct.personName, onValueChange = { viewProduct.personName = it },
                    textStyle = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.DarkGray,
                        focusedTextColor = colorResource(id = R.color.gold),
                        unfocusedContainerColor = Color.DarkGray,
                        unfocusedTextColor = colorResource(id = R.color.gold)

                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Person",
                            tint = Color.White
                        )
                    },
                    label = {
                        Text(
                            "Personel ismi", style = TextStyle(
                                color = Color.LightGray,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Light
                            )
                        )
                    })
                Spacer(modifier = Modifier.padding(top = 8.dp))
                TextField(
                    viewProduct.name, onValueChange = { viewProduct.name = it },
                    textStyle = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.DarkGray,
                        focusedTextColor = colorResource(id = R.color.gold),
                        unfocusedContainerColor = Color.DarkGray,
                        unfocusedTextColor = colorResource(id = R.color.gold)


                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Name",
                            tint = Color.White
                        )
                    },
                    label = {
                        Text(
                            "Ürün ismi", style = TextStyle(
                                color = Color.LightGray,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Light
                            )
                        )
                    })

                Spacer(modifier = Modifier.padding(top = 8.dp))

                TextField(
                    viewProduct.stockStr, onValueChange = { viewProduct.stockStr = it },
                    textStyle = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.DarkGray,
                        focusedTextColor = colorResource(id = R.color.gold),
                        unfocusedContainerColor = Color.DarkGray,
                        unfocusedTextColor = colorResource(id = R.color.gold)
                    ),
                    label = {
                        Text(
                            "Stok", style = TextStyle(
                                color = Color.LightGray,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Light
                            )
                        )
                    },

                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Inventory,
                            contentDescription = "Stok",
                            tint = Color.White
                        )
                    }
                )

                Spacer(modifier = Modifier.padding(top = 8.dp))

                TextField(
                    viewProduct.byPriceStr,
                    onValueChange = { viewProduct.byPriceStr = it },
                    textStyle = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.DarkGray,
                        focusedTextColor = colorResource(id = R.color.gold),
                        unfocusedContainerColor = Color.DarkGray,
                        unfocusedTextColor = colorResource(id = R.color.gold)

                    ),
                    label = {
                        Text(
                            "byPrice", style = TextStyle(
                                color = Color.LightGray,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Light
                            )
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.AttachMoney,
                            contentDescription = "byPrice",
                            tint = Color.White
                        )
                    }
                )

                Spacer(modifier = Modifier.padding(top = 8.dp))

                TextField(
                    viewProduct.sellPriceStr,
                    onValueChange = { viewProduct.sellPriceStr = it },
                    textStyle = TextStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.DarkGray,
                        focusedTextColor = colorResource(id = R.color.gold),
                        unfocusedContainerColor = Color.DarkGray,
                        unfocusedTextColor = colorResource(id = R.color.gold)

                    ),
                    label = {
                        Text(
                            "sellPrice", style = TextStyle(
                                color = Color.LightGray,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Light
                            )
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.AttachMoney,
                            contentDescription = "sellPrice",
                            tint = Color.White
                        )
                    }
                )

                Spacer(modifier = Modifier.padding(top = 8.dp))

                Button(
                    modifier = Modifier.padding(10.dp).width(280.dp),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 10.dp,
                        pressedElevation = 15.dp,
                        disabledElevation = 0.dp,

                        ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.gold),
                        contentColor = Color.White
                    ),

                    shape = RoundedCornerShape(10.dp),
                    onClick = {

                        viewProduct.toBigDecimalAndToInt()
                        views.SaveProduct(viewProduct.toProduct())
                        ++count

                    },
                    enabled = viewProduct.enabledButton()
                )
                {

                    Text(
                        stringResource(id = R.string.text_name_save), style = TextStyle(
                            color = Color.DarkGray,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold

                        )
                    )

                }

                if (views.viewSaveBool){

                    Text("${stringResource(id = R.string.text_name_succes_save)} ${count}",style = TextStyle(
                    color = colorResource(id = R.color.success),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal
                )) }
                else
                    Text(stringResource(id = R.string.text_name_unsucces_save),style = TextStyle(
                    color = Color.Red,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal
                ))

            }



        }


    }


}



