package inmo.ajax.gwt.client.db;

import java.io.Serializable;

public class ReclamoBean implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String idReclamo;
	private EmpleadoBean empleado;
	private PersonaBean persona;
	private TipoReclamoBean motivo;
	private ContratoBean contrato;
	private String descripcion;
	private String comentarios;
	
	public ReclamoBean() {
	}
	
	public ReclamoBean(String idReclamo, EmpleadoBean empleado,
			PersonaBean persona, TipoReclamoBean motivo, ContratoBean contrato,
			String descripcion, String comentarios)
	{
		super();
		this.idReclamo = idReclamo;
		this.empleado = empleado;
		this.persona = persona;
		this.motivo = motivo;
		this.contrato = contrato;
		this.descripcion = descripcion;
		this.comentarios = comentarios;
	}

	public String getIdReclamo()
	{
		return idReclamo;
	}

	public void setIdReclamo(String idReclamo)
	{
		this.idReclamo = idReclamo;
	}

	public EmpleadoBean getEmpleado()
	{
		return empleado;
	}

	public void setEmpleado(EmpleadoBean empleado)
	{
		this.empleado = empleado;
	}

	public PersonaBean getPersona()
	{
		return persona;
	}

	public void setPersona(PersonaBean persona)
	{
		this.persona = persona;
	}

	public TipoReclamoBean getMotivo()
	{
		return motivo;
	}

	public void setMotivo(TipoReclamoBean motivo)
	{
		this.motivo = motivo;
	}

	public ContratoBean getContrato()
	{
		return contrato;
	}

	public void setContrato(ContratoBean contrato)
	{
		this.contrato = contrato;
	}

	public String getDescripcion()
	{
		return descripcion;
	}

	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}

	public String getComentarios()
	{
		return comentarios;
	}

	public void setComentarios(String comentarios)
	{
		this.comentarios = comentarios;
	}	
}
