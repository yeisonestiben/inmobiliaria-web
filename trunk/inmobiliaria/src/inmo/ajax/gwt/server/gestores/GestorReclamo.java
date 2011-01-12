package inmo.ajax.gwt.server.gestores;

import inmo.ajax.gwt.client.db.ReclamoBean;
import inmo.ajax.gwt.client.utils.Bool;
import inmo.db.Contratos;
import inmo.db.ContratosDAO;
import inmo.db.Empleado;
import inmo.db.EmpleadoDAO;
import inmo.db.Motivo;
import inmo.db.MotivoDAO;
import inmo.db.Persona;
import inmo.db.PersonaDAO;
import inmo.db.Quejas;
import inmo.db.QuejasDAO;

public class GestorReclamo
{
	public Bool saveReclamo (ReclamoBean reclamoBean)
	{
        Persona persona = new PersonaDAO().findById(Integer.valueOf(reclamoBean.
        		getPersona().getIdPersona()));

        //Al Empleado lo tomará de la sesión
        Empleado empleado = new EmpleadoDAO().findById(1);
        
        Motivo motivo = new MotivoDAO().findById(Integer.parseInt(reclamoBean.
        		getMotivo().getIdMotivo()));
        Contratos contrato = new ContratosDAO().findById(Integer.
        		valueOf(reclamoBean.getContrato().getIdContrato()));
        String descripcion = reclamoBean.getDescripcion();
        String comentarios = reclamoBean.getComentarios();
        
        QuejasDAO quejasDAO = new QuejasDAO();
        Quejas quejas = new Quejas(null, empleado, persona, motivo, contrato,
        		descripcion, comentarios);
        
        //Lo guardo en la DB
        quejasDAO.save(quejas);
		return new Bool(true);
	}
}
