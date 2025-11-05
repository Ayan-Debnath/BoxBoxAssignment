package com.ayan.boxboxassignmnet.ui.screens.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.ayan.boxboxassignmnet.ui.common.HorizontalSpacer
import com.ayan.boxboxassignmnet.ui.theme.SessionColorBg
import com.ayan.boxboxassignmnet.ui.theme.SessionTimeColor

@Composable
fun SessionBox(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .width(163.dp)
            .height(132.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(SessionColorBg)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, top = 12.dp, end = 12.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                modifier = Modifier
                    .align(Alignment.End),
                painter = painterResource(R.drawable.session_track),
                contentDescription = null
            )
            Text(
                text = "FP1",
                color = Color.White,
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.space_grotesk_bold)),
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.calendar_check_4),
                    contentDescription = null
                )
                HorizontalSpacer(4)
                Text(
                    text = "04 Friday",
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.space_grotesk_bold)),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
            val annotatedString = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = SessionTimeColor,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.space_grotesk_bold)),
                        fontSize = 36.sp
                    )
                ) {
                    append("8:00")
                }
                withStyle(
                    style = SpanStyle(
                        color = SessionTimeColor,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.space_grotesk_bold)),
                        fontSize = 20.sp
                    )
                ) {
                    append("AM")
                }
            }
            Text(text = annotatedString)
        }
    }
}