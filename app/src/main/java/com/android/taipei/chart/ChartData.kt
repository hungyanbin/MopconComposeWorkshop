package com.android.taipei.chart

import androidx.compose.ui.graphics.Color

data class DataPoint(
    val xLabel: String,
    val yLabel: Float
)

data class LineData(
    val color: Color,
    val name: String,
    val points: List<DataPoint>,
)