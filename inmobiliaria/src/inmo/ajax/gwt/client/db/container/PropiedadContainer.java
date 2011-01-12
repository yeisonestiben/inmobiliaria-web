package inmo.ajax.gwt.client.db.container;

import inmo.ajax.gwt.client.db.PropiedadBean;

import java.io.Serializable;

public class PropiedadContainer implements Serializable
{
	private static final long serialVersionUID = 1L;
	private PropiedadBean propiedad;

	public PropiedadBean getPropiedad()
	{
		return propiedad;
	}

	public void setPropiedad(PropiedadBean propiedad)
	{
		this.propiedad = propiedad;
	}
}
