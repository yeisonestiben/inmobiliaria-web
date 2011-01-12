package inmo.ajax.gwt.client.db;

import java.io.Serializable;

public class TipoPropiedadBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idTipoPropiedad;
	private String nombre;
	private String descripcion;
	
	public TipoPropiedadBean() {
	}

	public TipoPropiedadBean(String idTipoPropiedad, String nombre,
			String descripcion)
	{
		super();
		this.idTipoPropiedad = idTipoPropiedad;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getIdTipoPropiedad()
	{
		return idTipoPropiedad;
	}

	public void setIdTipoPropiedad(String idTipoPropiedad)
	{
		this.idTipoPropiedad = idTipoPropiedad;
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
