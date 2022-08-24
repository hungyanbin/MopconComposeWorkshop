package com.android.taipei.chart.sample

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DrawPoints() {
    Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
        val points = listOf(
            Offset(0f, 0f),
            Offset(size.width / 2, size.height / 3),
            Offset(size.width / 3, size.height / 4 * 3),
            Offset(0f, 0f),
        )

        drawPoints(
            points = points,
            color = Color.Red,
            strokeWidth = 40f,
            pointMode = PointMode.Polygon,
        )
    })
}

@Composable
fun DrawPointsWithRoundStrokeCap() {
    Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
        val points = listOf(
            Offset(0f, 0f),
            Offset(size.width / 2, size.height / 3),
            Offset(size.width / 3, size.height / 4 * 3),
            Offset(0f, 0f),
        )

        drawPoints(
            points = points,
            color = Color.Red,
            strokeWidth = 40f,
            pointMode = PointMode.Polygon,
            cap = StrokeCap.Round
        )
    })
}

@Composable
fun DrawPointsWithPathEffect() {
    Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
        val points = listOf(
            Offset(0f, 0f),
            Offset(size.width / 2, size.height / 3),
            Offset(size.width / 3, size.height / 4 * 3),
            Offset(0f, 0f),
        )

        drawPoints(
            points = points,
            color = Color.Red,
            strokeWidth = 40f,
            pointMode = PointMode.Polygon,
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(40f, 10f), 0f),
        )
    })
}


@Preview(showBackground = true)
@Composable
fun DrawPointPreview() {
//    DrawPoints()
//    DrawPointsWithRoundStrokeCap()
    DrawPointsWithPathEffect()
}