package inmo.ajax.gwt.client.db;

import java.io.Serializable;

public class LocalidadBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idLocalidad;
	private ProvinciaBean provincia;
	private String nombre;

	public LocalidadBean(){
		
	}

	public LocalidadBean(String idLocalidad, ProvinciaBean provincia,
			String nombre) {
		super();
		this.idLocalidad = idLocalidad;
		this.provincia = provincia;
		this.nombre = nombre;
	}

	public String getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(String idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public ProvinciaBean getProvincia() {
		return provincia;
	}

	public void setProvincia(ProvinciaBean provincia) {
		this.provincia = provincia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
