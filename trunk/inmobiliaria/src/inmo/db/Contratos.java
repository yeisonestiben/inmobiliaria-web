package inmo.db;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class Contratos implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	// Fields

	private Integer idContratos;
	private TipoContrato tipoContrato;
	private Date fecha;
	private Propiedades propiedades;
	private Set ingresos = new HashSet(0);
	private Set quejases = new HashSet(0);
	private Set cobroAlquilereses = new HashSet(0);
	private Set clausulasXContratos = new HashSet(0);
	//O clientes u organizaciones debe ser nulo.
	//No se dan los 2 valores a la vez
	private Set clientes = new HashSet(0);
	private Set organizaciones = new HashSet(0);
	//estas son las garantias
	private Set propiedadeses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Contratos() {
	}

	/** full constructor */
	public Contratos(TipoContrato tipoContrato, Date fecha, Set ingresos,
			Set quejases, Set cobroAlquilereses, Set clausulasXContratos,
			Set clientes, Set organizaciones, Set propiedadeses) {
		this.tipoContrato = tipoContrato;
		this.fecha = fecha;
		this.ingresos = ingresos;
		this.quejases = quejases;
		this.cobroAlquilereses = cobroAlquilereses;
		this.clausulasXContratos = clausulasXContratos;
		this.clientes = clientes;
		this.propiedadeses = propiedadeses;
		this.organizaciones = organizaciones;
	}

	// Property accessors

	public Integer getIdContratos() {
		return this.idContratos;
	}

	public void setIdContratos(Integer idContratos) {
		this.idContratos = idContratos;
	}

	public TipoContrato getTipoContrato() {
		return this.tipoContrato;
	}

	public void setTipoContrato(TipoContrato tipoContrato) {
		this.tipoContrato = tipoContrato;
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

	public Set getQuejases() {
		return this.quejases;
	}

	public void setQuejases(Set quejases) {
		this.quejases = quejases;
	}

	public Set getCobroAlquilereses() {
		return this.cobroAlquilereses;
	}

	public void setCobroAlquilereses(Set cobroAlquilereses) {
		this.cobroAlquilereses = cobroAlquilereses;
	}

	public Set getClausulasXContratos() {
		return this.clausulasXContratos;
	}

	public void setClausulasXContratos(Set clausulasXContratos) {
		this.clausulasXContratos = clausulasXContratos;
	}

	public Set getClientes() {
		return this.clientes;
	}

	public void setClientes(Set clientes) {
		this.clientes = clientes;
	}

	public Set getPropiedadeses() {
		return this.propiedadeses;
	}

	public void setPropiedadeses(Set propiedadeses) {
		this.propiedadeses = propiedadeses;
	}

	public Propiedades getPropiedades() {
		return propiedades;
	}

	public void setPropiedades(Propiedades propiedades) {
		this.propiedades = propiedades;
	}

	public Set getOrganizaciones()
	{
		return organizaciones;
	}

	public void setOrganizaciones(Set organizaciones)
	{
		this.organizaciones = organizaciones;
	}
}