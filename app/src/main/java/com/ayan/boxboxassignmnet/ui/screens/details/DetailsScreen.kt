package com.ayan.boxboxassignmnet.ui.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ayan.boxboxassignmnet.R
import com.ayan.boxboxassignmnet.ui.common.HorizontalSpacer
import com.ayan.boxboxassignmnet.ui.common.VerticalSpacer
import com.ayan.boxboxassignmnet.ui.theme.BlackBg
import com.ayan.boxboxassignmnet.ui.theme.CircuitTextColor

@Composable
fun DetailsScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BlackBg)
    ) {
        Header()
        StaticDescription()
    }
}

@Composable
fun Header(modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(380.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 22.dp)
                .statusBarsPadding(),
            text = "Upcoming race",
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_medium)),
            color = Color.White,
            textAlign = TextAlign.Center
        )
        Image(
            painter = painterResource(R.drawable.circuit),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 11.dp, top = 45.dp)
                .width(156.dp)
                .height(106.dp)
                .align(Alignment.CenterEnd)
        )
        RaceInfo(modifier = Modifier.align(Alignment.CenterStart).padding(top = 150.dp))
    }
}

@Composable
fun RaceInfo(modifier: Modifier = Modifier) {
    Column(modifier.padding(bottom = 20.dp, start = 20.dp)) {
        Text(
            modifier = Modifier,
            text = "Round 12",
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_medium)),
            fontWeight = FontWeight.Medium,
            color = Color.White,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier,
            text = "São Paulo GP",
            fontSize = 22.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_black)),
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier,
            text = "São Paulo",
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_medium)),
            fontWeight = FontWeight.SemiBold,
            color = CircuitTextColor,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier,
            text = "23 - 30 April",
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_medium)),
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            textAlign = TextAlign.Center
        )
        VerticalSpacer(30)
        RaceCountdown()
    }
}

@Composable
fun RaceCountdown(modifier: Modifier = Modifier) {
    Column {
        Text(
            modifier = Modifier,
            text = "FP1 Starts in",
            fontSize = 10.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_medium)),
            fontWeight = FontWeight.W400,
            color = Color.White,
            textAlign = TextAlign.Center,
            lineHeight = 12.sp
        )
        Row {
            CountDownItem(value = "07", label = "Days")
            HorizontalSpacer(24)
            CountDownItem(value = "16", label = "Hours")
            HorizontalSpacer(24)
            CountDownItem(value = "42", label = "Minutes")
        }
    }
}

@Composable
fun CountDownItem(
    value: String,
    label: String
) {
    Column {
        Text(
            modifier = Modifier,
            text = value,
            fontSize = 28.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_medium)),
            fontWeight = FontWeight.W500,
            color = CircuitTextColor,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier,
            text = label,
            fontSize = 8.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_medium)),
            fontWeight = FontWeight.W400,
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun StaticDescription(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(start = 18.dp)
    ) {
        Text(
            modifier = Modifier,
            text = "São Paulo Circuit",
            fontSize = 18.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_bold)),
            fontWeight = FontWeight.W700,
            color = Color.White,
        )
        VerticalSpacer(12)
        Text(
            modifier = Modifier,
            text = """
                Bahrain International circuit is located in Sakhir, 
                Bahrain and it was designed by German architect Hermann Tilke. It was built on the site of a former 
                camel farm, in Sakhir. It measures 5.412 km, has 15 corners and 3 DRS Zones. The Grand Prix have 57 laps. This circuit has 6 alternative layouts.
            """.trimIndent(),
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_medium)),
            fontWeight = FontWeight.W500,
            color = Color.White,
            lineHeight = 18.sp
        )
        VerticalSpacer(30)
        Text(
            modifier = Modifier,
            text = "Circuit Facts",
            fontSize = 18.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_bold)),
            fontWeight = FontWeight.W700,
            color = Color.White,
        )
        Text(
            modifier = Modifier,
            text = "His brother Arthur Leclerc is currently set to race for DAMS in the 2023 F2 Championship",
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_medium)),
            fontWeight = FontWeight.W500,
            color = Color.White,
            lineHeight = 18.sp
        )
        VerticalSpacer(50)
        Text(
            modifier = Modifier,
            text = "His brother Arthur Leclerc is currently set to race for DAMS in the 2023 F2 Championship",
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.montserrat_medium)),
            fontWeight = FontWeight.W500,
            color = Color.White,
            lineHeight = 18.sp
        )
    }
}