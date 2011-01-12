package inmo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class RegistrarQuejaAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                            HttpServletRequest request, HttpServletResponse response) 
                            throws Exception
    {
//        RegistrarQuejaBean registrarQuejaBean =(RegistrarQuejaBean) form;
//        
//        Persona persona;
//        String[] idPersona = (String[]) request.getSession().getAttribute("persona");
//        if (Integer.parseInt(idPersona[1]) == 0)
//        {
//        	persona = new ClienteDAO().findById(Integer.parseInt(idPersona[0])).getPersona();
//        }
//        else
//        {
//        	persona = new PropietarioDAO().findById(Integer.parseInt(idPersona[0])).getPersona();
//        }    
//        //Al Empleado lo tomará de la sesión
//        Empleado empleado = new EmpleadoDAO().findById(1);
//        
//        Motivo motivo = new MotivoDAO().findById(Integer.parseInt(registrarQuejaBean.getMotivo()));
//        Contratos contrato = new ContratosDAO().findById(1);
//        String descripcion = registrarQuejaBean.getDescripcionReclamo();
//        String comentarios = registrarQuejaBean.getComentarios();
//        
//        QuejasDAO quejasDAO = new QuejasDAO();
//        Quejas quejas = new Quejas(null, empleado, persona, motivo, contrato, descripcion, comentarios);
//        
//        //Lo guardo en la DB
//        quejasDAO.save(quejas);
        return mapping.findForward("success");
    }
}
