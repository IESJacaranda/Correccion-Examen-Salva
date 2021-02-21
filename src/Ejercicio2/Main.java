
package Ejercicio2;

public class Main {

	public static void main(String[] args) {
		StringBuilder clave = new StringBuilder("b1o2m1e1r1a1n1g1");				// Clave a descomprimir
		StringBuilder clave2 = new StringBuilder("boomerang");						// Clave a comprimir
		System.out.println(descomprimirClave(clave));								// Prueba de descomprimir
		System.out.println(comprimirClave(clave2));									// Prueba de comprimir

	}
	private static StringBuilder comprimirClave(StringBuilder clave) {				// Función comprimir
		StringBuilder resultado = new StringBuilder("");								// Esta variable almacenará el resultado
		Character caracter;																// Esta almacenará un caracter de la clave
		Integer number;																	// Este contador contará cuantas veces se repite el caracter
		for (int i = 0; i < clave.length(); i++) {										// Recorremos la clave
			caracter = clave.charAt(i);													// Obtenemos el caracter según la posición que indique i 
			number = 1;																	// Establecemos el número de veces que aparece el caracter en 1
			for(int c = 0; (i + 1 != clave.length()) && clave.charAt(i+1) == caracter; c++) {	// Mientras que nos encontremos ese mismo caracter y la clave no termine vamos aumentando el número de veces que aparece ese caracter y la posición
				i++;
				number++;
			}
			resultado.append(caracter + String.valueOf(number));					// Una vez que termine añadimos al resultado el caracter y el número
		}
		return resultado;															// Devolvemos el resultado
	}
	private static StringBuilder descomprimirClave(StringBuilder clave) {				// Función descomprimir
		StringBuilder resultado = new StringBuilder("");									// Esta variable almacenará el resultado
		Character caracter = ' ';															// Esta variable almacenará temporalmente los carácteres de la clave
		for (int i = 0; i < clave.length(); i++) {											// Recorremos la clave
			if (Character.isLetter(clave.charAt(i))) {										// Si es un carácter lo agregamos a la variable caracter
				caracter = clave.charAt(i);
			}
			else {																					// Si no, estamos ante un número
				for (int c = 0; c < Integer.parseInt(String.valueOf(clave.charAt(i))); c++) {		// Añadimos al resultado tantas veces el caracter como indique el número
					resultado.append(caracter);
				}
			}
		}
		return resultado;																	// Retornamos el resultado
	}
}