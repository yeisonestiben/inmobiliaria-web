package inmo.ajax.gwt.client.db;

import inmo.ajax.gwt.client.utils.TipoPersona;

import java.io.Serializable;

public class ClienteBean extends PersonaBean implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private String idCliente;
	
	public ClienteBean(){
		this.tipoPersona = TipoPersona.CLIENTE;
	}

	public ClienteBean(String idCliente, String idPersona, 
			TipoDocumentoBean tipoDocumento, String apellido, String nombres,
			String numeroDocumento, String sexo, DireccionBean[] direcciones, 
			ContactoBean[] contactos) 
	{
		super(idPersona, tipoDocumento,	apellido, nombres, numeroDocumento,	
				sexo, direcciones, contactos);
		this.idCliente = idCliente;
		this.tipoPersona = TipoPersona.CLIENTE;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}	
}
