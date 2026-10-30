package br.edu.fatecgarca.determinantessimplex.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Functions
import androidx.compose.material.icons.filled.GridOn
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.edu.fatecgarca.determinantessimplex.R
import br.edu.fatecgarca.determinantessimplex.ui.theme.DeterminantesSimplexTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    onNavigateToDet2: () -> Unit,
    onNavigateToDet3: () -> Unit,
    onNavigateToDet4: () -> Unit,
    onNavigateToSimplex: () -> Unit
) {
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.app_name)) }
            )
        }
    ) { paddingValues ->
        if (isLandscape) {
            // 2x2 Grid without scrolling
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    CalculatorCard(
                        title = stringResource(R.string.det2),
                        description = stringResource(R.string.mat2x2),
                        icon = Icons.Default.GridOn,
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        onClick = onNavigateToDet2,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                    )
                    CalculatorCard(
                        title = stringResource(R.string.det3),
                        description = stringResource(R.string.mat3x3),
                        icon = Icons.Default.Calculate,
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        onClick = onNavigateToDet3,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    CalculatorCard(
                        title = stringResource(R.string.det4),
                        description = stringResource(R.string.mat4x4),
                        icon = Icons.Default.Functions,
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        onClick = onNavigateToDet4,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                    )
                    CalculatorCard(
                        title = stringResource(R.string.simplex),
                        description = stringResource(R.string.linear_programming),
                        icon = Icons.Default.Timeline,
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                        onClick = onNavigateToSimplex,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                    )
                }
            }
        } else {
            // Portrait: 4 rows without scrolling
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CalculatorCard(
                    title = stringResource(R.string.det2),
                    description = stringResource(R.string.det2_desc),
                    icon = Icons.Default.GridOn,
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    onClick = onNavigateToDet2,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
                CalculatorCard(
                    title = stringResource(R.string.det3),
                    description = stringResource(R.string.det3_desc),
                    icon = Icons.Default.Calculate,
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    onClick = onNavigateToDet3,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
                CalculatorCard(
                    title = stringResource(R.string.det4),
                    description = stringResource(R.string.det4_desc),
                    icon = Icons.Default.Functions,
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    onClick = onNavigateToDet4,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
                CalculatorCard(
                    title = stringResource(R.string.simplex_title),
                    description = stringResource(R.string.simplex_desc),
                    icon = Icons.Default.Timeline,
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    onClick = onNavigateToSimplex,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
            }
        }
    }
}

@Composable
fun CalculatorCard(
    title: String,
    description: String,
    icon: ImageVector,
    containerColor: androidx.compose.ui.graphics.Color,
    contentColor: androidx.compose.ui.graphics.Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = MaterialTheme.shapes.large
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Surface(
                shape = MaterialTheme.shapes.medium,
                color = contentColor.copy(alpha = 0.1f),
                modifier = Modifier.size(44.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = contentColor,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    DeterminantesSimplexTheme {
        MainScreen(
            onNavigateToDet2 = {},
            onNavigateToDet3 = {},
            onNavigateToDet4 = {},
            onNavigateToSimplex = {}
        )
    }
}
