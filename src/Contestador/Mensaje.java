package Contestador;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mensaje {

	public static Integer nextCode = 1;											// Esta variable almacenará el siguiente código a establecer para que no haya mensajes con códigos repetidos
	private StringBuilder remitente;											// Esta variable almacenará el remitente
	private StringBuilder msg;													// Esta variable almacenará el mensaje
	private LocalDateTime fecha;												// Esta variable almacenará la fecha del mensaje
	private Integer codigo;														// Esta variable almacenará el código proporcionado al mensaje

    private static final DateTimeFormatter FORMATO_HORAS_Y_MINUTOS= DateTimeFormatter.ofPattern("hh-mm");	// Definimos el formato hora para la fecha
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd-MM-yyyy");		// Definimos el formato fecha para la fecha
    
	public Mensaje(StringBuilder remitente, StringBuilder msg) {				// Constructor de mensaje
		super();
		this.remitente = remitente;												// Establecemos el remitente que nos pasen como argumento
		this.msg = msg;															// Establecemos el mensaje que nos pasen como argumento
		this.fecha = LocalDateTime.now();										// Establecemos la fecha actual sel sistema
		this.codigo = nextCode;													// Establecemos como código el código siguiente
		nextCode++;																// Incrementamos el código para que el siguiente mensaje que se construya no tenga el mismo código
	}

	public StringBuilder getRemitente() {										// Obtiene el remitente
		return remitente;
	}

	public StringBuilder getMsg() {												// Obtiene el mensaje
		return msg;
	}

	public LocalDateTime getFecha() {											// Obtiene la fecha del sistema
		return fecha;
	}

	public int getCodigo() {													// Obtiene el código del mensaje
		return codigo;
	}

	@Override
	public int hashCode() {														// Hashcode y equals
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Mensaje other = (Mensaje) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {													// ToString
		return "El " + fecha.format(FORMATO_FECHA) +  " a las " + fecha.format(FORMATO_HORAS_Y_MINUTOS) + " el usuario " + remitente + " dejó el mensaje: ' " + msg + " ' con código de mensaje " + codigo;
	}	
}
