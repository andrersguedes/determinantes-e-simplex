package br.edu.fatecgarca.determinantessimplex.calculos

import org.junit.Assert.assertEquals
import org.junit.Test

class CalculosTest {

    private val calculos = Calculos()

    @Test
    fun testEmptyMatrix() {
        assertEquals(0.0, calculos.determinant(arrayOf()), 1e-9)
    }

    @Test
    fun test1x1Matrix() {
        val mat = arrayOf(doubleArrayOf(5.0))
        assertEquals(5.0, calculos.determinant(mat), 1e-9)
    }

    @Test
    fun test2x2Matrix() {
        val mat = arrayOf(
            doubleArrayOf(1.0, 2.0),
            doubleArrayOf(3.0, 4.0)
        )
        assertEquals(-2.0, calculos.det2(mat), 1e-9)
        assertEquals(-2.0, calculos.determinant(mat), 1e-9)
    }

    @Test
    fun test3x3Matrix() {
        val mat = arrayOf(
            doubleArrayOf(1.0, 2.0, 3.0),
            doubleArrayOf(0.0, 1.0, 4.0),
            doubleArrayOf(5.0, 6.0, 0.0)
        )
        assertEquals(1.0, calculos.det3(mat), 1e-9)
        assertEquals(1.0, calculos.determinant(mat), 1e-9)
    }

    @Test
    fun test4x4Matrix() {
        val mat = arrayOf(
            doubleArrayOf(1.0, 0.0, 2.0, -1.0),
            doubleArrayOf(3.0, 0.0, 0.0, 5.0),
            doubleArrayOf(2.0, 1.0, 4.0, -3.0),
            doubleArrayOf(1.0, 0.0, 5.0, 0.0)
        )
        val res = calculos.det4(mat)
        assertEquals(res, calculos.determinant(mat), 1e-9)
    }

    @Test
    fun testSingularMatrix() {
        val mat = arrayOf(
            doubleArrayOf(1.0, 2.0),
            doubleArrayOf(2.0, 4.0)
        )
        assertEquals(0.0, calculos.determinant(mat), 1e-9)
    }

    @Test
    fun testPivotingMatrix() {
        val mat = arrayOf(
            doubleArrayOf(0.0, 1.0),
            doubleArrayOf(1.0, 0.0)
        )
        assertEquals(-1.0, calculos.determinant(mat), 1e-9)
    }

    @Test
    fun testZeroPivotBranch() {
        val mat = arrayOf(
            doubleArrayOf(1.0, 1.0, 1.0),
            doubleArrayOf(1.0, 1.0, 1.0),
            doubleArrayOf(2.0, 2.0, 2.0)
        )
        assertEquals(0.0, calculos.determinant(mat), 1e-9)

        val mat2 = arrayOf(
            doubleArrayOf(1.0, 1.0, 1.0),
            doubleArrayOf(2.0, 2.0, 3.0),
            doubleArrayOf(3.0, 3.0, 4.0)
        )
        assertEquals(0.0, calculos.determinant(mat2), 1e-9)
    }
}
