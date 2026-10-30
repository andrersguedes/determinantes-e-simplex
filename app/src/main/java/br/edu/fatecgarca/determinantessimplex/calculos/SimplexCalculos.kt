package br.edu.fatecgarca.determinantessimplex.calculos

import kotlin.math.abs

data class SimplexResult(
    val optimalValue: Double,
    val variables: Map<String, Double>,
    val steps: List<String>,
    val isOptimal: Boolean
)

class SimplexCalculos {
    fun solveMaximization(
        objectiveCoefficients: DoubleArray,
        constraints: Array<DoubleArray>, // each row: [a_i1, a_i2, ..., rhs]
    ): SimplexResult {
        val numVars = objectiveCoefficients.size
        val numConstraints = constraints.size
        val totalCols = numVars + numConstraints + 1 // variables + slacks + RHS
        val totalRows = numConstraints + 1

        val tableau = Array(totalRows) { DoubleArray(totalCols) }
        val steps = mutableListOf<String>()

        steps.add("Initial Tableau created.")

        // Fill constraints
        for (i in 0 until numConstraints) {
            for (j in 0 until numVars) {
                tableau[i][j] = constraints[i][j]
            }
            // Slack variable
            tableau[i][numVars + i] = 1.0
            // RHS
            tableau[i][totalCols - 1] = constraints[i][numVars]
        }

        // Fill objective function row (last row)
        for (j in 0 until numVars) {
            tableau[numConstraints][j] = -objectiveCoefficients[j]
        }

        var iteration = 0
        val maxIterations = 50

        while (iteration < maxIterations) {
            iteration++
            // Find pivot column (most negative in objective row)
            var pivotCol = -1
            var minVal = 0.0
            for (j in 0 until totalCols - 1) {
                if (tableau[numConstraints][j] < minVal) {
                    minVal = tableau[numConstraints][j]
                    pivotCol = j
                }
            }

            if (pivotCol == -1 || minVal >= -1e-9) {
                steps.add("Optimal solution reached at iteration $iteration.")
                break
            }

            // Find pivot row using minimum ratio test
            var pivotRow = -1
            var minRatio = Double.MAX_VALUE
            for (i in 0 until numConstraints) {
                val rhs = tableau[i][totalCols - 1]
                val coeff = tableau[i][pivotCol]
                if (coeff > 1e-9) {
                    val ratio = rhs / coeff
                    if (ratio < minRatio) {
                        minRatio = ratio
                        pivotRow = i
                    }
                }
            }

            if (pivotRow == -1) {
                return SimplexResult(
                    optimalValue = 0.0,
                    variables = emptyMap(),
                    steps = steps + "Problem is unbounded.",
                    isOptimal = false
                )
            }

            steps.add("Iteration $iteration: Pivot Row = $pivotRow, Pivot Col = $pivotCol")

            // Pivot operation
            val pivotElement = tableau[pivotRow][pivotCol]
            for (j in 0 until totalCols) {
                tableau[pivotRow][j] /= pivotElement
            }

            for (i in 0 until totalRows) {
                if (i != pivotRow) {
                    val factor = tableau[i][pivotCol]
                    if (factor != 0.0) {
                        for (j in 0 until totalCols) {
                            tableau[i][j] -= factor * tableau[pivotRow][j]
                        }
                    }
                }
            }
        }

        val optimalValue = tableau[numConstraints][totalCols - 1]
        val variables = mutableMapOf<String, Double>()

        for (j in 0 until numVars) {
            var basicRow = -1
            var count = 0
            for (i in 0 until numConstraints) {
                if (abs(tableau[i][j] - 1.0) < 1e-9) {
                    basicRow = i
                    count++
                } else if (abs(tableau[i][j]) > 1e-9) {
                    count++
                }
            }
            if (count == 1 && basicRow != -1) {
                variables["x${j + 1}"] = tableau[basicRow][totalCols - 1]
            } else {
                variables["x${j + 1}"] = 0.0
            }
        }

        return SimplexResult(
            optimalValue = optimalValue,
            variables = variables,
            steps = steps,
            isOptimal = true
        )
    }
}
