package inmo.ajax.gwt.server.gestores;

import inmo.ajax.gwt.client.db.EmpleadoBean;
import inmo.ajax.gwt.client.utils.Bool;
import inmo.db.Empleado;
import inmo.db.EmpleadoDAO;
import inmo.db.Persona;
import inmo.db.TipoEmpleado;
import inmo.db.TipoEmpleadoDAO;
import inmo.db.Titulo;
import inmo.db.TituloXEmpleado;
import inmo.db.TituloXEmpleadoDAO;
import inmo.db.TituloXEmpleadoId;

import java.util.Date;

public class GestorEmpleado extends GestorPersona 
{
	public Bool saveEmpleado(EmpleadoBean empleadoBean)
	{
		Bool lReturn  = new Bool(true);	
		
		Persona persona = savePersona(empleadoBean);
		
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();
		TituloXEmpleadoDAO tituloXEmpleadoDAO = new TituloXEmpleadoDAO();
		
		TipoEmpleado tipoEmpleado = new TipoEmpleadoDAO().findById(Integer.parseInt(empleadoBean.getTipoEmpleado().getIdTipoEmpleado()));
		Empleado empleado = new Empleado(null, tipoEmpleado, persona, null, null, null);
		empleadoDAO.save(empleado);
		
		for (int i = 0; i < empleadoBean.getTitulos().length; i++)
		{
			Titulo titulo = new GestorTitulo().getTitulo(empleadoBean.getTitulos()[i]);
			TituloXEmpleadoId tituloXEmpleadoId = new TituloXEmpleadoId (titulo, empleado);
			TituloXEmpleado tituloXEmpleado = new TituloXEmpleado (tituloXEmpleadoId, new Date());	
			tituloXEmpleadoDAO.save(tituloXEmpleado);
		}
		return lReturn;
	}
}
