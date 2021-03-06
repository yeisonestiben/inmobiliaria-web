package inmo.db;

import java.util.Date;

/**
 * Informes generated by MyEclipse Persistence Tools
 */

public class Informes implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idInformes;
	private Empleado empleado;
	private TipoInforme tipoInforme;
	private Date fecha;
	private String descripcion;

	// Constructors

	/** default constructor */
	public Informes() {
	}

	/** minimal constructor */
	public Informes(Integer idInformes) {
		this.idInformes = idInformes;
	}

	/** full constructor */
	public Informes(Integer idInformes, Empleado empleado,
			TipoInforme tipoInforme, Date fecha, String descripcion) {
		this.idInformes = idInformes;
		this.empleado = empleado;
		this.tipoInforme = tipoInforme;
		this.fecha = fecha;
		this.descripcion = descripcion;
	}

	// Property accessors

	public Integer getIdInformes() {
		return this.idInformes;
	}

	public void setIdInformes(Integer idInformes) {
		this.idInformes = idInformes;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public TipoInforme getTipoInforme() {
		return this.tipoInforme;
	}

	public void setTipoInforme(TipoInforme tipoInforme) {
		this.tipoInforme = tipoInforme;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}