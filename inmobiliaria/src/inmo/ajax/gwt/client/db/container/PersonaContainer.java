package inmo.ajax.gwt.client.db.container;

import inmo.ajax.gwt.client.db.PersonaBean;

import java.io.Serializable;

public class PersonaContainer implements Serializable
{
	private static final long serialVersionUID = 1L;
	private PersonaBean persona;

	public PersonaBean getPersona()
	{
		return persona;
	}

	public void setPersona(PersonaBean persona)
	{
		this.persona = persona;
	}
}
