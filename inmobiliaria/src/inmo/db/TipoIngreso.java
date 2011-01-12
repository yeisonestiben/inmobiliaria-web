package inmo.db;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class TipoIngreso implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idTipoIngreso;
	private String nombre;
	private String descripcion;
	private Set ingresos = new HashSet(0);

	// Constructors

	/** default constructor */
	public TipoIngreso() {
	}

	/** minimal constructor */
	public TipoIngreso(Integer idTipoIngreso) {
		this.idTipoIngreso = idTipoIngreso;
	}

	/** full constructor */
	public TipoIngreso(Integer idTipoIngreso, String nombre,
			String descripcion, Set ingresos) {
		this.idTipoIngreso = idTipoIngreso;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.ingresos = ingresos;
	}

	// Property accessors

	public Integer getIdTipoIngreso() {
		return this.idTipoIngreso;
	}

	public void setIdTipoIngreso(Integer idTipoIngreso) {
		this.idTipoIngreso = idTipoIngreso;
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

	public Set getIngresos() {
		return this.ingresos;
	}

	public void setIngresos(Set ingresos) {
		this.ingresos = ingresos;
	}

}