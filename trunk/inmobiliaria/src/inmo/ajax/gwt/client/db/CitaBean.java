package inmo.ajax.gwt.client.db;

import java.io.Serializable;

public class CitaBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String idcita;
	private MotivoCitaBean motivoCita;
	private DireccionBean direccion;
	private String fecha;
	private String hora;
	
	public CitaBean() {
	}

	public CitaBean(String idcita, MotivoCitaBean motivoCita,
			DireccionBean direccion, String fecha, String hora)
	{
		super();
		this.idcita = idcita;
		this.motivoCita = motivoCita;
		this.direccion = direccion;
		this.fecha = fecha;
		this.hora = hora;
	}

	public String getIdcita()
	{
		return idcita;
	}

	public void setIdcita(String idcita)
	{
		this.idcita = idcita;
	}

	public MotivoCitaBean getMotivoCita()
	{
		return motivoCita;
	}

	public void setMotivoCita(MotivoCitaBean motivoCita)
	{
		this.motivoCita = motivoCita;
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
}
