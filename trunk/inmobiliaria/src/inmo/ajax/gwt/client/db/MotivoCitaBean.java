package inmo.ajax.gwt.client.db;

import java.io.Serializable;

public class MotivoCitaBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String idMotivoCita;
	private String nombre;
	private String descripcion;
	
	public MotivoCitaBean() {
	}

	public MotivoCitaBean(String idMotivoCita, String nombre, String descripcion)
	{
		super();
		this.idMotivoCita = idMotivoCita;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getIdMotivoCita()
	{
		return idMotivoCita;
	}

	public void setIdMotivoCita(String idMotivoCita)
	{
		this.idMotivoCita = idMotivoCita;
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
