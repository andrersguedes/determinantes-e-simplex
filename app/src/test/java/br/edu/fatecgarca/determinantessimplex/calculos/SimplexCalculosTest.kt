package br.edu.fatecgarca.determinantessimplex.calculos

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class SimplexCalculosTest {

    private val solver = SimplexCalculos()

    @Test
    fun testMaximizationProblem() {
        val obj = doubleArrayOf(3.0, 5.0)
        val constraints = arrayOf(
            doubleArrayOf(1.0, 0.0, 4.0),
            doubleArrayOf(0.0, 2.0, 12.0),
            doubleArrayOf(3.0, 2.0, 18.0)
        )

        val result = solver.solveMaximization(obj, constraints)
        assertTrue(result.isOptimal)
        assertEquals(36.0, result.optimalValue, 1e-5)
        assertEquals(2.0, result.variables["x1"] ?: 0.0, 1e-5)
        assertEquals(6.0, result.variables["x2"] ?: 0.0, 1e-5)
    }

    @Test
    fun testUnboundedProblem() {
        val obj = doubleArrayOf(1.0, 1.0)
        val constraints = arrayOf(
            doubleArrayOf(-1.0, 1.0, 1.0)
        )
        val result = solver.solveMaximization(obj, constraints)
        assertTrue(result.steps.isNotEmpty())
    }
}
