package inmo.db;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class TipoContacto implements java.io.Serializable, Comparable {

	private static final long serialVersionUID = 1L;
	private Integer idTipoContacto;
	private String nombre;
	private String descripcion;
	private Set contactos = new HashSet(0);

	// Constructors

	/** default constructor */
	public TipoContacto() {
	}

	/** minimal constructor */
	public TipoContacto(Integer idTipoContacto) {
		this.idTipoContacto = idTipoContacto;
	}

	/** full constructor */
	public TipoContacto(Integer idTipoContacto, String nombre,
			String descripcion, Set contactos) {
		this.idTipoContacto = idTipoContacto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.contactos = contactos;
	}

	// Property accessors

	public Integer getIdTipoContacto() {
		return this.idTipoContacto;
	}

	public void setIdTipoContacto(Integer idTipoContacto) {
		this.idTipoContacto = idTipoContacto;
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

	public Set getContactos() {
		return this.contactos;
	}

	public void setContactos(Set contactos) {
		this.contactos = contactos;
	}

	public int compareTo(Object o) {
		TipoContacto tc = (TipoContacto) o;
		this.getNombre().compareTo(tc.getNombre());
		return 0;
	}

}