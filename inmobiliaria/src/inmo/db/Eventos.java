package inmo.db;

import java.util.Date;

public class Eventos implements java.io.Serializable {


	private static final long serialVersionUID = 1L;
	private Integer idEventos;
	private TipoEvento tipoEvento;
	private Direccion direccion;
	private Date fecha;
	private Date hora;
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Eventos() {
	}

	/** minimal constructor */
	public Eventos(Integer idEventos) {
		this.idEventos = idEventos;
	}

	/** full constructor */
	public Eventos(TipoEvento tipoEvento,
			Direccion direccion, Date fecha, Date hora, String descripcion) {
		this.tipoEvento = tipoEvento;
		this.direccion = direccion;
		this.fecha = fecha;
		this.hora = hora;
		this.descripcion = descripcion;
	}

	// Property accessors

	public Integer getIdEventos() {
		return this.idEventos;
	}

	public void setIdEventos(Integer idEventos) {
		this.idEventos = idEventos;
	}

	public TipoEvento getTipoEvento() {
		return this.tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public Direccion getDireccion() {
		return this.direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

}