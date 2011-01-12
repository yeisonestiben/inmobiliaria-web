package inmo.db;

import java.util.Date;


@SuppressWarnings("serial")
public class Disponibilidad implements java.io.Serializable {

	// Fields

	private Integer idDisponibilidad;
	private Moneda moneda;
	private Propiedades propiedades;
	private TipoDisponibilidad tipoDisponibilidad;
	private Date fechaDesde;
	private Date fechaHasta;
	private Float monto;

	// Constructors

	/** default constructor */
	public Disponibilidad() {
	}

	/** minimal constructor */
	public Disponibilidad(Integer idDisponibilidad) {
		this.idDisponibilidad = idDisponibilidad;
	}

	/** full constructor */
	public Disponibilidad(Moneda moneda,
			Propiedades propiedades, TipoDisponibilidad tipoDisponibilidad,
			Date fechaDesde, Date fechaHasta, Float monto) {
		this.moneda = moneda;
		this.propiedades = propiedades;
		this.tipoDisponibilidad = tipoDisponibilidad;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.monto = monto;
	}

	// Property accessors

	public Integer getIdDisponibilidad() {
		return this.idDisponibilidad;
	}

	public void setIdDisponibilidad(Integer idDisponibilidad) {
		this.idDisponibilidad = idDisponibilidad;
	}

	public Moneda getMoneda() {
		return this.moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public Propiedades getPropiedades() {
		return this.propiedades;
	}

	public void setPropiedades(Propiedades propiedades) {
		this.propiedades = propiedades;
	}

	public TipoDisponibilidad getTipoDisponibilidad() {
		return this.tipoDisponibilidad;
	}

	public void setTipoDisponibilidad(TipoDisponibilidad tipoDisponibilidad) {
		this.tipoDisponibilidad = tipoDisponibilidad;
	}

	public Date getFechaDesde() {
		return this.fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return this.fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public Float getMonto() {
		return this.monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

}