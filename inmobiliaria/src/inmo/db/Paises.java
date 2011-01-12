package inmo.db;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class Paises implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idPaises;
	private String nombre;
	private Set provinciases = new HashSet(0);

	// Constructors

	/** default constructor */
	public Paises() {
	}

	/** minimal constructor */
	public Paises(Integer idPaises) {
		this.idPaises = idPaises;
	}

	/** full constructor */
	public Paises(Integer idPaises, String nombre, Set provinciases) {
		this.idPaises = idPaises;
		this.nombre = nombre;
		this.provinciases = provinciases;
	}

	// Property accessors

	public Integer getIdPaises() {
		return this.idPaises;
	}

	public void setIdPaises(Integer idPaises) {
		this.idPaises = idPaises;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set getProvinciases() {
		return this.provinciases;
	}

	public void setProvinciases(Set provinciases) {
		this.provinciases = provinciases;
	}

}