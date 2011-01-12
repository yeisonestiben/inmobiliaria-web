package inmo.db;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class TipoDocumento implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idTipoDocumento;
	private String tipo;
	private String descripcion;
	private Set personas = new HashSet(0);

	// Constructors

	/** default constructor */
	public TipoDocumento() {
	}

	/** minimal constructor */
	public TipoDocumento(Integer idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	/** full constructor */
	public TipoDocumento(Integer idTipoDocumento, String tipo,
			String descripcion, Set personas) {
		this.idTipoDocumento = idTipoDocumento;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.personas = personas;
	}

	// Property accessors

	public Integer getIdTipoDocumento() {
		return this.idTipoDocumento;
	}

	public void setIdTipoDocumento(Integer idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set getPersonas() {
		return this.personas;
	}

	public void setPersonas(Set personas) {
		this.personas = personas;
	}

}