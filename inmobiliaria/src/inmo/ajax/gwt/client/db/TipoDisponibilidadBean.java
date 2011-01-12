package inmo.ajax.gwt.client.db;

import java.io.Serializable;

public class TipoDisponibilidadBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idTipoDisponibilidad;
	private String nombre;
	private String descripcion;
	
	public TipoDisponibilidadBean() {
	}

	public TipoDisponibilidadBean(String idTipoDisponibilidad, String nombre,
			String descripcion)
	{
		super();
		this.idTipoDisponibilidad = idTipoDisponibilidad;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getIdTipoDisponibilidad()
	{
		return idTipoDisponibilidad;
	}

	public void setIdTipoDisponibilidad(String idTipoDisponibilidad)
	{
		this.idTipoDisponibilidad = idTipoDisponibilidad;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}
}
