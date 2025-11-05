package com.ayan.boxboxassignmnet.ui.screens.home

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
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ayan.boxboxassignmnet.R
import com.ayan.boxboxassignmnet.ui.common.HorizontalSpacer
import com.ayan.boxboxassignmnet.ui.common.VerticalSpacer
import com.ayan.boxboxassignmnet.ui.screens.HomeViewModel
import com.ayan.boxboxassignmnet.ui.screens.component.DistanceBox
import com.ayan.boxboxassignmnet.ui.screens.component.MediumBox
import com.ayan.boxboxassignmnet.ui.screens.component.SessionBox
import com.ayan.boxboxassignmnet.ui.screens.component.SliderOne
import com.ayan.boxboxassignmnet.ui.screens.component.SliderTwo
import com.ayan.boxboxassignmnet.ui.theme.HomeScreenBg
import kotlinx.coroutines.delay

const val NUMBER_OF_PAGES = 2

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
        MidComponent()
        BottomBanner(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        )
    }

}

@Composable
fun TopSlider() {
    Box {
        AutoSlideBanner()
        GetPro()
    }
}

@Composable
fun MidComponent() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        SessionBox(modifier = Modifier.weight(1f))
        HorizontalSpacer(8)
        Column {
            DistanceBox()
            VerticalSpacer(8)
            MediumBox()
        }
    }
}


@Composable
fun BottomBanner(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(360.dp)
            .clip(RoundedCornerShape(16.dp))
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
fun AutoSlideBanner(modifier: Modifier = Modifier) {
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
                    SliderOne()
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
