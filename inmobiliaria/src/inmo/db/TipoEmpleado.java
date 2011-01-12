package inmo.db;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class TipoEmpleado implements java.io.Serializable, Comparable {

	private static final long serialVersionUID = 1L;
	private Integer idTipoEmpleado;
	private String nombre;
	private String descripcion;
	private Set empleados = new HashSet(0);

	// Constructors

	/** default constructor */
	public TipoEmpleado() {
	}

	/** minimal constructor */
	public TipoEmpleado(Integer idTipoEmpleado) {
		this.idTipoEmpleado = idTipoEmpleado;
	}

	/** full constructor */
	public TipoEmpleado(Integer idTipoEmpleado, String nombre,
			String descripcion, Set empleados) {
		this.idTipoEmpleado = idTipoEmpleado;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.empleados = empleados;
	}

	// Property accessors

	public Integer getIdTipoEmpleado() {
		return this.idTipoEmpleado;
	}

	public void setIdTipoEmpleado(Integer idTipoEmpleado) {
		this.idTipoEmpleado = idTipoEmpleado;
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

	public Set getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(Set empleados) {
		this.empleados = empleados;
	}

	public int compareTo(Object o) {
		TipoEmpleado te = (TipoEmpleado) o;
		return this.getNombre().compareTo(te.getNombre());
	}

}