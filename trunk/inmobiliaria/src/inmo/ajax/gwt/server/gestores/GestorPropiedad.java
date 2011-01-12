package inmo.ajax.gwt.server.gestores;

import inmo.ajax.gwt.client.db.DireccionBean;
import inmo.ajax.gwt.client.db.DisponibilidadBean;
import inmo.ajax.gwt.client.db.EstadoPropiedadBean;
import inmo.ajax.gwt.client.db.PropiedadBean;
import inmo.ajax.gwt.client.db.PropietarioBean;
import inmo.ajax.gwt.client.db.TipoDisponibilidadBean;
import inmo.ajax.gwt.client.db.TipoPropiedadBean;
import inmo.ajax.gwt.client.utils.Bool;
import inmo.ajax.gwt.client.utils.Utilidades;
import inmo.db.Barrios;
import inmo.db.BarriosDAO;
import inmo.db.Direccion;
import inmo.db.DireccionDAO;
import inmo.db.Disponibilidad;
import inmo.db.DisponibilidadDAO;
import inmo.db.EstadoPropiedad;
import inmo.db.EstadoPropiedadDAO;
import inmo.db.Moneda;
import inmo.db.MonedaDAO;
import inmo.db.Propiedades;
import inmo.db.PropiedadesDAO;
import inmo.db.PropiedadesXPropietario;
import inmo.db.PropiedadesXPropietarioDAO;
import inmo.db.PropiedadesXPropietarioId;
import inmo.db.Propietario;
import inmo.db.PropietarioDAO;
import inmo.db.TipoDisponibilidad;
import inmo.db.TipoDisponibilidadDAO;
import inmo.db.TipoPropiedad;
import inmo.db.TipoPropiedadDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.BaseTreeModel;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

public class GestorPropiedad
{
	public Bool savePropiedad (PropiedadBean propiedadBean)
	{
		return savePropiedad(propiedadBean, null);
	}

