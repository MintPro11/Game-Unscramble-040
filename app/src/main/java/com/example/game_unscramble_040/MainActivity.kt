package com.example.game_unscramble_040

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.game_unscramble_040.ui.theme.GamePage
import com.example.game_unscramble_040.ui.theme.GameUnscramble040Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameUnscramble040Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    /*
                    color = MaterialTheme.colors.background

                     */

                ) {
                        GamePage()
                }
            }
        }
    }
}
