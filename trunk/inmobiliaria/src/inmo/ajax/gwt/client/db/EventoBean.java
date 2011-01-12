package inmo.ajax.gwt.client.db;

import java.io.Serializable;


public class EventoBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String idEventos;
	private TipoEventoBean tipoEvento;
	private DireccionBean direccion;
	private String fecha;
	private String hora;
	private String descripcion;
	
	public EventoBean()
	{
	}

	public EventoBean(String idEventos, TipoEventoBean tipoEvento,
			DireccionBean direccion, String fecha, String hora,
			String descripcion)
	{
		super();
		this.idEventos = idEventos;
		this.tipoEvento = tipoEvento;
		this.direccion = direccion;
		this.fecha = fecha;
		this.hora = hora;
		this.descripcion = descripcion;
	}

	public String getIdEventos()
	{
		return idEventos;
	}

	public void setIdEventos(String idEventos)
	{
		this.idEventos = idEventos;
	}

	public TipoEventoBean getTipoEvento()
	{
		return tipoEvento;
	}

	public void setTipoEvento(TipoEventoBean tipoEvento)
	{
		this.tipoEvento = tipoEvento;
	}

	public DireccionBean getDireccion()
	{
		return direccion;
	}

	public void setDireccion(DireccionBean direccion)
	{
		this.direccion = direccion;
	}

	public String getFecha()
	{
		return fecha;
	}

	public void setFecha(String fecha)
	{
		this.fecha = fecha;
	}

	public String getHora()
	{
		return hora;
	}

	public void setHora(String hora)
	{
		this.hora = hora;
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
