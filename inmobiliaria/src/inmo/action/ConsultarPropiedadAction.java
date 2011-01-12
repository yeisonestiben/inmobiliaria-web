package inmo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ConsultarPropiedadAction extends Action {
	@SuppressWarnings({ "deprecation", "unchecked" })
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) 
	throws Exception {
//		
//		ConsultarPropiedadBean propiedadBean = (ConsultarPropiedadBean) form;
//		
//		//Creo los objetos para realizar la b�squeda
//		TipoDisponibilidad tipoDisponibilidad = new TipoDisponibilidadDAO().findById(Integer.parseInt(propiedadBean.getTipoDisponibilidad()));
//		Moneda moneda = new MonedaDAO().findById(Integer.parseInt(propiedadBean.getMoneda()));
//		float montoDesde = 0;
//		if (propiedadBean.getMontoDesde().compareTo("")!= 0)
//		{
//			montoDesde = Float.valueOf(propiedadBean.getMontoDesde());
//		}
//		float montoHasta = 0;
//		if (propiedadBean.getMontoHasta().compareTo("")!= 0)
//		{
//			montoHasta = Float.valueOf(propiedadBean.getMontoHasta());
//
//		}
//		int antiguedad = 0;
//		if (propiedadBean.getAntiguedad().compareTo("")!= 0)
//		{
//			antiguedad = Integer.parseInt(propiedadBean.getAntiguedad());
//		}
//		TipoPropiedad tipoPropiedad = null;
//		if (Integer.parseInt(propiedadBean.getTipoPropiedad()) != 0)
//		{
//			tipoPropiedad = new TipoPropiedadDAO().findById(Integer.parseInt(propiedadBean.getTipoPropiedad()));
//		}
//		
//		int parcela = 0;
//		if (propiedadBean.getParcela().compareTo("")!=0)
//		{
//			parcela = Integer.parseInt(propiedadBean.getParcela());
//		}
//		int cubierto = 0;
//		if (propiedadBean.getCubierto().compareTo("")!=0)
//		{
//			cubierto = Integer.parseInt(propiedadBean.getCubierto());
//		}
//		int patio = 0;
//		if (propiedadBean.getPatio().compareTo("")!=0)
//		{
//			patio = Integer.parseInt(propiedadBean.getPatio());
//		}
//		int dormitorios = Integer.parseInt(propiedadBean.getDormitorios());
//		int ambientes = Integer.parseInt(propiedadBean.getAmbientes());
//		Barrios barrio = null;
//		if (propiedadBean.getIdBarrio().compareTo("")!=0)
//		{
//			barrio = new BarriosDAO().findById(Integer.parseInt(propiedadBean.getIdBarrio()));
//		}
//		//Aqu� termino de crear los datos necesarios para la busqueda
//		
//		DisponibilidadDAO disponibilidadDAO = new DisponibilidadDAO();
//		ArrayList<Disponibilidad> arrayDisponibilidadesTodas = (ArrayList<Disponibilidad>)  disponibilidadDAO.findByProperty("tipoDisponibilidad", tipoDisponibilidad);
//		Iterator<Disponibilidad> iteratorDisponibilidad = arrayDisponibilidadesTodas.iterator();
//		ArrayList<Disponibilidad> arrayDisponibilidades;
//		arrayDisponibilidades = new ArrayList<Disponibilidad>();
//		
//		Disponibilidad disponibilidad;
//		
//		while (iteratorDisponibilidad.hasNext())
//		{	
//			boolean cambiar = true;
//			boolean agregar = true;	
//			disponibilidad = (Disponibilidad) iteratorDisponibilidad.next();
//			if (disponibilidad.getFechaHasta()== null)
//			{
//				if (montoDesde != 0 && cambiar == true)
//				{
//					float montoDisponibilidad = disponibilidad.getMonto();
//					float monto = montoDesde;
//					if (moneda != disponibilidad.getMoneda())
//					{
//						monto = monto*moneda.getCambio();
//						montoDisponibilidad = disponibilidad.getMoneda().getCambio()*disponibilidad.getMonto();
//					}
//					if (montoDisponibilidad >= monto)
//					{
//						agregar = true;
//					}
//					else
//					{
//						agregar = false;
//						cambiar = false;
//					}
//					
//				}
//				if (montoHasta != 0 && cambiar == true)
//				{
//					float montoDisponibilidad = disponibilidad.getMonto();
//					float monto = montoHasta;
//					if (moneda != disponibilidad.getMoneda())
//					{
//						monto = monto*moneda.getCambio();
//						montoDisponibilidad = disponibilidad.getMoneda().getCambio()*disponibilidad.getMonto();
//					}
//					if (montoDisponibilidad <= monto)
//					{
//						agregar = true;
//					}
//					else
//					{
//						agregar = false;
//						cambiar = false;
//					}
//				}
//				if (barrio != null && cambiar == true)
//				{
//					if (disponibilidad.getPropiedades().getDireccion().getBarrios() == barrio)
//					{
//						agregar = true;
//					}
//					else
//					{
//						agregar = false;
//						cambiar = false;
//					}
//				}
//				if (antiguedad != 0 && cambiar == true)
//				{
//					Date fechaComparar = new Date();
//					int anio = fechaComparar.getYear()-antiguedad+1;
//					fechaComparar.setYear(anio);
//					if (disponibilidad.getPropiedades().getFechaConstruccion().compareTo(fechaComparar) <= 0)
//					{
//						agregar = true;
//					}
//					else
//					{
//						agregar = false;
//						cambiar = false;
//					}
//				}
//				if (parcela != 0 && cambiar == true)
//				{
//					if (disponibilidad.getPropiedades().getParcelaM2() > parcela)
//					{
//						agregar = true;
//					}
//					else
//					{
//						agregar = false;
//						cambiar = false;
//					}
//				}
//				if (patio != 0 && cambiar == true)
//				{
//					if (disponibilidad.getPropiedades().getPatioM2() > patio)
//					{
//						agregar = true;
//					}
//					else
//					{
//						agregar = false;
//						cambiar = false;
//					}
//				}
//				if (cubierto != 0 && cambiar == true)
//				{
//					if (disponibilidad.getPropiedades().getCubiertoM2() > cubierto)
//					{
//						agregar = true;
//					}
//					else
//					{
//						agregar = false;
//						cambiar = false;
//					}
//				}
//				if (dormitorios != 0 && cambiar == true)
//				{
//					if (disponibilidad.getPropiedades().getDormitorios() == dormitorios)
//					{
//						agregar = true;
//					}
//					else
//					{
//						agregar = false;
//						cambiar = false;
//					}
//				}
//				if (ambientes != 0 && cambiar == true)
//				{
//					if (disponibilidad.getPropiedades().getAmbientes() == ambientes)
//					{
//						agregar = true;
//					}
//					else
//					{
//						agregar = false;
//						cambiar = false;
//					}
//				}
//				if (tipoPropiedad != null && cambiar == true)
//				{
//					if (disponibilidad.getPropiedades().getTipoPropiedad() == tipoPropiedad)
//					{
//						agregar = true;
//					}
//					else
//					{
//						agregar = false;
//						cambiar = false;
//					}
//				}
//				if (agregar == true)
//				{
//					arrayDisponibilidades.add(disponibilidad);
//				}
//			}	
//		}
//		request.setAttribute("arrayDisponibilidades",arrayDisponibilidades);
//		
		return mapping.findForward("success");
	}
}