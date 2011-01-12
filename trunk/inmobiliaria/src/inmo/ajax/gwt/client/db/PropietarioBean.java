package inmo.ajax.gwt.client.db;

import inmo.ajax.gwt.client.utils.TipoPersona;

import java.io.Serializable;

public class PropietarioBean extends PersonaBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idPropietario;
	
	public PropietarioBean(){
		this.tipoPersona = TipoPersona.PROPIETARIO;
	}

	public PropietarioBean(String idPropietario, String idPersona, 
			TipoDocumentoBean tipoDocumento, String apellido, String nombres, 
			String numeroDocumento, String sexo, DireccionBean[] direcciones, 
			ContactoBean[] contactos) 
	{
		super(idPersona, tipoDocumento,	apellido, nombres, numeroDocumento, 
				sexo, direcciones, contactos);
		this.idPropietario = idPropietario;
		this.tipoPersona = TipoPersona.PROPIETARIO;
	}

	public String getIdPropietario() {
		return idPropietario;
	}

	public void setIdPropietario(String idPropietario) {
		this.idPropietario = idPropietario;
	}
}
