package com.android.taipei.chart.sample

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DrawPath() {
    Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
        val path = Path()
        path.moveTo(center.x, center.y)
        path.lineTo(300f, 300f)
        path.lineTo(300f, center.y)
        path.lineTo(center.x, center.y)
        path.addOval(Rect(0f, 0f, 100f, 100f))
        path.addRect(Rect(100f, 100f, 200f, 200f))
        drawPath(
            path = path,
            color = Color.Cyan
        )
    })
}

@Preview(showBackground = true)
@Composable
fun DrawPathPreview() {
    DrawPath()
}