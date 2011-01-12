package inmo.pagebeans;

import org.apache.struts.action.ActionForm;

public class ConsultarPropiedadBean extends ActionForm {

	private static final long serialVersionUID = 1L;
	
	private String tipoPropiedad;
	private String tipoDisponibilidad;
	private String dormitorios;
	private String ambientes;
	private String cubierto;
	private String patio;
	private String parcela;
	private String idBarrio;
	private String nombreBarrio;
	private String moneda;
	private String montoDesde;
	private String montoHasta;
	private String antiguedad;
	
	public String getAmbientes() {
		return ambientes;
	}
	public void setAmbientes(String ambientes) {
		this.ambientes = ambientes;
	}
	public String getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(String antiguedad) {
		this.antiguedad = antiguedad;
	}
	public String getCubierto() {
		return cubierto;
	}
	public void setCubierto(String cubierto) {
		this.cubierto = cubierto;
	}
	public String getDormitorios() {
		return dormitorios;
	}
	public void setDormitorios(String dormitorios) {
		this.dormitorios = dormitorios;
	}
	public String getIdBarrio() {
		return idBarrio;
	}
	public void setIdBarrio(String idBarrio) {
		this.idBarrio = idBarrio;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public String getMontoDesde() {
		return montoDesde;
	}
	public void setMontoDesde(String montoDesde) {
		this.montoDesde = montoDesde;
	}
	public String getMontoHasta() {
		return montoHasta;
	}
	public void setMontoHasta(String montoHasta) {
		this.montoHasta = montoHasta;
	}
	public String getNombreBarrio() {
		return nombreBarrio;
	}
	public void setNombreBarrio(String nombreBarrio) {
		this.nombreBarrio = nombreBarrio;
	}
	public String getParcela() {
		return parcela;
	}
	public void setParcela(String parcela) {
		this.parcela = parcela;
	}
	public String getPatio() {
		return patio;
	}
	public void setPatio(String patio) {
		this.patio = patio;
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

}
