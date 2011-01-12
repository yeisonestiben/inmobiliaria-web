package inmo.ajax.gwt.client.db;

import java.io.Serializable;

public class TipoDocumentoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipo;
	private String idTipo;
	
	public TipoDocumentoBean(){
	}
	
	public TipoDocumentoBean(String tipo, String idTipo) {
		super();
		this.tipo = tipo;
		this.idTipo = idTipo;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(String idTipo) {
		this.idTipo = idTipo;
	}
}
