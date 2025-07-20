package com.ahbap.android.app.productapp.Naw

import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ahbap.android.app.productapp.page.DashboardPage
import com.ahbap.android.app.productapp.page.EditPage
import com.ahbap.android.app.productapp.page.ProductPage
import com.ahbap.android.app.productapp.page.ProductSavePage
import com.ahbap.android.app.productapp.page.ReportPage
import com.ahbap.android.app.productapp.page.TotalPricePage
import com.ahbap.android.app.productapp.page.TotalProfitPage

@Composable
fun NavControler(modifier: Modifier,
                 nav : NavHostController = rememberNavController(),
                 startDestination : String = NavItem.Product.router
) {

    NavHost(modifier = modifier,navController = nav,startDestination = startDestination) {

        composable(NavItem.Dashboard.router){

            DashboardPage(nav)
        }
        composable(NavItem.Product.router){

            ProductPage(nav)
        }
        composable(NavItem.ProductSave.router) {

            ProductSavePage(nav)
        }
        composable(NavItem.Report.router) {

            ReportPage(nav)

        }
        composable(NavItem.Edit.router) {

            EditPage(nav)

        }
        composable("${NavItem.TotalPrice.router}/{digit}",
            arguments = listOf(navArgument("digit"){type = NavType.IntType})


           ) { entry ->
            val digit = entry.arguments?.getInt("digit") ?: -1

            TotalPricePage(nav,digit)
        }

        composable(NavItem.TotalProfit.router) {

            TotalProfitPage(nav)

        }

    }

}