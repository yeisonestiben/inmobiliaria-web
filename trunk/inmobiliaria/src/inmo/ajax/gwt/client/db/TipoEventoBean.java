package inmo.ajax.gwt.client.db;

import java.io.Serializable;

public class TipoEventoBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String idTipoEvento;
	private String nombre;
	private String descripcion;
	
	public TipoEventoBean() 
	{
	}

	public TipoEventoBean(String idTipoEvento, String nombre, String descripcion)
	{
		super();
		this.idTipoEvento = idTipoEvento;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getIdTipoEvento()
	{
		return idTipoEvento;
	}

	public void setIdTipoEvento(String idTipoEvento)
	{
		this.idTipoEvento = idTipoEvento;
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
