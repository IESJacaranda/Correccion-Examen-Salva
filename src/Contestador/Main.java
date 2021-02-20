// Definimos el paquete
package Contestador;

// <<<<<<<<--------------------------------------------------- Librerías --------------------------------------------->>>>>>>>>>>

import java.util.Scanner;

public class Main {
	// Creamos el scanner y creamos un nuevo contestador
	private static Scanner UserInterface = new Scanner(System.in);
	private static Contestador Jacafit = new Contestador();
	
	// <<<<<<<<------------------------------------- Mensajes -------------------------------------------------------->>>>>>>>>>>
	private static final String MENSAJES = "\n 1.Mensaje 1" + "\n 2.Mensaje 2" + "\n 3.Mensaje 3";
	private static final String OIR_BORRAR =  "\n 1.Oir" + "\n 2.Borrar";
	private static final String OPT_INCORR = "Opción incorrecta";
	private static final String CONTESTADOR_FULL = "El contestador está lleno";
	private static final String IN_MSG = "Inserte nuevo mensaje: ";
	private static final String IN_USER = "Inserte usuario : ";
	private static final String MSG_APPEND = "¡Mensaje añadido!";
	private static final String ESTA_SEGURO = "¿Está seguro? (S/N) : ";
	private static final String SELECT = "Seleccione opción : ";
	private static final String SELECT_MSG = "Seleccione mensaje [1-3]: ";
	private static final String DELETING_MSG = "Borrando: ";
	
	// <<<<<<<<------------------------------------ Inicio de la aplicación ------------------------------------------>>>>>>>>>>>
	
	public static void main(String[] args) throws Exception{
		// Definimos dos variables las cuales almacenarán temporalmente las opciones elegidas por el usuario
		
		StringBuilder option = new StringBuilder(" ");
		StringBuilder option2 = new StringBuilder(" ");
		
		// Definimos un Bucle el cual mantendrá en ejecución nuestra aplicación hasta que el usuario desee salir
		
		while (!option.equals("exit")) {
			
			// Imprimimos el menú y el selector
			
			System.out.println(
					   "\n 1. Consultar número de mensajes"
					 + "\n 2. Consultar un mensaje"
					 + "\n 3. Añadir un nuevo mensaje"
					 + "\n 4. Añadir un nuevo mensaje borrando el más antiguo"
					 + "\n 5. Obtener el mensaje más antiguo"
					 + "\n 6. Obtener el mensaje más nuevo"
					 + "\n 7. Días entre el mensaje más nuevo y el más antiguo"
					 + "\n 8. Borrar todos los mensajes del Contestador"
					 + "\n 9. Salir");
			System.out.print("Indique opción >> ");
			
			// A partir de aquí entra en juego el usuario, debido a que pueden producirse excepciones abrimos un bloque try y catch para evitar que se finalize la aplicación
			
			try {
				// Escaneamos la elección del usuario
				
				option = new StringBuilder(UserInterface.nextLine());
				
				// Con un switch escaneamos la opción elegida por el usuario
				
				switch (option.toString()) {
					case "1":
						System.out.println("Hay un total de " + Jacafit.numeroDeMensajes() + " mensajes");
						break;
					case "2":
						System.out.println(MENSAJES);
						System.out.print(SELECT_MSG);
						option = new StringBuilder(UserInterface.nextLine());
						switch (option.toString()) {
							case "1":
								Jacafit.getMensaje1();
								option = oirHablarSelect();
								switch(option.toString()) {
									case "1":
										System.out.println(Jacafit.getMensaje1());
										break;
									case "2":
										System.out.println(DELETING_MSG + Jacafit.getMensaje1());
										Jacafit.borrarMensaje1();
										break;
									default:
										throw new Exception(OPT_INCORR);
								}
								break;
							case "2":
								Jacafit.getMensaje2();
								option = oirHablarSelect();
								switch(option.toString()) {
									case "1":
										System.out.println(Jacafit.getMensaje2());
										break;
									case "2":
										System.out.println(DELETING_MSG + Jacafit.getMensaje2());
										Jacafit.borrarMensaje2();
										break;
									default:
										throw new Exception(OPT_INCORR);
								}
								break;
							case "3":
								Jacafit.getMensaje2();
								option = oirHablarSelect();
								switch(option.toString()) {
									case "1":
										System.out.println(Jacafit.getMensaje3());
										break;
									case "2":
										System.out.println(DELETING_MSG + Jacafit.getMensaje3());
										Jacafit.borrarMensaje3();
										break;
									default:
										throw new Exception(OPT_INCORR);
								}
								break;
							default:
								throw new Exception(OPT_INCORR);
						}
						break;
					case "3":
						if (Jacafit.numeroDeMensajes() == 3) {
							throw new Exception(CONTESTADOR_FULL);
						}
						else {
							option = selectUser();
							option2 = selectMsg();
							Jacafit.añadirMensaje(option, option2);
							System.out.println(MSG_APPEND);
						}
						break;
					case "4":
						option = selectUser();
						option2 = selectMsg();
						Jacafit.anadirBorrando(option, option2);
						System.out.println(MSG_APPEND);
						break;
					case "5":
						System.out.println(Jacafit.mensajeMasViejo());
						break;
					case "6":
						System.out.println(Jacafit.mensajeMasNuevo());
						break;
					case "7":
						System.out.println("Ha pasado " + Jacafit.diasEntreMensajes() + " días entre el mensaje más nuevo y el más antiguo");
						break;
					case "8":
						Jacafit.borrarTodosLosMensajes();
						System.out.println("Todos los mensajes han sido borrados");
						break;
					case "9":
						salir();
					default:
						throw new Exception(OPT_INCORR);
				}
			}
			catch (Exception e) {
				System.out.println("Error: " + e);
			}
		}
	}
	
	
	// <<<<<<<<<<<<-------------------------------------------- Funciones ----------------------------------------------->>>>>>>
	
	private static StringBuilder oirHablarSelect() throws Exception {		// Devuelve la selección del usuario (Oir | Hablar) 
		System.out.println(OIR_BORRAR);
		System.out.print(SELECT);
		return new StringBuilder(UserInterface.nextLine());
	}
	
	private static StringBuilder selectUser() throws Exception {			// Devuelve el nombre de usuario que inserte el usuario
		System.out.print(IN_USER);
		return new StringBuilder(UserInterface.nextLine());
	}
	
	private static StringBuilder selectMsg() throws Exception {				// Devuelve el mensaje que inserte el usuario
		System.out.print(IN_MSG);
		return new StringBuilder(UserInterface.nextLine());
	}

	private static void salir() throws Exception {							// Función salir de la aplicación
		System.out.print(ESTA_SEGURO);
		StringBuilder option = new StringBuilder(UserInterface.nextLine());
		switch (option.toString().toUpperCase()) {
			case "S":
				option = new StringBuilder("exit");
				break;
			case "N":
				break;
			default:
				throw new Exception(OPT_INCORR);
		}
	}	
}
