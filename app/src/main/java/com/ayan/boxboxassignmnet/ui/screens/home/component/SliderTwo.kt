package com.ayan.boxboxassignmnet.ui.screens.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayan.boxboxassignmnet.R
import com.ayan.boxboxassignmnet.ui.common.VerticalSpacer
import com.ayan.boxboxassignmnet.ui.theme.BlackBg
import com.ayan.boxboxassignmnet.ui.theme.FollowUsButtonColor

@Composable
fun SliderTwo(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(420.dp)
            .background(BlackBg),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            modifier = Modifier
                .width(271.dp)
                .height(214.dp),
            painter = painterResource(R.drawable.slide_two),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        VerticalSpacer(21)
        FollowUsButton()
    }
}

@Composable
fun FollowUsButton(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.width(140.dp)
            .height(44.dp)
            .clip(RoundedCornerShape(55.dp))
            .background(FollowUsButtonColor),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Follow Us",
            fontSize = 16.sp,
            fontWeight = FontWeight.W700,
            fontFamily = FontFamily(Font(R.font.montserrat_bold)),
        )
    }
}