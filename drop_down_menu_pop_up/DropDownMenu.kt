package com.salmakhd.android.forpractice.DropDownMenu

/*
Topic of investigation: DropDownMenu pop up in Jetpack Compose
 */

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

data class DropDownItem (
    val text: String
)

/**
 * Long press to see effect
 */
@Composable
fun DropDownMenu(
    personName: String,
    dropDownItems: List<DropDownItem>,
    modifier: Modifier = Modifier,
    onItemClick: (DropDownItem) -> Unit
) {
    var isContextMenuVisible by rememberSaveable {
        mutableStateOf(false)
    }
    var pressOffset by remember {
        mutableStateOf(DpOffset.Zero)
    }
    var itemHeight by remember {
        mutableStateOf(0.dp)
    }

    val density = LocalDensity.current
    Card(
        elevation = 4.dp,
        modifier = modifier.onSizeChanged {
            itemHeight = with(density) { it.height.toDp()}
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .pointerInput(true) {
                    detectTapGestures(
                        onLongPress = {
                            isContextMenuVisible = true
                            pressOffset = DpOffset(
                                it.x.toDp(),
                                it.y.toDp()
                            )
                        }
                    )
                }
                .padding(16.dp)
        ) {
            Text(text = personName)
        }
        DropdownMenu(
            expanded = isContextMenuVisible,
            onDismissRequest = { isContextMenuVisible = false }
        ) {
            dropDownItems.forEach{item ->
                DropdownMenuItem(
                    onClick = {
                        onItemClick(item)
                        isContextMenuVisible = false
                    }
                ) {
                    Text(text = item.text)
                }
            }
        }
    }
}

@Preview
@Composable
fun DropDownMenuPreview() {
    DropDownMenu(personName = "Salma", dropDownItems = listOf(DropDownItem(text = "Salma"), DropDownItem(text = "Philippe")), onItemClick = {})
}