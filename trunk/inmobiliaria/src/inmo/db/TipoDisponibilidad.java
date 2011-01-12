package inmo.db;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class TipoDisponibilidad implements java.io.Serializable, Comparable<TipoDisponibilidad> {

	private static final long serialVersionUID = 1L;
	private Integer idTipoDisponibilidad;
	private String nombre;
	private String descripcion;
	private Set disponibilidads = new HashSet(0);

	// Constructors

	/** default constructor */
	public TipoDisponibilidad() {
	}

	/** minimal constructor */
	public TipoDisponibilidad(Integer idTipoDisponibilidad) {
		this.idTipoDisponibilidad = idTipoDisponibilidad;
	}

	/** full constructor */
	public TipoDisponibilidad(Integer idTipoDisponibilidad, String nombre,
			String descripcion, Set disponibilidads) {
		this.idTipoDisponibilidad = idTipoDisponibilidad;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.disponibilidads = disponibilidads;
	}

	// Property accessors

	public Integer getIdTipoDisponibilidad() {
		return this.idTipoDisponibilidad;
	}

	public void setIdTipoDisponibilidad(Integer idTipoDisponibilidad) {
		this.idTipoDisponibilidad = idTipoDisponibilidad;
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

	public Set getDisponibilidads() {
		return this.disponibilidads;
	}

	public void setDisponibilidads(Set disponibilidads) {
		this.disponibilidads = disponibilidads;
	}

	public int compareTo(TipoDisponibilidad o)
	{
		return this.getNombre().compareTo(o.getNombre());
	}

}