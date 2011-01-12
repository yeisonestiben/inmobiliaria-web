package inmo.ajax.gwt.client.db;

import java.io.Serializable;

public class ContactoBean implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idContacto;
	private TipoContactoBean tipoContacto;
	private String nombre;
	
	public ContactoBean(){
	}

	public ContactoBean(String idContacto, TipoContactoBean tipoContacto,
			String nombre) {
		super();
		this.idContacto = idContacto;
		this.tipoContacto = tipoContacto;
		this.nombre = nombre;
	}

	public String getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(String idContacto) {
		this.idContacto = idContacto;
	}

	public TipoContactoBean getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(TipoContactoBean tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
