package inmo.pagebeans;

import java.util.Iterator;

import inmo.db.Empleado;
import inmo.db.EmpleadoDAO;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public final class LogonBean extends ActionForm {

	private static final long serialVersionUID = 1L;


	private String password = null;
	private String username = null;
	private String id = null;

	public String getPassword() {
		return (this.password);
	}
	
	public LogonBean getBean ()
	{
		return this;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return (this.username);
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.password = null;
		this.username = null;
	}

	@SuppressWarnings("unchecked")
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		if ((username == null) || (username.length() < 1))
		{
			errors.add("username", new ActionMessage("errors.required", "Usuario"));
		}
			
		if ((password == null) || (password.length() < 1))
		{
			errors.add("password", new ActionMessage("errors.required", "Contraseña"));
		}
			
		if (errors.isEmpty())
		{
			try
			{
				Empleado empleado = null;
				Iterator<Empleado> iterator = new EmpleadoDAO().findByProperty("usuario", getUsername()).iterator();
				if (iterator.hasNext())
				{
					empleado = (Empleado) iterator.next();
				}
				if (empleado.getClave().compareTo(getPassword()) == 0)
				{
					setId(""+empleado.getIdEmpleado());
					request.getSession().setAttribute("user", getBean());
				}
			}
			catch (Exception e)
			{
				errors.add("password", new ActionMessage("errors.logon"));
			}
		}
		
		return errors;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
