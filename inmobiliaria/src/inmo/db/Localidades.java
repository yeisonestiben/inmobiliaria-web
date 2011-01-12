package inmo.db;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class Localidades implements java.io.Serializable, Comparable {

	private static final long serialVersionUID = 1L;
	private Integer idLocalidades;
	private Provincias provincias;
	private String nombre;
	private Set barrioses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Localidades() {
	}

	/** minimal constructor */
	public Localidades(Integer idLocalidades) {
		this.idLocalidades = idLocalidades;
	}

	/** full constructor */
	public Localidades(Integer idLocalidades, Provincias provincias,
			String nombre, Set barrioses) {
		this.idLocalidades = idLocalidades;
		this.provincias = provincias;
		this.nombre = nombre;
		this.barrioses = barrioses;
	}

	// Property accessors

	public Integer getIdLocalidades() {
		return this.idLocalidades;
	}

	public void setIdLocalidades(Integer idLocalidades) {
		this.idLocalidades = idLocalidades;
	}

	public Provincias getProvincias() {
		return this.provincias;
	}

	public void setProvincias(Provincias provincias) {
		this.provincias = provincias;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set getBarrioses() {
		return this.barrioses;
	}

	public void setBarrioses(Set barrioses) {
		this.barrioses = barrioses;
	}

	public int compareTo(Object o) {
		Localidades loc = (Localidades) o;
		return this.getNombre().compareTo(loc.getNombre());
	}

}