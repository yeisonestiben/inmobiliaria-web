package inmo.db;

import java.util.Set;

@SuppressWarnings("rawtypes")
public class Motivo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	// Fields

	private Integer idMotivo;
	private String nombre;
	private String descripcion;
	private String tiempoSoluciuon;



	/** default constructor */
	public Motivo() {
	}

	/** minimal constructor */
	public Motivo(Integer idMotivo) {
		this.idMotivo = idMotivo;
	}

	/** full constructor */
	public Motivo(Integer idMotivo, String nombre, String descripcion,
			String tiempoSoluciuon, Set quejases) {
		this.idMotivo = idMotivo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tiempoSoluciuon = tiempoSoluciuon;
	}

	// Property accessors

	public Integer getIdMotivo() {
		return this.idMotivo;
	}

	public void setIdMotivo(Integer idMotivo) {
		this.idMotivo = idMotivo;
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

	public String getTiempoSoluciuon() {
		return this.tiempoSoluciuon;
	}

	public void setTiempoSoluciuon(String tiempoSoluciuon) {
		this.tiempoSoluciuon = tiempoSoluciuon;
	}



}