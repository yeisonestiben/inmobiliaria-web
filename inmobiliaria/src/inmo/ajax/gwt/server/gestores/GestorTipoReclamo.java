package inmo.ajax.gwt.server.gestores;

import inmo.ajax.gwt.client.db.TipoReclamoBean;
import inmo.db.Motivo;
import inmo.db.MotivoDAO;

import java.util.ArrayList;
import java.util.List;

public class GestorTipoReclamo
{
	@SuppressWarnings("unchecked")
	public TipoReclamoBean[] getTiposReclamo()
	{
		MotivoDAO motivoDAO = new MotivoDAO();
		List<Motivo> arrayMotivos = (ArrayList<Motivo>) motivoDAO.findAll();
		
		List<TipoReclamoBean> listTipoReclamoBean = new 
		ArrayList<TipoReclamoBean>();
		
		for (Motivo motivo : arrayMotivos)
		{
			TipoReclamoBean tipoReclamoBean = 
				new TipoReclamoBean(motivo.getIdMotivo().toString(), 
						motivo.getNombre(), motivo.getDescripcion(), 
						motivo.getTiempoSoluciuon());
			listTipoReclamoBean.add(tipoReclamoBean);
		}
		return listTipoReclamoBean.toArray(
				new TipoReclamoBean[listTipoReclamoBean.size()]);
	}
}
