package inmo.db;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class Propietario implements java.io.Serializable, Comparable {

	private static final long serialVersionUID = 1L;
	private Integer idPropietario;
	private Persona persona;
	private Set propiedadesXPropietarios = new HashSet(0);

	public Propietario() {
	}

	public Propietario(Persona persona, Set propiedadesXPropietarios) {
		this.persona = persona;
		this.propiedadesXPropietarios = propiedadesXPropietarios;
	}

	public Integer getIdPropietario() {
		return this.idPropietario;
	}

	public void setIdPropietario(Integer idPropietario) {
		this.idPropietario = idPropietario;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Set getPropiedadesXPropietarios() {
		return this.propiedadesXPropietarios;
	}

	public void setPropiedadesXPropietarios(Set propiedadesXPropietarios) {
		this.propiedadesXPropietarios = propiedadesXPropietarios;
	}

	public int compareTo(Object o) {
		Propietario p = (Propietario) o;
		int devolver = this.getPersona().getApellido().compareTo(p.getPersona().getApellido());
		if (devolver != 0)
		{
			return devolver;
		}
		else
		{
			return this.getPersona().getNombres().compareTo(p.getPersona().getNombres());
		}
	}

}