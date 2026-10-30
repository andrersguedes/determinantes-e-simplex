package br.edu.fatecgarca.determinantessimplex.calculos

import kotlin.math.pow

class Calculos {

    fun det2(matriz: Array<DoubleArray>): Double {
        return (matriz[0][0] * matriz[1][1]) - (matriz[0][1] * matriz[1][0])
    }

    fun det3(matriz: Array<DoubleArray>): Double {
        val v1 = (matriz[0][0] * matriz[1][1] * matriz[2][2]) +
                (matriz[0][1] * matriz[1][2] * matriz[2][0]) +
                (matriz[0][2] * matriz[1][0] * matriz[2][1])

        val v2 = (matriz[0][2] * matriz[1][1] * matriz[2][0]) +
                (matriz[0][0] * matriz[1][2] * matriz[2][1]) +
                (matriz[0][1] * matriz[1][0] * matriz[2][2])

        return v1 - v2
    }

    fun det4(v: Array<DoubleArray>): Double {
        val d1 = ((v[1][1] * v[2][2] * v[3][3]) + (v[1][2] * v[2][3] * v[3][1]) + (v[1][3] * v[2][1] * v[3][2])) -
                ((v[1][3] * v[2][2] * v[3][1]) + (v[1][1] * v[2][3] * v[3][2]) + (v[1][2] * v[2][1] * v[3][3]))
        val d2 = ((v[1][0] * v[2][2] * v[3][3]) + (v[1][2] * v[2][3] * v[3][0]) + (v[1][3] * v[2][0] * v[3][2])) -
                ((v[1][3] * v[2][2] * v[3][0]) + (v[1][0] * v[2][3] * v[3][2]) + (v[1][2] * v[2][0] * v[3][3]))
        val d3 = ((v[1][0] * v[2][1] * v[3][3]) + (v[1][1] * v[2][3] * v[3][0]) + (v[1][3] * v[2][0] * v[3][1])) -
                ((v[1][3] * v[2][1] * v[3][0]) + (v[1][0] * v[2][3] * v[3][1]) + (v[1][1] * v[2][0] * v[3][3]))
        val d4 = ((v[1][0] * v[2][1] * v[3][2]) + (v[1][1] * v[2][2] * v[3][0]) + (v[1][3] * v[2][0] * v[3][1])) -
                ((v[1][2] * v[2][1] * v[3][0]) + (v[1][0] * v[2][2] * v[3][1]) + (v[1][1] * v[2][0] * v[3][2]))

        return v[0][0] * (-1.0).pow(2.0) * d1 + v[0][1] * (-1.0).pow(3.0) * d2 +
                v[0][2] * (-1.0).pow(4.0) * d3 + v[0][3] * (-1.0).pow(5.0) * d4
    }
}
