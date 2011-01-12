package inmo.ajax.gwt.client.abstracts;

public abstract class Pagina
{
	protected abstract void completarPanelSubmit();
	
	protected abstract void completarPanelErrores();
	
	protected abstract boolean validarCampos();
}
