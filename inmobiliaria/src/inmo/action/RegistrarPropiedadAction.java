package inmo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class RegistrarPropiedadAction extends Action {
	
	@SuppressWarnings("deprecation")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) 
	throws Exception {
//		
//		RegistrarPropiedadBean propiedadBean = (RegistrarPropiedadBean) form;
//		
//		String calle = propiedadBean.getCalle();
//		int numero = Integer.parseInt (propiedadBean.getNumero());
//		Integer piso;
//		try
//		{
//			piso = Integer.parseInt (propiedadBean.getPiso());
//		}
//		catch (Exception e)
//		{
//			piso = null;
//		}
//		
//		String departamento = propiedadBean.getDepartamento();
//		String cpp = propiedadBean.getCpp();
//		Barrios barrio = new BarriosDAO().findById(Integer.parseInt((String)request.getSession().getAttribute("idBarrio")));
//		Direccion direccion = new Direccion (null, barrio, calle, numero, piso, departamento, cpp);
//		
//		TipoPropiedad tipoPropiedad = new TipoPropiedadDAO().findById(Integer.parseInt(propiedadBean.getTipoPropiedad()));
//		EstadoPropiedad estadoPropiedad = new EstadoPropiedadDAO().findById(Integer.parseInt(propiedadBean.getEstadoPropiedad()));
//		
//		Date fechaConstruccion = new Date();
//		fechaConstruccion.setDate(Integer.parseInt(propiedadBean.getFecha().substring(0, 2)));
//		fechaConstruccion.setMonth(Integer.parseInt(propiedadBean.getFecha().substring(3, 5))-1);
//		fechaConstruccion.setYear(Integer.parseInt(propiedadBean.getFecha().substring(6))-1900);
//		
//		int ambientes = Integer.parseInt(propiedadBean.getAmbientes());
//		int dormitorios = Integer.parseInt(propiedadBean.getDormitorios());
//		int banios = Integer.parseInt(propiedadBean.getBanios());
//		int parcelaM2 = Integer.parseInt(propiedadBean.getParcelaM2());
//		int patioM2 = Integer.parseInt(propiedadBean.getPatioM2());
//		int cubiertoM2 = Integer.parseInt(propiedadBean.getCubiertoM2());
//		
//		
//		DireccionDAO direccionDAO = new DireccionDAO();
//		direccionDAO.save(direccion);
//		
//		Propiedades propiedad = new Propiedades(tipoPropiedad, direccion, estadoPropiedad, fechaConstruccion, ambientes, dormitorios, banios, patioM2, parcelaM2, cubiertoM2, null, null, null);
//		PropiedadesDAO propiedadesDAO = new PropiedadesDAO();
//		propiedadesDAO.save(propiedad);
//		
//		Propietario propietario = new PropietarioDAO().findById(Integer.parseInt(propiedadBean.getIdPropietario()));
//		
//		Date fechaDesde = new Date();
//		
//		PropiedadesXPropietarioId propiedadesXPropietarioId = new PropiedadesXPropietarioId(propiedad.getIdPropiedades(), Integer.parseInt(propiedadBean.getIdPropietario()), fechaDesde);
//		PropiedadesXPropietario propiedadesXPropietario  = new PropiedadesXPropietario (propiedadesXPropietarioId, propiedad, propietario, null);
//		PropiedadesXPropietarioDAO propiedadesXPropietarioDAO = new PropiedadesXPropietarioDAO();
//		propiedadesXPropietarioDAO.save(propiedadesXPropietario); 
//		
//		Moneda moneda = new MonedaDAO().findById(Integer.parseInt(propiedadBean.getMoneda()));
//	
//		TipoDisponibilidad tipoDisponibilidad = new TipoDisponibilidadDAO().findById(Integer.parseInt(propiedadBean.getTipoDisponibilidad()));
//		Disponibilidad disponibilidad = new Disponibilidad (moneda, propiedad, tipoDisponibilidad, fechaDesde, null, Float.valueOf(propiedadBean.getMonto()));
//		DisponibilidadDAO disponibilidadDAO = new DisponibilidadDAO();
//		disponibilidadDAO.save(disponibilidad);
//		
		return mapping.findForward ("success");
	}
}