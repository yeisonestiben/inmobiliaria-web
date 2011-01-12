package inmo.db;

import java.util.Date;


@SuppressWarnings("serial")
public class DireccionXPersona implements java.io.Serializable {

	// Fields

	private DireccionXPersonaId id;
	private Date fechaDesde;
	private Date fechaHasta;

	// Constructors

	/** default constructor */
	public DireccionXPersona() {
	}

	/** minimal constructor */
	public DireccionXPersona(DireccionXPersonaId id) {
		this.id = id;
	}

	/** full constructor */
	public DireccionXPersona(DireccionXPersonaId id, Date fechaDesde,
			Date fechaHasta) {
		this.id = id;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
	}

	// Property accessors

	public DireccionXPersonaId getId() {
		return this.id;
	}

	public void setId(DireccionXPersonaId id) {
		this.id = id;
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

}