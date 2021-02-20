package Contestador;
import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDateTime;

public class Contestador {
		private static final LocalDateTime FECHA_MAXIMA = LocalDateTime.of(2999, 12, 12, 12, 12);
		private static final LocalDateTime FECHA_MINIMA = LocalDateTime.of(1970, 12, 12, 12, 12);
	// Mensajes de error -->
		private static final String NO_MENSAJES = "No hay mensajes"; 
		private static final String CONTESTADOR_LLENO = "El buzón está lleno, borre algún mensaje"; 
		private static final String MENSAJE_NO_EXISTE = "El mensaje seleccionado no existe"; 
		private Mensaje mensaje1,mensaje2,mensaje3;
	// <--
	
	public Contestador() {
		super();
		this.mensaje1 = null;
		this.mensaje2 = null;
		this.mensaje3 = null;
	}
	
	public void borrarMensaje1() {
		this.mensaje1 = null;
	}
	
	public void borrarMensaje2() {
		this.mensaje2 = null;
	}
	
	public void borrarMensaje3() {
		this.mensaje3 = null;
	}
	
	public Mensaje getMensaje1() throws Exception{
		if (mensaje1 == null) {
			throw new Exception(MENSAJE_NO_EXISTE);
		}
		return mensaje1;
	}

	public Mensaje getMensaje2() throws Exception{
		if (mensaje2 == null) {
			throw new Exception(MENSAJE_NO_EXISTE);
		}
		return mensaje2;
	}

	public Mensaje getMensaje3() throws Exception{
		if (mensaje3 == null) {
			throw new Exception(MENSAJE_NO_EXISTE);
		}
		return mensaje3;
	}

	@Override
	public int hashCode() {
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
	public String toString() {
		return "Mensajes del contestador, mensaje1: " + mensaje1 + ", mensaje2: " + mensaje2 + ", mensaje3: " + mensaje3 + ".";
	}
	
	public int numeroDeMensajes() {
		Integer numeroMensajes = 0;
		if (mensaje1 != null) {
			numeroMensajes++;
		}
		if (mensaje2 != null) {
			numeroMensajes++;
		}
		if (mensaje3 != null) {
			numeroMensajes++;
		}
		return numeroMensajes;
	}
	
	public void borrarTodosLosMensajes() {
		this.mensaje1 = null;
		this.mensaje2 = null;
		this.mensaje3 = null;
	}  
	
	public Mensaje mensajeMasNuevo() throws Exception{
		Mensaje masnuevo = null;
		if (numeroDeMensajes() == 0) {
			throw new Exception(NO_MENSAJES);
		}
		if (mensaje1 != null && (masnuevo == null || mensaje1.getFecha().isAfter(FECHA_MINIMA))) {
			masnuevo = mensaje1;
		}
		if (mensaje2 != null && (masnuevo == null || mensaje2.getFecha().isAfter(FECHA_MINIMA))) {
			masnuevo = mensaje2;
		}
		if (mensaje3 != null && (masnuevo == null || mensaje3.getFecha().isAfter(FECHA_MINIMA))) {
			masnuevo = mensaje3;
		}
		return masnuevo;
	}
	public Mensaje mensajeMasViejo() throws Exception{
		Mensaje masviejo = null;
		if (numeroDeMensajes() == 0) {
			throw new Exception(NO_MENSAJES);
		}
			if (mensaje1 != null && (masviejo == null || mensaje1.getFecha().isAfter(FECHA_MAXIMA))) {
				masviejo = mensaje1;
			}
			if (mensaje2 != null && (masviejo == null || mensaje2.getFecha().isAfter(FECHA_MAXIMA))) {
				masviejo = mensaje2;
			}
			if (mensaje3 != null && (masviejo == null || mensaje3.getFecha().isAfter(FECHA_MAXIMA))) {
				masviejo = mensaje3;
			}
		return masviejo;
	}
	public int diasEntreMensajes() throws Exception {
		long numDias = DAYS.between(mensajeMasNuevo().getFecha(), mensajeMasNuevo().getFecha());
		return (int) numDias;
	}
	public void añadirMensaje(StringBuilder remitente, StringBuilder msg) throws Exception{
		if (this.numeroDeMensajes() == 3) {
			throw new Exception(CONTESTADOR_LLENO);
		}
		if (mensaje1 == null) {
			mensaje1 = new Mensaje(remitente, msg);
		}
		else if (mensaje2 == null) {
			mensaje2 = new Mensaje(remitente, msg);
		}
		else {
			mensaje3 = new Mensaje(remitente, msg);
		}
}
	public void anadirBorrando(StringBuilder remitente, StringBuilder msg) throws Exception{
		Mensaje masviejo = mensajeMasViejo();
		if (mensaje1.equals(masviejo)) {
			mensaje1 = new Mensaje(remitente, msg);
		}
		else if (mensaje2.equals(masviejo)) {
			mensaje2 = new Mensaje(remitente, msg);
		}
		else {
			mensaje3 = new Mensaje(remitente, msg);
		}
	}
}