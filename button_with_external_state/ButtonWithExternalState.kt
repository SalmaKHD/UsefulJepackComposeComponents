package com.salmakhd.android.forpractice

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ButtonWithExternalState(
    state: MutableState<Boolean>,
    onButtonClick :() -> Unit
) {
    val shouldShowButton by remember { state }
    // every time there is a change to the value of state outside the composable
    // a recomposition will occur and the object will be remembered by the composable

    Column(modifier=  Modifier.fillMaxSize()) {
        Button(
            onClick = {onButtonClick()}
        ) {
            Text(
                text = "Click!")
        }

        if(state.value) {
            Text(
                text="I'm visible!"
            )
        }
    }
}

var buttonState = mutableStateOf( true)
@Preview
@Composable
fun ButtonWithExternalStatePreview() {
    ButtonWithExternalState(state = buttonState) {
        buttonState.value = !buttonState.value
    }
}