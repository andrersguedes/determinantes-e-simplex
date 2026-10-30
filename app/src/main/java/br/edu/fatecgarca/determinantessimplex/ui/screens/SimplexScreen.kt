package br.edu.fatecgarca.determinantessimplex.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.edu.fatecgarca.determinantessimplex.calculos.SimplexCalculos
import br.edu.fatecgarca.determinantessimplex.calculos.SimplexResult
import br.edu.fatecgarca.determinantessimplex.ui.theme.DeterminantesSimplexTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimplexScreen(
    onBack: () -> Unit
) {
    val context = LocalContext.current
    var c1 by remember { mutableStateOf("3") }
    var c2 by remember { mutableStateOf("5") }

    var a11 by remember { mutableStateOf("1") }
    var a12 by remember { mutableStateOf("2") }
    var b1 by remember { mutableStateOf("8") }

    var a21 by remember { mutableStateOf("3") }
    var a22 by remember { mutableStateOf("2") }
    var b2 by remember { mutableStateOf("12") }

    var result by remember { mutableStateOf<SimplexResult?>(null) }
    val solver = remember { SimplexCalculos() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Método Simplex") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
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
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Maximizar Z = c₁x₁ + c₂x₂",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = c1,
                    onValueChange = { c1 = it },
                    label = { Text("c₁") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.weight(1f)
                )
                OutlinedTextField(
                    value = c2,
                    onValueChange = { c2 = it },
                    label = { Text("c₂") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.weight(1f)
                )
            }

            Text(
                text = "Restrições (≤ RHS)",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )

            // Constraint 1
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                OutlinedTextField(
                    value = a11,
                    onValueChange = { a11 = it },
                    label = { Text("a₁₁") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.weight(1f)
                )
                OutlinedTextField(
                    value = a12,
                    onValueChange = { a12 = it },
                    label = { Text("a₁₂") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.weight(1f)
                )
                Text("≤", style = MaterialTheme.typography.titleMedium)
                OutlinedTextField(
                    value = b1,
                    onValueChange = { b1 = it },
                    label = { Text("b₁") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.weight(1f)
                )
            }

            // Constraint 2
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                OutlinedTextField(
                    value = a21,
                    onValueChange = { a21 = it },
                    label = { Text("a₂₁") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.weight(1f)
                )
                OutlinedTextField(
                    value = a22,
                    onValueChange = { a22 = it },
                    label = { Text("a₂₂") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.weight(1f)
                )
                Text("≤", style = MaterialTheme.typography.titleMedium)
                OutlinedTextField(
                    value = b2,
                    onValueChange = { b2 = it },
                    label = { Text("b₂") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.weight(1f)
                )
            }

            Button(
                onClick = {
                    val obj = doubleArrayOf(
                        c1.toDoubleOrNull() ?: 0.0,
                        c2.toDoubleOrNull() ?: 0.0
                    )
                    val constraints = arrayOf(
                        doubleArrayOf(
                            a11.toDoubleOrNull() ?: 0.0,
                            a12.toDoubleOrNull() ?: 0.0,
                            b1.toDoubleOrNull() ?: 0.0
                        ),
                        doubleArrayOf(
                            a21.toDoubleOrNull() ?: 0.0,
                            a22.toDoubleOrNull() ?: 0.0,
                            b2.toDoubleOrNull() ?: 0.0
                        )
                    )
                    result = solver.solveMaximization(obj, constraints)
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
                Text("Resolver Simplex", style = MaterialTheme.typography.titleMedium)
            }

            if (result != null) {
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
                            text = if (result!!.isOptimal) "Solução Ótima" else "Resultado",
                            style = MaterialTheme.typography.titleSmall
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Z (Max) = ${result!!.optimalValue}",
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            for ((varName, value) in result!!.variables) {
                                Text(text = "$varName = $value", style = MaterialTheme.typography.bodyMedium)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SimplexScreenPreview() {
    DeterminantesSimplexTheme {
        SimplexScreen(
            onBack = {}
        )
    }
}
