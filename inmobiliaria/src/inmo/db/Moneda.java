package inmo.db;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class Moneda implements java.io.Serializable, Comparable<Moneda> {

	private static final long serialVersionUID = 1L;
	private Integer idMoneda;
	private String nombre;
	private String descripcion;
	private Float cambio;
	private Set egresos = new HashSet(0);
	private Set ingresos = new HashSet(0);
	private Set disponibilidads = new HashSet(0);

	// Constructors

	/** default constructor */
	public Moneda() {
	}

	/** minimal constructor */
	public Moneda(Integer idMoneda) {
		this.idMoneda = idMoneda;
	}

	/** full constructor */
	public Moneda(Integer idMoneda, String nombre, String descripcion, Float cambio,
			Set egresos, Set ingresos, Set disponibilidads) {
		this.idMoneda = idMoneda;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.egresos = egresos;
		this.ingresos = ingresos;
		this.disponibilidads = disponibilidads;
		this.cambio = cambio;
	}

	// Property accessors

	public Integer getIdMoneda() {
		return this.idMoneda;
	}

	public void setIdMoneda(Integer idMoneda) {
		this.idMoneda = idMoneda;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set getEgresos() {
		return this.egresos;
	}

	public void setEgresos(Set egresos) {
		this.egresos = egresos;
	}

	public Set getIngresos() {
		return this.ingresos;
	}

	public void setIngresos(Set ingresos) {
		this.ingresos = ingresos;
	}

	public Set getDisponibilidads() {
		return this.disponibilidads;
	}

	public void setDisponibilidads(Set disponibilidads) {
		this.disponibilidads = disponibilidads;
	}

	public Float getCambio() {
		return cambio;
	}

	public void setCambio(Float cambio) {
		this.cambio = cambio;
	}

	public int compareTo(Moneda o)
	{
		return this.nombre.compareTo(o.getNombre());
	}

}