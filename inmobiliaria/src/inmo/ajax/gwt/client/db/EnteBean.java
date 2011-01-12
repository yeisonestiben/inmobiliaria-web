package inmo.ajax.gwt.client.db;

import inmo.ajax.gwt.client.utils.TipoPersona;

import java.io.Serializable;

public abstract class EnteBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	protected TipoPersona tipoPersona;
	
	public TipoPersona getTipoPersona()
	{
		return tipoPersona;
	}
}
