package com.salmakhd.android.forpractice

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

/*
Important point to remember:
Any text that falls outside the withStyle() lambda block will
inherit the default style of the parent Text composable.
 */
@Composable
fun CustomText() {
    Text(
        text = buildAnnotatedString {
            withStyle(
                SpanStyle(
                    color = Color.Cyan,
                    fontSize = 10.sp
                )

            ) {
                append("Salma")
            }
            append(" Khodaei")
        },
        style = MaterialTheme.typography.body1.copy(color = Color.Blue)
    )
}

@Preview
@Composable
fun CustomTextPreview() {
    Surface {
        CustomText(
        )
    }
}