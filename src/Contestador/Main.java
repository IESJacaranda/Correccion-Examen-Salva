package Contestador;

import java.util.Scanner;

public class Main {
	private static Scanner UserInterface = new Scanner(System.in);
	private static Contestador Jacafit = new Contestador();

	public static void main(String[] args) throws Exception{
		String option = " ";
		while (option != "exit") {
			System.out.println(
					   "\n 1. Consultar número de mensajes"
					 + "\n 2. Consultar un mensaje"
					 + "\n 3. Añadir un nuevo mensaje"
					 + "\n 4. Añadir un nuevo mensaje borrando el más antiguo"
					 + "\n 5. Obtener el mensaje más antiguo"
					 + "\n 6. Obtener el mensaje más nuevo"
					 + "\n 7. Días entre dos mensajes"
					 + "\n 8. Borrar todos los mensajes del Contestador"
					 + "\n 9. Salir");
			System.out.print("Indique opción >> ");
			try {
				option = UserInterface.nextLine();
				switch (option) {
					case "1":
						System.out.println("Hay un total de " + Jacafit.numeroDeMensajes() + " mensajes");
						break;
					case "2":
						
						break;
					case "3":
						
						break;
					case "4":
						
						break;
					case "5":
						
						break;
					case "6":
						
						break;
					case "7":
						
						break;
					case "8":
						
						break;
					case "9":
						
						break;
				}
			}
			catch (Exception e) {
				System.out.println("Error: " + e);
			}
		}
	}

}
