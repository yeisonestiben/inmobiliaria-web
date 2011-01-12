package inmo.ajax.gwt.client.db;

import inmo.ajax.gwt.client.utils.TipoGarantia;

import java.io.Serializable;

public class GarantiaBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private TipoGarantia tipoGarantia;
	private PersonaBean garante;
	private String descripcionGarantia;
	private OrganizacionBean organizacion;
	public TipoGarantia getTipoGarantia()
	{
		return tipoGarantia;
	}
	public void setTipoGarantia(TipoGarantia tipoGarantia)
	{
		this.tipoGarantia = tipoGarantia;
	}
	public PersonaBean getGarante()
	{
		return garante;
	}
	public void setGarante(PersonaBean garante)
	{
		this.garante = garante;
	}
	public String getDescripcionGarantia()
	{
		return descripcionGarantia;
	}
	public void setDescripcionGarantia(String descripcionGarantia)
	{
		this.descripcionGarantia = descripcionGarantia;
	}
	public OrganizacionBean getOrganizacion()
	{
		return organizacion;
	}
	public void setOrganizacion(OrganizacionBean organizacion)
	{
		this.organizacion = organizacion;
	}
}
