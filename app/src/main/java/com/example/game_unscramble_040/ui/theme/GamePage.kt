package com.example.game_unscramble_040.ui.theme

import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.game_unscramble_040.R

@Composable
fun GamePage(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        GameStatus()
        GameLayout()
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            OutlinedButton(
                onClick = { },
                modifier = androidx.compose.ui.Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Text(stringResource(R.string.skip))
            }

            Button(
                modifier = modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(start = 8.dp),
                onClick = { }
            ) {
                Text(stringResource(R.string.submit))
            }
        }
    }
}

@Composable
fun  GameStatus(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .size(48.dp),
    ) {
                Text(text = stringResource(R.string.word_count, 0),
                    fontSize = 18.sp,
                )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End),
            text = stringResource(R.string.score, 0),
            fontSize = 18.sp,
        )
    }
}

@Composable
fun GameLayout(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp),

        ) {
        Text(
            text = "scrambleun",
            fontSize = 45.sp,
            modifier = modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = stringResource(R.string.instructions),
            fontSize = 17.sp,
            modifier = androidx.compose.ui.Modifier.align(Alignment.CenterHorizontally)
        )
        OutlinedTextField(
            value = "",
            singleLine = true,
            modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
            onValueChange = { },
            label = { Text(stringResource(R.string.enter_your_word)) },
            isError = false,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { }
            ),
        )
    }
}

@Composable
private fun FinalScoreDialog(
    onPlayAgain: () -> Unit,
    modifier: Modifier = Modifier
) {
    val activity = (LocalContext.current as Activity)

    AlertDialog(
        onDismissRequest = {
        },
        title = { Text(stringResource(R.string.congratulations)) },
        text = { Text(stringResource(R.string.you_scored, 0)) },
        modifier = modifier,
        dismissButton = {
            TextButton(
                onClick = {
                    activity.finish()
                }
            ) {
                Text(text = stringResource(R.string.exit))
            }
        },
        confirmButton = {
            TextButton(
                onClick = onPlayAgain
            ) {
                Text(text = stringResource(R.string.play_again))
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GameUnscramble040Theme{
        GamePage()
    }
}