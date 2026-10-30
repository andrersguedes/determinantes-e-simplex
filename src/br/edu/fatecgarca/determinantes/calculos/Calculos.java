package br.edu.fatecgarca.determinantes.calculos;

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
		
//		int l1 = 0, l2 = 0, l3 = 0, l4 = 0, li;
//		for (int i = 0; i < v.length; i++) {
//			for (int j = 0; j < v.length; j++) {
//				if (v[i][j] == 0) {
//					if (i == 0) {
//						l1++;
//					} else if (i == 1) {
//						l2++;
//					} else if (i == 2) {
//						l3++;
//					} else {
//						l4++;
//					}
//				}
//			}
//		}
//		
//		if((l1 > l2) && (l1 > l3) && (l1 > l4)){
//			li = l1;
//		}else if((l2 > l1) && (l2 > l3) && (l2 > l4)){
//			li = l2;
//		}else if((l3 > l2) && (l3 > l1) && (l3 > l4)){
//			li = l3;
//		}else
//			li = l4;
//		
//		return li;
		
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
