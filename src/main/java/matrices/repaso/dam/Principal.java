package matrices.repaso.dam;

import java.util.Scanner;

import clases.Funciones;

public class Principal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		byte nFilas = 0;
		byte nColumnas = 0;
		byte nMatrices = 0;
		boolean hayValorFilas = false;
		boolean hayValorColumnas = false;
		boolean hayValorMatriz = false;

		for (int i = 0; i < args.length; i++) {
			if (args[i].equalsIgnoreCase("-filas")) {
				nFilas = Byte.parseByte(args[i + 1]);
				hayValorFilas = true;
			} else if (args[i].equalsIgnoreCase("-columnas")) {
				nColumnas = Byte.parseByte(args[i + 1]);
				hayValorColumnas = true;
			} else if (args[i].equalsIgnoreCase("-matriz")) {
				nMatrices = Byte.parseByte(args[i + 1]);
				hayValorMatriz = true;
			}
		}

		while ((nFilas < 5 || nFilas > 10) && !hayValorFilas) {
			System.out.println("Dime un numero de filas para matriz");
			nFilas = Byte.parseByte(sc.nextLine());
			hayValorFilas=true;
		}

		while ((nColumnas < 5 || nColumnas > 10) && !hayValorColumnas) {

			System.out.println("Dime un numero de columnas para la matriz");
			nColumnas = Byte.parseByte(sc.nextLine());
			hayValorColumnas=true;
		}

		while (!hayValorMatriz) {
			System.out.println("Dime cuantas matrices quieres");
			nMatrices = Byte.parseByte(sc.nextLine());
			hayValorMatriz=true;
		}
		
		
		float[][] matriz = Funciones.generaMatrizFloat(nFilas, nColumnas);
		float[][] matrizMayor = new float[nFilas][nColumnas];

		byte sumatorio = Funciones.sumatoriaMasDeDos(matriz);

		for (byte i = 0; i < nMatrices; i++) {

			matriz = Funciones.generaMatrizFloat(nFilas, nColumnas);
			System.out.println(Funciones.sumatoriaMasDeDos(matriz));
			System.out.println(Funciones.imprimeMatriz(matriz));

			if (sumatorio > Funciones.sumatoriaMasDeDos(matrizMayor)) {
				matrizMayor = matriz;
			}
		}

		System.out.println("La matriz mayor es esta: \n\n" + Funciones.imprimeMatriz(matrizMayor));
		System.out.println(Funciones.sumatoriaAlrededor(matrizMayor, (byte) 2, (byte) 2));
	}
}
