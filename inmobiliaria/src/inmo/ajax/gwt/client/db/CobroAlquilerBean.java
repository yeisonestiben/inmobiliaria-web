package inmo.ajax.gwt.client.db;

import java.io.Serializable;

public class CobroAlquilerBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String idCobroAlquileres;
	private EstadoCobroBean estadoCobro;
	private ContratoBean contrato;
	private String fechaCobro;
	private String fechaVencimiento;
	private String monto;
	private String interes;
	
	public CobroAlquilerBean(){
	}

	public CobroAlquilerBean(String idCobroAlquileres,
			EstadoCobroBean estadoCobro, ContratoBean contrato,
			String fechaCobro, String fechaVencimiento, String monto,
			String interes)
	{
		super();
		this.idCobroAlquileres = idCobroAlquileres;
		this.estadoCobro = estadoCobro;
		this.contrato = contrato;
		this.fechaCobro = fechaCobro;
		this.fechaVencimiento = fechaVencimiento;
		this.monto = monto;
		this.interes = interes;
	}

	public String getIdCobroAlquileres()
	{
		return idCobroAlquileres;
	}

	public void setIdCobroAlquileres(String idCobroAlquileres)
	{
		this.idCobroAlquileres = idCobroAlquileres;
	}

	public EstadoCobroBean getEstadoCobro()
	{
		return estadoCobro;
	}

	public void setEstadoCobro(EstadoCobroBean estadoCobro)
	{
		this.estadoCobro = estadoCobro;
	}

	public ContratoBean getContrato()
	{
		return contrato;
	}

	public void setContrato(ContratoBean contrato)
	{
		this.contrato = contrato;
	}

	public String getFechaCobro()
	{
		return fechaCobro;
	}

	public void setFechaCobro(String fechaCobro)
	{
		this.fechaCobro = fechaCobro;
	}

	public String getFechaVencimiento()
	{
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento)
	{
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getMonto()
	{
		return monto;
	}

	public void setMonto(String monto)
	{
		this.monto = monto;
	}

	public String getInteres()
	{
		return interes;
	}

	public void setInteres(String interes)
	{
		this.interes = interes;
	}
}
