package com.android.taipei.chart.sample

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DrawCircle() {
    Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
        drawCircle(
            color = Color.Blue,
            radius = 100.dp.toPx()
        )
    })
}

@Composable
fun DrawCircleWithBrush() {
    Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
        drawCircle(
            brush = Brush.linearGradient(listOf(Color.Red, Color.Cyan))
        )
    })
}

@Composable
fun DrawCircleWithNoBlendMode() {
    Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
        drawCircle(
            center = Offset(size.width / 3, size.height / 3),
            color = Color.Red
        )
        drawCircle(
            center = Offset(size.width / 3 * 2, size.height / 3 * 2),
            color = Color.Blue
        )
    })
}

@Composable
fun DrawCircleWithBlendMode() {
    Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
        drawCircle(
            center = Offset(size.width / 3, size.height / 3),
            color = Color.Red
        )
        drawCircle(
            center = Offset(size.width / 3 * 2, size.height / 3 * 2),
            color = Color.Blue,
            blendMode = BlendMode.Plus
        )
    })
}

@Preview(showBackground = true)
@Composable
fun DrawCirclePreview() {
//    DrawCircle()
//    DrawCircleWithBrush()
//    DrawCircleWithNoBlendMode()
//    DrawCircleWithBlendMode()
}