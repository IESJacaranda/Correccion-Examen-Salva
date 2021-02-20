package Contestador;

import java.util.Scanner;

public class Main {
	private static Scanner UserInterface = new Scanner(System.in);
	private static Contestador Jacafit = new Contestador();
	// Mensajes de error y mensajes de opciones
	private static final String MENSAJES = "\n 1.Mensaje 1"
										+ "\n 2.Mensaje 2"
										+ "\n 3.Mensaje 3";
	private static final String OIR_BORRAR = "\n 1.Oir"
										  + "\n 2.Borrar";
	private static final String OPT_INCORR = "Opción incorrecta";
	private static final String CONTESTADOR_FULL = "El contestador está lleno";

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
						System.out.println(MENSAJES);
						System.out.println("Seleccione mensaje [1-3] >> ");
						option = UserInterface.nextLine();
						switch (option) {
							case "1":
								System.out.println(OIR_BORRAR);
								switch(option) {
								case "1":
									Jacafit.getMensaje1();
								case "2":
									Jacafit.borrarMensaje1();
								default:
									throw new Exception(OPT_INCORR);
								}
							case "2":
								System.out.println(OIR_BORRAR);
								switch(option) {
								case "1":
									Jacafit.getMensaje2();
								case "2":
									Jacafit.borrarMensaje2();
								default:
									throw new Exception(OPT_INCORR);
								}
							case "3":
								System.out.println(OIR_BORRAR);
								switch(option) {
								case "1":
									Jacafit.getMensaje3();
								case "2":
									Jacafit.borrarMensaje3();
								default:
									throw new Exception(OPT_INCORR);
								}
							default:
								throw new Exception(OPT_INCORR);
						}
					case "3":
						if (Jacafit.numeroDeMensajes() == 3) {
							throw new Exception(CONTESTADOR_FULL);
						}
						else {
							
						}
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
					default:
						throw new Exception(OPT_INCORR);
				}
			}
			catch (Exception e) {
				System.out.println("Error: " + e);
			}
		}
	}
}
