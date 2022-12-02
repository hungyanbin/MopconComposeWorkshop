package com.android.taipei.chart.steps

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Step1(modifier: Modifier) {
    val padding = 16.dp

    Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
        val paddingPx = padding.toPx()
        val strokeWidth = 3.dp.toPx()
        val chartWidth = size.width - 2 * paddingPx
        val chartHeight = size.height - 2 * paddingPx

        drawLine(
            color = Color.Black,
            start = Offset(paddingPx, paddingPx),
            end = Offset(paddingPx, paddingPx + chartHeight),
            strokeWidth = strokeWidth,
        )

        drawLine(
            color = Color.Black,
            start = Offset(paddingPx, paddingPx + chartHeight),
            end = Offset(paddingPx + chartWidth, paddingPx + chartHeight),
            strokeWidth = strokeWidth,
        )
    })
}

@Preview(showBackground = true)
@Composable
fun Step1Preview(){
    Step1(
        modifier = Modifier
            .height(300.dp)
            .fillMaxWidth()
    )
}