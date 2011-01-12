package inmo.ajax.gwt.server.gestores;

import inmo.ajax.gwt.client.db.TipoDocumentoBean;
import inmo.db.TipoDocumento;
import inmo.db.TipoDocumentoDAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GestorTipoDocumento {
	
	@SuppressWarnings("unchecked")
	public TipoDocumentoBean[] getTipoDocumentos() 
	{
		TipoDocumentoDAO tipoDocumentoDAO = new TipoDocumentoDAO();
		List<TipoDocumento> arrayTipoDocumentos = tipoDocumentoDAO.findAll();
		//TODO implementar la interface Comparable y el metodo compareTo en 
		//la clase TipoDocumento
		//Collections.sort (arrayTipoDocumentos);
		Iterator<TipoDocumento> iterator = arrayTipoDocumentos.iterator();
		
		List<TipoDocumentoBean> listaTipoDocumentoBeans = new ArrayList<TipoDocumentoBean>();
		
		
		while (iterator.hasNext())
		{
			TipoDocumento tipoDocumento = iterator.next();
			TipoDocumentoBean tipoDocumentoBean = 
				new TipoDocumentoBean(tipoDocumento.getTipo(), tipoDocumento.getIdTipoDocumento().toString());
			listaTipoDocumentoBeans.add(tipoDocumentoBean);
		}
		return listaTipoDocumentoBeans.toArray(new TipoDocumentoBean[arrayTipoDocumentos.size()]);
	}
	
	public TipoDocumento getTipoDocumento(TipoDocumentoBean tipoDocumentoBean)
	{
		int idTipoDocumento = Integer.parseInt(tipoDocumentoBean.getIdTipo());
		TipoDocumento tipoDocumento = new TipoDocumento(idTipoDocumento);
		return tipoDocumento;
	}

	public TipoDocumentoBean getTipoDocumento(TipoDocumento tipoDocumento)
	{
		TipoDocumentoBean tipo =
			new TipoDocumentoBean(tipoDocumento.getTipo(), 
					tipoDocumento.getIdTipoDocumento().toString());
		return tipo;
	}

}
