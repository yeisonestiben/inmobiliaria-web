package inmo.db;

@SuppressWarnings("serial")
public class DireccionXPersonaId implements java.io.Serializable {

	// Fields

	private Persona persona;
	private Direccion direccion;

	// Constructors

	/** default constructor */
	public DireccionXPersonaId() {
	}

	/** full constructor */
	public DireccionXPersonaId(Persona persona, Direccion direccion) {
		this.persona = persona;
		this.direccion = direccion;
	}

	// Property accessors

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Direccion getDireccion() {
		return this.direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DireccionXPersonaId))
			return false;
		DireccionXPersonaId castOther = (DireccionXPersonaId) other;

		return ((this.getPersona() == castOther.getPersona()) || (this
				.getPersona() != null
				&& castOther.getPersona() != null && this.getPersona().equals(
				castOther.getPersona())))
				&& ((this.getDireccion() == castOther.getDireccion()) || (this
						.getDireccion() != null
						&& castOther.getDireccion() != null && this
						.getDireccion().equals(castOther.getDireccion())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getPersona() == null ? 0 : this.getPersona().hashCode());
		result = 37 * result
				+ (getDireccion() == null ? 0 : this.getDireccion().hashCode());
		return result;
	}

}