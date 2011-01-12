package inmo.ajax.gwt.client.db;

import java.io.Serializable;

public class DisponibilidadBean implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idDisponibilidad;
	private MonedaBean moneda;
	private PropiedadBean propiedades;
	private TipoDisponibilidadBean tipoDisponibilidad;
	private String fechaDesde;
	private String fechaHasta;
	private String monto;
	
	public DisponibilidadBean () {
	}
	
	public DisponibilidadBean(String idDisponibilidad, MonedaBean moneda,
			PropiedadBean propiedades,
			TipoDisponibilidadBean tipoDisponibilidad, String fechaDesde,
			String fechaHasta, String monto)
	{
		super();
		this.idDisponibilidad = idDisponibilidad;
		this.moneda = moneda;
		this.propiedades = propiedades;
		this.tipoDisponibilidad = tipoDisponibilidad;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.monto = monto;
	}
	public String getIdDisponibilidad()
	{
		return idDisponibilidad;
	}
	public void setIdDisponibilidad(String idDisponibilidad)
	{
		this.idDisponibilidad = idDisponibilidad;
	}
	public MonedaBean getMoneda()
	{
		return moneda;
	}
	public void setMoneda(MonedaBean moneda)
	{
		this.moneda = moneda;
	}
	public PropiedadBean getPropiedades()
	{
		return propiedades;
	}
	public void setPropiedades(PropiedadBean propiedades)
	{
		this.propiedades = propiedades;
	}
	public TipoDisponibilidadBean getTipoDisponibilidad()
	{
		return tipoDisponibilidad;
	}
	public void setTipoDisponibilidad(TipoDisponibilidadBean tipoDisponibilidad)
	{
		this.tipoDisponibilidad = tipoDisponibilidad;
	}
	public String getFechaDesde()
	{
		return fechaDesde;
	}
	public void setFechaDesde(String fechaDesde)
	{
		this.fechaDesde = fechaDesde;
	}
	public String getFechaHasta()
	{
		return fechaHasta;
	}
	public void setFechaHasta(String fechaHasta)
	{
		this.fechaHasta = fechaHasta;
	}
	public String getMonto()
	{
		return monto;
	}
	public void setMonto(String monto)
	{
		this.monto = monto;
	}
}
