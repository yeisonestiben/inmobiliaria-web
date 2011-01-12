package inmo.pagebeans;

import inmo.Utilidades;
import inmo.db.EstadoPropiedad;
import inmo.db.EstadoPropiedadDAO;
import inmo.db.Moneda;
import inmo.db.MonedaDAO;
import inmo.db.TipoDisponibilidad;
import inmo.db.TipoDisponibilidadDAO;
import inmo.db.TipoPropiedad;
import inmo.db.TipoPropiedadDAO;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class RegistrarPropiedadBean extends ActionForm  {

	private static final long serialVersionUID = 1L;

	private String tipoPropiedad;
	private String tipoDisponibilidad;
	private String idPropietario;
	private String nombresPropietario;
	private String estadoPropiedad;
	private String fecha;
	private String banios;
	private String dormitorios;
	private String ambientes;
	private String cubiertoM2;
	private String patioM2;
	private String parcelaM2;
	private String calle;
	private String numero;
	private String piso;
	private String departamento;
	private String cpp;
	private String idBarrio;
	private String nombreBarrio;
	private String monto;
	private String moneda;

	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getCpp() {
		return cpp;
	}
	public void setCpp(String cpp) {
		this.cpp = cpp;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getIdBarrio() {
		return idBarrio;
	}
	public void setIdBarrio(String idBarrio) {
		this.idBarrio = idBarrio;
	}
	public String getIdPropietario() {
		return idPropietario;
	}
	public void setIdPropietario(String idPropietario) {
		this.idPropietario = idPropietario;
	}
	public String getNombreBarrio() {
		return nombreBarrio;
	}
	public void setNombreBarrio(String nombreBarrio) {
		this.nombreBarrio = nombreBarrio;
	}
	public String getNombresPropietario() {
		return nombresPropietario;
	}
	public void setNombresPropietario(String nombresPropietario) {
		this.nombresPropietario = nombresPropietario;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getPiso() {
		return piso;
	}
	public void setPiso(String piso) {
		this.piso = piso;
	}
	public String getTipoDisponibilidad() {
		return tipoDisponibilidad;
	}
	public void setTipoDisponibilidad(String tipoDisponibilidad) {
		this.tipoDisponibilidad = tipoDisponibilidad;
	}
	public String getTipoPropiedad() {
		return tipoPropiedad;
	}
	public void setTipoPropiedad(String tipoPropiedad) {
		this.tipoPropiedad = tipoPropiedad;
	}
	public String getAmbientes() {
		return ambientes;
	}
	public void setAmbientes(String ambientes) {
		this.ambientes = ambientes;
	}
	public String getBanios() {
		return banios;
	}
	public void setBanios(String banios) {
		this.banios = banios;
	}
	public String getCubiertoM2() {
		return cubiertoM2;
	}
	public void setCubiertoM2(String cubiertoM2) {
		this.cubiertoM2 = cubiertoM2;
	}
	public String getDormitorios() {
		return dormitorios;
	}
	public void setDormitorios(String dormitorios) {
		this.dormitorios = dormitorios;
	}
	public String getEstadoPropiedad() {
		return estadoPropiedad;
	}
	public void setEstadoPropiedad(String estadoPropiedad) {
		this.estadoPropiedad = estadoPropiedad;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getParcelaM2() {
		return parcelaM2;
	}
	public void setParcelaM2(String parcelaM2) {
		this.parcelaM2 = parcelaM2;
	}
	public String getPatioM2() {
		return patioM2;
	}
	public void setPatioM2(String patioM2) {
		this.patioM2 = patioM2;
	} 

	@SuppressWarnings("unchecked")
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();

		if (Utilidades.isMissing(getIdPropietario()))
		{
			errors.add("propietario", new ActionMessage("errors.required", "Propietario"));
		}

		if (Utilidades.isMissing(getFecha())) {
			errors.add("fecha", new ActionMessage("errors.required", "Fecha"));
		}	

		if (Utilidades.isMissing(getCubiertoM2())) {
			errors.add("cubiertoM2", new ActionMessage("errors.required", "Metros Cubiertos"));
		}
		else 
		{
			if (!Utilidades.isInt(getCubiertoM2()))
			{
				errors.add("cubiertoM2", new ActionMessage("errors.integer", "Metros Cubiertos"));
			}
		}

		if (Utilidades.isMissing(getPatioM2())) {
			errors.add("patioM2", new ActionMessage("errors.required", "Metros Patio"));
		}
		else 
		{
			if (!Utilidades.isInt(getPatioM2()))
			{
				errors.add("patioM2", new ActionMessage("errors.integer", "Metros Patio"));
			}
		}


		if (Utilidades.isMissing(getParcelaM2())) {
			errors.add("parcelaM2", new ActionMessage("errors.required", "Metros Parcela"));
		}
		else 
		{
			if (!Utilidades.isInt(getParcelaM2()))
			{
				errors.add("parcelaM2", new ActionMessage("errors.integer", "Metros Parcela"));
			}
		}


		if (Utilidades.isMissing(getCalle()))
		{
			errors.add("calle", new ActionMessage("errors.required", "Calle"));
		}

		if (Utilidades.isMissing(getNumero())) {
			errors.add("numero", new ActionMessage("errors.required", "Número de Dirección"));
		}
		else 
		{
			if (!Utilidades.isInt(getNumero()))
			{
				errors.add("numero", new ActionMessage("errors.integer", "Número de Dirección"));
			}
		}

		if (Utilidades.isMissing(getCpp())) {
			errors.add("cpp", new ActionMessage("errors.required", "Código Postal"));
		}

		if (Utilidades.isMissing(getMonto())) {
			errors.add("monto", new ActionMessage("errors.required", "Monto"));
		}
		else 
		{
			if (!Utilidades.isFloat(getMonto()))
			{
				errors.add("monto", new ActionMessage("errors.float", "Monto"));
			}
		}

		TipoPropiedadDAO tipoPropiedadDAO = new TipoPropiedadDAO();
		ArrayList<TipoPropiedad> arrayTipoPropiedad;
		arrayTipoPropiedad = (ArrayList<TipoPropiedad>) tipoPropiedadDAO.findAll();
		request.setAttribute("arrayTipoPropiedad",arrayTipoPropiedad);

		TipoDisponibilidadDAO tipoDisponibilidadDAO = new TipoDisponibilidadDAO();
		ArrayList<TipoDisponibilidad> arrayTipoDisponibilidad;
		arrayTipoDisponibilidad = (ArrayList<TipoDisponibilidad>) tipoDisponibilidadDAO.findAll();
		request.setAttribute("arrayTipoDisponibilidad",arrayTipoDisponibilidad);

		EstadoPropiedadDAO estadoPropiedadDAO = new EstadoPropiedadDAO();
		ArrayList<EstadoPropiedad> arrayEstadoPropiedad;
		arrayEstadoPropiedad = (ArrayList<EstadoPropiedad>) estadoPropiedadDAO.findAll();
		request.setAttribute("arrayEstadoPropiedad", arrayEstadoPropiedad);

		MonedaDAO monedaDAO = new MonedaDAO();
		ArrayList<Moneda> arrayMonedas;
		arrayMonedas = (ArrayList<Moneda>) monedaDAO.findAll();
		request.setAttribute("arrayMonedas",arrayMonedas);

		return errors;
	}
}
