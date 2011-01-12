package inmo.db;


import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("rawtypes")
public class Persona implements java.io.Serializable, Comparable<Persona> {

	private static final long serialVersionUID = 1L;
	private Integer idPersona;
	private TipoDocumento tipoDocumento;
	private String apellido;
	private String nombres;
	private String numeroDocumento;
	private String sexo;
	
	private Set quejases = new HashSet(0);
	private Set direccionXPersonas = new HashSet(0);
	private Set citases = new HashSet(0);
	private Set contactos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Persona() {
	}

	/** minimal constructor */
	public Persona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	/** full constructor */
	public Persona(Integer idPersona, TipoDocumento tipoDocumento,
			String apellido, String nombres, String numeroDocumento,
			String sexo, Set quejases, Set direccionXPersonas,
			Set citases, Set contactos) {
		this.idPersona = idPersona;
		this.tipoDocumento = tipoDocumento;
		this.apellido = apellido;
		this.nombres = nombres;
		this.numeroDocumento = numeroDocumento;
		this.sexo = sexo;
		this.quejases = quejases;
		this.direccionXPersonas = direccionXPersonas;
		this.citases = citases;
		this.contactos = contactos;
	}

	public Integer getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public TipoDocumento getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Set getQuejases() {
		return this.quejases;
	}

	public void setQuejases(Set quejases) {
		this.quejases = quejases;
	}

	public Set getDireccionXPersonas() {
		return this.direccionXPersonas;
	}

	public void setDireccionXPersonas(Set direccionXPersonas) {
		this.direccionXPersonas = direccionXPersonas;
	}

	public Set getCitases() {
		return this.citases;
	}

	public void setCitases(Set citases) {
		this.citases = citases;
	}

	public Set getContactos() {
		return this.contactos;
	}

	public void setContactos(Set contactos) {
		this.contactos = contactos;
	}

	public String getSexo()
	{
		return sexo;
	}

	public void setSexo(String sexo)
	{
		this.sexo = sexo;
	}

	public int compareTo(Persona o)
	{
		int devolver = this.getApellido().compareTo(o.getApellido());
		if (devolver == 0)
		{
			devolver = this.getNombres().compareTo(o.getNombres());
		}
		return devolver;
	}
}