package inmo.db;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class Titulo implements java.io.Serializable, Comparable {

	private static final long serialVersionUID = 1L;
	private Integer idTitulo;
	private String nombre;
	private String descripcion;
	private Set tituloXEmpleados = new HashSet(0);

	// Constructors

	/** default constructor */
	public Titulo() {
	}

	/** minimal constructor */
	public Titulo(Integer idTitulo) {
		this.idTitulo = idTitulo;
	}

	/** full constructor */
	public Titulo(Integer idTitulo, String nombre, String descripcion,
			Set tituloXEmpleados) {
		this.idTitulo = idTitulo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tituloXEmpleados = tituloXEmpleados;
	}

	// Property accessors

	public Integer getIdTitulo() {
		return this.idTitulo;
	}

	public void setIdTitulo(Integer idTitulo) {
		this.idTitulo = idTitulo;
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

	public Set getTituloXEmpleados() {
		return this.tituloXEmpleados;
	}

	public void setTituloXEmpleados(Set tituloXEmpleados) {
		this.tituloXEmpleados = tituloXEmpleados;
	}

	public int compareTo(Object o) {
		Titulo t = (Titulo) o;
		return this.getNombre().compareTo(t.getNombre());
	}

}