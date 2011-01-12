package inmo.db;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class EstadoCobro implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idEstadoCobro;
	private String nombre;
	private String descripcion;
	private Set cobroAlquilereses = new HashSet(0);

	// Constructors

	/** default constructor */
	public EstadoCobro() {
	}

	/** minimal constructor */
	public EstadoCobro(Integer idEstadoCobro) {
		this.idEstadoCobro = idEstadoCobro;
	}

	/** full constructor */
	public EstadoCobro(Integer idEstadoCobro, String nombre,
			String descripcion, Set cobroAlquilereses) {
		this.idEstadoCobro = idEstadoCobro;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cobroAlquilereses = cobroAlquilereses;
	}

	// Property accessors

	public Integer getIdEstadoCobro() {
		return this.idEstadoCobro;
	}

	public void setIdEstadoCobro(Integer idEstadoCobro) {
		this.idEstadoCobro = idEstadoCobro;
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

	public Set getCobroAlquilereses() {
		return this.cobroAlquilereses;
	}

	public void setCobroAlquilereses(Set cobroAlquilereses) {
		this.cobroAlquilereses = cobroAlquilereses;
	}

}