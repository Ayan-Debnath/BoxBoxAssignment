package com.ayan.boxboxassignmnet.ui.screens.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayan.boxboxassignmnet.R
import com.ayan.boxboxassignmnet.ui.theme.BorderColor
import com.ayan.boxboxassignmnet.ui.theme.MediumColor

@Composable
fun MediumBox(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .width(163.dp)
            .height(60.dp)
            .clip(RoundedCornerShape(16.dp))
            .border(1.dp, BorderColor, RoundedCornerShape(16.dp))
            .background(MediumColor),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 14.dp, top = 14.dp, end = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                modifier = Modifier,
                painter = painterResource(R.drawable.medium),
                contentDescription = null
            )
            Column {
                Text(
                    text = "Formula1",
                    color = Color.White,
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontFamily = FontFamily(Font(R.font.space_grotesk_bold)),
                )
                Text(
                    text = "Education",
                    color = Color.White,
                    fontSize = 16.sp,
                    lineHeight = 18.sp,
                    fontFamily = FontFamily(Font(R.font.space_grotesk_bold)),
                )
            }
            Image(
                modifier = Modifier,
                painter = painterResource(R.drawable.vector),
                contentDescription = null
            )
        }
    }
}