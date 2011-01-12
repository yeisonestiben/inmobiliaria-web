package inmo.db;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class Cliente implements java.io.Serializable, Comparable<Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer idCliente;
	private Persona persona;
	private Set contratoses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Cliente() {
	}

	/** minimal constructor */
	public Cliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	/** full constructor */
	public Cliente(Integer idCliente, Persona persona, Set contratoses) {
		this.idCliente = idCliente;
		this.persona = persona;
		this.contratoses = contratoses;
	}

	// Property accessors

	public Integer getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Set getContratoses() {
		return this.contratoses;
	}

	public void setContratoses(Set contratoses) {
		this.contratoses = contratoses;
	}

	public int compareTo(Object o) {
		Cliente c = (Cliente) o;
		int devolver = this.getPersona().getApellido().compareTo(c.getPersona().getApellido());
		if (devolver != 0)
		{
			return devolver;
		}
		else
		{
			return this.getPersona().getNombres().compareTo(c.getPersona().getNombres());
		}
	}
}