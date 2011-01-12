package inmo.ajax.gwt.client.db;

import java.io.Serializable;

public class ContratoBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String idContrato;
	private TipoContratoBean tipoContrato;
	private String fecha;
	private PropiedadBean propiedad;
	private ClienteBean[] clientes;
	private ClausulaBean[] clausulas;
	
	public ContratoBean(){
	}

	public ContratoBean(String idContratos, TipoContratoBean tipoContrato,
			String fecha, PropiedadBean propiedad, ClienteBean[] clientes, 
			ClausulaBean[] clausulas)
	{
		super();
		this.idContrato = idContratos;
		this.tipoContrato = tipoContrato;
		this.fecha = fecha;
		this.propiedad = propiedad;
		this.clientes = clientes;
		this.clausulas = clausulas;
	}

	public String getIdContrato()
	{
		return idContrato;
	}

	public void setIdContrato(String idContratos)
	{
		this.idContrato = idContratos;
	}

	public TipoContratoBean getTipoContrato()
	{
		return tipoContrato;
	}

	public void setTipoContrato(TipoContratoBean tipoContrato)
	{
		this.tipoContrato = tipoContrato;
	}

	public String getFecha()
	{
		return fecha;
	}

	public void setFecha(String fecha)
	{
		this.fecha = fecha;
	}

	public PropiedadBean getPropiedad()
	{
		return propiedad;
	}

	public void setPropiedad(PropiedadBean propiedad)
	{
		this.propiedad = propiedad;
	}

	public ClienteBean[] getClientes()
	{
		return clientes;
	}

	public void setClientes(ClienteBean[] clientes)
	{
		this.clientes = clientes;
	}

	public ClausulaBean[] getClausulas()
	{
		return clausulas;
	}

	public void setClausulas(ClausulaBean[] clausulas)
	{
		this.clausulas = clausulas;
	}
}
