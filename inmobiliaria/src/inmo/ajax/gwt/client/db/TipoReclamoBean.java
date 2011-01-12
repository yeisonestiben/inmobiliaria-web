package inmo.ajax.gwt.client.db;

import java.io.Serializable;

public class TipoReclamoBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String idMotivo;
	private String nombre;
	private String descripcion;
	private String tiempoSoluciuon;
	
	public TipoReclamoBean(){
	}

	public TipoReclamoBean(String idMotivo, String nombre, String descripcion,
			String tiempoSoluciuon)
	{
		super();
		this.idMotivo = idMotivo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tiempoSoluciuon = tiempoSoluciuon;
	}

	public String getIdMotivo()
	{
		return idMotivo;
	}

	public void setIdMotivo(String idMotivo)
	{
		this.idMotivo = idMotivo;
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

	public String getTiempoSoluciuon()
	{
		return tiempoSoluciuon;
	}

	public void setTiempoSoluciuon(String tiempoSoluciuon)
	{
		this.tiempoSoluciuon = tiempoSoluciuon;
	}
}
