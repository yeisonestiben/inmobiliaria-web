package inmo.db;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class Propiedades implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idPropiedades;
	private TipoPropiedad tipoPropiedad;
	private Direccion direccion;
	private EstadoPropiedad estadoPropiedad;
	private Date fechaConstruccion;
	private Integer ambientes;
	private Integer dormitorios;
	private Integer banios;
	private Integer patioM2;
	private Integer parcelaM2;
	private Integer cubiertoM2;
	private Set disponibilidads = new HashSet(0);
	private Set propiedadesXPropietarios = new HashSet(0);
	private Set contratoses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Propiedades() {
	}

	/** full constructor */
	public Propiedades(TipoPropiedad tipoPropiedad, Direccion direccion,
			EstadoPropiedad estadoPropiedad, Date fechaConstruccion,
			Integer ambientes, Integer dormitorios, Integer banios,
			Integer patioM2, Integer parcelaM2, Integer cubiertoM2,
			Set disponibilidads, Set propiedadesXPropietarios, Set contratoses) {
		this.tipoPropiedad = tipoPropiedad;
		this.direccion = direccion;
		this.estadoPropiedad = estadoPropiedad;
		this.fechaConstruccion = fechaConstruccion;
		this.ambientes = ambientes;
		this.dormitorios = dormitorios;
		this.banios = banios;
		this.patioM2 = patioM2;
		this.parcelaM2 = parcelaM2;
		this.cubiertoM2 = cubiertoM2;
		this.disponibilidads = disponibilidads;
		this.propiedadesXPropietarios = propiedadesXPropietarios;
		this.contratoses = contratoses;
	}

	// Property accessors

	public Integer getIdPropiedades() {
		return this.idPropiedades;
	}

	public void setIdPropiedades(Integer idPropiedades) {
		this.idPropiedades = idPropiedades;
	}

	public TipoPropiedad getTipoPropiedad() {
		return this.tipoPropiedad;
	}

	public void setTipoPropiedad(TipoPropiedad tipoPropiedad) {
		this.tipoPropiedad = tipoPropiedad;
	}

	public Direccion getDireccion() {
		return this.direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public EstadoPropiedad getEstadoPropiedad() {
		return this.estadoPropiedad;
	}

	public void setEstadoPropiedad(EstadoPropiedad estadoPropiedad) {
		this.estadoPropiedad = estadoPropiedad;
	}

	public Date getFechaConstruccion() {
		return this.fechaConstruccion;
	}

	public void setFechaConstruccion(Date fechaConstruccion) {
		this.fechaConstruccion = fechaConstruccion;
	}

	public Integer getAmbientes() {
		return this.ambientes;
	}

	public void setAmbientes(Integer ambientes) {
		this.ambientes = ambientes;
	}

	public Integer getDormitorios() {
		return this.dormitorios;
	}

	public void setDormitorios(Integer dormitorios) {
		this.dormitorios = dormitorios;
	}

	public Integer getBanios() {
		return this.banios;
	}

	public void setBanios(Integer banios) {
		this.banios = banios;
	}

	public Integer getPatioM2() {
		return this.patioM2;
	}

	public void setPatioM2(Integer patioM2) {
		this.patioM2 = patioM2;
	}

	public Integer getParcelaM2() {
		return this.parcelaM2;
	}

	public void setParcelaM2(Integer parcelaM2) {
		this.parcelaM2 = parcelaM2;
	}

	public Integer getCubiertoM2() {
		return this.cubiertoM2;
	}

	public void setCubiertoM2(Integer cubiertoM2) {
		this.cubiertoM2 = cubiertoM2;
	}

	public Set getDisponibilidads() {
		return this.disponibilidads;
	}

	public void setDisponibilidads(Set disponibilidads) {
		this.disponibilidads = disponibilidads;
	}

	public Set getPropiedadesXPropietarios() {
		return this.propiedadesXPropietarios;
	}

	public void setPropiedadesXPropietarios(Set propiedadesXPropietarios) {
		this.propiedadesXPropietarios = propiedadesXPropietarios;
	}

	public Set getContratoses() {
		return this.contratoses;
	}

	public void setContratoses(Set contratoses) {
		this.contratoses = contratoses;
	}

}