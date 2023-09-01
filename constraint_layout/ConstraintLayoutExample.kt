package com.salmakhd.android.forpractice
/*
Topic of Investigation: ConstraintLayout in Jetpack Compose.
Why use it?
- It can help create complex layouts easier.
- can be used by developers that are already familiar with these layouts
 */
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

/*
Tip:
visualize constraints as you would see in traditional .xml files when
defining a constraint layout in Jetpack Compose
 */

@Preview
@Composable
fun ConstraintLayoutExample() {
    val constraint = ConstraintSet {
        val greenBox = createRefFor("greenBox")
        val redBox = createRefFor("redBox")

        val guideline = createGuidelineFromTop(0.5f)

        constrain(greenBox) {
            top.linkTo(guideline)
            start.linkTo(redBox.end)
            end.linkTo(parent.end)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

        constrain(redBox) {
            top.linkTo(guideline)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

        // when used, all other constraints will be ignored, uncomment to see the effect
        //createHorizontalChain(greenBox, redBox, chainStyle = ChainStyle.Spread)
    }

    ConstraintLayout(constraint, modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .background(Color.Green)
            .layoutId("greenBox")
        ) {
            Text(
                text = "Green Box",
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Box(modifier = Modifier
            .background(Color.Red)
            .layoutId("redBox")
        ) {
            Text(
                text = "Red Box",
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}