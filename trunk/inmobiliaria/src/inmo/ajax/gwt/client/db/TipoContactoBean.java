package inmo.ajax.gwt.client.db;

import java.io.Serializable;

public class TipoContactoBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idTipoContacto;
	private String nombre;
	
	public TipoContactoBean(){
	}

	public TipoContactoBean(String idTipoContacto, String nombre) {
		super();
		this.idTipoContacto = idTipoContacto;
		this.nombre = nombre;
	}

	public String getIdTipoContacto() {
		return idTipoContacto;
	}

	public void setIdTipoContacto(String idTipoContacto) {
		this.idTipoContacto = idTipoContacto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
