package inmo.db;

public class Barrios implements java.io.Serializable, Comparable<Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer idBarrios;
	private Localidades localidades;
	private String nombre;

	// Constructors

	/** default constructor */
	public Barrios() {
	}

	/** minimal constructor */
	public Barrios(Integer idBarrios) {
		this.idBarrios = idBarrios;
	}

	/** full constructor */
	public Barrios(Integer idBarrios, Localidades localidades, String nombre) {
		this.idBarrios = idBarrios;
		this.localidades = localidades;
		this.nombre = nombre;
	}

	// Property accessors

	public Integer getIdBarrios() {
		return this.idBarrios;
	}

	public void setIdBarrios(Integer idBarrios) {
		this.idBarrios = idBarrios;
	}

	public Localidades getLocalidades() {
		return this.localidades;
	}

	public void setLocalidades(Localidades localidades) {
		this.localidades = localidades;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int compareTo(Object o) {
		Barrios b = (Barrios) o;
		return this.getNombre().compareTo((b.getNombre()));
	}

}