package inmo.db;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class TipoContrato implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idTipoContrato;
	private String nombre;
	private String descripcion;
	private Set contratoses = new HashSet(0);

	// Constructors

	/** default constructor */
	public TipoContrato() {
	}

	/** minimal constructor */
	public TipoContrato(Integer idTipoContrato) {
		this.idTipoContrato = idTipoContrato;
	}

	/** full constructor */
	public TipoContrato(Integer idTipoContrato, String nombre,
			String descripcion, Set contratoses) {
		this.idTipoContrato = idTipoContrato;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.contratoses = contratoses;
	}

	// Property accessors

	public Integer getIdTipoContrato() {
		return this.idTipoContrato;
	}

	public void setIdTipoContrato(Integer idTipoContrato) {
		this.idTipoContrato = idTipoContrato;
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

	public Set getContratoses() {
		return this.contratoses;
	}

	public void setContratoses(Set contratoses) {
		this.contratoses = contratoses;
	}

}