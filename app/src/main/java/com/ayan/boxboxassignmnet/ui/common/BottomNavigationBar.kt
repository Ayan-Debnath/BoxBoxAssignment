package com.ayan.boxboxassignmnet.ui.common

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ayan.boxboxassignmnet.R
import com.ayan.boxboxassignmnet.ui.theme.BottomBarColor
import com.ayan.boxboxassignmnet.ui.theme.BottomBarDeSelectColor

data class BottomNavItem(
    @DrawableRes val icon: Int
)

@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier) {

    var selectedPos by remember { mutableStateOf(0) }

    val navigationItems = listOf(
        BottomNavItem(R.drawable.layers_behind),
        BottomNavItem(R.drawable.calendar_days),
        BottomNavItem(R.drawable.trophy),
        BottomNavItem(R.drawable.globus),
        BottomNavItem(R.drawable.profile),
    )

    Box(
        modifier = Modifier
            .navigationBarsPadding()
            .fillMaxWidth()
            .height(65.dp)
            .background(BottomBarColor)

    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            navigationItems.forEachIndexed { index, bottomNavItem ->
                val isSelected = selectedPos == index
                val bgColor by animateColorAsState(
                    targetValue = if (isSelected)
                        BottomBarDeSelectColor
                    else
                        Color.Transparent,
                    label = "bgAnim"
                )

                val iconTint by animateColorAsState(
                    targetValue = if (isSelected)
                        Color.White
                    else
                        BottomBarDeSelectColor,
                    label = "tintAnim"
                )
                Box(
                    modifier = Modifier
                        .width(65.dp)
                        .height(48.dp)
                        .clip(RoundedCornerShape(300.dp))
                        .background(bgColor)
                        .clickable { selectedPos = index },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = bottomNavItem.icon),
                        contentDescription = null,
                        modifier = Modifier.size(28.dp),
                        colorFilter = ColorFilter.tint(iconTint)
                    )
                }
            }
        }
    }

}