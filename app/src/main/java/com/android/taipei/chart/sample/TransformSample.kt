package com.android.taipei.chart.sample

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TransformSample() {
    Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
        rotate(degrees = 45f) {
            translate(left = size.width / 4, top = size.height / 4) {
                drawRect(
                    size = Size(width = size.width / 2, height = size.height / 2),
                    color = Color.Red
                )
            }
        }
    })
}

@Composable
fun WithTransformSample() {
    Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
        withTransform({
            rotate(degrees = 45f)
            translate(left = size.width / 4, top = size.height / 4)
        }) {
            drawRect(
                size = Size(width = size.width / 2, height = size.height / 2),
                color = Color.Red
            )
        }
    })
}

@Preview(showBackground = true)
@Composable
fun TransformSamplePreview() {
    TransformSample()
}