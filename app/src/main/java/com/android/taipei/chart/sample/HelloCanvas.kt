package com.android.taipei.chart.sample

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HelloCanvas() {
    Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
        drawLine(
            color = Color.Red,
            start = Offset.Zero,
            end = Offset(size.width, size.height)
        )
    })
}

@Preview(showBackground = true)
@Composable
fun HelloCanvasPreview() {
    HelloCanvas()
}