package inmo.ajax.gwt.client.db;

import java.io.Serializable;

public class ProvinciaBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idProvincia;
	private String nombre;
	/**
	 * Algun dia se implementara este atributo
	 */
	//private PaisBean pais;
	
	public ProvinciaBean(){
	}
	
	public ProvinciaBean(String idProvincia, String nombre) {
		super();
		this.idProvincia = idProvincia;
		this.nombre = nombre;
	}

	public String getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(String idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
