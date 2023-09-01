package com.salmakhd.android.forpractice

import android.view.Gravity
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.TextView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView

/*
Topic of investigation:
Using XML files within Jetpack Compose
 */
@Composable
@Preview
fun ComposeXML() {
    Column(modifier = Modifier.fillMaxSize()) {
        AndroidView(
            modifier = Modifier.fillMaxWidth(),
            factory = {
                TextView(it)
            }) { textView ->
            textView.apply {
                text = "Hello from Compose to XML"
                gravity = Gravity.CENTER
            }
        }

        AndroidView(
            modifier = Modifier.fillMaxWidth(),
            factory = {
                android.widget.Button(it)
            }) { btn ->
            btn.apply {
                text = "Some Button"
                layoutParams = LinearLayout.LayoutParams(
                    MATCH_PARENT, WRAP_CONTENT
                )
                setOnClickListener {

                }
            }
        }
    }
}