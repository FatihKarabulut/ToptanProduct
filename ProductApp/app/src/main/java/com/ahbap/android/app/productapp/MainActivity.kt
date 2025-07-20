package com.ahbap.android.app.productapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ahbap.android.app.productapp.Naw.NavControler
import com.ahbap.android.app.productapp.Naw.NavItem
import com.ahbap.android.app.productapp.ui.theme.ProductAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProductAppTheme {
                val nav: NavHostController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { TopAppBars(nav) },
                    containerColor = Color.DarkGray,
                    contentColor = Color.White,
                ) { innerPadding ->
                    NavControler(
                        modifier = Modifier.padding(innerPadding),
                        nav = nav,
                        startDestination = NavItem.Product.router
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun TopAppBars(nav: NavHostController) {

    var dashboardColor by remember {
        mutableStateOf(Color.White)
    }
    var productColor by remember {
        mutableStateOf(Color.Green)
    }
    var productSaveColor by remember {
        mutableStateOf(Color.White)
    }
    var reportColor by remember {
        mutableStateOf(Color.White)
    }

    CenterAlignedTopAppBar(title = {

        FlowRow(
           horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {


            Text(
                text = "Dashboard", style = TextStyle(
                    color = dashboardColor,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Black
                ),
                modifier = Modifier.clickable {
                    dashboardColor = Color.Green
                    productColor = Color.White
                    productSaveColor = Color.White
                    reportColor = Color.White
                    nav.navigate(NavItem.Dashboard.router)

                })
            Text(
                text = "Ürünler", style = TextStyle(
                    color = productColor,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Black
                ), modifier = Modifier.clickable{
                    dashboardColor = Color.White
                    productColor = Color.Green
                    productSaveColor = Color.White
                    reportColor = Color.White

                    nav.navigate(NavItem.Product.router)
                }
            )

                    Text(
                        text = "Ürün Ekle", style = TextStyle(
                            color = productSaveColor,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Black
                        ), modifier = Modifier.clickable{
                            dashboardColor = Color.White
                            productColor = Color.White
                            productSaveColor = Color.Green
                            reportColor = Color.White

                            nav.navigate(NavItem.ProductSave.router)
                        }
                    )
                    Text(
                        text = "Rapor", style = TextStyle(
                            color = reportColor,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Black
                        ), modifier = Modifier.clickable{
                            dashboardColor = Color.White
                            productColor = Color.White
                            productSaveColor = Color.White
                            reportColor = Color.Green

                            nav.navigate(NavItem.Report.router)
                        }
                    )

                }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.DarkGray
        ), modifier = Modifier
            .border(2.dp,Color.Green, shape = RoundedCornerShape(5.dp))




        )

    }





