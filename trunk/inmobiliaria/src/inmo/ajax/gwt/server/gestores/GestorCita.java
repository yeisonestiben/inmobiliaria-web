package inmo.ajax.gwt.server.gestores;

import inmo.ajax.gwt.client.db.CitaBean;
import inmo.ajax.gwt.client.utils.Bool;
import inmo.ajax.gwt.client.utils.Utilidades;
import inmo.db.Barrios;
import inmo.db.BarriosDAO;
import inmo.db.Citas;
import inmo.db.CitasDAO;
import inmo.db.Direccion;
import inmo.db.DireccionDAO;
import inmo.db.MotivoCita;
import inmo.db.MotivoCitaDAO;

import java.util.Date;

public class GestorCita
{
	public Bool saveCita(CitaBean citaBean)
	{
		Bool lReturn  = new Bool(true);	
		
		Barrios barrio = new BarriosDAO().findById(Integer.parseInt(
				citaBean.getDireccion().getBarrios().getIdBarrio()));
		String calle = citaBean.getDireccion().getCalle();
		
		String pisoStr = citaBean.getDireccion().getPiso();
		Integer numero = Integer.parseInt(citaBean.getDireccion().getNumero());
		Integer piso = !pisoStr.equals("") ? Integer.parseInt(pisoStr) : 0;
		String departamento = citaBean.getDireccion().getDepartamento();
		String cpp = citaBean.getDireccion().getCpp();
		
		Direccion direccion = new Direccion (null, barrio, calle, numero, piso, 
				departamento, cpp);
		
		Date fecha = Utilidades.getDate(citaBean.getFecha());
		Date hora = Utilidades.getHora(citaBean.getHora());
		
		MotivoCita motivo = new MotivoCitaDAO().findById(Integer.valueOf(
				citaBean.getMotivoCita().getIdMotivoCita()));
		
		Citas cita = new Citas(motivo, direccion, fecha, hora);
		
		new DireccionDAO().save(direccion);
		new CitasDAO().save(cita);
		
		return lReturn;
	}
}
