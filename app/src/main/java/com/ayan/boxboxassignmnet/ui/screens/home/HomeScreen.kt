package com.ayan.boxboxassignmnet.ui.screens.home

import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ayan.boxboxassignmnet.R
import com.ayan.boxboxassignmnet.ui.common.HorizontalSpacer
import com.ayan.boxboxassignmnet.ui.common.VerticalSpacer
import com.ayan.boxboxassignmnet.ui.screens.HomeViewModel
import com.ayan.boxboxassignmnet.ui.theme.BorderColor
import com.ayan.boxboxassignmnet.ui.theme.DistanceBgColor
import com.ayan.boxboxassignmnet.ui.theme.HomeScreenBg
import com.ayan.boxboxassignmnet.ui.theme.InnerBoxColor
import com.ayan.boxboxassignmnet.ui.theme.MediumColor
import com.ayan.boxboxassignmnet.ui.theme.SessionColorBg
import com.ayan.boxboxassignmnet.ui.theme.SessionTimeColor
import com.ayan.boxboxassignmnet.ui.theme.TopSliderBg
import com.ayan.boxboxassignmnet.ui.theme.TopSliderTextColor
import com.ayan.boxboxassignmnet.utils.HelperFunction.pxToDp

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {

    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(HomeScreenBg)
            .verticalScroll(state = rememberScrollState())
    ) {
        TopSlider()
        Row(
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp, end = 16.dp)
        ) {
            SessionBox()
            HorizontalSpacer(8)
            Column {
                DistanceBox()
                VerticalSpacer(8)
                MediumBox()
            }
        }
        BottomBanner(
            modifier = Modifier.padding(16.dp)
        )
    }


}


@Composable
fun SessionBox(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .width(163.dp)
            .height(132.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(SessionColorBg)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
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

@Composable
fun DistanceBox(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
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

@Composable
fun BottomBanner(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .width(338.dp)
            .height(360.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        Image(
            painter = painterResource(R.drawable.bottom_banner),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Image(
            painter = painterResource(R.drawable.insta),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(12.dp)
        )
    }
}

@Composable
fun TopSlider(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(420.dp)
            .background(TopSliderBg)
    ) {
        Text(
            modifier = Modifier
                .statusBarsPadding()
                .padding(top = 18.dp, start = 20.dp),
            text = "Lando",
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
            modifier = Modifier.align(Alignment.BottomStart)
        )
    }
}

@Composable
fun ScoreCard(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
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
                append("01")
            }
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily(Font(R.font.space_grotesk_medium)),
                    fontSize = 10.sp
                )
            ) {
                append("Pos")
            }
        }
        Text(text = annotatedString)
        HorizontalSpacer(10)
        Image(
            painter = painterResource(R.drawable.alt),
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
                append("09")
            }
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily(Font(R.font.space_grotesk_medium)),
                    fontSize = 10.sp
                )
            ) {
                append("Wins")
            }
        }
        Text(text = annotatedWinString)
    }
}