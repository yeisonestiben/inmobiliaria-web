package inmo.db;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class Organizacion implements java.io.Serializable, Comparable<Organizacion>
{
	private static final long serialVersionUID = 1L;
	private Integer idOrganizacion;
	private String nombre;
	private Direccion direccion;
	private Persona titular;
	private Set contactos = new HashSet(0);
	
	public Organizacion() {
	}
	
	public Organizacion(Integer idOrganizacion, String nombre,
			Direccion direccion, Persona titular, Set contactos)
	{
		super();
		this.idOrganizacion = idOrganizacion;
		this.nombre = nombre;
		this.direccion = direccion;
		this.contactos = contactos;
		this.titular = titular;
	}

	public Integer getIdOrganizacion()
	{
		return idOrganizacion;
	}

	public void setIdOrganizacion(Integer idOrganizacion)
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

	public Direccion getDireccion()
	{
		return direccion;
	}

	public void setDireccion(Direccion direccion)
	{
		this.direccion = direccion;
	}

	public Persona getTitular()
	{
		return titular;
	}

	public void setTitular(Persona titular)
	{
		this.titular = titular;
	}

	public Set getContactos()
	{
		return contactos;
	}

	public void setContactos(Set contactos)
	{
		this.contactos = contactos;
	}

	public int compareTo(Organizacion o)
	{
		// TODO Auto-generated method stub
		return 0;
	}
}
