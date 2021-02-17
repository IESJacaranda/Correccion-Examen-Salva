package Contestador;

import java.time.LocalDate;
import java.time.LocalTime;

public class Mensaje {
	public static Integer nextCode = 1;
	private StringBuilder remitente;
	private StringBuilder msg;
	private LocalDate fecha;
	private LocalTime hora;
	private Integer codigo;
	
	public Mensaje(StringBuilder remitente, StringBuilder msg) {
		super();
		this.remitente = remitente;
		this.msg = msg;
		this.fecha = LocalDate.now();
		this.hora = LocalTime.now();
		this.codigo = nextCode;
		nextCode++;
	}

	public StringBuilder getRemitente() {
		return remitente;
	}

	public void setRemitente(StringBuilder remitente) {
		this.remitente = remitente;
	}

	public StringBuilder getMsg() {
		return msg;
	}

	public void setMsg(StringBuilder msg) {
		this.msg = msg;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
		return "El " + fecha + " a las " + hora + " el usuario " + remitente + " dejó el mensaje: " + msg + " con código de mensaje " + codigo;
	}	
}
