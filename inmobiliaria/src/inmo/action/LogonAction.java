package inmo.action;

import inmo.pagebeans.LogonBean;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public final class LogonAction extends Action {

	public ActionForward execute(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
	throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		LogonBean logonBean = (LogonBean) session.getAttribute("user");
		if (logonBean == null)
		{
			return (mapping.findForward("loguear"));
		}
		return (mapping.findForward("logueado"));
	}
}
