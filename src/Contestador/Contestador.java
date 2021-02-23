package Contestador;
import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDateTime;

public class Contestador {
		private static final LocalDateTime FECHA_MAXIMA = LocalDateTime.of(2999, 12, 12, 12, 12);		// Fecha para obtener el mensaje más antiguo 
		private static final LocalDateTime FECHA_MINIMA = LocalDateTime.of(1970, 12, 12, 12, 12);		// Fecha para obtener el mensaje más nuevo
		
	// <<<<<<<<<<<<<<<<<<-------------------------------- Mensajes de error --------------------------------------->>>>>>>>>>
		
		private static final String NO_MENSAJES = "No hay mensajes"; 
		private static final String CONTESTADOR_LLENO = "El buzón está lleno, borre algún mensaje"; 
		private static final String MENSAJE_NO_EXISTE = "El mensaje seleccionado no existe"; 
		
	// <<<<<<<<<<<<<<<<<<------------------------------------- Mensajes -------------------------------------------->>>>>>>>>>
		
		private Mensaje mensaje1,mensaje2,mensaje3;
	// <<<<<<<<<<<<<<<<<------------------------------------- Métodos ----------------------------------------------->>>>>>>>>>
	
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
	
	public Mensaje getMensaje1() throws Exception{			// Obtener mensaje1 : Obtiene el mensaje 1, si es null lanza una excepción
		if (mensaje1 == null) {
			throw new Exception(MENSAJE_NO_EXISTE);
		}
		return mensaje1;
	}

	public Mensaje getMensaje2() throws Exception{			// Obtener mensaje2 : Obtiene el mensaje 2, si es null lanza una excepción
		if (mensaje2 == null) {
			throw new Exception(MENSAJE_NO_EXISTE);
		}
		return mensaje2;
	}

	public Mensaje getMensaje3() throws Exception{			// Obtener mensaje3 : Obtiene el mensaje 3, si es null lanza una excepción
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
	
	public int numeroDeMensajes() {								// Número de mensajes
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
	
	public Mensaje mensajeMasNuevo() throws Exception{			// Mensaje más nuevo
		Mensaje masnuevo = null;									// Crea un nuevo mensaje a nulo que almacenará el mensaje más nuevo
		if (numeroDeMensajes() == 0) {								// Comprobamos si hay al menos un mensaje y en el caso de que no haya lanzamos excepción
			throw new Exception(NO_MENSAJES);
		}
		if (mensaje1 != null && (masnuevo == null || mensaje1.getFecha().isAfter(FECHA_MINIMA))) {		// Si el mensaje 1 no es nulo y (el mas nuevo es nulo o es más nuevo que el que tenemos almacenado) lo establecemos como mensaje más nuevo
			masnuevo = mensaje1;
		}
		if (mensaje2 != null && (masnuevo == null || mensaje2.getFecha().isAfter(FECHA_MINIMA))) {		// Si el mensaje 2 no es nulo y (el mas nuevo es nulo o es más nuevo que el que tenemos almacenado) lo establecemos como mensaje más nuevo
			masnuevo = mensaje2;
		}
		if (mensaje3 != null && (masnuevo == null || mensaje3.getFecha().isAfter(FECHA_MINIMA))) {		// Si el mensaje 3 no es nulo y (el mas nuevo es nulo o es más nuevo que el que tenemos almacenado) lo establecemos como mensaje más nuevo
			masnuevo = mensaje3;
		}
		return masnuevo;																				// Retornamos el mensaje más nuevo
	}
	public Mensaje mensajeMasViejo() throws Exception{									// Mensaje más viejo
		Mensaje masviejo = null;															// Creamos un nuevo mensaje a null que almacenará el mensaje más viejo
		if (numeroDeMensajes() == 0) {														// Si el número de mensajes en 0 lanzamos una excepción indicando que no hay mensajes
			throw new Exception(NO_MENSAJES);
		}
			if (mensaje1 != null && (masviejo == null || mensaje1.getFecha().isAfter(FECHA_MAXIMA))) {	// Si el mensaje 1 no es nulo y (el mas viejo es nulo o es más viejo que el que tenemos almacenado) lo establecemos como mensaje más viejo
				masviejo = mensaje1;
			}
			if (mensaje2 != null && (masviejo == null || mensaje2.getFecha().isAfter(FECHA_MAXIMA))) {	// Si el mensaje 2 no es nulo y (el mas viejo es nulo o es más viejo que el que tenemos almacenado) lo establecemos como mensaje más viejo
				masviejo = mensaje2;
			}
			if (mensaje3 != null && (masviejo == null || mensaje3.getFecha().isAfter(FECHA_MAXIMA))) {	// Si el mensaje 3 no es nulo y (el mas viejo es nulo o es más viejo que el que tenemos almacenado) lo establecemos como mensaje más viejo
				masviejo = mensaje3;														// Retornamos el mensaje más viejo
			}
		return masviejo;
	}
	public int diasEntreMensajes() throws Exception {											// Días entre mensajes
		long numDias = DAYS.between(mensajeMasNuevo().getFecha(), mensajeMasNuevo().getFecha()); // Creamos una variable de tipo long la cual almacenará los días entre las dos fechas, para obtener la fecha usamos la funcion DAYS.between a la cual le pasamos la fecha del mensaje mas nuevo y la fecha del mensaje más antiguo 
		return (int) numDias;																		// Retornamos el resultado como un entero
	}
	public void añadirMensaje(StringBuilder remitente, StringBuilder msg) throws Exception{		// Añadir mensaje
		if (this.numeroDeMensajes() == 3) {															// Comprueba si el buzon está lleno, en el caso de que sí lanzamos una excepción
			throw new Exception(CONTESTADOR_LLENO);
		}
		if (mensaje1 == null) {																	// Si el mensaje 1 es nulo lo guardamos ahí
			mensaje1 = new Mensaje(remitente, msg);
		}
		else if (mensaje2 == null) {															// Si no lo guardamos el mensaje2
			mensaje2 = new Mensaje(remitente, msg);
		}
		else {
			mensaje3 = new Mensaje(remitente, msg);												// Si no en mensaje3
		}
}
	public void anadirBorrando(StringBuilder remitente, StringBuilder msg) throws Exception{	// Añadir borrando
		try {																							// Intentamos añadir el mensaje si hay hueco libre
			añadirMensaje(remitente, msg);
		}
		catch(Exception e) {																			// Si no intentamos añadir borrando
			Mensaje masviejo = mensajeMasViejo();														// Creamos un nuevo Mensaje el cual almacenará el mensaje más viejo 
			if (mensaje1.equals(masviejo)) {															// Comprobamos si el mensaje1 es el más viejo y si es así lo almacenamos
				mensaje1 = new Mensaje(remitente, msg);
			}
			else if (mensaje2.equals(masviejo)) {														// Comprobamos si el mensaje2 es el más viejo y si es así lo almacenamos
				mensaje2 = new Mensaje(remitente, msg);
			}
			else {																						// Comprobamos si el mensaje3 es el más viejo y si es así lo almacenamos
				mensaje3 = new Mensaje(remitente, msg);
			}
		}
	}
}