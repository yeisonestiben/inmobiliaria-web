package inmo.db;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class Provincias implements java.io.Serializable, Comparable {

	private static final long serialVersionUID = 1L;
	private Integer idProvincias;
	private Paises paises;
	private String nombre;
	private Set localidadeses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Provincias() {
	}

	/** minimal constructor */
	public Provincias(Integer idProvincias, Paises paises) {
		this.idProvincias = idProvincias;
		this.paises = paises;
	}

	/** full constructor */
	public Provincias(Integer idProvincias, Paises paises, String nombre,
			Set localidadeses) {
		this.idProvincias = idProvincias;
		this.paises = paises;
		this.nombre = nombre;
		this.localidadeses = localidadeses;
	}

	// Property accessors

	public Integer getIdProvincias() {
		return this.idProvincias;
	}

	public void setIdProvincias(Integer idProvincias) {
		this.idProvincias = idProvincias;
	}

	public Paises getPaises() {
		return this.paises;
	}

	public void setPaises(Paises paises) {
		this.paises = paises;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set getLocalidadeses() {
		return this.localidadeses;
	}

	public void setLocalidadeses(Set localidadeses) {
		this.localidadeses = localidadeses;
	}

	public int compareTo(Object o) {
		Provincias p = (Provincias) o;
		return this.getNombre().compareTo(p.getNombre());
	}
}