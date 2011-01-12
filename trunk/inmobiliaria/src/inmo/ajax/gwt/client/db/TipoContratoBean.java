package inmo.ajax.gwt.client.db;

import java.io.Serializable;

public class TipoContratoBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String idTipoContrato;
	private String nombre;
	private String descripcion;
	
	public TipoContratoBean(){
	}

	public TipoContratoBean(String idTipoContrato, String nombre,
			String descripcion)
	{
		super();
		this.idTipoContrato = idTipoContrato;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getIdTipoContrato()
	{
		return idTipoContrato;
	}

	public void setIdTipoContrato(String idTipoContrato)
	{
		this.idTipoContrato = idTipoContrato;
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
