package com.android.taipei.chart.sample

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.taipei.chart.ui.theme.Brown
import com.android.taipei.chart.ui.theme.Orange

@Composable
fun Tree(modifier: Modifier) {
    Canvas(modifier = modifier, onDraw = {
        // 樹幹
        val topTranslate = 250.dp.toPx()
        withTransform({
            translate(size.width / 2, topTranslate)
        }, {
            drawTrunk(40, 200)
        })

        var topTreeTranslate = 100.dp.toPx()
        translate(
            size.width / 2,topTreeTranslate
        ) {
            drawTriangle(100)
        }

        topTreeTranslate = 150.dp.toPx()
        translate(
            size.width / 2,topTreeTranslate
        ) {
            drawTriangle(100)
        }

        topTreeTranslate = 200.dp.toPx()
        translate(
            size.width / 2,topTreeTranslate
        ) {
            drawTriangle(100)
        }
    })
}

private fun DrawScope.drawRibbon(width: Int, height: Int, strokeWidth: Int, color: Color) {
    val ribbonWidth = strokeWidth.dp.toPx()
    val rectWidth = width.dp.toPx()
    val rectHeight = height.dp.toPx()
    val ribbonPath = Path()
    ribbonPath.moveTo(-rectWidth/2, rectHeight)
    ribbonPath.quadraticBezierTo(
        x1 = 0f,
        y1 = 0f,
        x2 = rectWidth/2,
        y2 = rectHeight
    )
    ribbonPath.lineTo(rectWidth/2, rectHeight + ribbonWidth)
    ribbonPath.quadraticBezierTo(
        x1 = 0f,
        y1 = ribbonWidth,
        x2 = -rectWidth/2,
        y2 = rectHeight + ribbonWidth
    )
    ribbonPath.lineTo(-rectWidth/2, rectHeight)

    drawPath(
        path = ribbonPath,
        color = color
    )
}

private fun DrawScope.drawTriangle(width: Int) {
    val trianglePath = Path()
    trianglePath.lineTo(width.dp.toPx(), width.dp.toPx())
    trianglePath.lineTo(-width.dp.toPx(), width.dp.toPx())
    drawPath(
        path = trianglePath,
        color = Color.Green
    )
}

private fun DrawScope.drawStar(size: Int) {
    val starPath = Path()
    starPath.moveTo((size*-0.5f).dp.toPx(), (size*0.34f).dp.toPx())
    starPath.lineTo((size*0.5f).dp.toPx(), (size*0.34f).dp.toPx())
    starPath.lineTo((-size*0.32f).dp.toPx(), (size*0.95f).dp.toPx())
    starPath.lineTo(0f, 0f)
    starPath.lineTo((size*0.32f).dp.toPx(), (size*0.95f).dp.toPx())
    starPath.lineTo((size*-0.5f).dp.toPx(), (size*0.34f).dp.toPx())

    drawPath(
        path = starPath,
        color = Orange
    )
}

fun DrawScope.drawTrunk(width: Int, height: Int) {
    drawRect(
        color = Brown,
        topLeft = Offset(-(width/2).dp.toPx(), 0f),
        size = Size(width.dp.toPx(), height.dp.toPx())
    )
}

private fun DrawScope.drawPresent(size: Int, backgroundColor: Color, color: Color) {
    drawRect(
        color = backgroundColor,
        topLeft = Offset(-(size / 2).dp.toPx(), 0f),
        size = Size(size.dp.toPx(), size.dp.toPx())
    )
    // Vertical line
    drawRect(
        color = color,
        topLeft = Offset(-(size / 10).dp.toPx(), 0f),
        size = Size((size / 5).dp.toPx(), size.dp.toPx())
    )
    // Horizontal line
    drawRect(
        color = color,
        topLeft = Offset(-(size / 2).dp.toPx(), (size / 5 * 2).dp.toPx()),
        size = Size(size.dp.toPx(), (size / 5).dp.toPx())
    )
}

@Preview(showBackground = true)
@Composable
fun TreePreview() {
    Tree(modifier = Modifier.size(1000.dp, 1000.dp))
}