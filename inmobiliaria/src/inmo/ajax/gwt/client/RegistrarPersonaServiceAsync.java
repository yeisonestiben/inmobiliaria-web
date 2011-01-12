package inmo.ajax.gwt.client;

import inmo.ajax.gwt.client.Interfaces.BuscarBarrioService;
import inmo.ajax.gwt.client.db.ClienteBean;
import inmo.ajax.gwt.client.db.EmpleadoBean;
import inmo.ajax.gwt.client.db.PersonaBean;
import inmo.ajax.gwt.client.db.PropietarioBean;
import inmo.ajax.gwt.client.db.ProvinciaBean;
import inmo.ajax.gwt.client.db.TipoContactoBean;
import inmo.ajax.gwt.client.db.TipoDireccionBean;
import inmo.ajax.gwt.client.db.TipoDocumentoBean;
import inmo.ajax.gwt.client.db.TipoEmpleadoBean;
import inmo.ajax.gwt.client.db.TituloBean;
import inmo.ajax.gwt.client.utils.Bool;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RegistrarPersonaServiceAsync extends BuscarBarrioService 
{
	void getTipoDocumentos(AsyncCallback<TipoDocumentoBean[]> callback);
	
	void getTipoDirecciones(AsyncCallback<TipoDireccionBean[]> callback);

	void getTiposEmpleado(AsyncCallback<TipoEmpleadoBean[]> callback);

	void getTitulos(AsyncCallback<TituloBean[]> callback);

	void getProvincias(AsyncCallback<ProvinciaBean[]> callback);

	void getTipoContactos(AsyncCallback<TipoContactoBean[]> callback);
	
	void savePersona(PersonaBean persona, AsyncCallback<Bool> callback);

	void savePropietario(PropietarioBean propietario, AsyncCallback<Bool> callback);

	void saveEmpleado(EmpleadoBean empleado, AsyncCallback<Bool> callback);

	void saveCliente(ClienteBean cliente, AsyncCallback<Bool> callback);
}
