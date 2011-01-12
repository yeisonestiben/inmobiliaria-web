package inmo.db;

public class EstadoPropiedad implements java.io.Serializable, 
												Comparable<EstadoPropiedad> {

	private static final long serialVersionUID = 1L;
	private Integer idEstadoPropiedad;
	private String nombre;
	private String descipcion;


	/** default constructor */
	public EstadoPropiedad() {
	}

	/** minimal constructor */
	public EstadoPropiedad(Integer idEstadoPropiedad) {
		this.idEstadoPropiedad = idEstadoPropiedad;
	}

	/** full constructor */
	public EstadoPropiedad(Integer idEstadoPropiedad, String nombre,
			String descipcion) {
		this.idEstadoPropiedad = idEstadoPropiedad;
		this.nombre = nombre;
		this.descipcion = descipcion;
	}

	// Property accessors

	public Integer getIdEstadoPropiedad() {
		return this.idEstadoPropiedad;
	}

	public void setIdEstadoPropiedad(Integer idEstadoPropiedad) {
		this.idEstadoPropiedad = idEstadoPropiedad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescipcion() {
		return this.descipcion;
	}

	public void setDescipcion(String descipcion) {
		this.descipcion = descipcion;
	}

	public int compareTo(EstadoPropiedad o)
	{
		return this.nombre.compareTo(o.getNombre());
	}
}