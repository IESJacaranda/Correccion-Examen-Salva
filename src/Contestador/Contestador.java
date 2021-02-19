package Contestador;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class Contestador {
	
	// Mensajes de error -->
		private static final String NO_MENSAJES = "No hay mensajes"; 
		private static final String CONTESTADOR_LLENO = "El buzón está lleno, borre algún mensaje"; 
		private static final String MENSAJE_NO_EXISTE = "El mensaje seleccionado no existe"; 
	// <--
	private Mensaje mensajes[] = new Mensaje[3];
	
	public Contestador() {
		super();
		this.mensajes[1] = null;
		this.mensajes[2] = null;
		this.mensajes[3] = null;
	}
	
	public void borrarMensaje1() {
		this.mensajes[1] = null;
	}
	
	public void borrarMensaje2() {
		this.mensajes[2] = null;
	}
	
	public void borrarMensaje3() {
		this.mensajes[3] = null;
	}
	
	public Mensaje getMensaje1() throws Exception{
		if (mensajes[1] == null) {
			throw new Exception(MENSAJE_NO_EXISTE);
		}
		return mensajes[1];
	}

	public Mensaje getMensaje2() throws Exception{
		if (mensajes[2] == null) {
			throw new Exception(MENSAJE_NO_EXISTE);
		}
		return mensajes[2];
	}

	public Mensaje getMensaje3() throws Exception{
		if (mensajes[3] == null) {
			throw new Exception(MENSAJE_NO_EXISTE);
		}
		return mensajes[3];
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(mensajes);
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
		if (!Arrays.equals(mensajes, other.mensajes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mensajes del contestador, mensaje1: " + mensajes[1] + ", mensaje2: " + mensajes[2] + ", mensaje3: " + mensajes[3] + ".";
	}
	
	public int numeroDeMensajes() {
		Integer numeroMensajes = 0;
		for (Mensaje mens:mensajes) {
			if (mens != null) {
				numeroMensajes++;
			}
		}
		return numeroMensajes;
	}
	
	public void borrarTodosLosMensajes() {
		this.mensajes[1] = null;
		this.mensajes[2] = null;
		this.mensajes[3] = null;
	}  
	
	public Mensaje mensajeMasNuevo() throws Exception{
		Mensaje masnuevo = null;
		if (numeroDeMensajes() == 0) {
			throw new Exception(NO_MENSAJES);
		}
		for (Mensaje mens:mensajes) {
			if ((masnuevo == null || mens.getFecha().isAfter(mensajeMasNuevo().getFecha())) && mens != null) {
				masnuevo = mens;
			}
		}
		return masnuevo;
	}
	public Mensaje mensajeMasViejo() throws Exception{
		Mensaje masviejo = null;
		if (numeroDeMensajes() == 0) {
			throw new Exception(NO_MENSAJES);
		}
		for (Mensaje mens:mensajes) {
			if ((masviejo == null || mens.getFecha().isAfter(mensajeMasNuevo().getFecha())) && mens != null) {
				masviejo = mens;
			}
		}
		return masviejo;
	}
	public int diasEntreMensajes() throws Exception {
		long numDias;
		Mensaje mensajeMasNuevo = mensajeMasNuevo();
		Mensaje mensajeMasViejo = mensajeMasNuevo();
		numDias = ChronoUnit.DAYS.between(mensajeMasNuevo.getFecha(), mensajeMasViejo.getFecha());
		return (int) numDias;
	}
	public void añadirMensaje(StringBuilder remitente, StringBuilder msg) throws Exception{
		if (this.numeroDeMensajes() == 3) {
			throw new Exception(CONTESTADOR_LLENO);
		}
		for (Mensaje mens:mensajes) {
			if (mens == null) {
				mens = new Mensaje(remitente, msg);
			}
		}
}
	public void anadirBorrando(StringBuilder remitente, StringBuilder msg) throws Exception{
		Mensaje masviejo = mensajeMasViejo();
		for (Mensaje mens:mensajes) {
			if (mens.equals(masviejo)) {
				mens = new Mensaje(remitente, msg);
			}
		}
	}
}