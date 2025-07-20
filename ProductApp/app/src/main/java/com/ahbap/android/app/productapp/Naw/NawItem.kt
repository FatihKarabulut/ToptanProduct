package com.ahbap.android.app.productapp.Naw

enum class Router{
    DASHBOARD,PRODUCTS,PRODUCT_SAVE,REPORT,EDIT_PAGE,
    TOTAL_PRIRICE,TOTAL_PROFIT


}

sealed class NavItem(var router : String){
    object Dashboard: NavItem(Router.DASHBOARD.name)
    object Product : NavItem(Router.PRODUCTS.name)
    object ProductSave : NavItem(Router.PRODUCT_SAVE.name)
    object Report : NavItem(Router.REPORT.name)
    object Edit : NavItem(Router.EDIT_PAGE.name)
    object TotalPrice : NavItem(Router.TOTAL_PRIRICE.name)

    object TotalProfit : NavItem(Router.TOTAL_PROFIT.name)
}