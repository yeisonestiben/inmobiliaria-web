package inmo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public final class LogoffAction extends Action {

	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	throws IOException, ServletException 
	{

		// Extract attributes we will need
		HttpSession session = request.getSession();

		session.removeAttribute("user");
		// session.invalidate(); Will break JSP that try to check session to see if logged in.

		// Forward control to the specified success URI
		return (mapping.findForward("success"));
	}
}
