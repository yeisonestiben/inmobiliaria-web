package inmo.db;

@SuppressWarnings("serial")
public class Contacto implements java.io.Serializable {

	// Fields

	private Integer idContacto;
	private TipoContacto tipoContacto;
	private Persona persona;
	private Organizacion organizacion;
	private String nombre;

	// Constructors

	/** default constructor */
	public Contacto() {
	}

	/** minimal constructor */
	public Contacto(Integer idContacto) {
		this.idContacto = idContacto;
	}

	/** full constructor */
	public Contacto(Integer idContacto, TipoContacto tipoContacto,
			Persona persona, Organizacion organizacion, String nombre) {
		this.idContacto = idContacto;
		this.tipoContacto = tipoContacto;
		this.persona = persona;
		this.nombre = nombre;
		this.organizacion = organizacion;
	}

	// Property accessors

	public Organizacion getOrganizacion()
	{
		return organizacion;
	}

	public void setOrganizacion(Organizacion organizacion)
	{
		this.organizacion = organizacion;
	}

	public Integer getIdContacto() {
		return this.idContacto;
	}

	public void setIdContacto(Integer idContacto) {
		this.idContacto = idContacto;
	}

	public TipoContacto getTipoContacto() {
		return this.tipoContacto;
	}

	public void setTipoContacto(TipoContacto tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}