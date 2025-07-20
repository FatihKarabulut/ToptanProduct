package com.ahbap.android.app.productapp.page.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ahbap.android.app.productapp.Naw.NavItem
import com.ahbap.android.app.productapp.R
import com.ahbap.android.app.productapp.retrofit.Product
import com.ahbap.android.app.productapp.view.Views

@Composable
fun CardList(nav : NavHostController, list : List<Product>, view : Views = hiltViewModel())
{



    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),

        contentPadding = PaddingValues(5.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)) {




        items(list){


            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp),colors = CardDefaults.cardColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
                shape = RoundedCornerShape(10.dp),
                elevation = CardDefaults.cardElevation(10.dp)

            ) {
                Column(
                    modifier = Modifier.padding(5.dp),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            ,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,

                        )
                    {
                        Button(modifier = Modifier.padding(5.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.success),
                                contentColor = Color.White
                            ),
                            shape = RoundedCornerShape(5.dp),
                            onClick = {
                                view.updatePlusStock(it.name!!)



                            }) {

                            Text(stringResource(id = R.string.text_name_plus_stock),
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Black
                                ))
                        }

                        Button(modifier = Modifier.padding(5.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.warning),
                                contentColor = Color.White
                            ),
                            shape = RoundedCornerShape(5.dp),
                            onClick = {

                                view.updateMinusStock(it.name!!)

                            }) {

                            Text(stringResource(id = R.string.text_name_minus_stock),
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Black
                                ))
                        }
                            Button(modifier = Modifier.padding(5.dp),shape = RoundedCornerShape(5.dp),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = colorResource(id = R.color.Redd),
                                    contentColor = Color.White
                                ),onClick = {
                                    view.DeleteByName(it.name!!)
                                }) {

                                Text(stringResource(id = R.string.text_name_deletebyname),
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Black
                                    ))
                            }


                        Button(
                            shape = RoundedCornerShape(5.dp),
                            colors = ButtonDefaults.buttonColors(

                                containerColor = Color.Transparent,
                                contentColor = Color.White
                            ), onClick = {

                            }) {


                            Image(
                                modifier = Modifier.background(Color.Blue)
                                    .size(30.dp).clickable {
                                        nav.navigate(NavItem.Edit.router)
                                    },
                                painter = painterResource(R.drawable.edits),
                                contentDescription = "edit",
                                contentScale = ContentScale.Crop,
                                colorFilter = ColorFilter.tint(Color.White),

                                )


                        }





                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.Start,


                        ) {



                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,

                        ) {


                        Text(
                            "Personel ismi: ", style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        )
                        Text(
                            "${it.personName}", style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            "Ürün ismi: ", style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        )
                        Text(
                            "${it.name}", style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            "Stok: ", style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        )
                        Text(
                            "${it.stock}", style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            "Alış fiyatı: ", style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        )
                        Text(
                            "${it.byPrice}", style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            "Satış fiyatı: ", style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        )
                        Text(
                            "${it.sellPrice}", style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        )
                    }

                }
            }



            }

    }
}
