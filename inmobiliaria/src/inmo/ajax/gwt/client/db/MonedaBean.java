package inmo.ajax.gwt.client.db;

import java.io.Serializable;

public class MonedaBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idMoneda;
	private String nombre;
	private String descripcion;
	private String cambio;
	
	public MonedaBean() {
	}

	public MonedaBean(String idMoneda, String nombre, String descripcion,
			String cambio)
	{
		super();
		this.idMoneda = idMoneda;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.cambio = cambio;
	}

	public String getIdMoneda()
	{
		return idMoneda;
	}

	public void setIdMoneda(String idMoneda)
	{
		this.idMoneda = idMoneda;
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

	public String getCambio()
	{
		return cambio;
	}

	public void setCambio(String cambio)
	{
		this.cambio = cambio;
	}
}
