package inmo.ajax.gwt.client.db;

import java.io.Serializable;

public class EstadoCobroBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String idEstadoCobro;
	private String nombre;
	private String descripcion;
	
	public EstadoCobroBean() {
	}

	public EstadoCobroBean(String idEstadoCobro, String nombre,
			String descripcion)
	{
		super();
		this.idEstadoCobro = idEstadoCobro;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getIdEstadoCobro()
	{
		return idEstadoCobro;
	}

	public void setIdEstadoCobro(String idEstadoCobro)
	{
		this.idEstadoCobro = idEstadoCobro;
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
