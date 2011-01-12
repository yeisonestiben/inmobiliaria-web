package inmo.ajax.gwt.client.db;

import java.io.Serializable;

public class PersonaBean extends EnteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String idPersona;
	private TipoDocumentoBean tipoDocumento;
	private String apellido;
	private String nombres;
	private String numeroDocumento;
	private String sexo;
	private DireccionBean[] direcciones;
	private ContactoBean[] contactos;
	
	public PersonaBean()
	{
//		this.tipoPersona = TipoPersona.PERSONA;
	}

	public PersonaBean(String idPersona, TipoDocumentoBean tipoDocumento,
			String apellido, String nombres, String numeroDocumento,
			String sexo, DireccionBean[] direcciones, ContactoBean[] contactos) 
	{
		super();
//		this.tipoPersona = TipoPersona.PERSONA;
		this.idPersona = idPersona;
		this.tipoDocumento = tipoDocumento;
		this.apellido = apellido;
		this.nombres = nombres;
		this.numeroDocumento = numeroDocumento;
		this.sexo = sexo;
		this.direcciones = direcciones;
		this.contactos = contactos;
	}

	public String getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}

	public TipoDocumentoBean getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumentoBean tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public DireccionBean[] getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(DireccionBean[] direcciones) {
		this.direcciones = direcciones;
	}

	public ContactoBean[] getContactos() {
		return contactos;
	}

	public void setContactos(ContactoBean[] contactos) {
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
}
