package br.edu.fatecgarca.determinantessimplex.calculos

import kotlin.math.abs

class Calculos {

    /**
     * Calculates the determinant of any N x N square matrix using Gaussian elimination with partial pivoting.
     */
    fun determinant(matrix: Array<DoubleArray>): Double {
        val n = matrix.size
        if (n == 0) return 0.0
        if (n == 1) return matrix[0][0]
        if (n == 2) return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0])

        // Deep copy of matrix to avoid mutating original input
        val mat = Array(n) { i -> matrix[i].clone() }
        var det = 1.0
        val eps = 1e-12

        for (i in 0 until n) {
            var pivot = i
            for (j in i + 1 until n) {
                if (abs(mat[j][i]) > abs(mat[pivot][i])) {
                    pivot = j
                }
            }

            if (abs(mat[pivot][i]) < eps) {
                return 0.0
            }

            if (pivot != i) {
                val temp = mat[i]
                mat[i] = mat[pivot]
                mat[pivot] = temp
                det = -det // Row swap negates determinant
            }

            det *= mat[i][i]

            for (j in i + 1 until n) {
                val factor = mat[j][i] / mat[i][i]
                for (k in i until n) {
                    mat[j][k] -= factor * mat[i][k]
                }
            }
        }

        return det
    }

    fun det2(matriz: Array<DoubleArray>): Double = determinant(matriz)

    fun det3(matriz: Array<DoubleArray>): Double = determinant(matriz)

    fun det4(v: Array<DoubleArray>): Double = determinant(v)
}
