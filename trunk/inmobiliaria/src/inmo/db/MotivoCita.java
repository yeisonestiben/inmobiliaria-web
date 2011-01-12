package inmo.db;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class MotivoCita implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idMotivoCita;
	private String nombre;
	private String descripcion;
	private Set citases = new HashSet(0);

	// Constructors

	/** default constructor */
	public MotivoCita() {
	}

	/** minimal constructor */
	public MotivoCita(Integer idMotivoCita) {
		this.idMotivoCita = idMotivoCita;
	}

	/** full constructor */
	public MotivoCita(Integer idMotivoCita, String nombre, String descripcion,
			Set citases) {
		this.idMotivoCita = idMotivoCita;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.citases = citases;
	}

	// Property accessors

	public Integer getIdMotivoCita() {
		return this.idMotivoCita;
	}

	public void setIdMotivoCita(Integer idMotivoCita) {
		this.idMotivoCita = idMotivoCita;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set getCitases() {
		return this.citases;
	}

	public void setCitases(Set citases) {
		this.citases = citases;
	}

}