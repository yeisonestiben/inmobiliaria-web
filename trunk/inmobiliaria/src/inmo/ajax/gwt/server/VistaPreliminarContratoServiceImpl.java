package inmo.ajax.gwt.server;

import inmo.ajax.gwt.client.VistaPreliminarContratoService;

import javax.servlet.http.HttpSession;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class VistaPreliminarContratoServiceImpl extends RemoteServiceServlet
implements VistaPreliminarContratoService
{
	private static final long serialVersionUID = 1L;

	public void method()
	{
	}

	public String getContrato()
	{
		HttpSession session = this.getThreadLocalRequest().getSession();
		String html = (String) session.getAttribute("contratoLocacion");
		System.out.println("HTML: " + html);
		return html;
	}
}
