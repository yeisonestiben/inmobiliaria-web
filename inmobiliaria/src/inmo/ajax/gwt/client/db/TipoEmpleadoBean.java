package inmo.ajax.gwt.client.db;

import java.io.Serializable;

public class TipoEmpleadoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idTipoEmpleado;
	private String nombre;
	private String descripcion;
	
	public TipoEmpleadoBean(){
		
	}
	
	public TipoEmpleadoBean(String idTipoEmpleado, String nombre,
			String descripcion) {
		super();
		this.idTipoEmpleado = idTipoEmpleado;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	public String getIdTipoEmpleado() {
		return idTipoEmpleado;
	}
	public void setIdTipoEmpleado(String idTipoEmpleado) {
		this.idTipoEmpleado = idTipoEmpleado;
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
