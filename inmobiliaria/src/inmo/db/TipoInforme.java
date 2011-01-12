package inmo.db;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class TipoInforme implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idTipoInforme;
	private String nombre;
	private String descripcion;
	private Set informeses = new HashSet(0);

	// Constructors

	/** default constructor */
	public TipoInforme() {
	}

	/** minimal constructor */
	public TipoInforme(Integer idTipoInforme) {
		this.idTipoInforme = idTipoInforme;
	}

	/** full constructor */
	public TipoInforme(Integer idTipoInforme, String nombre,
			String descripcion, Set informeses) {
		this.idTipoInforme = idTipoInforme;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.informeses = informeses;
	}

	// Property accessors

	public Integer getIdTipoInforme() {
		return this.idTipoInforme;
	}

	public void setIdTipoInforme(Integer idTipoInforme) {
		this.idTipoInforme = idTipoInforme;
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

	public Set getInformeses() {
		return this.informeses;
	}

	public void setInformeses(Set informeses) {
		this.informeses = informeses;
	}

}