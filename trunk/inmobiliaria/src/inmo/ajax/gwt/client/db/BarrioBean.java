package inmo.ajax.gwt.client.db;

import java.io.Serializable;

public class BarrioBean implements Serializable {	

	private static final long serialVersionUID = 1L;
	private String idBarrio;
	private LocalidadBean localidad;
	private String nombre;
	
	public BarrioBean(){
	}

	public BarrioBean(String idBarrio, LocalidadBean localidad, String nombre) {
		super();
		this.idBarrio = idBarrio;
		this.localidad = localidad;
		this.nombre = nombre;
	}

	public String getIdBarrio() {
		return idBarrio;
	}

	public void setIdBarrio(String idBarrio) {
		this.idBarrio = idBarrio;
	}

	public LocalidadBean getLocalidad() {
		return localidad;
	}

	public void setLocalidad(LocalidadBean localidad) {
		this.localidad = localidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombreLocalidad()
	{
		return localidad.getNombre();
	}
	
	public String getNombreProvincia()
	{
		return localidad.getProvincia().getNombre();
	}
}
