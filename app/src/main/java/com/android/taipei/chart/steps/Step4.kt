package com.android.taipei.chart.steps

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.taipei.chart.common.DataPoint
import com.android.taipei.chart.common.LineData
import kotlin.random.Random

@Composable
fun Step4(modifier: Modifier, lineDatas: List<LineData>) {
    val padding = 16.dp
    val xLabelHeight = 40.dp

    Column(Modifier) {
        Surface(modifier) {
            Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
                val paddingPx = padding.toPx()
                val strokeWidth = 3.dp.toPx()
                val chartWidth = size.width - 2 * paddingPx
                val chartHeight = size.height - 2 * paddingPx
                val xInterval = chartWidth / 10

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

                    drawDataWithPoints(lineDatas, xInterval, chartHeight, strokeWidth)
                }
            })
        }

        Row(
            modifier = Modifier
                .height(xLabelHeight)
                .padding(start = padding/2, end = padding/2)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (lineDatas.isNotEmpty()) {
                lineDatas[0].points.forEach { dataPoint ->
                    Text(text = dataPoint.xLabel, modifier = Modifier)
                }
            }
        }
    }
}

private fun DrawScope.drawDataWithPoints(
    lineDatas: List<LineData>,
    xInterval: Float,
    chartHeight: Float,
    strokeWidth: Float
) {
    lineDatas.forEach { lineData ->
        val points = lineData.points.mapIndexed { index, dataPoint ->
            val x = index * xInterval
            val y = chartHeight - (chartHeight / 100 * dataPoint.yLabel)
            Offset(x, y)
        }

        drawPoints(
            points = points,
            pointMode = PointMode.Polygon,
            strokeWidth = strokeWidth,
            color = lineData.color,
            cap = StrokeCap.Round
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Step4Preview() {
    val lineData1 = LineData(
        color = Color.Red,
        name = "Sample",
        points = (1..11).toList().map {
            val yLabel = Random.nextFloat() * 100
            DataPoint(it.toString(), yLabel = yLabel)
        }
    )
    val lineData2 = LineData(
        color = Color.Blue,
        name = "Sample2",
        points = (1..11).toList().map {
            val yLabel = Random.nextFloat() * 50
            DataPoint(it.toString(), yLabel = yLabel)
        }
    )

    Step4(
        modifier = Modifier
            .height(300.dp)
            .fillMaxWidth(),
        listOf(lineData1, lineData2)
    )
}