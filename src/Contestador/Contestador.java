package Contestador;
import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDateTime;

public class Contestador {
		private static final LocalDateTime FECHA_MAXIMA = LocalDateTime.of(2999, 12, 12, 12, 12);		// Fecha para obtener el mensaje m�s antiguo 
		private static final LocalDateTime FECHA_MINIMA = LocalDateTime.of(1970, 12, 12, 12, 12);		// Fecha para obtener el mensaje m�s nuevo
		
	// <<<<<<<<<<<<<<<<<<-------------------------------- Mensajes de error --------------------------------------->>>>>>>>>>
		
		private static final String NO_MENSAJES = "No hay mensajes"; 
		private static final String CONTESTADOR_LLENO = "El buz�n est� lleno, borre alg�n mensaje"; 
		private static final String MENSAJE_NO_EXISTE = "El mensaje seleccionado no existe"; 
		
	// <<<<<<<<<<<<<<<<<<------------------------------------- Mensajes -------------------------------------------->>>>>>>>>>
		
		private Mensaje mensaje1,mensaje2,mensaje3;
	// <<<<<<<<<<<<<<<<<------------------------------------- M�todos ----------------------------------------------->>>>>>>>>>
	
	public Contestador() {									// Constructor : Establece todos los mensajes a null
		super();
		this.mensaje1 = null;
		this.mensaje2 = null;
		this.mensaje3 = null;
	}
	
	public void borrarMensaje1() {							// Borrar mensaje1 : Establece el mensaje 1 en null
		this.mensaje1 = null;
	}
	
	public void borrarMensaje2() {							// Borrar mensaje2 : Establece el mensaje 2 en null
		this.mensaje2 = null;
	}
	
	public void borrarMensaje3() {							// Borrar mensaje3 : Establece el mensaje 3 en null
		this.mensaje3 = null;
	}
	
	public Mensaje getMensaje1() throws Exception{			// Obtener mensaje1 : Obtiene el mensaje 1, si es null lanza una excepci�n
		if (mensaje1 == null) {
			throw new Exception(MENSAJE_NO_EXISTE);
		}
		return mensaje1;
	}

	public Mensaje getMensaje2() throws Exception{			// Obtener mensaje2 : Obtiene el mensaje 2, si es null lanza una excepci�n
		if (mensaje2 == null) {
			throw new Exception(MENSAJE_NO_EXISTE);
		}
		return mensaje2;
	}

	public Mensaje getMensaje3() throws Exception{			// Obtener mensaje3 : Obtiene el mensaje 3, si es null lanza una excepci�n
		if (mensaje3 == null) {
			throw new Exception(MENSAJE_NO_EXISTE);
		}
		return mensaje3;
	}

