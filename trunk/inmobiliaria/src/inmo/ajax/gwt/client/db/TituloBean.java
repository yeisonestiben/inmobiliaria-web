package inmo.ajax.gwt.client.db;

import java.io.Serializable;


public class TituloBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idTitulo;
	private String nombre;
	private String descripcion;
	
	public TituloBean(){
	}
	
	public TituloBean(String idTitulo, String nombre, String descripcion) {
		super();
		this.idTitulo = idTitulo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getIdTitulo() {
		return idTitulo;
	}

	public void setIdTitulo(String idTitulo) {
		this.idTitulo = idTitulo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
}
