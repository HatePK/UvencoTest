package com.uvencotest.ui.screens.topBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.uvencotest.R
import com.uvencotest.ui.viewModel.MainViewModel
import com.uvencotest.ui.theme.TopBarBottomBorderColor
import com.uvencotest.ui.theme.background
import com.uvencotest.ui.theme.logoText
import com.uvencotest.ui.theme.topBarTextColor
import com.uvencotest.ui.utils.montserratRegular


@Composable
fun TopBar(viewModel: MainViewModel, navController: NavHostController) {
    val temperature by viewModel.temperature.collectAsState()
    val time by viewModel.time.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(background)
            .height(54.dp)
            .drawBehind {
                drawLine(
                    color = TopBarBottomBorderColor,
                    start = Offset(0f, size.height - 1),
                    end = Offset(size.width, size.height - 1),
                    strokeWidth = 1.dp.toPx()
                )
            }
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 26.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                modifier = Modifier.clickable {
                    navController.navigate("details_screen")
                },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.height(24.dp),
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "logo"
                )
                Text(
                    modifier = Modifier.padding(start = 12.dp),
                    text = "RUNERO Touch",
                    color = logoText,
                    fontFamily = montserratRegular,
                    fontSize = 16.sp
                )
            }
            Row(
                modifier = Modifier.fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 24.dp),
                    color = topBarTextColor,
                    text = time,
                    fontFamily = montserratRegular,
                    fontSize = 16.sp
                )
                Row(
                    modifier = Modifier.padding(horizontal = 24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.width(38.dp),
                        color = topBarTextColor,
                        text = "$temperature",
                        fontFamily = montserratRegular,
                        fontSize = 16.sp
                    )
                    Text(
                        color = topBarTextColor,
                        text = "°",
                        fontFamily = montserratRegular,
                        fontSize = 16.sp
                    )
                    Image(
                        painter = painterResource(id = R.drawable.humidity_icon),
                        contentDescription = "humidity icon"
                    )
                }
                Row(
                    modifier = Modifier.padding(horizontal = 24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.width(11.dp).height(11.dp),
                        painter = painterResource(id = R.drawable.icon_russia),
                        contentDescription = "country"
                    )
                    Text(
                        modifier = Modifier.padding(start = 4.dp),
                        color = topBarTextColor,
                        text = "RU",
                        fontFamily = montserratRegular,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}