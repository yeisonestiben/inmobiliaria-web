package inmo.ajax.gwt.server.gestores;

import inmo.ajax.gwt.client.db.DisponibilidadBean;
import inmo.ajax.gwt.client.utils.Bool;
import inmo.db.Disponibilidad;
import inmo.db.DisponibilidadDAO;
import inmo.db.Moneda;
import inmo.db.MonedaDAO;
import inmo.db.Propiedades;
import inmo.db.PropiedadesDAO;
import inmo.db.TipoDisponibilidad;
import inmo.db.TipoDisponibilidadDAO;

import java.util.Date;

public class GestorDisponibilidad
{
	public Bool saveDisponibilidad (DisponibilidadBean disponibilidadBean)
	{
		Bool resultado = new Bool(true);
		
		Moneda moneda = new MonedaDAO().findById(Integer.parseInt(disponibilidadBean.getMoneda().getIdMoneda()));
		Float monto = Float.parseFloat(disponibilidadBean.getMonto());
		Date fechaDesde = new Date();
		
		Propiedades propiedad = new PropiedadesDAO().findById(Integer.parseInt(disponibilidadBean.getPropiedades().getIdPropiedades()));
	
		TipoDisponibilidad tipoDisponibilidad = new TipoDisponibilidadDAO().findById(Integer.parseInt(disponibilidadBean.getTipoDisponibilidad().getIdTipoDisponibilidad()));
		Disponibilidad disponibilidad = new Disponibilidad (moneda, propiedad, tipoDisponibilidad, fechaDesde, null, monto);
		DisponibilidadDAO disponibilidadDAO = new DisponibilidadDAO();
		disponibilidadDAO.save(disponibilidad);
		
		return resultado;
	}
}
