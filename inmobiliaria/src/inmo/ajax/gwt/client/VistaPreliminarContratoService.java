package inmo.ajax.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("VistaPreliminarContrato")
public interface VistaPreliminarContratoService extends RemoteService
{

	String getContrato();

}
