package inmo.ajax.gwt.client.db;

import inmo.ajax.gwt.client.utils.TipoPersona;

import java.io.Serializable;


public class OrganizacionBean extends EnteBean implements Serializable
{
	private static final long serialVersionUID = -7573088384180005476L;
	
	private String idOrganizacion;
	private String nombre;
	private DireccionBean direccion;
	private PersonaBean titular;
	private ContactoBean[] contactos;
	
	public OrganizacionBean() {
		this.tipoPersona = TipoPersona.ORGANIZACION;
	}

	public OrganizacionBean(String idOrganizacion, String nombre,
			DireccionBean direccion, PersonaBean titular, 
			ContactoBean[] contactos)
	{
		super();
		this.idOrganizacion = idOrganizacion;
		this.nombre = nombre;
		this.direccion = direccion;
		this.contactos = contactos;
		this.tipoPersona = TipoPersona.ORGANIZACION;
		this.titular = titular;
	}

	public String getIdOrganizacion()
	{
		return idOrganizacion;
	}

	public void setIdOrganizacion(String idOrganizacion)
	{
		this.idOrganizacion = idOrganizacion;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public DireccionBean getDireccion()
	{
		return direccion;
	}

	public void setDireccion(DireccionBean direccion)
	{
		this.direccion = direccion;
	}

	public PersonaBean getTitular()
	{
		return titular;
	}

	public void setTitular(PersonaBean titular)
	{
		this.titular = titular;
	}

	public ContactoBean[] getContactos()
	{
		return contactos;
	}

	public void setContactos(ContactoBean[] contactos)
	{
		this.contactos = contactos;
	}
}
