package com.example.pjsk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pjsk.data.pjskInfos
import com.example.pjsk.model.PJSKInfo
import com.example.pjsk.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PJSKApp(
                windowWidthSizeClass = calculateWindowSizeClass(this).widthSizeClass
            )
        }
    }
}

@Composable
fun PJSKApp(
    windowWidthSizeClass: WindowWidthSizeClass,
) {
    AppTheme(
        dynamicColor = false,
    ) {
        Scaffold(
            topBar = { PJSKAppBar() },
        ) { innerPadding ->
            Box(
                contentAlignment = Alignment.TopCenter,
                modifier = Modifier.fillMaxSize(),
            ) {
                PJSKCardList(
                    windowWidthSizeClass = windowWidthSizeClass,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PJSKAppPreview() {
    PJSKApp(
        windowWidthSizeClass = WindowWidthSizeClass.Compact
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PJSKAppBar() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineLarge,
            )
        },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun PJSKCard(
    day: Int,
    info: PJSKInfo,
    modifier: Modifier = Modifier,
) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card(
        modifier = modifier,
        onClick = { expanded = !expanded },
        colors = CardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            disabledContainerColor = CardDefaults.cardColors().disabledContainerColor,
            disabledContentColor = CardDefaults.cardColors().disabledContentColor,
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMediumLow,
                    )
                )
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            Text(
                text = "Day $day",
                style = MaterialTheme.typography.titleSmall,
            )
            Text(
                text = info.title,
                style = MaterialTheme.typography.titleLarge,
            )
            Text(
                text = info.character.chrName,
                style = MaterialTheme.typography.titleMedium,
            )
            Card(
                shape = RoundedCornerShape(16.dp)
            ) {
                Image(
                    painter = painterResource(info.drawable),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.height(240.dp)
                )
            }

            if (expanded) {
                Text(
                    text = info.dialogue,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth(),
                )
                Text(
                    text = info.skillName,
                    style = MaterialTheme.typography.labelLarge,
                )
                Text(
                    text = info.skillDescription.description,
                    style = MaterialTheme.typography.bodySmall,
                )
            }
        }
    }
}

@Composable
fun PJSKCardList(
    windowWidthSizeClass: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    val cardWidthFraction = if (windowWidthSizeClass == WindowWidthSizeClass.Compact) {
        1f
    } else {
        0.66f
    }

    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(pjskInfos) { info ->
            PJSKCard(
                day = pjskInfos.indexOf(info) + 1,
                info = info,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(cardWidthFraction)
            )
        }
    }
}
