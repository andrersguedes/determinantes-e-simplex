package br.edu.fatecgarca.determinantessimplex.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.edu.fatecgarca.determinantessimplex.calculos.Calculos
import br.edu.fatecgarca.determinantessimplex.ui.theme.DeterminantesSimplexTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MatrixCalculatorScreen(
    title: String,
    dimension: Int, // 2, 3, or 4
    onBack: () -> Unit
) {
    val context = LocalContext.current
    val matrixState = remember(dimension) {
        mutableStateOf(Array(dimension) { Array(dimension) { mutableStateOf("") } })
    }
    var resultText by remember { mutableStateOf<String?>(null) }
    val calculos = remember { Calculos() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(title) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Informe os valores da matriz",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )

            for (i in 0 until dimension) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    for (j in 0 until dimension) {
                        OutlinedTextField(
                            value = matrixState.value[i][j].value,
                            onValueChange = { matrixState.value[i][j].value = it },
                            label = { Text("a${i + 1}${j + 1}") },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            modifier = Modifier
                                .weight(1f)
                                .height(56.dp)
                        )
                    }
                }
            }

            Button(
                onClick = {
                    var isEmpty = false
                    for (i in 0 until dimension) {
                        for (j in 0 until dimension) {
                            if (matrixState.value[i][j].value.isEmpty()) {
                                isEmpty = true
                                break
                            }
                        }
                    }

                    if (isEmpty) {
                        Toast.makeText(context, "Digite todos os valores da matriz!", Toast.LENGTH_SHORT).show()
                    } else {
                        val doubleArray = Array(dimension) { i ->
                            DoubleArray(dimension) { j ->
                                matrixState.value[i][j].value.toDoubleOrNull() ?: 0.0
                            }
                        }
                        val res = when (dimension) {
                            2 -> calculos.det2(doubleArray)
                            3 -> calculos.det3(doubleArray)
                            4 -> calculos.det4(doubleArray)
                            else -> 0.0
                        }
                        resultText = res.toString()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                shape = MaterialTheme.shapes.medium
            ) {
                Text("Calcular", style = MaterialTheme.typography.titleMedium)
            }

            if (resultText != null) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Determinante:",
                            style = MaterialTheme.typography.titleSmall
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = resultText ?: "",
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MatrixCalculatorScreenPreview() {
    DeterminantesSimplexTheme {
        MatrixCalculatorScreen(
            title = "Determinante 3 x 3",
            dimension = 3,
            onBack = {}
        )
    }
}
