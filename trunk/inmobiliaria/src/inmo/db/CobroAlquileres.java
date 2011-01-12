package inmo.db;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class CobroAlquileres implements java.io.Serializable, Comparable {

	private static final long serialVersionUID = 1L;
	// Fields

	private Integer idCobroAlquileres;
	private EstadoCobro estadoCobro;
	private Contratos contratos;
	private Date fechaCobro;
	private Date fechaVencimiento;
	private Float monto;
	private Float interes;
	private Set liquidacioneses = new HashSet(0);

	// Constructors

	/** default constructor */
	public CobroAlquileres() {
	}

	/** minimal constructor */
	public CobroAlquileres(Integer idCobroAlquileres) {
		this.idCobroAlquileres = idCobroAlquileres;
	}

	/** full constructor */
	public CobroAlquileres(Integer idCobroAlquileres, EstadoCobro estadoCobro,
			Contratos contratos, Date fechaCobro, Date fechaVencimiento,
			Float monto, Float interes, Set liquidacioneses) {
		this.idCobroAlquileres = idCobroAlquileres;
		this.estadoCobro = estadoCobro;
		this.contratos = contratos;
		this.fechaCobro = fechaCobro;
		this.fechaVencimiento = fechaVencimiento;
		this.monto = monto;
		this.interes = interes;
		this.liquidacioneses = liquidacioneses;
	}

	// Property accessors

	public Integer getIdCobroAlquileres() {
		return this.idCobroAlquileres;
	}

	public void setIdCobroAlquileres(Integer idCobroAlquileres) {
		this.idCobroAlquileres = idCobroAlquileres;
	}

	public EstadoCobro getEstadoCobro() {
		return this.estadoCobro;
	}

	public void setEstadoCobro(EstadoCobro estadoCobro) {
		this.estadoCobro = estadoCobro;
	}

	public Contratos getContratos() {
		return this.contratos;
	}

	public void setContratos(Contratos contratos) {
		this.contratos = contratos;
	}

	public Date getFechaCobro() {
		return this.fechaCobro;
	}

	public void setFechaCobro(Date fechaCobro) {
		this.fechaCobro = fechaCobro;
	}

	public Date getFechaVencimiento() {
		return this.fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Float getMonto() {
		return this.monto;
	}

	public void setMonto(Float monto) {
		this.monto = monto;
	}

	public Float getInteres() {
		return this.interes;
	}

	public void setInteres(Float interes) {
		this.interes = interes;
	}

	public Set getLiquidacioneses() {
		return this.liquidacioneses;
	}

	public void setLiquidacioneses(Set liquidacioneses) {
		this.liquidacioneses = liquidacioneses;
	}

	public int compareTo(Object o) {
		CobroAlquileres ca = (CobroAlquileres) o;
		return getFechaVencimiento().compareTo(ca.getFechaVencimiento());
	}

}