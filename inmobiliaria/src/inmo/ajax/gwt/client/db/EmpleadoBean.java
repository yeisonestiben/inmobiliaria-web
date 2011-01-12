package inmo.ajax.gwt.client.db;

import inmo.ajax.gwt.client.utils.TipoPersona;

import java.io.Serializable;

public class EmpleadoBean extends PersonaBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idEmpleado;
	private TipoEmpleadoBean tipoEmpleado;
	private String usuario;
	private String clave;
	private TituloBean[] titulos;

	public EmpleadoBean(){
		this.tipoPersona = TipoPersona.EMPLEADO;
	}

	public EmpleadoBean(String idEmpleado, TipoEmpleadoBean tipoEmpleado,
			String usuario, String clave, TituloBean[] titulos, String idPersona, TipoDocumentoBean tipoDocumento,
			String apellido, String nombres, String numeroDocumento, String sexo,
			DireccionBean[] direcciones, ContactoBean[] contactos) 
	{
		super(idPersona, tipoDocumento,	apellido, nombres, numeroDocumento,
				sexo, direcciones, contactos);
		this.idEmpleado = idEmpleado;
		this.tipoEmpleado = tipoEmpleado;
		this.usuario = usuario;
		this.clave = clave;
		this.titulos = titulos;
		this.tipoPersona = TipoPersona.EMPLEADO;
	}

	public String getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public TipoEmpleadoBean getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(TipoEmpleadoBean tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

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
	
	public TituloBean[] getTitulos() {
		return titulos;
	}

	public void setTitulos(TituloBean[] titulos) {
		this.titulos = titulos;
	}
}
