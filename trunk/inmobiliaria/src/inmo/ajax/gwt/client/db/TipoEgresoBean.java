package inmo.ajax.gwt.client.db;

import java.io.Serializable;

public class TipoEgresoBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String idTipoEgreso;
	private String nombre;
	private String descripcion;
	
	public TipoEgresoBean()
	{
	}

	public TipoEgresoBean(String idTipoEgreso, String nombre, String descripcion)
	{
		super();
		this.idTipoEgreso = idTipoEgreso;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getIdTipoEgreso()
	{
		return idTipoEgreso;
	}

	public void setIdTipoEgreso(String idTipoEgreso)
	{
		this.idTipoEgreso = idTipoEgreso;
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
