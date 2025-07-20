package com.ahbap.android.app.productapp.page

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.ahbap.android.app.productapp.page.composable.CardList
import com.ahbap.android.app.productapp.view.Views


@Composable
fun ProductPage(nav : NavHostController,view : Views = hiltViewModel()){


    LaunchedEffect(Unit) {
        view.FindByList()
    }

    if (view.viewFindByList.isEmpty())
    {
        Text("Veriler Getirilemedi",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Black
            ), modifier = Modifier.padding(10.dp)
                .fillMaxWidth(),textAlign = TextAlign.Center)
    }
    else
        CardList(nav,view.viewFindByList)






}

