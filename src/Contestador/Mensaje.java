package Contestador;

import java.time.LocalDateTime;

public class Mensaje {
	public static Integer nextCode = 1;
	private StringBuilder remitente;
	private StringBuilder msg;
	private LocalDateTime fecha;
	private Integer codigo;
	
	public Mensaje(StringBuilder remitente, StringBuilder msg) {
		super();
		this.remitente = remitente;
		this.msg = msg;
		this.fecha = LocalDateTime.now();
		this.codigo = nextCode;
		nextCode++;
	}

	public StringBuilder getRemitente() {
		return remitente;
	}

	public StringBuilder getMsg() {
		return msg;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public int getCodigo() {
		return codigo;
	}

	@Override
	public int hashCode() {
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
	public String toString() {
		return "El " + fecha + " el usuario " + remitente + " dejó el mensaje: " + msg + " con código de mensaje " + codigo;
	}	
}
