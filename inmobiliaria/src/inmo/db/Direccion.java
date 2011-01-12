package inmo.db;


@SuppressWarnings("serial")
public class Direccion implements java.io.Serializable {

	private Integer idDireccion;
	private TipoUbicacion tipoUbicacion;
	private Barrios barrios;
	private String calle;
	private Integer nro;
	private Integer piso;
	private String departamento;
	private String cpp;
	
	// Constructors

	/** default constructor */
	public Direccion() {
	}

	/** minimal constructor */
	public Direccion(Integer idDireccion) {
		this.idDireccion = idDireccion;
	}

	/** full constructor */
	public Direccion(TipoUbicacion tipoUbicacion,
			Barrios barrios, String calle, Integer nro, Integer piso,
			String departamento, String cpp) {
		this.tipoUbicacion = tipoUbicacion;
		this.barrios = barrios;
		this.calle = calle;
		this.nro = nro;
		this.piso = piso;
		this.departamento = departamento;
		this.cpp = cpp;
	}

	// Property accessors

	public Integer getIdDireccion() {
		return this.idDireccion;
	}

	public void setIdDireccion(Integer idDireccion) {
		this.idDireccion = idDireccion;
	}

	public TipoUbicacion getTipoUbicacion() {
		return this.tipoUbicacion;
	}

	public void setTipoUbicacion(TipoUbicacion tipoUbicacion) {
		this.tipoUbicacion = tipoUbicacion;
	}

	public Barrios getBarrios() {
		return this.barrios;
	}

	public void setBarrios(Barrios barrios) {
		this.barrios = barrios;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNro() {
		return this.nro;
	}

	public void setNro(Integer nro) {
		this.nro = nro;
	}

	public Integer getPiso() {
		return this.piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getCpp() {
		return this.cpp;
	}

	public void setCpp(String cpp) {
		this.cpp = cpp;
	}

}