package inmo.db;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class TipoUbicacion implements java.io.Serializable, Comparable<TipoUbicacion>
{

	private static final long serialVersionUID = 1L;
	private Integer idTipoUbicacion;
	private String nombre;
	private String descripcion;
	private Set direccions = new HashSet(0);

	// Constructors

	/** default constructor */
	public TipoUbicacion() {
	}

	/** minimal constructor */
	public TipoUbicacion(Integer idTipoUbicacion) {
		this.idTipoUbicacion = idTipoUbicacion;
	}

	/** full constructor */
	public TipoUbicacion(Integer idTipoUbicacion, String nombre,
			String descripcion, Set direccions) {
		this.idTipoUbicacion = idTipoUbicacion;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.direccions = direccions;
	}

	// Property accessors

	public Integer getIdTipoUbicacion() {
		return this.idTipoUbicacion;
	}

	public void setIdTipoUbicacion(Integer idTipoUbicacion) {
		this.idTipoUbicacion = idTipoUbicacion;
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

	public Set getDireccions() {
		return this.direccions;
	}

	public void setDireccions(Set direccions) {
		this.direccions = direccions;
	}

	public int compareTo(TipoUbicacion o)
	{
		return this.nombre.compareTo(o.getNombre());
	}
}