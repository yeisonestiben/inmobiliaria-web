package inmo.db;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class TipoEvento implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idTipoEvento;
	private String nombre;
	private String descripcion;
	private Set eventoses = new HashSet(0);

	// Constructors

	/** default constructor */
	public TipoEvento() {
	}

	/** minimal constructor */
	public TipoEvento(Integer idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
	}

	/** full constructor */
	public TipoEvento(Integer idTipoEvento, String nombre, String descripcion,
			Set eventoses) {
		this.idTipoEvento = idTipoEvento;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.eventoses = eventoses;
	}

	// Property accessors

	public Integer getIdTipoEvento() {
		return this.idTipoEvento;
	}

	public void setIdTipoEvento(Integer idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
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

	public Set getEventoses() {
		return this.eventoses;
	}

	public void setEventoses(Set eventoses) {
		this.eventoses = eventoses;
	}

}