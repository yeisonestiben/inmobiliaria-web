package inmo.ajax.gwt.client.db;

import java.io.Serializable;

public class DireccionBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idDireccion;
	private TipoDireccionBean tipoUbicacion;
	private BarrioBean barrio;
	private String calle;
	private String numero;
	private String piso;
	private String departamento;
	private String cpp;
	
	public DireccionBean(){
	}

	public DireccionBean(String idDireccion, TipoDireccionBean tipoUbicacion,
			BarrioBean barrio, String calle, String numero, String piso,
			String departamento, String cpp) {
		super();
		this.idDireccion = idDireccion;
		this.tipoUbicacion = tipoUbicacion;
		this.barrio = barrio;
		this.calle = calle;
		this.numero = numero;
		this.piso = piso;
		this.departamento = departamento;
		this.cpp = cpp;
	}

	public String getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(String idDireccion) {
		this.idDireccion = idDireccion;
	}

	public TipoDireccionBean getTipoUbicacion() {
		return tipoUbicacion;
	}

	public void setTipoUbicacion(TipoDireccionBean tipoUbicacion) {
		this.tipoUbicacion = tipoUbicacion;
	}

	public BarrioBean getBarrios() {
		return barrio;
	}

	public void setBarrio(BarrioBean barrio) {
		this.barrio = barrio;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
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

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getCpp() {
		return cpp;
	}

	public void setCpp(String cpp) {
		this.cpp = cpp;
	}
}
