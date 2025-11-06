package com.ayan.boxboxassignmnet.ui.screens.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayan.boxboxassignmnet.R
import com.ayan.boxboxassignmnet.ui.common.HorizontalSpacer
import com.ayan.boxboxassignmnet.ui.theme.PointsColor
import com.ayan.boxboxassignmnet.ui.theme.TopSliderBg
import com.ayan.boxboxassignmnet.ui.theme.TopSliderTextColor

@Composable
fun SliderOne(
    teamName: String,
    position: String,
    wins: String,
    points: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(420.dp)
            .background(TopSliderBg)
    ) {
        Text(
            modifier = Modifier
                .padding(top = 45.dp, start = 20.dp),
            text = teamName,
            fontSize = 154.sp,
            fontFamily = FontFamily(Font(R.font.space_grotesk_bold)),
            color = TopSliderTextColor.copy(alpha = 0.5f),
            maxLines = 1,
            overflow = TextOverflow.Visible,
            softWrap = false,
        )
        Image(
            painter = painterResource(R.drawable.lando_norris),
            contentDescription = null,
            modifier = Modifier
                .height(380.dp)
                .align(Alignment.BottomEnd),
            contentScale = ContentScale.FillHeight
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .align(Alignment.BottomCenter)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color(0xFF000000) // dark blur effect
                        )
                    )
                )
        )
        ScoreCard(
            modifier = Modifier.align(Alignment.BottomStart),
            position = position,
            wins = wins,
            points = points
        )
    }
}

@Composable
fun ScoreCard(
    modifier: Modifier = Modifier,
    position: String,
    wins: String,
    points: String
) {
    Column(modifier = modifier.padding(start = 33.dp, bottom = 33.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.alt),
                contentDescription = null,
                contentScale = ContentScale.FillHeight
            )
            val annotatedString = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.space_grotesk_bold)),
                        fontSize = 18.sp
                    )
                ) {
                    append(" $position")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily(Font(R.font.space_grotesk_medium)),
                        fontSize = 10.sp
                    )
                ) {
                    append(" Pos")
                }
            }
            Text(text = annotatedString)
            HorizontalSpacer(10)
            Image(
                painter = painterResource(R.drawable.icon),
                contentDescription = null,
                contentScale = ContentScale.FillHeight
            )
            val annotatedWinString = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.space_grotesk_bold)),
                        fontSize = 18.sp
                    )
                ) {
                    if (wins.toInt() < 10){
                        append(" 0$wins")
                    } else {
                        append(" $wins")
                    }
                }
                withStyle(
                    style = SpanStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily(Font(R.font.space_grotesk_medium)),
                        fontSize = 10.sp
                    )
                ) {
                    append(" Wins")
                }
            }
            Text(text = annotatedWinString)
        }
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = points,
                fontSize = 72.sp,
                fontFamily = FontFamily(Font(R.font.space_grotesk_light)),
                style = TextStyle(brush = PointsColor),
                fontWeight = FontWeight.W300,
                maxLines = 1,
                lineHeight = 70.sp
            )
            Image(
                modifier = Modifier.padding(bottom = 22.dp),
                painter = painterResource(R.drawable.pts),
                contentDescription = null,
                contentScale = ContentScale.FillHeight
            )
        }
    }
}