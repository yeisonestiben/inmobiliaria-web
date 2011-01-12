package inmo.db;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class TipoComprobante implements java.io.Serializable, Comparable<TipoComprobante> {

	private static final long serialVersionUID = 1L;
	private Integer idTipoComprobante;
	private String nombre;
	private String descripcion;
	private Set egresos = new HashSet(0);

	// Constructors

	/** default constructor */
	public TipoComprobante() {
	}

	/** minimal constructor */
	public TipoComprobante(Integer idTipoComprobante) {
		this.idTipoComprobante = idTipoComprobante;
	}

	/** full constructor */
	public TipoComprobante(Integer idTipoComprobante, String nombre,
			String descripcion, Set egresos) {
		this.idTipoComprobante = idTipoComprobante;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.egresos = egresos;
	}

	// Property accessors

	public Integer getIdTipoComprobante() {
		return this.idTipoComprobante;
	}

	public void setIdTipoComprobante(Integer idTipoComprobante) {
		this.idTipoComprobante = idTipoComprobante;
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

	public int compareTo(TipoComprobante o)
	{
		return this.getNombre().compareTo(o.getNombre());
	}

}