package com.ayan.boxboxassignmnet.ui.screens.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayan.boxboxassignmnet.R
import com.ayan.boxboxassignmnet.ui.theme.DistanceBgColor
import com.ayan.boxboxassignmnet.ui.theme.InnerBoxColor

@Composable
fun DistanceBox(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .width(163.dp)
            .height(60.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(DistanceBgColor),
    ) {
        InnerBox()
        Row(
            modifier = Modifier.align(Alignment.Center),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier,
                painter = painterResource(R.drawable.route),
                contentDescription = null
            )
            val annotatedString = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.space_grotesk_bold)),
                        fontSize = 28.sp
                    )
                ) {
                    append("7015.3")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.space_grotesk_bold)),
                        fontSize = 14.sp
                    )
                ) {
                    append("AM")
                }
            }
            Text(text = annotatedString)
        }

    }
}

@Composable
fun InnerBox(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .width(61.dp)
            .height(60.dp)
            .clip(RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp))
            .background(InnerBoxColor)

    )
}