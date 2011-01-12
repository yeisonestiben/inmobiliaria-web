package inmo.db;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class Liquidaciones implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idLiquidaciones;
	private CobroAlquileres cobroAlquileres;
	private Date fecha;
	private Set ingresos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Liquidaciones() {
	}

	/** minimal constructor */
	public Liquidaciones(Integer idLiquidaciones) {
		this.idLiquidaciones = idLiquidaciones;
	}

	/** full constructor */
	public Liquidaciones(Integer idLiquidaciones,
			CobroAlquileres cobroAlquileres, Date fecha, Set ingresos) {
		this.idLiquidaciones = idLiquidaciones;
		this.cobroAlquileres = cobroAlquileres;
		this.fecha = fecha;
		this.ingresos = ingresos;
	}

	// Property accessors

	public Integer getIdLiquidaciones() {
		return this.idLiquidaciones;
	}

	public void setIdLiquidaciones(Integer idLiquidaciones) {
		this.idLiquidaciones = idLiquidaciones;
	}

	public CobroAlquileres getCobroAlquileres() {
		return this.cobroAlquileres;
	}

	public void setCobroAlquileres(CobroAlquileres cobroAlquileres) {
		this.cobroAlquileres = cobroAlquileres;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Set getIngresos() {
		return this.ingresos;
	}

	public void setIngresos(Set ingresos) {
		this.ingresos = ingresos;
	}

}