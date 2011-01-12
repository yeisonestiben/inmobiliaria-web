package inmo.pagebeans;

import java.util.ArrayList;

import inmo.Utilidades;
import inmo.db.TipoEvento;
import inmo.db.TipoEventoDAO;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class RegistrarEventoBean extends ActionForm
{

    private static final long serialVersionUID = 1L;
    private String tipoEvento;
    private String fecha;
    private String hora;
    private String minutos;
    private String calle;
    private String numero;
    private String piso;
    private String departamento;
    private String idBarrio;
    private String barrio;
    private String cpp;
    private String descripcion;
    private String nombreBarrio;

    public String getNombreBarrio() {
		return nombreBarrio;
	}

	public void setNombreBarrio(String nombreBarrio) {
		this.nombreBarrio = nombreBarrio;
	}

	public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getBarrio()
    {
        return barrio;
    }

    public void setBarrio(String barrio)
    {
        this.barrio = barrio;
    }

    public String getCalle()
    {
        return calle;
    }

    public void setCalle(String calle)
    {
        this.calle = calle;
    }

    public String getCpp()
    {
        return cpp;
    }

    public void setCpp(String cpp)
    {
        this.cpp = cpp;
    }

    public String getDepartamento()
    {
        return departamento;
    }

    public void setDepartamento(String departamento)
    {
        this.departamento = departamento;
    }

    public String getFecha()
    {
        return fecha;
    }

    public void setFecha(String fecha)
    {
        this.fecha = fecha;
    }

    public String getHora()
    {
        return hora;
    }

    public void setHora(String hora)
    {
        this.hora = hora;
    }

    public String getIdBarrio()
    {
        return idBarrio;
    }

    public void setIdBarrio(String idBarrio)
    {
        this.idBarrio = idBarrio;
    }

    public String getMinutos()
    {
        return minutos;
    }

    public void setMinutos(String minutos)
    {
        this.minutos = minutos;
    }

    public String getNumero()
    {
        return numero;
    }

    public void setNumero(String numero)
    {
        this.numero = numero;
    }

    public String getPiso()
    {
        return piso;
    }

    public void setPiso(String piso)
    {
        this.piso = piso;
    }

    public String getTipoEvento()
    {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento)
    {
        this.tipoEvento = tipoEvento;
    }

    @SuppressWarnings("unchecked")
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
    {

        ActionErrors errors = new ActionErrors();

        if (Utilidades.isMissing(getFecha()))
        {
            errors.add("fecha", new ActionMessage("errors.required", "Fecha"));
        }

        if (Utilidades.isMissing(getHora()))
        {
            errors.add("hora", new ActionMessage("errors.required", "Hora"));
        }
        else
        {
            if (!Utilidades.isInt(getHora()))
            {
                errors.add("hora", new ActionMessage("errors.integer", "Hora"));
            }
            else
            {
                int hora = Integer.parseInt(getHora());
                if (hora >= 24 || hora < 0)
                {
                    errors.add("hora", new ActionMessage("errors.hora"));
                }
            }
        }

        if (Utilidades.isMissing(getMinutos()))
        {
            errors.add("minutos", new ActionMessage("errors.required", "Minutos"));
        }
        else
        {
            if (!Utilidades.isInt(getMinutos()))
            {
                errors.add("minutos", new ActionMessage("errors.integer", "Minutos"));
            }
            else
            {
                int mins = Integer.parseInt(getMinutos());
                if (mins >= 60 || mins < 0)
                {
                    errors.add("minutos", new ActionMessage("errors.minutos"));
                }
            }
        }

        if (Utilidades.isMissing(getCalle()))
        {
            errors.add("calle", new ActionMessage("errors.required", "Calle"));
        }

        if (Utilidades.isMissing(getNumero()))
        {
            errors.add("numero", new ActionMessage("errors.required", "Numero de Dirección"));
        }

        if (Utilidades.isMissing(getNumero()))
        {
            errors.add("numero", new ActionMessage("errors.required", "Numero de Dirección"));
        }

        if (Utilidades.isMissing(getIdBarrio()))
        {
            errors.add("idBarrio", new ActionMessage("errors.required", "Barrio"));
        }
        
        TipoEventoDAO tipoEvento = new TipoEventoDAO();
		ArrayList<TipoEvento> arrayTipoEvento;
		arrayTipoEvento = (ArrayList<TipoEvento>) tipoEvento.findAll();
		request.setAttribute("arrayTipoEvento",arrayTipoEvento);

        return errors;
    }
}
