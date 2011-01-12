package inmo.db;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class Citas implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idcita;
	private MotivoCita motivoCita;
	private Direccion direccion;
	private Date fecha;
	private Date hora;
	private Set personas = new HashSet(0);

	// Constructors

	/** default constructor */
	public Citas() {
	}

	/** minimal constructor */
	public Citas(Integer idcita) {
		this.idcita = idcita;
	}

	/** full constructor */
	public Citas(MotivoCita motivoCita, Direccion direccion,
			Date fecha, Date hora) {
		this.motivoCita = motivoCita;
		this.direccion = direccion;
		this.fecha = fecha;
		this.hora = hora;
	}

	// Property accessors

	public Integer getIdcita() {
		return this.idcita;
	}

	public void setIdcita(Integer idcita) {
		this.idcita = idcita;
	}

	public MotivoCita getMotivoCita() {
		return this.motivoCita;
	}

	public void setMotivoCita(MotivoCita motivoCita) {
		this.motivoCita = motivoCita;
	}

	public Direccion getDireccion() {
		return this.direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHora() {
		return this.hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public Set getPersonas() {
		return this.personas;
	}

	public void setPersonas(Set personas) {
		this.personas = personas;
	}

}