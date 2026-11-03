package br.edu.fatecgarca.determinantessimplex.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.edu.fatecgarca.determinantessimplex.R
import br.edu.fatecgarca.determinantessimplex.ui.theme.DeterminantesSimplexTheme

enum class MethodType {
    DET_2X2, DET_3X3, DET_4X4, SIMPLEX
}

@Composable
fun TheoryExplanationDialog(
    methodType: MethodType,
    onDismiss: () -> Unit
) {
    val (title, theory, example) = when (methodType) {
        MethodType.DET_2X2 -> Triple(
            stringResource(R.string.theory_det2_title),
            stringResource(R.string.theory_det2_text),
            stringResource(R.string.example_det2_text)
        )
        MethodType.DET_3X3 -> Triple(
            stringResource(R.string.theory_det3_title),
            stringResource(R.string.theory_det3_text),
            stringResource(R.string.example_det3_text)
        )
        MethodType.DET_4X4 -> Triple(
            stringResource(R.string.theory_det4_title),
            stringResource(R.string.theory_det4_text),
            stringResource(R.string.example_det4_text)
        )
        MethodType.SIMPLEX -> Triple(
            stringResource(R.string.theory_simplex_title),
            stringResource(R.string.theory_simplex_text),
            stringResource(R.string.example_simplex_text)
        )
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(title, style = MaterialTheme.typography.titleLarge)
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = stringResource(R.string.theory_section_header),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = theory,
                    style = MaterialTheme.typography.bodyMedium
                )
                HorizontalDivider()
                Text(
                    text = stringResource(R.string.example_section_header),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = example,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(stringResource(R.string.understand_button))
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TheoryExplanationDialogPreview() {
    DeterminantesSimplexTheme {
        TheoryExplanationDialog(MethodType.SIMPLEX) { }
    }
}