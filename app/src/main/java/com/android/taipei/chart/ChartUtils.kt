package com.android.taipei.chart

import androidx.compose.ui.graphics.Path

object ChartUtils {

    fun Path.bezierPointsTo(points: List<CBPointF>, direction: Direction) {
        if (points.size < 2) return

        when (direction) {
            Direction.Horizontal -> {
                for (i in 1 until points.size) {
                    val currentPoint = points[i]
                    val nextPoint = points[i - 1]
                    this.cubicTo(
                        (currentPoint.x + nextPoint.x) / 2,
                        nextPoint.y,
                        (currentPoint.x + nextPoint.x) / 2,
                        currentPoint.y,
                        currentPoint.x,
                        currentPoint.y
                    )
                }
            }
            Direction.Vertical -> {
                for (i in 1 until points.size) {
                    val currentPoint = points[i]
                    val nextPoint = points[i - 1]
                    this.cubicTo(
                        nextPoint.x,
                        (currentPoint.y + nextPoint.y) / 2,
                        currentPoint.x,
                        (currentPoint.y + nextPoint.y) / 2,
                        currentPoint.x,
                        currentPoint.y
                    )
                }
            }
        }
    }

    enum class Direction {
        Vertical, Horizontal
    }
}