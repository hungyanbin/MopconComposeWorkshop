package com.android.taipei.chart.steps

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Step2(modifier: Modifier) {
    val padding = 16.dp

    Column(Modifier) {
        Surface(modifier) {
            Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
                val paddingPx = padding.toPx()
                val strokeWidth = 3.dp.toPx()
                val chartWidth = size.width - 2 * paddingPx
                val chartHeight = size.height - 2 * paddingPx

                translate(left = paddingPx, top = paddingPx) {
                    drawLine(
                        color = Color.Black,
                        start = Offset(0f, 0f),
                        end = Offset(0f, 0f + chartHeight),
                        strokeWidth = strokeWidth,
                    )

                    drawLine(
                        color = Color.Black,
                        start = Offset(0f, chartHeight),
                        end = Offset(chartWidth, chartHeight),
                        strokeWidth = strokeWidth,
                    )
                }
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Step2Preview() {
    Step2(
        modifier = Modifier
            .height(300.dp)
            .fillMaxWidth()
    )
}