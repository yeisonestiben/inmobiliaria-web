package inmo.db;

import java.util.Date;


@SuppressWarnings("serial")
public class Egreso implements java.io.Serializable {

	private Integer idEgreso;
	private TipoEgreso tipoEgreso;
	private TipoComprobante tipoComprobante;
	private Moneda moneda;
	private Date fecha;
	private Float monto;
	private String numeroComprobante;


	/** default constructor */
	public Egreso() {
	}

	/** minimal constructor */
	public Egreso(Integer idEgreso) {
		this.idEgreso = idEgreso;
	}

	/** full constructor */
	public Egreso(Integer idEgreso, TipoEgreso tipoEgreso,
			TipoComprobante tipoComprobante, Moneda moneda, Date fecha,
			Float monto, String numeroComprobante) {
		this.idEgreso = idEgreso;
		this.tipoEgreso = tipoEgreso;
		this.tipoComprobante = tipoComprobante;
		this.moneda = moneda;
		this.fecha = fecha;
		this.monto = monto;
		this.numeroComprobante = numeroComprobante;
	}

	// Property accessors

	public Integer getIdEgreso() {
		return this.idEgreso;
	}

	public void setIdEgreso(Integer idEgreso) {
		this.idEgreso = idEgreso;
	}

	public TipoEgreso getTipoEgreso() {
		return this.tipoEgreso;
	}

	public void setTipoEgreso(TipoEgreso tipoEgreso) {
		this.tipoEgreso = tipoEgreso;
	}

	public TipoComprobante getTipoComprobante() {
		return this.tipoComprobante;
	}

	public void setTipoComprobante(TipoComprobante tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}

	public Moneda getMoneda() {
		return this.moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Float getMonto() {
		return this.monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	public String getNumeroComprobante() {
		return this.numeroComprobante;
	}

	public void setNumeroComprobante(String numeroComprobante) {
		this.numeroComprobante = numeroComprobante;
	}

}