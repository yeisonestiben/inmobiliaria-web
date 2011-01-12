package inmo.ajax.gwt.client.db;

import java.io.Serializable;

public class TipoDireccionBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String idTipoUbicacion;
	private String nombre;
	
	public TipoDireccionBean(){
	}

	public TipoDireccionBean(String idTipoUbicacion, String nombre) {
		super();
		this.idTipoUbicacion = idTipoUbicacion;
		this.nombre = nombre;
	}

	public String getIdTipoUbicacion() {
		return idTipoUbicacion;
	}

	public void setIdTipoUbicacion(String idTipoUbicacion) {
		this.idTipoUbicacion = idTipoUbicacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
