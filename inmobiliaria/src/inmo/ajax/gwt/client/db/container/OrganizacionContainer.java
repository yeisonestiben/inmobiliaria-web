package inmo.ajax.gwt.client.db.container;

import inmo.ajax.gwt.client.db.OrganizacionBean;

import java.io.Serializable;

public class OrganizacionContainer implements Serializable
{
	private static final long serialVersionUID = 1L;
	private OrganizacionBean organizacion;

	public OrganizacionBean getOrganizacion()
	{
		return organizacion;
	}

	public void setOrganizacion(OrganizacionBean organizacion)
	{
		this.organizacion = organizacion;
	}
}
