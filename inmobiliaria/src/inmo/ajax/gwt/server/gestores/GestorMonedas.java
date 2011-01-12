package inmo.ajax.gwt.server.gestores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import inmo.ajax.gwt.client.db.MonedaBean;
import inmo.db.Moneda;
import inmo.db.MonedaDAO;

public class GestorMonedas
{
	public MonedaBean[] getMonedasBean()
	{
		@SuppressWarnings("unchecked")
		List<Moneda> listMonedas = new MonedaDAO().findAll();
		Collections.sort(listMonedas);
		List<MonedaBean> listMonedaBean = new ArrayList<MonedaBean>();
		
		for (Moneda moneda : listMonedas)
		{
			float cambio = (moneda.getCambio() == null) ? 0 : moneda.getCambio();
			MonedaBean monedaBean = new MonedaBean(moneda.getIdMoneda().toString(), 
					moneda.getNombre(), moneda.getDescripcion(), 
					String.valueOf(cambio));
			listMonedaBean.add(monedaBean);
		}
		return listMonedaBean.toArray(new MonedaBean[listMonedaBean.size()]);
	}
}