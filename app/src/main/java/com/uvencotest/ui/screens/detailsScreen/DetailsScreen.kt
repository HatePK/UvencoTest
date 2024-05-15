package com.uvencotest.ui.screens.detailsScreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavHostController
import com.uvencotest.R
import com.uvencotest.domain.entity.ProductDetails
import com.uvencotest.ui.viewModel.MainViewModel
import com.uvencotest.ui.theme.TopBarBottomBorderColor
import com.uvencotest.ui.theme.background
import com.uvencotest.ui.theme.buttonTextColor
import com.uvencotest.ui.theme.inputBackground
import com.uvencotest.ui.theme.inputTextColor
import com.uvencotest.ui.theme.labelColor
import com.uvencotest.ui.theme.priceColor
import com.uvencotest.ui.theme.switchBackground
import com.uvencotest.ui.theme.topBarTextColor
import com.uvencotest.ui.utils.montserratMedium
import com.uvencotest.ui.utils.montserratRegular

@Composable
fun RenderDetails(viewModel: MainViewModel, navController: NavHostController) {
    val productDetails = viewModel.getDetails()
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current

    var text by remember { mutableStateOf(productDetails.name) }
    var price by remember { mutableIntStateOf(productDetails.price) }
    var isChecked by remember { mutableStateOf(productDetails.isFree) }

    var isImageOneClicked by remember {
        when (productDetails.imageOption) {
            ProductDetails.ImageSource.CAPPUCCINO -> mutableStateOf(true)
            ProductDetails.ImageSource.AMERICANO -> mutableStateOf(false)
        }
    }

    var isImageTwoClicked by remember {
        when (productDetails.imageOption) {
            ProductDetails.ImageSource.CAPPUCCINO -> mutableStateOf(false)
            ProductDetails.ImageSource.AMERICANO -> mutableStateOf(true)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                focusManager.clearFocus()
            }
            .background(background),
        contentAlignment = Alignment.Center
    ){
        Column {
            Row(){
                Column(
                    modifier = Modifier.width(418.dp)
                ) {
                    Text(
                        color = labelColor,
                        text = "Наименование",
                        fontFamily = montserratMedium,
                        fontSize = 16.sp
                    )
                    TextField(
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = inputBackground,
                            focusedContainerColor = inputBackground,
                            unfocusedTextColor = inputTextColor,
                            focusedTextColor = inputTextColor,
                            cursorColor = topBarTextColor,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                        ),
                        shape = RoundedCornerShape(6.dp),
                        modifier = Modifier
                            .padding(top = 12.dp)
                            .fillMaxWidth(),
                        value = text,
                        onValueChange = { text = it },
                        textStyle = TextStyle(
                            fontFamily = montserratMedium,
                            fontSize = 20.sp
                        )
                    )
                    Text(
                        modifier = Modifier.padding(top = 32.dp),
                        color = labelColor,
                        text = "Цена",
                        fontFamily = montserratMedium,
                        fontSize = 16.sp
                    )
                    TextField(
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = inputBackground,
                            focusedContainerColor = inputBackground,
                            unfocusedTextColor = inputTextColor,
                            focusedTextColor = inputTextColor,
                            cursorColor = topBarTextColor,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        textStyle = TextStyle(
                            fontFamily = montserratMedium,
                            fontSize = 20.sp
                        ),
                        trailingIcon = {
                            Text(
                                color = topBarTextColor,
                                text = "₽",
                                fontFamily = montserratMedium,
                                fontSize = 20.sp
                            )
                        },
                        shape = RoundedCornerShape(6.dp),
                        modifier = Modifier
                            .padding(top = 12.dp)
                            .fillMaxWidth(),
                        value = price.toString(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        onValueChange = {
                            if (it.isEmpty()) price = 0 else
                            if (it.isDigitsOnly()) price = it.toInt()
                        },
                    )
                    Box(
                        modifier = Modifier
                            .padding(top = 12.dp)
                            .height(48.dp)
                            .border(1.dp, TopBarBottomBorderColor, RoundedCornerShape(12.dp))
                            .fillMaxWidth()
                    ){
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 24.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                color = topBarTextColor,
                                text = "Продавать бесплатно",
                                fontFamily = montserratRegular,
                                fontSize = 14.sp
                            )
                            Switch(
                                modifier = Modifier.scale(0.8f),
                                checked = isChecked,
                                onCheckedChange = {
                                    isChecked = it
                                    focusManager.clearFocus()
                                },
                                colors = SwitchDefaults.colors(
                                    checkedTrackColor = switchBackground
                                )
                            )
                        }
                    }
                }
                Row(modifier = Modifier.padding(start = 30.dp)) {
                    Box(modifier = Modifier.clickable {
                        isImageOneClicked = true
                        isImageTwoClicked = false
                        focusManager.clearFocus()
                    }) {
                        Image(
                            modifier = Modifier.width(227.dp),
                            painter = painterResource(id = R.drawable.cappuchino),
                            contentDescription = "capuchino",
                            alpha = if (isImageOneClicked) 1.0f else 0.3f
                        )
                        if (isImageOneClicked) {
                            Image(
                                modifier = Modifier
                                    .align(Alignment.BottomCenter)
                                    .padding(bottom = 20.dp),
                                painter = painterResource(id = R.drawable.success_icon),
                                contentDescription = "choosen"
                            )
                        }
                    }
                    Box(modifier = Modifier.clickable {
                        isImageOneClicked = false
                        isImageTwoClicked = true
                        focusManager.clearFocus()
                    }) {
                        Image(
                            modifier = Modifier
                                .width(227.dp)
                                .padding(top = 18.dp),
                            painter = painterResource(id = R.drawable.americano),
                            contentDescription = "americano",
                            alpha = if (isImageTwoClicked) 1.0f else 0.3f
                        )
                        if (isImageTwoClicked) {
                            Image(
                                modifier = Modifier
                                    .align(Alignment.BottomCenter)
                                    .padding(bottom = 40.dp),
                                painter = painterResource(id = R.drawable.success_icon),
                                contentDescription = "choosen"
                            )
                        }
                    }
                }
            }
            Box(modifier = Modifier.padding(top = 64.dp)) {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = priceColor
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.height(52.dp),
                    onClick = {
                        viewModel.saveDetails(
                            ProductDetails(
                                name = text,
                                price = price,
                                isFree = isChecked,
                                imageOption = if (isImageOneClicked) {
                                    ProductDetails.ImageSource.CAPPUCCINO
                                } else {
                                    ProductDetails.ImageSource.AMERICANO
                                }
                            )
                        )
                        navController.navigate("main_screen")
                        Toast.makeText(context, "Детали напитка сохранены успешно", Toast.LENGTH_SHORT).show()
                    }
                ) {
                    Text(
                        color = buttonTextColor,
                        text = "Сохранить",
                        fontFamily = montserratMedium,
                        fontSize = 16.sp
                    )
                }
            }
        }

    }
}