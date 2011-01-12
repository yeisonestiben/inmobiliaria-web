package inmo.db;

import java.util.Date;

/**
 * TituloXEmpleado generated by MyEclipse Persistence Tools
 */

public class TituloXEmpleado implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TituloXEmpleadoId id;
	private Date fechaDesde;

	// Constructors

	/** default constructor */
	public TituloXEmpleado() {
	}

	/** minimal constructor */
	public TituloXEmpleado(TituloXEmpleadoId id) {
		this.id = id;
	}

	/** full constructor */
	public TituloXEmpleado(TituloXEmpleadoId id, Date fechaDesde) {
		this.id = id;
		this.fechaDesde = fechaDesde;
	}

	// Property accessors

	public TituloXEmpleadoId getId() {
		return this.id;
	}

	public void setId(TituloXEmpleadoId id) {
		this.id = id;
	}

	public Date getFechaDesde() {
		return this.fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

}