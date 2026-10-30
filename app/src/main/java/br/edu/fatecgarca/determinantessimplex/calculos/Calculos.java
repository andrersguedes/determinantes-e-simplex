package br.edu.fatecgarca.determinantessimplex.calculos;

public class Calculos {

	public double det2(double[][] matriz) {
		return (matriz[0][0] * matriz[1][1]) - (matriz[0][1] * matriz[1][0]);
	}

	public double det3(double[][] matriz) {
		double v1 = 0, v2 = 0;
		v1 = (matriz[0][0] * matriz[1][1] * matriz[2][2])
				+ (matriz[0][1] * matriz[1][2] * matriz[2][0])
				+ (matriz[0][2] * matriz[1][0] * matriz[2][1]);

		v2 = (matriz[0][2] * matriz[1][1] * matriz[2][0])
				+ (matriz[0][0] * matriz[1][2] * matriz[2][1])
				+ (matriz[0][1] * matriz[1][0] * matriz[2][2]);

		return v1 - v2;
	}

	public double det4(double v[][]) {
		double d1, d2, d3, d4;

		d1 = ((v[1][1] * v[2][2] * v[3][3]) + (v[1][2] * v[2][3] * v[3][1]) + (v[1][3]
				* v[2][1] * v[3][2]))
				- ((v[1][3] * v[2][2] * v[3][1])
						+ (v[1][1] * v[2][3] * v[3][2]) + (v[1][2] * v[2][1] * v[3][3]));
		d2 = ((v[1][0] * v[2][2] * v[3][3]) + (v[1][2] * v[2][3] * v[3][0]) + (v[1][3]
				* v[2][0] * v[3][2]))
				- ((v[1][3] * v[2][2] * v[3][0])
						+ (v[1][0] * v[2][3] * v[3][2]) + (v[1][2] * v[2][0] * v[3][3]));
		d3 = ((v[1][0] * v[2][1] * v[3][3]) + (v[1][1] * v[2][3] * v[3][0]) + (v[1][3]
				* v[2][0] * v[3][1]))
				- ((v[1][3] * v[2][1] * v[3][0])
						+ (v[1][0] * v[2][3] * v[3][1]) + (v[1][1] * v[2][0] * v[3][3]));
		d4 = ((v[1][0] * v[2][1] * v[3][2]) + (v[1][1] * v[2][2] * v[3][0]) + (v[1][3]
				* v[2][0] * v[3][1]))
				- ((v[1][2] * v[2][1] * v[3][0])
						+ (v[1][0] * v[2][2] * v[3][1]) + (v[1][1] * v[2][0] * v[3][2]));

		return v[0][0] * Math.pow(-1, 2) * d1 + v[0][1] * Math.pow(-1, 3) * d2
				+ v[0][2] * Math.pow(-1, 4) * d3 + v[0][3] * Math.pow(-1, 5)
				* d4;
	}
}
