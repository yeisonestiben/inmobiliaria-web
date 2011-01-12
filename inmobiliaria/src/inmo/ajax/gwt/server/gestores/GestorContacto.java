package inmo.ajax.gwt.server.gestores;

import inmo.ajax.gwt.client.db.ContactoBean;
import inmo.ajax.gwt.client.db.TipoContactoBean;
import inmo.db.Contacto;
import inmo.db.TipoContacto;
import inmo.db.TipoContactoDAO;

import java.util.Set;

public class GestorContacto {

	public Contacto getContacto (ContactoBean contactoBean)
	{
		TipoContacto tipoContacto =
			new TipoContactoDAO().findById(Integer.parseInt(contactoBean.
					getTipoContacto().getIdTipoContacto()));

		Contacto contacto = new Contacto(null, tipoContacto, null, null, 
				contactoBean.getNombre());
		return contacto;
	}

	@SuppressWarnings("rawtypes")
	public ContactoBean[] getContactos(Set contactos)
	{
		ContactoBean[] contactosBean = new ContactoBean[contactos.size()];
		int i = 0;
		for (Object obj : contactos)
		{
			Contacto contacto = (Contacto) obj;
			TipoContactoBean tipoContactoBean = 
				new GestorTipoContacto().getTipoContacto(contacto.
						getTipoContacto());
			ContactoBean contactoBean = 
				new ContactoBean(contacto.getIdContacto().toString(), 
						tipoContactoBean, contacto.getNombre());
			contactosBean[i] = contactoBean;
			i++;
		}
		return contactosBean;
	}

}
