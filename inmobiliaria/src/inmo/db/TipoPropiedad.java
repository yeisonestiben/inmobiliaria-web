package inmo.db;

public class TipoPropiedad implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idTipoPropiedad;
	private String nombre;
	private String descripcion;

	public TipoPropiedad() {
	}

	public TipoPropiedad(Integer idTipoPropiedad) {
		this.idTipoPropiedad = idTipoPropiedad;
	}

	public TipoPropiedad(Integer idTipoPropiedad, String nombre,
			String descripcion) {
		this.idTipoPropiedad = idTipoPropiedad;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Integer getIdTipoPropiedad() {
		return this.idTipoPropiedad;
	}

	public void setIdTipoPropiedad(Integer idTipoPropiedad) {
		this.idTipoPropiedad = idTipoPropiedad;
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
}