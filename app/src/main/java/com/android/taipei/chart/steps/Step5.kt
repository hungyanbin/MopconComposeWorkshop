package com.android.taipei.chart.steps

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.taipei.chart.common.ChartUtils.bezierPointsTo
import com.android.taipei.chart.common.ChartUtils
import com.android.taipei.chart.common.DataPoint
import com.android.taipei.chart.common.LineData
import kotlin.random.Random

@Composable
fun Step5(modifier: Modifier, lineDatas: List<LineData>) {
    val padding = 16.dp
    val xLabelHeight = 40.dp

    Column(Modifier) {
        Surface(modifier) {
            Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
                val paddingPx = padding.toPx()
                val strokeWidth = 3.dp.toPx()
                val chartWidth = size.width - 2 * paddingPx
                val chartHeight = size.height - 2 * paddingPx

                translate(left = paddingPx, top = paddingPx) {
                    val xInterval = chartWidth / 10
                    drawDataWithBezier(lineDatas, xInterval, chartHeight)
                    drawLine(
                        color = Color.Black,
                        start = Offset(0f, 0f),
                        end = Offset(0f, chartHeight),
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


private fun DrawScope.drawDataWithBezier(
    lineDatas: List<LineData>,
    xInterval: Float,
    chartHeight: Float
) {
    lineDatas.forEach { lineData ->
        val path = Path()
        path.moveTo(0f, chartHeight)
        val points = lineData.points.mapIndexed { index, dataPoint ->
            val x = index * xInterval
            val y = chartHeight - (chartHeight / 100 * dataPoint.yLabel)
            Offset(x, y)
        }

        path.bezierPointsTo(points, ChartUtils.Direction.Horizontal)
        path.lineTo(xInterval* 10, chartHeight)

        drawPath(
            path = path,
            brush = Brush.horizontalGradient(listOf(lineData.color, lineData.color.copy(green = 1f))),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Step5Preview(){
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

    Step5(
        modifier = Modifier
            .height(300.dp)
            .fillMaxWidth(),
        lineDatas = listOf(lineData1, lineData2)
    )
}