package inmo.db;

import java.util.HashSet;
import java.util.Set;
@SuppressWarnings("rawtypes")
public class Empleado implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idEmpleado;
	private TipoEmpleado tipoEmpleado;
	private Persona persona;
	private String usuario;
	private String clave;
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	private Set tituloXEmpleados = new HashSet(0);
	private Set informeses = new HashSet(0);
	private Set quejases = new HashSet(0);

	public Empleado() {
	}

	public Empleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
		
	public Empleado(Integer idEmpleado, TipoEmpleado tipoEmpleado,
			Persona persona, Set tituloXEmpleados, Set informeses, Set quejases) {
		this.idEmpleado = idEmpleado;
		this.tipoEmpleado = tipoEmpleado;
		this.persona = persona;
		this.tituloXEmpleados = tituloXEmpleados;
		this.informeses = informeses;
		this.quejases = quejases;
	}

	public Integer getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public TipoEmpleado getTipoEmpleado() {
		return this.tipoEmpleado;
	}

	public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Set getTituloXEmpleados() {
		return this.tituloXEmpleados;
	}

	public void setTituloXEmpleados(Set tituloXEmpleados) {
		this.tituloXEmpleados = tituloXEmpleados;
	}

	public Set getInformeses() {
		return this.informeses;
	}

	public void setInformeses(Set informeses) {
		this.informeses = informeses;
	}

	public Set getQuejases() {
		return this.quejases;
	}

	public void setQuejases(Set quejases) {
		this.quejases = quejases;
	}

}