	public Bool savePropiedad (PropiedadBean propiedadBean, DisponibilidadBean 
			disponibilidadBean)
	{
		Bool resultado = new Bool(true);
		String calle = propiedadBean.getDireccion().getCalle();
		int numero = 
			propiedadBean.getDireccion().getNumero().trim().equals("") ? 0 : 
				Integer.parseInt (propiedadBean.getDireccion().getNumero());
		int piso = 
			propiedadBean.getDireccion().getPiso().trim().equals("") ? 0 : 
				Integer.parseInt (propiedadBean.getDireccion().getPiso());
		String departamento = propiedadBean.getDireccion().getDepartamento();
		String cpp = propiedadBean.getDireccion().getCpp();
		Barrios barrio = 
			new BarriosDAO().findById(Integer.parseInt(
					propiedadBean.getDireccion().getBarrios().getIdBarrio()));
		Direccion direccion = 
			new Direccion (null, barrio, calle, numero, piso, departamento, cpp);

		TipoPropiedad tipoPropiedad = 
			new TipoPropiedadDAO().findById(Integer.parseInt(propiedadBean.
					getTipoPropiedad().getIdTipoPropiedad()));
		EstadoPropiedad estadoPropiedad = 
			new EstadoPropiedadDAO().findById(Integer.parseInt(propiedadBean.
					getEstadoPropiedad().getIdEstadoPropiedad()));

		Date fechaConstruccion = 
			Utilidades.getDate(propiedadBean.getFechaConstruccion());

		int ambientes = Integer.parseInt(propiedadBean.getAmbientes());
		int dormitorios = Integer.parseInt(propiedadBean.getDormitorios());
		int banios = Integer.parseInt(propiedadBean.getBanios());
		int parcelaM2 = Integer.parseInt(propiedadBean.getParcelaM2());
		int patioM2 = propiedadBean.getPatioM2().equals("") ? 0 : 
			Integer.parseInt(propiedadBean.getPatioM2());
		int cubiertoM2 = Integer.parseInt(propiedadBean.getCubiertoM2());

		DireccionDAO direccionDAO = new DireccionDAO();
		direccionDAO.save(direccion);

		Propiedades propiedad = new Propiedades(tipoPropiedad, direccion, 
				estadoPropiedad, fechaConstruccion, ambientes, dormitorios, 
				banios, patioM2, parcelaM2, cubiertoM2, null, null, null);
		PropiedadesDAO propiedadesDAO = new PropiedadesDAO();
		propiedadesDAO.save(propiedad);

		Propietario propietario = 
			new PropietarioDAO().findById(Integer.parseInt(propiedadBean.
					getPropietario().getIdPropietario()));

		Date fechaDesde = new Date();

		PropiedadesXPropietarioId propiedadesXPropietarioId = 
			new PropiedadesXPropietarioId(propiedad.getIdPropiedades(), 
					Integer.parseInt(propiedadBean.getPropietario().
							getIdPropietario()), fechaDesde);
		PropiedadesXPropietario propiedadesXPropietario  = 
			new PropiedadesXPropietario (propiedadesXPropietarioId, propiedad, 
					propietario, null);
		PropiedadesXPropietarioDAO propiedadesXPropietarioDAO = 
			new PropiedadesXPropietarioDAO();
		propiedadesXPropietarioDAO.save(propiedadesXPropietario);

		if (disponibilidadBean != null)
		{
			Moneda moneda = 
				new MonedaDAO().findById(Integer.parseInt(disponibilidadBean.
						getMoneda().getIdMoneda()));
			Float monto = Float.parseFloat(disponibilidadBean.getMonto());

			TipoDisponibilidad tipoDisponibilidad = 
				new TipoDisponibilidadDAO().findById(Integer.parseInt(
						disponibilidadBean.getTipoDisponibilidad().
						getIdTipoDisponibilidad()));
			Disponibilidad disponibilidad = new Disponibilidad (moneda, 
					propiedad, tipoDisponibilidad, fechaDesde, null, monto);
			DisponibilidadDAO disponibilidadDAO = new DisponibilidadDAO();
			disponibilidadDAO.save(disponibilidad);
		}

		return resultado;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public BasePagingLoadResult<BaseTreeModel> getPagedPropiedades(
			PagingLoadConfig loadConfig, PropiedadBean propiedadBean, 
			DisponibilidadBean disponibilidadBean, String montoDesde, 
			String montoHasta, String antiguedad)
	{		
		//Creo los objetos para realizar la busqueda
		TipoDisponibilidad tipoDisponibilidad = 
			new TipoDisponibilidadDAO().findById(
					Integer.parseInt(disponibilidadBean.getTipoDisponibilidad().
							getIdTipoDisponibilidad()));
		Moneda moneda = 
			new MonedaDAO().findById(Integer.parseInt(disponibilidadBean.
					getMoneda().getIdMoneda()));
		float mDesde = 0;
		if (montoDesde.compareTo("")!= 0)
		{
			mDesde = Float.valueOf(montoDesde);
		}
		float mHasta = 0;
		if (montoHasta.compareTo("")!= 0)
		{
			mHasta = Float.valueOf(montoHasta);

		}
		int antigued = 0;
		if (antiguedad.compareTo("")!= 0)
		{
			antigued = Integer.parseInt(antiguedad);
		}
		TipoPropiedad tipoPropiedad = null;
		if (Integer.parseInt(propiedadBean.getTipoPropiedad().
				getIdTipoPropiedad()) != 0)
		{
			tipoPropiedad = 
				new TipoPropiedadDAO().findById(Integer.parseInt(propiedadBean.
						getTipoPropiedad().getIdTipoPropiedad()));
		}

		int parcela = 0;
		if (propiedadBean.getParcelaM2().compareTo("")!=0)
		{
			parcela = Integer.parseInt(propiedadBean.getParcelaM2());
		}
		int cubierto = 0;
		if (propiedadBean.getCubiertoM2().compareTo("")!=0)
		{
			cubierto = Integer.parseInt(propiedadBean.getCubiertoM2());
		}
		int patio = 0;
		if (propiedadBean.getPatioM2().compareTo("")!=0)
		{
			patio = Integer.parseInt(propiedadBean.getPatioM2());
		}
		int dormitorios = Integer.parseInt(propiedadBean.getDormitorios());
		int ambientes = Integer.parseInt(propiedadBean.getAmbientes());
		Barrios barrio = null;
		if (propiedadBean.getDireccion().getBarrios().getIdBarrio().
				compareTo("")!=0)
		{
			barrio = new BarriosDAO().findById(Integer.parseInt(propiedadBean.getDireccion().getBarrios().getIdBarrio()));
		}
		//Aquí termino de crear los datos necesarios para la busqueda

		DisponibilidadDAO disponibilidadDAO = new DisponibilidadDAO();
		List<Disponibilidad> arrayDisponibilidadesTodas = disponibilidadDAO.findByProperty("tipoDisponibilidad", tipoDisponibilidad);
		Iterator<Disponibilidad> iteratorDisponibilidad = arrayDisponibilidadesTodas.iterator();
		List<BaseTreeModel> propiedadesModel = new ArrayList<BaseTreeModel>();

		Disponibilidad disponibilidad;

		while (iteratorDisponibilidad.hasNext())
		{	
			boolean cambiar = true;
			boolean agregar = true;	
			disponibilidad = (Disponibilidad) iteratorDisponibilidad.next();
			if (disponibilidad.getFechaHasta()== null)
			{
				if (mDesde != 0 && cambiar == true)
				{
					float montoDisponibilidad = disponibilidad.getMonto();
					float monto = mDesde;
					if (moneda != disponibilidad.getMoneda())
					{
						monto = monto*moneda.getCambio();
						montoDisponibilidad = disponibilidad.getMoneda().getCambio()*disponibilidad.getMonto();
					}
					if (montoDisponibilidad >= monto)
					{
						agregar = true;
					}
					else
					{
						agregar = false;
						cambiar = false;
					}

				}
				if (mHasta != 0 && cambiar == true)
				{
					float montoDisponibilidad = disponibilidad.getMonto();
					float monto = mHasta;
					if (moneda != disponibilidad.getMoneda())
					{
						monto = monto*moneda.getCambio();
						montoDisponibilidad = disponibilidad.getMoneda().getCambio()*disponibilidad.getMonto();
					}
					if (montoDisponibilidad <= monto)
					{
						agregar = true;
					}
					else
					{
						agregar = false;
						cambiar = false;
					}
				}
				if (barrio != null && cambiar == true)
				{
					if (disponibilidad.getPropiedades().getDireccion().getBarrios() == barrio)
					{
						agregar = true;
					}
					else
					{
						agregar = false;
						cambiar = false;
					}
				}
				if (antigued != 0 && cambiar == true)
				{
					Date fechaComparar = new Date();
					int anio = fechaComparar.getYear()-antigued+1;
					fechaComparar.setYear(anio);
					if (disponibilidad.getPropiedades().getFechaConstruccion().compareTo(fechaComparar) <= 0)
					{
						agregar = true;
					}
					else
					{
						agregar = false;
						cambiar = false;
					}
				}
				if (parcela != 0 && cambiar == true)
				{
					if (disponibilidad.getPropiedades().getParcelaM2() > parcela)
					{
						agregar = true;
					}
					else
					{
						agregar = false;
						cambiar = false;
					}
				}
				if (patio != 0 && cambiar == true)
				{
					if (disponibilidad.getPropiedades().getPatioM2() > patio)
					{
						agregar = true;
					}
					else
					{
						agregar = false;
						cambiar = false;
					}
				}
				if (cubierto != 0 && cambiar == true)
				{
					if (disponibilidad.getPropiedades().getCubiertoM2() > cubierto)
					{
						agregar = true;
					}
					else
					{
						agregar = false;
						cambiar = false;
					}
				}
				if (dormitorios != 0 && cambiar == true)
				{
					if (disponibilidad.getPropiedades().getDormitorios() == dormitorios)
					{
						agregar = true;
					}
					else
					{
						agregar = false;
						cambiar = false;
					}
				}
				if (ambientes != 0 && cambiar == true)
				{
					if (disponibilidad.getPropiedades().getAmbientes() == ambientes)
					{
						agregar = true;
					}
					else
					{
						agregar = false;
						cambiar = false;
					}
				}
				if (tipoPropiedad != null && cambiar == true)
				{
					if (disponibilidad.getPropiedades().getTipoPropiedad() == tipoPropiedad)
					{
						agregar = true;
					}
					else
					{
						agregar = false;
						cambiar = false;
					}
				}
				if (agregar == true)
				{
					BaseTreeModel propiedadModel = new BaseTreeModel();

					propiedadModel.set("idPropiedad", disponibilidad.getPropiedades().getIdPropiedades().toString());
					propiedadModel.set("tipoPropiedad", disponibilidad.getPropiedades().getTipoPropiedad().getNombre());
					propiedadModel.set("calle", disponibilidad.getPropiedades().getDireccion().getCalle());
					propiedadModel.set("numero", disponibilidad.getPropiedades().getDireccion().getNro().toString());
					propiedadModel.set("barrio", disponibilidad.getPropiedades().getDireccion().getBarrios().getNombre());
					propiedadModel.set("moneda", disponibilidad.getMoneda().getNombre());
					propiedadModel.set("monto", disponibilidad.getMonto().toString());

					propiedadesModel.add(propiedadModel);
				}
			}	
		}
		return new BasePagingLoadResult<BaseTreeModel>(propiedadesModel, loadConfig.getOffset(), propiedadesModel.size());
	}

	@SuppressWarnings("unchecked")
	public PagingLoadResult<BaseTreeModel> getPagedPropiedades(
			PagingLoadConfig loadConfig, String idPropietario, String idBarrio,
			String calle, String numero, String idTipoPropiedad,
			TipoDisponibilidadBean tipoDisponibilidad)
	{
		List<BaseTreeModel> propiedadesModel = new ArrayList<BaseTreeModel>();
		if (tipoDisponibilidad != null)
		{
			TipoDisponibilidad tipoDisp = 
				new TipoDisponibilidadDAO().findById(Integer.
						valueOf(tipoDisponibilidad.getIdTipoDisponibilidad()));

			DisponibilidadDAO disponibilidadDAO = new DisponibilidadDAO();

			List<Disponibilidad> arrayDisponibilidadesTodas = 
				disponibilidadDAO.findByProperty("tipoDisponibilidad", tipoDisp);

			for (Disponibilidad disponibilidad : arrayDisponibilidadesTodas)
			{
				if (disponibilidad.getFechaHasta()== null)
				{
					boolean cambiar = true;
					boolean agregar = true;	
					if (!idBarrio.equals("") && cambiar == true)
					{
						if (disponibilidad.getPropiedades().getDireccion().
								getBarrios().getIdBarrios().toString().
								equals(idBarrio))
						{
							agregar = true;
						}
						else
						{
							agregar = false;
							cambiar = false;
						}
					}

					if (!idTipoPropiedad.equals("") && cambiar == true)
					{
						if (disponibilidad.getPropiedades().getTipoPropiedad().
								getIdTipoPropiedad().toString().
								equals(idTipoPropiedad))
						{
							agregar = true;
						}
						else
						{
							agregar = false;
							cambiar = false;
						}
					}
					if (!calle.equals("") && cambiar == true)
					{
						if (disponibilidad.getPropiedades().getDireccion().
								getCalle().toUpperCase().
								contains(calle.toUpperCase()))
						{
							agregar = true;
						}
						else
						{
							agregar = false;
							cambiar = false;
						}
					}
					if (!numero.equals("") && cambiar == true)
					{
						if (disponibilidad.getPropiedades().getDireccion().
								getNro().toString().equals(numero))
						{
							agregar = true;
						}
						else
						{
							agregar = false;
							cambiar = false;
						}
					}
					if (!idPropietario.equals("") && cambiar == true)
					{
						agregar = false;
						Set<PropiedadesXPropietario> pxps = 
							disponibilidad.getPropiedades().
							getPropiedadesXPropietarios();
						for (PropiedadesXPropietario pxp : pxps )
						{
							if (pxp.getId().getIdPropietario().toString().
									equals(idPropietario))
							{
								agregar = true;
							}
						}
						if (!agregar)
						{
							cambiar = false;
						}
					}

					if (agregar == true)
					{
						BaseTreeModel propiedadModel = new BaseTreeModel();

						propiedadModel.set("idPropiedad", 
								disponibilidad.getPropiedades().
								getIdPropiedades().toString());
						propiedadModel.set("tipoPropiedad",
								disponibilidad.getPropiedades().
								getTipoPropiedad().getNombre());
						propiedadModel.set("calle", 
								disponibilidad.getPropiedades().getDireccion().
								getCalle());
						propiedadModel.set("numero", 
								disponibilidad.getPropiedades().getDireccion().
								getNro().toString());
						propiedadModel.set("barrio", 
								disponibilidad.getPropiedades().getDireccion().
								getBarrios().getNombre());
						propiedadModel.set("localidad", 
								disponibilidad.getPropiedades().getDireccion().
								getBarrios().getLocalidades().getNombre());
						propiedadModel.set("provincia", 
								disponibilidad.getPropiedades().getDireccion().
								getBarrios().getLocalidades().getProvincias().
								getNombre());
						propiedadModel.set("propiedad",
								getPropiedad(disponibilidad.getPropiedades()));
						propiedadesModel.add(propiedadModel);
					}
				}
			}			
		}
		else
		{
			PropiedadesDAO propiedadesDAO = new PropiedadesDAO();
			List<Propiedades> propiedades = propiedadesDAO.findAll();
			for (Propiedades propiedad : propiedades)
			{
				boolean cambiar = true;
				boolean agregar = true;	
				if (!idBarrio.equals("") && cambiar == true)
				{
					if (propiedad.getDireccion().getBarrios().getIdBarrios().
							toString().equals(idBarrio))
					{
						agregar = true;
					}
					else
					{
						agregar = false;
						cambiar = false;
					}
				}

				if (!idTipoPropiedad.equals("") && cambiar == true)
				{
					if (propiedad.getTipoPropiedad().getIdTipoPropiedad().
							toString().equals(idTipoPropiedad))
					{
						agregar = true;
					}
					else
					{
						agregar = false;
						cambiar = false;
					}
				}
				if (!calle.equals("") && cambiar == true)
				{
					if (propiedad.getDireccion().getCalle().toUpperCase().
							contains(calle.toUpperCase()))
					{
						agregar = true;
					}
					else
					{
						agregar = false;
						cambiar = false;
					}
				}
				if (!numero.equals("") && cambiar == true)
				{
					if (propiedad.getDireccion().getNro().toString().
							equals(numero))
					{
						agregar = true;
					}
					else
					{
						agregar = false;
						cambiar = false;
					}
				}
				if (!idPropietario.equals("") && cambiar == true)
				{
					agregar = false;
					Set<PropiedadesXPropietario> pxps = 
						propiedad.getPropiedadesXPropietarios();
					for (PropiedadesXPropietario pxp : pxps )
					{
						if (pxp.getId().getIdPropietario().toString().
								equals(idPropietario))
						{
							agregar = true;
						}
					}
					if (!agregar)
					{
						cambiar = false;
					}
				}

				if (agregar == true)
				{
					BaseTreeModel propiedadModel = new BaseTreeModel();

					propiedadModel.set("idPropiedad", 
							propiedad.getIdPropiedades().
							toString());
					propiedadModel.set("tipoPropiedad",
							propiedad.getTipoPropiedad().
							getNombre());
					propiedadModel.set("calle", 
							propiedad.getDireccion().
							getCalle());
					propiedadModel.set("numero", 
							propiedad.getDireccion().
							getNro().toString());
					propiedadModel.set("barrio", 
							propiedad.getDireccion().
							getBarrios().getNombre());
					propiedadModel.set("localidad", 
							propiedad.getDireccion().
							getBarrios().getLocalidades().getNombre());
					propiedadModel.set("provincia", 
							propiedad.getDireccion().
							getBarrios().getLocalidades().getProvincias().
							getNombre());
					propiedadModel.set("propiedad", getPropiedad(propiedad));
					propiedadesModel.add(propiedadModel);
				}
			}
		}
		return new BasePagingLoadResult<BaseTreeModel>(propiedadesModel, 
				loadConfig.getOffset(), propiedadesModel.size());
	}

	public PropiedadBean getPropiedad(String idPropiedad)
	{
		Propiedades propiedad = 
			new PropiedadesDAO().findById(Integer.valueOf(idPropiedad));
		
		return getPropiedad(propiedad);
	}
	
	@SuppressWarnings("unchecked")
	public PropiedadBean getPropiedad(Propiedades propiedad)
	{
		String idPropiedad = propiedad.getIdPropiedades().toString();
		TipoPropiedadBean tipoPropiedad = 
			new GestorTipoPropiedad().
			getTipoPropiedad(propiedad.getTipoPropiedad());
		DireccionBean direccion = 
			new GestorDireccion().getDireccion(propiedad.getDireccion());
		EstadoPropiedadBean estadoPropiedad = 
			new GestorEstadoPropiedad().
			getEstadoPropiedad(propiedad.getEstadoPropiedad());
		String fechaConstruccion = 
			Utilidades.getDate(propiedad.getFechaConstruccion());
		String ambientes = String.valueOf(propiedad.getAmbientes());
		String dormitorios = String.valueOf(propiedad.getDormitorios());
		String banios = String.valueOf(propiedad.getBanios());
		String patioM2  = String.valueOf(propiedad.getPatioM2());
		String parcelaM2 = String.valueOf(propiedad.getParcelaM2());
		String cubiertoM2 = String.valueOf(propiedad.getCubiertoM2());
		String idPropietario = propiedad.getIdPropiedades().toString();
		Set<PropiedadesXPropietario> pxps = 
			propiedad.getPropiedadesXPropietarios();
		for (PropiedadesXPropietario pxp :pxps) {
			if (pxp.getFechaHasta() == null)
			{
				idPropietario = pxp.getId().getIdPropietario().toString();
			}
		}
		PropietarioBean propietario = 
			new GestorPropietario().getPropietario(idPropietario);
		
		PropiedadBean propiedadBean = new PropiedadBean(idPropiedad, 
				tipoPropiedad, direccion, estadoPropiedad, fechaConstruccion, 
				ambientes, dormitorios, banios, patioM2, parcelaM2, cubiertoM2, 
				propietario);
		
		return propiedadBean;
	}
}