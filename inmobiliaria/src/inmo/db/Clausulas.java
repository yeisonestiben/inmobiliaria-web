package inmo.db;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class Clausulas implements java.io.Serializable, Comparable<Clausulas> {

	private static final long serialVersionUID = 1L;
	private Integer idClausulas;
	private String nombre;
	private String descripcion;
	private Integer numero;
	private Set clausulasXContratos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Clausulas() {
	}

	/** full constructor */
	public Clausulas(String nombre, String descripcion, Integer numero, 
			Set clausulasXContratos) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.clausulasXContratos = clausulasXContratos;
	}

	// Property accessors

	public Integer getIdClausulas() {
		return this.idClausulas;
	}

	public void setIdClausulas(Integer idClausulas) {
		this.idClausulas = idClausulas;
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

	public Integer getNumero()
	{
		return numero;
	}

	public void setNumero(Integer numero)
	{
		this.numero = numero;
	}

	public Set getClausulasXContratos() {
		return this.clausulasXContratos;
	}

	public void setClausulasXContratos(Set clausulasXContratos) {
		this.clausulasXContratos = clausulasXContratos;
	}

	public int compareTo(Clausulas o)
	{
		return idClausulas.compareTo(o.getIdClausulas());
	}
}