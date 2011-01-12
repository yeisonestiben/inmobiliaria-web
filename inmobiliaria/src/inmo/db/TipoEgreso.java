package inmo.db;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class TipoEgreso implements java.io.Serializable, Comparable<TipoEgreso> {

	private static final long serialVersionUID = 1L;
	private Integer idTipoEgreso;
	private String nombre;
	private String descripcion;
	private Set egresos = new HashSet(0);

	// Constructors

	/** default constructor */
	public TipoEgreso() {
	}

	/** minimal constructor */
	public TipoEgreso(Integer idTipoEgreso) {
		this.idTipoEgreso = idTipoEgreso;
	}

	/** full constructor */
	public TipoEgreso(Integer idTipoEgreso, String nombre, String descripcion,
			Set egresos) {
		this.idTipoEgreso = idTipoEgreso;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.egresos = egresos;
	}

	// Property accessors

	public Integer getIdTipoEgreso() {
		return this.idTipoEgreso;
	}

	public void setIdTipoEgreso(Integer idTipoEgreso) {
		this.idTipoEgreso = idTipoEgreso;
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

	public Set getEgresos() {
		return this.egresos;
	}

	public void setEgresos(Set egresos) {
		this.egresos = egresos;
	}

	public int compareTo(TipoEgreso o)
	{
		return this.getNombre().compareTo(o.getNombre());
	}

}