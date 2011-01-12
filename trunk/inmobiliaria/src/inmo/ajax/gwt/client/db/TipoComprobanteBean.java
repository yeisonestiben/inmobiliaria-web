package inmo.ajax.gwt.client.db;

import java.io.Serializable;

public class TipoComprobanteBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String idTipoComprobante;
	private String nombre;
	private String descripcion;
	
	public TipoComprobanteBean()
	{
	}

	public TipoComprobanteBean(String idTipoComprobante, String nombre,
			String descripcion)
	{
		super();
		this.idTipoComprobante = idTipoComprobante;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getIdTipoComprobante()
	{
		return idTipoComprobante;
	}

	public void setIdTipoComprobante(String idTipoComprobante)
	{
		this.idTipoComprobante = idTipoComprobante;
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
