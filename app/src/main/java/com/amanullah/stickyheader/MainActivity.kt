package com.amanullah.stickyheader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.amanullah.stickyheader.ui.theme.StickyHeaderTheme

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StickyHeaderTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                    val sections = listOf("A", "B", "C", "D", "E")

                    LazyColumn(
                        contentPadding = PaddingValues(all = 12.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ){
                        sections.forEach { section ->
                            stickyHeader {
                                Text(
                                    modifier = androidx.compose.ui.Modifier
                                        .fillMaxWidth()
                                        .background(Color.Black)
                                        .padding(12.dp),
                                    text = "Section $section",
                                    color = Color.White,
                                    fontSize = MaterialTheme.typography.h4.fontSize,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            items(10)
                            {
                                Text(
                                    modifier = androidx.compose.ui.Modifier
                                        .padding(12.dp),
                                    text = "Item $it from the Section $section"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}