	@Override
	public int hashCode() {									// hashcode y equals
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mensaje1 == null) ? 0 : mensaje1.hashCode());
		result = prime * result + ((mensaje2 == null) ? 0 : mensaje2.hashCode());
		result = prime * result + ((mensaje3 == null) ? 0 : mensaje3.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contestador other = (Contestador) obj;
		if (mensaje1 == null) {
			if (other.mensaje1 != null)
				return false;
		} else if (!mensaje1.equals(other.mensaje1))
			return false;
		if (mensaje2 == null) {
			if (other.mensaje2 != null)
				return false;
		} else if (!mensaje2.equals(other.mensaje2))
			return false;
		if (mensaje3 == null) {
			if (other.mensaje3 != null)
				return false;
		} else if (!mensaje3.equals(other.mensaje3))
			return false;
		return true;
	}

	@Override
	public String toString() {									// ToString
		return "Mensajes del contestador, mensaje1: " + mensaje1 + ", mensaje2: " + mensaje2 + ", mensaje3: " + mensaje3 + ".";
	}
	
	public int numeroDeMensajes() {								// N�mero de mensajes
		Integer numeroMensajes = 0;									// Define un contador
		if (mensaje1 != null) {										// Si el mensaje 1 no es null incrementamos el contador
			numeroMensajes++;
		}
		if (mensaje2 != null) {										// Si el mensaje 2 no es null incrementamos el contador
			numeroMensajes++;
		}
		if (mensaje3 != null) {										// Si el mensaje 3 no es nul incrementamos el contador
			numeroMensajes++;
		}
		return numeroMensajes;										// Retornamos el valor del contador
	}
	
	public void borrarTodosLosMensajes() {						// Borrar todos los mensajes: Establece todos los mensajes a null
		this.mensaje1 = null;
		this.mensaje2 = null;
		this.mensaje3 = null;
	}  
	
	public Mensaje mensajeMasNuevo() throws Exception{			// Mensaje m�s nuevo
		Mensaje masnuevo = null;									// Crea un nuevo mensaje a nulo que almacenar� el mensaje m�s nuevo
		if (numeroDeMensajes() == 0) {								// Comprobamos si hay al menos un mensaje y en el caso de que no haya lanzamos excepci�n
			throw new Exception(NO_MENSAJES);
		}
		if (mensaje1 != null && (masnuevo == null || mensaje1.getFecha().isAfter(FECHA_MINIMA))) {		// Si el mensaje 1 no es nulo y (el mas nuevo es nulo o es m�s nuevo que el que tenemos almacenado) lo establecemos como mensaje m�s nuevo
			masnuevo = mensaje1;
		}
		if (mensaje2 != null && (masnuevo == null || mensaje2.getFecha().isAfter(FECHA_MINIMA))) {		// Si el mensaje 2 no es nulo y (el mas nuevo es nulo o es m�s nuevo que el que tenemos almacenado) lo establecemos como mensaje m�s nuevo
			masnuevo = mensaje2;
		}
		if (mensaje3 != null && (masnuevo == null || mensaje3.getFecha().isAfter(FECHA_MINIMA))) {		// Si el mensaje 3 no es nulo y (el mas nuevo es nulo o es m�s nuevo que el que tenemos almacenado) lo establecemos como mensaje m�s nuevo
			masnuevo = mensaje3;
		}
		return masnuevo;																				// Retornamos el mensaje m�s nuevo
	}
	public Mensaje mensajeMasViejo() throws Exception{									// Mensaje m�s viejo
		Mensaje masviejo = null;															// Creamos un nuevo mensaje a null que almacenar� el mensaje m�s viejo
		if (numeroDeMensajes() == 0) {														// Si el n�mero de mensajes en 0 lanzamos una excepci�n indicando que no hay mensajes
			throw new Exception(NO_MENSAJES);
		}
			if (mensaje1 != null && (masviejo == null || mensaje1.getFecha().isAfter(FECHA_MAXIMA))) {	// Si el mensaje 1 no es nulo y (el mas viejo es nulo o es m�s viejo que el que tenemos almacenado) lo establecemos como mensaje m�s viejo
				masviejo = mensaje1;
			}
			if (mensaje2 != null && (masviejo == null || mensaje2.getFecha().isAfter(FECHA_MAXIMA))) {	// Si el mensaje 2 no es nulo y (el mas viejo es nulo o es m�s viejo que el que tenemos almacenado) lo establecemos como mensaje m�s viejo
				masviejo = mensaje2;
			}
			if (mensaje3 != null && (masviejo == null || mensaje3.getFecha().isAfter(FECHA_MAXIMA))) {	// Si el mensaje 3 no es nulo y (el mas viejo es nulo o es m�s viejo que el que tenemos almacenado) lo establecemos como mensaje m�s viejo
				masviejo = mensaje3;														// Retornamos el mensaje m�s viejo
			}
		return masviejo;
	}
	public int diasEntreMensajes() throws Exception {											// D�as entre mensajes
		long numDias = DAYS.between(mensajeMasNuevo().getFecha(), mensajeMasNuevo().getFecha()); // Creamos una variable de tipo long la cual almacenar� los d�as entre las dos fechas, para obtener la fecha usamos la funcion DAYS.between a la cual le pasamos la fecha del mensaje mas nuevo y la fecha del mensaje m�s antiguo 
		return (int) numDias;																		// Retornamos el resultado como un entero
	}
	public void a�adirMensaje(StringBuilder remitente, StringBuilder msg) throws Exception{		// A�adir mensaje
		if (this.numeroDeMensajes() == 3) {															// Comprueba si el buzon est� lleno, en el caso de que s� lanzamos una excepci�n
			throw new Exception(CONTESTADOR_LLENO);
		}
		if (mensaje1 == null) {																	// Si el mensaje 1 es nulo lo guardamos ah�
			mensaje1 = new Mensaje(remitente, msg);
		}
		else if (mensaje2 == null) {															// Si no lo guardamos el mensaje2
			mensaje2 = new Mensaje(remitente, msg);
		}
		else {
			mensaje3 = new Mensaje(remitente, msg);												// Si no en mensaje3
		}
}
	public void anadirBorrando(StringBuilder remitente, StringBuilder msg) throws Exception{	// A�adir borrando
		try {																							// Intentamos a�adir el mensaje si hay hueco libre
			a�adirMensaje(remitente, msg);
		}
		catch(Exception e) {																			// Si no intentamos a�adir borrando
			Mensaje masviejo = mensajeMasViejo();														// Creamos un nuevo Mensaje el cual almacenar� el mensaje m�s viejo 
			if (mensaje1.equals(masviejo)) {															// Comprobamos si el mensaje1 es el m�s viejo y si es as� lo almacenamos
				mensaje1 = new Mensaje(remitente, msg);
			}
			else if (mensaje2.equals(masviejo)) {														// Comprobamos si el mensaje2 es el m�s viejo y si es as� lo almacenamos
				mensaje2 = new Mensaje(remitente, msg);
			}
			else {																						// Comprobamos si el mensaje3 es el m�s viejo y si es as� lo almacenamos
				mensaje3 = new Mensaje(remitente, msg);
			}
		}
	}
}