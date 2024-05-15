package com.uvencotest.ui.screens.mainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvencotest.R
import com.uvencotest.domain.entity.ProductDetails
import com.uvencotest.ui.theme.background
import com.uvencotest.ui.theme.cardGradient
import com.uvencotest.ui.theme.labelColor
import com.uvencotest.ui.theme.priceColor
import com.uvencotest.ui.theme.priceGradient
import com.uvencotest.ui.theme.topBarTextColor
import com.uvencotest.ui.theme.valueColor
import com.uvencotest.ui.utils.montserratBold
import com.uvencotest.ui.utils.montserratMedium
import com.uvencotest.ui.utils.montserratRegular

@Composable
fun RenderLoading() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(50.dp),
            color = topBarTextColor
        )
    }
}

@Composable
fun RenderContent(list: List<ProductDetails>) {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 12.dp,
                start = 12.dp,
                end = 12.dp
            ),
        columns = GridCells.Adaptive(minSize = 227.dp),
    ) {
        items(list.size) {
            ProductCard(list[it])
        }
    }
}

@Composable
fun ProductCard(product: ProductDetails) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = background,
        ),
        modifier = Modifier.padding(12.dp)
    ) {
        Column(
            modifier = Modifier
                .background(cardGradient)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(210.dp)
                    .width(210.dp),
                painter = painterResource(id = when (product.imageOption) {
                    ProductDetails.ImageSource.AMERICANO -> R.drawable.americano
                    ProductDetails.ImageSource.CAPPUCCINO -> R.drawable.cappuchino
                }),
                contentDescription = "product image",
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(57.dp)
                    .padding(top = 6.dp),
                textAlign = TextAlign.Center,
                text = product.name,
                color = labelColor,
                fontFamily = montserratMedium,
                fontSize = 17.sp
            )
            Box(
                modifier = Modifier
                    .padding(top = 18.dp)
                    .background(priceGradient)
                    .fillMaxWidth()
                    .height(42.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = if (product.isFree) {
                        Arrangement.Center
                    } else {
                        Arrangement.SpaceBetween
                    },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        color = valueColor,
                        text = "${product.volume}",
                        fontFamily = montserratRegular,
                        fontSize = 16.sp
                    )
                    if (!product.isFree) {
                        Text(
                            color = priceColor,
                            text = "${product.price} ₽",
                            fontFamily = montserratBold,
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }
}