package com.android.taipei.chart.sample

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DrawCross() {
    Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
        drawLine(
            color = Color.Blue,
            start = Offset(center.x, 0f),
            end = Offset(center.x, size.height),
            strokeWidth = 33f
        )

        drawLine(
            color = Color.Blue,
            start = Offset(0f, center.y),
            end = Offset(size.width, center.y),
            strokeWidth = 33f
        )
    })
}

@Composable
fun DrawCrossWithDp() {
    val strokeWidth = 16.dp
    Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
        drawLine(
            color = Color.Blue,
            start = Offset(center.x, 0f),
            end = Offset(center.x, size.height),
            strokeWidth = strokeWidth.toPx()
        )

        drawLine(
            color = Color.Blue,
            start = Offset(0f, center.y),
            end = Offset(size.width, center.y),
            strokeWidth = strokeWidth.toPx()
        )
    })
}

@Preview(showBackground = true)
@Composable
fun DrawLinePreview() {
    DrawCross()
}