package inmo.ajax.gwt.client.db;

import java.io.Serializable;

public class ClausulaBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String idClausulas;
	private String nombre;
	private String descripcion;
	private String numero;
	
	public ClausulaBean(){}

	public ClausulaBean(String idClausulas, String nombre, String descripcion,
			String numero)
	{
		super();
		this.idClausulas = idClausulas;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.numero = numero;
	}

	public String getIdClausulas()
	{
		return idClausulas;
	}

	public void setIdClausulas(String idClausulas)
	{
		this.idClausulas = idClausulas;
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

	public String getNumero()
	{
		return numero;
	}

	public void setNumero(String numero)
	{
		this.numero = numero;
	}
}
