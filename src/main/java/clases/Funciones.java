package clases;

import java.util.Random;

public class Funciones {

	public static float[][] generaMatrizFloat(byte nFilas, byte nColumnas) {

		Random r = new Random();

		float[][] matriz = new float[nFilas][nColumnas];

		for (byte i = 0; i < matriz.length; i++) {
			for (byte j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = (float) r.nextInt(2);
			}
		}

		return matriz;

	}

	public static byte sumatoriaMasDeDos(float[][] matriz) {

		byte num = 0;
		byte cont = 0;
		for (byte i = 0; i < matriz.length; i++) {
			for (byte j = 0; j < matriz[i].length; j++) {
				num += matriz[i][j];
			}
			if (num > 2) {
				cont++;
			}
			num = 0;
		}

		return cont;
	}

	public static String imprimeMatriz(float[][] matriz) {

		String ret = "";

		for (byte i = 0; i < matriz.length; i++) {
			for (byte j = 0; j < matriz[i].length; j++) {
				ret += matriz[i][j] + "\t";
			}
			ret += "\n";
		}
		return ret;
	}

	public static float sumatoriaAlrededor(float[][] matriz, byte nFilas, byte nColumnas) {
		byte filaActual=(byte) (nFilas-1);
		byte columnaActual=(byte) (nColumnas-1);
		float sumatorio = matriz[filaActual - 1][columnaActual];
		
		/*float arriba = matriz[nFilas - 1][nColumnas];
		float abajo = matriz[nFilas + 1][nColumnas];
		float derecha = matriz[nFilas][nColumnas + 1];
		float izquierda = matriz[nFilas][nColumnas - 1];
		float diagonalDerechaArriba = matriz[nFilas - 1][nColumnas + 1];
		float diagonalDerechaAbajo = matriz[nFilas + 1][nColumnas + 1];
		float diagonalIzquierdaAbajo = matriz[nFilas + 1][nColumnas - 1];
		float diagonalIzquierdaArriba = matriz[nFilas - 1][nColumnas - 1];*/

        if (filaActual - 1 > 0) {
            sumatorio += matriz[filaActual - 1][columnaActual];
        }

        if (filaActual + 1 < matriz.length-1){
            sumatorio += matriz[filaActual + 1][columnaActual];
        }

        if (columnaActual + 1 < matriz[filaActual].length-1) {
            sumatorio += matriz[filaActual][columnaActual + 1];
        }

        if (columnaActual - 1 > 0) {
            sumatorio += matriz[filaActual][columnaActual - 1];
        }

        if (filaActual - 1 > 0 && columnaActual + 1 < matriz[filaActual].length-1) {
            sumatorio += matriz[filaActual - 1][columnaActual + 1];
        }

        if (filaActual - 1 > 0 && columnaActual - 1 > 0){
            sumatorio += matriz[filaActual - 1][columnaActual - 1];
        }

        if (filaActual + 1 < matriz.length-1 && columnaActual + 1 < matriz[filaActual].length-1) {
            sumatorio += matriz[filaActual + 1][columnaActual + 1];
        }

        if (filaActual + 1 < matriz.length-1 && columnaActual - 1 > 0){
            sumatorio += matriz[filaActual + 1][columnaActual - 1];
        }

        sumatorio += matriz[filaActual][columnaActual];
        return sumatorio;
	}

}
