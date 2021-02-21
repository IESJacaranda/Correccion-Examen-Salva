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
		boolean exitApp = false;
		
		// Definimos un Bucle el cual mantendrá en ejecución nuestra aplicación hasta que el usuario desee salir
		
		while (!exitApp) {
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
					case "1":													// Total de mensajes
						System.out.println("Hay un total de " + Jacafit.numeroDeMensajes() + " mensajes");	// Llamamos al método numero de mensajes y obtenemos e imprimimos el número de mensajes
						break;
					case "2":													// Consultar mensaje
						System.out.println(MENSAJES);									// Imprimimos el menú mensajes
						System.out.print(SELECT_MSG);									// Mostramos el selector
						option = new StringBuilder(UserInterface.nextLine());			// Escaneamos la entrada del usuario
						switch (option.toString()) {									// Comprobamos que ha puesto el usuario
							case "1":												// En el caso de que sea 1
								Jacafit.getMensaje1();									// Llamamos al metodo get mensaje solo con el fin de que si este es null nos lance la excepción y no le muestre al usuario el menú oir / borrar
								option = oirHablarSelect();								// Llamamos a la función seleccionar oir o hablar 
								switch(option.toString()) {								// Verificamos que ha insertado el usuario
									case "1":												// En el caso de que haya seleccionado 1 imprimimos ahora si el mensaje
										System.out.println(Jacafit.getMensaje1());
										break;
									case "2":												// En el caso de que haya seleccionado 2 imprimimos el mensaje que se va a borrar y acto seguido lo borramos
										System.out.println(DELETING_MSG + Jacafit.getMensaje1());
										Jacafit.borrarMensaje1();
										break;
									default:												// En el caso de que se haya equivocado lanzamos una excepción
										throw new Exception(OPT_INCORR);
								}// Si ha seleccionado una opción no disponible lanzamos excepción
								break;
							case "2":												// En el caso de que sea 2
								Jacafit.getMensaje2();									// Llamamos al metodo get mensaje solo con el fin de que si este es null nos lance la excepción y no le muestre al usuario el menú oir / borrar
								option = oirHablarSelect();								// Llamamos a la función seleccionar oir / hablar
								switch(option.toString()) {								// Comprobamos que ha insertado el usuario
									case "1":												// En el caso de que sea 1
										System.out.println(Jacafit.getMensaje2());				// Imprimimos el mensaje
										break;
									case "2":
										System.out.println(DELETING_MSG + Jacafit.getMensaje2());	// Imprimimos y acto seguido lo borramos
										Jacafit.borrarMensaje2();
										break;
									default:													// Si ha seleccionado una opción incorrecta lanzamos excepción
										throw new Exception(OPT_INCORR);
								}
								break;
							case "3":												// En el caso de que sea 3
								Jacafit.getMensaje2();									// Llamamos al metodo get mensaje solo con el fin de que si este es null nos lance la excepción y no le muestre al usuario el menú oir / borrar
								option = oirHablarSelect();								// Llamamos a la función seleccionar oir / hablar
								switch(option.toString()) {							// Escaneamos la entrada del usuario
									case "1":											// Si ha seleccionado 1 imprimimos el mensaje
										System.out.println(Jacafit.getMensaje3());
										break;
									case "2":											// Si ha seleccionado 2 imprimimos el mensaje a borrar y lo borramos
										System.out.println(DELETING_MSG + Jacafit.getMensaje3());
										Jacafit.borrarMensaje3();
										break;
									default:											// Si ha seleccionado una opción no disponible lanzamos excepción
										throw new Exception(OPT_INCORR);
								}
								break;
							default:													// Si ha seleccionado una opción no disponible lanzamos excepción
								throw new Exception(OPT_INCORR);
						}
						break;
					case "3":											// Añadir mensaje
						if (Jacafit.numeroDeMensajes() == 3) {								// En el caso de que el contestador esté lleno nos lanzará un excepción indicandolo
							throw new Exception(CONTESTADOR_FULL);
						}
						else {
							option = selectUser();											// Llama a la función seleccionar usuario
							option2 = selectMsg();											// Llama a la función seleccionar mensaje 
							Jacafit.añadirMensaje(option, option2);							// Al metodo añadir le pasamos los datos anteriores
							System.out.println(MSG_APPEND);									// Indicamos que el mensaje se ha añadido con éxito
						}
						break;
					case "4":											// Añadir mensaje borrando
						option = selectUser();												// Llama a la función seleccionar usuari
						option2 = selectMsg();												// Llama a la función seleccionar mensaje
						Jacafit.anadirBorrando(option, option2);							// Al metodo añadirborrando le pasamos los datos anteriores
						System.out.println(MSG_APPEND);										// Indicamos que el mensaje se ha añadido con éxito
						break;
					case "5":											// Obtener el mensaje más antiguo
						System.out.println(Jacafit.mensajeMasViejo());						// Obtiene e imprime el mensaje más viejo
						break;
					case "6":											// Obtener el mensaje más nuevo
						System.out.println(Jacafit.mensajeMasNuevo());						// Obtiene e imprime el mensaje más nuevo
						break;
					case "7":											// Obtener el número de días entre mensaje nuevo y viejo
						System.out.println("Ha pasado " + Jacafit.diasEntreMensajes() + " días entre el mensaje más nuevo y el más antiguo");	// Imprime el número de días que ha pasado entre el mensaje más nuevo y el mensaje más antiguo
						break;
					case "8":											// Borrar todos los mensajes
						Jacafit.borrarTodosLosMensajes();									// Borra todos los mensajes
						System.out.println("Todos los mensajes han sido borrados");			// Indicamos que se han borrado todos los mensajes
						break;
					case "9":											// Salir
						exitApp = salir();															// Llama a la función salir
						break;
					default:											// Error
						throw new Exception(OPT_INCORR);									// En el caso de que elija una opción incorrecta se mostrará el mensaje de opción incorrecta
				}
			}
			catch (Exception e) {															// En el caso de que haya un excepción se imprimirá por pantalla el texto Error: seguido del error producido
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

	private static boolean salir() throws Exception {							// Función salir de la aplicación
		System.out.print(ESTA_SEGURO);
		String selection = UserInterface.nextLine().toUpperCase();
		switch (selection) {
			case "S":
				return true;
			case "N":
				return false;
			default:
				throw new Exception(OPT_INCORR);
		}
	}	
}
