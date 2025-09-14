package com.rocketseat.tabelanutricional.ui.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.rocketseat.tabelanutricional.R
import com.rocketseat.tabelanutricional.ui.theme.Background
import com.rocketseat.tabelanutricional.ui.theme.Secondary
import com.rocketseat.tabelanutricional.ui.theme.TabelaNutricionalTheme
import kotlinx.coroutines.delay

@Composable
fun LoveButton(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    onClick: (isSelected: Boolean) -> Unit
) {

    var isSelected by remember { mutableStateOf(isSelected) }
    var isPressed by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = isPressed) {
        if (isPressed) {
            delay(500)
            isPressed = false
        }
    }


    val color by animateColorAsState(
        targetValue = if (isSelected) Secondary else LocalContentColor.current,
    )

    val scale by animateFloatAsState(
        targetValue = if (isPressed) 1.2f else 1.0f,
        animationSpec = tween(durationMillis = 150)
    )

    IconButton(
        modifier = modifier,
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = Background,
            contentColor = color
        ),
        onClick = {
            isPressed = true
            isSelected = !isSelected
            onClick(isSelected)
        }
    ) {
        Icon(
            modifier = Modifier.scale(scale),
            painter = painterResource(id = if (isSelected) R.drawable.ic_heart else R.drawable.ic_heart_filled),
            contentDescription = stringResource(id = R.string.botao_coracao)
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun LoveButtonPreview() {
    TabelaNutricionalTheme {
        LoveButton {}
    }
}