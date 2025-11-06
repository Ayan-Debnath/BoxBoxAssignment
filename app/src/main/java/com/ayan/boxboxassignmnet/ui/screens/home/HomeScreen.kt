package com.ayan.boxboxassignmnet.ui.screens.home

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.LoadingIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ayan.boxboxassignmnet.R
import com.ayan.boxboxassignmnet.ui.common.HorizontalSpacer
import com.ayan.boxboxassignmnet.ui.common.VerticalSpacer
import com.ayan.boxboxassignmnet.ui.screens.home.component.DistanceBox
import com.ayan.boxboxassignmnet.ui.screens.home.component.SessionBox
import com.ayan.boxboxassignmnet.ui.screens.home.component.SliderOne
import com.ayan.boxboxassignmnet.ui.screens.home.component.SliderTwo
import com.ayan.boxboxassignmnet.ui.theme.BlackBg
import kotlinx.coroutines.delay
import androidx.core.net.toUri
import androidx.navigation.NavController
import com.ayan.boxboxassignmnet.ui.navigation.Destinations
import com.ayan.boxboxassignmnet.ui.screens.home.component.MediumArticleBox

const val NUMBER_OF_PAGES = 2

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BlackBg)
            .verticalScroll(state = rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (uiState.isLoading) {
            LoadingIndicator(color = Color.White, modifier = Modifier.size(50.dp))
        } else {
            if (uiState.driverData != null && uiState.sessionUiData!= null){
                TopSlider(uiState = uiState)
                MidComponent(uiState){
                    navController.navigate(Destinations.Details.route)
                }
                BottomBanner(
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally),
                    openInstagram = {
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            "https://www.instagram.com/boxbox_club/".toUri()
                        )
                        context.startActivity(intent)
                    }
                )
            } else{
                Text(
                    "Some unexpected error occurred",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.space_grotesk_bold)),
                    fontWeight = FontWeight.W700,
                    lineHeight = 14.sp,
                    color = Color.White
                )
            }
        }
    }

}

@Composable
fun TopSlider(uiState: HomeUiState) {
    Box {
        AutoSlideBanner(uiState = uiState)
        GetPro()
    }
}

@Composable
fun MidComponent(
    homeUiState: HomeUiState,
    onSessionBoxClick: ()->Unit
) {
    val context = LocalContext.current
    val startDateTime = homeUiState.sessionUiData?.startTime?.split(",")?: emptyList()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        SessionBox(
            modifier = Modifier.weight(1f).clickable { onSessionBoxClick() },
            sessionName = homeUiState.sessionUiData?.sessionName ?: "",
            date = startDateTime[0],
            time = startDateTime[1]
        )
        HorizontalSpacer(8)
        Column {
            DistanceBox()
            VerticalSpacer(8)
            MediumArticleBox(
                openMedium = {
                    val intent = Intent(
                        Intent.ACTION_VIEW,
                        "https://blog.boxbox.club/tagged/beginners-guide".toUri()
                    )
                    context.startActivity(intent)
                }
            )
        }
    }
}


@Composable
fun BottomBanner(
    modifier: Modifier = Modifier,
    openInstagram: ()->Unit
) {
    Box(
        modifier = modifier
            .navigationBarsPadding()
            .padding(bottom = 65.dp)
            .fillMaxWidth()
            .height(360.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable { openInstagram() }
    ) {
        Image(
            painter = painterResource(R.drawable.bottom_banner),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
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
fun GetPro() {
    Image(
        modifier = Modifier
            .statusBarsPadding()
            .padding(start = 20.dp, top = 10.dp)
            .width(89.dp)
            .height(26.dp),
        painter = painterResource(R.drawable.get_ultra),
        contentDescription = null,
    )
}

@Composable
fun DotsIndicator(
    modifier: Modifier = Modifier,
    currentPage: Int,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(2) {
            val isSelected = currentPage == it
            if (isSelected) {
                Image(
                    painter = painterResource(R.drawable.frame_1000005215),
                    contentDescription = null,
                    modifier = Modifier
                        .width(24.dp)
                        .height(4.dp)
                )
            } else {
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(4.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                )
            }
        }
    }
}

@Composable
fun AutoSlideBanner(
    uiState: HomeUiState
) {
    val pagerState = rememberPagerState(initialPage = 0) { NUMBER_OF_PAGES }

    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)
            val next = (pagerState.currentPage + 1) % NUMBER_OF_PAGES
            pagerState.animateScrollToPage(next)
        }
    }
    Column {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(420.dp)
        ) { page ->
            when (page) {
                0 -> {
                    SliderOne(
                        teamName = uiState.driverData?.driverName ?: "",
                        position = uiState.driverData?.position.toString(),
                        points = uiState.driverData?.points.toString(),
                        wins = uiState.driverData?.wins.toString()
                    )
                }

                1 -> {
                    SliderTwo()
                }
            }
        }

        VerticalSpacer(4)
        DotsIndicator(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            currentPage = pagerState.currentPage
        )
    }
}
