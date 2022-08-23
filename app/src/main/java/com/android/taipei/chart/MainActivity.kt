package com.android.taipei.chart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.taipei.chart.ui.theme.ComposeChartTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeChartTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
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

                    SampleChart(
                        modifier = Modifier
                            .height(300.dp)
                            .fillMaxWidth(),
                        lineDatas = listOf(lineData1, lineData2)
                    )
                }
            }
        }
    }
}
