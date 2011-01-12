package inmo.ajax.gwt.client.db;

import java.io.Serializable;

public class EstadoPropiedadBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idEstadoPropiedad;
	private String nombre;
	private String descipcion;
	
	public EstadoPropiedadBean() {
	}

	public EstadoPropiedadBean(String idEstadoPropiedad, String nombre,
			String descipcion)
	{
		super();
		this.idEstadoPropiedad = idEstadoPropiedad;
		this.nombre = nombre;
		this.descipcion = descipcion;
	}

	public String getIdEstadoPropiedad()
	{
		return idEstadoPropiedad;
	}

	public void setIdEstadoPropiedad(String idEstadoPropiedad)
	{
		this.idEstadoPropiedad = idEstadoPropiedad;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getDescipcion()
	{
		return descipcion;
	}

	public void setDescipcion(String descipcion)
	{
		this.descipcion = descipcion;
	}
}
