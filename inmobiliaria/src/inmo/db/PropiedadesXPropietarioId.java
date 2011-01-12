package inmo.db;

import java.util.Date;



public class PropiedadesXPropietarioId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	// Fields

	private Integer idPropiedades;
	private Integer idPropietario;
	private Date fechaDesde;

	// Constructors

	/** default constructor */
	public PropiedadesXPropietarioId() {
	}

	/** full constructor */
	public PropiedadesXPropietarioId(Integer idPropiedades,
			Integer idPropietario, Date fechaDesde) {
		this.idPropiedades = idPropiedades;
		this.idPropietario = idPropietario;
		this.fechaDesde = fechaDesde;
	}

	// Property accessors

	public Integer getIdPropiedades() {
		return this.idPropiedades;
	}

	public void setIdPropiedades(Integer idPropiedades) {
		this.idPropiedades = idPropiedades;
	}

	public Integer getIdPropietario() {
		return this.idPropietario;
	}

	public void setIdPropietario(Integer idPropietario) {
		this.idPropietario = idPropietario;
	}

	public Date getFechaDesde() {
		return this.fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PropiedadesXPropietarioId))
			return false;
		PropiedadesXPropietarioId castOther = (PropiedadesXPropietarioId) other;

		return ((this.getIdPropiedades() == castOther.getIdPropiedades()) || (this
				.getIdPropiedades() != null
				&& castOther.getIdPropiedades() != null && this
				.getIdPropiedades().equals(castOther.getIdPropiedades())))
				&& ((this.getIdPropietario() == castOther.getIdPropietario()) || (this
						.getIdPropietario() != null
						&& castOther.getIdPropietario() != null && this
						.getIdPropietario()
						.equals(castOther.getIdPropietario())))
				&& ((this.getFechaDesde() == castOther.getFechaDesde()) || (this
						.getFechaDesde() != null
						&& castOther.getFechaDesde() != null && this
						.getFechaDesde().equals(castOther.getFechaDesde())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getIdPropiedades() == null ? 0 : this.getIdPropiedades()
						.hashCode());
		result = 37
				* result
				+ (getIdPropietario() == null ? 0 : this.getIdPropietario()
						.hashCode());
		result = 37
				* result
				+ (getFechaDesde() == null ? 0 : this.getFechaDesde()
						.hashCode());
		return result;
	}

}