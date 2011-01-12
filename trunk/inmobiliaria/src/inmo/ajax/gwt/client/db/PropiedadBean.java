package inmo.ajax.gwt.client.db;

import java.io.Serializable;

public class PropiedadBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String idPropiedades;
	private TipoPropiedadBean tipoPropiedad;
	private DireccionBean direccion;
	private EstadoPropiedadBean estadoPropiedad;
	private String fechaConstruccion;
	private String ambientes;
	private String dormitorios;
	private String banios;
	private String patioM2;
	private String parcelaM2;
	private String cubiertoM2;
	private PropietarioBean propietario;
	
	public PropiedadBean () {
	}

	public PropiedadBean(String idPropiedades, TipoPropiedadBean tipoPropiedad,
			DireccionBean direccion, EstadoPropiedadBean estadoPropiedad,
			String fechaConstruccion, String ambientes, String dormitorios,
			String banios, String patioM2, String parcelaM2, String cubiertoM2,
			PropietarioBean propietario)
	{
		super();
		this.idPropiedades = idPropiedades;
		this.tipoPropiedad = tipoPropiedad;
		this.direccion = direccion;
		this.estadoPropiedad = estadoPropiedad;
		this.fechaConstruccion = fechaConstruccion;
		this.ambientes = ambientes;
		this.dormitorios = dormitorios;
		this.banios = banios;
		this.patioM2 = patioM2;
		this.parcelaM2 = parcelaM2;
		this.cubiertoM2 = cubiertoM2;
		this.propietario = propietario;
	}

	public String getIdPropiedades()
	{
		return idPropiedades;
	}

	public void setIdPropiedades(String idPropiedades)
	{
		this.idPropiedades = idPropiedades;
	}

	public TipoPropiedadBean getTipoPropiedad()
	{
		return tipoPropiedad;
	}

	public void setTipoPropiedad(TipoPropiedadBean tipoPropiedad)
	{
		this.tipoPropiedad = tipoPropiedad;
	}

	public DireccionBean getDireccion()
	{
		return direccion;
	}

	public void setDireccion(DireccionBean direccion)
	{
		this.direccion = direccion;
	}

	public EstadoPropiedadBean getEstadoPropiedad()
	{
		return estadoPropiedad;
	}

	public void setEstadoPropiedad(EstadoPropiedadBean estadoPropiedad)
	{
		this.estadoPropiedad = estadoPropiedad;
	}

	public String getFechaConstruccion()
	{
		return fechaConstruccion;
	}

	public void setFechaConstruccion(String fechaConstruccion)
	{
		this.fechaConstruccion = fechaConstruccion;
	}

	public String getAmbientes()
	{
		return ambientes;
	}

	public void setAmbientes(String ambientes)
	{
		this.ambientes = ambientes;
	}

	public String getDormitorios()
	{
		return dormitorios;
	}

	public void setDormitorios(String dormitorios)
	{
		this.dormitorios = dormitorios;
	}

	public String getBanios()
	{
		return banios;
	}

	public void setBanios(String banios)
	{
		this.banios = banios;
	}

	public String getPatioM2()
	{
		return patioM2;
	}

	public void setPatioM2(String patioM2)
	{
		this.patioM2 = patioM2;
	}

	public String getParcelaM2()
	{
		return parcelaM2;
	}

	public void setParcelaM2(String parcelaM2)
	{
		this.parcelaM2 = parcelaM2;
	}

	public String getCubiertoM2()
	{
		return cubiertoM2;
	}

	public void setCubiertoM2(String cubiertoM2)
	{
		this.cubiertoM2 = cubiertoM2;
	}
	
	public PropietarioBean getPropietario()
	{
		return propietario;
	}

	public void setPropietario(PropietarioBean propietario)
	{
		this.propietario = propietario;
	}

	public String getDescripcion()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
